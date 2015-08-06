package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbProblemType entity. @author MyEclipse Persistence Tools
 */

public class TbProblemType implements java.io.Serializable {

	// Fields

	private Integer ptId;
	private String ptMyselfId;
	private String ptName;
	private String ptDel;
	private String col1;
	private String col2;
	private String col3;
	private Set tbTacticses = new HashSet(0);
	private Set tbProblems = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbProblemType() {
	}

	/** full constructor */
	public TbProblemType(String ptMyselfId, String ptName, String ptDel,
			String col1, String col2, String col3, Set tbTacticses,
			Set tbProblems) {
		this.ptMyselfId = ptMyselfId;
		this.ptName = ptName;
		this.ptDel = ptDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
		this.tbTacticses = tbTacticses;
		this.tbProblems = tbProblems;
	}

	// Property accessors

	public Integer getPtId() {
		return this.ptId;
	}

	public void setPtId(Integer ptId) {
		this.ptId = ptId;
	}

	public String getPtMyselfId() {
		return this.ptMyselfId;
	}

	public void setPtMyselfId(String ptMyselfId) {
		this.ptMyselfId = ptMyselfId;
	}

	public String getPtName() {
		return this.ptName;
	}

	public void setPtName(String ptName) {
		this.ptName = ptName;
	}

	public String getPtDel() {
		return this.ptDel;
	}

	public void setPtDel(String ptDel) {
		this.ptDel = ptDel;
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