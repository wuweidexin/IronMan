package com.cissst.iService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.cissst.dao.ExamPlanDao;
import com.cissst.entity.TbClasses;
import com.cissst.entity.TbExamPlan;
import com.cissst.entity.TbExamScheme;
import com.cissst.entity.TbExamSchemeDetail;
import com.cissst.entity.TbPlanStatus;
import com.cissst.entity.TbProblem;
import com.cissst.entity.TbProblemResult;
import com.cissst.entity.TbReadType;
import com.cissst.service.ExamPlanService;
import com.cissst.utils.Pager;


/**
 * @模块名称：ExamPlanAction(考试计划)
 * @开发人：
 * @功          能：管理ExamPlanAction的所有业务逻辑
 * @开发时间：
 */
public class ExamPlanServiceImp implements ExamPlanService
{
	private ExamPlanDao examPlanDao;
	@SuppressWarnings("unused")
	private ExamPlanService EPService;

	public ExamPlanDao getExamPlanDao()
	{
		return examPlanDao;
	}

	public void setExamPlanDao(ExamPlanDao examPlanDao)
	{
		this.examPlanDao = examPlanDao;
	}

	/**
	 * Add页面
	 */
	/**
	 * 班级名称下拉列表
	 */
	public List<?> selectClassName(){
		return examPlanDao.findList(" from TbClasses where CDel='0' ");
	}
	/**
	 * 考试方案名称下拉列表
	 */
	public List<?> selectExamSchemeName(){
		return examPlanDao.findList(" from TbExamScheme where esDel='0' ");	
	}
	/**
	 * 考试计划新增—————保存按钮
	 */
	public void examPlanAddSaveButton(TbExamPlan plan){
		examPlanDao.save(plan);
	}
	/**
	 * 班级名称
	 */
	public TbClasses findclaID(int CId){
		return (TbClasses) examPlanDao.findByHQL(" from TbClasses where CDel='0' and CId="+CId);
	}
	/**
	 * 考试方案名称
	 */
	public TbExamScheme findschID(int esId){
		return (TbExamScheme) examPlanDao.findByHQL(" from TbExamScheme where esDel='0' and esId="+esId);
	}
	/**
	 * 根据ID查询考试方案
	 */
	public TbExamScheme getTbExamScheme(int esId){
		return (TbExamScheme) examPlanDao.findByHQL("from TbExamScheme where esDel='0' and esId="+esId);
	}
	/**
	 * 答案选项表查询
	 */
	@SuppressWarnings("unchecked")
	public List<TbProblemResult> findTbProblemResult() {
		return (List<TbProblemResult>) examPlanDao.findList("from TbProblemResult where prDel=0");
	}
	//----------------------------------------------------------------------------------//
	/**
	 * 
	 * Query页面查找
	 */
	public String findWithQueryPage(HttpServletRequest request) {
		StringBuilder sql=new StringBuilder(" from TbExamPlan where planDel='0' ");

		String examPlanNo=ServletActionContext.getRequest().getParameter("examPlanNo");
		if(examPlanNo!=null&&examPlanNo!=""){
			sql.append(" and epMyselfId like '%"+examPlanNo+"%'");
		}
		String examPlanName=ServletActionContext.getRequest().getParameter("examPlanName");
		if(examPlanName!=null&&examPlanName!=""){
			sql.append(" and planName like '%"+examPlanName+"%'");
		}
		String readType=ServletActionContext.getRequest().getParameter("readType");
		if(readType!=null&&readType!=""){
			sql.append(" and tbReadType.rtName like '%"+readType+"%'");
		}
		String classNum=ServletActionContext.getRequest().getParameter("classNum");
		if(classNum!=null&&classNum!=""){
			sql.append(" and tbClasses.CNum like '%"+classNum+"%'");
		}
		String examPlanStatus=ServletActionContext.getRequest().getParameter("examPlanStatus");
		if(examPlanStatus!=null&&examPlanStatus!=""){
			sql.append(" and tbPlanStatus.psName like '%"+examPlanStatus+"%'");
		}
		String examTimeStart=ServletActionContext.getRequest().getParameter("examTimeStart");
		String examTimeEnd=ServletActionContext.getRequest().getParameter("examTimeEnd");
		if((examTimeStart!=null&&examTimeStart!="")&&(examTimeEnd!=null&&examTimeEnd!="")){
			sql.append(" and planStartTime like '%"+examTimeStart+"%' and planEndTime like '%"+examTimeEnd+"%'");
		}
		String HQL= sql.toString();
		ServletActionContext.getRequest().getSession().setAttribute("HQL", HQL);
		return HQL;
	}
	/**
	 * 批阅方式下拉列表
	 * @return
	 */
	public List<?> selectReadType(){
		return examPlanDao.findList(" from TbReadType where rtDel='0' ");
	}
	/**
	 * 考试计划状态下拉列表
	 */
	public List<?> selectExamPlanStatus(){
		return examPlanDao.findList(" from TbPlanStatus where psDel='0' ");
	}
	/**
	 * TbExamPlan表单查
	 * 
	 */
	public TbExamPlan loginExamPlan(int planId){
		return (TbExamPlan) examPlanDao.findByHQL(" from TbExamPlan where planDel='0' and planId="+planId);
	}
	/**
	 * 批阅方式
	 */
	public TbReadType loginReadType(int rtId){
		return (TbReadType) examPlanDao.findByHQL(" from TbReadType where rtDel='0' and rtId="+rtId);
	}
	public List<?> seleteReadType(){
		return examPlanDao.findList(" from TbReadType where rtDel='0' ");
	}
    //---------------------------------------------------------------------//
	/**
	 * Issue页面查找
	 */
	public String findWithIssuePage(int startNumber, int pageSize){
		StringBuilder sql=new StringBuilder(" from TbExamPlan where planDel='0' ");

		String examPlanNo=ServletActionContext.getRequest().getParameter("examPlanNo");
		if(examPlanNo!=null&&examPlanNo!=""){
			sql.append(" and epMyselfId like '%"+examPlanNo+"%'");
		}
		String examPlanName=ServletActionContext.getRequest().getParameter("examPlanName");
		if(examPlanName!=null&&examPlanName!=""){
			sql.append(" and planName like '%"+examPlanName+"%'");
		}
		String readType=ServletActionContext.getRequest().getParameter("readType");
		if(readType!=null&&readType!=""){
			sql.append(" and tbReadType.rtName like '%"+readType+"%'");
		}
		String classNum=ServletActionContext.getRequest().getParameter("classNum");
		if(classNum!=null&&classNum!=""){
			sql.append(" and tbClasses.CNum like '%"+classNum+"%'");
		}
		String examTimeStart=ServletActionContext.getRequest().getParameter("examTimeStart");
		String examTimeEnd=ServletActionContext.getRequest().getParameter("examTimeEnd");
		if((examTimeStart!=null&&examTimeStart!="")&&(examTimeEnd!=null&&examTimeEnd!="")){
			sql.append(" and planStartTime like '%"+examTimeStart+"%' and planEndTime like '%"+examTimeEnd+"%'");
		}
		//		sql.append(" and planDel='0' ");
		String HQL= sql.toString();
		ServletActionContext.getRequest().getSession().setAttribute("HQL", HQL);

		return HQL;

	}
//------------------------------------------------------------------------------------------//
	/**
	 * Cancel页面查找
	 */
	public String findWithCancelPage(int startNumber, int pageSize){
		StringBuilder sql=new StringBuilder(" from TbExamPlan where planDel='0'");
		String examPlanNo=ServletActionContext.getRequest().getParameter("examPlanNo");
		if(examPlanNo!=null&&examPlanNo!=""){
			sql.append(" and epMyselfId like '%"+examPlanNo+"%'");
		}
		String examPlanName=ServletActionContext.getRequest().getParameter("examPlanName");
		if(examPlanName!=null&&examPlanName!=""){
			sql.append(" and planName like '%"+examPlanName+"%'");
		}
		String readType=ServletActionContext.getRequest().getParameter("readType");
		if(readType!=null&&readType!=""){
			sql.append(" and tbReadType.rtName like '%"+readType+"%'");
		}
		String classNum=ServletActionContext.getRequest().getParameter("classNum");
		if(classNum!=null&&classNum!=""){
			sql.append(" and tbClasses.CNum like '%"+classNum+"%'");
		}
		String examTimeStart=ServletActionContext.getRequest().getParameter("examTimeStart");
		String examTimeEnd=ServletActionContext.getRequest().getParameter("examTimeEnd");
		if((examTimeStart!=null&&examTimeStart!="")&&(examTimeEnd!=null&&examTimeEnd!="")){
			sql.append(" and planStartTime like '%"+examTimeStart+"%' and planEndTime like '%"+examTimeEnd+"%'");
		}
		//		sql.append(" and planDel='0' ");
		String HQL= sql.toString();
		ServletActionContext.getRequest().getSession().setAttribute("HQL", HQL);

		return HQL;
	}

	//获得考试计划状态的方法
	public	TbPlanStatus getStatus(String str)
	{
		String HQL = "from TbPlanStatus where psDel='0' and psName='"+str+"'";
		
		return (TbPlanStatus) examPlanDao.findByHQL(HQL);
		
	}
	

	/**
	 * 班级编号链接
	 */
	public TbClasses loginClassNum(String classNum){
		return (TbClasses) examPlanDao.findByHQL(" from TbClasses where CDel='0' and CNum like '%"+classNum+"%'");

	}

	/**
	 * 考试方案名称链接
	 */
	public TbExamScheme loginExamSchemeName(String examSchemeNum){
		return (TbExamScheme) examPlanDao.findByHQL(" from TbExamScheme where esDel='0' and esMyselfId like '%"+examSchemeNum+"%' ");

	}

	/**
	 * TbProblem表全查
	 */
	@SuppressWarnings("unchecked")
	public List<TbProblem> findWithProblemPage(int startNumber,int pageSize){
		StringBuilder sql=new StringBuilder(" from TbProblem where PDel='0' ");
		String HQL=sql.toString();
		return (List<TbProblem>) examPlanDao.findWithPage(startNumber, pageSize, HQL);

	}

	/**
	 * 
	 * TbProblem表单查
	 */
	public TbProblem loginProblem(int num){
		return (TbProblem) examPlanDao.findByHQL(" from TbProblem where PDel='0' and PId like '%"+num+"%' ");

	}
	public TbProblem Problem(){
		return (TbProblem) examPlanDao.findByHQL(" from TbProblem where PDel='0'");
	}
	


	/**
	 * 考试计划撤销————撤销按钮
	 * @return 
	 */
	/**
	 * 考试计划维护————保存按钮
	 */
	public void examPlanUpdate(TbExamPlan del){
		examPlanDao.update(del);
	}

	/**
	 * 考试计划批阅人
	 */
	public List<?> selectExamPlanReader(){
		return examPlanDao.findList(" from TbExamPlan where planDel='0' ");

	}
	/**
	 * 分页查询方法
	 */
	public List<?> findWithPage(Pager pager, String HQL){

		return examPlanDao.findWithPage(pager.getStartRow(), pager.getPageSize(), HQL);

	}
	/**
	 * 获得数据总条数
	 */
	public int getRows(String HQL){
		return examPlanDao.findList(HQL).size();
	}
	
	/**
	 * 
	 */
	public TbExamSchemeDetail loginSchemeDetail(TbExamScheme scheme){
		return (TbExamSchemeDetail) examPlanDao.findByHQL(" from TbExamSchemeDetail esdDel='0' and tbExamScheme="+scheme);
	}
}

