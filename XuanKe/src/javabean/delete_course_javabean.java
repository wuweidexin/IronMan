package javabean;

import java.sql.SQLException;

import conn.conn;

public class delete_course_javabean {
	
	public int delete_course(String c_code){
		
		String sql = " delete from course where c_code ='"+c_code+"'";
		
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
