package com.cissst.entity;

/**
 * TbSchemeAudit entity. @author MyEclipse Persistence Tools
 */

public class TbSchemeAudit implements java.io.Serializable {

	// Fields

	private Integer saId;
	private TbUser tbUser;
	private TbExamScheme tbExamScheme;
	private String saTime;
	private String saComment;
	private String saDel;
	private String col1;
	private String col2;
	private String col3;

	// Constructors

	/** default constructor */
	public TbSchemeAudit() {
	}

	/** full constructor */
	public TbSchemeAudit(TbUser tbUser, TbExamScheme tbExamScheme,
			String saTime, String saComment, String saDel, String col1,
			String col2, String col3) {
		this.tbUser = tbUser;
		this.tbExamScheme = tbExamScheme;
		this.saTime = saTime;
		this.saComment = saComment;
		this.saDel = saDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
	}

	// Property accessors

	public Integer getSaId() {
		return this.saId;
	}

	public void setSaId(Integer saId) {
		this.saId = saId;
	}

	public TbUser getTbUser() {
		return this.tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public TbExamScheme getTbExamScheme() {
		return this.tbExamScheme;
	}

	public void setTbExamScheme(TbExamScheme tbExamScheme) {
		this.tbExamScheme = tbExamScheme;
	}

	public String getSaTime() {
		return this.saTime;
	}

	public void setSaTime(String saTime) {
		this.saTime = saTime;
	}

	public String getSaComment() {
		return this.saComment;
	}

	public void setSaComment(String saComment) {
		this.saComment = saComment;
	}

	public String getSaDel() {
		return this.saDel;
	}

	public void setSaDel(String saDel) {
		this.saDel = saDel;
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

}