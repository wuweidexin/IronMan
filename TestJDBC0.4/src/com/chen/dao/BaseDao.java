package com.chen.dao;

import java.sql.ResultSet;

/**
 * 数据访问层接口
 * @author Administrator
 *
 */
public interface BaseDao {
	
	
	public int dateCud(String sql);
	
	
	public ResultSet getResult(String sql);

}
