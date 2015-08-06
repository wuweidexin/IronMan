package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.update_teacher_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;

@SuppressWarnings("serial")
public class update_teacher extends HttpServlet {

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		
		String t_id = request.getParameter("t_id");

		int id = Integer.parseInt(t_id);
		String t_username = request.getParameter("t_username");
		t_username=new String(t_username.getBytes("ISO8859_1"), "gb2312");
		
		String t_password = request.getParameter("t_password");
		t_password=new String(t_password.getBytes("ISO8859_1"), "gb2312");
		
		String t_sex = request.getParameter("t_sex");
		t_sex=new String(t_sex.getBytes("ISO8859_1"), "gb2312");
		
		String t_name = request.getParameter("t_name");
		t_name=new String(t_name.getBytes("ISO8859_1"), "gb2312");
		
		Teacher teacher = new Teacher();
	
		teacher.setT_id(id);
		teacher.setT_name(t_name);
		teacher.setT_password(t_password);
		teacher.setT_sex(t_sex);
		teacher.setT_username(t_username);
		
		update_teacher_javabean utj = new update_teacher_javabean();
		
		int i = utj.update_teacher(teacher);
		
		if(i>0){
			HttpSession session=request.getSession();
			session.setAttribute("user", t_username);
			out.println("<script>");
	    	out.println("alert('修改成功！');");
	    	out.println("window.location='editteacher.jsp';");
	    	out.println("</script>");
		}else{
			HttpSession session=request.getSession();
			session.setAttribute("user", t_username);
			out.println("<script>");
	    	out.println("alert('修改失败！');");
	    	out.println("window.location='editteacher.jsp';");
	    	out.println("</script>");
		}
		
		
	}

	

}
