package com.chen.serviceImp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.chen.dao.BaseDao;
import com.chen.daoImp.BaseDaoImp;
import com.chen.entity.Book;
import com.chen.entity.Customer;
import com.chen.entity.Order;
import com.chen.service.BookService;
import com.chen.service.CustomerService;

public class CustomerServiceImp implements CustomerService{
	BaseDao dao = new BaseDaoImp();
	
	public void saveCustomer(Customer customer) {
		dao.saveObject(customer);
		
	}

	public void updateCustomer(Customer customer) {
		dao.updateObject(customer);
		
	}

	public void deleteCustomer(Customer customer) {
		dao.deleteObject(customer);
		
	}

	public Customer findOneCustomer(String HQL) {
		return (Customer)dao.findObject(HQL);
		
	}

	public List findWithPage(int startRow, int pageSize, String HQL) {
		List list = new ArrayList();
		
		list=dao.findWithPage(startRow,pageSize,HQL);
		return list;
	}
	
	public int getRow() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public static void main(String[] arg)
	{
		Customer cus = new Customer();
		CustomerServiceImp c = new CustomerServiceImp();
		List<Customer> list = new ArrayList();
		//查找一个客户
		//测试成功
//		String HQL = "from Customer where id=1";
//		cus = c.findOneCustomer(HQL);
//		System.out.print(cus.getCusName());
		
		//添加一个客户
		//测试成功
//		cus.setCusName("LiMing");
//		cus.setCusPassWord("LiMing");
//		cus.setCusAddress("XIAN");
//		c.saveCustomer(cus);
		
		//删除一个客户
		//测试成功
//		cus.setId(2);
//		c.deleteCustomer(cus);
		
		//修改一个顾客
//		cus.setId(3);
//		cus.setCusName("Pan");
//		cus.setCusPassWord("Pan");
//		cus.setCusAddress("XIAN");
//		c.updateCustomer(cus);
		
		//查找一个链表的顾客
		//测试成功
//		list = c.findWithPage(0, 2, "from Customer");
//		for(int i = 0; i < list.size(); i ++)
//		{
//			Customer customer = new Customer();
//			customer = list.get(i);
//			System.out.println(customer.getCusName());
//		}
		
		
		//添加一个客户和一个订单
		//测试成功,可以达到一个效果那就是多个订单属于一个顾客
//		Order order = new Order();
//		order.setOrderID(101);
//		order.setOrderTime("20021212");
//		order.setTotalPrice(56);
//		Set<Order> set = new HashSet<Order>();
//		set.add(order);
//		cus.setOrders(set);
//		cus.setCusName("LiMing");
//		cus.setCusPassWord("LiMing");
//		cus.setCusAddress("XIAN");
//		c.saveCustomer(cus);
	}


	public void updateWithQuery(String HQL) {
		dao.updateWithQuery(HQL);
		
	}

}
