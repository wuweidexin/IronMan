package com.chen.service;
import java.util.List;

import com.chen.entity.*;

public interface StuService {
	/*
	 * ��֤��½
	 */
	public String checkLogin(String username, String password);
	/*
	 * ����һ��ѧ��
	 */
	public Student findStu(String HQL);
	public List<Student> findListStu();
	/*
	 * ����һ��ѧ��
	 */
	public void saveStu(Student stu);
	/*
	 * ɾ��һ��ѧ��
	 */
	public void delectStu(int id);
	/*
	 * �޸�һ��ѧ��
	 */
	public void updateStu(Student stu);
}
