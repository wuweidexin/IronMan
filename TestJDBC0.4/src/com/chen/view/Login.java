package com.chen.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
	boolean employeeB = false;
	boolean manageB = false;
	JPanel jpanel_name = new JPanel(new GridLayout());
	JPanel jpanel_password = new JPanel(new GridLayout());
	JPanel jpanel_button =  new JPanel(new GridLayout(2,1));
	JPanel jpanel_border = new JPanel(new GridLayout(2,1));
	JPanel jpanel_button_group = new JPanel(new GridLayout(1,2));
	
	JLabel nameLabel = new JLabel("用户名：");
	JLabel passwordLabel = new JLabel("密码：");
	JLabel outLabel = new JLabel("请选择登陆类型：");
	
	JTextField nameText = new JTextField(8);
	JPasswordField passwordText = new JPasswordField();
	
	JButton bLogin = new JButton("登陆");
	JButton bExit = new JButton("退出");
	JRadioButton employee = new JRadioButton("员工");
	JRadioButton manage = new JRadioButton("管理员");
	ButtonGroup  buttonGroup = new ButtonGroup();
	
	Border border1 = BorderFactory.createEtchedBorder(EtchedBorder.RAISED,
            Color.white, new Color(148, 145, 140));
	
	BorderLayout borderLayout1 = new BorderLayout();
	
	public Login()
	{
		try
		{
			init();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void init(){
		getContentPane().setLayout(borderLayout1);
		buttonGroup.add(employee);
		buttonGroup.add(manage);
		jpanel_border.setBorder(border1);
		jpanel_name.add(nameLabel);
		jpanel_name.add(nameText);
		jpanel_password.add(passwordLabel);
		jpanel_password.add(passwordText);
		jpanel_border.add(jpanel_name);
		jpanel_border.add(jpanel_password);
		
		jpanel_button.add(bLogin);
		jpanel_button.add(bExit);
		jpanel_button_group.add(employee);
		jpanel_button_group.add(manage);
		jpanel_button_group.add(jpanel_button);
		
		RadioButton radioButton = new RadioButton();
		ButtonListener btListener = new ButtonListener();
		employee.addActionListener(radioButton);
		manage.addActionListener(radioButton);
		bLogin.addActionListener(btListener);
		bExit.addActionListener(btListener);
		
		this.setTitle("员工管理系统");
		this.setLayout(new GridLayout(2,1));
		this.add(jpanel_border);
		this.add(jpanel_button_group);
		this.setBounds(400, 400, 300, 150);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
	}
	
	public static void main(String[] args)
	{
		new Login();
	}
	
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if("".equals(nameText.getText())||nameText.getText() == null
					||"".equals(passwordText.getPassword())||passwordText.getPassword() == null)
			{
				JOptionPane.showMessageDialog(null,"请输入正确的信息");
			}
			else
			{
				if(!employeeB ||!manageB)
				{
					JOptionPane.showMessageDialog(null,"请选择登陆身份");
				}
				else if(employeeB)
				{
					System.out.println("employ");
				}
				else if(manageB)
				{
					System.out.println("mange");
				}
			}
		}
		
	}
	class RadioButton implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(null == e.getSource())
			{
				JOptionPane.showMessageDialog(null,"请选择登陆身份");
			}
			if(e.getSource() == employee)
			{
				employeeB = true;
			}
			else if(e.getSource() == manage)
			{
				manageB = true;
			}
			
		}
		
	}
	
}
