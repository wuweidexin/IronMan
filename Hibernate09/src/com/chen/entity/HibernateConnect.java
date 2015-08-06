package com.chen.entity;

import javax.persistence.Entity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity
public class HibernateConnect {
	
	private static SessionFactory sfg  = null;
	
	static 
	{
		Configuration cfg = new Configuration().configure();
		sfg = cfg.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sfg;
	}
	
	public static Session getSession()
	{
		return sfg.openSession();
	}
	
	public static void closeSession(Session session)
	{
		try {
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
