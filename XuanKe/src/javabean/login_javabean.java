package javabean;

import java.sql.ResultSet;
import java.sql.SQLException;

import conn.conn;

public class login_javabean {
	
	public int login(String username, String password,String rights){
		
		String sql = " select * from teacher where t_username = '"+username+"' ";
		
		String sql1 = " select * from student where s_username = '"+username+"'";
		
		String sql2 = " select * from zhuanjia where z_username = '"+username+"'";
		
        conn cn = new conn();
		
		ResultSet  rs ;
		
		if("student".equals(rights)){
			rs = cn.query(sql1);
			try {
				if(rs.next()){
					if(password.equals(rs.getString("s_password"))){
						return 1;
					}else{
						return 0;
					}
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
		}else{
			if("teacher".equals(rights)){
				System.out.println("进入教师1111111111111111");

				rs = cn.query(sql);
				System.out.println("进入教师222222222222222222");
				try {
					if(rs.next()){
						if(password.equals(rs.getString("t_password"))){
							return 2;
						}else{
							return 0;
						}
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
			}else{
				rs = cn.query(sql2);
				try {
					if(rs.next()){
						if(password.equals(rs.getString("z_password"))){
							return 3;
						}else{
							return 0;
						}
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
			
			}
		}
		return 0;
		
	}

}
