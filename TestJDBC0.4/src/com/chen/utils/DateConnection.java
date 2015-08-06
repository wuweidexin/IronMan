package com.chen.utils;

import java.sql.*;

/**
 * 链接数据库的功能类
 * @author Administrator
 *
 */
public class DateConnection implements CommInterface {

	/**
	 * 获得数据库的链接
	 * @return
	 */
	public  static Connection getConnection(){
		Connection conn=null;

		try {

			try {
				Class.forName(DRIVER);
				conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return conn;

	}
	
	/**
	 * 
	 * 对表进行增删改操作
	 */
	public static  int dateCUD(String sql){
		
		Connection conn=getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return 1;
	}
	
	/**
	 * 查询数据的记录结果集
	 * @param sql
	 * @return
	 */
	public static  ResultSet getResult(String sql){
		ResultSet rs=null;
		PreparedStatement ps=null;
		Connection conn=getConnection();
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return rs;
	}
	
	/**
	 * 关闭链接释放资源
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		
		
		if(conn!=null){
			
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	

}
