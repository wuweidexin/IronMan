package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbReadType entity. @author MyEclipse Persistence Tools
 */

public class TbReadType implements java.io.Serializable {

	// Fields

	private Integer rtId;
	private String rtName;
	private String rtDel;
	private String col1;
	private String col2;
	private String col3;
	private Set tbExamPlans = new HashSet(0);
	private Set tbTacticses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbReadType() {
	}

	/** full constructor */
	public TbReadType(String rtName, String rtDel, String col1, String col2,
			String col3, Set tbExamPlans, Set tbTacticses) {
		this.rtName = rtName;
		this.rtDel = rtDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
		this.tbExamPlans = tbExamPlans;
		this.tbTacticses = tbTacticses;
	}

	// Property accessors

	public Integer getRtId() {
		return this.rtId;
	}

	public void setRtId(Integer rtId) {
		this.rtId = rtId;
	}

	public String getRtName() {
		return this.rtName;
	}

	public void setRtName(String rtName) {
		this.rtName = rtName;
	}

	public String getRtDel() {
		return this.rtDel;
	}

	public void setRtDel(String rtDel) {
		this.rtDel = rtDel;
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

	public Set getTbExamPlans() {
		return this.tbExamPlans;
	}

	public void setTbExamPlans(Set tbExamPlans) {
		this.tbExamPlans = tbExamPlans;
	}

	public Set getTbTacticses() {
		return this.tbTacticses;
	}

	public void setTbTacticses(Set tbTacticses) {
		this.tbTacticses = tbTacticses;
	}

}