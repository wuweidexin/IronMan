package javabean;

import java.sql.SQLException;

import conn.conn;

public class add_chengji_javabean {
	
	public int add_chengji(String s_username,String c_code,String chengji){
		
		String sql = " insert into chengji (s_username,c_code,chengji) values('"+s_username+"','"+c_code+"','"+chengji+"')";
		
		conn cn = new conn();
		
		try {
			int i = cn.update(sql);
			if(i>0){
				return 1;
			}else{
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				cn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

}
