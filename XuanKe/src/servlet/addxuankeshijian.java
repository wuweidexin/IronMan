package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.add_time_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addxuankeshijian extends HttpServlet {

	private static final long serialVersionUID = -1978131210719462404L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		String x_begintime = request.getParameter("x_begintime");
		
		String x_endtime = request.getParameter("x_endtime");
		
		add_time_javabean atj = new add_time_javabean();
		
		int i = atj.add_time(x_begintime, x_endtime);
		
		
			if(i==1){
				out.println("<script>");
		    	out.println("alert('修改选课时间成功！');");
		    	out.println("window.location='addxuankeshijian.jsp';");
		    	out.println("</script>");
			}else{
				out.println("<script>");
		    	out.println("alert('修改失败！');");
		    	out.println("window.location='addxuankeshijian.jsp';");
		    	out.println("</script>");
			}
		}

	
}
