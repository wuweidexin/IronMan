package com.chen.dao;

import java.sql.ResultSet;

/**
 * ���ݷ��ʲ�ӿ�
 * @author Administrator
 *
 */
public interface BaseDao {
	
	
	public int dateCud(String sql);
	
	
	public ResultSet getResult(String sql);

}
