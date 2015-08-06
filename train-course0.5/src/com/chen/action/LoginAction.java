package com.chen.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.chen.entity.Notice;
import com.chen.service.ManagerService;
import com.chen.service.NoticeService;
import com.chen.service.StuService;
import com.chen.serviceImp.ManagerServiceImp;
import com.chen.serviceImp.NoticeServiceImp;
import com.chen.serviceImp.StuServiceImp;

public class LoginAction {
	HttpServletRequest request = ServletActionContext.getRequest();
	StuService stuSer = new StuServiceImp();
	ManagerService mSer = new ManagerServiceImp();
	NoticeService ns = new NoticeServiceImp();
	/*
	 * 系统登录
	 */
	public String login()
	{
		String rights = request.getParameter("rights");

		String flag = null;
		String username = request.getParameter("username");
		String pwd = request.getParameter("password");
		List<Notice> nList = ns.queryListNotice();
		if(username != null && pwd != null && rights != null)
		{
			if(rights.endsWith("student"))
			{
				String re = stuSer.checkLogin(username, pwd);
				if(re.endsWith("inexistence"))
				{
					flag = "inexistence";
					request.setAttribute("flag", flag);
					return "inexistence";
				}else if(re.endsWith("pwdError"))
				{
					flag = "pwdError";
					request.setAttribute("flag", flag);
					return "pwdError";
				}else if(re.endsWith("sPwdCorrect"))
				{
					flag = "sPwdCorrect";
					request.getSession().setAttribute("nList", nList);
					request.setAttribute("flag", flag);
					return "sPwdCorrect";
				}else
				{
					return null;
				}
			}else
			{
				String re = mSer.checkLogin(username, pwd);
				if(re.endsWith("inexistence"))
				{
					flag = "inexistence";
					request.setAttribute("flag", flag);
					return "inexistence";
				}else if(re.endsWith("pwdError"))
				{
					flag = "pwdError";
					request.setAttribute("flag", flag);
					return "pwdError";
				}else if(re.endsWith("mPwdCorrect"))
				{
					flag = "mPwdCorrect";
					request.getSession().setAttribute("nList", nList);
					request.setAttribute("flag", flag);
					return "mPwdCorrect";
				}else
				{
					return null;
				}
			}
		}else
		{
			System.out.println("未知，用无名和密码出现问题");
			flag = "error";
			request.setAttribute("flag", flag);
			return "error";
		}
	}
}
