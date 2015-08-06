package javabean;

import java.sql.SQLException;

import conn.conn;
import bean.Teacher;

public class update_teacher_javabean {
	
	public int update_teacher(Teacher teacher){
		
		String sql = " update teacher set t_password = '"+teacher.getT_password()+"',t_name = '"+teacher.getT_name()+"',t_sex = '"+teacher.getT_sex()+"' where t_username = '"+teacher.getT_username()+"'";
		
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
