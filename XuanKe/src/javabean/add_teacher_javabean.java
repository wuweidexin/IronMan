package javabean;

import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Teacher;
import conn.conn;

public class add_teacher_javabean {

	
	public int add_teacher(Teacher t){
		
		String sql = " insert into teacher (t_username,t_password,t_sex,t_name) values ('"+t.getT_username()+"','"+t.getT_password()+"','"+t.getT_sex()+"','"+t.getT_name()+"')";
		
		String sql1 = " select * from teacher where t_username = '"+t.getT_username()+"'";
		
		System.out.println(sql);
		
		conn cn = new conn();
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
