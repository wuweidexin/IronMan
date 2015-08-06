package com.chen.view;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Index extends JFrame{
	
	private JPanel panel = new JPanel();
	private JMenu menuFile = new JMenu("文件");
	private JMenuBar menuBar = new JMenuBar();
	private JMenuItem newConstruction = new JMenuItem("新建"),
			save = new JMenuItem("存储"),
			saveAs = new JMenuItem("另存为"),
			exit = new JMenuItem("退出");
	private JPanel imagePanel = new JPanel();
	ImageIcon eeimage = new ImageIcon(Index.class.getClassLoader().getResource("com/chen/Images/eeManage.gif"));
			
			
	
	private JButton eeManager = new JButton("员工管理"),
			deptManager = new JButton("部门管理"),
			salaryManager = new JButton("工资管理"),
			quikDemand = new JButton("快速查找");
	//Explode.class.getClassLoader().getResource("Images/tankL.gif")
	public void launchFrame()
	{
		menuFile.add(newConstruction);
		menuFile.add(save);
		menuFile.add(saveAs);
		menuFile.add(exit);
		menuBar.add(menuFile);
		
		imagePanel.setLayout(null);
		eeManager.setBounds(10, 10, 80, 80);
		imagePanel.add(eeManager);
		deptManager.setBounds(90,10,80,80);
		imagePanel.add(deptManager);
		salaryManager.setBounds(170, 10, 80, 80);
		imagePanel.add(salaryManager);
		quikDemand.setBounds(250, 10, 80, 80);
		imagePanel.add(quikDemand);
		imagePanel.setBounds(3, 3, 500, 150);
		
		JButtonListener jb = new JButtonListener();
		
		eeManager.addActionListener(jb);
		deptManager.addActionListener(jb);
		salaryManager.addActionListener(jb);
		quikDemand.addActionListener(jb);
		
		this.setTitle("管理系统");
		this.setLayout(null);
		this.add(imagePanel);
		this.setJMenuBar(menuBar);
		this.setBounds(100, 100, 600, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public Index()
	{
		launchFrame();
	}
	
	public static void main(String[] args)
	{
		new Index();
	}
	
	class JButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) {
			
		}
		
	}
}
