package com.chen.serviceImp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.chen.dao.BaseDao;
import com.chen.daoImp.BaseDaoImp;
import com.chen.entity.Student;
import com.chen.service.StuService;

public class StuServiceImp implements StuService{
	BaseDao baseDao = new BaseDaoImp();
	/*
	 * 验证登陆信息
	 * @see com.chen.service.StuService#checkLogin()
	 */
	HttpServletRequest re = ServletActionContext.getRequest();
	/*
	 * 验证登陆的用户名和密码
	 * @see com.chen.service.StuService#checkLogin(java.lang.String, java.lang.String)
	 */
	public String checkLogin(String username, String password) {
		String HQL = "from Student where column10 = '1' and SNumber = '"+username+"'";
		Student stu = (Student) baseDao.findObject(HQL);
		if(stu != null)
		{
			//密码错误
			if( !stu.getSPwd().endsWith(password))
			{
				return "pwdError";
			}else
			{
				//密码正确
				re.getSession().setAttribute("user", stu);
				return "sPwdCorrect";
			}
			
		}else
		{
			//查询结果为空，代表用户不存在
			return "inexistence";
		}
		
	}
	public Student findStu(String HQL) {
		Student stu = (Student)baseDao.findObject(HQL);
		return stu;
	}
	/*
	 * 查询所有的学生
	 */
	public List<Student> findListStu(){
		String HQL = "from Student where column10 = '1'";
		return baseDao.findList(HQL);
		
	}
	public void delectStu(int id) {
		String HQL = "from Student where column10 = '1' and SId="+id;
		Student ss = (Student)baseDao.findObject(HQL);
		ss.setColumn10("0");
		baseDao.updateObject(ss);
	}
	public void saveStu(Student stu) {
		baseDao.saveObject(stu);
	}
	public void updateStu(Student stu) {
		baseDao.updateObject(stu);
	}

}
