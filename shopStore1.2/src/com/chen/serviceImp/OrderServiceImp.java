package com.chen.serviceImp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.chen.dao.BaseDao;
import com.chen.daoImp.BaseDaoImp;
import com.chen.entity.Book;
import com.chen.entity.Order;
import com.chen.service.OrderService;

public class OrderServiceImp implements OrderService{
	BaseDao dao = new BaseDaoImp();
	public void saveOrder(Order order) {
		dao.saveObject(order);
	}
	
	
	public void deleteOrder(Order order)
	{
		
		dao.deleteObject(order);
	}
	public void updateOrder(Order order) {
	
		dao.updateObject(order);
	}

	public Order findOneOrder(String HQL) {
		
		return (Order)dao.findObject(HQL);
	}

	public List findList(String HQL) {
		List list = new ArrayList();
		list=dao.findList(HQL);
		return list;
	}
	


	public List findWithPage(int startRow, int pageSize, String HQL) {
		
		return null;
	}

	public int getRow() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void updateWithQuery(String HQL) {
		dao.updateWithQuery(HQL);
		
	} 
	
	
	//下面是测试代码，测试代码要把所有的操作都能成功
//	public static void main(String[] args)
//	{
//		BaseDao basedao = new BaseDaoImp();
//		OrderServiceImp o = new OrderServiceImp();
//		Order order = new Order();
//		String HQL = "from Order where id=1";
//		
//		//添加一个订单,同时往这个订单中添加一本书
//		
//		Book book = (Book)basedao.findObject("from Book where id = 1" );
//		Set<Book> setBook = new HashSet<Book>();
//		setBook.add(book);
//		order.setBook(setBook);
//		order.setRecieverAddress("西安");
//		order.setRecieverOphone("132456");
//		order.setTotalPrice(45);
//		order.setCarriagePaid(12);
//		order.setOrderState(0);
//		order.setOrderTime("20000101");
//		
//		o.saveOrder(order);
//		System.out.print(order.getTotalPrice());
//	}
//	
}
