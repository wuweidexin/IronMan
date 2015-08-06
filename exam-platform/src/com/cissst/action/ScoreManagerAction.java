package com.cissst.action;
import java.awt.print.Paper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.jboss.cache.eviction.BaseSortedEvictionAlgorithm;

import com.cissst.entity.TbClasses;
import com.cissst.entity.TbExamPaper;
import com.cissst.entity.TbExamPaperAnswer;
import com.cissst.entity.TbExamPlan;
import com.cissst.entity.TbStudent;
import com.cissst.entity.TbUser;
import com.cissst.service.ScoreManagerService;
import com.cissst.utils.Pager;
import com.cissst.utils.PagerHelper;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @模块名称：ScoreManagerAction(成绩管理)
 * @开发人：党智勇
 * @功          能：
 * @开发时间：
 */
public class ScoreManagerAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	//调用业务逻辑层
	private ScoreManagerService SMService;
	private TbExamPaper  tbExamPaper;
	private TbExamPlan examPlan ;
	private TbExamPaperAnswer paperAnswer;
	//实现get/set方法
	public TbExamPaperAnswer getPaperAnswer() {
		return paperAnswer;
	}

	public void setPaperAnswer(TbExamPaperAnswer paperAnswer) {
		this.paperAnswer = paperAnswer;
	}

	public TbExamPlan getExamPlan() {
		return examPlan;
	}

	public void setExamPlan(TbExamPlan examPlan) {
		this.examPlan = examPlan;
	}

	public TbExamPaper getTbExamPaper() {
		return tbExamPaper;
	}

	public void setTbExamPaper(TbExamPaper tbExamPaper) {
		this.tbExamPaper = tbExamPaper;
	}
	public ScoreManagerService getSMService()
	{
		return SMService;
	}

	public void setSMService(ScoreManagerService sMService)
	{
		SMService = sMService;
	}

	
	/**
	 * @模块名称：成绩查询
	 * @开发人：党智勇
	 * @功          能：实现查询所有开始计划的查询
	 * @开发时间：
	 */
	public String gradeQuery(){
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String newHQL=request.getParameter("newHQL");
		String HQL=null;
		if(newHQL!=null){
			HQL=SMService.joinHql();
		}else{
			 HQL=(String) request.getSession().getAttribute("builderHQL");
		}
		//根据HQL得到总行数
		int totalRows=SMService.getRows(HQL);
		//拿到一个pager对象
		Pager pager=PagerHelper.getPager(request, totalRows);
		request.setAttribute("totalPage", pager.getTotalPages());
		request.setAttribute("currentPage",pager.getCurrentPage());
		
		List<TbExamPlan> gradeQueryList=SMService.gradeQuery(pager.getStartRow(),pager.getPageSize(),HQL);
		request.setAttribute("gradeQueryList", gradeQueryList);
		return "gradeQuery";
	}
	/**
	 * @模块名称：成绩查询
	 * @开发人：党智勇
	 * @功          能：实现查询一个学生成绩功能
	 * @开发时间：
	 */
	public String findOneScore(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int id=Integer.valueOf(request.getParameter("c_id"));
         System.out.println("~~~~~~~"+id);
		 examPlan=SMService.findPlan(id);
		request.setAttribute("examPlan", examPlan);
		
//		Set<TbExamPaper> paperSet=new HashSet<TbExamPaper>();
//		paperSet=examPlan.getTbExamPapers();
//		Iterator<TbExamPaper> it=paperSet.iterator();
//		List<TbExamPaper> paperList=new ArrayList<TbExamPaper>();
//		while(it.hasNext()){
//			TbExamPaper paper=new TbExamPaper();
//			paper=it.next();
//			paperList.add(paper);
//			request.setAttribute("paperList", paperList);
//		}
		return "gradeQuery2";
	}
	
	/**
	 * @模块名称：成绩发布
	 * @开发人：党智勇
	 * @功          能：实现查询一个学生成绩功能
	 * @开发时间：
	 */
	public String gradeIssue(){
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String newHQL=request.getParameter("newHQL");
		String HQL=null;
		if(newHQL!=null&&newHQL!=""){
			HQL=SMService.joinHql();
		}else{
			 HQL=(String) request.getSession().getAttribute("builderHQL");

		}
		//根据HQL得到总行数
		int totalRows=SMService.getRows(HQL);
		//拿到一个pager对象
		Pager pager=PagerHelper.getPager(request, totalRows);
		request.setAttribute("totalPage", pager.getTotalPages());
		request.setAttribute("currentPage",pager.getCurrentPage());
		
		List<TbExamPlan> gradeIssueList=SMService.gradeIssue(pager.getStartRow(), pager.getPageSize(),HQL);
		request.setAttribute("gradeIssueList", gradeIssueList);
		return "gradeIssue";
	}
	/**
	 * @模块名称：成绩发布
	 * @开发人：党智勇
	 * @功          能：查询考试发布中一个考试计划
	 * @开发时间：
	 */
	@SuppressWarnings("unchecked")
	public String gradeIssueOne(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int id=Integer.valueOf(request.getParameter("issueId"));
		
		TbExamPlan examPlanIssue=SMService.findPlan(id);
		TbClasses classes=examPlanIssue.getTbClasses();
		Set<TbStudent> stuSet=classes.getTbStudents();
		int stuTotal=stuSet.size();
		request.setAttribute("stuTotal", stuTotal);
		request.setAttribute("examPlanIssue", examPlanIssue);
		return "gradeIssue1";
	}
	
	/**
	 * @模块名称：成绩发布
	 * @开发人：党智勇
	 * @功          能：查询考试发布中一个考试计划
	 * @开发时间：
	 */
	public String issue(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int id=Integer.valueOf(request.getParameter("pId"));
		TbExamPlan examPlan =SMService.findPlan(id);
		examPlan.setCol2("已发布");
		SMService.updatePlan(examPlan);
		return this.gradeIssueOne();
		
	}
	
	
	
	
	/**
	 * @模块名称：成绩批阅
	 * @开发人：党智勇
	 * @功          能：查询所有需要批阅的考试计划
	 * @开发时间：
	 */
	public String gradeCheck(){
        HttpServletRequest request=ServletActionContext.getRequest();
        //获得页面参数的值
        String newHQL=request.getParameter("newHQL");
        String HQL=null;
        //判断newHQL是否为空
        if(newHQL!=null){
        	HQL=SMService.joinHql();
        }else{
        	HQL=(String) request.getSession().getAttribute("builderHQL");
        }
        //根据HQL得到总行数
		int totalRows=SMService.getRows(HQL);
		//拿到一个pager对象
		Pager pager=PagerHelper.getPager(request, totalRows);
		//将总页数和当前页设到页面上
		request.setAttribute("totalPage", pager.getTotalPages());
		request.setAttribute("currentPage",pager.getCurrentPage());
		
		List<TbExamPlan> gradeChecklist=SMService.gradeCheck(pager.getStartRow(), pager.getPageSize(),HQL);
		request.setAttribute("gradeChecklist", gradeChecklist);
		return "gradeCheck";
	}
	/**
	 * @模块名称：成绩批阅
	 * @开发人：党智勇
	 * @功          能：根据id查询一个需要批阅的考试计划
	 * @开发时间：
	 */
	public String gradeCheckList(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int id=Integer.valueOf(request.getParameter("c_id1"));
		int totalRows=SMService.getRowsCheck(id);
		Pager pager=PagerHelper.getPager(request, totalRows);
		request.setAttribute("totalPage", pager.getTotalPages());
		request.setAttribute("currentPage", pager.getCurrentPage());
		
		
		TbExamPlan examPlanCheck=SMService.gradeCheckList(id);
		request.setAttribute("examPlanCheck", examPlanCheck);
		return "gradeCheckList";
	}
	/**
	 * @模块名称：成绩批阅
	 * @开发人：党智勇
	 * @功          能：根据id查询一个需要批阅的考试计划
	 * @开发时间：
	 */
	@SuppressWarnings("unchecked")
	public String gradeForCheck(){
		HttpServletRequest request=ServletActionContext.getRequest();
		//根据前一页的考试计划id查出考试计划
		int id=Integer.valueOf(request.getParameter("gradeForCheck"));
		 examPlan=SMService.gradeForCheck(id);
		 //将考试编号放到批阅的标题中
		 request.setAttribute("examPlan", examPlan);

         int paperId=Integer.valueOf(request.getParameter("paperId"));
         //拿到一张考卷
         tbExamPaper=SMService.checkPaper(paperId);
           Set answersSet=new HashSet();
           //取出paperAnswer集合
           answersSet=tbExamPaper.getTbExamPaperAnswers();
          request.setAttribute("answersSet",answersSet);
		return "gradeForCheck";
	}
	/**
	 * @模块名称：成绩批阅
	 * @开发人：党智勇
	 * @功          能：保存每道题成绩
	 * @开发时间：
	 */
	public String saveScore(){
		HttpServletRequest request=ServletActionContext.getRequest();
		//拿到老师打的分数
		String mark=request.getParameter("score");
		float mark1=Float.valueOf(mark);
		//拿到那份试卷id并查出来把分数更新进去
		int  id=Integer.valueOf(request.getParameter("answerId"));
		TbExamPaperAnswer paperAnswer=SMService.paperAnswer(id);
		paperAnswer.setEpaMark(mark1);
		SMService.saveScore(paperAnswer);
		//return "gradeForCheck";
		return this.gradeForCheck();
		
		
		
		
	}
	
	

}
