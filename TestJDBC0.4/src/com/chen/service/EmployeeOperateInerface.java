package com.chen.service;

import java.util.Set;

import com.chen.entity.Employee;

public interface EmployeeOperateInerface {
	public void update(Employee e);
	public Set find(int id);
	public void delete(int id);
}
