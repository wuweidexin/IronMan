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
 * @模块名称：ClassesManagerAction(班级管理)
 * @开发人：
 * @功          能：管理ClassesManagerAction的所有业务逻辑
 * @开发时间：
 */
public interface ClassesManagerService{
	public void save(TbClasses cla);

	public TbUser getUserById(int uId);

	public TbClassType getClassTypeById(int ctId);

	

	public List<TbClassType> findclatypeName();
	
	/**
	 * 根据用户姓名查询对象
	 * @param UName
	 * @return
	 */
	public List<TbUser> finduName();
	/**
	 * 班级查询
	 */
	public List<?> findUser();
	public TbClazzStatus findTbClazzStatus(String name);
	
	public List<?> findTbClazzStatus();
	
	
	public List<?> findClasses(Pager pager, String HQL);
	

	public  String checkHQL(HttpServletRequest request);
	
	public  String studentQueryHQL(HttpServletRequest request);
	
	public int getRows(String HQL);
	
	/**
	 * 根据班级名称查询班级信息
	 */
	public TbClasses findTbClasses(String className);
	
	/**
	 * 根据班级id查询班级信息
	 */
	public TbClasses findTbClasses(int id);
	
	/**
	 * 更新班级信息
	 */
	public void updateClasses(TbClasses clazz);
	
	/**
	 * 查询所有学生类型
	 */
	public List<?> findStudentType();
	
	/**
	 * 通过学生Id查找学生类型
	 */
	public TbStudentType findStudentType(int id);
	
	/**
	 * 根据学生id获得学生
	 */
	public TbUser getTbUser(int id);
	
	/**
	 * 保存学生
	 */
	public void saveStudent(TbStudent student);
	
	/**
	 * 根据用户Id查询学生
	 */
	public TbStudent getTbStudent(int id);
	
	/**
	 * 查询某个班级有多少个学生(根据班级id)
	 */
	public int getStudentCount(int id);
	
	/**
	 * 更新学生
	 */
	public void updateStudent(TbStudent student);
	
	/**
	 * 查询suoyou学生状态
	 */
	public List<?> findStudentStatus();
	
	/**
	 * 根据学生状态名查询其状态
	 */
	public TbStudentStatus findStudentStatues(String name) ;
}
