package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.add_chengji_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addchengji extends HttpServlet {
	private static final long serialVersionUID = 1338936157101731696L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         
		request.setCharacterEncoding("gb2312");
		response.setContentType("text/xml;charset=utf-8");
		
		String c_code = request.getParameter("c_code");
		String s_username = request.getParameter("s_username");
		String chengji = request.getParameter("chengji");
		
		PrintWriter out = response.getWriter();
		
		add_chengji_javabean acj = new add_chengji_javabean();
		
		int i = acj.add_chengji(s_username, c_code, chengji);
		
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
