package com.cissst.iService;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.cissst.dao.ScoreManagerDao;
import com.cissst.entity.TbExamPaper;
import com.cissst.entity.TbExamPaperAnswer;
import com.cissst.entity.TbExamPlan;
import com.cissst.service.ScoreManagerService;
/**
 * @模块名称：ScoreManagerAction(成绩管理)
 * @开发人：
 * @功          能：管理ScoreManagerAction对数据库的所有操作
 * @开发时间：
 */
public class ScoreManagerServiceImp implements ScoreManagerService{
	//调用数据访问层
	private ScoreManagerDao scoreManagerDao;
    //实现get和set方法
	public ScoreManagerDao getScoreManagerDao()
	{
		return scoreManagerDao;
	}

	public void setScoreManagerDao(ScoreManagerDao scoreManagerDao)
	{
		this.scoreManagerDao = scoreManagerDao;
	}
	
	//分页中拿到考试计划的总行数
	public int getRows(String HQL) {	
		return scoreManagerDao.findList(HQL).size();
	}
//	public int getRows() {	
//		String HQL="select count(*) from TbExamPlan  where 1=1";
//		Object object=scoreManagerDao.getRows(HQL);
//		long tempNumber=(Long)object;
//		return (int)tempNumber;
//	}
	  //在成绩批阅中根据一个计划编号得到这个计划需要批阅的总行数
	public int getRowsCheck(int id) {
		HttpServletRequest request=ServletActionContext.getRequest();
		//TbExamPlan examPlanrequest.getParameter(name);
		String HQL="from TbExamPaper where tbExamPlan.planId="+id;
		System.out.println("&&&&"+HQL);
//		Object object=scoreManagerDao.getRows(HQL);
//		long tempNumber=(Long)object;
//		return (int)tempNumber;
		return   scoreManagerDao.findList(HQL).size();
	}
	//条件查询拼接HQL
	public String joinHql(){
		HttpServletRequest request=ServletActionContext.getRequest();
		StringBuilder builderHql=new StringBuilder("from TbExamPlan where 1=1 ");
		//考试计划编号
		String epMyselfId=request.getParameter("epMyselfId");
		if(epMyselfId!=null && epMyselfId!=""){
			builderHql.append(" and epMyselfId like '%"+epMyselfId+"%'");
		}
		//考试计划名称
		String planName=request.getParameter("planName");
		if(planName!=null && planName!=""){
			builderHql.append(" and planName like '%"+planName+"%'");
		}
		//考试计划描述
		String planDescribe=request.getParameter("planDescribe");
		if(planDescribe!=null && planDescribe!=""){
			builderHql.append(" and planDescribe like '%"+planDescribe+"%'");
		}
		//考试方案编号
		String esMyselfId=request.getParameter("esMyselfId");
		if(esMyselfId!=null && esMyselfId!=""){
			builderHql.append(" and tbExamScheme.esMyselfId like '%"+esMyselfId+"%'");
		}
		//批阅状态
		String rsName=request.getParameter("rsName");
		if(rsName!=null&&rsName!="" ){
			int tempt=Integer.valueOf(rsName);
			switch (tempt) {
			case 0: rsName=null;
			    break;
			case 1: rsName="未批阅";
				break;
			case 2: rsName="批阅中";
			     break;
			case 3: rsName="已批阅";
		     break;
			}
			}
		if(rsName!=null&&rsName!=""){
			builderHql.append(" and  tbReadStatus.rsName like '%"+rsName+"%' ");
		}
		//批阅类型
		String rtName=request.getParameter("rtName");
		
		if(rtName!=null&&rtName!="" ){
			int tempt=Integer.valueOf(rtName);
			System.out.println(tempt);
			switch (tempt) {
			case 0: rtName=null;
			    break;
			case 1: rtName="自动批阅";
				break;
			case 2: rtName="老师批阅";
			     break;
			}
			}
		if(rtName!=null && rtName!=""){
			builderHql.append(" and tbReadType.rtName like '%"+rtName+"%'");
		}
		//班级名称
		String CName=request.getParameter("CName");
		if(CName!=null&&CName!=""){
			builderHql.append(" and tbClasses.CName like '%"+CName+"%'");
		}
		//班级状态
		String csName=request.getParameter("csName");
		if(csName!=null&&csName!="" ){
			int tempt=Integer.valueOf(csName);
			switch (tempt) {
			case 0: csName=null;
			    break;
			case 1: csName="已开班";
				break;
			case 2: csName="已结业";
			     break;
			}
			}
		if(csName!=null&&csName!=""){
			builderHql.append(" and tbClasses.tbClazzStatus.csName like '%"+csName+"%'");
		}
		//考试开始时间
		String planStartTime=request.getParameter("planStartTime");
		if(planStartTime!=null&&planStartTime!=""){
			builderHql.append(" and planStartTime  > '"+planStartTime+"'");
		}
		//考试结束时间
		String planEndTime=request.getParameter("planEndTime");
		if(planEndTime!=null&&planEndTime!=""){
			builderHql.append(" and planEndTime < '"+planEndTime+"'");
		}
		builderHql.append(" and planDel=0");
		//转换成String类型
		String builderHQL=builderHql.toString();
		//set到session中
		request.getSession().setAttribute("builderHQL", builderHQL);
		System.out.println("HQL是："+builderHQL);
		return builderHQL;
	}
	/**
	 * @模块名称：成绩查询
	 * @开发人：党智勇
	 * @功          能：查询所有成绩
	 * @开发时间：
	 */
	@SuppressWarnings("unchecked")
	public List<TbExamPlan> gradeQuery(int startNumber,int pageSize,String HQL) {
		return (List<TbExamPlan>)scoreManagerDao.findWithPage(startNumber, pageSize, HQL);
	}


	//查出一个试计划的对象
	public TbExamPlan findPlan(int id){
		String HQL="from TbExamPlan where planId="+id;
		TbExamPlan TbExamPlan=(TbExamPlan)scoreManagerDao.findByHQL(HQL);
		System.out.println("HQL:"+HQL);
		return TbExamPlan;
	}
	/**
	 * @模块名称：成绩发布
	 * @开发人：党智勇
	 * @功          能：实现考试发布页面的总体查询
	 * @开发时间：
	 */
	@SuppressWarnings("unchecked")
	public List<TbExamPlan> gradeIssue(int startNumber,int pageSize,String HQL) {
		return (List<TbExamPlan>)scoreManagerDao.findWithPage(startNumber, pageSize, HQL);
	}
	/**
	 * @模块名称：成绩发布
	 * @开发人：党智勇
	 * @功          能：查询一个考试计划
	 * @开发时间：
	 */
	public TbExamPlan gradeIssueOne(String epMyselfId){
		String HQL="from TbExamPlan where epMyselfId="+epMyselfId;
		System.out.println(HQL);
		return (TbExamPlan) scoreManagerDao.findByHQL(HQL);
	}
	/**
	 * @模块名称：成绩批阅
	 * @开发人：党智勇
	 * @功          能：查询所有批阅项
	 * @开发时间：
	 */
	@SuppressWarnings("unchecked")
	public List<TbExamPlan> gradeCheck(int startNumber,int pageSize,String HQL) {
		
		return (List<TbExamPlan>)scoreManagerDao.findWithPage(startNumber, pageSize, HQL);
	}
	/**
	 * @模块名称：成绩批阅
	 * @开发人：党智勇
	 * @功          能：查询一个需要批阅的考试计划
	 * @开发时间：
	 */
	public TbExamPlan gradeCheckList(int id){
		String HQL="from TbExamPlan where planId="+id;
		return (TbExamPlan) scoreManagerDao.findByHQL(HQL);
		
	}
	/**
	 * @模块名称：成绩批阅
	 * @开发人：党智勇
	 * @功          能：根据考试计划id查询一份试卷
	 * @开发时间：
	 */
	public TbExamPlan gradeForCheck(int id){
		String HQL="from TbExamPlan   where  planId="+id;
		return (TbExamPlan) scoreManagerDao.findByHQL(HQL);
		
	}
	/**
	 * @模块名称：成绩批阅
	 * @开发人：党智勇
	 * @功          能：根据paper的id查询一份试卷
	 * @开发时间：
	 */
    public TbExamPaper checkPaper(int id){
		String HQL="from TbExamPaper where epId="+id;
    	return (TbExamPaper)scoreManagerDao.findByHQL(HQL);
    }
    /**
	 * @模块名称：成绩批阅
	 * @开发人：党智勇
	 * @功          能：根据id查询出一个试卷作答对象
	 * @开发时间：
	 */
	public TbExamPaperAnswer paperAnswer(int id) {
		String HQL="from TbExamPaperAnswer where epaId="+id;
		
		return (TbExamPaperAnswer) scoreManagerDao.findByHQL(HQL);
	}
	/**
	 * @模块名称：成绩批阅
	 * @开发人：党智勇
	 * @功          能：保存的成绩
	 * @开发时间：
	 */
    public void saveScore(TbExamPaperAnswer paperAnswer){
    	scoreManagerDao.update(paperAnswer);
    }


	/**
	 * @模块名称：成绩发布
	 * @开发人：党智勇
	 * @功          能：更新考试计划
	 * @开发时间：
	 */
	public void updatePlan(TbExamPlan examPlan){
		scoreManagerDao.update(examPlan);
	}

	
}
