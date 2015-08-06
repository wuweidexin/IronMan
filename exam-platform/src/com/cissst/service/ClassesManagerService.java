package com.cissst.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cissst.entity.TbClassType;
import com.cissst.entity.TbClasses;
import com.cissst.entity.TbClazzStatus;
import com.cissst.entity.TbStudent;
import com.cissst.entity.TbStudentStatus;
import com.cissst.entity.TbStudentType;
import com.cissst.entity.TbUser;
import com.cissst.utils.Pager;

/**
 * @ģ�����ƣ�ClassesManagerAction(�༶����)
 * @�����ˣ�
 * @��          �ܣ�����ClassesManagerAction������ҵ���߼�
 * @����ʱ�䣺
 */
public interface ClassesManagerService{
	public void save(TbClasses cla);

	public TbUser getUserById(int uId);

	public TbClassType getClassTypeById(int ctId);

	

	public List<TbClassType> findclatypeName();
	
	/**
	 * �����û�������ѯ����
	 * @param UName
	 * @return
	 */
	public List<TbUser> finduName();
	/**
	 * �༶��ѯ
	 */
	public List<?> findUser();
	public TbClazzStatus findTbClazzStatus(String name);
	
	public List<?> findTbClazzStatus();
	
	
	public List<?> findClasses(Pager pager, String HQL);
	

	public  String checkHQL(HttpServletRequest request);
	
	public  String studentQueryHQL(HttpServletRequest request);
	
	public int getRows(String HQL);
	
	/**
	 * ���ݰ༶���Ʋ�ѯ�༶��Ϣ
	 */
	public TbClasses findTbClasses(String className);
	
	/**
	 * ���ݰ༶id��ѯ�༶��Ϣ
	 */
	public TbClasses findTbClasses(int id);
	
	/**
	 * ���°༶��Ϣ
	 */
	public void updateClasses(TbClasses clazz);
	
	/**
	 * ��ѯ����ѧ������
	 */
	public List<?> findStudentType();
	
	/**
	 * ͨ��ѧ��Id����ѧ������
	 */
	public TbStudentType findStudentType(int id);
	
	/**
	 * ����ѧ��id���ѧ��
	 */
	public TbUser getTbUser(int id);
	
	/**
	 * ����ѧ��
	 */
	public void saveStudent(TbStudent student);
	
	/**
	 * �����û�Id��ѯѧ��
	 */
	public TbStudent getTbStudent(int id);
	
	/**
	 * ��ѯĳ���༶�ж��ٸ�ѧ��(���ݰ༶id)
	 */
	public int getStudentCount(int id);
	
	/**
	 * ����ѧ��
	 */
	public void updateStudent(TbStudent student);
	
	/**
	 * ��ѯsuoyouѧ��״̬
	 */
	public List<?> findStudentStatus();
	
	/**
	 * ����ѧ��״̬����ѯ��״̬
	 */
	public TbStudentStatus findStudentStatues(String name) ;
}
