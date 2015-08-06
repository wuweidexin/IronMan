package com.cissst.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cissst.entity.TbAuditStatus;
import com.cissst.entity.TbProblem;
import com.cissst.entity.TbProblemAudit;
import com.cissst.entity.TbProblemDifficultyLevel;
import com.cissst.entity.TbProblemResult;
import com.cissst.entity.TbProblemScore;
import com.cissst.entity.TbProblemType;
import com.cissst.entity.TbUser;
import com.cissst.utils.Pager;

/**
 * @模块名称：ProblemManagerAction(题库管理)
 * @开发人：
 * @功          能：管理ProblemManagerAction的所有业务逻辑
 * @开发时间：
 */
public interface ProblemManagerService
{
	/**
	 * 查询题目类型
	 */
	public List<?> findProblemType();
	
	/**
	 * 查询题目范围
	 */
	public List<?> findProblemScore();
	
	/**
	 * 查询题目难度等级
	 */
	public List<?> findProblemDifficultyLevel();
	
	/**
	 * 查询题一种目类型
	 */
	
	public TbProblemType getProblemType( int id);
	
	/**
	 * 查询题一个出题范围
	 */
	
	public TbProblemScore getProblemScore(int id);
	
	/**
	 * 查询题一试题难度等级
	 */
	
	public TbProblemDifficultyLevel getProblemDifficultyLevel(int id);
	
	/**
	 * 查询题题答案
	 */
	public List<?> findProResult(int id);
	
	/**
	 * 通过题目Id获得该道题目所有答案的id
	 */
	public List<?> getResultId(int id);
	
	/**
	 * 通过答案Id获得一个答案
	 */
	public TbProblemResult getProResult(int id);
	
	/**
	 * 删除答案
	 */
	public void deleteProResult(int id);
	
	/**
	 * 存储一道题目
	 */
	public void saveProblem(TbProblem tbProblem);

	/**
	 * 通过题目编号查询一道题目
	 */
	public TbProblem findTbProblem(String col1);
	
	/**
	 * 通过题目ID查询一道题目
	 */
	public TbProblem getTbProblem(int id);
	
	/**
	 * 存储一个答案
	 */
	public void saveResult(TbProblemResult tbProblemResult);
	
	/**
	 * 更新答案
	 */
	public void updateResult(TbProblemResult result);
	
	/**
	 * 更新一道题目
	 */
	public void updateProblem(TbProblem problem);
	
	/**
	 * 保存 TbUser对象
	 */
	public void saveTbUser(TbUser user);
	
	/**
 	 * 根据审核状态名称查找审核Id
	 */
	public TbAuditStatus findTbAuditStatus(String asName);
	
	/**
	 * 查询试题可设置的几种状态
	 */
	public List<?> findTbAuditStatusList();
	
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
	 *分页Hql拼写
	 */
	public String checkHQL(HttpServletRequest request);
	
	/**
	 * 
	 *题目审核分页Hql拼写
	 */
	public String AuditHQL(HttpServletRequest request);
	
	/**
	 * 
	 * 查找一个tbUser，通过tbUbser的id （此方法整合时可能会去掉)
	 */
	public TbUser getTbUser(int id);
	
	/**
	 * 保存题目审核意见
	 * 
	 */
	public void saveTbProblemAudit(TbProblemAudit audit);
	
	/**
	 * 
	 *题目审核分页Hql拼写
	 */
	public String cancelHQL(HttpServletRequest request);
	
	/**
	 * 通过题目id查找题目的审核状态
	 */
	public TbProblemAudit findTbProblemAudit (int id);

	/**
	 * 更新题目审核状态表
	 */
	public void updateTbProblemAudit(TbProblemAudit problemAudit);
	
	/**
	 * 通过题目ID删除题目
	 */
	public void deleteProblem(int id);

}
