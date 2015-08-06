package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbStudentType entity. @author MyEclipse Persistence Tools
 */

public class TbStudentType implements java.io.Serializable {

	// Fields

	private Integer stId;
	private String stMyselfId;
	private String stName;
	private String stDel;
	private String col1;
	private String col2;
	private String col3;
	private Set tbStudents = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbStudentType() {
	}

	/** full constructor */
	public TbStudentType(String stMyselfId, String stName, String stDel,
			String col1, String col2, String col3, Set tbStudents) {
		this.stMyselfId = stMyselfId;
		this.stName = stName;
		this.stDel = stDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
		this.tbStudents = tbStudents;
	}

	// Property accessors

	public Integer getStId() {
		return this.stId;
	}

	public void setStId(Integer stId) {
		this.stId = stId;
	}

	public String getStMyselfId() {
		return this.stMyselfId;
	}

	public void setStMyselfId(String stMyselfId) {
		this.stMyselfId = stMyselfId;
	}

	public String getStName() {
		return this.stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getStDel() {
		return this.stDel;
	}

	public void setStDel(String stDel) {
		this.stDel = stDel;
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