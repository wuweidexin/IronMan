package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.update_chengji_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class update_chengji extends HttpServlet {

	private static final long serialVersionUID = -3179415159517775046L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		String s_username = request.getParameter("s_username");
		
		String c_code = request.getParameter("c_code");

		String chengji = request.getParameter("chengji");
		
		update_chengji_javabean ucj = new update_chengji_javabean();
		
		int i = ucj.update_chengji(s_username, c_code, chengji);
		
		
			if(i==1){
				out.println("<script>");
		    	out.println("alert('添加成功！');");
		    	out.println("window.location='addscore.jsp';");
		    	out.println("</script>");
			}else{
				out.println("<script>");
		    	out.println("alert('添加失败！');");
		    	out.println("window.location='addscore.jsp';");
		    	out.println("</script>");
			}
		}


	

}
