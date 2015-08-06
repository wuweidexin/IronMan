package com.chen.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.chen.HibernateUtil.HibernateUtils;
import com.chen.dao.BaseDao;

public class BaseDaoImp implements BaseDao{
	HibernateUtils hibernateUtils = new HibernateUtils();
	
	//底层操作数据库，查找一页的数据的方法
	public List findWithPage(int startRow, int pageSize, String HQL) {
		Session session = hibernateUtils.getSession();
		List list = new ArrayList();
		try {
			session.getTransaction().begin();
			list = session.createQuery(HQL)
			.setFirstResult(startRow)
			.setMaxResults(pageSize)
			.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			
			session.getTransaction().rollback();
			System.out.println("系统出错与DaoImp的findWithPage");
			e.printStackTrace();
		}finally
		{
			hibernateUtils.closeSession(session);
		}
		return list;
	}
	//查找单条数据的方法
	public Object findObject(String HQL) {
		Session session = hibernateUtils.getSession();
		Object obj = null;
		try {
			session.getTransaction().begin();
			obj = session.createQuery(HQL).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			
			session.getTransaction().rollback();
			System.out.println("系统出错与DaoImp的findOne");
			e.printStackTrace();
		}finally
		{
			hibernateUtils.closeSession(session);
		}
		return obj;
	}
	//存储一个对象的方法，传入的是对象
	public void saveObject(Object obj) {
		
		Session session = hibernateUtils.getSession();
		try {
			session.getTransaction().begin();
			session.save(obj);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			
			session.getTransaction().rollback();
			System.out.println("系统出错与DaoImp的saveObject");
			e.printStackTrace();
		}finally
		{
			hibernateUtils.closeSession(session);
		}
	}
	//删除一个对象的方法
	public void deleteObject(Object obj) {
	
		Session session = hibernateUtils.getSession();
		try {
			session.getTransaction().begin();
			session.delete(obj);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			
			session.getTransaction().rollback();
			System.out.println("系统出错与DaoImp的deleteObject");
			e.printStackTrace();
		}finally
		{
			hibernateUtils.closeSession(session);
		}
	}
	//更新一个对象的方法
	public void updateObject(Object obj) {
		Session session = hibernateUtils.getSession();
		try {
			session.getTransaction().begin();
			session.update(obj);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			
			session.getTransaction().rollback();
			System.out.println("系统出错与DaoImp的updateObject");
			e.printStackTrace();
		}finally
		{
			hibernateUtils.closeSession(session);
		}
	}
	public List findList(String HQL) {
		Session session = hibernateUtils.getSession();
		List list = new ArrayList();
		try {
			session.getTransaction().begin();
			list = session.createQuery(HQL)
			.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			
			session.getTransaction().rollback();
			System.out.println("系统出错与DaoImp的findWithPage");
			e.printStackTrace();
		}finally
		{
			hibernateUtils.closeSession(session);
		}
		return list;
	}
	public void updateWithQuery(String HQL) {
		Session session = hibernateUtils.getSession();
		try {
			session.getTransaction().begin();
			Query que = session.createQuery(HQL);
			que.executeUpdate();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			
			session.getTransaction().rollback();
			System.out.println("系统出错与DaoImp的updateObject");
			e.printStackTrace();
		}finally
		{
			hibernateUtils.closeSession(session);
		}
		
	}

}
