package javabean;

import java.sql.ResultSet;
import java.sql.SQLException;

import conn.conn;
import bean.Course;

public class add_course_javabean {
	
	public int add_course(Course course){
		
		String sql = " insert into course (c_code,c_name,c_keshi,c_tid,c_tname,c_renshu,c_address) values('"+course.getC_code()+"','"+course.getC_name()+"',"+course.getC_keshi()+",'"+course.getC_tid()+"','"+course.getC_tname()+"',"+course.getC_renshu()+",'"+course.getC_address()+"')";
		
		String sql1 = " select * from course where c_code = '"+course.getC_code()+"'";
		
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
