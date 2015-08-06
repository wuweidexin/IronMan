package com.cissst.iService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cissst.dao.ClassesManagerDao;
import com.cissst.entity.TbClassType;
import com.cissst.entity.TbClasses;
import com.cissst.entity.TbClazzStatus;
import com.cissst.entity.TbStudent;
import com.cissst.entity.TbStudentStatus;
import com.cissst.entity.TbStudentType;
import com.cissst.entity.TbUser;
import com.cissst.service.ClassesManagerService;
import com.cissst.utils.Pager;
/**
 * @模块名称：ClassesManagerAction(班级管理)
 * @开发人：
 * @功          能：管理ClassesManagerAction的所有业务逻辑
 * @开发时间：
 */
public class ClassesManagerServiceImp implements ClassesManagerService
{
	private ClassesManagerDao classesManagerDao;

	public ClassesManagerDao getClassesManagerDao()
	{
		return classesManagerDao;
	}

	public void setClassesManagerDao(ClassesManagerDao classesManagerDao)
	{
		this.classesManagerDao = classesManagerDao;
	}

	public void save(TbClasses cla) {
		classesManagerDao.save(cla);
	}

	public TbClassType getClassTypeById(int ctId) {
		return (TbClassType) classesManagerDao.findByHQL("from TbClassType where ctDel = 0 and id ="+ctId);
	}

	public TbUser getUserById(int uId) {
		
		return (TbUser) classesManagerDao.findByHQL("from TbUser where UDel = 0 and id ="+uId);
	}


	@SuppressWarnings("unchecked")
	public List<TbClassType> findclatypeName() {
		
		return (List<TbClassType>) classesManagerDao.findList("from TbClassType where ctDel = 0");
	}
	
	/**
	 * 根据用户姓名查询对象
	 * @param UName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TbUser> finduName(){
		return (List<TbUser>) classesManagerDao.findList("from TbUser where UDel = 0");
	}

	public List<?> findClasses(Pager pager, String HQL) {
		return classesManagerDao.findWithPage(pager.getStartRow(), pager.getPageSize(), HQL);
	}
	
	public  String checkHQL(HttpServletRequest request) {
		
		StringBuilder builder = new StringBuilder("from TbClasses where CDel=0");
		
		String classNo = request.getParameter("classNo");
		String className=request.getParameter("className");
		String uName =request.getParameter("uName");
		String csName =request.getParameter("csName");
		String ctName = request.getParameter("ctName");
		if(classNo != "" && classNo != null) {
			builder.append(" and CNum like '%"+classNo+"%'");
		} 
		if(className !=""&& className!=null){
			builder.append("and className like '%"+className+"%'");
		}
		if(uName!="" && uName!=null){
			builder.append("and tbUser.UName like '%"+uName+"%'");
		}
		if(csName!="" && csName!=null){
			builder.append("and tbClazzStatus.csName like '%"+csName+"%'");
		}
		if(ctName!="" && ctName!=null){
			builder.append("and tbClassType.ctName like '%"+ctName+"%'");
		}
		
		
		
		String HQL = builder.toString();
		request.getSession().setAttribute("HQL", HQL);
		return HQL;
		
	}
	
	public  String studentQueryHQL(HttpServletRequest request) {
		
		StringBuilder builder = new StringBuilder("from TbStudent where stuDel=0");
		
		String stuNo = request.getParameter("stuNo");
		
		String stuName=request.getParameter("stuName");
		
		String sex =request.getParameter("sex");
		
		String claName =request.getParameter("claName");
		
		String stuStatus = request.getParameter("stuStatus");
		
		String stuType = request.getParameter("stuType");
		
		if(stuNo != "" && stuNo != null) {
			builder.append(" and col1 like '%"+stuNo+"%'");
		} 
		if(stuName !=""&& stuName!=null){
			builder.append("and col2 like '%"+stuName+"%'");
		}
		if(sex!="" && sex!=null){
			builder.append("and col3 like '%"+sex+"%'");
		}
		if(claName!="" && claName!=null){
			builder.append("and tbClasses.CName like '%"+claName+"%'");
		}
		if(stuStatus!="" && stuStatus!=null){
			builder.append("and tbStudentStatus.ssName like '%"+stuStatus+"%'");
		}
		if(stuType!="" && stuType!=null){
			builder.append("and tbStudentType.stName like '%"+stuType+"%'");
		}
		
		
		
		String HQLs = builder.toString();
		request.getSession().setAttribute("HQLs", HQLs);
		return HQLs;
		
	}
	
	public int getRows(String HQL) {
		return classesManagerDao.findList(HQL).size();
		
	}

	public List<?> findUser() {
		
		return classesManagerDao.findList("from TbUser where UDel=0");
	}

	/**
	 * 根据班级状态名查询状态id
	 */
	public TbClazzStatus findTbClazzStatus(String name) {
		
		return (TbClazzStatus) classesManagerDao.findByHQL("from TbClazzStatus where csDel=0 and csName like'%"+name+"%'");
	}
	
	/**
	 * 查询所有班级状态
	 */
	public List<?> findTbClazzStatus() {
		
		return  classesManagerDao.findList("from TbClazzStatus where csDel=0");
	}
	
	/**
	 * 根据班级名称查询班级信息
	 */
	public TbClasses findTbClasses(String classNo){
		
		return (TbClasses) classesManagerDao.findByHQL("from TbClasses where CDel=0 and CNum like '%"+classNo+"%' ");
		
	}

	/**
	 * 根据班级id查询班级信息
	 */
	public TbClasses findTbClasses(int id) {

		return (TbClasses) classesManagerDao.findByHQL("from TbClasses where CDel =0 and CId=" +id);
	}

	/**
	 * 更新班级信息
	 */
	public void updateClasses(TbClasses clazz){
		classesManagerDao.update(clazz);
	}
	
	/**
	 * 查询所有学生类型
	 */
	public List<?> findStudentType(){
		return classesManagerDao.findList("from TbStudentType where stDel=0");
	}

	/**
	 * 通过学生Id查找学生类型
	 */
	public TbStudentType findStudentType(int id){
		return (TbStudentType) classesManagerDao.findByHQL("from TbStudentType where stDel=0 and stId="+id);
		
	}
	
	/**
	 * 根据学生id获得学生
	 */
	public TbUser getTbUser(int id){
		return (TbUser) classesManagerDao.findByHQL("from TbUser where UDel=0 and UId="+id);
		
	}
	
	/**
	 * 保存学生
	 */
	public void saveStudent(TbStudent student){
		classesManagerDao.save(student);
	}
	
	/**
	 * 根据用户Id查询学生
	 */
	public TbStudent getTbStudent(int id){
		return (TbStudent) classesManagerDao.findByHQL("from TbStudent where stuDel=0 and stuId="+id);
		
	}
	
	/**
	 * 查询某个班级有多少个学生(根据班级id)
	 */
	public int getStudentCount(int id) {
		int countNum = 0;
		String temp = (String) classesManagerDao.findByHQL("select col2 from TbClasses where CDel =0 and CId="+id);
		if(temp == null) {
			countNum =1;
		} else {
			int temp_1 = Integer.parseInt(temp);
			countNum= temp_1+1;
		}
		return countNum;
		
	}
	
	/**
	 * 更新学生
	 */
	public void updateStudent(TbStudent student){
		classesManagerDao.update(student);
	}
	
	/**
	 * 查询学生状态
	 */
	public List<?> findStudentStatus(){
		return classesManagerDao.findList("from TbStudentStatus where ssDel =0");
	}
	
	/**
	 * 根据学生状态名查询其状态
	 */
	public TbStudentStatus findStudentStatues( String name) {
		return (TbStudentStatus) classesManagerDao.findByHQL("from TbStudentStatus where ssDel =0 and ssName like '%"+name+"%'");
		
	}

}
