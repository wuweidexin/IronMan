package com.cissst.iService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.cissst.dao.ProblemManagerDao;
import com.cissst.entity.TbAuditStatus;
import com.cissst.entity.TbProblem;
import com.cissst.entity.TbProblemAudit;
import com.cissst.entity.TbProblemDifficultyLevel;
import com.cissst.entity.TbProblemResult;
import com.cissst.entity.TbProblemScore;
import com.cissst.entity.TbProblemType;
import com.cissst.entity.TbUser;
import com.cissst.service.ProblemManagerService;
import com.cissst.utils.Pager;
/**
 * @模块名称：ProblemManagerAction(题库管理)
 * @开发人：
 * @功          能：管理ProblemManagerAction的所有业务逻辑
 * @开发时间：
 */
public class ProblemManagerServiceImp implements ProblemManagerService
{
	private ProblemManagerDao problemManagerDao;

	public ProblemManagerDao getProblemManagerDao()
	{
		return problemManagerDao;
	}

	public void setProblemManagerDao(ProblemManagerDao problemManagerDao)
	{
		this.problemManagerDao = problemManagerDao;
	}

	/**
	 * 查询题目难度等级
	 */
	public List<?> findProblemDifficultyLevel() {

		return problemManagerDao.findList("from TbProblemDifficultyLevel where pdlDel=0 ");
	}

	/**
	 * 查询题目范围
	 */
	public List<?> findProblemScore() {

		return problemManagerDao.findList("from TbProblemScore where psDel = 0");
	}

	/**
	 * 查询题目类型
	 */
	public List<?> findProblemType() {
		return problemManagerDao.findList("from TbProblemType where ptDel = 0");
	}

	/**
	 * 查询题一试题难度等级
	 */
	public TbProblemDifficultyLevel getProblemDifficultyLevel(int id) {

		return (TbProblemDifficultyLevel) problemManagerDao.findByHQL("from TbProblemDifficultyLevel where pdlDel=0 and id=" +id);
	}

	/**
	 * 查询题一个出题范围
	 */
	public TbProblemScore getProblemScore(int id) {

		return (TbProblemScore) problemManagerDao.findByHQL("from TbProblemScore where psDel = 0 and id ="+id);
	}

	/**
	 * 查询题一种目类型
	 */
	public TbProblemType getProblemType(int id) {

		return (TbProblemType) problemManagerDao.findByHQL("from TbProblemType where ptDel = 0 and id=" + id);
	}

	/**
	 * 删除答案
	 */
	public void deleteProResult(int id) {
		TbProblemResult problemResult = (TbProblemResult) problemManagerDao.findByHQL("from TbProblemResult where id=" +id);
		String prDel = "1";
		problemResult.setPrDel(prDel);
		problemManagerDao.update(problemResult);
	}

	/**
	 * 存储一道题目
	 */
	public void saveProblem(TbProblem tbProblem) {
		problemManagerDao.save(tbProblem);
	}

	/**
	 * 查询一道题目
	 * col1为试题编号
	 */
	public TbProblem findTbProblem(String col1) { 
		StringBuffer HQL = new StringBuffer("from TbProblem where PDel = 0 ");
		HQL.append(" and col1 like '%"+col1+"%'");
		return (TbProblem) problemManagerDao.findByHQL(HQL.toString());
	}

	/** 
	 * 通过ID查询一道题目
	 */
	public TbProblem getTbProblem(int id) {

		return (TbProblem) problemManagerDao.findByHQL("from TbProblem where PDel = 0 and PId =" + id);
	}

	/**
	 * 存储一个答案
	 */
	public void saveResult(TbProblemResult tbProblemResult) {
		problemManagerDao.save(tbProblemResult);
	}

	/**
	 * 通过题目Id查询题目答案
	 */
	public List<?> findProResult(int id ) {

		return problemManagerDao.findList("from TbProblemResult as pr where pr.prDel=0 and pr.tbProblem.PId = " + id);

	}

	/**
	 * 通过题目Id获得该道题目所有答案的id
	 */
	public List<?> getResultId(int id){
		return problemManagerDao.findList(" select pr.prId from TbProblemResult as pr where pr.prDel=0 and pr.tbProblem.PId = " + id);

	}

	/**
	 * 更新答案
	 */
	public void updateResult(TbProblemResult result) {
		problemManagerDao.update(result);
	}

	/**
	 * 通过答案Id获得一个答案
	 */
	public TbProblemResult getProResult(int id) {
		return (TbProblemResult) problemManagerDao.findByHQL("from TbProblemResult where prDel = 0 and id =" +id);
	}

	/**
	 * 更新一道题目
	 */
	public void updateProblem(TbProblem problem) {
		problemManagerDao.update(problem);
	}

	/**
	 * 保存 TbUser对象
	 */
	public void saveTbUser(TbUser user) {
		problemManagerDao.save(user);
	}

	/**
	 * 存储审核状态
	 */
	public void saveAuditStatus(TbAuditStatus auditStatus){
		problemManagerDao.save(auditStatus);
	}

	/**
	 * 根据审核状态名称查找审核Id
	 */
	public TbAuditStatus findTbAuditStatus(String asName){
		return (TbAuditStatus) problemManagerDao.findByHQL(" from TbAuditStatus as tbAs where tbAs.asDel=0 and tbAs.asName like '%"+asName+"%'");
	}

	/**
	 * 查询试题可设置的几种状态
	 */
	public List<?> findTbAuditStatusList(){
		return problemManagerDao.findList("from TbAuditStatus where asDel = 0");

	}

	/**
	 * 
	 *分页Hql拼写
	 */
	public String checkHQL(HttpServletRequest request) {

		StringBuffer buffer = new StringBuffer("from TbProblem where PDel = 0");

		//获得题目编号
		String  problemNo = ServletActionContext.getRequest().getParameter("problemNo");
		if(problemNo != "" && problemNo != null) {
			buffer.append(" and col1 like '%"+problemNo+"%'");
		}

		//获得题目类型名称
		String ptName = ServletActionContext.getRequest().getParameter("ptName");
		if(ptName != "" && ptName  != null) {
			buffer.append(" and tbProblemType.ptName like '%"+ptName+"%'");
		}

		//获得题目范围名称
		String psName = ServletActionContext.getRequest().getParameter("psName");
		if(psName != "" && psName != null) {
			buffer.append(" and tbProblemScore.psName like '%"+ psName +"%'");
		}

		//获得题目难度等级
		String pdlName = ServletActionContext.getRequest().getParameter("pdlName");
		if(pdlName != "" && pdlName != null) {
			buffer.append(" and tbProblemDifficultyLevel.pdlName like '%"+ pdlName  +"%'");
		}

		//获得题目审批状态
		String asName = ServletActionContext.getRequest().getParameter("asName");
		if(asName != "" && asName != null) {
			buffer.append(" and tbAuditStatus.asName like '%"+ asName +"%'");
		}

		//获得添加人
		String addTbUser = request.getParameter("addTbUser");
		if(addTbUser != "" && addTbUser != null) {
			buffer.append(" and  tbUser.UName like '%"+ addTbUser +"%'");
		}

		//获得前台开始结束时间
		String startTime = ServletActionContext.getRequest().getParameter("startTime");
		String endTime = ServletActionContext.getRequest().getParameter("endTime");
		if(startTime != "" && startTime != null) {
			buffer.append(" and PAddTime > '"+startTime+"'");
		}
		if(endTime != "" && endTime != null) {
			buffer.append(" and PAddTime < '"+endTime+"'");
		}

		String HQL = buffer.toString();
		ServletActionContext.getRequest().getSession().setAttribute("HQL", HQL);

		return HQL;
	}

	/**
	 * 
	 *题目审核分页Hql拼写
	 */
	public String AuditHQL(HttpServletRequest request) {
		StringBuffer buffer = new StringBuffer("from TbProblem  where PDel = 0  ");

		//获得题目编号
		String  problemNo = ServletActionContext.getRequest().getParameter("problemNo");
		if(problemNo != "" && problemNo != null) {
			buffer.append(" and col1 like '%"+problemNo+"%'");
		}

		//获得题目类型名称
		String ptName = ServletActionContext.getRequest().getParameter("ptName");
		if(ptName != "" && ptName  != null) {
			buffer.append(" and tbProblemType.ptName like '%"+ptName+"%'");
		}

		//获得题目范围名称
		String psName = ServletActionContext.getRequest().getParameter("psName");
		if(psName != "" && psName != null) {
			buffer.append(" and tbProblemScore.psName like '%"+ psName +"%'");
		}

		//获得题目难度等级
		String pdlName = ServletActionContext.getRequest().getParameter("pdlName");
		if(pdlName != "" && pdlName != null) {
			buffer.append(" and tbProblemDifficultyLevel.pdlName like '%"+ pdlName  +"%'");
		}

		//获得添加人
		String addTbUser = request.getParameter("addTbUser");
		if(addTbUser != "" && addTbUser != null) {
			buffer.append(" and  tbUser.UName like '%"+ addTbUser +"%'");
		}

		//获得前台开始结束时间
		String startTime = ServletActionContext.getRequest().getParameter("startTime");
		String endTime = ServletActionContext.getRequest().getParameter("endTime");
		if(startTime != "" && startTime != null) {
			buffer.append(" and PAddTime > '"+startTime+"'");
		}
		if(endTime != "" && endTime != null) {
			buffer.append(" and PAddTime < '"+endTime+"'");
		}


		buffer.append(" and tbAuditStatus.asName  like  '%"+ "已提交" +"%' ");


		String HQLs = buffer.toString();
		ServletActionContext.getRequest().getSession().setAttribute("HQLs", HQLs);

		return HQLs;
	}

	/**
	 * 
	 *题目审核分页Hql拼写
	 */
	public String cancelHQL(HttpServletRequest request) {

		StringBuffer buffer = new StringBuffer("from TbProblem where PDel = 0  ");

		//获得题目编号
		String  problemNo = ServletActionContext.getRequest().getParameter("problemNo");
		if(problemNo != "" && problemNo != null) {
			buffer.append(" and col1 like '%"+problemNo+"%'");
		}

		//获得题目类型名称
		String ptName = ServletActionContext.getRequest().getParameter("ptName");
		if(ptName != "" && ptName  != null) {
			buffer.append(" and tbProblemType.ptName like '%"+ptName+"%'");
		}

		//获得题目范围名称
		String psName = ServletActionContext.getRequest().getParameter("psName");
		if(psName != "" && psName != null) {
			buffer.append(" and tbProblemScore.psName like '%"+ psName +"%'");
		}

		//获得题目难度等级
		String pdlName = ServletActionContext.getRequest().getParameter("pdlName");
		if(pdlName != "" && pdlName != null) {
			buffer.append(" and tbProblemDifficultyLevel.pdlName like '%"+ pdlName  +"%'");
		}

		//获得添加人
		String addTbUser = request.getParameter("addTbUser");
		if(addTbUser != "" && addTbUser != null) {
			buffer.append(" and  tbUser.UName like '%"+ addTbUser +"%'");
		}

		//获得前台开始结束时间
		String startTime = ServletActionContext.getRequest().getParameter("startTime");
		String endTime = ServletActionContext.getRequest().getParameter("endTime");
		if(startTime != "" && startTime != null) {
			buffer.append(" and PAddTime > '"+startTime+"'");
		}
		if(endTime != "" && endTime != null) {
			buffer.append(" and PAddTime < '"+endTime+"'");
		}
		buffer.append(" and tbAuditStatus.asName not like '%"+ "已保存" +"%'");

		String HQLes = buffer.toString();
		ServletActionContext.getRequest().getSession().setAttribute("HQLes", HQLes);

		return HQLes;
	}


	/**
	 * 分页查询方法
	 */
	public List<?> findWithPage(Pager pager, String HQL){

		return problemManagerDao.findWithPage(pager.getStartRow(), pager.getPageSize(), HQL);

	}

	/**
	 * 获得数据总条数
	 */
	public int getRows(String HQL){
		return problemManagerDao.findList(HQL).size();
	}


	/**
	 * 
	 * 查找一个tbUser，通过tbUbser的id （此方法整合时可能会去掉)
	 */
	public TbUser getTbUser(int id){
		return (TbUser) problemManagerDao.findByHQL("from TbUser where UDel=0 and UId="+id );

	}

	/**
	 * 保存题目审核意见
	 */
	public void saveTbProblemAudit(TbProblemAudit audit) {
		problemManagerDao.save(audit);
	}

	/**
	 * 通过题目id查找题目的审核状态
	 */
	public TbProblemAudit findTbProblemAudit (int id) {
		return (TbProblemAudit) problemManagerDao.findByHQL("from TbProblemAudit where paDel=0 and tbProblem.PId = " + id);
	}

	/**
	 * 更新题目审核状态表
	 */
	public void updateTbProblemAudit(TbProblemAudit problemAudit){
		problemManagerDao.update(problemAudit);
	}

	/**
	 * 通过题目ID删除题目
	 */
	public void deleteProblem(int id) {
		String HQL = "from TbProblem where PDel=0 and PId =" +id;
		TbProblem problem = (TbProblem) problemManagerDao.findByHQL(HQL);
		problem.setPDel("1");
		problemManagerDao.update(problem);
	}


}
