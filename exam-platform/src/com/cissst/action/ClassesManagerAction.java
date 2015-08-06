package com.cissst.action;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.cissst.entity.TbClassType;
import com.cissst.entity.TbClasses;
import com.cissst.entity.TbClazzStatus;
import com.cissst.entity.TbStudent;
import com.cissst.entity.TbStudentStatus;
import com.cissst.entity.TbStudentType;
import com.cissst.entity.TbUser;
import com.cissst.service.ClassesManagerService;
import com.cissst.utils.NumberUtil;
import com.cissst.utils.Pager;
import com.cissst.utils.PagerHelper;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @模块名称：ClassesManagerAction(班级管理)
 * @开发人：詹聪
 * @功          能：
 * @开发时间：
 */
public class ClassesManagerAction extends ActionSupport
{
	
	private static final long serialVersionUID = 1L;
	
	private ClassesManagerService CMService;
	private TbUser tbUSer;
	private TbClassType tbClassType;
	private TbClasses tbClasses;
	private TbClazzStatus tbClazzStatus;
	private TbStudent tbStudent;
	private TbStudentType tbStudentType;
	private NumberUtil classNo;

	

	public NumberUtil getClassNo() {
		return classNo;
	}

	public void setClassNo(NumberUtil classNo) {
		this.classNo = classNo;
	}

	private TbStudentStatus tbStudentStatus;
	
	
	/**
	 * 跳转到页面！
	 * @return
	 */
	public String classAdd(){
		this.goToclassAdd();
		System.out.print("classAdd");
		return "classAdd";
		
		
	}
	
	/**
	 * 跳转到增加页面
	 * @return
	 */
	
	public String goToclassAdd(){
		//在数据库中查出班主任
		List<TbUser> uName=CMService.finduName();
		//把班主任信息添加到Request中
		ServletActionContext.getRequest().setAttribute("uName", uName);
		//在数据库中查出班级类型
		List<TbClassType> clatypeName=CMService.findclatypeName();
		//把班级类型信息添加到Request中
		ServletActionContext.getRequest().setAttribute("clatypeName", clatypeName);
		
		return "";
		
	}
	
	public String saveClass() {
		//获得班级编号
		String CNum = classNo.getClassNo() ;
		tbClasses.setCNum(CNum);
		
		//获得班级名称
		String CName = ServletActionContext.getRequest().getParameter("CName");
		tbClasses.setCName(CName);
		
		//获得班主任
		int UId = Integer.parseInt(ServletActionContext.getRequest().getParameter("UId"));
		tbUSer = CMService.getUserById(UId);
		tbClasses.setTbUser(tbUSer);
		
		//班级类型
		int ctId = Integer.parseInt(ServletActionContext.getRequest().getParameter("ctId"));
		tbClassType = CMService.getClassTypeById(ctId);
		tbClasses.setTbClassType(tbClassType);
		
		//添加班级状态
		TbClazzStatus tbClazzStatus = CMService.findTbClazzStatus("已开业");
		tbClasses.setTbClazzStatus(tbClazzStatus);
		
		//班级描述
		String col1 = ServletActionContext.getRequest().getParameter("col1");
		tbClasses.setCol1(col1);
		
		//班级存在状态
		tbClasses.setCDel("0");
		
		//录入日期
		tbClasses.setCStartTime(new SimpleDateFormat("yyyy-MM-dd").format( new Date()));
		tbClasses.setCEndTime("");
		
		CMService.save(tbClasses);
		return this.classAdd();
	}
	/**
	 * 班级查询
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	public String findClasses () {
		HttpServletRequest request = ServletActionContext.getRequest();
		String isNew = request.getParameter("isNew");
		String HQL = null;
		if(isNew !=null) {
			HQL = CMService.checkHQL(request);
		} else {
			HQL = (String) request.getSession().getAttribute("HQL");
		}
		int totalRows = CMService.getRows(HQL);
		Pager pager = PagerHelper.getPager(request, totalRows);
		List classList = CMService.findClasses(pager, HQL);
		request.setAttribute("classList",classList);
		
		
		List list1=CMService.findUser();
		List list2=CMService.findclatypeName();
		List list3=CMService.findTbClazzStatus();
		
		request.setAttribute("list1",list1);
		request.setAttribute("list2",list2);
		request.setAttribute("list3",list3);
		
		request.setAttribute("totalPages",pager.getTotalPages());
		request.setAttribute("currentPage",pager.getCurrentPage());
		return "classQuery";
		
	}
	
	/**
	 * classQuery2班级维护页面
	 */
	public String classQuery2() {
		int classId = Integer.parseInt(ServletActionContext.getRequest().getParameter("classId"));
		TbClasses tbClasses = CMService.findTbClasses(classId);
		ServletActionContext.getRequest().setAttribute("tbClasses",tbClasses);
		
		//在数据库中查出班主任
		List<TbUser> teaList=CMService.finduName();
		//把班主任信息添加到Request中
		ServletActionContext.getRequest().setAttribute("teaList", teaList);
		//在数据库中查出班级类型
		List<TbClassType> claTypeList=CMService.findclatypeName();
		//把班级类型信息添加到Request中
		ServletActionContext.getRequest().setAttribute("claTypeList", claTypeList);
		
		//查询班级所有状态
		List<?> claStatus =  CMService.findTbClazzStatus();
		ServletActionContext.getRequest().setAttribute("claStatus", claStatus);
		return "classQuery2";
	}
	
	/**
	 * 更新班级的信息
	 */
	public String updateClaInfo() {
		
		//获得维护班级的id
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("clazzId"));
		TbClasses tbClasses = CMService.findTbClasses(id);
		
		//修改班级名称 
		String claName = ServletActionContext.getRequest().getParameter("claName");
		tbClasses.setCName(claName);
		
		//换班主任
		int teaId = Integer.parseInt(ServletActionContext.getRequest().getParameter("UId"));
		TbUser tbUser = CMService.getUserById(teaId);
		tbClasses.setTbUser(tbUser);
		
		//修改班级状态(是否结业)
		String statusId = ServletActionContext.getRequest().getParameter("statusId");
		TbClazzStatus classStatus =  CMService.findTbClazzStatus(statusId);
		tbClasses.setTbClazzStatus(classStatus);
		
		//修改班级类型
		int ctId = Integer.parseInt(ServletActionContext.getRequest().getParameter("ctId"));
		TbClassType tbClassType = CMService.getClassTypeById(ctId);
		tbClasses.setTbClassType(tbClassType);
		
		//班级描述
		String classDescribe = ServletActionContext.getRequest().getParameter("classDescribe");
		tbClasses.setCol1(classDescribe);
		CMService.updateClasses(tbClasses);
		return this.findClasses();
	}
	
	/**
	 * 改班级已结业，更改其相关信息
	 * @return
	 */
	public String endEducation() {
		//获得结业班级id
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("clazzId"));
		TbClasses tbClasses = CMService.findTbClasses(id);
		//添加结业时间到班级表中
		tbClasses.setCEndTime(new SimpleDateFormat("yyyy-MM-dd").format( new Date()));
		
		//更改班级状态为已结业
		TbClazzStatus classStatus = CMService.findTbClazzStatus("已结业");
		tbClasses.setTbClazzStatus(classStatus);
		
		CMService.updateClasses(tbClasses);
		
		return this.findClasses();
	}
	
    /**
     * 删除某个班级
     */
	public String deleteClazz(){
		//要删除的班级的id
		int clazzId = Integer.parseInt(ServletActionContext.getRequest().getParameter("clazzId"));
		TbClasses clazz = CMService.findTbClasses(clazzId);
		clazz.setCDel("1");
		CMService.updateClasses(clazz);
		return this.findClasses();
		
	}

	/**
	 * 返回classQuery页面
	 */
	public String returnClassQuery() {
		return this.findClasses();
	}
	
	/**
	 * 学生查询第一步，班级查询
	 * @return
	 */
	
	public String studentAdd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String isNew = request.getParameter("isNew");
		String HQL = null;
		if(isNew !=null) {
			HQL = CMService.checkHQL(request);
		} else {
			HQL = (String) request.getSession().getAttribute("HQL");
		}
		int totalRows = CMService.getRows(HQL);
		Pager pager = PagerHelper.getPager(request, totalRows);
		List classList = CMService.findClasses(pager, HQL);
		request.setAttribute("classList",classList);
		List list3=CMService.findTbClazzStatus();
		
		
		request.setAttribute("list3",list3);
		
		request.setAttribute("totalPages",pager.getTotalPages());
		request.setAttribute("currentPage",pager.getCurrentPage());
		return "studentAdd";
		
	}
	
	/**
	 * 班级信息
	 */
	public String classQuery3() {
		int claId = Integer.parseInt(ServletActionContext.getRequest().getParameter("clazzId"));
		TbClasses tbClasses = CMService.findTbClasses(claId);
		ServletActionContext.getRequest().setAttribute("tbClasses", tbClasses);
		return "classQuery3";
		
	}
	
	/**
	 * 学生增加第二部，学生增加
	 * @return
	 */
	public String studentAdd1() {
		//将要添加学生的班级信息
		int claId = Integer.parseInt(ServletActionContext.getRequest().getParameter("clazzId"));
		TbClasses tbClasses = CMService.findTbClasses(claId);
		ServletActionContext.getRequest().setAttribute("tbClasses", tbClasses);
		
		//所有学生类型
		List<?> stuTypeList = CMService.findStudentType();
		ServletActionContext.getRequest().setAttribute("stuTypeList", stuTypeList);
	
		return "studentAdd1";
	}
	
	/**
	 * 添加学生
	 * @return
	 */
	public String AddStudent() {
		
		int claId = Integer.parseInt(ServletActionContext.getRequest().getParameter("classId"));
		TbClasses clazz = CMService.findTbClasses(claId);
		
		//学生引用用户表外键id
		int id = clazz.getCId();
		int stuCountNum_1 = CMService.getStudentCount(id);
		String stuCountNum = Integer.toString(stuCountNum_1);
		clazz.setCol2(stuCountNum);
		
		//获得学生编号
		String stuNo = ServletActionContext.getRequest().getParameter("stuNo");
		tbStudent.setCol1(stuNo);
		
		//或得学生姓名
		String stuName = ServletActionContext.getRequest().getParameter("stuName");
		tbStudent.setCol2(stuName);
		
		//获得学生类型
		int stuTypeId = Integer.parseInt(ServletActionContext.getRequest().getParameter("stuTypeId"));
		TbStudentType tbStudentType = CMService.findStudentType(stuTypeId);
		tbStudent.setTbStudentType(tbStudentType);
		
		//获得学生性别
		String sex = ServletActionContext.getRequest().getParameter("sex");
		tbStudent.setCol3(sex);
		
		//添加班级
		tbStudent.setTbClasses(clazz);
		
		//添加学生状态
		TbStudentStatus studentStatus = CMService.findStudentStatues("已入学");
		tbStudent.setTbStudentStatus(studentStatus);
		
		//设置学生存在状态
		tbStudent.setStuDel("0");
		
		CMService.saveStudent(tbStudent);
		
		//将要添加学生的班级信息
		//int claId = Integer.parseInt(ServletActionContext.getRequest().getParameter("clazzId"));
		TbClasses tbClasses = CMService.findTbClasses(claId);
		ServletActionContext.getRequest().setAttribute("tbClasses", tbClasses);
		
		//所有学生类型
		List<?> stuTypeList = CMService.findStudentType();
		ServletActionContext.getRequest().setAttribute("stuTypeList", stuTypeList);
	
		
		return "studentAdd1";
	}
	
	/**
	 * 学生查询
	 * @return
	 */
	public String studentQuery() {
		//学生状态
		List<?> stuStatusList = CMService.findStudentStatus();
		ServletActionContext.getRequest().setAttribute("stuStatusList", stuStatusList);
		
		//学生类型
		List<?> stuStyList = CMService.findStudentType();
		ServletActionContext.getRequest().setAttribute("stuStyList", stuStyList);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String isNew = request.getParameter("isNew");
		
		String HQL = null;
		if(isNew !=null) {
			HQL = CMService.studentQueryHQL(request);
		} else {
			HQL = (String) request.getSession().getAttribute("HQL");
		}
		int totalRows = CMService.getRows(HQL);
		Pager pager = PagerHelper.getPager(request, totalRows);
		List stuList = CMService.findClasses(pager, HQL);
		request.setAttribute("stuList",stuList);
		request.setAttribute("totalPages",pager.getTotalPages());
		request.setAttribute("currentPage",pager.getCurrentPage());
		
		return "studentQuery";
	}
	
	/**
	 * 学生维护
	 * @return
	 */
	public String studentQuery2() {
		//根据学生编号查询学生
		int stuNo = Integer.parseInt(ServletActionContext.getRequest().getParameter("stuNo"));
		TbStudent student = CMService.getTbStudent(stuNo);
		ServletActionContext.getRequest().setAttribute("student", student);
		
		//学生的所有状态
		List<?> stuStaList = CMService.findStudentStatus();
		ServletActionContext.getRequest().setAttribute("stuStaList", stuStaList);
		
		return "studentQuery2";
		
	}
	
	/**
	 * tuixuehuojieye
	 * @return
	 */
	public String backAndEnd() {
		String student_back = ServletActionContext.getRequest().getParameter("student_back");
		String student_end = ServletActionContext.getRequest().getParameter("student_end");
		if(student_back != "" && student_back != null) {
			int back_id = Integer.parseInt(student_back);
			TbStudent student = CMService.getTbStudent(back_id);
			TbStudentStatus status = CMService.findStudentStatues("已退学");
			student.setTbStudentStatus(status);
			CMService.updateStudent(student);
		}else {
			int end_id = Integer.parseInt(student_end);
			TbStudent student = CMService.getTbStudent(end_id);
			TbStudentStatus status = CMService.findStudentStatues("已结业");
			student.setTbStudentStatus(status);
			CMService.updateStudent(student);
		}
	
		
		return "studentQuery2()";
	}
	
	
	
	public ClassesManagerService getCMService()
	{
		return CMService;
	}

	public void setCMService(ClassesManagerService cMService)
	{
		CMService = cMService;
	}
	
	public TbUser getTbUSer() {
		return tbUSer;
	}

	public void setTbUSer(TbUser tbUSer) {
		this.tbUSer = tbUSer;
	}

	public TbClassType getTbClassType() {
		return tbClassType;
	}

	public void setTbClassType(TbClassType tbClassType) {
		this.tbClassType = tbClassType;
	}

	public TbClasses getTbClasses() {
		return tbClasses;
	}

	public void setTbClasses(TbClasses tbClasses) {
		this.tbClasses = tbClasses;
	}

	public TbClazzStatus getTbClazzStatus() {
		return tbClazzStatus;
	}

	public void setTbClazzStatus(TbClazzStatus tbClazzStatus) {
		this.tbClazzStatus = tbClazzStatus;
	}
	public TbStudent getTbStudent() {
		return tbStudent;
	}

	public void setTbStudent(TbStudent tbStudent) {
		this.tbStudent = tbStudent;
	}
	public TbStudentType getTbStudentType() {
		return tbStudentType;
	}

	public void setTbStudentType(TbStudentType tbStudentType) {
		this.tbStudentType = tbStudentType;
	}

	public TbStudentStatus getTbStudentStatus() {
		return tbStudentStatus;
	}

	public void setTbStudentStatus(TbStudentStatus tbStudentStatus) {
		this.tbStudentStatus = tbStudentStatus;
	}
	

	


}
