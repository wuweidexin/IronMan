package com.chen.entity;

public class Employee {
	private int employeeid;
	private String employeename;
	private String employeesex;
	private int employeeage;
	private Dept dept;
	private Salary salary;
	
	public Employee() {
	}
	public Employee(int employeeid, String employeename, String employeesex,
			int employeeage, Dept dept, Salary salary) {
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.employeesex = employeesex;
		this.employeeage = employeeage;
		this.dept = dept;
		this.salary = salary;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getEmployeesex() {
		return employeesex;
	}
	public void setEmployeesex(String employeesex) {
		this.employeesex = employeesex;
	}
	public int getEmployeeage() {
		return employeeage;
	}
	public void setEmployeeage(int employeeage) {
		this.employeeage = employeeage;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Salary getSalary()
	{
		return salary;
	}
	public void setSalary(Salary salary)
	{
		this.salary = salary;
	}
}
