package com.cissst.entity;

/**
 * TbProblemResult entity. @author MyEclipse Persistence Tools
 */

public class TbProblemResult implements java.io.Serializable {

	// Fields

	private Integer prId;
	private TbProblem tbProblem;
	private String prContent;
	private String prTrueIdent;
	private String prDel;
	private String col1;
	private String col2;
	private String col3;

	// Constructors

	/** default constructor */
	public TbProblemResult() {
	}

	/** full constructor */
	public TbProblemResult(TbProblem tbProblem, String prContent,
			String prTrueIdent, String prDel, String col1, String col2,
			String col3) {
		this.tbProblem = tbProblem;
		this.prContent = prContent;
		this.prTrueIdent = prTrueIdent;
		this.prDel = prDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
	}

	// Property accessors

	public Integer getPrId() {
		return this.prId;
	}

	public void setPrId(Integer prId) {
		this.prId = prId;
	}

	public TbProblem getTbProblem() {
		return this.tbProblem;
	}

	public void setTbProblem(TbProblem tbProblem) {
		this.tbProblem = tbProblem;
	}

	public String getPrContent() {
		return this.prContent;
	}

	public void setPrContent(String prContent) {
		this.prContent = prContent;
	}

	public String getPrTrueIdent() {
		return this.prTrueIdent;
	}

	public void setPrTrueIdent(String prTrueIdent) {
		this.prTrueIdent = prTrueIdent;
	}

	public String getPrDel() {
		return this.prDel;
	}

	public void setPrDel(String prDel) {
		this.prDel = prDel;
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