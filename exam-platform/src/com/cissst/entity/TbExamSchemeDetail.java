package com.cissst.entity;

/**
 * TbExamSchemeDetail entity. @author MyEclipse Persistence Tools
 */

public class TbExamSchemeDetail implements java.io.Serializable {

	// Fields

	private Integer esdId;
	private TbTactics tbTactics;
	private TbExamScheme tbExamScheme;
	private String esdDel;
	private String col1;
	private String col2;
	private String col3;

	// Constructors

	/** default constructor */
	public TbExamSchemeDetail() {
	}

	/** full constructor */
	public TbExamSchemeDetail(TbTactics tbTactics, TbExamScheme tbExamScheme,
			String esdDel, String col1, String col2, String col3) {
		this.tbTactics = tbTactics;
		this.tbExamScheme = tbExamScheme;
		this.esdDel = esdDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
	}

	// Property accessors

	public Integer getEsdId() {
		return this.esdId;
	}

	public void setEsdId(Integer esdId) {
		this.esdId = esdId;
	}

	public TbTactics getTbTactics() {
		return this.tbTactics;
	}

	public void setTbTactics(TbTactics tbTactics) {
		this.tbTactics = tbTactics;
	}

	public TbExamScheme getTbExamScheme() {
		return this.tbExamScheme;
	}

	public void setTbExamScheme(TbExamScheme tbExamScheme) {
		this.tbExamScheme = tbExamScheme;
	}

	public String getEsdDel() {
		return this.esdDel;
	}

	public void setEsdDel(String esdDel) {
		this.esdDel = esdDel;
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