package com.cissst.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.cissst.dao.ClassesManagerDao;
import com.cissst.dao.ExamPlanDao;
import com.cissst.dao.ExamSchemaDao;
import com.cissst.dao.ProblemManagerDao;
import com.cissst.dao.SystemSettingDao;
import com.cissst.iDao.ProblemManagerDaoImp;
import com.cissst.service.ProblemManagerService;

public class NumberUtil {
	/**
	 * 或得题目编号(	QN20120920001)
	 */
	private  ProblemManagerDao problemManagerDao;
	private ClassesManagerDao classesManagerDao;
	private SystemSettingDao systemSettingDao;
	private ExamPlanDao examPlanDao;
	private ExamSchemaDao examSchemaDao;


	//获得学生类型编号
	public String getStuTypeNo()
	{
		long temp =  (	Long) systemSettingDao.findByHQL("select count(*) from TbStudentType");

		String stuTypeNum = this.getNum("ST",temp );

		return stuTypeNum;
	}
	//获得班级类型编号
	public String getClaTypeNo()
	{
		long temp =  (	Long) systemSettingDao.findByHQL("select count(*) from TbClassType");

		String claTypeNum = this.getNum("CT",temp );

		return claTypeNum;
	}

	//获得题目难度编号
	public String getQlDifNo()
	{
		long temp =  (	Long) systemSettingDao.findByHQL("select count(*) from TbProblemDifficultyLevel");

		String qlDifNum = this.getNum("QD",temp );

		return qlDifNum;
	}


	//获得题目范围编号
	public String getQlScoreNo()
	{
		long temp =  (	Long) systemSettingDao.findByHQL("select count(*) from TbProblemScore");

		String qlScoreNum = this.getNum("QR",temp );

		return qlScoreNum;
	}


	//获得题目类型编号
	public String getQlTypeNo()
	{
		long temp =  (	Long) systemSettingDao.findByHQL("select count(*) from TbProblemType");

		String qlTypeNum = this.getNum("QT",temp );

		return qlTypeNum;
	}

	//获得班级编号
	public String getClassNo() {

		long temp = (Long)classesManagerDao.findByHQL("select count(*) from TbClasses");
	
		StringBuilder builder = new StringBuilder("ISSTCWH_J");

		int countNo = (int)temp + 1;
		if(countNo<10) {
			builder.append("00");
			builder.append(countNo);
		} else if (countNo<100) {
			builder.append("0");
			builder.append(countNo);
		} else {
			builder.append(countNo);
		}

		String num = builder.toString();
		return num;
	}	
	//获得用户编号
	public String getUserNo()
	{
		long temp =  (	Long) systemSettingDao.findByHQL("select count(*) from TbUser");

		String userNum = this.getNum("US",temp );

		return userNum;
	}
	//获得问题编号
	public  String getProblemNo() {
		long temp =  (	Long) problemManagerDao.findByHQL("select count(*) from TbProblem");
		String proNum = this.getNum("QN", temp);		

		return proNum;
	}
	//获得考试计划编号
	public String getExamPlanNo(String classNo)
	{
		long temp = (Long)examPlanDao.findByHQL("select count(*) from TbExamPlan");
		String claN = classNo+"_";

		return this.getNum1(claN, temp);
	}
	
	
	//构造考试方案编号
	public String getExamScheme()
	{
		long temp = (Long)examPlanDao.findByHQL("select count(*) from TbExamScheme");
		String str = "ISSTCWH_S";

		return this.getNum1(str, temp);
	}
	
	
	public String getNum1(String str, long temp)
	{
		StringBuilder builder = new StringBuilder(str);

		int countNo = (int)temp + 1;
		if(countNo<10) {
			builder.append("00");
			builder.append(countNo);
		} else if (countNo<100) {
			builder.append("0");
			builder.append(countNo);
		} else {
			builder.append(countNo);
		}

		String num = builder.toString();
		return num;
	}

	//公共方法进行构造编号
	public String getNum(String str, long temp)
	{
		StringBuilder builder = new StringBuilder(str);

		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String date_str = format.format(d);
		builder.append(date_str);

		int countNo = (int)temp + 1;
		if(countNo<10) {
			builder.append("00");
			builder.append(countNo);
		} else if (countNo<100) {
			builder.append("0");
			builder.append(countNo);
		} else {
			builder.append(countNo);
		}

		String num = builder.toString();
		return num;
	}

	public ClassesManagerDao getClassesManagerDao() {
		return classesManagerDao;
	}


	public void setClassesManagerDao(ClassesManagerDao classesManagerDao) {
		this.classesManagerDao = classesManagerDao;
	}



	public  ProblemManagerDao getProblemManagerDao() {
		return problemManagerDao;
	}



	public  void setProblemManagerDao(ProblemManagerDao problemManagerDao) {
		this.problemManagerDao = problemManagerDao;
	}

	public SystemSettingDao getSystemSettingDao() {
		return systemSettingDao;
	}

	public void setSystemSettingDao(SystemSettingDao systemSettingDao) {
		this.systemSettingDao = systemSettingDao;
	}
	public ExamSchemaDao getExamSchemaDao() {
		return examSchemaDao;
	}
	public void setExamSchemaDao(ExamSchemaDao examSchemaDao) {
		this.examSchemaDao = examSchemaDao;
	}
	public ExamPlanDao getExamPlanDao() {
		return examPlanDao;
	}
	public void setExamPlanDao(ExamPlanDao examPlanDao) {
		this.examPlanDao = examPlanDao;
	}
}
