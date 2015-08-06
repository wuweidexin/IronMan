package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javabean.add_course_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.conn;

import bean.Course;

@SuppressWarnings("serial")
public class add_course extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		String c_code = request.getParameter("c_code");
		
		String c_name = request.getParameter("c_name");
		c_name=new String(c_name.getBytes("ISO8859_1"), "gb2312");
		
		String c_keshi1 = request.getParameter("c_keshi");
		
		double c_keshi = Double.parseDouble(c_keshi1);
		
		String c_tid = request.getParameter("c_tid");
		
		String c_renshu1 = request.getParameter("c_renshu");
		
		int c_renshu = Integer.parseInt(c_renshu1);
		
		String c_address = request.getParameter("c_address");
		c_address=new String(c_address.getBytes("ISO8859_1"), "gb2312");
	
		
		String sql = "select * from teacher where t_username = '"+c_tid+"'";
		
		conn cn = new conn();
		String c_tname = null;
		
		ResultSet rs;
		
		rs = cn.query(sql);
		
		try {
			while(rs.next()){
				c_tname = rs.getString("t_name");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		
		Course course = new Course();
		
		course.setC_code(c_code);
		course.setC_name(c_name);
		course.setC_address(c_address);
        course.setC_keshi(c_keshi);
        course.setC_renshu(c_renshu);
        course.setC_tid(c_tid);
        course.setC_tname(c_tname);
		
		add_course_javabean acj = new add_course_javabean();
		
		int i = acj.add_course(course);
		
		if(i==2){

			out.println("<script>");
	    	out.println("alert('添加失败,课程编号已经存在！');");
	    	out.println("window.location='addcourse.jsp';");
	    	out.println("</script>");
		}else{
			
			if(i==1){
				out.println("<script>");
		    	out.println("alert('添加成功！');");
		    	out.println("window.location='admin_course.jsp';");
		    	out.println("</script>");
			}else{
				out.println("<script>");
		    	out.println("alert('添加失败！');");
		    	out.println("window.location='addcourse.jsp';");
		    	out.println("</script>");
			}
		}
	}

	
}
