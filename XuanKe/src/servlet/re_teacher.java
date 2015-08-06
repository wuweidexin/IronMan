package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.re_teacher_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class re_teacher extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/xml;charset=utf-8");
		
		String t_username = request.getParameter("t_username");

		PrintWriter out = response.getWriter();
		
		re_teacher_javabean rtj = new re_teacher_javabean();
		
		int i = rtj.re_teacher(t_username);
		
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
