package com.cissst.service;

import java.util.List;

import com.cissst.entity.TbClassType;
import com.cissst.entity.TbClasses;
import com.cissst.entity.TbProblemDifficultyLevel;
import com.cissst.entity.TbProblemScore;
import com.cissst.entity.TbProblemType;
import com.cissst.entity.TbStudentType;
import com.cissst.entity.TbUser;
import com.cissst.entity.TbUserType;

/**
 * @ģ�����ƣ�SystemSettingAction(ϵͳ����)
 * @�����ˣ��¿�ȫ
 * @��          �ܣ�����SystemSettingAction������ҵ���߼�
 * @����ʱ�䣺
 */
public interface SystemSettingService
{
	public Object find(String HQL);
	public List<?> findWithPageObject(int startNumber, int pageSize, String tbName, String del,  String str);
	public List<?> findWithPage(int startNum, int pageSize, String HQL);
	public void addObject(Object obj);
	public void updateObject(Object obj);//�������º�ɾ��
	public String findUserCheckHQL(String uAccount, String uName, String uType, 
			String uGender, String uHiretime, String uLastLoginTime
			);
	public List<TbProblemType> findQlTypeCondition(String examNo, String examName);
	public List<TbProblemScore> findQlRangeCondition(String psNo, String psName);
	public List<TbProblemDifficultyLevel> findQlDifficultyCondition(String pdNo, String pdName);
	public List<TbClassType> findClassTypeCondition(String ctNo, String ctName);
	public List<TbStudentType> findStudentTypeCondition(String stNo, String stName);
	public TbUserType findWith(String uName);
	public Object findObject(String tbName, String tid, int Id);
	public int getRow(String HQL);
	
	public boolean findQlType(TbProblemType t);
	public boolean findQlRange(TbProblemScore ts);
	public boolean findQlDifficulty(TbProblemDifficultyLevel tpd);
	public boolean findClass(TbClassType clat);
	public boolean findStuType(TbStudentType tst);

}
