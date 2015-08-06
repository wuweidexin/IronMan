package com.chen.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame.*;
import javax.swing.table.DefaultTableModel;

import com.chen.utils.TableMode;

public class D_View{
	
	private JPanel insertMesPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JScrollPane dataJScrollPane = new JScrollPane();
	private JSplitPane jSplitPane1 = new JSplitPane();
	
	private JTable dataTabel =  new JTable();
	private DefaultTableModel dtMode =null;
	private JLabel idLabel = new JLabel("ID");
	private JLabel label = new JLabel("��ѯ�ؼ��֣�");
	
	private JButton refreshE = new JButton("ˢ��");
	private JButton insertE = new JButton("����");
	private JButton deleteE = new JButton("ɾ��");
	private JButton updateE = new JButton("�޸�");
	private JButton saveE = new JButton("����");
	private JButton exitE = new JButton("�˳�");
	
	private JLabel deptId = new JLabel("���źţ�");
	private JLabel deptName = new JLabel("��������");
	private JLabel deptCreateTime = new JLabel("���Ŵ���ʱ�䣺");
	
	private JTextField idText =  new JTextField();
	private JTextField nameText =  new JTextField();
	private JTextField deptCreateTimeText = new JTextField();
	JFrame jframe = new JFrame();
	TableMode tm = null;
	
	String sql = "select dept.deptid, dept.deptname, dept.deptCreateTime from dept where " +
			"dept.islive = 1";
	
	public void launchFrame()
	{
		BorderLayout borderaLayout = new BorderLayout();
		FlowLayout flowLayout = new FlowLayout();
		jframe.setLayout(borderaLayout);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		buttonPanel.setLayout(flowLayout);
		buttonPanel.add(refreshE);
		buttonPanel.add(insertE);
		buttonPanel.add(deleteE);	
		buttonPanel.add(updateE);
		buttonPanel.add(saveE);
		buttonPanel.add(exitE);
		
		insertMesPanel.setLayout(new GridLayout(1,7));
		insertMesPanel.add(label);
		insertMesPanel.add(deptId);
		insertMesPanel.add(idText);
		insertMesPanel.add(deptName);
		insertMesPanel.add(nameText);
		insertMesPanel.add(deptCreateTime);
		insertMesPanel.add(deptCreateTimeText);
		
		ButtonListener button = new ButtonListener();
		
		jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		jSplitPane1.add(dataJScrollPane, JSplitPane.TOP);
		jSplitPane1.add(insertMesPanel, JSplitPane.BOTTOM);
		jSplitPane1.setDividerLocation(480);
		dataJScrollPane.getViewport().add(dataTabel);
		
		jframe.getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);
		
		jframe.getContentPane().add(buttonPanel, BorderLayout.NORTH);
		jframe.setLocation(300, 100);
		jframe.setTitle("���Ź���");
		jframe.setVisible(true);
		jframe.setSize(600, 600);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	public void showData(String sql)
	{
		tm = new TableMode("dept");
		dtMode = tm.getTableModel(sql);
		dataTabel.setModel(dtMode);	
		//dataJScrollPane.add(dataTabel);
	}

	public D_View()
	{
		try
		{
			showData(sql);
			launchFrame();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		new D_View();
	}
	
	class ButtonListener implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) {
			
		}
		
	}
}
