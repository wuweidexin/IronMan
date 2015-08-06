package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.add_student_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;

@SuppressWarnings("serial")
public class add_student extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		String s_username = request.getParameter("s_username");
		s_username=new String(s_username.getBytes("ISO8859_1"), "gb2312");
		String s_password = request.getParameter("s_password");
		s_password=new String(s_password.getBytes("ISO8859_1"), "gb2312");
		String s_name = request.getParameter("s_name");
		s_name=new String(s_name.getBytes("ISO8859_1"), "gb2312");
		String s_sex = request.getParameter("s_sex");
		s_sex=new String(s_sex.getBytes("ISO8859_1"), "gb2312");
		
		String s_banji = request.getParameter("s_banji");
		s_banji=new String(s_banji.getBytes("ISO8859_1"), "gb2312");
		String s_zhuanye = request.getParameter("s_zhuanye");
		s_zhuanye=new String(s_zhuanye.getBytes("ISO8859_1"), "gb2312");

		
		Student s = new Student();
		
		s.setS_banji(s_banji);
		s.setS_name(s_name);
		s.setS_sex(s_sex);
		s.setS_password(s_password);
		s.setS_username(s_username);
		s.setS_zhuanye(s_zhuanye);
		
		add_student_javabean asj = new add_student_javabean();
		
		int i = asj.add_student(s);
		
		if(i==2){

			out.println("<script>");
	    	out.println("alert('添加失败,用户名已经存在！');");
	    	out.println("window.location='addstudent.jsp';");
	    	out.println("</script>");
		}else{
			
			if(i==1){
				out.println("<script>");
		    	out.println("alert('添加成功！');");
		    	out.println("window.location='admin_student.jsp';");
		    	out.println("</script>");
			}else{
				out.println("<script>");
		    	out.println("alert('添加失败！');");
		    	out.println("window.location='addstudent.jsp';");
		    	out.println("</script>");
			}
		}
	}

	
}
