package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbProblem entity. @author MyEclipse Persistence Tools
 */

public class TbProblem implements java.io.Serializable {

	// Fields

	private Integer PId;
	private TbProblemType tbProblemType;
	private TbProblemDifficultyLevel tbProblemDifficultyLevel;
	private TbAuditStatus tbAuditStatus;
	private TbUser tbUser;
	private TbProblemScore tbProblemScore;
	private String PAddTime;
	private String PTitle;
	private String PDel;
	private String col1;
	private String col2;
	private String col3;
	private Set tbExamPaperAnswers = new HashSet(0);
	private Set tbTacticsDetails = new HashSet(0);
	private Set tbProblemResults = new HashSet(0);
	private Set tbProblemAudits = new HashSet(0);
	private Set tbExamSchemeProblems = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbProblem() {
	}

	/** full constructor */
	public TbProblem(TbProblemType tbProblemType,
			TbProblemDifficultyLevel tbProblemDifficultyLevel,
			TbAuditStatus tbAuditStatus, TbUser tbUser,
			TbProblemScore tbProblemScore, String PAddTime, String PTitle,
			String PDel, String col1, String col2, String col3,
			Set tbExamPaperAnswers, Set tbTacticsDetails, Set tbProblemResults,
			Set tbProblemAudits, Set tbExamSchemeProblems) {
		this.tbProblemType = tbProblemType;
		this.tbProblemDifficultyLevel = tbProblemDifficultyLevel;
		this.tbAuditStatus = tbAuditStatus;
		this.tbUser = tbUser;
		this.tbProblemScore = tbProblemScore;
		this.PAddTime = PAddTime;
		this.PTitle = PTitle;
		this.PDel = PDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
		this.tbExamPaperAnswers = tbExamPaperAnswers;
		this.tbTacticsDetails = tbTacticsDetails;
		this.tbProblemResults = tbProblemResults;
		this.tbProblemAudits = tbProblemAudits;
		this.tbExamSchemeProblems = tbExamSchemeProblems;
	}

	// Property accessors

	public Integer getPId() {
		return this.PId;
	}

	public void setPId(Integer PId) {
		this.PId = PId;
	}

	public TbProblemType getTbProblemType() {
		return this.tbProblemType;
	}

	public void setTbProblemType(TbProblemType tbProblemType) {
		this.tbProblemType = tbProblemType;
	}

	public TbProblemDifficultyLevel getTbProblemDifficultyLevel() {
		return this.tbProblemDifficultyLevel;
	}

	public void setTbProblemDifficultyLevel(
			TbProblemDifficultyLevel tbProblemDifficultyLevel) {
		this.tbProblemDifficultyLevel = tbProblemDifficultyLevel;
	}

	public TbAuditStatus getTbAuditStatus() {
		return this.tbAuditStatus;
	}

	public void setTbAuditStatus(TbAuditStatus tbAuditStatus) {
		this.tbAuditStatus = tbAuditStatus;
	}

	public TbUser getTbUser() {
		return this.tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public TbProblemScore getTbProblemScore() {
		return this.tbProblemScore;
	}

	public void setTbProblemScore(TbProblemScore tbProblemScore) {
		this.tbProblemScore = tbProblemScore;
	}

	public String getPAddTime() {
		return this.PAddTime;
	}

	public void setPAddTime(String PAddTime) {
		this.PAddTime = PAddTime;
	}

	public String getPTitle() {
		return this.PTitle;
	}

	public void setPTitle(String PTitle) {
		this.PTitle = PTitle;
	}

	public String getPDel() {
		return this.PDel;
	}

	public void setPDel(String PDel) {
		this.PDel = PDel;
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

	public Set getTbExamPaperAnswers() {
		return this.tbExamPaperAnswers;
	}

	public void setTbExamPaperAnswers(Set tbExamPaperAnswers) {
		this.tbExamPaperAnswers = tbExamPaperAnswers;
	}

	public Set getTbTacticsDetails() {
		return this.tbTacticsDetails;
	}

	public void setTbTacticsDetails(Set tbTacticsDetails) {
		this.tbTacticsDetails = tbTacticsDetails;
	}

	public Set getTbProblemResults() {
		return this.tbProblemResults;
	}

	public void setTbProblemResults(Set tbProblemResults) {
		this.tbProblemResults = tbProblemResults;
	}

	public Set getTbProblemAudits() {
		return this.tbProblemAudits;
	}

	public void setTbProblemAudits(Set tbProblemAudits) {
		this.tbProblemAudits = tbProblemAudits;
	}

	public Set getTbExamSchemeProblems() {
		return this.tbExamSchemeProblems;
	}

	public void setTbExamSchemeProblems(Set tbExamSchemeProblems) {
		this.tbExamSchemeProblems = tbExamSchemeProblems;
	}

}