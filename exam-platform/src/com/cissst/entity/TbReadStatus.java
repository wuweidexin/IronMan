package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbReadStatus entity. @author MyEclipse Persistence Tools
 */

public class TbReadStatus implements java.io.Serializable {

	// Fields

	private Integer rsId;
	private String rsName;
	private String col1;
	private String col2;
	private String col3;
	private String rsDel;
	private Set tbExamPlans = new HashSet(0);
	private Set tbExamPapers = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbReadStatus() {
	}

	/** full constructor */
	public TbReadStatus(String rsName, String col1, String col2, String col3,
			String rsDel, Set tbExamPlans, Set tbExamPapers) {
		this.rsName = rsName;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
		this.rsDel = rsDel;
		this.tbExamPlans = tbExamPlans;
		this.tbExamPapers = tbExamPapers;
	}

	// Property accessors

	public Integer getRsId() {
		return this.rsId;
	}

	public void setRsId(Integer rsId) {
		this.rsId = rsId;
	}

	public String getRsName() {
		return this.rsName;
	}

	public void setRsName(String rsName) {
		this.rsName = rsName;
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

	public String getRsDel() {
		return this.rsDel;
	}

	public void setRsDel(String rsDel) {
		this.rsDel = rsDel;
	}

	public Set getTbExamPlans() {
		return this.tbExamPlans;
	}

	public void setTbExamPlans(Set tbExamPlans) {
		this.tbExamPlans = tbExamPlans;
	}

	public Set getTbExamPapers() {
		return this.tbExamPapers;
	}

	public void setTbExamPapers(Set tbExamPapers) {
		this.tbExamPapers = tbExamPapers;
	}

}