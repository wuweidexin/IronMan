package com.chen.service;
import java.util.List;

import com.chen.entity.*;

public interface StuService {
	/*
	 * 验证登陆
	 */
	public String checkLogin(String username, String password);
	/*
	 * 查找一个学生
	 */
	public Student findStu(String HQL);
	public List<Student> findListStu();
	/*
	 * 增加一个学生
	 */
	public void saveStu(Student stu);
	/*
	 * 删除一个学生
	 */
	public void delectStu(int id);
	/*
	 * 修改一个学生
	 */
	public void updateStu(Student stu);
}
