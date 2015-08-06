package com.chen.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.chen.serviceImp.EmployeeOperate;
import com.chen.utils.TableMode;
import com.chen.view.D_View.ButtonListener;
import com.chen.view.*;

public class E_View extends JFrame{

	EmployeeOperate eeo = new EmployeeOperate();
	private String sex = null;
	private boolean man = false;
	private boolean woman = false;
	private JPanel insertPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JScrollPane dataJScrollPane = new JScrollPane();
	private JTable dataTable =  new JTable();
	private DefaultTableModel dtMode = null;
	private JLabel idLabel = new JLabel("ID");

	private JButton refreshE = new JButton("刷新");
	private JButton insertE = new JButton("插入");
	private JButton deleteE = new JButton("删除");
	private JButton updateE = new JButton("修改");
	private JButton saveE = new JButton("存盘");
	private JButton findE = new JButton("查询");

	private JLabel nameLabel = new JLabel("姓名：");
	private JLabel sexLabel = new JLabel("性别：");
	private JLabel ageLabel = new JLabel("年龄：");
	private JTextField idText =  new JTextField(5);
	private JTextField nameText =  new JTextField(5);
	private JTextField ageText = new JTextField(5);
	private JRadioButton manR = new JRadioButton("男");
	private JRadioButton womanR = new JRadioButton("女");
	private ButtonGroup sexGroup = new ButtonGroup();
	private JLabel deptLabel = new JLabel("部门号");
	private JTextField deptText = new JTextField(5);
	private JLabel employeeid = new JLabel("员工ID(删除,修改)");
	private JTextField employeeidText = new JTextField(5);

	TableMode tm = null;
	private JSplitPane jSplitPane1 = new JSplitPane();
	
	String eesql = "select employee.employeeid, employee.employeename, employee.employeesex, " +
			"employee.employeeage, dept.deptname, dept.deptid, dept.deptcreateTime from employee, " +
			"dept where employee.deptid = dept.deptid and employee.islive = 1;";
	public void launchFrame()
	{
		sexGroup.add(manR);
		sexGroup.add(womanR);
		buttonPanel.add(refreshE);
		buttonPanel.add(insertE);
		buttonPanel.add(deleteE);
		buttonPanel.add(updateE);
		buttonPanel.add(saveE);
		buttonPanel.add(findE);
		
		insertPanel.add(nameLabel);
		insertPanel.add(nameText);
		insertPanel.add(sexLabel);
		insertPanel.add(manR);
		insertPanel.add(womanR);
		insertPanel.add(ageLabel);		
		insertPanel.add(ageText);	
		insertPanel.add(deptLabel);		
		insertPanel.add(deptText);	
		insertPanel.add(employeeid);	
		insertPanel.add(employeeidText);		
		insertPanel.setLayout(new FlowLayout());
		
		jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		jSplitPane1.add(insertPanel,JSplitPane.BOTTOM );
		jSplitPane1.add(dataJScrollPane, JSplitPane.TOP);
		jSplitPane1.setDividerLocation(480);
		dataJScrollPane.getViewport().add(dataTable);
		
		ButtonListener button = new ButtonListener();
		refreshE.addActionListener(button);
		insertE.addActionListener(button);
		deleteE.addActionListener(button);
		updateE.addActionListener(button);
		saveE.addActionListener(button);
		findE.addActionListener(button);
		
		RadioButtonListener rbl = new RadioButtonListener();
		manR.addActionListener(rbl);
		womanR.addActionListener(rbl);
		
	
		BorderLayout borderaLayout = new BorderLayout();
		FlowLayout flowLayout = new FlowLayout();
		this.setLayout(borderaLayout);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		buttonPanel.setLayout(flowLayout);
		
		this.getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);
		this.getContentPane().add(buttonPanel, BorderLayout.NORTH);
		
		this.setTitle("员工管理");
		this.setSize(700, 600);
		this.setLocation(300, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void showData(String sql)
	{
		tm = new TableMode("employee");
		dtMode = tm.getTableModel(sql);
		dataTable.setModel(dtMode);	
	}
	
	public void showfindData(String sql)
	{
		showData(sql);
	}

	public E_View()
	{
		showData(eesql);
		launchFrame();
	}

	public static void main(String[] args)
	{
		new E_View();
	}


	class ButtonListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == refreshE)
			{
				showData(eesql);
			}
			else if(e.getSource() == insertE)
			{
	
				if(nameText.getText().trim().equals("") || ageText.getText().trim().equals("") || 
						deptText.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null ,"请检查信息是否输入正确");
				}
				else
				{
					String sql = "insert into employee(deptid, employeename, employeesex, employeeage, islive) values(" + 
							deptText.getText().trim() + ", '" + nameText.getText().trim() + "', '" + sex + "'," + 
							ageText.getText().trim() + "," + 1 +  " ); ";
					eeo.alter(sql);
					JOptionPane.showMessageDialog(null ,"成功插入数据");	
					nameText.setText("");			
					ageText.setText("");	deptText.setText("");
					sex = null;
					
				}


			}
			else if(e.getSource() == deleteE)
			{
				int selectRow = 0;
				selectRow = dataTable.getSelectedRow(); 
				if(selectRow < 0)return;
				int id = (Integer) dataTable.getValueAt(selectRow,0);
				String sql = "update employee set islive = 0 where employeeid = " + id;
				eeo.alter(sql);
				JOptionPane.showMessageDialog(null ,"数据删除成功");
			}
			else if(e.getSource() == updateE)
			{
				int selectRow = 0;
				selectRow = dataTable.getSelectedRow(); 
				if(selectRow < 0)return;
				int id = (Integer) dataTable.getValueAt(selectRow,0);
				String sql ="select employee.employeename, employee.employeesex, " +
						"employee.employeeage, employee.deptid from employee " +
						"where employee.islive = 1 and employee.employeeid = "
						+ id ;
				ResultSet res = eeo.find(sql);
				String oldname = null;
				String oldsex = null;
				int oldage = 0;
				int deptid = 0;
				try {
					
					res.next();
					 nameText.setText(oldname = res.getString(1));
					String sex = res.getString(2);
					if(sex.equals("男"))
					{
						manR.setSelected(true);
						oldsex = "男";
					}
					else if(sex.equals("女"))
					{
						womanR.setSelected(true);
						oldsex = "女";
					}
					ageText.setText("" + (oldage = res.getInt(3)));	
					deptText.setText("" + (deptid = res.getInt(4)));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(nameText.getText().trim().equals(oldname))
					System.out.println(oldname);
//				String sqlin = "insert into employee(deptid, employeename, employeesex, employeeage, islive) values(" + 
//						deptText.getText().trim() + ", '" + nameText.getText().trim() + "', '" + sex + "'," + 
//						ageText.getText().trim() + "," + 1 +  " ); ";
//
//				eeo.alter(sqlin);
//				JOptionPane.showMessageDialog(null ,"成功插入数据");	
//				nameText.setText("");			
//				ageText.setText("");	deptText.setText("");
			}
			else if(e.getSource() == saveE)
			{}
			else if(e.getSource() == findE)
			{
				if(nameText.getText().trim().equals("") && ageText.getText().trim().equals("") && 
						deptText.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null ,"请输入相应信息进行查询");
				}
				else if(!nameText.getText().equals(""))
				{
					String sql ="select employee.employeeid, employee.employeename, employee.employeesex, " +
							"employee.employeeage, dept.deptname, dept.deptid, dept.deptcreateTime from employee, " +
							"dept where employee.deptid = dept.deptid and employee.islive = 1 and employee.employeename = '"
							+ nameText.getText().trim() + "';";
					showfindData(sql);
				}else if(!ageText.getText().trim().equals(""))
				{
					int age = Integer.parseInt(ageText.getText().trim());
					String sql ="select employee.employeeid, employee.employeename, employee.employeesex, " +
							"employee.employeeage, dept.deptname, dept.deptid, dept.deptcreateTime from employee, " +
							"dept where employee.deptid = dept.deptid and employee.islive = 1 and employee.employeeage = "
							+ age + ";";
					showfindData(sql);
				}
				else if(man&&!woman)
				{
					String sex = null;
					String sql ="select employee.employeeid, employee.employeename, employee.employeesex, " +
							"employee.employeeage, dept.deptname, dept.deptid, dept.deptcreateTime from employee, " +
							"dept where employee.deptid = dept.deptid and employee.islive = 1 and employee.employeesex = '"
							+ sex + "';";
					showfindData(sql);
					
				}
				else if(!employeeidText.getText().trim().equals(""))
				{
//					int e = 
//					String sql = "select employee.employeeid, employee.employeename, employee.employeesex, " +
//							"employee.employeeage, dept.deptname, dept.deptid, dept.deptcreateTime from employee, " +
//							"dept where employee.deptid = dept.deptid and employee.islive = 1 and employee.employeeid = '"
//							+  + "';";
				}
			}
		}

	}
	class RadioButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == manR)
			{
				sex = "男";
				man = true;
			}
			else if(e.getSource() == womanR)
			{
				sex = "女";
				woman = true;
			}
		}

	}
}
