package com.chen.serviceImp;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import com.chen.daoimp.BaseDaoImp;
import com.chen.entity.Dept;
import com.chen.entity.Employee;
import com.chen.entity.Salary;
import com.chen.service.EmployeeOperateInerface;
import com.chen.utils.DateConnection;


public class EmployeeOperate implements EmployeeOperateInerface
{
	BaseDaoImp base = new BaseDaoImp();
	public void delete(int id) {
		String sql = "";
	}


	public Set find(int id) {
		String sql =" select employee.employeeid, employee.employeename,  employee.employeesex, " + 
	"employee.employeeage, dept.deptname, dept.deptid, dept.deptcreateTime,salary.salaryid, salary.basesalary," +
	" salary.reward, salary.subsidy from employee, dept, salary where employee.deptid = dept.deptid " +
	"and employee.employeeid = salary.employeeid and employee.employeeid = " + id;
		
		ResultSet res = base.getResult(sql);
		Set<Employee> setE = new HashSet<Employee>();
		try {
			while(res.next())
			{
				Employee e = new Employee();
				Dept dept = new Dept();
				Salary salary = new Salary();
				e.setEmployeeid(res.getInt(1));
				e.setEmployeename(res.getString(2));
				e.setEmployeesex(res.getString(3));
				e.setEmployeeage(res.getInt(4));
				dept.setDeptname(res.getString(5));
				dept.setDeptid(res.getInt(6));
				dept.setDeptcreatetime(res.getString(7));
				e.setDept(dept);
				salary.setSalaryid(res.getInt(8));
				salary.setBasesalary(res.getDouble(9));
				salary.setReward(res.getDouble(10));
				salary.setSubsidy(res.getDouble(11));
				e.setSalary(salary);
				setE.add(e);
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();	
		}
		return setE;
	}
	
	public ResultSet find(String sql) {
		
		return base.getResult(sql);
	}

	public void update(Employee e) {

		
	}
	
	public int alter(String sql)
	{
		int text = base.dateCud(sql);
		if(text == 0)
		{
			JOptionPane.showMessageDialog(null, "未能修改成功，请重试", "注意",  JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		else
		{
			return 1;
		}
		
	}
}
