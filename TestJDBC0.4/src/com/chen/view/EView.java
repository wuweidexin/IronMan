//package com.chen.view;
//import javax.swing.JFrame;
//import java.awt.BorderLayout;
//import javax.swing.JInternalFrame;
//import javax.swing.JSplitPane;
//import javax.swing.JScrollPane;
//import javax.swing.JPanel;
//import javax.swing.JTable;
//import java.awt.GridLayout;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.DefaultDesktopManager;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseAdapter;
//import javax.swing.JComboBox;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
//
//
//
//
//public class EView extends JInternalFrame {
//	public EView() {
//		try {
//			jbInit();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
//
//	private void jbInit() throws Exception {
//		buildTable();
//		this.getContentPane().setLayout(borderLayout1);
//		setSize(420,340);
//		this.setClosable(true);
//		setVisible(true);
//		
//		gridLayout1.setColumns(2);
//		gridLayout1.setRows(3);
//		jLabel1.setText("班级编号");
//		jTextField1.setEnabled(false);
//		jTextField1.setText("");
//		jLabel2.setText("班级名称");
//		jTextField2.setEnabled(false);
//		jTextField2.setText("");
//		
//		jBdel.setText("删除");
//		jPanel2.setLayout(flowLayout1);
//		flowLayout1.setAlignment(FlowLayout.RIGHT);
//		jBadd.setText("添加");
//		
//		jBsave.setText("存盘");
//		
//		jBexit.setText("退出");
//		
//		
//		jLabel3.setText("年级名称");
//		jComboBox1.addItemListener(new
//				JF_view_sysset_class_jComboBox1_itemAdapter(this));
//		jLabel4.setText("选择年级");
//		
//		this.getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);
//		jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
//		jPanel1.setLayout(gridLayout1);
//		jSplitPane1.add(jScrollPane1, JSplitPane.TOP);
//		jScrollPane1.getViewport().add(jTable1);
//		jSplitPane1.add(jPanel1, JSplitPane.BOTTOM);
//		jPanel1.add(jLabel2);
//		jPanel1.add(jTextField1);
//		jPanel1.add(jLabel1);
//		jPanel1.add(jTextField2);
//		jPanel1.add(jLabel3);
//		jPanel1.add(jTextField3);
//		jPanel2.add(jLabel4);
//		jPanel2.add(jComboBox1);
//		jPanel2.add(jBdel);
//		jPanel2.add(jBadd);
//		jPanel2.add(jBsave);
//		jPanel2.add(jBexit);
//		this.getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);
//		jSplitPane1.setDividerLocation(164);
//
//		jTextField1.addKeyListener(new SendFocuseAdapter(jTextField2));
//		buildTable();
//		initJcombox();
//	}
//
//	BorderLayout borderLayout1 = new BorderLayout();
//	JSplitPane jSplitPane1 = new JSplitPane();
//	JScrollPane jScrollPane1 = new JScrollPane();
//	JPanel jPanel1 = new JPanel();
//	
//	JTable jTable1 = new JTable();
//	
//	GridLayout gridLayout1 = new GridLayout();
//	JLabel jLabel1 = new JLabel();
//	JTextField jTextField1 = new JTextField();
//	JLabel jLabel2 = new JLabel();
//	JTextField jTextField2 = new JTextField();
//	JPanel jPanel2 = new JPanel();
//	JButton jBdel = new JButton();
//	FlowLayout flowLayout1 = new FlowLayout();
//	JButton jBadd = new JButton();
//	JButton jBsave = new JButton();
//	JButton jBexit = new JButton();
//	JLabel jLabel3 = new JLabel();
//	JComboBox jComboBox1 = new JComboBox();
//	String gradeID[] = null;
//	//添加变量用来控制状态
//	boolean insertflag = false;
//	JTextField jTextField3 = new JTextField();
//	JLabel jLabel4 = new JLabel();
//	public void buildTable(){
//		DefaultTableModel tablemodel = null;
//		String[] name = {"班级编号","年级编号","班级名称"};
//		String sqlStr = "select * from tb_classinfo";
//		appstu.util.RetrieveObject bdt = new  appstu.util.RetrieveObject();
//		tablemodel = bdt.getTableModel(name,sqlStr);
//		jTable1.setModel(tablemodel);
//		jTable1.setRowHeight(24);
//
//
//	}
//	private void initJcombox(){
//		String sqlStr = null;
//		sqlStr  = "select gradeID,gradeName from tb_gradeinfo";
//
//		RetrieveObject retrieve = new RetrieveObject();
//		java.util.Collection collection = null;
//		java.util.Iterator iterator = null;
//		collection = retrieve.getTableCollection(sqlStr);
//		iterator = collection.iterator();
//		gradeID = new String[collection.size()];
//		int i = 0;
//		jComboBox1.removeAllItems();
//		while(iterator.hasNext()){
//			java.util.Vector vdata = (java.util.Vector)iterator.next();
//			gradeID[i] = String.valueOf(vdata.get(0));
//			jComboBox1.addItem(vdata.get(1));
//			i++;
//		}
//
//	}
//	public void jBsave_actionPerformed(ActionEvent e) {
//		int result = JOptionPane.showOptionDialog(null,"是否存盘班级信息数据?","系统提示",
//				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
//				null,new String[]  {"是","否"},"否");
//		if (result == JOptionPane.NO_OPTION)  return;
//		int index = jComboBox1.getSelectedIndex();
//		String gradeid = gradeID[index];
//		appstu.model.Obj_classinfo objclassinfo = new appstu.model.Obj_classinfo();
//		objclassinfo.setClassID(jTextField2.getText().trim());
//		objclassinfo.setGradeID(gradeid);
//		// objclassinfo.setGradeID("0" + String.valueOf(jComboBox1.getSelectedIndex() + 1));
//		//objclassinfo.setGradeID("0" + (jTable1.getSelectedRow() + 1));
//		objclassinfo.setClassName(jTextField3.getText().trim());
//		JdbcAdapter jdbcAdapter = new JdbcAdapter();
//		if (jdbcAdapter.InsertOrUpdateObject(objclassinfo)) buildTable();
//
//	}
//
//	public void jBexit_actionPerformed(ActionEvent e) {
//		javax.swing.DefaultDesktopManager manger = new DefaultDesktopManager();
//		int result = JOptionPane.showOptionDialog(null,"是否退出班级信息设置?","系统提示",
//				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
//				null,new String[]  {"是","否"},"否");
//		if (result == JOptionPane.YES_OPTION) {
//			manger.closeFrame(this);
//		}
//
//	}
//
//	public void jBadd_actionPerformed(ActionEvent e) {
//		//获得年级名称
//		if ( jComboBox1.getItemCount() <= 0 ) return;
//		int index = jComboBox1.getSelectedIndex();
//		String gradeid = gradeID[index];
//		String sqlStr = null,classid = null;
//		sqlStr = "SELECT MAX(classID) FROM tb_classinfo where gradeID = '" + gradeid + "'";
//		ProduceMaxBh pm = new appstu.util.ProduceMaxBh();
//		System.out.println("我在方法item中" + sqlStr + "; index = " + index);
//		classid = pm.getMaxBh(sqlStr, gradeid);
//		jTextField1.setText(String.valueOf(jComboBox1.getSelectedItem()));
//		jTextField2.setText(classid);
//		jTextField3.setText("");
//		jTextField3.requestFocus();
//		//sqlStr  = "select gradeID,gradeName from tb_gradeinfo";
//		/*       RetrieveObject retrieve = new RetrieveObject();
//	        java.util.Collection collection = null;
//	        java.util.Iterator iterator = null;
//	        collection = retrieve.getTableCollection(sqlStr);
//	        iterator = collection.iterator();
//	        gradeID = new String[collection.size()];
//	        int i = 0;
//	        jComboBox1.removeAllItems();
//	        insertflag = true;
//	        while(iterator.hasNext()){
//	          java.util.Vector vdata = (java.util.Vector)iterator.next();
//	          gradeID[i] = String.valueOf(vdata.get(0));
//	          jComboBox1.addItem(vdata.get(1));
//	          i++;
//	        }
//
//	        ItemEvent item = new ItemEvent(jComboBox1,0,jComboBox1,jComboBox1.getSelectedIndex());
//	        jComboBox1_itemStateChanged(item);*/
//
//
//	}
//
//	public void jTable1_mouseClicked(MouseEvent e) {
//		insertflag = false;
//		String id = null;
//		String sqlStr = null;
//		int selectrow = 0;
//		selectrow = jTable1.getSelectedRow();
//		if (selectrow < 0 ) return;
//
//		id = jTable1.getValueAt(selectrow,0).toString();
//		sqlStr = "SELECT c.classID, d.gradeName, c.className FROM tb_classinfo c INNER JOIN " +
//				" tb_gradeinfo d ON c.gradeID = d.gradeID" +
//				" where c.classID = '" + id + "'";
//		java.util.Vector vdata = null;
//		RetrieveObject retrive = new RetrieveObject();
//		vdata = retrive.getObjectRow(sqlStr);
//
//		System.out.println(vdata.get(0) + ":" + vdata.get(1) + ": " + vdata.get(2));
//		jTextField2.setText(vdata.get(0).toString());
//		jTextField1.setText(vdata.get(1).toString());
//		jTextField3.setText(vdata.get(2).toString());
//
//	}
//
//	public void jBdel_actionPerformed(ActionEvent e) {
//		int result = JOptionPane.showOptionDialog(null,"是否删除班级信息数据?","系统提示",
//				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
//				null,new String[]  {"是","否"},"否");
//		if (result == JOptionPane.NO_OPTION)  return;
//		String sqlDel = "delete tb_classinfo where classID = '" + jTextField2.getText().trim() + "'";
//		JdbcAdapter jdbcAdapter = new JdbcAdapter();
//		if (jdbcAdapter.DeleteObject(sqlDel)) {
//
//			jTextField1.setText("");
//			jTextField2.setText("");
//			jTextField3.setText("");
//			buildTable();
//		}
//	}
//
//	public void jComboBox1_itemStateChanged(ItemEvent e) {
//		/* if (insertflag){
//	            String gradeid = null;
////	            gradeid = "0" + String.valueOf(jComboBox1.getSelectedIndex() + 1);
//	            int index = jComboBox1.getSelectedIndex();
//	            gradeid = gradeID[index];
//	            ProduceMaxBh pm = new appstu.util.ProduceMaxBh();
//	            String sqlStr = null, classid = null;
//	            sqlStr = "SELECT MAX(classID) FROM tb_classinfo where gradeID = '" +
//	                     gradeid + "'";
//	            System.out.println("我在方法item中" + sqlStr + "; index = " + index);
//	            classid = pm.getMaxBh(sqlStr, gradeid);
//
//	            jTextField1.setText(classid);
//	        }else{
//	            jTextField1.setText(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(),0)));
//
//	        }
//		 */
//	}
//}
//
//
//class JF_view_sysset_class_jComboBox1_itemAdapter implements ItemListener {
//	private EView adaptee;
//	JF_view_sysset_class_jComboBox1_itemAdapter(EView adaptee) {
//		this.adaptee = adaptee;
//	}
//
//	public void itemStateChanged(ItemEvent e) {
//		adaptee.jComboBox1_itemStateChanged(e);
//	}
//}
//
//
//class JF_view_sysset_class_jTable1_mouseAdapter extends MouseAdapter {
//	private EView adaptee;
//	JF_view_sysset_class_jTable1_mouseAdapter(EView adaptee) {
//		this.adaptee = adaptee;
//	}
//
//	public void mouseClicked(MouseEvent e) {
//		adaptee.jTable1_mouseClicked(e);
//	}
//}
//
//
//class JF_view_sysset_class_jBdel_actionAdapter implements ActionListener {
//	private EView adaptee;
//	JF_view_sysset_class_jBdel_actionAdapter(EView adaptee) {
//		this.adaptee = adaptee;
//	}
//
//	public void actionPerformed(ActionEvent e) {
//		adaptee.jBdel_actionPerformed(e);
//	}
//}
//
//
//class JF_view_sysset_class_jBadd_actionAdapter implements ActionListener {
//	private EView adaptee;
//	JF_view_sysset_class_jBadd_actionAdapter(EView adaptee) {
//		this.adaptee = adaptee;
//	}
//
//	public void actionPerformed(ActionEvent e) {
//		adaptee.jBadd_actionPerformed(e);
//	}
//}
//
//
//class JF_view_sysset_class_jBexit_actionAdapter implements ActionListener {
//	private EView adaptee;
//	JF_view_sysset_class_jBexit_actionAdapter(EView adaptee) {
//		this.adaptee = adaptee;
//	}
//
//	public void actionPerformed(ActionEvent e) {
//		adaptee.jBexit_actionPerformed(e);
//	}
//}
//
//
//class JF_view_sysset_class_jButton3_actionAdapter implements ActionListener {
//	private EView adaptee;
//	JF_view_sysset_class_jButton3_actionAdapter(EView adaptee) {
//		this.adaptee = adaptee;
//	}
//
//	public void actionPerformed(ActionEvent e) {
//
//		adaptee.jBsave_actionPerformed(e);
//	}
//}
//
