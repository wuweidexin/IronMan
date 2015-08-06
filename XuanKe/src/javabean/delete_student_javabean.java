package javabean;

import java.sql.SQLException;

import conn.conn;

public class delete_student_javabean {
	
	public int delete_student(String s_username){
		
		String sql = " delete  from  student where s_username = '"+s_username+"'";
		
		conn cn = new conn();
		
		try {
			int i = cn.update(sql);
			if(i>0){
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
				
				e.printStackTrace();
			}
		}
		return 0;
	}

}
