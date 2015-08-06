package com.chen.serviceImp;

import java.util.ArrayList;
import java.util.List;

import com.chen.dao.BaseDao;
import com.chen.daoImp.BaseDaoImp;
import com.chen.entity.Classes;
import com.chen.entity.Course;
import com.chen.entity.Selectcourse;
import com.chen.entity.Stucla;
import com.chen.entity.Student;
import com.chen.entity.Studylocation;
import com.chen.entity.Teacher;
import com.chen.service.CourseService;

public class CourseServiceImp implements CourseService{
	BaseDao baseDao = new BaseDaoImp();
	/*
	 * 课程查询
	 */

	public Course queryCourse() {
		String HQL = null;
		Course course = (Course) baseDao.findObject(HQL);
		return course;
	}
	/*
	 * 直接查询所有课程信息
	 * (non-Javadoc)
	 * @see com.chen.service.CourseService#queryListCourse()
	 */
	public List<Course> queryListCourse() {
		String HQL = "from Course where column5 =1";
		List<Course> list = baseDao.findList(HQL);
		return list;
	}
	/*
	 * 通过查询老师来查询课程信息
	 */
	public List<Teacher> queryTeachet()
	{
		String HQL ="from Teacher where column5='1'";
		List<Teacher> tea = baseDao.findList(HQL);	
		return tea;
		
	}
	/*
	 * 查询老师
	 * @see com.chen.service.CourseService#queryTeacher(int)
	 */
	public Teacher queryTeacher(int id) {
		
		String HQL ="from Teacher where column5 = '1' and TId="+id;
		Teacher tea = (Teacher) baseDao.findObject(HQL);	
		return tea;
	}
	public List<Teacher> queryListTeacher(){
		String HQL = "from Teacher where column5 = '1'";
		
		List<Teacher> list = baseDao.findList(HQL);
		return list;
	}
	/*
	 * 选课
	 * @see com.chen.service.CourseService#chooseCourse()
	 */
	public void chooseCourse(Selectcourse sc) {
		baseDao.saveObject(sc);
	}
	/*
	 * 保存选课信息
	 * @see com.chen.service.CourseService#saveSelectcourse(com.chen.entity.Selectcourse)
	 */
	public void saveSelectcourse(Selectcourse sc) {
		// TODO Auto-generated method stub
		baseDao.saveObject(sc);
	}
	/*
	 * 修改老师信息
	 * @see com.chen.service.CourseService#saveTeacher(com.chen.entity.Teacher)
	 */
	public void updateTeacher(Teacher t) {
		
		baseDao.updateObject(t);
	}
	/*
	 * 查询已选课程信息
	 * @see com.chen.service.CourseService#queryListSelectCourse()
	 */
	public List<Selectcourse> queryListSelectCourse(Student stu)
	{
		String HQL = "from Selectcourse where column2='1'";
		List<Selectcourse> list = new ArrayList<Selectcourse>();
		List<Selectcourse> li = (List<Selectcourse>)baseDao.findList(HQL);
		for (int i = 0; i < li.size(); i++) {
			if(li.get(i).getStudent().getSId().equals(stu.getSId())){
				list.add(li.get(i));
			}				
		}
		return list;
	}
	/*
	 * 验证所选课程是否自己已经选了
	 * @see com.chen.service.CourseService#checkSelectcourse(int)
	 */
	public int checkSelectcourse(int SId,int CId) {
		int flag = 0;
		String HQL = "from Selectcourse where column2='1'";
		List<Selectcourse> list = baseDao.findList(HQL);
		Selectcourse sc = null;
		for(int i = 0; i < list.size(); i ++)
		{
			sc = list.get(i);
			if(sc.getStudent().getSId() == SId && sc.getCourse().getCId() == CId)
			{
				flag = 1;
				break;
			}
		}
		return flag;		
	}
	/*
	 * 保存学生选该门课程所在的班级
	 * @see com.chen.service.CourseService#saveStucla(com.chen.entity.Stucla)
	 */
	public void saveStucla(Stucla stucla) {
		baseDao.saveObject(stucla);
	}
	/*
	 * 删除已选课程
	 * @see com.chen.service.CourseService#delectSelectCourse(int)
	 */
	public void delectSelectCourse(int id) {
		String HQL = "from Selectcourse where column2='1' and  scId="+id;
		Selectcourse s = (Selectcourse) baseDao.findObject(HQL);
		s.setColumn2("0");
		baseDao.updateObject(s);	
	}
	/*
	 * 新增班级
	 * @see com.chen.service.CourseService#saveClass(com.chen.entity.Classes)
	 */
	public void saveClass(Classes cl) {
		baseDao.saveObject(cl);
	}
	/*
	 * 新增课程
	 * @see com.chen.service.CourseService#saveCourse(com.chen.entity.Course)
	 */
	public void saveCourse(Course c) {
		baseDao.saveObject(c);
	}
	/*
	 * 新增老师
	 * @see com.chen.service.CourseService#saveTeacher(com.chen.entity.Teacher)
	 */
	public void saveTeacher(Teacher t) {
		baseDao.saveObject(t);
	}
	public  List<Studylocation> queryListStuLo() {
		String HQL = "from Studylocation where column6='1'";
		return baseDao.findList(HQL);
	}
	public void savaStudylocation(Studylocation sl) {
		baseDao.saveObject(sl);
		
	}
	public Studylocation queryStudylocation(int id) {
		String HQL = "from Studylocation where column6='1' and loId="+id;
		return (Studylocation)baseDao.findObject(HQL);
	}
	
}
