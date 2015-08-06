package com.chen.serviceImp;

import java.util.ArrayList;
import java.util.List;

import com.chen.dao.BaseDao;
import com.chen.daoImp.BaseDaoImp;
import com.chen.entity.Book;
import com.chen.entity.ShoppingCart;
import com.chen.service.ShoppingCartService;

public class ShoppingCartServiceImp implements ShoppingCartService{
	BaseDao baseDao = new BaseDaoImp();
	
	public void deleteAllRecord() {
		// TODO Auto-generated method stub
		
	}

	public void deleteOneRecord(int id) {
		baseDao.deleteObject(findOneRecord("from ShoppingCart where id=" + id));
		
	}

	public List findList(String HQL) {
		List<ShoppingCart> list = new ArrayList<ShoppingCart>();
		list = baseDao.findList(HQL);
		return list;
	}

	public ShoppingCart findOneRecord(String HQL) {
		System.out.println("*****");
//		if(baseDao.findObject(HQL) == null)
//		{
//			System.out.println("对象为空");
//		}
//		else
//		{
//			System.out.println("对象不为空");
//		}
		return (ShoppingCart)baseDao.findObject(HQL);
	}

	public List findWithPage(int startRow, int pageSize, String HQL) {
		List<ShoppingCart> list = new ArrayList<ShoppingCart>();
		list = baseDao.findWithPage(0, 5, HQL);
		return list;
	}

	public int getRow() {
		String HQL = null;
		return Integer.parseInt((String)baseDao.findObject(HQL));
	}

	public void saveOneRecord(ShoppingCart shoppingCar) {
		baseDao.saveObject(shoppingCar);
		
	}

	public void updateOneRecord(ShoppingCart shoppingCar) {
		baseDao.updateObject(shoppingCar);
		
	}
	
	
	public static void main(String[] args) {
		ShoppingCartServiceImp s = new ShoppingCartServiceImp();
		ShoppingCart spc = new ShoppingCart();
		
		//添加一个记录
		//添加成功
//		shoppingCart.setTotalPrice(45);
//		shoppingCart.setBookID(1);
//		shoppingCart.setShoppingCartID(1);
//		s.saveOneRecord(shoppingCart);
		
		//查询一个记录
		//成功
//		spc = s.findOneRecord("from ShoppingCart where id =" + 2);
//		System.out.println(spc.getTotalPrice());
		
		//删除一个记录
		//s.deleteOneRecord(1);
		
		//查询一个链表的记录
		//操作成功
//		List<ShoppingCart> list = new ArrayList<ShoppingCart>();
//		list = s.findList("from ShoppingCart");
//		for(int i = 0 ;i < list.size(); i ++)
//		{
//			spc = (ShoppingCart)list.get(i);
//			System.out.println("******");
//			System.out.println("购物车id是：" +spc.getShoppingCartID());
//		}
	}


	public void updateWithQuery(String HQL) {
		
		baseDao.updateWithQuery(HQL);
	}
}
