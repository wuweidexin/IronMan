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
		//初始化用户类型
		TbUserType userType = new TbUserType();
		userType.setUtName("管理员");
		userType.setUtDel("0");
		saveObject(userType);
		
		TbUserType userType1 = new TbUserType();
		userType1.setUtName("教务主任");
		userType1.setUtDel("0");
		saveObject(userType1);
		
		TbUserType userType2 = new TbUserType();
		userType2.setUtName("班主任");
		userType2.setUtDel("0");
		saveObject(userType2);
		
		TbUserType userType3 = new TbUserType();
		userType3.setUtName("讲师");
		userType3.setUtDel("0");
		saveObject(userType3);
		
		TbUserType userType4= new TbUserType();
		userType4.setUtName("一般用户");
		userType4.setUtDel("0");
		saveObject(userType4);
		
		
		
		
		
		//预存TbAuditStatus状态
		TbAuditStatus tas = new TbAuditStatus();
		tas.setAsName("已保存");
		tas.setAsDel("0");
		saveObject(tas);
		
		TbAuditStatus tas0 = new TbAuditStatus();
		tas0.setAsName("已提交");
		tas0.setAsDel("0");
		saveObject(tas0);
		
		TbAuditStatus tas1 = new TbAuditStatus();
		tas1.setAsName("已通过");
		tas1.setAsDel("0");
		saveObject(tas1);
		
		TbAuditStatus tas2 = new TbAuditStatus();
		tas2.setAsName("已拒绝");
		tas2.setAsDel("0");
		saveObject(tas2);
		
		//预存TbPlanStatus数据
		TbPlanStatus tps = new TbPlanStatus();
		tps.setPsDel("0");
		tps.setPsName("已撤销");
		saveObject(tps);
		
		TbPlanStatus tps1 = new TbPlanStatus();
		tps1.setPsDel("0");
		tps1.setPsName("未发布");
		saveObject(tps1);
		
		TbPlanStatus tps2 = new TbPlanStatus();
		tps2.setPsDel("0");
		tps2.setPsName("已发布");
		saveObject(tps2);
		
		//预存TbReadType数据
		TbReadType trt = new TbReadType();
		trt.setRtDel("0");
		trt.setRtName("老师批阅");
		saveObject(trt);
		
		TbReadType trt1 = new TbReadType();
		trt1.setRtDel("0");
		trt1.setRtName("自动批阅");
		saveObject(trt1);
		
		//预存TbReadStatus数据
		TbReadStatus trs = new TbReadStatus();
		trs.setRsDel("0");
		trs.setRsName("未批阅");
		saveObject(trs);
		
		TbReadStatus trs1 = new TbReadStatus();
		trs1.setRsDel("0");
		trs1.setRsName("批阅中");
		saveObject(trs1);
		
		TbReadStatus trs2 = new TbReadStatus();
		trs2.setRsDel("0");
		trs2.setRsName("已批阅");
		saveObject(trs2);
		
		
		TbUser user = new TbUser();
		user.setUAccount("admin");
		user.setUName("Administrator");
		user.setUPwd("admin");
		
		//给TbClazzStatus预存数据
		TbClazzStatus tcs = new TbClazzStatus();
		tcs.setCsName("未开班");
		tcs.setCsDel("0");
		saveObject(tcs);
		
		TbClazzStatus tcs1 = new TbClazzStatus();
		tcs1.setCsName("已开班");
		tcs1.setCsDel("0");
		saveObject(tcs1);
		
		TbClazzStatus tcs2 = new TbClazzStatus();
		tcs2.setCsName("已结业");
		tcs2.setCsDel("0");
		saveObject(tcs2);
		
		//学生状态表TbStudentStatus增添数据
		
		TbStudentStatus tss = new TbStudentStatus();
		tss.setSsName("已入学");
		tss.setSsDel("0");
		saveObject(tss);
		
		TbStudentStatus tss1 = new TbStudentStatus();
		tss1.setSsName("已退学");
		tss1.setSsDel("0");
		saveObject(tss1);
		
		TbStudentStatus tss2 = new TbStudentStatus();
		tss2.setSsName("已结业");
		tss2.setSsDel("0");
		saveObject(tss2);
		
		
		user.setTbUserType(findObject());//系统最高权限，默认不能修改其内容！！！！！
		user.setUGender("男");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date de=new Date();
		user.setUHiretime(sdf.format(de));
		user.setUEmail("123456789@qq.com");
		user.setUDel("0");
		saveObject(user);
		
	}
	
	public static void saveObject(Object object) 
	{
		// 1 --链接到数据库
		Configuration cfg = new Configuration().configure();
		// 2 --生成数据库操作的工厂
		SessionFactory factory = cfg.buildSessionFactory();
		// 3 --生成操作数据的session对象
		Session session = factory.openSession();
		try {
			// 4 --开启事务
			session.getTransaction().begin();
			// 5 --执行事务
			session.save(object);
			// 6 --提交事务
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// 7 --出现异常，回滚事务
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	public static TbUserType findObject() 
	{
		// 1 --链接到数据库
		Configuration cfg = new Configuration().configure();
		// 2 --生成数据库操作的工厂
		SessionFactory factory = cfg.buildSessionFactory();
		TbUserType t = null;
		// 3 --生成操作数据的session对象
		Session session = factory.openSession();
		try {
			// 4 --开启事务
			session.getTransaction().begin();
			// 5 --执行事务
			
			t = (TbUserType) session.get(TbUserType.class, 1);
			
			// 6 --提交事务
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// 7 --出现异常，回滚事务
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return t;
	}


}
