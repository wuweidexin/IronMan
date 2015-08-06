package com.cissst.utils;

import java.util.Map;
import java.util.ResourceBundle;

import org.apache.struts2.ServletActionContext;

import com.cissst.action.IndexPageAction;
import com.cissst.entity.TbUser;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class InterceptUtil extends AbstractInterceptor{

	public static ResourceBundle yibanyonghu =ResourceBundle.getBundle("yibanyonghu");
	public static ResourceBundle jiaowuzhuren =ResourceBundle.getBundle("jiaowuzhuren");
	public static ResourceBundle jiangshi =ResourceBundle.getBundle("jiangshi");
	public static ResourceBundle banzhuren =ResourceBundle.getBundle("banzhuren");
	public static ResourceBundle administrator=ResourceBundle.getBundle("administrator");

	public IndexPageAction indexPageAction;

	@SuppressWarnings("unchecked")
	public String intercept(ActionInvocation invocation) throws Exception{


		//��ȡurl��ַ
		String url=ServletActionContext.getRequest().getRequestURI().toString();
		TbUser loginUser = (TbUser) ServletActionContext.getRequest().getSession().getAttribute("user");
		if("/exam-platform/indexPageAction!sLogin".equals(url)||
				"/exam-platform/indexPageAction!exitSystem".equals(url)||
				"/exam-platform/indexPageAction!toResetPwd".equals(url))
		{
			if(loginUser!=null){//����Ȩ��λ
				String userPrivilege=loginUser.getTbUserType().getUtName();
				if("��ʦ".equals(userPrivilege)){
					ServletActionContext.getRequest().setAttribute("userPrivilege",3);
				}else if("������".equals(userPrivilege)){
					ServletActionContext.getRequest().setAttribute("userPrivilege",4);
				}else if("��������".equals(userPrivilege)){
					ServletActionContext.getRequest().setAttribute("userPrivilege",5);
				}else if("һ���û�".equals(userPrivilege)){
					ServletActionContext.getRequest().setAttribute("userPrivilege",6);
				}else if("����Ա".equals(userPrivilege)){
					ServletActionContext.getRequest().setAttribute("userPrivilege",2);
				}
			}
			return invocation.invoke();//���ص����ַ���
		}

		//��֤session����Ч��

		if(loginUser == null)
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "������δ�����ѱ�ע��,�����µ�¼!");
			return "TOLOGIN";
		}

		String sessionOld = (String) ActionContext.getContext().getSession().get(ServletActionContext.getRequest().getSession().getId());

		String sessionNew = ((Map<Integer, String>)ActionContext.getContext().getSession().get("sessionId")).get(loginUser.getUId());

		if(sessionOld==null||sessionNew==null||"".equals(sessionOld)||"".endsWith(sessionNew)){
			return "TOLOGIN";
		}
		if(sessionNew!=sessionOld){
			ServletActionContext.getRequest().setAttribute("errorMsg", "�����˺��ڱ𴦵�¼,�����µ�¼!");
			return "TOLOGIN";
		}


		//Ȩ����֤
		String userType = loginUser.getTbUserType().getUtName();
		String newURL=url.substring(url.lastIndexOf('/')+1).trim();
		
		System.out.println("**************************************"+newURL);
		if("��������".equals(userType))
		{
			if(jiaowuzhuren.containsKey(newURL)){

				ServletActionContext.getRequest().setAttribute("userPrivilege",5);
				return invocation.invoke();
			}
		}else if("��ʦ".equals(userType))
		{
			if(jiangshi.containsKey(newURL)){

				ServletActionContext.getRequest().setAttribute("userPrivilege",3);
				return invocation.invoke();
			}
		}else if("������".equals(userType))
		{
			if(banzhuren.containsKey(newURL)){

				ServletActionContext.getRequest().setAttribute("userPrivilege",4);
				return invocation.invoke();
			}
		}else if("һ���û�".equals(userType))
		{
			if(yibanyonghu.containsKey(newURL)){

				ServletActionContext.getRequest().setAttribute("userPrivilege",6);
				return invocation.invoke();
			}
		}else if("����Ա".equals(userType))
		{
			if(administrator.containsKey(newURL)){

				ServletActionContext.getRequest().setAttribute("userPrivilege",2);
				return invocation.invoke();
			}
		}
		return "noPrivilege";
	}
	
	public IndexPageAction getIndexPageAction() {
		return indexPageAction;
	}
	public void setIndexPageAction(IndexPageAction indexPageAction) {
		this.indexPageAction = indexPageAction;
	}
}
