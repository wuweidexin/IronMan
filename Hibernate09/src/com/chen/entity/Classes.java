package com.chen.entity;

import java.util.HashSet;
import java.util.Set;

public class Classes {
	private int id;
	private String claName;
	private TbStudent student;
	private Set<TbStudent> set = new HashSet<TbStudent>();
	
	public Set<TbStudent> getSet() {
		return set;
	}
	public void setSet(Set<TbStudent> set) {
		this.set = set;
	}
	/*
	 * 多对一和一对多复合使用
	 * 
	 */
	public Classes() {
	}
	public Classes(int id, String claName, TbStudent student, Set<TbStudent> set) {
		this.id = id;
		this.claName = claName;
		this.student = student;
		this.set = set;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClaName() {
		return claName;
	}
	public void setClaName(String claName) {
		this.claName = claName;
	}
	public TbStudent getStudent() {
		return student;
	}
	public void setStudent(TbStudent student) {
		this.student = student;
	}
}
