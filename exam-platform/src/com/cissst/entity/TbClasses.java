package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbClasses entity. @author MyEclipse Persistence Tools
 */

public class TbClasses implements java.io.Serializable {

	// Fields

	private Integer CId;
	private TbUser tbUser;
	private TbClassType tbClassType;
	private TbClazzStatus tbClazzStatus;
	private String CNum;
	private String CName;
	private String CStartTime;
	private String CEndTime;
	private String col3;
	private String col2;
	private String CDel;
	private String col1;
	private Set tbStudents = new HashSet(0);
	private Set tbExamPlans = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbClasses() {
	}

	/** full constructor */
	public TbClasses(TbUser tbUser, TbClassType tbClassType,
			TbClazzStatus tbClazzStatus, String CNum, String CName,
			String CStartTime, String CEndTime, String col3, String col2,
			String CDel, String col1, Set tbStudents, Set tbExamPlans) {
		this.tbUser = tbUser;
		this.tbClassType = tbClassType;
		this.tbClazzStatus = tbClazzStatus;
		this.CNum = CNum;
		this.CName = CName;
		this.CStartTime = CStartTime;
		this.CEndTime = CEndTime;
		this.col3 = col3;
		this.col2 = col2;
		this.CDel = CDel;
		this.col1 = col1;
		this.tbStudents = tbStudents;
		this.tbExamPlans = tbExamPlans;
	}

	// Property accessors

	public Integer getCId() {
		return this.CId;
	}

	public void setCId(Integer CId) {
		this.CId = CId;
	}

	public TbUser getTbUser() {
		return this.tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public TbClassType getTbClassType() {
		return this.tbClassType;
	}

	public void setTbClassType(TbClassType tbClassType) {
		this.tbClassType = tbClassType;
	}

	public TbClazzStatus getTbClazzStatus() {
		return this.tbClazzStatus;
	}

	public void setTbClazzStatus(TbClazzStatus tbClazzStatus) {
		this.tbClazzStatus = tbClazzStatus;
	}

	public String getCNum() {
		return this.CNum;
	}

	public void setCNum(String CNum) {
		this.CNum = CNum;
	}

	public String getCName() {
		return this.CName;
	}

	public void setCName(String CName) {
		this.CName = CName;
	}

	public String getCStartTime() {
		return this.CStartTime;
	}

	public void setCStartTime(String CStartTime) {
		this.CStartTime = CStartTime;
	}

	public String getCEndTime() {
		return this.CEndTime;
	}

	public void setCEndTime(String CEndTime) {
		this.CEndTime = CEndTime;
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

	public String getCDel() {
		return this.CDel;
	}

	public void setCDel(String CDel) {
		this.CDel = CDel;
	}

	public String getCol1() {
		return this.col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1;
	}

	public Set getTbStudents() {
		return this.tbStudents;
	}

	public void setTbStudents(Set tbStudents) {
		this.tbStudents = tbStudents;
	}

	public Set getTbExamPlans() {
		return this.tbExamPlans;
	}

	public void setTbExamPlans(Set tbExamPlans) {
		this.tbExamPlans = tbExamPlans;
	}

}