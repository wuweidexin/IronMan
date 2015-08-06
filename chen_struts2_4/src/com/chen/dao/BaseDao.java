package com.chen.dao;

import java.util.List;

public interface BaseDao {
	public List findWithPage(String HQL);
	public Object findOne(String HQL);
}
