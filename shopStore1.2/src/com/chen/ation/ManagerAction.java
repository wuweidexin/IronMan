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
		//�������Ա������Ϣ���ý���,�Լ����ҳ��Ŀ���
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
		//����Ա��¼���棬�Լ���¼�ȵĲ���
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
		//�������Ա��̨�������
	
		
		return "loadManagerSet";
	}
	
	public String updateManagerPassword()
	{
		//�޸Ĺ���Ա�Լ�������

		Manager manager = (Manager)ServletActionContext.getRequest().getSession().getAttribute("manager");
		String newManagerPassword = ServletActionContext.getRequest().getParameter("managerPassword");
		
		manager.setManagerPassword(newManagerPassword);
		ms.updateManager(manager);
		return "success";
	}
	
	public String updateManagerMes()
	{
		//�޸Ĺ���Ա����Ϣ
		
		
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
		//��������Ա
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
		//ɾ������Ա
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		Manager m = ms.findOneManager("from Manager where id="+ id);
		ms.deleteManager(m);
		return "loadManagerSet";
	}

}
