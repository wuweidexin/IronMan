package com.chen.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.chen.entity.*;
import com.chen.service.StuService;
import com.chen.serviceImp.StuServiceImp;

public class StuAction {
	/*
	 * �û�ע��
	 */
	HttpServletRequest re = ServletActionContext.getRequest();
	StuService stuSer = new StuServiceImp();
	public String stuRegister()
	{
		Student stu = new Student();
		String flag = re.getParameter("flag");
		String number = re.getParameter("s_number");
		String name = re.getParameter("s_name");
		String pwd = re.getParameter("s_pwd");
		String sex = re.getParameter("s_sex");
		String phone = re.getParameter("s_phone");
		String education = re.getParameter("s_education");
		String HQL = "from Student where SName ='"+name+"'";
		if(stuSer.findStu(HQL) == null){
			stu.setSNumber(number);
			stu.setSName(name);
			stu.setSPhone(phone);
			stu.setSPwd(pwd);
			stu.setSSex(sex);
			stu.setSEducation(education);
			stu.setColumn10("1");
			stuSer.saveStu(stu);
			if(flag.endsWith("add")){
				return queryListStu();
			}else{
				return "login";
			}
				
		}else{
			return "error";
		}
		
		
		
		
	}
	
	/*
	 * �û��޸ĸ�����Ϣ
	 */
	public String stuUpdate()
	{
		Student stu = null;
		String id = re.getParameter("s_id");
		String number = re.getParameter("s_number");
		String name = re.getParameter("s_name");
		String pwd = re.getParameter("s_pwd");
		String sex = re.getParameter("s_sex");
		String phone = re.getParameter("s_phone");
		String education = re.getParameter("s_education");
		System.out.println(number+"*****");
		
		 
		 
		if(id != null)
		{
			String HQL = "from Student where SId ="+Integer.valueOf(id);
			stu = stuSer.findStu(HQL);
			stu.setSNumber(number);
			stu.setSName(name);
			stu.setSPhone(phone);
			stu.setSPwd(pwd);
			stu.setSEducation(education);
			stuSer.updateStu(stu);
		}else
		{
			System.out.println("Something Wrong");
		}
		
		return null;
		
	}
	/*
	 * ��ѯ����ѧ������Ϣ��̨ʹ��
	 */
	public String queryListStu()
	{
		List<Student> list = stuSer.findListStu();
		re.setAttribute("listStu", list);
		return "queryListStu";
	}
	public String delectStu(){
		int id = Integer.valueOf(re.getParameter("id"));
		stuSer.delectStu(id);
		return queryListStu();
	}

}
