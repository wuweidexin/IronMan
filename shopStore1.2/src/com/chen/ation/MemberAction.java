package com.chen.ation;

import org.apache.struts2.ServletActionContext;

import com.chen.entity.Customer;
import com.chen.entity.ShoppingCart;
import com.chen.service.CustomerService;
import com.chen.service.ShoppingCartService;
import com.chen.serviceImp.CustomerServiceImp;
import com.chen.serviceImp.ShoppingCartServiceImp;

public class MemberAction {
	java.util.Date date=new java.util.Date();
	CustomerService cus = new CustomerServiceImp();
	ShoppingCartService scs = new ShoppingCartServiceImp();
	Customer customer = new Customer();
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String login()
	{
		BookAction bookAction = new BookAction();
		String cusName = ServletActionContext.getRequest().getParameter("cusName").trim();
		String cusPassWord = ServletActionContext.getRequest().getParameter("cusPassword").trim();
		String HQL="from Customer as a where a.cusName='" +cusName+"'";
		customer = cus.findOneCustomer(HQL);
		if(customer == null)
		{
			return "nullMember";
		}
		else if(cusPassWord.equals(customer.getCusPassword()))
		{

			ServletActionContext.getRequest().getSession().setAttribute("customer", customer);
			return "loginSuccess";
		}
		else
		{
			
			return "loginUnSuccess";
		}
		
	}
	
	public String findPassword()
	{
		int action =  Integer.parseInt(ServletActionContext.getRequest().getParameter("action").trim());
		if(action == 0)
		{
			return "toFindPassword";
		}
		else if(action == 1)
		{
			String name = ServletActionContext.getRequest().getParameter("name");
			Customer getPassCus = cus.findOneCustomer("from Customer where cusName='"+ name +"'");
			if(getPassCus== null)
			{
				return "nullMember";
			}
			else
			{
				ServletActionContext.getRequest().getSession().setAttribute("getPassCus", getPassCus);
				return "findTwo";
			}
		}else if(action == 2)
		{
			String result = ServletActionContext.getRequest().getParameter("result");
			Customer gpcus = (Customer)ServletActionContext.getRequest().getSession().getAttribute("getPassCus");
			if(result.endsWith(gpcus.getAnswer()))
			{
				ServletActionContext.getRequest().getSession().setAttribute("gpcus", gpcus);
				return "findFour";
			}else
			{
				return "error";
			}
		}else{
			return null;
		}
		
		
	}
	
	
	
	public String checkCustomer()
	{
		return null;
	}
	public String memberRegister()
	{
		//注册成功
		ShoppingCart s = new ShoppingCart();
		customer.setCusID("CX" + (date.getYear()+1900) + (date.getMonth()+1) + date.getDate() + date.getHours() + date.getMinutes() + date.getSeconds());
		s.setShoppingCartID("SX" + "CX" + (date.getYear()+1900) + (date.getMonth()+1) + date.getDate() + date.getHours() + date.getMinutes() + date.getSeconds());
		customer.setShoppingCart(s);
		cus.saveCustomer(customer);
		ServletActionContext.getRequest().getSession().removeAttribute("customer");
		ServletActionContext.getRequest().getSession().setAttribute("customer", null);
		return "memberRegister";
	}
	public String goRegister()
	{
		
		Customer customer = (Customer)ServletActionContext.getRequest().getSession().getAttribute("customer");
		
		return "goRegister";
	}
	
	public String goUpdateCustomer()
	{
		
		Customer customer = (Customer)ServletActionContext.getRequest().getSession().getAttribute("customer");
		ServletActionContext.getRequest().setAttribute("customer", customer);
		return "goUpdateCustomer";
	}
	public String updateCustomer()
	{
		Customer customer = (Customer)ServletActionContext.getRequest().getSession().getAttribute("customer");
		
		String  cusName = ServletActionContext.getRequest().getParameter("name");
		String  cusPassword= ServletActionContext.getRequest().getParameter("password");
		String  cusTelephone= ServletActionContext.getRequest().getParameter("cusTelephone");
		String  cusAddress= ServletActionContext.getRequest().getParameter("cusAddress");
		String  cusMail= ServletActionContext.getRequest().getParameter("cusPostCode");
		String  cusPostCode= ServletActionContext.getRequest().getParameter("cusMail");
		
		customer.setCusPassword(cusPassword);
		customer.setCusTelephone(cusTelephone);
		customer.setCusAddress(cusAddress);
		customer.setCusMail(cusMail);
		customer.setCusPostCode(cusPostCode);
		cus.updateCustomer(customer);
		return "updateCustomer";
	}
	
	
	
	//下面是后台处理的方法
	
	public String loadMemberSet()
	{
		//载入后台处理
		int action = Integer.parseInt(ServletActionContext.getRequest().getParameter("action")) ;
		if(action == 0)
		{
			return "loadMemberSet";
		}
		else if(action == 1)
		{
			int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
			Customer customer = cus.findOneCustomer("from Customer where id=" + id);
			ServletActionContext.getRequest().setAttribute("customer", customer);
			return "detailMember";
		}else 
		{
			return deleteMember();
		}
	}
	public String deleteMember() {
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		Customer customer = cus.findOneCustomer("from Customer where id=" + id);
		cus.deleteCustomer(customer);
		return "loadMemberSet";
	}
	

}
