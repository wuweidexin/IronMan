package com.cissst.iDao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cissst.dao.SystemSettingDao;
/**
 * @模块名称：SystemSettingAction(系统设置)
 * @开发人：唐俊洪
 * @功          能：管理SystemSettingAction对数据库的所有操作
 * @开发时间：2012-8-23
 */
public class SystemSettingDaoImp extends HibernateDaoSupport implements SystemSettingDao
{
	/**
	 * 方法：save(Object entity) 保存一个指定对象到数据库
	 */
	public void save(Object entity) {
		super.getHibernateTemplate().save(entity);
		super.getHibernateTemplate().flush();
		super.getHibernateTemplate().clear();
	}
	/**
	 * 方法：update(Object entity) 更新一个在数据库中的指定对象
	 */
	public void update(Object entity) {
		super.getHibernateTemplate().update(entity);
		super.getHibernateTemplate().flush();
		super.getHibernateTemplate().clear();
	}
	/**
	 * 方法：delete(Object entity删除一个在数据库中的指定对象
	 */
	public void delete(Object entity) {
		super.getHibernateTemplate().delete(entity);
		super.getHibernateTemplate().flush();
		super.getHibernateTemplate().clear();
	}
	/**
	 * 方法：getByOne(Object entity, int id)查询一个指定类型和id的对象
	 */
	public Object getByOne(Object entity, int id) {
		return getSession().get(entity.getClass(), id);
	}
	/**
	 * 方法：findByHQL(final String HQL)根据HQL查询一个对象
	 */	
	public Object findByHQL(final String HQL) {
		return super.getHibernateTemplate().execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				return session.createQuery(HQL).uniqueResult();
			}
		});
		
	}
	/**
	 * 方法：findByHQL(final String HQL)根据HQL查询一组对象集
	 */	
	public List<?> findList(final String HQL) {
		return super.getHibernateTemplate().executeFind(new HibernateCallback<List<?>>() {
			public List<?> doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createQuery(HQL).list();
			}
		});
	}
	/**
	 * 方法：findWithPage(final int startNumber, final int pageSize, final String HQL)根据HQL查询一部分对象集
	 */	
	public List<?> findWithPage(final int startNumber, final int pageSize, final String HQL) {
		return super.getHibernateTemplate().executeFind(new HibernateCallback<List<?>>() {
			public List<?> doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createQuery(HQL).setFirstResult(startNumber).setMaxResults(pageSize).list();
			}
		});
	}
	/**
	 * 方法：getRows(final String HQL)根据HQL查询这个对象集中共有几个对象
	 */
	public Object getRows(final String HQL) {
		return super.getHibernateTemplate().execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				return session.createQuery(HQL).uniqueResult();
			}
		});
		
	}
}
