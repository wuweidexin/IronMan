package javabean;

import java.sql.SQLException;

import conn.conn;
import bean.Course;

public class update_course_javabean {
	
	public int update_course(Course course){
		
		String sql = " update course set c_name = '"+course.getC_name()+"',c_keshi = "+course.getC_keshi()+",c_tid = '"+course.getC_tid()+"',c_tname = '"+course.getC_tname()+"',c_renshu = "+course.getC_renshu()+" ,c_address = '"+course.getC_address()+"'  where c_code = '"+course.getC_code()+"' ";
		
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
