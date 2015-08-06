package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.update_zhuanjia_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.zhuanjia;

@SuppressWarnings("serial")
public class update_zhuanjia extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		//String z_id = request.getParameter("z_id");

		//int id = Integer.parseInt(z_id);
		String z_username = request.getParameter("z_username");
		z_username=new String(z_username.getBytes("ISO8859_1"), "gb2312");
		
		String z_password = request.getParameter("z_password");
		z_password=new String(z_password.getBytes("ISO8859_1"), "gb2312");
		
		String z_sex = request.getParameter("z_sex");
		z_sex=new String(z_sex.getBytes("ISO8859_1"), "gb2312");
		
		String z_name = request.getParameter("z_name");
		z_name=new String(z_name.getBytes("ISO8859_1"), "gb2312");
		
		zhuanjia zj = new zhuanjia();
		
		zj.setZ_name(z_name);
		zj.setZ_password(z_password);
		zj.setZ_sex(z_sex);
		zj.setZ_username(z_username);
		
		update_zhuanjia_javabean uzj = new update_zhuanjia_javabean();
		
		int i = uzj.update_zhuanjia(zj);
		
		if(i>0){
			HttpSession session=request.getSession();
			session.setAttribute("user", z_username);
			out.println("<script>");
	    	out.println("alert('修改成功！');");
	    	out.println("window.location='editzhuanjia.jsp';");
	    	out.println("</script>");
		}else{
			HttpSession session=request.getSession();
			session.setAttribute("user", z_username);
			out.println("<script>");
	    	out.println("alert('修改失败！');");
	    	out.println("window.location='editzhuanjia.jsp';");
	    	out.println("</script>");
		}
		
	}

}
