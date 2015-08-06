package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbStudentStatus entity. @author MyEclipse Persistence Tools
 */

public class TbStudentStatus implements java.io.Serializable {

	// Fields

	private Integer ssId;
	private String ssName;
	private String ssDel;
	private String col1;
	private String col2;
	private String col3;
	private Set tbStudents = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbStudentStatus() {
	}

	/** full constructor */
	public TbStudentStatus(String ssName, String ssDel, String col1,
			String col2, String col3, Set tbStudents) {
		this.ssName = ssName;
		this.ssDel = ssDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
		this.tbStudents = tbStudents;
	}

	// Property accessors

	public Integer getSsId() {
		return this.ssId;
	}

	public void setSsId(Integer ssId) {
		this.ssId = ssId;
	}

	public String getSsName() {
		return this.ssName;
	}

	public void setSsName(String ssName) {
		this.ssName = ssName;
	}

	public String getSsDel() {
		return this.ssDel;
	}

	public void setSsDel(String ssDel) {
		this.ssDel = ssDel;
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

	public Set getTbStudents() {
		return this.tbStudents;
	}

	public void setTbStudents(Set tbStudents) {
		this.tbStudents = tbStudents;
	}

}