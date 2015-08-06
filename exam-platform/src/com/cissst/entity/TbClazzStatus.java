package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbClazzStatus entity. @author MyEclipse Persistence Tools
 */

public class TbClazzStatus implements java.io.Serializable {

	// Fields

	private Integer csId;
	private String csName;
	private String col3;
	private String col2;
	private String csDel;
	private String col1;
	private Set tbClasseses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbClazzStatus() {
	}

	/** full constructor */
	public TbClazzStatus(String csName, String col3, String col2, String csDel,
			String col1, Set tbClasseses) {
		this.csName = csName;
		this.col3 = col3;
		this.col2 = col2;
		this.csDel = csDel;
		this.col1 = col1;
		this.tbClasseses = tbClasseses;
	}

	// Property accessors

	public Integer getCsId() {
		return this.csId;
	}

	public void setCsId(Integer csId) {
		this.csId = csId;
	}

	public String getCsName() {
		return this.csName;
	}

	public void setCsName(String csName) {
		this.csName = csName;
	}

	public String getCol3() {
		return this.col3;
	}

	public void setCol3(String col3) {
		this.col3 = col3;
	}

	public String getCol2() {
		return this.col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}

	public String getCsDel() {
		return this.csDel;
	}

	public void setCsDel(String csDel) {
		this.csDel = csDel;
	}

	public String getCol1() {
		return this.col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1;
	}

	public Set getTbClasseses() {
		return this.tbClasseses;
	}

	public void setTbClasseses(Set tbClasseses) {
		this.tbClasseses = tbClasseses;
	}

}