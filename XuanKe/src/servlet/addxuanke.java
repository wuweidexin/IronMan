package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javabean.addxuanke_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.conn;

public class addxuanke extends HttpServlet {

	private static final long serialVersionUID = -3410447283540197356L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/xml;charset=utf-8");
		
		String c_code = request.getParameter("c_code");
		String s_username = request.getParameter("s_username");
		
		
		conn cn1 = new conn();
		String sql1 = " select * from student where s_username = '"+s_username+"'";
		ResultSet rs1 = cn1.query(sql1);
		String s_name =null;
		String s_sex = null;
		String s_zhuanye = null;
		String s_banji = null;
		try {
			while(rs1.next()){
				s_name = rs1.getString("s_name");
				s_sex = rs1.getString("s_sex");
				s_zhuanye = rs1.getString("s_zhuanye");
				s_banji = rs1.getString("s_banji");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				cn1.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		conn cn2 = new conn();
		String sql2 = " select * from course where c_code = '"+c_code+"'";
		ResultSet rs2 = cn2.query(sql2);
		String c_name =null;
		try {
			while(rs2.next()){
				c_name = rs2.getString("c_name");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				cn2.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		PrintWriter out = response.getWriter();
		
		addxuanke_javabean axj = new addxuanke_javabean();
		
		int i = axj.addaddxuanke(s_username, c_code,s_name,s_sex,s_zhuanye,s_banji,c_name);
		
		System.out.println("i ========"+i);
		
		if(i>0){
			out.println("<response>");
			out.println("<message>" + "0" + "</message>");	
			out.println("</response>");
		}else{
			out.println("<response>");			
			out.println("<message>" + "1" + "</message>");	
			out.println("</response>");
			out.close();
		}	
		
		out.close();
		
	}

	
}
