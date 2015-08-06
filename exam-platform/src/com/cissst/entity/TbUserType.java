package com.cissst.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TbUserType entity. @author MyEclipse Persistence Tools
 */

public class TbUserType implements java.io.Serializable {

	// Fields

	private Integer utId;
	private String utName;
	private String utDel;
	private String col1;
	private String col2;
	private String col3;
	private Set tbUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public TbUserType() {
	}

	/** full constructor */
	public TbUserType(String utName, String utDel, String col1, String col2,
			String col3, Set tbUsers) {
		this.utName = utName;
		this.utDel = utDel;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
		this.tbUsers = tbUsers;
	}

	// Property accessors

	public Integer getUtId() {
		return this.utId;
	}

	public void setUtId(Integer utId) {
		this.utId = utId;
	}

	public String getUtName() {
		return this.utName;
	}

	public void setUtName(String utName) {
		this.utName = utName;
	}

	public String getUtDel() {
		return this.utDel;
	}

	public void setUtDel(String utDel) {
		this.utDel = utDel;
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

	public Set getTbUsers() {
		return this.tbUsers;
	}

	public void setTbUsers(Set tbUsers) {
		this.tbUsers = tbUsers;
	}

}