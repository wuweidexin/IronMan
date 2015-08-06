package com.chen.view;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import com.chen.daoimp.BaseDaoImp;
import com.chen.serviceImp.EmployeeOperate;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewUser extends JFrame{
	
	private int age = 18;
	private String dept = "技术部";
	private JLabel nameLabel = new JLabel("姓名：", SwingConstants.CENTER),
			sexLabel = new JLabel("性别：", SwingConstants.CENTER),
			ageLabel = new JLabel("年龄：", SwingConstants.CENTER),
			deptNumLabel = new JLabel("部门号：", SwingConstants.RIGHT),
			deptNameLabel = new JLabel("部门名：", SwingConstants.RIGHT),
			deptCreateTimeLabel = new JLabel("创时：", SwingConstants.RIGHT),
			baseSalaryLabel = new JLabel("工资：", SwingConstants.CENTER),
			rewardLabel = new JLabel("奖金：", SwingConstants.CENTER),
			subsidyLabel = new JLabel("补贴：", SwingConstants.CENTER);
	
	private Border borderEmp = BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Color.white, new Color(148, 145, 140)),
			borderDept = BorderFactory.createLineBorder(getForeground()),
			borderSalary = BorderFactory.createLineBorder(getForeground());
	
	private JPanel empPanel = new JPanel(),
			deptPanel = new JPanel(),
			salaryPanel = new JPanel(),
			buttonPanel = new JPanel();
	
	private JTextField nameText = new JTextField(8),
			deptNumText = new JTextField(8),
			deptCreateTimeText = new JTextField(8),
			baseSalaryText = new JTextField(8),
			rewardText = new JTextField(8),
			subsidyText = new JTextField(8);
	
	private int[] ageNum = new int[]{
		18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36	
	};
	private String[] deptname = new String[]{
		"技术部", "管理部", "销售部", "财务部"	
	};
	
	
	private JComboBox ageText = new JComboBox();
	private JComboBox deptNameText = new JComboBox();
	
	private JButton login = new JButton("确定"),
					cancel = new JButton("取消");
	
	private int x1 = 20, y1 = 10, w1 = 180, h1 = 100;
	private int x2 = 20, y2 = 120, w2 = 180, h2 = 100;
	private int x3 = 20, y3 = 230, w3 = 180, h3 = 100;
	private int x4 = 80, y4 = 350, w4 = 120, h4 = 50;
	
	
	private JRadioButton manButton = new JRadioButton("男"),
			womanButton = new JRadioButton("女");
	ButtonGroup  buttonGroup = new ButtonGroup();
	EmployeeOperate ee =  new EmployeeOperate();
	
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
		
		for(int i = 0; i < 18; i ++)
		{
			ageText.addItem(ageNum[i]);
		}
		for(int j = 0; j < 4; j ++)
		{
			deptNameText.addItem(deptname[j]);
		}
		empPanel.add(nameLabel);
		nameLabel.setBounds(10, 10, 50, 25);
		empPanel.add(nameText);
		nameText.setBounds(70, 10, 80, 25);
		empPanel.add(sexLabel);
		sexLabel.setBounds(10, 40, 50, 25);
		empPanel.add(manButton);
		manButton.setBounds(60, 40, 45, 20);
		empPanel.add(womanButton);
		womanButton.setBounds(110, 40, 45, 20);
		buttonGroup.add(manButton);
		buttonGroup.add(womanButton);
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
		
		JComboBoxListener jcombox = new JComboBoxListener();
		ageText.addActionListener(jcombox);
		deptNameText.addActionListener(jcombox);
		
		this.setLayout(null);
		this.add(empPanel);
		this.add(deptPanel);
		this.add(salaryPanel);
		this.add(buttonPanel);
		this.setBounds(400, 200, 250, 420);
		this.setTitle("登陆者：" + "***");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public NewUser()
	{
		launchFrame();
	}
	
	public static void main(String[] args)
	{
		new NewUser();
	}
//	
//	public void getEEName()
//	{
//		for(int i = 100; )
//	}
	public int findI(String mess, String table,  String mess2, String mess3, int i)
	{
		String sql = "select " + mess + "form " + table+ "where " + mess2 +" = '" + mess3 + "';";
		ResultSet temp = ee.find(sql);
		try {
			System.out.println(temp.getInt(i));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public String findS(String table, int id)
	{
		return null;
	}
	
	
	class JComboBoxListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == ageText)
			{
				int ageTemp = (Integer) ageText.getSelectedItem();
				
				switch(ageTemp)
				{
				case 18:	age = 18;	break;
				case 19:	age = 19;	break;
				case 20:	age = 20;	break;
				case 21:	age = 21;	break;
				case 22:	age = 22;	break;				
				case 23:	age = 23;	break;
				case 24:	age = 24;	break;
				case 25:	age = 25;	break;
				case 26:	age = 26;	break;
				case 27:	age = 27;	break;
				case 28:	age = 28;	break;
				case 29:	age = 29;	break;
				case 30:	age = 30;	break;
				case 31:	age = 31;	break;
				case 32:	age = 32;	break;
				case 33:	age = 33;	break;
				case 34:	age = 34;	break;
				case 35:	age = 35;	break;
				case 36:	age = 36;	break;
				}
				System.out.println(age);
			}
			else if(e.getSource() == deptNameText)
			{
				String temp  = (String) deptNameText.getSelectedItem();
				if(temp.equals("技术部"))
				{
					dept = "技术部";
					deptNumText.setText("1001");
					deptCreateTimeText.setText("20111201");
					baseSalaryText.setText("");
					rewardText.setText("");
					subsidyText.setText("");
					
				}
				else if(temp.equals("管理部"))
				{
					dept = "管理部";
					deptNumText.setText("1002");
					deptCreateTimeText.setText("20111201");
					baseSalaryText.setText("");
					rewardText.setText("");
					subsidyText.setText("");
					findI("deptid", "dept", "deptname", "管理部", 2);
				}
				else if(temp.equals("销售部"))
				{
					dept = "销售部";
					deptNumText.setText("");
					deptCreateTimeText.setText("" );
					baseSalaryText.setText("");
					rewardText.setText("");
					subsidyText.setText("");
				}
				else if(temp.equals("财务部"))
				{
					dept = "财务部";
					deptNumText.setText("1004");
					deptCreateTimeText.setText("20111202");
					baseSalaryText.setText("");
					rewardText.setText("");
					subsidyText.setText("");
				}
			}
			System.out.println(dept);
		}
		
	}
	class ButtonListener  implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == login)
			{
				
			}
			else if(e.getSource() == cancel)
			{
				
			}
		}
		
	}
}
