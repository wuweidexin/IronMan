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
 * @ģ�����ƣ�ClassesManagerAction(�༶����)
 * @�����ˣ�ղ��
 * @��          �ܣ�
 * @����ʱ�䣺
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
	 * ��ת��ҳ�棡
	 * @return
	 */
	public String classAdd(){
		this.goToclassAdd();
		System.out.print("classAdd");
		return "classAdd";
		
		
	}
	
	/**
	 * ��ת������ҳ��
	 * @return
	 */
	
	public String goToclassAdd(){
		//�����ݿ��в��������
		List<TbUser> uName=CMService.finduName();
		//�Ѱ�������Ϣ��ӵ�Request��
		ServletActionContext.getRequest().setAttribute("uName", uName);
		//�����ݿ��в���༶����
		List<TbClassType> clatypeName=CMService.findclatypeName();
		//�Ѱ༶������Ϣ��ӵ�Request��
		ServletActionContext.getRequest().setAttribute("clatypeName", clatypeName);
		
		return "";
		
	}
	
	public String saveClass() {
		//��ð༶���
		String CNum = classNo.getClassNo() ;
		tbClasses.setCNum(CNum);
		
		//��ð༶����
		String CName = ServletActionContext.getRequest().getParameter("CName");
		tbClasses.setCName(CName);
		
		//��ð�����
		int UId = Integer.parseInt(ServletActionContext.getRequest().getParameter("UId"));
		tbUSer = CMService.getUserById(UId);
		tbClasses.setTbUser(tbUSer);
		
		//�༶����
		int ctId = Integer.parseInt(ServletActionContext.getRequest().getParameter("ctId"));
		tbClassType = CMService.getClassTypeById(ctId);
		tbClasses.setTbClassType(tbClassType);
		
		//��Ӱ༶״̬
		TbClazzStatus tbClazzStatus = CMService.findTbClazzStatus("�ѿ�ҵ");
		tbClasses.setTbClazzStatus(tbClazzStatus);
		
		//�༶����
		String col1 = ServletActionContext.getRequest().getParameter("col1");
		tbClasses.setCol1(col1);
		
		//�༶����״̬
		tbClasses.setCDel("0");
		
		//¼������
		tbClasses.setCStartTime(new SimpleDateFormat("yyyy-MM-dd").format( new Date()));
		tbClasses.setCEndTime("");
		
		CMService.save(tbClasses);
		return this.classAdd();
	}
	/**
	 * �༶��ѯ
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
	 * classQuery2�༶ά��ҳ��
	 */
	public String classQuery2() {
		int classId = Integer.parseInt(ServletActionContext.getRequest().getParameter("classId"));
		TbClasses tbClasses = CMService.findTbClasses(classId);
		ServletActionContext.getRequest().setAttribute("tbClasses",tbClasses);
		
		//�����ݿ��в��������
		List<TbUser> teaList=CMService.finduName();
		//�Ѱ�������Ϣ��ӵ�Request��
		ServletActionContext.getRequest().setAttribute("teaList", teaList);
		//�����ݿ��в���༶����
		List<TbClassType> claTypeList=CMService.findclatypeName();
		//�Ѱ༶������Ϣ��ӵ�Request��
		ServletActionContext.getRequest().setAttribute("claTypeList", claTypeList);
		
		//��ѯ�༶����״̬
		List<?> claStatus =  CMService.findTbClazzStatus();
		ServletActionContext.getRequest().setAttribute("claStatus", claStatus);
		return "classQuery2";
	}
	
	/**
	 * ���°༶����Ϣ
	 */
	public String updateClaInfo() {
		
		//���ά���༶��id
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("clazzId"));
		TbClasses tbClasses = CMService.findTbClasses(id);
		
		//�޸İ༶���� 
		String claName = ServletActionContext.getRequest().getParameter("claName");
		tbClasses.setCName(claName);
		
		//��������
		int teaId = Integer.parseInt(ServletActionContext.getRequest().getParameter("UId"));
		TbUser tbUser = CMService.getUserById(teaId);
		tbClasses.setTbUser(tbUser);
		
		//�޸İ༶״̬(�Ƿ��ҵ)
		String statusId = ServletActionContext.getRequest().getParameter("statusId");
		TbClazzStatus classStatus =  CMService.findTbClazzStatus(statusId);
		tbClasses.setTbClazzStatus(classStatus);
		
		//�޸İ༶����
		int ctId = Integer.parseInt(ServletActionContext.getRequest().getParameter("ctId"));
		TbClassType tbClassType = CMService.getClassTypeById(ctId);
		tbClasses.setTbClassType(tbClassType);
		
		//�༶����
		String classDescribe = ServletActionContext.getRequest().getParameter("classDescribe");
		tbClasses.setCol1(classDescribe);
		CMService.updateClasses(tbClasses);
		return this.findClasses();
	}
	
	/**
	 * �İ༶�ѽ�ҵ�������������Ϣ
	 * @return
	 */
	public String endEducation() {
		//��ý�ҵ�༶id
		int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("clazzId"));
		TbClasses tbClasses = CMService.findTbClasses(id);
		//��ӽ�ҵʱ�䵽�༶����
		tbClasses.setCEndTime(new SimpleDateFormat("yyyy-MM-dd").format( new Date()));
		
		//���İ༶״̬Ϊ�ѽ�ҵ
		TbClazzStatus classStatus = CMService.findTbClazzStatus("�ѽ�ҵ");
		tbClasses.setTbClazzStatus(classStatus);
		
		CMService.updateClasses(tbClasses);
		
		return this.findClasses();
	}
	
    /**
     * ɾ��ĳ���༶
     */
	public String deleteClazz(){
		//Ҫɾ���İ༶��id
		int clazzId = Integer.parseInt(ServletActionContext.getRequest().getParameter("clazzId"));
		TbClasses clazz = CMService.findTbClasses(clazzId);
		clazz.setCDel("1");
		CMService.updateClasses(clazz);
		return this.findClasses();
		
	}

	/**
	 * ����classQueryҳ��
	 */
	public String returnClassQuery() {
		return this.findClasses();
	}
	
	/**
	 * ѧ����ѯ��һ�����༶��ѯ
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
	 * �༶��Ϣ
	 */
	public String classQuery3() {
		int claId = Integer.parseInt(ServletActionContext.getRequest().getParameter("clazzId"));
		TbClasses tbClasses = CMService.findTbClasses(claId);
		ServletActionContext.getRequest().setAttribute("tbClasses", tbClasses);
		return "classQuery3";
		
	}
	
	/**
	 * ѧ�����ӵڶ�����ѧ������
	 * @return
	 */
	public String studentAdd1() {
		//��Ҫ���ѧ���İ༶��Ϣ
		int claId = Integer.parseInt(ServletActionContext.getRequest().getParameter("clazzId"));
		TbClasses tbClasses = CMService.findTbClasses(claId);
		ServletActionContext.getRequest().setAttribute("tbClasses", tbClasses);
		
		//����ѧ������
		List<?> stuTypeList = CMService.findStudentType();
		ServletActionContext.getRequest().setAttribute("stuTypeList", stuTypeList);
	
		return "studentAdd1";
	}
	
	/**
	 * ���ѧ��
	 * @return
	 */
	public String AddStudent() {
		
		int claId = Integer.parseInt(ServletActionContext.getRequest().getParameter("classId"));
		TbClasses clazz = CMService.findTbClasses(claId);
		
		//ѧ�������û������id
		int id = clazz.getCId();
		int stuCountNum_1 = CMService.getStudentCount(id);
		String stuCountNum = Integer.toString(stuCountNum_1);
		clazz.setCol2(stuCountNum);
		
		//���ѧ�����
		String stuNo = ServletActionContext.getRequest().getParameter("stuNo");
		tbStudent.setCol1(stuNo);
		
		//���ѧ������
		String stuName = ServletActionContext.getRequest().getParameter("stuName");
		tbStudent.setCol2(stuName);
		
		//���ѧ������
		int stuTypeId = Integer.parseInt(ServletActionContext.getRequest().getParameter("stuTypeId"));
		TbStudentType tbStudentType = CMService.findStudentType(stuTypeId);
		tbStudent.setTbStudentType(tbStudentType);
		
		//���ѧ���Ա�
		String sex = ServletActionContext.getRequest().getParameter("sex");
		tbStudent.setCol3(sex);
		
		//��Ӱ༶
		tbStudent.setTbClasses(clazz);
		
		//���ѧ��״̬
		TbStudentStatus studentStatus = CMService.findStudentStatues("����ѧ");
		tbStudent.setTbStudentStatus(studentStatus);
		
		//����ѧ������״̬
		tbStudent.setStuDel("0");
		
		CMService.saveStudent(tbStudent);
		
		//��Ҫ���ѧ���İ༶��Ϣ
		//int claId = Integer.parseInt(ServletActionContext.getRequest().getParameter("clazzId"));
		TbClasses tbClasses = CMService.findTbClasses(claId);
		ServletActionContext.getRequest().setAttribute("tbClasses", tbClasses);
		
		//����ѧ������
		List<?> stuTypeList = CMService.findStudentType();
		ServletActionContext.getRequest().setAttribute("stuTypeList", stuTypeList);
	
		
		return "studentAdd1";
	}
	
	/**
	 * ѧ����ѯ
	 * @return
	 */
	public String studentQuery() {
		//ѧ��״̬
		List<?> stuStatusList = CMService.findStudentStatus();
		ServletActionContext.getRequest().setAttribute("stuStatusList", stuStatusList);
		
		//ѧ������
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
	 * ѧ��ά��
	 * @return
	 */
	public String studentQuery2() {
		//����ѧ����Ų�ѯѧ��
		int stuNo = Integer.parseInt(ServletActionContext.getRequest().getParameter("stuNo"));
		TbStudent student = CMService.getTbStudent(stuNo);
		ServletActionContext.getRequest().setAttribute("student", student);
		
		//ѧ��������״̬
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
			TbStudentStatus status = CMService.findStudentStatues("����ѧ");
			student.setTbStudentStatus(status);
			CMService.updateStudent(student);
		}else {
			int end_id = Integer.parseInt(student_end);
			TbStudent student = CMService.getTbStudent(end_id);
			TbStudentStatus status = CMService.findStudentStatues("�ѽ�ҵ");
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
