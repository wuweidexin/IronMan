package com.chen.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class deptUptateFrame extends JFrame{
	
	
	private JLabel deptId = new JLabel("����ID��");
	private JTextField deptIdText = new JTextField(8);
	private JLabel deptName = new JLabel("�������ƣ�");
	private JTextField deptNameText = new JTextField(8);
	private JLabel createTimeLabel = new JLabel("���Ŵ���ʱ�䣺");
	private JTextField createTimeText = new JTextField(8);
	private JButton ensure = new JButton("ȷ��");
	private JButton cancel = new JButton("ȡ��");
	private JPanel panel = new JPanel();
	static String s = null;
	public void launchFrame()
	{
		panel.setLayout(new GridLayout(4,1));
		panel.add(deptId);
		panel.add(deptIdText);
		panel.add(deptName);
		panel.add(deptNameText);
		panel.add(createTimeLabel);
		panel.add(createTimeText);
		panel.add(ensure);
		panel.add(cancel);
		this.getContentPane().add(panel);
		this.setSize(250,400);
		this.setVisible(true);
		this.setLocation(400, 100);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e) 
			{
				dispose();
			}

		});
	}
	public void updateShow(String s)
	{
		if(s.equals("insert"))
		{
			String sql = "insert into dept(dept.deptname, dept.deptcreatetime)"
					+"values('" + deptName.getText().trim() + "', '"+ createTimeText.getText().trim() +"')";
		}
		else if(s.equals("update"))
		{
			
		}
	}
	
	public deptUptateFrame()
	{
		
	}
	public deptUptateFrame(String s)
	{
		this.s = s;
		try
		{
			updateShow(s);
			launchFrame();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		new deptUptateFrame(s);
	}
}
