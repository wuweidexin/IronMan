package com.cissst.service;

import java.util.List;

import com.cissst.entity.TbAuditStatus;
import com.cissst.entity.TbExamScheme;
import com.cissst.entity.TbExamSchemeDetail;
import com.cissst.entity.TbProblem;
import com.cissst.entity.TbProblemDifficultyLevel;
import com.cissst.entity.TbProblemScore;
import com.cissst.entity.TbProblemType;
import com.cissst.entity.TbReadType;
import com.cissst.entity.TbTactics;
import com.cissst.entity.TbTacticsDetail;

/**
 * @模块名称：ExamSchemaAction(考试方案)
 * @开发人：
 * @功          能：管理ExamSchemaAction的所有业务逻辑
 * @开发时间：
 */
public interface ExamSchemaService
{
	
	//存储策略
	public void save(TbTactics tbTactics);
	
	//存储批阅方式
	public void saveTbReadType(TbReadType tbReadType);
	
	//存储详细方案表
	public void saveSchemeDetail(TbExamSchemeDetail tbExamSchemeDetail);
	
	//存储策略详细表
	public void saveDetail(TbTacticsDetail tbTacticsDetail);
	
	//查询策略
	public TbTactics TbTacticsfindByHQLQuery(int ID);
	
	//策略全查
	public List<TbTactics> findByHQLtbTactics();
	
	//更新策略
	public void TbTacticsupdate(TbTactics tbTactics);
	
	//自动查询
	public List<?> findByHQLFree();
	
	//更新题目
	public void updateTbProblem(TbProblem tbProblem);
	
    //查询题目
	public List<?> findWithPage(int startNumber,int pageSize);
	
	//查询题目表数目
	public int getRow();
	
	//通过ID查询一个题目
	public TbProblem findByHQLTbProblem(int ID);
	
	//存储一个方案
	public void saveTbE(TbExamScheme tbExamScheme);
	
	//查询方案
	public List<?> findWithPageSchamaPlan(int startNumber,int pageSize);
	
	//查询方案表数目
	public int getRowNum();
	
	//通过ID查询一个方案
	public TbExamScheme findByHQL(int ID);
	
	//方案撤销
	public void update(TbExamScheme tbExamScheme);
	
	//全查题目
	public List<TbProblem> findByHQLtbTbProblem();
	//查询题目范围
	public List<TbProblemScore> TbPrfindByHQLtbScore();
	
	//查询题目难度
	public List<TbProblemDifficultyLevel> TbPrfindByHQLdifficultyLevel();
	
	//查询题目类型
	public List<TbProblemType> findByHQLtbProblemType();
	
	//查询方案审核状态
	public List<TbAuditStatus> TbPrfindByHQLtbAuditStatus();
	
	
	//查询审核状态
	public TbAuditStatus findByHQL(String HQ);
	
	
	//查询题目范围
	public TbProblemScore findByHQLtbScore(String HQL);
	
	//查询题目难度
	public TbProblemDifficultyLevel findByHQLdifficultyLevel(String HQL);
	
	//查询题目类型
	public TbProblemType findByHQLtProblemType(String HQL);
	
	//查询题目类型
	public TbAuditStatus findByHQLtbAuditStatus(String HQL);
	
	//更新详细方案表
	public void updatetbExamSchemeDetail(TbExamSchemeDetail tbExamSchemeDetail);
}
