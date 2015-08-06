package com.chen.utils;

import java.sql.*;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.chen.daoimp.BaseDaoImp;
import com.chen.serviceImp.EmployeeOperate;

public class TableMode {

	String tname = null;
	String[] ETable = {"Ա��ID", "Ա������",  "Ա���Ա�", "Ա������", "������","����ID", "���Ŵ���ʱ��"};
	String[] DTable = {"����ID", "������", "���Ŵ���ʱ��"};
	String[] STable = {"Ա��ID", "Ա������", "��������", "����", "����"};
	public TableMode(){}

	public TableMode(String tname)
	{
		this.tname = tname;

	}
	public DefaultTableModel getTableModel(String sql)
	{
		Vector vct1 = new Vector();
		Vector vct2  = new Vector();
		String[] tColumnName = null;
		DefaultTableModel dtm = null;
		EmployeeOperate eeo = new EmployeeOperate();
		Set set = null;
		ResultSet res = null;

		if(tname.equals("employee"))
		{
			tColumnName = ETable;

		}
		else if(tname.equals("dept"))
		{
			tColumnName = DTable;
		}
		res = eeo.find(sql);
		for(int i = 0; i < tColumnName.length; i ++)
		{
			vct1.addElement(tColumnName[i]);

		}
		dtm = new DefaultTableModel(vct1,0);
		try {
			while(res.next())
			{
				vct2 = new Vector();
				for(int i =0; i < res.getMetaData().getColumnCount(); i ++)
				{
					vct2.addElement(res.getObject(i + 1));
				}
				dtm.addRow(vct2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dtm;

	}
}
