package com.cissst.service;

import java.util.List;

import com.cissst.entity.TbExamPaper;
import com.cissst.entity.TbExamPaperAnswer;
import com.cissst.entity.TbExamPlan;

/**
 * @模块名称：ScoreManagerAction(成绩管理)
 * @开发人：
 * @功          能：管理ScoreManagerAction对数据库的所有操作
 * @开发时间：
 */
public interface ScoreManagerService
{
    //在成绩查询中查询所有成绩
	public List<TbExamPlan> gradeQuery(int startNumber,int pageSize,String HQL);
	
	//分页中拿到考试计划的总行数
	public int getRows(String HQL);
	
//	//分页中拿到考试计划的总行数
//	public int getRows();
	
	//条件查询拼接HQL
	public String joinHql();
	
	//查出一个试计划的对象
	public TbExamPlan findPlan(int id);
	
	//在考试发布中查询整体
	public List<TbExamPlan> gradeIssue(int startNumber,int pageSize,String HQL);
	
	//在考试发布中查询一个考试计划
	public TbExamPlan gradeIssueOne(String epMyselfId);
	
	//在考试批阅中查询所有批阅项
	public List<TbExamPlan> gradeCheck(int startNumber,int pageSize,String HQL);
	
	//在成绩批阅中查询一个需要批阅的考试计划
	public TbExamPlan gradeCheckList(int id);
	
	//在成绩批阅中根据一个计划编号得到这个计划需要批阅的总行数
	public int getRowsCheck(int id);
	
	//在考试批阅中根据考试计划id查询一个计划
	public TbExamPlan gradeForCheck(int id);
	
	//在考试批阅中根据id查询一份试卷
	public TbExamPaper checkPaper(int id);
	
	//根据id查询一个试卷作答对象
	public TbExamPaperAnswer paperAnswer(int id);
	
	//保存每道题成绩
	public void saveScore(TbExamPaperAnswer paperAnswer);
	
	//在考试发布中更新计划
	public void updatePlan(TbExamPlan examPlan);

}
