package com.chen.ation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.chen.entity.Book;
import com.chen.entity.Customer;
import com.chen.entity.Order;
import com.chen.service.CustomerService;
import com.chen.service.OrderService;
import com.chen.serviceImp.CustomerServiceImp;
import com.chen.serviceImp.OrderServiceImp;

public class CartActioon {
	java.util.Date date=new java.util.Date();
	OrderService os = new OrderServiceImp();
	CustomerService cus = new CustomerServiceImp();
	public String cartLogin()
	{
		//这个方法是登录进购物车的方法
		//页面跳转通过带参跳转
		double sum = 0;
		Set<Book> set = new HashSet<Book>();
		List<Book> li = new ArrayList<Book>();
		
		Customer customer = (Customer)ServletActionContext.getRequest().getSession().getAttribute("customer");

		
		if(customer.getShoppingCart().getBook() != null)
		{
			set = customer.getShoppingCart().getBook();
			Iterator ita = set.iterator();
			
			while(ita.hasNext())
			{
				Book b = (Book)ita.next();
				li.add(b);
				sum = sum + b.getPrice();
			}
		}

		ServletActionContext.getRequest().setAttribute("sum", sum);
		ServletActionContext.getRequest().setAttribute("li", li);
		return "cartLogin";


	}
	public String backIndex()
	{
		Customer customer = (Customer)ServletActionContext.getRequest().getSession().getAttribute("customer");
		ServletActionContext.getRequest().setAttribute("customer", customer);
		return "backIndex";
	}

	public String checkOut()
	{
		Customer customer = (Customer)ServletActionContext.getRequest().getSession().getAttribute("customer");


		Order o = new Order();
		o.setOrderID(""+(date.getYear()+1900) + (date.getMonth()+1) + date.getDate() + date.getHours() + date.getMinutes() + date.getSeconds());
		o.setOrderTime(""+(date.getYear()+1900) + (date.getMonth()+1) + date.getDate());
		o.setOrderState(0);
		o.setCustomer(customer);
		o.setBook(customer.getShoppingCart().getBook());
		os.saveOrder(o);
		o = os.findOneOrder("from Order where orderID ='"+ o.getOrderID()+"'" );
		ServletActionContext.getRequest().getSession().setAttribute("newOrder", o);
		System.out.println("*****************");
		System.out.println(o.getOrderID());
		return "checkOut";
	}

	public String clearShoppingCart()
	{


		Customer customer = (Customer)ServletActionContext.getRequest().getSession().getAttribute("customer");
		customer.getShoppingCart().getBook().clear();
		ServletActionContext.getRequest().getSession().removeAttribute("sum");
		cus.updateCustomer(customer);
		return "clearShoppingCart";
	}


}
