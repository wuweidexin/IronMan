package javabean;

import java.sql.ResultSet;
import java.sql.SQLException;

import conn.conn;

public class delete_teacher_javabean {
	
       public int delete_teacher(String t_username){
		
		String sql = " delete  from  teacher where t_username = '"+t_username+"'";
		
		String sql1 = " select * from course where c_tid = '"+t_username+"'";
		
		conn cn = new conn();
		
		System.out.println("sql=================="+sql);
		
		System.out.println("sql1=================="+sql1);
		
		ResultSet rs = cn.query(sql1);
		
		
		try {
			if(rs.next()){
				return 2;
			}else{
			int i = cn.update(sql);
			if(i>0){
				return 1;
			}else{
				return 0;
			}}
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
