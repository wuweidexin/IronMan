package javabean;

import java.sql.SQLException;

import conn.conn;

public class update_chengji_javabean {
	
	public int update_chengji(String s_username,String c_code,String chengji){
		
		String sql = "update xuanke set chengji = '"+chengji+"' where s_username = '"+s_username+"' and c_code = '"+c_code+"'";
		
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
