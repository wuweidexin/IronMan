package com.cissst.action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.cissst.entity.TbClasses;
import com.cissst.entity.TbExamPlan;
import com.cissst.entity.TbExamScheme;
import com.cissst.entity.TbExamSchemeDetail;
import com.cissst.entity.TbProblem;
import com.cissst.entity.TbTactics;
import com.cissst.entity.TbTacticsDetail;
import com.cissst.service.ExamPlanService;
import com.cissst.utils.NumberUtil;
import com.cissst.utils.Pager;
import com.cissst.utils.PagerHelper;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @模块名称：ExamPlanAction(考试计划)
 * @开发人：史小兵
 * @功          能：
 * @开发时间：
 */
public class ExamPlanAction extends  ActionSupport
{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final String HQL = null;
	private ExamPlanService EPService;
	private NumberUtil numberUtil;
	

	public ExamPlanService getEPService()
	{
		return EPService;
	}

	public void setEPService(ExamPlanService ePService)
	{
		EPService = ePService;
	}

	/**
	 * 考试计划新增
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String examProjectAdd(){
		//班级名称下拉列表
		List classesname=EPService.selectClassName();
		ServletActionContext.getRequest().setAttribute("classesname", classesname);
		//考试方案名称下拉列表
		List examschemename= EPService.selectExamSchemeName();
		ServletActionContext.getRequest().setAttribute("examschemename", examschemename);
		return "examprojectadd";
	}
	/**
	 * 考试计划新增————保存按钮
	 */
	public String examPlanAddSave(){
		TbExamPlan plan=new TbExamPlan();
		@SuppressWarnings("unused")
		TbClasses classes=new TbClasses();
		@SuppressWarnings("unused")
		TbExamScheme scheme=new TbExamScheme();
		//
		
		//
		String planName=ServletActionContext.getRequest().getParameter("planName");
		plan.setPlanName(planName);
		//
		String txtAddress=ServletActionContext.getRequest().getParameter("txtAddress");
		plan.setPlanDescribe(txtAddress);
		//
		int CId=Integer.valueOf(ServletActionContext.getRequest().getParameter("classesName"));
		TbClasses cla = EPService.findclaID(CId);
		
		plan.setTbClasses(cla);
		
		String planId = numberUtil.getExamPlanNo(cla.getCNum());
		plan.setEpMyselfId(planId);
		//
		String examTimeStart=ServletActionContext.getRequest().getParameter("examTimeStart");
		plan.setPlanStartTime(examTimeStart);
		//
		String examTimeEnd=ServletActionContext.getRequest().getParameter("examTimeEnd");
		plan.setPlanEndTime(examTimeEnd);
		//
		int esId=Integer.valueOf(ServletActionContext.getRequest().getParameter("examSchemeName"));
		plan.setTbExamScheme(EPService.findschID(esId));
		//
		String readOverTime=ServletActionContext.getRequest().getParameter("readOverTime");
		plan.setPlanReadOverTime(readOverTime);
		//
		String readerName=ServletActionContext.getRequest().getParameter("readerName");
		plan.setCol3(readerName);
		
		//设置计划状态
		plan.setTbPlanStatus(EPService.getStatus("未发布"));
		
		//
		plan.setPlanDel("0");
		EPService.examPlanAddSaveButton(plan);
        ServletActionContext.getRequest().setAttribute("plan",plan);
		return "examprojectadd";
	}
	/**
	 * 考试计划新增————删除按钮
	 */
	public String examProjectAdddelete(){
		int planId=Integer.valueOf(ServletActionContext.getRequest().getParameter("planId"));
		TbExamPlan plan=EPService.loginExamPlan(planId);
		plan.setPlanDel("1");
		return examProjectAdd();
	}
	/**
	 * 试卷预览
	 */
	@SuppressWarnings("unchecked")
	public String examPage(){
		List<TbTacticsDetail> list = new ArrayList<TbTacticsDetail>();
		int examSchemeName = Integer.valueOf(ServletActionContext.getRequest().getParameter("examSchemeName"));
		TbExamScheme examScheme = EPService.getTbExamScheme(examSchemeName);
		Set<TbExamSchemeDetail> esdSet = examScheme.getTbExamSchemeDetails();
		for (TbExamSchemeDetail esd : esdSet) {
			TbTactics tactics = esd.getTbTactics();
			Set<TbTacticsDetail> tdSet = tactics.getTbTacticsDetails();
			Iterator<TbTacticsDetail> tdIter= tdSet.iterator();
			while(tdIter.hasNext())
			{
				TbTacticsDetail detail =tdIter.next();
				list.add(detail);
			}
		}
		ServletActionContext.getRequest().setAttribute("list", list);
		ServletActionContext.getRequest().setAttribute("problemNum", list.size());
		ServletActionContext.getRequest().setAttribute("esId", examSchemeName);
		return "exam";	
	}
	/**
	 * 试题答案查询
	 * @return
	 */
	public String exam(){
		List<?> list=EPService.findTbProblemResult();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "examPage";	
	}
	//-------------------------------------------------------------------------------------------------------------//
	/**
	 * 考试计划查询
	 */
	@SuppressWarnings("unchecked")
	public String examProjectQuery(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String newHQL = (String) ServletActionContext.getRequest().getParameter("newHQL");
		String HQL = null;
		//当newHQL为不为null时，表明是新的查询，从新拼写SQL
		if(newHQL != null) {
			HQL=EPService.findWithQueryPage(request);
		} else {
			HQL = (String) request.getSession().getAttribute("HQL");
		}

		int totalRows=EPService.getRows(HQL);

		//将总页数及当前页数发往前台
		Pager pager = PagerHelper.getPager(ServletActionContext.getRequest(), totalRows);
		ServletActionContext.getRequest().setAttribute("totalPages", pager.getTotalPages());
		ServletActionContext.getRequest().setAttribute("currentPage", pager.getCurrentPage());

		//批阅方式
		List readtype=EPService.selectReadType();
		ServletActionContext.getRequest().setAttribute("readtype", readtype);

		//考试计划状态
		List examplanstatus=EPService.selectExamPlanStatus();
		ServletActionContext.getRequest().setAttribute("examplanstatus", examplanstatus);

		//
		List list=EPService.findWithPage(pager, HQL);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "examprojectquery";
	}
	/**
	 * 考试计划查询---考试计划编号链接
	 * @return
	 */
	public String examPlanQueryNum(){
		//考试计划维护————班级名称
		List<?> className=EPService.selectClassName();
		ServletActionContext.getRequest().setAttribute("cla", className);

		//考试计划维护————考试方案名称
		List<?> examSchemeName=EPService.selectExamSchemeName();
		ServletActionContext.getRequest().setAttribute("sch", examSchemeName);
		
		//考试计划维护————批阅方式
		List<?> readType=EPService.selectReadType();
		ServletActionContext.getRequest().setAttribute("readType", readType);
		
		int epqn=Integer.valueOf(ServletActionContext.getRequest().getParameter("epqn"));
		TbExamPlan pq=EPService.loginExamPlan(epqn);
		ServletActionContext.getRequest().getSession().setAttribute("pq", pq);
		return "examplanquerynum";
	}
	/**
	 * 考试计划维护————删除按钮
	 */
	public String examPlanQuerydelete(){
		TbExamPlan pl=(TbExamPlan) ServletActionContext.getRequest().getSession().getAttribute("pq");
		pl.setPlanDel("1");
		EPService.examPlanUpdate(pl);
		ServletActionContext.getRequest().setAttribute("list", null);
		return examProjectQuery();
	}
	/**
	 * 考试计划维护————保存按钮
	 */
	public String examPlanQuerySave(){
		int planId=Integer.valueOf(ServletActionContext.getRequest().getParameter("planId"));
		TbExamPlan plan=EPService.loginExamPlan(planId);
		//考试计划描述
		String txtAddress=ServletActionContext.getRequest().getParameter("txtAddress");
		plan.setPlanDescribe(txtAddress);

		//考试计划名称
		String planName=ServletActionContext.getRequest().getParameter("planName");
		plan.setPlanName(planName);

		//班级名称
		int CId=Integer.valueOf(ServletActionContext.getRequest().getParameter("className"));
		plan.setTbClasses(EPService.findclaID(CId));

		//考试开始时间
		String startTime=ServletActionContext.getRequest().getParameter("startTime");
		plan.setPlanStartTime(startTime);

		//考试结束时间
		String endTime=ServletActionContext.getRequest().getParameter("endTime");
		plan.setPlanEndTime(endTime);

		//考试方案名称
		int esId=Integer.valueOf(ServletActionContext.getRequest().getParameter("examSchemeName"));
		plan.setTbExamScheme(EPService.findschID(esId));

		//批阅截止时间
		String readOverTime=ServletActionContext.getRequest().getParameter("readOverTime");
		plan.setPlanReadOverTime(readOverTime);

		//批阅方式
		int readType=Integer.valueOf(ServletActionContext.getRequest().getParameter("readType"));
		plan.setTbReadType(EPService.loginReadType(readType));

		//批阅人
		String reader=ServletActionContext.getRequest().getParameter("reader");
		plan.setCol3(reader);

		//
		EPService.examPlanUpdate(plan);

		return "examplanquerynum";
	}
	/**
	 * 考试计划维护————提交按钮
	 */
	public String examPlanQueryIssue(){
		return examProjectQuery();
	}
	/**
	 * 考试计划发布
	 * @return
	 */
	public String examProjectIssue(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String newHQL = (String) ServletActionContext.getRequest().getParameter("newHQL");
		String HQL = null;
		//当newHQL为不为null时，表明是新的查询，从新拼写SQL
		if(newHQL != null) {
			HQL=EPService.findWithQueryPage(request);
		} else {
			HQL = (String) request.getSession().getAttribute("HQL");
		}

		int totalRows=EPService.getRows(HQL);

		//将总页数及当前页数发往前台
		Pager pager = PagerHelper.getPager(ServletActionContext.getRequest(), totalRows);
		ServletActionContext.getRequest().setAttribute("totalPages", pager.getTotalPages());
		ServletActionContext.getRequest().setAttribute("currentPage", pager.getCurrentPage());


		//批阅方式
		List<?> readType=EPService.selectReadType();
		ServletActionContext.getRequest().setAttribute("readType", readType);

		//
		List<?> list=EPService.findWithPage(pager, HQL);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "examprojectissue";

	}

	/**
	 * 考试计划撤销
	 * @return
	 */
	public String examProjectCancel(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String newHQL = (String) ServletActionContext.getRequest().getParameter("newHQL");
		String HQL = null;
		//当newHQL为不为null时，表明是新的查询，从新拼写SQL
		if(newHQL != null) {
			HQL=EPService.findWithQueryPage(request);
		} else {
			HQL = (String) request.getSession().getAttribute("HQL");
		}

		int totalRows=EPService.getRows(HQL);

		//将总页数及当前页数发往前台
		Pager pager = PagerHelper.getPager(ServletActionContext.getRequest(), totalRows);
		ServletActionContext.getRequest().setAttribute("totalPages", pager.getTotalPages());
		ServletActionContext.getRequest().setAttribute("currentPage", pager.getCurrentPage());


		//批阅方式
		List<?> readType=EPService.selectReadType();
		ServletActionContext.getRequest().setAttribute("readType", readType);

		//
		List<?> list=EPService.findWithPage(pager, HQL);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "examprojectcancel";
	}


	/**
	 *班级编号连接
	 * @return
	 */
	public String classNumQuery(){
		String classNum = ServletActionContext.getRequest().getParameter("classNum");
		TbClasses classnum= EPService.loginClassNum(classNum);
		ServletActionContext.getRequest().setAttribute("classnum", classnum);
		return "classnumquery";		
	}

	/**
	 * 考试方案名称链接
	 */
	public String examSchemeNameQuery(){
		//
		String examSchemeNum=ServletActionContext.getRequest().getParameter("examSchemeNum");
		TbExamScheme esn=EPService.loginExamSchemeName(examSchemeNum);
		ServletActionContext.getRequest().setAttribute("esn", esn);
		//
		List<?> list=EPService.findWithProblemPage(0, 5);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "examschemenamequery";

	}

	/**
	 * 序号链接
	 */
	public String number(){
		int id=Integer.valueOf(ServletActionContext.getRequest().getParameter("id"));
		TbProblem pro=EPService.loginProblem(id);
		ServletActionContext.getRequest().setAttribute("pro", pro);

		List<?> list=EPService.findWithProblemPage(0, 10);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "number";

	}

	/**
	 * 题目编号链接
	 * @return
	 */
	public String problemNum(){
		int pn=Integer.valueOf(ServletActionContext.getRequest().getParameter("pn"));
		TbProblem pro=EPService.loginProblem(pn);
		ServletActionContext.getRequest().setAttribute("pro", pro);

		return "problemNum";
	}

	/**
	 * 考试计划撤消---考试计划编号链接
	 * @return
	 */
	public String examPlanCancelNum(){
		int epcn=Integer.valueOf(ServletActionContext.getRequest().getParameter("epcn"));
		TbExamPlan pn=EPService.loginExamPlan(epcn);
		ServletActionContext.getRequest().getSession().setAttribute("pn", pn);
		return "examplancancelnum";	
	}

	/**
	 * 计划撤消返回函数
	 */
	public String examPlanCanelBack(){
		TbExamPlan epcb=(TbExamPlan) ServletActionContext.getRequest().getSession().getAttribute("pn");
		epcb.setPlanDel("1");
		EPService.examPlanUpdate(epcb);
		ServletActionContext.getRequest().setAttribute("list", null);
		return examProjectCancel();

	}

	/**
	 * 考试计划发布---考试计划编号链接
	 * @return
	 */
	public String examPlanIssueNum(){
		int epin=Integer.valueOf(ServletActionContext.getRequest().getParameter("epin"));
		TbExamPlan pi=EPService.loginExamPlan(epin);
		ServletActionContext.getRequest().setAttribute("pi", pi);
		return "examplanissuenum";

	}

	/**
	 * 考试计划发布函数
	 * @return
	 */
	public String examPlanIssueIssue(){
		return examProjectIssue();
	}

	/**
	 * 
	 */
	public String examProjectQuery3(){
		int planId=Integer.valueOf(ServletActionContext.getRequest().getParameter("planId"));
		TbExamPlan plan=EPService.loginExamPlan(planId);
		ServletActionContext.getRequest().setAttribute("plan", plan);
		return "examProjectQuery3";
	}
	/**
	 * 
	 */
	public String examProjectIssue3(){
		int esId=Integer.valueOf(ServletActionContext.getRequest().getParameter("esId"));
		TbExamScheme scheme=EPService.findschID(esId);
		TbExamSchemeDetail schemeDetail=EPService.loginSchemeDetail(scheme);
		ServletActionContext.getRequest().setAttribute("schemeDetail", schemeDetail);
		return "examProjectIssue3";
	}

	



	public NumberUtil getNumberUtil() {
		return numberUtil;
	}

	public void setNumberUtil(NumberUtil numberUtil) {
		this.numberUtil = numberUtil;
	}

	
}