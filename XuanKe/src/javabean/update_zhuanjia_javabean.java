package javabean;

import java.sql.SQLException;

import conn.conn;
import bean.zhuanjia;

public class update_zhuanjia_javabean {
	
	public int update_zhuanjia(zhuanjia zj){
		
		String sql = " update zhuanjia set z_password = '"+zj.getZ_password()+"',z_name = '"+zj.getZ_name()+"',z_sex = '"+zj.getZ_sex()+"' where z_username = '"+zj.getZ_username()+"'";
		
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
