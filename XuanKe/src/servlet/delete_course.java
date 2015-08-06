package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.delete_course_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class delete_course extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		String c_code = request.getParameter("c_code");
		
		delete_course_javabean dcj = new delete_course_javabean();
		
		int i = dcj.delete_course(c_code);
		
		if(i>0){
			out.println("<script>");
	    	out.println("alert('É¾³ý³É¹¦£¡');");
	    	out.println("window.location='admin_course.jsp';");
	    	out.println("</script>");
		}else{
			out.println("<script>");
	    	out.println("alert('É¾³ýÊ§°Ü£¡');");
	    	out.println("window.location='admin_course.jsp';");
	    	out.println("</script>");
		}
		
	}

	
}
