package com.cissst.dao;

import java.util.List;

/**
 * @ģ�����ƣ�ExamPlanAction(���Լƻ�)
 * @�����ˣ��ƿ���
 * @��          �ܣ�����ExamPlanAction�����ݿ�����в���
 * @����ʱ�䣺2012-8-23
 */
public interface ExamPlanDao
{
	/**
	 * ������save(Object entity) ����һ��ָ���������ݿ�
	 */	
	public void save(Object entity);
	/**
	 * ������update(Object entity) ����һ�������ݿ��е�ָ������
	 */
	public void update(Object entity) ;
	/**
	 * ������delete(Object entityɾ��һ�������ݿ��е�ָ������
	 */
	public void delete(Object entity) ;
	/**
	 * ������getByOne(Object entity, int id)��ѯһ��ָ�����ͺ�id�Ķ���
	 */
	public Object getByOne(Object entity, int id);
	/**
	 * ������findByHQL(final String HQL)����HQL��ѯһ������
	 */	
	public Object findByHQL( String HQL) ;
	/**
	 * ������findByHQL(final String HQL)����HQL��ѯһ�����
	 */	
	public List<?> findList( String HQL) ;
	/**
	 * ������findWithPage(final int startNumber, final int pageSize, final String HQL)����HQL��ѯһ���ֶ���
	 */	
	public List<?> findWithPage(int startNumber, int pageSize,  String HQL);
	/**
	 * ������getRows(final String HQL)����HQL��ѯ��������й��м�������
	 */
	public Object getRows(final String HQL) ;
}
