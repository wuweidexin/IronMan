package com.chen.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.chen.entity.Manager;
import com.chen.service.ManagerService;
import com.chen.serviceImp.ManagerServiceImp;

public class ManagerAction {
	ManagerService ms = new ManagerServiceImp();
	HttpServletRequest request = ServletActionContext.getRequest();
	/*
	 * 查询管理员信息
	 */
	public String queryManager()
	{
		List<Manager> list = ms.queryListManager();
		request.setAttribute("nList", list);
		return "queryManager";
	}
	
	public String delectManager(){
		int id = Integer.valueOf(request.getParameter("mId"));
		ms.delectManager(id);
		return queryManager();
	}
}
