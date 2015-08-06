package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.login_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class login extends HttpServlet {

	 
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
	
		String username = request.getParameter("username");
		
		username=new String(username.getBytes("ISO8859_1"), "gb2312");
		String password = request.getParameter("password");
		password=new String(password.getBytes("ISO8859_1"), "gb2312");
		
		String rights = request.getParameter("rights");
		rights=new String(rights.getBytes("ISO8859_1"), "gb2312");
		
		login_javabean  lj = new login_javabean();
		
		int i = lj.login(username, password,rights);
		
		
		if(i==1){
			HttpSession session=request.getSession();
			session.setAttribute("user", username);
			out.println("<script>");
	    	out.println("alert('µÇÂ¼³É¹¦£¡');");
	    	out.println("window.location='main.jsp';");
	    	out.println("</script>");
		}else{
			if(i==2){
				HttpSession session=request.getSession();
				session.setAttribute("user", username);
				out.println("<script>");
		    	out.println("alert('µÇÂ¼³É¹¦£¡');");
		    	out.println("window.location='main_teacher.jsp';");
		    	out.println("</script>");
			}else{
				if(i==3){
					HttpSession session=request.getSession();
					session.setAttribute("user", username);
					out.println("<script>");
			    	out.println("alert('µÇÂ¼³É¹¦£¡');");
			    	out.println("window.location='main_zhuanjia.jsp';");
			    	out.println("</script>");
				}else{
					out.println("<script>");
			    	out.println("alert('µÇÂ¼Ê§°Ü£¡');");
			    	out.println("window.location='login.jsp';");
			    	out.println("</script>");
				}
			}
		}

	}


}
