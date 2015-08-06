package com.cissst.dao;

import java.util.List;

/**
 * @模块名称：ExamPlanAction(考试计划)
 * @开发人：唐俊洪
 * @功          能：管理ExamPlanAction对数据库的所有操作
 * @开发时间：2012-8-23
 */
public interface ExamPlanDao
{
	/**
	 * 方法：save(Object entity) 保存一个指定对象到数据库
	 */	
	public void save(Object entity);
	/**
	 * 方法：update(Object entity) 更新一个在数据库中的指定对象
	 */
	public void update(Object entity) ;
	/**
	 * 方法：delete(Object entity删除一个在数据库中的指定对象
	 */
	public void delete(Object entity) ;
	/**
	 * 方法：getByOne(Object entity, int id)查询一个指定类型和id的对象
	 */
	public Object getByOne(Object entity, int id);
	/**
	 * 方法：findByHQL(final String HQL)根据HQL查询一个对象
	 */	
	public Object findByHQL( String HQL) ;
	/**
	 * 方法：findByHQL(final String HQL)根据HQL查询一组对象集
	 */	
	public List<?> findList( String HQL) ;
	/**
	 * 方法：findWithPage(final int startNumber, final int pageSize, final String HQL)根据HQL查询一部分对象集
	 */	
	public List<?> findWithPage(int startNumber, int pageSize,  String HQL);
	/**
	 * 方法：getRows(final String HQL)根据HQL查询这个对象集中共有几个对象
	 */
	public Object getRows(final String HQL) ;
}
