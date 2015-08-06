package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.delete_gonggao_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class delete_gonggao extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 638346152681807500L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		String n_id = request.getParameter("n_id");
		
		int n_id1 = Integer.parseInt(n_id);
		
		delete_gonggao_javabean dsj = new delete_gonggao_javabean();
		
		int i = dsj.delete_gonggao(n_id1);
		
		if(i==1){
			out.println("<script>");
	    	out.println("alert('É¾³ý³É¹¦£¡');");
	    	out.println("window.location='gonggao_zhuanjia.jsp';");
	    	out.println("</script>");
		}else{
			out.println("<script>");
	    	out.println("alert('É¾³ýÊ§°Ü£¡');");
	    	out.println("window.location='gonggao_zhuanjia.jsp';");
	    	out.println("</script>");
		}
	
		
		
	}

	
}
