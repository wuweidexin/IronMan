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

public class OrderAction {
	
	CustomerService cus = new CustomerServiceImp();
	Order order = new Order();
	OrderService os = new OrderServiceImp();
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String orderLogin()
	{
		//这个方法是登录进购物车的方法
		//页面跳转通过带参跳转
		Customer customer = (Customer)ServletActionContext.getRequest().getSession().getAttribute("customer");
		
		Set<Order> setOrder = customer.getOrders();
		//ServletActionContext.getRequest().setAttribute("customer", customer);
		List<Order> list = new ArrayList<Order>();
		if(setOrder != null)
		{
			List<Order> order = new ArrayList<Order>();
		 	Iterator ita = setOrder.iterator();
			while(ita.hasNext())
			{
				Order od = (Order)ita.next();
				list.add(od);
			}
			
			ServletActionContext.getRequest().getSession().setAttribute("list", list);
		}
		else
		{
			ServletActionContext.getRequest().setAttribute("list", null);
		}
		
		return "orderLogin";
	

	}
	
	public String addOrder()
	{
		Customer customer = (Customer)ServletActionContext.getRequest().getSession().getAttribute("customer");
		Order order=(Order)ServletActionContext.getRequest().getSession().getAttribute("newOrder");
		String recieverName = ServletActionContext.getRequest().getParameter("recieverName");
		String recieverAddress = ServletActionContext.getRequest().getParameter("recieverAddress");
		String recieverOphone = ServletActionContext.getRequest().getParameter("recieverOphone");
		String moneySendMethod = ServletActionContext.getRequest().getParameter("moneySendMethod");
		String deliveryMethod = ServletActionContext.getRequest().getParameter("deliveryMethod");
		
		System.out.println("*************");
		System.out.println(order.getOrderTime());
		System.out.println(recieverAddress);
		System.out.println(recieverOphone);
		
		order.setRecieverOphone(recieverOphone);
		order.setRecieverAddress(recieverAddress);
		order.setRecieverName(recieverName);
		order.setDeliveryMethod(deliveryMethod);
		order.setMoneySendMethod(moneySendMethod);
		os.updateOrder(order);
		System.out.println("*************");
		Double totalPrice = customer.getShoppingCart().getTotalPrice();
		customer.getShoppingCart().setBook(null);
		customer.getOrders().add(order);
		cus.updateCustomer(customer);
		ServletActionContext.getRequest().getSession().setAttribute("list", null);
		
		return "addOrder";
	}
	
//	public void add()
//	{
//		Order order = os.findOneOrder("from Order where id=1");
//		Customer  customer = order.getCustomer();
//		
//		order.setRecieverName("AAA");
//		order.setRecieverAddress("ABC");
//		order.setRecieverOphone("2123");
//		order.setMoneySendMethod("EMS");
//		order.setDeliveryMethod("EWW");
//		os.updateOrder(order);
//		System.out.println(order.getRecieverAddress());
//	}
	
//	public static void main(String[] args) {
//		OrderAction oa = new OrderAction();
//		oa.add();
//	}
	
	//后台处理
	
	public String loadOrderSet()
	{
		int action = Integer.parseInt(ServletActionContext.getRequest().getParameter("action"));
		if(action == 0)
		{//出货是
			return updateState();
		}else if(action == 1)
		{//出货否
			return null;
		}else if(action == 2)
		{//详细信息
			return selectContent();
		}else if(action == 3)
		{//删除
			return deleteOrder();
		}else if(action == 4)
		{//载入界面
			return "loadOrderSet";
		}
		else
		{
			return null;
		}
		
	}
	
	public String selectContent() {
		
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
	
		Order order = os.findOneOrder("from Order where id="+ id);
		
		
		
		Set<Book> bookSet = new HashSet<Book>();
		bookSet = order.getBook();
		List<Book> list = new ArrayList<Book>();
		
		
		Iterator ita = bookSet.iterator();
		
		while(ita.hasNext())
		{
			Book b = (Book)ita.next();
			list.add(b);
		}
		System.out.println("*************");
		System.out.println(list.get(0).getBookName());
		Customer cus = order.getCustomer();
	
		ServletActionContext.getRequest().setAttribute("customer", cus);
		ServletActionContext.getRequest().setAttribute("detailOrder", order);
		ServletActionContext.getRequest().setAttribute("listDetail", list);
		return "selectContent";
	}

	public String deleteOrder()
	{
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		Order order = os.findOneOrder("from Order where id=" + id);
		os.deleteOrder(order);
		return "loadOrderSet";
	}
	
	public String updateState()
	{
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		Order order = os.findOneOrder("from Order where id=" + id);
		order.setOrderState(1);
		os.updateOrder(order);
		return "loadOrderSet";
	}
	
	public static void main(String[] args) {
		OrderAction o = new OrderAction();
		o.selectContent();
	}
}
