package com.chen.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.chen.HibernateUtil.NumberUtil;
import com.chen.entity.Classes;
import com.chen.entity.Course;
import com.chen.entity.Selectcourse;
import com.chen.entity.Stucla;
import com.chen.entity.Student;
import com.chen.entity.Studylocation;
import com.chen.entity.Teacher;
import com.chen.service.CourseService;
import com.chen.serviceImp.CourseServiceImp;

public class CourseAction {
	CourseService cou = new CourseServiceImp();
	HttpServletRequest req = ServletActionContext.getRequest();
	NumberUtil nu = new NumberUtil();
	/*
	 *课程查询 
	 */
	public String queryCourse()
	{
		List<Teacher> tea = cou.queryTeachet();
		req.setAttribute("tea", tea);
		return "queryCourse";
		
	}
	/*
	 * 该函数是后台查询课程信息以便编辑课程信息的函数
	 */
	public String queryCourse1()
	{
		List<Teacher> tea = cou.queryTeachet();
		req.setAttribute("tea", tea);
		return "queryCourse1";
	}
	/*
	 * 选课
	 */
	
	public String chooseCourse()
	{
		//String[] checkCourse = req.getParameterValues("xuanze");
		String checkCourse = req.getParameter("choose");
		String[] tId = checkCourse.split(",");
		
		Selectcourse sc = null;
		Course c = null;
		Teacher t = null;
		Student s = null;
		Stucla stucla = null;
		int flag = 0;
		s = (Student) req.getSession().getAttribute("user");
		for(int i = 0; i < tId.length; i ++)
		{
			t = cou.queryTeacher(Integer.valueOf(tId[i]));
			c = t.getCourse();
			flag = cou.checkSelectcourse(s.getSId(), c.getCId());
			//说明自己已经选了这门课程
			if(flag == 1)
			{
				return "exit";
			}else
			{
				//下面是没有选这门课的处理
				sc = new Selectcourse();
				stucla = new Stucla();
				stucla.setClasses(t.getClasses());
				stucla.setStudent(s);
				stucla.setColumn4("1");
				sc.setStudent(s);
				sc.setCourse(c);
				sc.setTeacher(t);
				sc.setColumn2("1");
				cou.saveSelectcourse(sc);
				cou.saveStucla(stucla);
			}
		}
		return hasQueryCourse();
	}
	/*
	 * 查询已选课程
	 */
	public String hasQueryCourse()
	{
		Student s = (Student) req.getSession().getAttribute("user");
		List<Teacher> listTo = new ArrayList<Teacher>();
		List<Selectcourse> listSeCourse = cou.queryListSelectCourse(s);
		req.setAttribute("listSeCourse", listSeCourse);
		
		return "yixuankecheng";
	}
	/*
	 * 删除已经选择的课程
	 */
	public String delectSeCourse()
	{
		int id = Integer.valueOf(req.getParameter("id"));
		cou.delectSelectCourse(id);
		return hasQueryCourse();
	}
	/*
	 * 删除课程,通过删除与其一一对应的Teacher来处理
	 */
	public String delectCourse()
	{
		int id = Integer.valueOf(req.getParameter("id"));
		Teacher t = cou.queryTeacher(id);
		t.getCourse().setColumn5("0");
		t.setColumn5("0");
		cou.updateTeacher(t);
		return queryCourse1();
	}
	public String goUpdateCourse()
	{
		int id = Integer.valueOf(req.getParameter("id"));
		Teacher t = cou.queryTeacher(id);			
		List<Studylocation> sl = cou.queryListStuLo();
		req.setAttribute("sl", sl);
		req.setAttribute("teacher", t);
		return "goUpdateCourse";
	}
	/*
	 * 修改课程
	 */
	public String updateCourse()
	{
		Studylocation sl =null;
		int sid = Integer.valueOf(req.getParameter("loId"));
		sl = cou.queryStudylocation(sid);
		
		int id = Integer.valueOf(req.getParameter("tId"));
		Teacher t = cou.queryTeacher(id);
		Course c = t.getCourse();
		Classes cl = t.getClasses();
		
		t.setTNumber(req.getParameter("tNumber"));
		t.setTName(req.getParameter("tName"));
		t.setTSex(req.getParameter("tSex"));
				
		c.setCNumber(req.getParameter("cNumber"));
		c.setCName(req.getParameter("cName"));
		c.setCTime(req.getParameter("cTime"));
		
		cl.setClNumber(req.getParameter("clNumber"));
		cl.setClName(req.getParameter("clName"));
		cl.setStudylocation(sl);
		
		cou.updateTeacher(t);
		return queryCourse1();
	}
	public String toAddCourse(){
		String tNo = nu.getTeaNo();
		String clNo = nu.getClaNo();
		String cNo = nu.getCourseNo();
		List<Studylocation> sl =  cou.queryListStuLo();
		req.setAttribute("listSL", sl);
		req.setAttribute("tNo", tNo);
		req.setAttribute("clNo", clNo);
		req.setAttribute("cNo", cNo);
		return "toAddCourse";
	}
	
	/*
	 * 新增课程
	 */
	public String addCourse(){
		
		Studylocation sl =null;
		int id = Integer.valueOf(req.getParameter("loId"));
		sl = cou.queryStudylocation(id);
		Classes cl = new Classes();
		cl.setClNumber(req.getParameter("clNumber"));
		cl.setClName(req.getParameter("clName"));
		cl.setColumn5("1");
		cl.setStudylocation(sl);
		cou.saveClass(cl);
		
		Course c = new Course();
		c.setCNumber(req.getParameter("cNumber"));
		c.setCTime(req.getParameter("cTime"));
		c.setCName(req.getParameter("cName"));
		c.setColumn5("1");
		cou.saveCourse(c);
		
		Teacher t = new Teacher();
		t.setTNumber(req.getParameter("tNumber"));
		t.setTName(req.getParameter("tName"));
		t.setTSex(req.getParameter("tSex"));
		t.setColumn5("1");
		t.setClasses(cl);
		t.setCourse(c);
		
		cou.saveTeacher(t);
		return queryCourse1();
	}
}
