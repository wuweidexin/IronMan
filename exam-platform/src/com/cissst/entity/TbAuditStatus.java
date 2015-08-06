package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbAuditStatus entity. @author MyEclipse Persistence Tools
 */

public class TbAuditStatus implements java.io.Serializable {

	// Fields

	private Integer asId;
	private String asName;
	private String asDel;
	private String col1;
	private String col2;
	private String col3;
	private Set tbExamSchemes = new HashSet(0);
	private Set tbProblems = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbAuditStatus() {
	}

	/** full constructor */
	public TbAuditStatus(String asName, String asDel, String col1, String col2,
			String col3, Set tbExamSchemes, Set tbProblems) {
		this.asName = asName;
		this.asDel = asDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
		this.tbExamSchemes = tbExamSchemes;
		this.tbProblems = tbProblems;
	}

	// Property accessors

	public Integer getAsId() {
		return this.asId;
	}

	public void setAsId(Integer asId) {
		this.asId = asId;
	}

	public String getAsName() {
		return this.asName;
	}

	public void setAsName(String asName) {
		this.asName = asName;
	}

	public String getAsDel() {
		return this.asDel;
	}

	public void setAsDel(String asDel) {
		this.asDel = asDel;
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

	public Set getTbExamSchemes() {
		return this.tbExamSchemes;
	}

	public void setTbExamSchemes(Set tbExamSchemes) {
		this.tbExamSchemes = tbExamSchemes;
	}

	public Set getTbProblems() {
		return this.tbProblems;
	}

	public void setTbProblems(Set tbProblems) {
		this.tbProblems = tbProblems;
	}

}