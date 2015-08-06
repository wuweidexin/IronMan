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
	 * �γ̲�ѯ
	 */

	public Course queryCourse() {
		String HQL = null;
		Course course = (Course) baseDao.findObject(HQL);
		return course;
	}
	/*
	 * ֱ�Ӳ�ѯ���пγ���Ϣ
	 * (non-Javadoc)
	 * @see com.chen.service.CourseService#queryListCourse()
	 */
	public List<Course> queryListCourse() {
		String HQL = "from Course where column5 =1";
		List<Course> list = baseDao.findList(HQL);
		return list;
	}
	/*
	 * ͨ����ѯ��ʦ����ѯ�γ���Ϣ
	 */
	public List<Teacher> queryTeachet()
	{
		String HQL ="from Teacher where column5='1'";
		List<Teacher> tea = baseDao.findList(HQL);	
		return tea;
		
	}
	/*
	 * ��ѯ��ʦ
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
	 * ѡ��
	 * @see com.chen.service.CourseService#chooseCourse()
	 */
	public void chooseCourse(Selectcourse sc) {
		baseDao.saveObject(sc);
	}
	/*
	 * ����ѡ����Ϣ
	 * @see com.chen.service.CourseService#saveSelectcourse(com.chen.entity.Selectcourse)
	 */
	public void saveSelectcourse(Selectcourse sc) {
		// TODO Auto-generated method stub
		baseDao.saveObject(sc);
	}
	/*
	 * �޸���ʦ��Ϣ
	 * @see com.chen.service.CourseService#saveTeacher(com.chen.entity.Teacher)
	 */
	public void updateTeacher(Teacher t) {
		
		baseDao.updateObject(t);
	}
	/*
	 * ��ѯ��ѡ�γ���Ϣ
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
	 * ��֤��ѡ�γ��Ƿ��Լ��Ѿ�ѡ��
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
	 * ����ѧ��ѡ���ſγ����ڵİ༶
	 * @see com.chen.service.CourseService#saveStucla(com.chen.entity.Stucla)
	 */
	public void saveStucla(Stucla stucla) {
		baseDao.saveObject(stucla);
	}
	/*
	 * ɾ����ѡ�γ�
	 * @see com.chen.service.CourseService#delectSelectCourse(int)
	 */
	public void delectSelectCourse(int id) {
		String HQL = "from Selectcourse where column2='1' and  scId="+id;
		Selectcourse s = (Selectcourse) baseDao.findObject(HQL);
		s.setColumn2("0");
		baseDao.updateObject(s);	
	}
	/*
	 * �����༶
	 * @see com.chen.service.CourseService#saveClass(com.chen.entity.Classes)
	 */
	public void saveClass(Classes cl) {
		baseDao.saveObject(cl);
	}
	/*
	 * �����γ�
	 * @see com.chen.service.CourseService#saveCourse(com.chen.entity.Course)
	 */
	public void saveCourse(Course c) {
		baseDao.saveObject(c);
	}
	/*
	 * ������ʦ
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
