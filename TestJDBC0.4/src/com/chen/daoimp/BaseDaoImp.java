package com.chen.daoimp;

import java.sql.ResultSet;

import com.chen.dao.BaseDao;
import com.chen.utils.DateConnection;
/**
 * ���ݷ��ʲ�ӿڵ�ʵ����
 * @author Administrator
 *
 */
public class BaseDaoImp  implements BaseDao{


	public int dateCud(String sql) {
		DateConnection.dateCUD(sql);
		return 1;
	}

	
	public ResultSet getResult(String sql) {
		
		return DateConnection.getResult(sql);
	}

}
