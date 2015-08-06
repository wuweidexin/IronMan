package javabean;

import java.sql.SQLException;

import conn.conn;

public class add_time_javabean {
	
	public int add_time (String x_begintime ,String x_endtime){
		
		String sql = " update xuankeshijian set x_begintime = '"+x_begintime+"' ,x_endtime = '"+x_endtime+"'";
        
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
