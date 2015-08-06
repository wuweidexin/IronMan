package com.chen.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory= null;
	
	static
	{
		
		try {
			Configuration config  = new Configuration().configure();
			sessionFactory = config.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public static Session getSession()
	{
		return sessionFactory.openSession();
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
