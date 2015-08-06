package com.cissst.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cissst.entity.TbClasses;
import com.cissst.entity.TbExamPlan;
import com.cissst.entity.TbExamScheme;
import com.cissst.entity.TbExamSchemeDetail;
import com.cissst.entity.TbPlanStatus;
import com.cissst.entity.TbProblem;
import com.cissst.entity.TbProblemResult;
import com.cissst.entity.TbReadType;
import com.cissst.utils.Pager;


/**
 * @模块名称：ExamPlanAction(考试计划)
 * @开发人：
 * @功          能：管理ExamPlanAction的所有业务逻辑
 * @开发时间：
 */
public interface ExamPlanService
{

	/**
	 * Add页面
	 */
	/**
	 * 班级名称下拉列表
	 */
	public List<?> selectClassName();
	/**
	 * 考试方案名称下拉列表
	 */
	public List<?> selectExamSchemeName();
	/**
	 * 考试计划新增————保存按钮
	 */
	public void examPlanAddSaveButton(TbExamPlan plan);
	/**
	 * 根据班级名称找ID
	 */
	public TbClasses findclaID(int Cid);
	/**
	 * 根据考试方案名称找ID
	 */
	public TbExamScheme findschID(int esId);
	/**
	 * 根据ID查询考试方案
	 */
	public TbExamScheme getTbExamScheme(int esId);
	/**
	 * 答案选项表查询
	 */
	public List<TbProblemResult> findTbProblemResult();
	//-------------------------------------------------------------------------//
	/**
	 * Query页面查找
	 */
	public String findWithQueryPage(HttpServletRequest request);
	/**
	 * 批阅方式下拉列表
	 */
	public List<?> selectReadType();
	/**
	 * 考试计划状态下拉列表
	 */
	public List<?> selectExamPlanStatus();
	/**
	 * TbExamPlan表单查
	 * 
	 */
	public TbExamPlan loginExamPlan(int planId);
	/**
	 * 批阅方式
	 */
	public TbReadType loginReadType(int rtId);
	
	public List<?> seleteReadType();
	//-------------------------------------------------------------------------------//
	/**
	 * Issue页面查找
	 */
	public String findWithIssuePage(int startNumber, int pageSize);

	/**
	 * Cancel页面查找
	 */
	public String findWithCancelPage(int startNumber, int pageSize);
	/**
	 * 班级编号链接
	 */
	public TbClasses loginClassNum(String classNum) ;

	/**
	 * 考试方案名称链接
	 */
	public TbExamScheme loginExamSchemeName(String examSchemeNum);

	/**
	 * TbProblem表全查
	 */
	public List<?> findWithProblemPage(int startNumber,int pageSize);

	/**
	 * TbProblem表单查
	 * 
	 */
	public TbProblem loginProblem(int num);

	public TbProblem Problem();

	

	/**
	 * 考试计划撤销————撤销按钮
	 */
	/**
	 * 考试计划维护————保存按钮
	 */
	public void examPlanUpdate(TbExamPlan del);

	/**
	 * 考试计划批阅人
	 */
	public List<?> selectExamPlanReader();

	
	

	/**
	 * 分页查询方法
	 */
	public List<?> findWithPage(Pager pager, String HQL);


	/**
	 * 获得数据总条数(全查分页所调)
	 */
	public int getRows(String HQL);


	/**
	 * 
	 */
	public TbExamSchemeDetail loginSchemeDetail(TbExamScheme scheme);

	//获得考试计划状态的方法
	public	TbPlanStatus getStatus(String str);
	
}

