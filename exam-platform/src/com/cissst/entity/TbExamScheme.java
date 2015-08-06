package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbExamScheme entity. @author MyEclipse Persistence Tools
 */

public class TbExamScheme implements java.io.Serializable {

	// Fields

	private Integer esId;
	private TbAuditStatus tbAuditStatus;
	private String esMyselfId;
	private String esName;
	private String esDescribe;
	private String esAddUser;
	private String esAddTime;
	private String esDel;
	private String col1;
	private String col2;
	private String col3;
	private Set tbExamPlans = new HashSet(0);
	private Set tbExamSchemeProblems = new HashSet(0);
	private Set tbSchemeAudits = new HashSet(0);
	private Set tbExamSchemeDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbExamScheme() {
	}

	/** full constructor */
	public TbExamScheme(TbAuditStatus tbAuditStatus, String esMyselfId,
			String esName, String esDescribe, String esAddUser,
			String esAddTime, String esDel, String col1, String col2,
			String col3, Set tbExamPlans, Set tbExamSchemeProblems,
			Set tbSchemeAudits, Set tbExamSchemeDetails) {
		this.tbAuditStatus = tbAuditStatus;
		this.esMyselfId = esMyselfId;
		this.esName = esName;
		this.esDescribe = esDescribe;
		this.esAddUser = esAddUser;
		this.esAddTime = esAddTime;
		this.esDel = esDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
		this.tbExamPlans = tbExamPlans;
		this.tbExamSchemeProblems = tbExamSchemeProblems;
		this.tbSchemeAudits = tbSchemeAudits;
		this.tbExamSchemeDetails = tbExamSchemeDetails;
	}

	// Property accessors

	public Integer getEsId() {
		return this.esId;
	}

	public void setEsId(Integer esId) {
		this.esId = esId;
	}

	public TbAuditStatus getTbAuditStatus() {
		return this.tbAuditStatus;
	}

	public void setTbAuditStatus(TbAuditStatus tbAuditStatus) {
		this.tbAuditStatus = tbAuditStatus;
	}

	public String getEsMyselfId() {
		return this.esMyselfId;
	}

	public void setEsMyselfId(String esMyselfId) {
		this.esMyselfId = esMyselfId;
	}

	public String getEsName() {
		return this.esName;
	}

	public void setEsName(String esName) {
		this.esName = esName;
	}

	public String getEsDescribe() {
		return this.esDescribe;
	}

	public void setEsDescribe(String esDescribe) {
		this.esDescribe = esDescribe;
	}

	public String getEsAddUser() {
		return this.esAddUser;
	}

	public void setEsAddUser(String esAddUser) {
		this.esAddUser = esAddUser;
	}

	public String getEsAddTime() {
		return this.esAddTime;
	}

	public void setEsAddTime(String esAddTime) {
		this.esAddTime = esAddTime;
	}

	public String getEsDel() {
		return this.esDel;
	}

	public void setEsDel(String esDel) {
		this.esDel = esDel;
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

	public Set getTbExamPlans() {
		return this.tbExamPlans;
	}

	public void setTbExamPlans(Set tbExamPlans) {
		this.tbExamPlans = tbExamPlans;
	}

	public Set getTbExamSchemeProblems() {
		return this.tbExamSchemeProblems;
	}

	public void setTbExamSchemeProblems(Set tbExamSchemeProblems) {
		this.tbExamSchemeProblems = tbExamSchemeProblems;
	}

	public Set getTbSchemeAudits() {
		return this.tbSchemeAudits;
	}

	public void setTbSchemeAudits(Set tbSchemeAudits) {
		this.tbSchemeAudits = tbSchemeAudits;
	}

	public Set getTbExamSchemeDetails() {
		return this.tbExamSchemeDetails;
	}

	public void setTbExamSchemeDetails(Set tbExamSchemeDetails) {
		this.tbExamSchemeDetails = tbExamSchemeDetails;
	}

}