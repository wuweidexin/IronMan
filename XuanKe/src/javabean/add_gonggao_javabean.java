package javabean;

import bean.News;
import conn.conn;

public class add_gonggao_javabean {
	
	public int add_gonggao (News n){
		
		String sql = " insert into news (n_title,n_content,n_time) values ('"+n.getN_title()+"','"+n.getN_content()+"','"+n.getN_time()+"')";
		
		conn cn = new conn();
		
		try{
			int i = cn.update(sql);
			if(i>0){
				return 1;
			}else{
				return 0;
			}
			
		}catch(Exception e){
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
