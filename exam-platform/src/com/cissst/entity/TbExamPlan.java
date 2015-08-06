package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbExamPlan entity. @author MyEclipse Persistence Tools
 */

public class TbExamPlan implements java.io.Serializable {

	// Fields

	private Integer planId;
	private TbReadStatus tbReadStatus;
	private TbReadType tbReadType;
	private TbExamScheme tbExamScheme;
	private TbPlanStatus tbPlanStatus;
	private TbClasses tbClasses;
	private String epMyselfId;
	private String planName;
	private String planDescribe;
	private String planStartTime;
	private String planEndTime;
	private String planReadOverTime;
	private String planDel;
	private String col1;
	private String col2;
	private String col3;
	private Set tbExamPapers = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbExamPlan() {
	}

	/** full constructor */
	public TbExamPlan(TbReadStatus tbReadStatus, TbReadType tbReadType,
			TbExamScheme tbExamScheme, TbPlanStatus tbPlanStatus,
			TbClasses tbClasses, String epMyselfId, String planName,
			String planDescribe, String planStartTime, String planEndTime,
			String planReadOverTime, String planDel, String col1, String col2,
			String col3, Set tbExamPapers) {
		this.tbReadStatus = tbReadStatus;
		this.tbReadType = tbReadType;
		this.tbExamScheme = tbExamScheme;
		this.tbPlanStatus = tbPlanStatus;
		this.tbClasses = tbClasses;
		this.epMyselfId = epMyselfId;
		this.planName = planName;
		this.planDescribe = planDescribe;
		this.planStartTime = planStartTime;
		this.planEndTime = planEndTime;
		this.planReadOverTime = planReadOverTime;
		this.planDel = planDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
		this.tbExamPapers = tbExamPapers;
	}

	// Property accessors

	public Integer getPlanId() {
		return this.planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public TbReadStatus getTbReadStatus() {
		return this.tbReadStatus;
	}

	public void setTbReadStatus(TbReadStatus tbReadStatus) {
		this.tbReadStatus = tbReadStatus;
	}

	public TbReadType getTbReadType() {
		return this.tbReadType;
	}

	public void setTbReadType(TbReadType tbReadType) {
		this.tbReadType = tbReadType;
	}

	public TbExamScheme getTbExamScheme() {
		return this.tbExamScheme;
	}

	public void setTbExamScheme(TbExamScheme tbExamScheme) {
		this.tbExamScheme = tbExamScheme;
	}

	public TbPlanStatus getTbPlanStatus() {
		return this.tbPlanStatus;
	}

	public void setTbPlanStatus(TbPlanStatus tbPlanStatus) {
		this.tbPlanStatus = tbPlanStatus;
	}

	public TbClasses getTbClasses() {
		return this.tbClasses;
	}

	public void setTbClasses(TbClasses tbClasses) {
		this.tbClasses = tbClasses;
	}

	public String getEpMyselfId() {
		return this.epMyselfId;
	}

	public void setEpMyselfId(String epMyselfId) {
		this.epMyselfId = epMyselfId;
	}

	public String getPlanName() {
		return this.planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanDescribe() {
		return this.planDescribe;
	}

	public void setPlanDescribe(String planDescribe) {
		this.planDescribe = planDescribe;
	}

	public String getPlanStartTime() {
		return this.planStartTime;
	}

	public void setPlanStartTime(String planStartTime) {
		this.planStartTime = planStartTime;
	}

	public String getPlanEndTime() {
		return this.planEndTime;
	}

	public void setPlanEndTime(String planEndTime) {
		this.planEndTime = planEndTime;
	}

	public String getPlanReadOverTime() {
		return this.planReadOverTime;
	}

	public void setPlanReadOverTime(String planReadOverTime) {
		this.planReadOverTime = planReadOverTime;
	}

	public String getPlanDel() {
		return this.planDel;
	}

	public void setPlanDel(String planDel) {
		this.planDel = planDel;
	}

	public String getCol1() {
		return this.col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1;
	}

	public String getCol2() {
		return this.col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}

	public String getCol3() {
		return this.col3;
	}

	public void setCol3(String col3) {
		this.col3 = col3;
	}

	public Set getTbExamPapers() {
		return this.tbExamPapers;
	}

	public void setTbExamPapers(Set tbExamPapers) {
		this.tbExamPapers = tbExamPapers;
	}

}