package com.cissst.mapping;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.cissst.dao.IndexPageDao;
import com.cissst.entity.TbAuditStatus;
import com.cissst.entity.TbClazzStatus;
import com.cissst.entity.TbExamPlan;
import com.cissst.entity.TbPlanStatus;
import com.cissst.entity.TbProblemType;
import com.cissst.entity.TbReadStatus;
import com.cissst.entity.TbReadType;
import com.cissst.entity.TbStudentStatus;
import com.cissst.entity.TbUser;
import com.cissst.entity.TbUserType;
import com.cissst.iDao.IndexPageDaoImp;


public class TestMapping {
	
	
	public static void main(String[] args) {
		IndexPageDao indexPageDao = new IndexPageDaoImp();
		Configuration  cfg=new Configuration().configure();
		SchemaExport export=new SchemaExport(cfg);
		export.create(true, true);
		//��ʼ���û�����
		TbUserType userType = new TbUserType();
		userType.setUtName("����Ա");
		userType.setUtDel("0");
		saveObject(userType);
		
		TbUserType userType1 = new TbUserType();
		userType1.setUtName("��������");
		userType1.setUtDel("0");
		saveObject(userType1);
		
		TbUserType userType2 = new TbUserType();
		userType2.setUtName("������");
		userType2.setUtDel("0");
		saveObject(userType2);
		
		TbUserType userType3 = new TbUserType();
		userType3.setUtName("��ʦ");
		userType3.setUtDel("0");
		saveObject(userType3);
		
		TbUserType userType4= new TbUserType();
		userType4.setUtName("һ���û�");
		userType4.setUtDel("0");
		saveObject(userType4);
		
		
		
		
		
		//Ԥ��TbAuditStatus״̬
		TbAuditStatus tas = new TbAuditStatus();
		tas.setAsName("�ѱ���");
		tas.setAsDel("0");
		saveObject(tas);
		
		TbAuditStatus tas0 = new TbAuditStatus();
		tas0.setAsName("���ύ");
		tas0.setAsDel("0");
		saveObject(tas0);
		
		TbAuditStatus tas1 = new TbAuditStatus();
		tas1.setAsName("��ͨ��");
		tas1.setAsDel("0");
		saveObject(tas1);
		
		TbAuditStatus tas2 = new TbAuditStatus();
		tas2.setAsName("�Ѿܾ�");
		tas2.setAsDel("0");
		saveObject(tas2);
		
		//Ԥ��TbPlanStatus����
		TbPlanStatus tps = new TbPlanStatus();
		tps.setPsDel("0");
		tps.setPsName("�ѳ���");
		saveObject(tps);
		
		TbPlanStatus tps1 = new TbPlanStatus();
		tps1.setPsDel("0");
		tps1.setPsName("δ����");
		saveObject(tps1);
		
		TbPlanStatus tps2 = new TbPlanStatus();
		tps2.setPsDel("0");
		tps2.setPsName("�ѷ���");
		saveObject(tps2);
		
		//Ԥ��TbReadType����
		TbReadType trt = new TbReadType();
		trt.setRtDel("0");
		trt.setRtName("��ʦ����");
		saveObject(trt);
		
		TbReadType trt1 = new TbReadType();
		trt1.setRtDel("0");
		trt1.setRtName("�Զ�����");
		saveObject(trt1);
		
		//Ԥ��TbReadStatus����
		TbReadStatus trs = new TbReadStatus();
		trs.setRsDel("0");
		trs.setRsName("δ����");
		saveObject(trs);
		
		TbReadStatus trs1 = new TbReadStatus();
		trs1.setRsDel("0");
		trs1.setRsName("������");
		saveObject(trs1);
		
		TbReadStatus trs2 = new TbReadStatus();
		trs2.setRsDel("0");
		trs2.setRsName("������");
		saveObject(trs2);
		
		
		TbUser user = new TbUser();
		user.setUAccount("admin");
		user.setUName("Administrator");
		user.setUPwd("admin");
		
		//��TbClazzStatusԤ������
		TbClazzStatus tcs = new TbClazzStatus();
		tcs.setCsName("δ����");
		tcs.setCsDel("0");
		saveObject(tcs);
		
		TbClazzStatus tcs1 = new TbClazzStatus();
		tcs1.setCsName("�ѿ���");
		tcs1.setCsDel("0");
		saveObject(tcs1);
		
		TbClazzStatus tcs2 = new TbClazzStatus();
		tcs2.setCsName("�ѽ�ҵ");
		tcs2.setCsDel("0");
		saveObject(tcs2);
		
		//ѧ��״̬��TbStudentStatus��������
		
		TbStudentStatus tss = new TbStudentStatus();
		tss.setSsName("����ѧ");
		tss.setSsDel("0");
		saveObject(tss);
		
		TbStudentStatus tss1 = new TbStudentStatus();
		tss1.setSsName("����ѧ");
		tss1.setSsDel("0");
		saveObject(tss1);
		
		TbStudentStatus tss2 = new TbStudentStatus();
		tss2.setSsName("�ѽ�ҵ");
		tss2.setSsDel("0");
		saveObject(tss2);
		
		
		user.setTbUserType(findObject());//ϵͳ���Ȩ�ޣ�Ĭ�ϲ����޸������ݣ���������
		user.setUGender("��");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date de=new Date();
		user.setUHiretime(sdf.format(de));
		user.setUEmail("123456789@qq.com");
		user.setUDel("0");
		saveObject(user);
		
	}
	
	public static void saveObject(Object object) 
	{
		// 1 --���ӵ����ݿ�
		Configuration cfg = new Configuration().configure();
		// 2 --�������ݿ�����Ĺ���
		SessionFactory factory = cfg.buildSessionFactory();
		// 3 --���ɲ������ݵ�session����
		Session session = factory.openSession();
		try {
			// 4 --��������
			session.getTransaction().begin();
			// 5 --ִ������
			session.save(object);
			// 6 --�ύ����
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// 7 --�����쳣���ع�����
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	public static TbUserType findObject() 
	{
		// 1 --���ӵ����ݿ�
		Configuration cfg = new Configuration().configure();
		// 2 --�������ݿ�����Ĺ���
		SessionFactory factory = cfg.buildSessionFactory();
		TbUserType t = null;
		// 3 --���ɲ������ݵ�session����
		Session session = factory.openSession();
		try {
			// 4 --��������
			session.getTransaction().begin();
			// 5 --ִ������
			
			t = (TbUserType) session.get(TbUserType.class, 1);
			
			// 6 --�ύ����
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// 7 --�����쳣���ع�����
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return t;
	}


}
