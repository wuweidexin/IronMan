package com.chen.ation;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;


import com.chen.entity.Manager;
import com.chen.service.ManagerService;
import com.chen.serviceImp.ManagerServiceImp;
import com.opensymphony.xwork2.ActionSupport;

public class ManagerAction extends ActionSupport{
	ManagerService ms = new ManagerServiceImp();
	java.util.Date date=new java.util.Date();
	public String loadManagerSet()
	{
		//载入管理员个人信息设置界面,以及相关页面的控制
		 int action = Integer.parseInt(ServletActionContext.getRequest().getParameter("action"));
		
		 if(action == -1)
		 { 
			 return login();
		 }
		 else if(action == 0)
		 {
			 return showManagerSetView();
		 }else if(action == 1)
		 {
			 return "updateManagerPassword";
		 }else if(action == 2)
		 {
			 int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
			 Manager managerAlter = ms.findOneManager("from Manager where id="+ id);
			 ServletActionContext.getRequest().getSession().setAttribute("managerAlter", managerAlter);
			 return "updateManagerMes";
		 }
		 else if(action == 3)
		 {
			 Manager newManager = new Manager();
			 String managerID = "MX" + (date.getYear()+1900) + (date.getMonth()+1) + date.getDate() + date.getHours() + date.getMinutes() + date.getSeconds();
			 newManager.setManagerID(managerID);
			 ms.saveManager(newManager);
			 ServletActionContext.getRequest().getSession().setAttribute("managerID", managerID);
			 ServletActionContext.getRequest().getSession().setAttribute("newManager", newManager);
			 return "saveManager";
		 }else if(action == 4)
		 {
			 return deleteManager();
		 }else
		 {
			 return "Unsuccess";
		 }
	}
	
	public String login()
	{
		//管理员登录界面，以及登录等的操作
		String managerName = ServletActionContext.getRequest().getParameter("managerName");
		String managerPassword = ServletActionContext.getRequest().getParameter("managerPassword");
		Manager manager = ms.findOneManager("from Manager where managerName='" + managerName + "'");
		if(manager == null)
		{
			return "nullMManager";
		}
		else if(managerPassword.equals(manager.getManagerPassword()))
		{

			ServletActionContext.getRequest().getSession().setAttribute("manager", manager);
			return "loginSuccess";
		}
		else
		{
			
			return "unSuccess";
		}
	}
	
	public String showManagerSetView()
	{
		//进入管理员后台处理界面
	
		
		return "loadManagerSet";
	}
	
	public String updateManagerPassword()
	{
		//修改管理员自己的密码

		Manager manager = (Manager)ServletActionContext.getRequest().getSession().getAttribute("manager");
		String newManagerPassword = ServletActionContext.getRequest().getParameter("managerPassword");
		
		manager.setManagerPassword(newManagerPassword);
		ms.updateManager(manager);
		return "success";
	}
	
	public String updateManagerMes()
	{
		//修改管理员的信息
		
		
		String name = ServletActionContext.getRequest().getParameter("name");
		String password = ServletActionContext.getRequest().getParameter("password");
		Manager m = (Manager)ServletActionContext.getRequest().getSession().getAttribute("managerAlter");
		m.setManagerName(name);
		m.setManagerPassword(password);
		ms.updateManager(m);
		return "loadManagerSet";
	}
	

	public String saveManager()
	{
		//新增管理员
		Manager newManager = (Manager)ServletActionContext.getRequest().getSession().getAttribute("newManager");
		
		String managerPassword = ServletActionContext.getRequest().getParameter("password");
		String managerName = ServletActionContext.getRequest().getParameter("name");
		
		newManager.setManagerName(managerName);
		newManager.setManagerPassword(managerPassword);
		ms.updateManager(newManager);
		return "loadManagerSet";
	}
	
	public String deleteManager()
	{
		//删除管理员
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		Manager m = ms.findOneManager("from Manager where id="+ id);
		ms.deleteManager(m);
		return "loadManagerSet";
	}

}
