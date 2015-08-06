package com.chen.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.chen.entity.Users;
import com.chen.service.BaseService;
import com.chen.serviceImp.BaseServiceImp;


public class BaseAction {
	BaseService baseService = new BaseServiceImp();
	public String loginUser()
	{
		String userName = ServletActionContext.getRequest().getParameter("userName").trim();
		String passWord = ServletActionContext.getRequest().getParameter("passWord").trim();
		Users users = baseService.findOne(userName);
		if( ((!"".equals(userName)) && userName.equals(users.getUserName()))||
				((!"".equals(passWord) )&& (passWord.equals(users.getPassWord()))))
		{
			return "LOGINSUCCESS";
		}
		else
			return "LOGINUNSUCCESS";
	}
	
	public String deleteUser()
	{
		return "SUCCESS";
	}
	public String updateUser()
	{
		return "SUCCESS";
	}
	public String findWithPageUser()
	{
		List list = new ArrayList();
		list = baseService.findWithPage();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "SUCCESS";
	}
}
