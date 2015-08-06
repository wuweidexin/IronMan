package com.chen.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import com.chen.entity.Employee;
import com.chen.serviceImp.EmployeeOperate;
import com.chen.serviceImp.EmployeeOperate1;
import com.chen.serviceImp.EmployeeOperate2;
import com.chen.serviceImp.EmployeeOperate3;

public class Test {
	public static void main(String[] args) throws SQLException {
		EmployeeOperate employee = new EmployeeOperate();
		Set<Employee> set = employee.find(100);
		Iterator<Employee> ita = set.iterator();
		while(ita.hasNext())
		{
			Employee e = ita.next();
			System.out.println(e.getEmployeeid());
			System.out.println(e.getEmployeename());
			System.out.println(e.getEmployeesex());
			System.out.println(e.getEmployeeage());
			System.out.println(e.getDept().getDeptid());
			System.out.println(e.getDept().getDeptname());
			System.out.println(e.getDept().getDeptcreatetime());
		}
		
		System.out.println("***********************************");
		EmployeeOperate1 employee1 = new EmployeeOperate1();
		Set<Employee> set1 = employee1.find(101);
		Iterator<Employee> ita1 = set1.iterator();
		while(ita1.hasNext())
		{
			Employee e1 = ita1.next();
			System.out.println(e1.getEmployeeid());
			System.out.println(e1.getEmployeename());
			System.out.println(e1.getEmployeesex());
			System.out.println(e1.getEmployeeage());
			System.out.println(e1.getDept().getDeptid());
			System.out.println(e1.getDept().getDeptname());
			System.out.println(e1.getDept().getDeptcreatetime());
		}
		
		System.out.println("***********************************");
		EmployeeOperate2 employee2 = new EmployeeOperate2();
		Set<Employee> set2= employee2.find(102);
		Iterator<Employee> ita2 = set2.iterator();
		while(ita2.hasNext())
		{
			Employee e2 = ita2.next();
			System.out.println(e2.getEmployeeid());
			System.out.println(e2.getEmployeename());
			System.out.println(e2.getEmployeesex());
			System.out.println(e2.getEmployeeage());
			System.out.println(e2.getDept().getDeptid());
			System.out.println(e2.getDept().getDeptname());
			System.out.println(e2.getDept().getDeptcreatetime());
		}
		
		System.out.println("***********************************");
		EmployeeOperate3 employee3 = new EmployeeOperate3();
		Set<Employee> set3= employee3.find(103);
		Iterator<Employee> ita3 = set3.iterator();
		while(ita3.hasNext())
		{
			Employee e3 = ita3.next();
			System.out.println(e3.getEmployeeid());
			System.out.println(e3.getEmployeename());
			System.out.println(e3.getEmployeesex());
			System.out.println(e3.getEmployeeage());
			System.out.println(e3.getDept().getDeptid());
			System.out.println(e3.getDept().getDeptname());
			System.out.println(e3.getDept().getDeptcreatetime());
		}
		System.out.println("***************************************");

		ResultSet res = employee.find("select deptid from dept where deptname = " + "'œ˙ €≤ø'");
		//Sres.next();
		System.out.println(res.getInt(1));
	}
}
