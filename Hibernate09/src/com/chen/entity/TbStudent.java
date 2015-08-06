package com.chen.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * TbStudent entity. @author MyEclipse Persistence Tools
 */

@Entity
public class TbStudent implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String stuName;
	private String stuSex;
	private Integer stuAge;
	private Classes cla;


	public Classes getCla() {
		return cla;
	}

	public void setCla(Classes cla) {
		this.cla = cla;
	}

	/** default constructor */
	public TbStudent() {
	}

	/** full constructor */
	public TbStudent(String stuName, String stuSex, Integer stuAge, Classes cla) {
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuAge = stuAge;
		this.cla = cla;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuSex() {
		return this.stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public Integer getStuAge() {
		return this.stuAge;
	}

	public void setStuAge(Integer stuAge) {
		this.stuAge = stuAge;
	}

}