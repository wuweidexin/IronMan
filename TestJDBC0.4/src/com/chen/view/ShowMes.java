package com.chen.view;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import com.chen.entity.Dept;
import com.chen.entity.Employee;
import com.chen.entity.Salary;
import com.chen.serviceImp.EmployeeOperate;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;

public class ShowMes{
	int id;
	JFrame f = new JFrame();
	EmployeeOperate employee = new EmployeeOperate();
	private JLabel nameLabel = new JLabel("姓名：", SwingConstants.CENTER),
			sexLabel = new JLabel("性别：", SwingConstants.CENTER),
			ageLabel = new JLabel("年龄：", SwingConstants.CENTER),
			deptNumLabel = new JLabel("部门号：", SwingConstants.RIGHT),
			deptNameLabel = new JLabel("部门名：", SwingConstants.RIGHT),
			deptCreateTimeLabel = new JLabel("距今：", SwingConstants.RIGHT),
			baseSalaryLabel = new JLabel("工资：", SwingConstants.CENTER),
			rewardLabel = new JLabel("奖金：", SwingConstants.CENTER),
			subsidyLabel = new JLabel("补贴：", SwingConstants.CENTER);
	
	private Border borderEmp = BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Color.white, new Color(148, 145, 140)),
			borderDept = BorderFactory.createLineBorder(f.getForeground()),
			borderSalary = BorderFactory.createLineBorder(f.getForeground());
	
	private JPanel empPanel = new JPanel(),
			deptPanel = new JPanel(),
			salaryPanel = new JPanel(),
			buttonPanel = new JPanel();
	
	private JTextField nameText = new JTextField(8),
			sexText = new JTextField(8),
			ageText = new JTextField(8),
			deptNumText = new JTextField(8),
			deptNameText = new JTextField(8), 
			deptCreateTimeText = new JTextField(8),
			baseSalaryText = new JTextField(8),
			rewardText = new JTextField(8),
			subsidyText = new JTextField(8);
	
	
	private JButton login = new JButton("确定"),
					cancel = new JButton("取消");
	
	private int x1 = 20, y1 = 10, w1 = 180, h1 = 100;
	private int x2 = 20, y2 = 120, w2 = 180, h2 = 100;
	private int x3 = 20, y3 = 230, w3 = 180, h3 = 100;
	private int x4 = 80, y4 = 350, w4 = 120, h4 = 50;
	
	public static int eeid;
	private String loginEE = null;
	private String oldNameText = null,
			oldSexText = null,
			oldAgeText =null;
	
	
	public void launchFrame()
	{
		deptNameText.setEditable(false);
		deptNumText.setEditable(false);
		deptCreateTimeText.setEditable(false);
		baseSalaryText.setEditable(false);
		rewardText.setEditable(false);
		subsidyText.setEditable(false);
		
		empPanel.setBorder(borderEmp);
		empPanel.setLayout(null);
		deptPanel.setBorder(borderDept);
		deptPanel.setLayout(null);
		salaryPanel.setBorder(borderSalary);
		salaryPanel.setLayout(null);
		buttonPanel.setLayout(null);
		
		empPanel.add(nameLabel);
		nameLabel.setBounds(10, 10, 50, 25);
		empPanel.add(nameText);
		nameText.setBounds(70, 10, 80, 25);
		empPanel.add(sexLabel);
		sexLabel.setBounds(10, 40, 50, 25);
		empPanel.add(sexText);
		sexText.setBounds(70, 40, 80, 25);
		empPanel.add(ageLabel);
		ageLabel.setBounds(10, 70, 50, 25);
		empPanel.add(ageText);
		ageText.setBounds(70, 70, 80, 25);
		empPanel.setBounds(x1, y1, w1, h1);
		
		deptPanel.add(deptNameLabel);
		deptNameLabel.setBounds(10, 10, 60, 25);
		deptPanel.add(deptNameText);
		deptNameText.setBounds(70, 10, 80, 25);
		deptPanel.add(deptNumLabel);
		deptNumLabel.setBounds(10, 40, 60, 25);
		deptPanel.add(deptNumText);
		deptNumText.setBounds(70, 40, 80, 25);
		deptPanel.add(deptCreateTimeLabel);
		deptCreateTimeLabel.setBounds(10, 70, 50, 25);
		deptPanel.add(deptCreateTimeText);
		deptCreateTimeText.setBounds(70, 70, 80, 25);
		deptPanel.setBounds(x2, y2, w2, h2);
		
		salaryPanel.add(baseSalaryLabel);
		baseSalaryLabel.setBounds(10, 10, 60, 25);
		salaryPanel.add(baseSalaryText);
		baseSalaryText.setBounds(70, 10, 80, 25);
		salaryPanel.add(rewardLabel);
		rewardLabel.setBounds(10, 40, 60, 25);
		salaryPanel.add(rewardText);
		rewardText.setBounds(70, 40, 80, 25);
		salaryPanel.add(subsidyLabel);
		subsidyLabel.setBounds(10, 70, 50, 25);
		salaryPanel.add(subsidyText);
		subsidyText.setBounds(70, 70, 80, 25);
		salaryPanel.setBounds(x3, y3, w3, h3);
		
		buttonPanel.add(login);
		login.setBounds(5, 5, 60, 30);
		buttonPanel.add(cancel);
		cancel.setBounds(60, 5, 60, 30);
		buttonPanel.setBounds(x4, y4, w4, h4);
		
		ButtonListener buttonListener = new ButtonListener();
		login.addActionListener(buttonListener);
		cancel.addActionListener(buttonListener);
		 
		f.addWindowListener(new WindowListener(){
			public void windowActivated(WindowEvent e){}			
			public void windowClosed(WindowEvent e){}			
			public void windowClosing(WindowEvent e){
				f.dispose();
			}			
			public void windowDeactivated(WindowEvent e){}		
			public void windowDeiconified(WindowEvent e){}			
			public void windowIconified(WindowEvent e){}		
			public void windowOpened(WindowEvent e){}
		});
		f.setLayout(null);
		f.add(empPanel);
		f.add(deptPanel);
		f.add(salaryPanel);
		f.add(buttonPanel);
		f.setBounds(400, 200, 250, 420);
		f.setTitle("登陆者：" + loginEE);
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	public void find(int id)
	{
		Set<Employee> set = employee.find(id);
		Iterator<Employee> ita = set.iterator();
		if(ita.hasNext())
		{
			Employee ee = ita.next();
			nameText.setText(ee.getEmployeename());
			sexText.setText(ee.getEmployeesex());
			ageText.setText("" + ee.getEmployeeage());
			deptNameText.setText(ee.getDept().getDeptname());
			deptNumText.setText("" + ee.getDept().getDeptid());
			deptCreateTimeText.setText(ee.getDept().getDeptcreatetime());
			baseSalaryText.setText("" + ee.getSalary().getBasesalary());
			rewardText.setText("" + ee.getSalary().getReward());
			subsidyText.setText("" + ee.getSalary().getSubsidy());
			eeid = ee.getEmployeeid();
			loginEE = nameText.getText().trim();
			oldNameText = nameText.getText().trim();
			oldSexText = sexText.getText().trim();
			oldAgeText = ageText.getText().trim();
		}
		else 
		{
			System.out.println("没有查到元素");
		}
	
		
	}
	public void showFrame()
	{
		find(id);
		launchFrame();
	}
	public ShowMes(int id)
	{
		this.id = id;
	}
	
	class ButtonListener  implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			String mysql = null;
			String newNameText = nameText.getText().trim(),
					newSexText = sexText.getText().trim(),
					newAgeText = ageText.getText().trim();
			if(e.getSource() == login)
			{
				if(! newNameText.equals(oldNameText))
				{
					mysql = "update employee set employeename = '" + newNameText + "' where employeeid = " + eeid + ";";
					employee.alter(mysql);
					JOptionPane.showMessageDialog(null, "成功插入数据", "注意",  JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
				else if(! newSexText.equals(oldSexText))
				{
					mysql = "update employee set employeesex = '" + newSexText + "' where employeeid = " + eeid + ";";;
					employee.alter(mysql);
				}
				else if(! newAgeText.equals(oldAgeText))
				{
					mysql = "update employee set employeeage = '" + newAgeText + "' where employeeid = " + eeid + ";";;
					employee.alter(mysql);
				}
			}
			else if(e.getSource() == cancel)
			{
				f.dispose();
			}
		}
		
	}
}
