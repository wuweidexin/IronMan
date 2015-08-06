package com.chen.daoImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.chen.dao.BaseDao;
import com.chen.utils.HibernateUtils;

public class BaseDaoImp implements BaseDao{
	HibernateUtils hibernateUtils = new HibernateUtils();
	
	public List findWithPage(String HQL) {
		Session session = hibernateUtils.getSession();
		List list = new ArrayList();
		try {
			session.getTransaction().begin();
			list = session.createQuery(HQL).list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return list;
	}
	public Object findOne(String HQL) {
		Session session = hibernateUtils.getSession();
		Object obj = null;
		try {
			session.getTransaction().begin();
			obj = session.createQuery(HQL).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return obj;
	}

}
