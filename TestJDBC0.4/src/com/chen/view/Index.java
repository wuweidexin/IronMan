package com.chen.view;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Index extends JFrame{
	
	private JPanel panel = new JPanel();
	private JMenu menuFile = new JMenu("�ļ�");
	private JMenuBar menuBar = new JMenuBar();
	private JMenuItem newConstruction = new JMenuItem("�½�"),
			save = new JMenuItem("�洢"),
			saveAs = new JMenuItem("���Ϊ"),
			exit = new JMenuItem("�˳�");
	private JPanel imagePanel = new JPanel();
	ImageIcon eeimage = new ImageIcon(Index.class.getClassLoader().getResource("com/chen/Images/eeManage.gif"));
			
			
	
	private JButton eeManager = new JButton("Ա������"),
			deptManager = new JButton("���Ź���"),
			salaryManager = new JButton("���ʹ���"),
			quikDemand = new JButton("���ٲ���");
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
		
		this.setTitle("����ϵͳ");
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
