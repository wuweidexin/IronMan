package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbExamPaperAnswer entity. @author MyEclipse Persistence Tools
 */

public class TbExamPaperAnswer implements java.io.Serializable {

	// Fields

	private Integer epaId;
	private TbExamPaper tbExamPaper;
	private TbProblem tbProblem;
	private Float epaMark;
	private String epaDel;
	private String col1;
	private String col2;
	private String col3;
	private Set tbProblemAnswers = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbExamPaperAnswer() {
	}

	/** full constructor */
	public TbExamPaperAnswer(TbExamPaper tbExamPaper, TbProblem tbProblem,
			Float epaMark, String epaDel, String col1, String col2,
			String col3, Set tbProblemAnswers) {
		this.tbExamPaper = tbExamPaper;
		this.tbProblem = tbProblem;
		this.epaMark = epaMark;
		this.epaDel = epaDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
		this.tbProblemAnswers = tbProblemAnswers;
	}

	// Property accessors

	public Integer getEpaId() {
		return this.epaId;
	}

	public void setEpaId(Integer epaId) {
		this.epaId = epaId;
	}

	public TbExamPaper getTbExamPaper() {
		return this.tbExamPaper;
	}

	public void setTbExamPaper(TbExamPaper tbExamPaper) {
		this.tbExamPaper = tbExamPaper;
	}

	public TbProblem getTbProblem() {
		return this.tbProblem;
	}

	public void setTbProblem(TbProblem tbProblem) {
		this.tbProblem = tbProblem;
	}

	public Float getEpaMark() {
		return this.epaMark;
	}

	public void setEpaMark(Float epaMark) {
		this.epaMark = epaMark;
	}

	public String getEpaDel() {
		return this.epaDel;
	}

	public void setEpaDel(String epaDel) {
		this.epaDel = epaDel;
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

	public Set getTbProblemAnswers() {
		return this.tbProblemAnswers;
	}

	public void setTbProblemAnswers(Set tbProblemAnswers) {
		this.tbProblemAnswers = tbProblemAnswers;
	}

}