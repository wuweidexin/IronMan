package com.chen.utils;

import java.sql.*;

/**
 * �������ݿ�Ĺ�����
 * @author Administrator
 *
 */
public class DateConnection implements CommInterface {

	/**
	 * ������ݿ������
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
	 * �Ա������ɾ�Ĳ���
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
	 * ��ѯ���ݵļ�¼�����
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
	 * �ر������ͷ���Դ
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
