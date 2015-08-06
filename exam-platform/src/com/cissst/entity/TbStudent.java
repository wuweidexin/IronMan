package com.cissst.entity;

/**
 * TbStudent entity. @author MyEclipse Persistence Tools
 */

public class TbStudent implements java.io.Serializable {

	// Fields

	private Integer stuId;
	private TbStudentStatus tbStudentStatus;
	private TbUser tbUser;
	private TbClasses tbClasses;
	private TbStudentType tbStudentType;
	private String col3;
	private String col2;
	private String stuDel;
	private String col1;

	// Constructors

	/** default constructor */
	public TbStudent() {
	}

	/** full constructor */
	public TbStudent(TbStudentStatus tbStudentStatus, TbUser tbUser,
			TbClasses tbClasses, TbStudentType tbStudentType, String col3,
			String col2, String stuDel, String col1) {
		this.tbStudentStatus = tbStudentStatus;
		this.tbUser = tbUser;
		this.tbClasses = tbClasses;
		this.tbStudentType = tbStudentType;
		this.col3 = col3;
		this.col2 = col2;
		this.stuDel = stuDel;
		this.col1 = col1;
	}

	// Property accessors

	public Integer getStuId() {
		return this.stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public TbStudentStatus getTbStudentStatus() {
		return this.tbStudentStatus;
	}

	public void setTbStudentStatus(TbStudentStatus tbStudentStatus) {
		this.tbStudentStatus = tbStudentStatus;
	}

	public TbUser getTbUser() {
		return this.tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public TbClasses getTbClasses() {
		return this.tbClasses;
	}

	public void setTbClasses(TbClasses tbClasses) {
		this.tbClasses = tbClasses;
	}

	public TbStudentType getTbStudentType() {
		return this.tbStudentType;
	}

	public void setTbStudentType(TbStudentType tbStudentType) {
		this.tbStudentType = tbStudentType;
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

	public String getStuDel() {
		return this.stuDel;
	}

	public void setStuDel(String stuDel) {
		this.stuDel = stuDel;
	}

	public String getCol1() {
		return this.col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1;
	}

}