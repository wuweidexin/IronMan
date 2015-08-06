package com.chen.daoimp;

import java.sql.ResultSet;

import com.chen.dao.BaseDao;
import com.chen.utils.DateConnection;
/**
 * 数据访问层接口的实现类
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
