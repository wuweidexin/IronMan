package com.cissst.iService;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.cissst.dao.SystemSettingDao;
import com.cissst.entity.TbClassType;
import com.cissst.entity.TbClasses;
import com.cissst.entity.TbProblemDifficultyLevel;
import com.cissst.entity.TbProblemScore;
import com.cissst.entity.TbProblemType;
import com.cissst.entity.TbStudentType;
import com.cissst.entity.TbUser;
import com.cissst.entity.TbUserType;
import com.cissst.service.SystemSettingService;
/**
 * @ģ�����ƣ�SystemSettingAction(ϵͳ����)
 * @�����ˣ��¿�ȫ
 * @��          �ܣ�����SystemSettingAction������ҵ���߼�
 * @����ʱ�䣺
 */
public class SystemSettingServiceImp implements SystemSettingService
{
	private SystemSettingDao systemSettingDao;

	public SystemSettingDao getSystemSettingDao()
	{
		return systemSettingDao;
	}

	public void setSystemSettingDao(SystemSettingDao systemSettingDao)
	{
		this.systemSettingDao = systemSettingDao;
	}
	
	//��������ѯһ���û�
	public List<?> findWithPageObject(int startNumber, int pageSize, String tbName, String del,  String str)
	{
		String hql = "from "+ tbName +" where " +del +"='0' ";
		if(str == null)
		{
			str="";
		}
		String HQL = hql + str;
		List<?> list =  systemSettingDao.findWithPage(startNumber, pageSize, HQL);
		
System.out.println(HQL+str);
		return list;
		
	}
	
	
	//����һ������
	public void addObject(Object obj)
	{
		systemSettingDao.save(obj);
	}

	//����һ������
	public void updateObject(Object obj)
	{
		systemSettingDao.update(obj);
	}
	//����һ������
	public Object find(String HQL) {
		
		return systemSettingDao.findByHQL(HQL);
	}
	//��������ѯһ��TbUser����ģ����ѯ
	@SuppressWarnings("unchecked")
	public String findUserCheckHQL(String uAccount, String uName, String uType, 
			String uGender, String uHiretime, String uLastLoginTime
			) {
		String str = null;
		StringBuilder strb =  new StringBuilder();
		if(uGender!=null)
		{
			int sexTemp=Integer.valueOf(uGender);
			switch(sexTemp)
			{
			case 0:uGender=null;break;
			case 1:uGender="��";break;
			case 2:uGender="Ů";break;
			}
		}
		if(uType!=null)
		{
			int temp=Integer.valueOf(uType);
			switch(temp)
			{
			case 0:uType=null;break;
			case 1:uType="��ʦ";break;
			case 2:uType="������";break;
			case 3:uType="��������";break;
			case 4:uType="һ���û�";break;
			}
		}
		
		
		
		if(uAccount != null && uAccount.length()!= 0)
		{
			strb.append("and UAccount like '%"+uAccount+"%' ");
		}
		
		if(uName != null && uName.length() != 0)
		{
			strb.append("and UName like '%"+uName+"%' ");
		}
		if(uType != null && uType.length() != 0)
		{
			strb.append("and tbUserType.utName like '%"+uType+"%' ");
		}
		
		if(uGender != null && uGender.length() != 0)
		{
			strb.append("and UGender like '%"+uGender+"%' ");
		}
		
		if(uHiretime != null && uHiretime.length() != 0)
		{
			strb.append("and UHiretime > '"+uHiretime+"' ");
		}
		
		if(uLastLoginTime != null && uLastLoginTime.length() != 0)
		{
			strb.append("and UHiretime < '"+uLastLoginTime+"' ");
		}
		String allHQL = "from TbUser where UDel ='0' ";
		str = strb.toString();
		String HQL =allHQL + str ;
		ServletActionContext.getRequest().getSession().setAttribute("HQL", HQL);
		return HQL;
		
	}
	
	
	//ģ����ѯһ��TbProblemType����
	public List<TbProblemType> findQlTypeCondition(String examNo, String examName) {
		String str = null;
		StringBuilder strb =  new StringBuilder();
		
		if(examNo != null && examNo.length()!= 0)
		{
			strb.append("and ptMyselfId like '%"+examNo+"%' ");
		}
		
		if(examName != null && examName.length() != 0)
		{
			strb.append("and ptName like '%"+examName+"%' ");
		}
		str = strb.toString();
		List list =  (List<TbProblemType>)findWithPageObject(0, 100, "TbProblemType", "ptDel", str);
		
		return list;
	}
	//ģ����ѯһ��TbClassType����
	public List<TbClassType> findClassTypeCondition(String ctNo, String ctName) {
		String str = null;
		StringBuilder strb =  new StringBuilder();
		
		if(ctNo != null && ctNo.length()!= 0)
		{
			strb.append("and ctMyselfId like '%"+ctNo+"%' ");
		}
		
		if(ctName != null && ctName.length() != 0)
		{
			strb.append("and ctName like '%"+ctName+"%' ");
		}
		str = strb.toString();
		List list =  (List<TbClassType>)findWithPageObject(0, 100, "TbClassType", "ctDel", str);
		return list;
	}
	//ģ����ѯһ��TbProblemDifficultyLevel����
	public List<TbProblemDifficultyLevel> findQlDifficultyCondition(String pdNo, String pdName) {
	
		StringBuilder strb =  new StringBuilder();
		
		if(pdNo != null && pdNo.length()!= 0)
		{
			strb.append("and pdlMyselfId like '%"+pdNo+"%' ");
		}
		
		if(pdName != null && pdName.length() != 0)
		{
			strb.append("and pdlName like '%"+pdName+"%' ");
		}
		
		String str = strb.toString();
		List list =  (List<TbProblemDifficultyLevel>)findWithPageObject(0, 100, "TbProblemDifficultyLevel", "pdlDel", str);
		return list;
	}
	//ģ����ѯһ��TbProblemScore����
	public List<TbProblemScore> findQlRangeCondition(String psNo, String psName) {
		String str = null;
		StringBuilder strb =  new StringBuilder();
		
		if(psNo != null && psNo.length()!= 0)
		{
			strb.append("and psMyselfId like '%"+psNo+"%' ");
		}
		
		if(psName != null && psName.length() != 0)
		{
			strb.append("and psName like '%"+psName+"%' ");
		}
		str = strb.toString();
		List list =  (List<TbProblemScore>)findWithPageObject(0, 100, "TbProblemScore", "psDel", str);
		//System.out.println(str);
		return list;
	}

	
	//ģ����ѯһ��TbStudentType����
	public List<TbStudentType> findStudentTypeCondition(String stNo, String stName) {
		String str = null;
		StringBuilder strb =  new StringBuilder();
		
		if(stNo != null && stNo.length()!= 0)
		{
			strb.append("and stMyselfId like '%"+stNo+"%' ");
		}
		
		if(stName != null && stName.length() != 0)
		{
			strb.append("and stName like '%"+stName+"%' ");
		}
		str = strb.toString();
		List list =  (List<TbStudentType>)findWithPageObject(0, 100, "TbStudentType", "stDel", str);
		return list;
	}
	//��ȷ��ѯ��ͨ��utName��ѯһ��TbUserType����
	public TbUserType findWith(String uName)
	{
		TbUserType tut = (TbUserType) find("from TbUserType where utName='" + uName+"'");
		return tut;
	}
	

	public Object findObject(String tbName, String tid, int Id) {
		String HQL="from "+tbName+" where "+tid+"="+Id;
		return find(HQL);
	}

	public int getRow(String HQL) {
		
		return systemSettingDao.findList(HQL).size();
	}

	public List<?> findWithPage(int startNum, int pageSize, String HQL) {
		List<?> list = systemSettingDao.findWithPage(startNum, pageSize, HQL);
		ServletActionContext.getRequest().getSession().setAttribute("HQL", HQL);
		ServletActionContext.getRequest().getSession().setAttribute("rows", list.size());
		return list;
	}
	
	//�����������������Ƿ����
	public boolean findQlType(TbProblemType t)
	{
		String Hql = "from TbProblemType where ptDel='0' and ptName = '"+t.getPtName()+"'";
		//�������ݿ��и��û��������û�
		TbProblemType u = (TbProblemType) systemSettingDao.findByHQL(Hql);
		if(u!=null)
		{
			//��ͬ�����û�������
			return true;
		}
		else
		{
			return false;
		}
	}
	//������ⷶΧ�����Ƿ����
	public boolean findQlRange(TbProblemScore ts) {
		String Hql = "from TbProblemScore where psDel='0' and psName = '"+ts.getPsName()+"'";
		//�������ݿ��и��û��������û�
		TbProblemScore u = (TbProblemScore) systemSettingDao.findByHQL(Hql);
		if(u!=null)
		{
			//��ͬ�����û�������
			return true;
		}
		else
		{
			return false;
		}
	}
	//��������Ѷ������Ƿ����
	public boolean findQlDifficulty(TbProblemDifficultyLevel tpd) {
		String Hql = "from TbProblemDifficultyLevel where pdlDel='0' and pdlName = '"+tpd.getPdlName()+"'";
		//�������ݿ��и��û��������û�
		TbProblemDifficultyLevel u = (TbProblemDifficultyLevel) systemSettingDao.findByHQL(Hql);
		if(u!=null)
		{
			//��ͬ�����û�������
			return true;
		}
		else
		{
			return false;
		}
	}
	//���༶���������Ƿ����
	public boolean findClass(TbClassType clat) {
		String Hql = "from TbClassType where ctDel='0' and ctName = '"+clat.getCtName()+"'";
		TbClassType u = (TbClassType) systemSettingDao.findByHQL(Hql);
		if(u!=null)
		{
			//��ͬ�����û�������
			return true;
		}
		else
		{
			return false;
		}
	}
	//���ѧ�����������Ƿ����
	public boolean findStuType(TbStudentType tst) {
		String Hql = "from TbStudentType where stDel='0' and stName = '"+tst.getStName()+"'";
		//�������ݿ��и��û��������û�
		TbStudentType u = (TbStudentType) systemSettingDao.findByHQL(Hql);
		if(u!=null)
		{
			//��ͬ�����û�������
			return true;
		}
		else
		{
			return false;
		}
	}

}
