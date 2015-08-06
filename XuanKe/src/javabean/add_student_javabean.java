package javabean;
import java.sql.SQLException;
import java.sql.*;
import conn.conn;
import bean.Student;
public class add_student_javabean {
	
	public int add_student(Student s){
		
		String sql1 = "select * from student where s_username = '"+s.getS_username()+"'";
		
		String sql = " insert into student (s_username,s_password,s_sex,s_name,s_banji,s_zhuanye) values ('"+s.getS_username()+"','"+s.getS_password()+"','"+s.getS_sex()+"','"+s.getS_name()+"','"+s.getS_banji()+"','"+s.getS_zhuanye()+"')";
		
		System.out.println(sql);
		
		conn cn = new conn();
		
		ResultSet  rs = cn.query(sql1);
		
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
