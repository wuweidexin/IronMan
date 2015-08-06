package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.update_course_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Course;

@SuppressWarnings("serial")
public class update_course extends HttpServlet {

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
		
		
		
		String c_tname = request.getParameter("c_tname");
		c_tname=new String(c_tname.getBytes("ISO8859_1"), "gb2312");
		Course course = new Course();
		
		course.setC_code(c_code);
		course.setC_name(c_name);
		course.setC_address(c_address);
        course.setC_keshi(c_keshi);
        course.setC_renshu(c_renshu);
        course.setC_tid(c_tid);
        course.setC_tname(c_tname);
		
		update_course_javabean ucj = new update_course_javabean();
		
		int i = ucj.update_course(course);
		
		if(i>0){
		
			out.println("<script>");
	    	out.println("alert('修改成功！');");
	    	out.println("window.location='admin_course.jsp';");
	    	out.println("</script>");
		}else{
			
			out.println("<script>");
	    	out.println("alert('修改失败！');");
	    	out.println("window.location='admin_course.jsp';");
	    	out.println("</script>");
		}
		
		
		
	}

}
