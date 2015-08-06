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
 * @ģ�����ƣ�IndexPageAction(��ҳ)
 * @�����ˣ��¿�ȫ
 * @��          �ܣ���½��Ȩ�޷���
 * @����ʱ�䣺
 */
@SuppressWarnings("unchecked")
public class IndexPageAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private IndexPageService IPService;
	private TbUser user;
	

	//ÿ����¼�߶����Լ���sessionId��������֤�û����ظ���¼��session����Ч��
	private Map<Integer, String> sessionId;


	//����Ա�ĵ�½����
	public String sLogin()
	{
		
		String logingSessionId = ServletActionContext.getRequest().getSession().getId();
		if("".equals(logingSessionId)||logingSessionId==null){
			ServletActionContext.getRequest().setAttribute("errorMsg", "�������ڲ�������ˢ�¸�ҳ�����µ�¼��");
			return "backIndexByError";
		}
		
		String s = IPService.checkLogin(user);
		if(s.equals("SUCCESS"))
		{
			TbUser loginUser = (TbUser) ServletActionContext.getRequest().getSession().getAttribute("user");
			sessionId.put(loginUser.getUId(),logingSessionId);
			
			//ÿ���û���Ӧһ���Լ���sessionId����������ظ���¼����ı���˺ŵ�sessionId������ͬһ���˻��µı���û�������ʹ�ã� 
			ActionContext.getContext().getSession().put("loginUser", loginUser);
			ActionContext.getContext().getSession().put("sessionId", sessionId);
			ActionContext.getContext().getSession().put("loginUserId", loginUser.getUId());
			ActionContext.getContext().getSession().put(logingSessionId, logingSessionId);
			/*ActionContext.getContext().getSession().put("IPService", IPService);
*/			
		
			//�����û��ϴε�¼ʱ��
			SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
			loginUser.setULastLoginTime(fmt.format(new Date()));
			IPService.updateObject(loginUser);
			//���ݲ�ͬ���û����ͣ���ת����ͬҳ��
			if("����Ա".equals(loginUser.getTbUserType().getUtName())){//����Ա
				ServletActionContext.getRequest().setAttribute("userPrivilege",2);
				return indexPage();
			}else if("��������".equals(loginUser.getTbUserType().getUtName())){
				ServletActionContext.getRequest().setAttribute("userPrivilege",5);
				return jwzrFindProblem();
			}else if("������".equals(loginUser.getTbUserType().getUtName())){
				ServletActionContext.getRequest().setAttribute("userPrivilege",4);
				return bzrFindEP();
			}else if("��ʦ".equals(loginUser.getTbUserType().getUtName())){
				ServletActionContext.getRequest().setAttribute("userPrivilege",3);
				return teacherFind();
			}else if("һ���û�".equals(loginUser.getTbUserType().getUtName())){
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
		//��sessionId����map��,ÿ���û�id��Ӧһ�����µ�
	
		
		
		
	}
	//��ҳ��ť
	public String indexPage()
	{
		List<TbUser> list = (List<TbUser>) IPService.findWithPage("TbUser", "UDel", null);
		ServletActionContext.getRequest().setAttribute("user", 
				ServletActionContext.getRequest().getSession().getAttribute("user"));
		ServletActionContext.getRequest().setAttribute("list", list);
		return "SUCCESS";
	}
	
	//��������������
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
	
	//�����ν���,���ҿ��Լƻ���
	public String bzrFindEP()
	{
		List<TbExamPlan> list = (List<TbExamPlan>) IPService.findWithPage("TbExamPlan", "planDel", null);
		
		ServletActionContext.getRequest().setAttribute("user", 
				ServletActionContext.getRequest().getSession().getAttribute("user"));
		ServletActionContext.getRequest().setAttribute("list", list);
		return "BANZHUREN";
	}
	//��ʦ������ƣ����ҿ��Լƻ����Լ���Ŀ��
	
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
	//һ���û��������
	public String userFind()
	{
		ServletActionContext.getRequest().setAttribute("user", 
				ServletActionContext.getRequest().getSession().getAttribute("user"));
		return "YIBANHONGHU";
	}
	
	//�Ƴ���½
	public String exitSystem()
	{
		TbUser loginUser=(TbUser) ActionContext.getContext().getSession().get("loginUser");
		
		if(loginUser!=null){//����Ա�˳�
			//�ɵ�sessionID
			String oldSessionId=(String) ActionContext.getContext().getSession().get(ServletActionContext.getRequest().getSession().getId());
			//�µ�sessionID
			String newSessionId=((Map<Integer, String>)ActionContext.getContext().getSession().get("sessionId")).get(loginUser.getUId());
			if(oldSessionId==newSessionId){
				sessionId.remove(loginUser.getUId());
			}
		}
		return "TOLOGIN";
	}
	
	//�޸�����
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
