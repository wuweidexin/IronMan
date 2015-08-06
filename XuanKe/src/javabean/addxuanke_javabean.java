package javabean;

import java.sql.SQLException;

import conn.conn;

public class addxuanke_javabean {
	
	public int addaddxuanke (String s_username,String c_code,String s_name,String s_sex,String s_banji,String s_zhuanye,String c_name){
		
		String sql = "insert into xuanke (s_username,c_code,s_name,s_sex,s_zhuanye,s_banji,c_name) values ('"+s_username+"','"+c_code+"','"+s_name+"','"+s_sex+"','"+s_banji+"','"+s_zhuanye+"','"+c_name+"')";
		
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
