package com.chen.view;

import javax.swing.*;
import java.awt.*;

public class EmployeeIndex extends JFrame{


	JPanel      p1;
	JPanel      p2;
	JButton     button1;
	JButton     button2;
	JButton     button3;//该键是对文件等的测试
	JMenuBar    jMenuBar;//定义菜单条
	JMenu       jMenu;//定义菜单
	JMenuItem   jMenuItem1;//定义菜单项
	JMenuItem   jMenuItem2;
	JToolBar    jToolBar;//定义工具条
	JTextArea   textArea;
	JTextField  jtf;

	public EmployeeIndex()
	{
		p1         = new JPanel(new BorderLayout());
		p2         = new JPanel(new BorderLayout());
		
//		button1    = new JButton("OK");
//		button2    = new JButton("Cancle");
//		button3    = new JButton("File_class");
		
		jMenuBar   = new JMenuBar();
		
		jMenu      = new JMenu("File");
		
		jMenuItem1 = new JMenuItem("Open");
		jMenuItem2 = new JMenuItem("Exit");
		
		textArea   = new JTextArea();//建立一个显示框显示点击事件后的结果
		jtf        = new JTextField();


//		jToolBar.add(button1);
//		jToolBar.add(button2);

		jMenu.add(jMenuItem1);
		jMenu.add(jMenuItem2);
		jMenuBar.add(jMenu);
		
		p2.add(jtf,BorderLayout.NORTH);
		p2.add(jToolBar,BorderLayout.SOUTH);

		p1.add(textArea,BorderLayout.CENTER);
		p1.add(p2,BorderLayout.SOUTH);
		p1.add(jMenuBar,BorderLayout.NORTH);
		add(p1);
	}
	public static void main(String[] args)
	{
		EmployeeIndex f=new EmployeeIndex();
		f.setTitle("我的");
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400, 400);
		f.setVisible(true);
	}
}
