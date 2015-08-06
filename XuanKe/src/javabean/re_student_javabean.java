package javabean;

import java.sql.ResultSet;
import java.sql.SQLException;

import conn.conn;

public class re_student_javabean {
	
	public int re_student (String s_username){
		
		String sql = " select * from student where s_username = '"+s_username+"' ";
		
		System.out.println(sql);
       
		conn cn = new conn();
		
		ResultSet rs = cn.query(sql);
		
		try {
			if(rs.next()){
				return 1;
			}else{
				return 0;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				cn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

}
