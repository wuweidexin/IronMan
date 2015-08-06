package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.delete_student_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class delete_student extends HttpServlet {




	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		String s_username = request.getParameter("s_username");
		
		delete_student_javabean dsj = new delete_student_javabean();
		
		int i = dsj.delete_student(s_username);
		
		if(i>0){
			out.println("<script>");
	    	out.println("alert('É¾³ý³É¹¦£¡');");
	    	out.println("window.location='admin_student.jsp';");
	    	out.println("</script>");
		}else{
			out.println("<script>");
	    	out.println("alert('É¾³ýÊ§°Ü£¡');");
	    	out.println("window.location='admin_student.jsp';");
	    	out.println("</script>");
		}
		
	}
}
