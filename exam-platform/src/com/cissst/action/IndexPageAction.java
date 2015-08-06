package com.cissst.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.cissst.entity.TbExamPlan;
import com.cissst.entity.TbExamScheme;
import com.cissst.entity.TbProblem;
import com.cissst.entity.TbUser;
import com.cissst.iService.IndexPageServiceImp;
import com.cissst.service.IndexPageService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @模块名称：IndexPageAction(首页)
 * @开发人：陈俊全
 * @功          能：登陆，权限分配
 * @开发时间：
 */
@SuppressWarnings("unchecked")
public class IndexPageAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private IndexPageService IPService;
	private TbUser user;
	

	//每个登录者都有自己的sessionId，用来验证用户的重复登录及session的有效性
	private Map<Integer, String> sessionId;


	//管理员的登陆界面
	public String sLogin()
	{
		
		String logingSessionId = ServletActionContext.getRequest().getSession().getId();
		if("".equals(logingSessionId)||logingSessionId==null){
			ServletActionContext.getRequest().setAttribute("errorMsg", "服务器内部错误，请刷新该页面重新登录！");
			return "backIndexByError";
		}
		
		String s = IPService.checkLogin(user);
		if(s.equals("SUCCESS"))
		{
			TbUser loginUser = (TbUser) ServletActionContext.getRequest().getSession().getAttribute("user");
			sessionId.put(loginUser.getUId(),logingSessionId);
			
			//每个用户对应一个自己的sessionId，如果有人重复登录，会改变该账号的sessionId，导致同一个账户下的别的用户不可以使用！ 
			ActionContext.getContext().getSession().put("loginUser", loginUser);
			ActionContext.getContext().getSession().put("sessionId", sessionId);
			ActionContext.getContext().getSession().put("loginUserId", loginUser.getUId());
			ActionContext.getContext().getSession().put(logingSessionId, logingSessionId);
			/*ActionContext.getContext().getSession().put("IPService", IPService);
*/			
		
			//设置用户上次登录时间
			SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
			loginUser.setULastLoginTime(fmt.format(new Date()));
			IPService.updateObject(loginUser);
			//根据不同的用户类型，跳转到不同页面
			if("管理员".equals(loginUser.getTbUserType().getUtName())){//管理员
				ServletActionContext.getRequest().setAttribute("userPrivilege",2);
				return indexPage();
			}else if("教务主任".equals(loginUser.getTbUserType().getUtName())){
				ServletActionContext.getRequest().setAttribute("userPrivilege",5);
				return jwzrFindProblem();
			}else if("班主任".equals(loginUser.getTbUserType().getUtName())){
				ServletActionContext.getRequest().setAttribute("userPrivilege",4);
				return bzrFindEP();
			}else if("讲师".equals(loginUser.getTbUserType().getUtName())){
				ServletActionContext.getRequest().setAttribute("userPrivilege",3);
				return teacherFind();
			}else if("一般用户".equals(loginUser.getTbUserType().getUtName())){
				ServletActionContext.getRequest().setAttribute("userPrivilege",6);
				return userFind();
			}else
			{
				return null;
			}
		}
		else
		{
			return s;
		}
		//把sessionId放在map中,每个用户id对应一个最新的
	
		
		
		
	}
	//首页按钮
	public String indexPage()
	{
		List<TbUser> list = (List<TbUser>) IPService.findWithPage("TbUser", "UDel", null);
		ServletActionContext.getRequest().setAttribute("user", 
				ServletActionContext.getRequest().getSession().getAttribute("user"));
		ServletActionContext.getRequest().setAttribute("list", list);
		return "SUCCESS";
	}
	
	//教务主任主界面
	@SuppressWarnings("unchecked")
	public String jwzrFindProblem()
	{
		List<TbProblem> listPro = (List<TbProblem>) IPService.findWithPage("TbProblem", "PDel", null);
		List<TbExamScheme> listExaS = (List<TbExamScheme>) IPService.findWithPage("TbExamScheme", "esDel", null);

		ServletActionContext.getRequest().setAttribute("user", 
				ServletActionContext.getRequest().getSession().getAttribute("user"));
		ServletActionContext.getRequest().setAttribute("listPro", listPro);
		ServletActionContext.getRequest().setAttribute("listExaS", listExaS);
		//ServletActionContext.getRequest().setAttribute("m", m);
		
		return "JIAOWUZHUREN";
	}
	
	//班主任界面,查找考试计划表
	public String bzrFindEP()
	{
		List<TbExamPlan> list = (List<TbExamPlan>) IPService.findWithPage("TbExamPlan", "planDel", null);
		
		ServletActionContext.getRequest().setAttribute("user", 
				ServletActionContext.getRequest().getSession().getAttribute("user"));
		ServletActionContext.getRequest().setAttribute("list", list);
		return "BANZHUREN";
	}
	//老师界面设计，查找考试计划，以及题目表
	
	public String teacherFind()
	{
		List<TbExamPlan> list = (List<TbExamPlan>) IPService.findWithPage("TbExamPlan", "planDel", null);
		List<TbProblem> listPro = (List<TbProblem>) IPService.findWithPage("TbProblem", "PDel", null);
		ServletActionContext.getRequest().setAttribute("user", 
				ServletActionContext.getRequest().getSession().getAttribute("user"));
		ServletActionContext.getRequest().setAttribute("list", list);
		ServletActionContext.getRequest().setAttribute("listPro", listPro);
		return "TEACHER";
	}
	//一般用户登入界面
	public String userFind()
	{
		ServletActionContext.getRequest().setAttribute("user", 
				ServletActionContext.getRequest().getSession().getAttribute("user"));
		return "YIBANHONGHU";
	}
	
	//推出登陆
	public String exitSystem()
	{
		TbUser loginUser=(TbUser) ActionContext.getContext().getSession().get("loginUser");
		
		if(loginUser!=null){//管理员退出
			//旧的sessionID
			String oldSessionId=(String) ActionContext.getContext().getSession().get(ServletActionContext.getRequest().getSession().getId());
			//新的sessionID
			String newSessionId=((Map<Integer, String>)ActionContext.getContext().getSession().get("sessionId")).get(loginUser.getUId());
			if(oldSessionId==newSessionId){
				sessionId.remove(loginUser.getUId());
			}
		}
		return "TOLOGIN";
	}
	
	//修改密码
	public String toResetPwd()
	{
		TbUser user = (TbUser) ServletActionContext.getRequest().getSession().getAttribute("user");
		ServletActionContext.getRequest().setAttribute("user", user);
		return "TORESETPWD";
	}
	public String resetPwd()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("u_id"));
		user.setUId(id);
		TbUser userPwd = IPService.findUser(id);
		userPwd.setUPwd(request.getParameter("password"));
		IPService.updateObject(userPwd);
		return this.exitSystem();
	}
	
	
	
	public IndexPageService getIPService()
	{
		return IPService;
	}

	public void setIPService(IndexPageService iPService)
	{
		IPService = iPService;
	}
	public TbUser getUser() {
		return user;
	}
	public void setUser(TbUser user) {
		this.user = user;
	}
	public Map<Integer, String> getSessionId() {
		return sessionId;
	}
	public void setSessionId(Map<Integer, String> sessionId) {
		this.sessionId = sessionId;
	}
}
