package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbProblemScore entity. @author MyEclipse Persistence Tools
 */

public class TbProblemScore implements java.io.Serializable {

	// Fields

	private Integer psId;
	private String psMyselfId;
	private String psName;
	private String psDel;
	private String col1;
	private String col2;
	private String col3;
	private Set tbTacticses = new HashSet(0);
	private Set tbProblems = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbProblemScore() {
	}

	/** full constructor */
	public TbProblemScore(String psMyselfId, String psName, String psDel,
			String col1, String col2, String col3, Set tbTacticses,
			Set tbProblems) {
		this.psMyselfId = psMyselfId;
		this.psName = psName;
		this.psDel = psDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
		this.tbTacticses = tbTacticses;
		this.tbProblems = tbProblems;
	}

	// Property accessors

	public Integer getPsId() {
		return this.psId;
	}

	public void setPsId(Integer psId) {
		this.psId = psId;
	}

	public String getPsMyselfId() {
		return this.psMyselfId;
	}

	public void setPsMyselfId(String psMyselfId) {
		this.psMyselfId = psMyselfId;
	}

	public String getPsName() {
		return this.psName;
	}

	public void setPsName(String psName) {
		this.psName = psName;
	}

	public String getPsDel() {
		return this.psDel;
	}

	public void setPsDel(String psDel) {
		this.psDel = psDel;
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

	public Set getTbTacticses() {
		return this.tbTacticses;
	}

	public void setTbTacticses(Set tbTacticses) {
		this.tbTacticses = tbTacticses;
	}

	public Set getTbProblems() {
		return this.tbProblems;
	}

	public void setTbProblems(Set tbProblems) {
		this.tbProblems = tbProblems;
	}

}