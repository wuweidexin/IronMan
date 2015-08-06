package com.chen.service;

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


public interface CourseService {

	public Course queryCourse();
	public List<Course> queryListCourse();
	public List<Teacher> queryTeachet();
	public Teacher queryTeacher(int id);
	public List<Teacher> queryListTeacher();
	public void chooseCourse(Selectcourse sc);
	public void updateTeacher(Teacher t);
	public void saveSelectcourse(Selectcourse sc);
	public int checkSelectcourse(int SId,int CId);
	public List<Selectcourse> queryListSelectCourse(Student stu);
	public void saveStucla(Stucla stucla);
	public void delectSelectCourse(int id);
	public void saveTeacher(Teacher t);
	public void saveClass(Classes cl);
	public void saveCourse(Course c);
	public List<Studylocation> queryListStuLo();
	public void savaStudylocation(Studylocation sl);
	public Studylocation queryStudylocation(int id);
	
}
