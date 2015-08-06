package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbTactics entity. @author MyEclipse Persistence Tools
 */

public class TbTactics implements java.io.Serializable {

	// Fields

	private Integer TId;
	private TbProblemType tbProblemType;
	private TbProblemDifficultyLevel tbProblemDifficultyLevel;
	private TbReadType tbReadType;
	private TbProblemScore tbProblemScore;
	private String TGetTitleMethod;
	private Integer TEveryMark;
	private String TProblemNum;
	private String TDel;
	private String col1;
	private String col2;
	private String col3;
	private Set tbExamSchemeDetails = new HashSet(0);
	private Set tbTacticsDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbTactics() {
	}

	/** full constructor */
	public TbTactics(TbProblemType tbProblemType,
			TbProblemDifficultyLevel tbProblemDifficultyLevel,
			TbReadType tbReadType, TbProblemScore tbProblemScore,
			String TGetTitleMethod, Integer TEveryMark, String TProblemNum,
			String TDel, String col1, String col2, String col3,
			Set tbExamSchemeDetails, Set tbTacticsDetails) {
		this.tbProblemType = tbProblemType;
		this.tbProblemDifficultyLevel = tbProblemDifficultyLevel;
		this.tbReadType = tbReadType;
		this.tbProblemScore = tbProblemScore;
		this.TGetTitleMethod = TGetTitleMethod;
		this.TEveryMark = TEveryMark;
		this.TProblemNum = TProblemNum;
		this.TDel = TDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
		this.tbExamSchemeDetails = tbExamSchemeDetails;
		this.tbTacticsDetails = tbTacticsDetails;
	}

	// Property accessors

	public Integer getTId() {
		return this.TId;
	}

	public void setTId(Integer TId) {
		this.TId = TId;
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

	public TbReadType getTbReadType() {
		return this.tbReadType;
	}

	public void setTbReadType(TbReadType tbReadType) {
		this.tbReadType = tbReadType;
	}

	public TbProblemScore getTbProblemScore() {
		return this.tbProblemScore;
	}

	public void setTbProblemScore(TbProblemScore tbProblemScore) {
		this.tbProblemScore = tbProblemScore;
	}

	public String getTGetTitleMethod() {
		return this.TGetTitleMethod;
	}

	public void setTGetTitleMethod(String TGetTitleMethod) {
		this.TGetTitleMethod = TGetTitleMethod;
	}

	public Integer getTEveryMark() {
		return this.TEveryMark;
	}

	public void setTEveryMark(Integer TEveryMark) {
		this.TEveryMark = TEveryMark;
	}

	public String getTProblemNum() {
		return this.TProblemNum;
	}

	public void setTProblemNum(String TProblemNum) {
		this.TProblemNum = TProblemNum;
	}

	public String getTDel() {
		return this.TDel;
	}

	public void setTDel(String TDel) {
		this.TDel = TDel;
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

	public Set getTbExamSchemeDetails() {
		return this.tbExamSchemeDetails;
	}

	public void setTbExamSchemeDetails(Set tbExamSchemeDetails) {
		this.tbExamSchemeDetails = tbExamSchemeDetails;
	}

	public Set getTbTacticsDetails() {
		return this.tbTacticsDetails;
	}

	public void setTbTacticsDetails(Set tbTacticsDetails) {
		this.tbTacticsDetails = tbTacticsDetails;
	}

}