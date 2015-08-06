package javabean;

import java.sql.SQLException;

import conn.conn;
import bean.Student;

public class update_student_javabean {
	
	public int update(Student student){
		
		String sql = " update student set s_password = '"+student.getS_password()+"',s_sex = '"+student.getS_sex()+"',s_name = '"+student.getS_name()+"',s_banji = '"+student.getS_banji()+"',s_zhuanye = '"+student.getS_zhuanye()+"' where s_id = '"+student.getS_id()+"'  ";
		
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
