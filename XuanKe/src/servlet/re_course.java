package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.re_course_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class re_course extends HttpServlet {

	private static final long serialVersionUID = -3849303984120877419L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/xml;charset=utf-8");
		
		String c_code = request.getParameter("c_code");

		PrintWriter out = response.getWriter();
		
		re_course_javabean rcj = new re_course_javabean();
		
		int i = rcj.re_course(c_code);
		
		System.out.println("i ========"+i);
		
		if(i>0){
			out.println("<response>");
			//out.println("<message>" + "对不起,该用户名已经存在！" + "</message>");
			out.println("<message>" + "0" + "</message>");	
			out.println("</response>");
		}else{
			out.println("<response>");			
			//out.println("<message>" + "恭喜您,用户名可以用！" + "</message>");
			out.println("<message>" + "1" + "</message>");	
			out.println("</response>");
			out.close();
		}	
		
		out.close();
		
	}

	

}
