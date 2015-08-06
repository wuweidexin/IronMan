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
	
	//�ײ�������ݿ⣬����һҳ�����ݵķ���
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
			System.out.println("ϵͳ������DaoImp��findWithPage");
			e.printStackTrace();
		}finally
		{
			hibernateUtils.closeSession(session);
		}
		return list;
	}
	//���ҵ������ݵķ���
	public Object findObject(String HQL) {
		Session session = hibernateUtils.getSession();
		Object obj = null;
		try {
			session.getTransaction().begin();
			obj = session.createQuery(HQL).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			
			session.getTransaction().rollback();
			System.out.println("ϵͳ������DaoImp��findOne");
			e.printStackTrace();
		}finally
		{
			hibernateUtils.closeSession(session);
		}
		return obj;
	}
	//�洢һ������ķ�����������Ƕ���
	public void saveObject(Object obj) {
		
		Session session = hibernateUtils.getSession();
		try {
			session.getTransaction().begin();
			session.save(obj);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			
			session.getTransaction().rollback();
			System.out.println("ϵͳ������DaoImp��saveObject");
			e.printStackTrace();
		}finally
		{
			hibernateUtils.closeSession(session);
		}
	}
	//ɾ��һ������ķ���
	public void deleteObject(Object obj) {
	
		Session session = hibernateUtils.getSession();
		try {
			session.getTransaction().begin();
			session.delete(obj);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			
			session.getTransaction().rollback();
			System.out.println("ϵͳ������DaoImp��deleteObject");
			e.printStackTrace();
		}finally
		{
			hibernateUtils.closeSession(session);
		}
	}
	//����һ������ķ���
	public void updateObject(Object obj) {
		Session session = hibernateUtils.getSession();
		try {
			session.getTransaction().begin();
			session.update(obj);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			
			session.getTransaction().rollback();
			System.out.println("ϵͳ������DaoImp��updateObject");
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
			System.out.println("ϵͳ������DaoImp��findWithPage");
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
			System.out.println("ϵͳ������DaoImp��updateObject");
			e.printStackTrace();
		}finally
		{
			hibernateUtils.closeSession(session);
		}
		
	}

}
