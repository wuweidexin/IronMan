package com.chen.entity;

import java.util.Set;

public class Dept {
	private int deptid;
	private String deptname;
	private String deptcreatetime;
	private Set<Employee> set;
	public Dept() {
		
	}
	
	public Dept(int deptid, String deptname, String deptcreatetime,
			Set<Employee> set) {
		super();
		this.deptid = deptid;
		this.deptname = deptname;
		this.deptcreatetime = deptcreatetime;
		this.set = set;
	}

	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getDeptcreatetime() {
		return deptcreatetime;
	}
	public void setDeptcreatetime(String deptcreatetime) {
		this.deptcreatetime = deptcreatetime;
	}
	public Set<Employee> getSet() {
		return set;
	}
	public void setSet(Set<Employee> set) {
		this.set = set;
	}
}
