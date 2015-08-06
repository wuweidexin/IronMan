package com.cissst.entity;

/**
 * TbProblemAnswer entity. @author MyEclipse Persistence Tools
 */

public class TbProblemAnswer implements java.io.Serializable {

	// Fields

	private Integer paId;
	private TbExamPaperAnswer tbExamPaperAnswer;
	private String paComment;
	private String paDel;
	private String col1;
	private String col2;
	private String col3;

	// Constructors

	/** default constructor */
	public TbProblemAnswer() {
	}

	/** full constructor */
	public TbProblemAnswer(TbExamPaperAnswer tbExamPaperAnswer,
			String paComment, String paDel, String col1, String col2,
			String col3) {
		this.tbExamPaperAnswer = tbExamPaperAnswer;
		this.paComment = paComment;
		this.paDel = paDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
	}

	// Property accessors

	public Integer getPaId() {
		return this.paId;
	}

	public void setPaId(Integer paId) {
		this.paId = paId;
	}

	public TbExamPaperAnswer getTbExamPaperAnswer() {
		return this.tbExamPaperAnswer;
	}

	public void setTbExamPaperAnswer(TbExamPaperAnswer tbExamPaperAnswer) {
		this.tbExamPaperAnswer = tbExamPaperAnswer;
	}

	public String getPaComment() {
		return this.paComment;
	}

	public void setPaComment(String paComment) {
		this.paComment = paComment;
	}

	public String getPaDel() {
		return this.paDel;
	}

	public void setPaDel(String paDel) {
		this.paDel = paDel;
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