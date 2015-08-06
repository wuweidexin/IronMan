package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbPlanStatus entity. @author MyEclipse Persistence Tools
 */

public class TbPlanStatus implements java.io.Serializable {

	// Fields

	private Integer psId;
	private String psName;
	private String col3;
	private String col2;
	private String psDel;
	private String col1;
	private Set tbExamPlans = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbPlanStatus() {
	}

	/** full constructor */
	public TbPlanStatus(String psName, String col3, String col2, String psDel,
			String col1, Set tbExamPlans) {
		this.psName = psName;
		this.col3 = col3;
		this.col2 = col2;
		this.psDel = psDel;
		this.col1 = col1;
		this.tbExamPlans = tbExamPlans;
	}

	// Property accessors

	public Integer getPsId() {
		return this.psId;
	}

	public void setPsId(Integer psId) {
		this.psId = psId;
	}

	public String getPsName() {
		return this.psName;
	}

	public void setPsName(String psName) {
		this.psName = psName;
	}

	public String getCol3() {
		return this.col3;
	}

	public void setCol3(String col3) {
		this.col3 = col3;
	}

	public String getCol2() {
		return this.col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}

	public String getPsDel() {
		return this.psDel;
	}

	public void setPsDel(String psDel) {
		this.psDel = psDel;
	}

	public String getCol1() {
		return this.col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1;
	}

	public Set getTbExamPlans() {
		return this.tbExamPlans;
	}

	public void setTbExamPlans(Set tbExamPlans) {
		this.tbExamPlans = tbExamPlans;
	}

}