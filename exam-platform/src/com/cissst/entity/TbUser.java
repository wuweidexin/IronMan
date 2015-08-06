package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbUser entity. @author MyEclipse Persistence Tools
 */

public class TbUser implements java.io.Serializable {

	// Fields

	private Integer UId;
	private TbUserType tbUserType;
	private String UAccount;
	private String UName;
	private String UPwd;
	private String UGender;
	private String UEmail;
	private String UHiretime;
	private String ULastLoginTime;
	private String UDel;
	private String col1;
	private String col2;
	private String col3;
	private Set tbProblems = new HashSet(0);
	private Set tbStudents = new HashSet(0);
	private Set tbClasseses = new HashSet(0);
	private Set tbExamPapers = new HashSet(0);
	private Set tbSchemeAudits = new HashSet(0);
	private Set tbProblemAudits = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbUser() {
	}

	/** full constructor */
	public TbUser(TbUserType tbUserType, String UAccount, String UName,
			String UPwd, String UGender, String UEmail, String UHiretime,
			String ULastLoginTime, String UDel, String col1, String col2,
			String col3, Set tbProblems, Set tbStudents, Set tbClasseses,
			Set tbExamPapers, Set tbSchemeAudits, Set tbProblemAudits) {
		this.tbUserType = tbUserType;
		this.UAccount = UAccount;
		this.UName = UName;
		this.UPwd = UPwd;
		this.UGender = UGender;
		this.UEmail = UEmail;
		this.UHiretime = UHiretime;
		this.ULastLoginTime = ULastLoginTime;
		this.UDel = UDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
		this.tbProblems = tbProblems;
		this.tbStudents = tbStudents;
		this.tbClasseses = tbClasseses;
		this.tbExamPapers = tbExamPapers;
		this.tbSchemeAudits = tbSchemeAudits;
		this.tbProblemAudits = tbProblemAudits;
	}

	// Property accessors

	public Integer getUId() {
		return this.UId;
	}

	public void setUId(Integer UId) {
		this.UId = UId;
	}

	public TbUserType getTbUserType() {
		return this.tbUserType;
	}

	public void setTbUserType(TbUserType tbUserType) {
		this.tbUserType = tbUserType;
	}

	public String getUAccount() {
		return this.UAccount;
	}

	public void setUAccount(String UAccount) {
		this.UAccount = UAccount;
	}

	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

	public String getUPwd() {
		return this.UPwd;
	}

	public void setUPwd(String UPwd) {
		this.UPwd = UPwd;
	}

	public String getUGender() {
		return this.UGender;
	}

	public void setUGender(String UGender) {
		this.UGender = UGender;
	}

	public String getUEmail() {
		return this.UEmail;
	}

	public void setUEmail(String UEmail) {
		this.UEmail = UEmail;
	}

	public String getUHiretime() {
		return this.UHiretime;
	}

	public void setUHiretime(String UHiretime) {
		this.UHiretime = UHiretime;
	}

	public String getULastLoginTime() {
		return this.ULastLoginTime;
	}

	public void setULastLoginTime(String ULastLoginTime) {
		this.ULastLoginTime = ULastLoginTime;
	}

	public String getUDel() {
		return this.UDel;
	}

	public void setUDel(String UDel) {
		this.UDel = UDel;
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

	public Set getTbProblems() {
		return this.tbProblems;
	}

	public void setTbProblems(Set tbProblems) {
		this.tbProblems = tbProblems;
	}

	public Set getTbStudents() {
		return this.tbStudents;
	}

	public void setTbStudents(Set tbStudents) {
		this.tbStudents = tbStudents;
	}

	public Set getTbClasseses() {
		return this.tbClasseses;
	}

	public void setTbClasseses(Set tbClasseses) {
		this.tbClasseses = tbClasseses;
	}

	public Set getTbExamPapers() {
		return this.tbExamPapers;
	}

	public void setTbExamPapers(Set tbExamPapers) {
		this.tbExamPapers = tbExamPapers;
	}

	public Set getTbSchemeAudits() {
		return this.tbSchemeAudits;
	}

	public void setTbSchemeAudits(Set tbSchemeAudits) {
		this.tbSchemeAudits = tbSchemeAudits;
	}

	public Set getTbProblemAudits() {
		return this.tbProblemAudits;
	}

	public void setTbProblemAudits(Set tbProblemAudits) {
		this.tbProblemAudits = tbProblemAudits;
	}

}