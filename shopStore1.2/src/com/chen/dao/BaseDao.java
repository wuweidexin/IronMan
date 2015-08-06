package com.chen.dao;

import java.util.List;

public interface BaseDao {
	//����ײ�������ݿ����ɾ��ĵĽӿڷ���
	public List findWithPage(int startRow, int pageSize, String HQL); 
	public Object findObject(String HQL);
	public void saveObject(Object obj);
	public void deleteObject(Object obj);
	public void updateObject(Object obj);
	public void updateWithQuery(String HQL);
	public List findList(String HQL);
}
