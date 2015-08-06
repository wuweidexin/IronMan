package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbClassType entity. @author MyEclipse Persistence Tools
 */

public class TbClassType implements java.io.Serializable {

	// Fields

	private Integer ctId;
	private String ctMyselfId;
	private String ctName;
	private String ctDel;
	private String col1;
	private String col2;
	private String col3;
	private Set tbClasseses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbClassType() {
	}

	/** full constructor */
	public TbClassType(String ctMyselfId, String ctName, String ctDel,
			String col1, String col2, String col3, Set tbClasseses) {
		this.ctMyselfId = ctMyselfId;
		this.ctName = ctName;
		this.ctDel = ctDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
		this.tbClasseses = tbClasseses;
	}

	// Property accessors

	public Integer getCtId() {
		return this.ctId;
	}

	public void setCtId(Integer ctId) {
		this.ctId = ctId;
	}

	public String getCtMyselfId() {
		return this.ctMyselfId;
	}

	public void setCtMyselfId(String ctMyselfId) {
		this.ctMyselfId = ctMyselfId;
	}

	public String getCtName() {
		return this.ctName;
	}

	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	public String getCtDel() {
		return this.ctDel;
	}

	public void setCtDel(String ctDel) {
		this.ctDel = ctDel;
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

	public Set getTbClasseses() {
		return this.tbClasseses;
	}

	public void setTbClasseses(Set tbClasseses) {
		this.tbClasseses = tbClasseses;
	}

}