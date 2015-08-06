package com.cissst.entity;

/**
 * TbTacticsDetail entity. @author MyEclipse Persistence Tools
 */

public class TbTacticsDetail implements java.io.Serializable {

	// Fields

	private Integer tdId;
	private TbTactics tbTactics;
	private TbProblem tbProblem;
	private String tdDelIdent;
	private String col1;
	private String col2;
	private String col3;

	// Constructors

	/** default constructor */
	public TbTacticsDetail() {
	}

	/** full constructor */
	public TbTacticsDetail(TbTactics tbTactics, TbProblem tbProblem,
			String tdDelIdent, String col1, String col2, String col3) {
		this.tbTactics = tbTactics;
		this.tbProblem = tbProblem;
		this.tdDelIdent = tdDelIdent;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
	}

	// Property accessors

	public Integer getTdId() {
		return this.tdId;
	}

	public void setTdId(Integer tdId) {
		this.tdId = tdId;
	}

	public TbTactics getTbTactics() {
		return this.tbTactics;
	}

	public void setTbTactics(TbTactics tbTactics) {
		this.tbTactics = tbTactics;
	}

	public TbProblem getTbProblem() {
		return this.tbProblem;
	}

	public void setTbProblem(TbProblem tbProblem) {
		this.tbProblem = tbProblem;
	}

	public String getTdDelIdent() {
		return this.tdDelIdent;
	}

	public void setTdDelIdent(String tdDelIdent) {
		this.tdDelIdent = tdDelIdent;
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