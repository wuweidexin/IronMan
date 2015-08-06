package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.add_gonggao_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.News;

public class add_gonggao extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		String n_title = request.getParameter("n_title");
		n_title=new String(n_title.getBytes("ISO8859_1"), "gb2312");
		String n_content = request.getParameter("n_content");
		n_content=new String(n_content.getBytes("ISO8859_1"), "gb2312");
		String n_time = request.getParameter("n_time");
		n_time=new String(n_time.getBytes("ISO8859_1"), "gb2312");
		
		
		News n = new News();
		
		n.setN_title(n_title);
		n.setN_content(n_content);
		n.setN_time(n_time);
		
		
		add_gonggao_javabean agj = new add_gonggao_javabean();
		
		int i = agj.add_gonggao(n);
		
		
			if(i==1){
				out.println("<script>");
		    	out.println("alert('添加成功！');");
		    	out.println("window.location='gonggao_zhuanjia.jsp';");
		    	out.println("</script>");
			}else{
				out.println("<script>");
		    	out.println("alert('添加失败！');");
		    	out.println("window.location='gonggao_zhuanjia.jsp';");
		    	out.println("</script>");
			}
		}

	
}
