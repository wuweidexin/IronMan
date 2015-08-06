package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbExamPaper entity. @author MyEclipse Persistence Tools
 */

public class TbExamPaper implements java.io.Serializable {

	// Fields

	private Integer epId;
	private TbReadStatus tbReadStatus;
	private TbUser tbUser;
	private TbExamPlan tbExamPlan;
	private Float epTotalMark;
	private String col2;
	private String epDel;
	private String col1;
	private String col3;
	private Set tbExamPaperAnswers = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbExamPaper() {
	}

	/** full constructor */
	public TbExamPaper(TbReadStatus tbReadStatus, TbUser tbUser,
			TbExamPlan tbExamPlan, Float epTotalMark, String col2,
			String epDel, String col1, String col3, Set tbExamPaperAnswers) {
		this.tbReadStatus = tbReadStatus;
		this.tbUser = tbUser;
		this.tbExamPlan = tbExamPlan;
		this.epTotalMark = epTotalMark;
		this.col2 = col2;
		this.epDel = epDel;
		this.col1 = col1;
		this.col3 = col3;
		this.tbExamPaperAnswers = tbExamPaperAnswers;
	}

	// Property accessors

	public Integer getEpId() {
		return this.epId;
	}

	public void setEpId(Integer epId) {
		this.epId = epId;
	}

	public TbReadStatus getTbReadStatus() {
		return this.tbReadStatus;
	}

	public void setTbReadStatus(TbReadStatus tbReadStatus) {
		this.tbReadStatus = tbReadStatus;
	}

	public TbUser getTbUser() {
		return this.tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public TbExamPlan getTbExamPlan() {
		return this.tbExamPlan;
	}

	public void setTbExamPlan(TbExamPlan tbExamPlan) {
		this.tbExamPlan = tbExamPlan;
	}

	public Float getEpTotalMark() {
		return this.epTotalMark;
	}

	public void setEpTotalMark(Float epTotalMark) {
		this.epTotalMark = epTotalMark;
	}

	public String getCol2() {
		return this.col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}

	public String getEpDel() {
		return this.epDel;
	}

	public void setEpDel(String epDel) {
		this.epDel = epDel;
	}

	public String getCol1() {
		return this.col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1;
	}

	public String getCol3() {
		return this.col3;
	}

	public void setCol3(String col3) {
		this.col3 = col3;
	}

	public Set getTbExamPaperAnswers() {
		return this.tbExamPaperAnswers;
	}

	public void setTbExamPaperAnswers(Set tbExamPaperAnswers) {
		this.tbExamPaperAnswers = tbExamPaperAnswers;
	}

}