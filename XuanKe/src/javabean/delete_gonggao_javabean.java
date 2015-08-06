package javabean;

import java.sql.SQLException;

import conn.conn;

public class delete_gonggao_javabean {

	
	public int delete_gonggao(int n_id){
		
		String sql = " delete  from  news where n_id = '"+n_id+"'";
		
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
