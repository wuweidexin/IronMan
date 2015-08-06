package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.addaddxuanke_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deletexuanke extends HttpServlet {

	private static final long serialVersionUID = -6969805323868004892L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/xml;charset=utf-8");
		
		String c_code = request.getParameter("c_code");
		PrintWriter out = response.getWriter();
		
		addaddxuanke_javabean adj = new addaddxuanke_javabean();
		
		int i = adj.deletexuanke(c_code);
		
		if(i>0){
			out.println("<response>");
			out.println("<message>" + "2" + "</message>");	
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
