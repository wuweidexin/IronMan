package com.chen.serviceImp;

import java.sql.*;
import java.util.*;

import com.chen.daoimp.BaseDaoImp;
import com.chen.entity.Dept;
import com.chen.entity.Employee;
import com.chen.service.EmployeeOperateInerface;


public class EmployeeOperate3
{
	public static Set set = null;
	public void into(int id)
	{
		class Opereat
		{
			public void delete(int id) {

			}


			public Set find(int id) {
				String sql = "select employee.employeeid, employee.employeename, "+
				"employee.employeesex, employee.employeeage, dept.deptname, "+
				"dept.deptcreatetime from employee, dept where employee.deptid = "+
				"dept.deptid and employee.employeeid = " + id;
				BaseDaoImp base = new BaseDaoImp();
				ResultSet res = base.getResult(sql);
				Set<Employee> setE = new HashSet<Employee>();
				try {
					while(res.next())
					{
						Employee e = new Employee();
						Dept dept = new Dept();
						e.setEmployeeid(res.getInt(1));
						e.setEmployeename(res.getString(2));
						e.setEmployeesex(res.getString(3));
						e.setEmployeeage(res.getInt(4));
						dept.setDeptname(res.getString(5));
						dept.setDeptcreatetime(res.getString(6));
						e.setDept(dept);
						setE.add(e);
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();	
				}
				return setE;
			}


			public void update(Employee e) {

				
			}
		}
		Opereat opa = new Opereat();
		set = opa.find(id);
	}
	
	public Set find(int id)
	{
		into(id);
		return set;
	}
	
	
}
