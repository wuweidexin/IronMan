package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.delete_teacher_javabean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class delete_teacher extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		String t_username = request.getParameter("t_username");
		
		delete_teacher_javabean dsj = new delete_teacher_javabean();
		
		int i = dsj.delete_teacher(t_username);
		
		if(i==2){

			out.println("<script>");
	    	out.println("alert('ɾ��ʧ��,���޸Ĵ˽�ʦ�����Ŀγ�ת�ƣ�');");
	    	out.println("window.location='admin_teacher.jsp';");
	    	out.println("</script>");
		}else{
			
			if(i==1){
				out.println("<script>");
		    	out.println("alert('ɾ���ɹ���');");
		    	out.println("window.location='admin_teacher.jsp';");
		    	out.println("</script>");
			}else{
				out.println("<script>");
		    	out.println("alert('ɾ��ʧ�ܣ�');");
		    	out.println("window.location='admin_teacher.jsp';");
		    	out.println("</script>");
			}
		}
		
		
	}

	

}
