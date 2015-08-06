package com.cissst.iDao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cissst.dao.ScoreManagerDao;
/**
 * @ģ�����ƣ�ScoreManagerAction(�ɼ�����)
 * @�����ˣ��ƿ���
 * @��          �ܣ�����ScoreManagerAction�����ݿ�����в���
 * @����ʱ�䣺2012-8-23
 */
public class ScoreManagerDaoImp extends HibernateDaoSupport implements ScoreManagerDao
{
	/**
	 * ������save(Object entity) ����һ��ָ���������ݿ�
	 */
	public void save(Object entity) {
		super.getHibernateTemplate().save(entity);
		super.getHibernateTemplate().flush();
		super.getHibernateTemplate().clear();
	}
	/**
	 * ������update(Object entity) ����һ�������ݿ��е�ָ������
	 */
	public void update(Object entity) {
		super.getHibernateTemplate().update(entity);
		super.getHibernateTemplate().flush();
		super.getHibernateTemplate().clear();
	}
	/**
	 * ������delete(Object entityɾ��һ�������ݿ��е�ָ������
	 */
	public void delete(Object entity) {
		super.getHibernateTemplate().delete(entity);
		super.getHibernateTemplate().flush();
		super.getHibernateTemplate().clear();
	}
	/**
	 * ������getByOne(Object entity, int id)��ѯһ��ָ�����ͺ�id�Ķ���
	 */
	public Object getByOne(Object entity, int id) {
		return getSession().get(entity.getClass(), id);
	}
	/**
	 * ������findByHQL(final String HQL)����HQL��ѯһ������
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
	 * ������findByHQL(final String HQL)����HQL��ѯһ�����
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
	 * ������findWithPage(final int startNumber, final int pageSize, final String HQL)����HQL��ѯһ���ֶ���
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
	 * ������getRows(final String HQL)����HQL��ѯ��������й��м�������
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