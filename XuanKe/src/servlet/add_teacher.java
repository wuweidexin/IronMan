package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.add_teacher_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Teacher;

@SuppressWarnings("serial")
public class add_teacher extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		String t_username = request.getParameter("t_username");
		t_username=new String(t_username.getBytes("ISO8859_1"), "gb2312");
		String t_password = request.getParameter("t_password");
		t_password=new String(t_password.getBytes("ISO8859_1"), "gb2312");
		String t_name = request.getParameter("t_name");
		t_name=new String(t_name.getBytes("ISO8859_1"), "gb2312");
		String t_sex = request.getParameter("t_sex");
		t_sex=new String(t_sex.getBytes("ISO8859_1"), "gb2312");
		
		Teacher t = new Teacher();
		
		t.setT_name(t_name);
		t.setT_password(t_password);
		t.setT_sex(t_sex);
		t.setT_username(t_username);
		
		add_teacher_javabean atj = new add_teacher_javabean();
		
		int i = atj.add_teacher(t);
		
		if(i==2){

			out.println("<script>");
	    	out.println("alert('添加失败,用户名已经存在！');");
	    	out.println("window.location='addteacher.jsp';");
	    	out.println("</script>");
		}else{
			
			if(i==1){
				out.println("<script>");
		    	out.println("alert('添加成功！');");
		    	out.println("window.location='admin_teacher.jsp';");
		    	out.println("</script>");
			}else{
				out.println("<script>");
		    	out.println("alert('添加失败！');");
		    	out.println("window.location='addteacher.jsp';");
		    	out.println("</script>");
			}
		}
	}

	
}
