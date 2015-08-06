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


		//获取url地址
		String url=ServletActionContext.getRequest().getRequestURI().toString();
		TbUser loginUser = (TbUser) ServletActionContext.getRequest().getSession().getAttribute("user");
		if("/exam-platform/indexPageAction!sLogin".equals(url)||
				"/exam-platform/indexPageAction!exitSystem".equals(url)||
				"/exam-platform/indexPageAction!toResetPwd".equals(url))
		{
			if(loginUser!=null){//设置权限位
				String userPrivilege=loginUser.getTbUserType().getUtName();
				if("讲师".equals(userPrivilege)){
					ServletActionContext.getRequest().setAttribute("userPrivilege",3);
				}else if("班主任".equals(userPrivilege)){
					ServletActionContext.getRequest().setAttribute("userPrivilege",4);
				}else if("教务主任".equals(userPrivilege)){
					ServletActionContext.getRequest().setAttribute("userPrivilege",5);
				}else if("一般用户".equals(userPrivilege)){
					ServletActionContext.getRequest().setAttribute("userPrivilege",6);
				}else if("管理员".equals(userPrivilege)){
					ServletActionContext.getRequest().setAttribute("userPrivilege",2);
				}
			}
			return invocation.invoke();//返回的是字符串
		}

		//验证session的有效性

		if(loginUser == null)
		{
			ServletActionContext.getRequest().setAttribute("errorMsg", "您长期未操作已被注销,请重新登录!");
			return "TOLOGIN";
		}

		String sessionOld = (String) ActionContext.getContext().getSession().get(ServletActionContext.getRequest().getSession().getId());

		String sessionNew = ((Map<Integer, String>)ActionContext.getContext().getSession().get("sessionId")).get(loginUser.getUId());

		if(sessionOld==null||sessionNew==null||"".equals(sessionOld)||"".endsWith(sessionNew)){
			return "TOLOGIN";
		}
		if(sessionNew!=sessionOld){
			ServletActionContext.getRequest().setAttribute("errorMsg", "您的账号在别处登录,请重新登录!");
			return "TOLOGIN";
		}


		//权限验证
		String userType = loginUser.getTbUserType().getUtName();
		String newURL=url.substring(url.lastIndexOf('/')+1).trim();
		
		System.out.println("**************************************"+newURL);
		if("教务主任".equals(userType))
		{
			if(jiaowuzhuren.containsKey(newURL)){

				ServletActionContext.getRequest().setAttribute("userPrivilege",5);
				return invocation.invoke();
			}
		}else if("讲师".equals(userType))
		{
			if(jiangshi.containsKey(newURL)){

				ServletActionContext.getRequest().setAttribute("userPrivilege",3);
				return invocation.invoke();
			}
		}else if("班主任".equals(userType))
		{
			if(banzhuren.containsKey(newURL)){

				ServletActionContext.getRequest().setAttribute("userPrivilege",4);
				return invocation.invoke();
			}
		}else if("一般用户".equals(userType))
		{
			if(yibanyonghu.containsKey(newURL)){

				ServletActionContext.getRequest().setAttribute("userPrivilege",6);
				return invocation.invoke();
			}
		}else if("管理员".equals(userType))
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
