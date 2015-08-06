package com.cissst.entity;

/**
 * TbExamSchemeProblem entity. @author MyEclipse Persistence Tools
 */

public class TbExamSchemeProblem implements java.io.Serializable {

	// Fields

	private Integer espId;
	private TbExamScheme tbExamScheme;
	private TbProblem tbProblem;
	private String espDel;
	private String col1;
	private String col2;
	private String col3;

	// Constructors

	/** default constructor */
	public TbExamSchemeProblem() {
	}

	/** full constructor */
	public TbExamSchemeProblem(TbExamScheme tbExamScheme, TbProblem tbProblem,
			String espDel, String col1, String col2, String col3) {
		this.tbExamScheme = tbExamScheme;
		this.tbProblem = tbProblem;
		this.espDel = espDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
	}

	// Property accessors

	public Integer getEspId() {
		return this.espId;
	}

	public void setEspId(Integer espId) {
		this.espId = espId;
	}

	public TbExamScheme getTbExamScheme() {
		return this.tbExamScheme;
	}

	public void setTbExamScheme(TbExamScheme tbExamScheme) {
		this.tbExamScheme = tbExamScheme;
	}

	public TbProblem getTbProblem() {
		return this.tbProblem;
	}

	public void setTbProblem(TbProblem tbProblem) {
		this.tbProblem = tbProblem;
	}

	public String getEspDel() {
		return this.espDel;
	}

	public void setEspDel(String espDel) {
		this.espDel = espDel;
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