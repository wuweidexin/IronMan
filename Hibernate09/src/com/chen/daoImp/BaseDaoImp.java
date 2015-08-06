package com.chen.daoImp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.swing.JOptionPane;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.chen.entity.Classes;
import com.chen.entity.HibernateConnect;
import com.chen.entity.TbStudent;

@Entity
public class BaseDaoImp {
	/**
	 * 更加面向对象的查询接口crete
	 */
	public static void createTable()
	{
		Configuration cfg = new Configuration();
		SchemaExport export = new SchemaExport(cfg);
		export.create(true, true);
	}


	public static void save()
	{
		Session session = HibernateConnect.getSession();

		try {
			session.getTransaction().begin();

			Classes cla = new Classes();
			cla.setClaName("计算机");
			session.save(cla);
			Set<TbStudent> set = new HashSet<TbStudent>();

			TbStudent stu1 = new TbStudent();
			stu1.setStuAge(12);
			stu1.setStuName("黎明");
			stu1.setStuSex("男");
			session.save(stu1);

			TbStudent stu2 = new TbStudent();
			stu2.setStuAge(12);
			stu2.setStuName("张明");
			stu2.setStuSex("男");
			session.save(stu2);

			set.add(stu1);
			set.add(stu2);

			cla.setSet(set);


			session.getTransaction().commit();

		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally
		{
			HibernateConnect.closeSession(session);
		}


	}

	public static void delete(TbStudent users)
	{
		Session session = HibernateConnect.getSession();
		try {
			session.getTransaction().begin();
			session.delete(users);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			HibernateConnect.closeSession(session);
		}
	}

	public static void update(TbStudent users)
	{
		Session session = HibernateConnect.getSession();
		try {
			session.getTransaction().begin();
			session.update(users);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			HibernateConnect.closeSession(session);
		}
	}

	public static void get(int id)
	{
		Session session = HibernateConnect.getSession();
		try {
			session.getTransaction().begin();
			if(session.get(TbStudent.class, id) != null)
			{
				TbStudent stu = (TbStudent)session.get(TbStudent.class, id);

				System.out.println(stu.getId());
				System.out.println(stu.getStuName());
				System.out.println(stu.getStuSex());
				System.out.println(stu.getStuAge());

			}
			else
			{
				JOptionPane.showMessageDialog(null, "你要查询的记录为空");
			}

			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();  
		}finally{
			HibernateConnect.closeSession(session);
		}
	}

	public static void load(int id)
	{
		Session session = HibernateConnect.getSession();
		try {
			session.getTransaction().begin();
			TbStudent stu = (TbStudent)session.load(TbStudent.class, id);
			System.out.println(stu.getId());
			System.out.println(stu.getStuName());
			System.out.println(stu.getStuSex());
			System.out.println(stu.getStuAge());
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			HibernateConnect.closeSession(session);
		}
	}

	public static void findCriteria()
	{
		Session session = HibernateConnect.getSession();
		try {
			session.getTransaction().begin();
			List<TbStudent> stuList = session.createCriteria(TbStudent.class).list();
			for(int i = 0; i < stuList.size(); i ++)
			{
				TbStudent stu = new TbStudent();
				stu = stuList.get(i);
				System.out.println(stu.getId());
				System.out.println(stu.getStuAge());
				System.out.println(stu.getStuName());
				System.out.println(stu.getStuSex());			
			}

			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			HibernateConnect.closeSession(session);
		}
	}

	public static void findCriteria1()
	{
		Session session = HibernateConnect.getSession();
		try {
			session.getTransaction().begin();
			TbStudent stu = (TbStudent)session.createCriteria(TbStudent.class).add(Restrictions.eq("id", 1)).uniqueResult();
			System.out.println(stu.getId());
			System.out.println(stu.getStuAge());
			System.out.println(stu.getStuName());
			System.out.println(stu.getStuSex());			


			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			HibernateConnect.closeSession(session);
		}
	}
	
	public static void findCriteria2()
	{
		Session session = HibernateConnect.getSession();
		try {
			session.getTransaction().begin();
			TbStudent stu = (TbStudent)session.createCriteria(TbStudent.class).add(Restrictions.like("stuName","'%" + "Li%'")).uniqueResult();
			System.out.println(stu.getId());
			System.out.println(stu.getStuAge());
			System.out.println(stu.getStuName());
			System.out.println(stu.getStuSex());			


			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			HibernateConnect.closeSession(session);
		}
	}

	public static void main(String[] args)
	{
		BaseDaoImp.findCriteria1();
	}
}
