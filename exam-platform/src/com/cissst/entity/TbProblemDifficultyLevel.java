package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbProblemDifficultyLevel entity. @author MyEclipse Persistence Tools
 */

public class TbProblemDifficultyLevel implements java.io.Serializable {

	// Fields

	private Integer pdlId;
	private String pdlMyselfId;
	private String pdlName;
	private String pdlDel;
	private String col1;
	private String col2;
	private String col3;
	private Set tbProblems = new HashSet(0);
	private Set tbTacticses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbProblemDifficultyLevel() {
	}

	/** minimal constructor */
	public TbProblemDifficultyLevel(String pdlDel) {
		this.pdlDel = pdlDel;
	}

	/** full constructor */
	public TbProblemDifficultyLevel(String pdlMyselfId, String pdlName,
			String pdlDel, String col1, String col2, String col3,
			Set tbProblems, Set tbTacticses) {
		this.pdlMyselfId = pdlMyselfId;
		this.pdlName = pdlName;
		this.pdlDel = pdlDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
		this.tbProblems = tbProblems;
		this.tbTacticses = tbTacticses;
	}

	// Property accessors

	public Integer getPdlId() {
		return this.pdlId;
	}

	public void setPdlId(Integer pdlId) {
		this.pdlId = pdlId;
	}

	public String getPdlMyselfId() {
		return this.pdlMyselfId;
	}

	public void setPdlMyselfId(String pdlMyselfId) {
		this.pdlMyselfId = pdlMyselfId;
	}

	public String getPdlName() {
		return this.pdlName;
	}

	public void setPdlName(String pdlName) {
		this.pdlName = pdlName;
	}

	public String getPdlDel() {
		return this.pdlDel;
	}

	public void setPdlDel(String pdlDel) {
		this.pdlDel = pdlDel;
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

	public Set getTbProblems() {
		return this.tbProblems;
	}

	public void setTbProblems(Set tbProblems) {
		this.tbProblems = tbProblems;
	}

	public Set getTbTacticses() {
		return this.tbTacticses;
	}

	public void setTbTacticses(Set tbTacticses) {
		this.tbTacticses = tbTacticses;
	}

}