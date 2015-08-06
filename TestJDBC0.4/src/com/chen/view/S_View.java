package com.chen.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class S_View extends JFrame{
	
	private JPanel insertMesPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JScrollPane dataJScrollPane = new JScrollPane();
	private JTable dataTabel =  new JTable();
	private DefaultTableModel dtMode = new DefaultTableModel();
	private JLabel idLabel = new JLabel("ID");
	
	private JButton refreshE = new JButton("刷新");
	private JButton insertE = new JButton("插入");
	private JButton deleteE = new JButton("删除");
	private JButton updateE = new JButton("修改");
	private JButton saveE = new JButton("存盘");
	private JButton exitE = new JButton("退出");
	
	private JLabel baseSalaryLabel = new JLabel("姓名：");
	private JLabel rewardLabel = new JLabel("性别：");
	private JLabel subsidyLabel = new JLabel("年龄：");
	private JLabel eeLabel = new JLabel("员工号");
	
	private JTextField baseSalaryText =  new JTextField();
	private JTextField rewardText =  new JTextField();
	private JTextField subsidyText = new JTextField();
	private JTextField eeText = new JTextField();
	
	private Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED,
            Color.white, new Color(148, 145, 140));
	
	private Border border1 = BorderFactory.createTitledBorder(LineBorder.createBlackLineBorder(), "操作区域");
	
	/**
	 * 
	 */
	public void launchFrame()
	{
		
		buttonPanel.setLayout(null);
		buttonPanel.setBounds(230, 10,555, 60);
		buttonPanel.setBorder(border1);
		buttonPanel.add(refreshE);
		refreshE.setBounds(10, 15, 80, 40);
		buttonPanel.add(insertE);
		insertE.setBounds(100, 15, 80, 40);
		buttonPanel.add(deleteE);
		deleteE.setBounds(200, 15, 80, 40);
		buttonPanel.add(updateE);
		updateE.setBounds(290, 15, 80, 40);
		buttonPanel.add(saveE);
		saveE.setBounds(380, 15, 80, 40);
		buttonPanel.add(exitE);
		exitE.setBounds(470, 15, 80, 40);
		
		insertMesPanel.setLayout(null);
		insertMesPanel.setBorder(border);
		insertMesPanel.setBounds(5, 510, 780, 50);
		
		insertMesPanel.add(baseSalaryLabel);
		baseSalaryLabel.setBounds(10, 10, 50, 30);
		insertMesPanel.add(baseSalaryText);
		baseSalaryText.setBounds(60, 10, 80, 30);
		
		insertMesPanel.add(rewardLabel);
		insertMesPanel.add(rewardText);
		rewardLabel.setBounds(150, 10, 50, 30);
		rewardText.setBounds(200, 10, 80, 30);
		
		insertMesPanel.add(subsidyLabel);
		subsidyLabel.setBounds(300, 10, 50, 30);
		insertMesPanel.add(subsidyText);
		subsidyText.setBounds(360, 10, 80, 30);
		
		insertMesPanel.add(eeLabel);
		eeLabel.setBounds(450, 10, 50, 30);
		insertMesPanel.add(eeText);
		eeText.setBounds(510, 10, 80, 30);
		
		dataJScrollPane.setBounds(5, 70, 780, 440);
		this.add(dataJScrollPane);
		
		this.add(buttonPanel);
		this.add(insertMesPanel);
		this.setLayout(null);
		this.setTitle("工资管理");
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public S_View()
	{
		launchFrame();
	}
	
	public static void main(String[] args)
	{
		new S_View();
	}
	
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) {
		}
		
	}
}
