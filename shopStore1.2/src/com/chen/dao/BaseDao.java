package com.chen.dao;

import java.util.List;

public interface BaseDao {
	//定义底层操作数据库的增删查改的接口方法
	public List findWithPage(int startRow, int pageSize, String HQL); 
	public Object findObject(String HQL);
	public void saveObject(Object obj);
	public void deleteObject(Object obj);
	public void updateObject(Object obj);
	public void updateWithQuery(String HQL);
	public List findList(String HQL);
}
