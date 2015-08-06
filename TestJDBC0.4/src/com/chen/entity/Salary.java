package com.chen.entity;

public class Salary {
	private int salaryid;
	private double basesalary;
	private double reward;
	private double subsidy;
	public Salary() {
	}
	public Salary(int salaryid, double basesalary, double reward, double subsidy) {
		this.salaryid = salaryid;
		this.basesalary = basesalary;
		this.reward = reward;
		this.subsidy = subsidy;
	}
	public int getSalaryid() {
		return salaryid;
	}
	public void setSalaryid(int salaryid) {
		this.salaryid = salaryid;
	}
	public double getBasesalary() {
		return basesalary;
	}
	public void setBasesalary(double basesalary) {
		this.basesalary = basesalary;
	}
	public double getReward() {
		return reward;
	}
	public void setReward(double reward) {
		this.reward = reward;
	}
	public double getSubsidy() {
		return subsidy;
	}
	public void setSubsidy(double subsidy) {
		this.subsidy = subsidy;
	}
}
