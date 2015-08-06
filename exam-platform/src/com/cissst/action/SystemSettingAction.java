package com.cissst.action;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.cissst.entity.TbClassType;
import com.cissst.entity.TbProblemDifficultyLevel;
import com.cissst.entity.TbProblemScore;
import com.cissst.entity.TbProblemType;
import com.cissst.entity.TbStudentType;
import com.cissst.entity.TbUser;
import com.cissst.entity.TbUserType;
import com.cissst.service.SystemSettingService;
import com.cissst.utils.NumberUtil;
import com.cissst.utils.Pager;
import com.cissst.utils.PagerHelper;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @ģ�����ƣ�SystemSettingAction(ϵͳ����)
 * @�����ˣ��¿�ȫ
 * @��          �ܣ�
 * @����ʱ�䣺
 */
public class SystemSettingAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private SystemSettingService SSService;
	public TbProblemType problemType;
	public TbProblemScore problemScore;
	public TbProblemDifficultyLevel problemDifficultyLevel;
	public TbClassType classType;
	public TbStudentType studentType;
	public TbUser user;
	public TbUserType userType;
	public NumberUtil numberUtil;




	public NumberUtil getNumberUtil() {
		return numberUtil;
	}

	public void setNumberUtil(NumberUtil numberUtil) {
		this.numberUtil = numberUtil;
	}

	//��תҳ��ķ���
	public String toNext()
	{
		String temp = ServletActionContext.getRequest().getParameter("temp");
		if(temp.equals("toAddUser"))
		{
			String userNum = numberUtil.getUserNo();
			ServletActionContext.getRequest().setAttribute("uAccount", userNum);
			return "toAddUser";
		}
		else if(temp.endsWith("toAddQlType"))
		{
			String num = numberUtil.getQlTypeNo();
			ServletActionContext.getRequest().setAttribute("ptMyselfId", num);

			return "toAddQlType";
		}
		else if(temp.endsWith("toAddQlRange"))
		{
			String num = numberUtil.getQlScoreNo();
			ServletActionContext.getRequest().setAttribute("num", num);

			return "toAddQlRange";
		}
		else if(temp.endsWith("toAddQlDifficulty"))
		{
			String num = numberUtil.getQlDifNo();
			ServletActionContext.getRequest().setAttribute("num", num);

			return "toAddQlDifficulty";
		}
		else if(temp.endsWith("toAddClassType"))
		{
			String num = numberUtil.getClaTypeNo();
			ServletActionContext.getRequest().setAttribute("num", num);

			return "toAddClassType";
		}
		else if(temp.endsWith("toAddStudentType"))
		{
			String num = numberUtil.getStuTypeNo();
			ServletActionContext.getRequest().setAttribute("num", num);

			return "toAddStudentType";
		}
		else
		{
			return null;
		}


	}

	//�û����ã�ҳ�����û�����ִ�д˷���
	public String systermSetting()
	{
		String strAction = ServletActionContext.getRequest().getParameter("action");
		int action = Integer.valueOf(strAction);

		switch(action)
		{
		case 1:return findUserCondition();
		case 2:return qlTypeSetting();
		case 3:return qlRangeSetting();
		case 4:return qlDifficultySetting();
		case 5:return classTypeSetting();
		case 6:return studentTypeSetting();
		}
		return strAction;
	}


	//�û�����

	public String findWithPage()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String strHQL = (String) ServletActionContext.getRequest().getSession().getAttribute("HQL");
		int totalRows=SSService.getRow(strHQL);
		Pager pager=PagerHelper.getPager(request, totalRows);
		List list = (List<TbUser>) SSService.findWithPage(pager.getStartRow(),pager.getPageSize(),strHQL);

		request.setAttribute("totalPage", pager.getTotalPages());
		request.setAttribute("currentPage",pager.getCurrentPage());
		request.setAttribute("list", list);
		return "userSetting";

	}


	//�û�����
	@SuppressWarnings("unchecked")
	public String findUserCondition()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String uAccount = request.getParameter("uAccount");
		String uName = request.getParameter("uName");
		String userTypeName = request.getParameter("userTypeName");
		String uGender = request.getParameter("uGender");
		String uHiretime = request.getParameter("uHiretime");
		String uHiretime1 = request.getParameter("uHiretime1");
		List<TbUser> list  = null;
		String	strHQL  =  SSService.findUserCheckHQL(uAccount, uName,
				userTypeName, uGender, 
				uHiretime, uHiretime1);

		int totalRows=SSService.getRow(strHQL);
		Pager pager=PagerHelper.getPager(request, totalRows);
		list = (List<TbUser>) SSService.findWithPage(pager.getStartRow(),pager.getPageSize(),strHQL);

		request.setAttribute("totalPage", pager.getTotalPages());
		request.setAttribute("currentPage",pager.getCurrentPage());
		request.setAttribute("list", list);
		return "userSetting";
	}

	//�����û��ķ���
	public String addUser()
	{
		SimpleDateFormat s =  new SimpleDateFormat("yyyy-MM-dd");
		String uName = user.getUName();
		user.setUPwd("000000");
		user.setUDel("0");

		TbUserType userType1 = (TbUserType)SSService.findWith(userType.getUtName());
		user.setUHiretime(s.format(new java.util.Date()));
		user.setTbUserType(userType1);
		SSService.addObject(user);
		return this.findUserCondition();

	}
	public String toUpdateUser()
	{
		String sid = ServletActionContext.getRequest().getParameter("temp");	
		int id = Integer.valueOf(sid);
		user = (TbUser) SSService.findObject("TbUser", "UId", id);
		ServletActionContext.getRequest().setAttribute("userN", user);
		return "toUpdateUser";
	}
	public String updateUser()
	{

		TbUserType userTypeNew = SSService.findWith(userType.getUtName());
		String sid = ServletActionContext.getRequest().getParameter("u_id");	
		int id = Integer.valueOf(sid);
		TbUser	user1 =(TbUser) SSService.findObject("TbUser", "UId", id);
		user1.setUName(user.getUName());
		user1.setUHiretime(user.getUHiretime());
		user1.setUEmail(user.getUEmail());
		user1.setUGender(user.getUGender());
		user1.setTbUserType(userTypeNew);
		SSService.updateObject(user1);
		return this.findUserCondition();

	}
	public String deleteUser()
	{
		String sid = ServletActionContext.getRequest().getParameter("u_id");	
		int id = Integer.valueOf(sid);
		TbUser	user1 =(TbUser) SSService.findObject("TbUser", "UId", id);

		user1.setUDel("1");
		SSService.updateObject(user1);
		return this.findUserCondition();
	}


	//��Ŀ��������
	private String qlTypeSetting() {
		List<TbProblemType> list = (List<TbProblemType>) SSService.findWithPageObject(0, 100, "TbProblemType", "ptDel", null);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "qlTypeSetting";
	}
	//������������Ŀ����
	public String findQlTypeCondition()
	{
		HttpServletRequest res =ServletActionContext.getRequest();
		String examNo = res.getParameter("examNo");
		String examName = res.getParameter("examName");
		List list = SSService.findQlTypeCondition(examNo, examName);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "qlTypeSetting";
	}

	//����һ��TbProblemType����
	public String addQlType()
	{
		boolean b = SSService.findQlType(problemType);
		if(!b)
		{
			problemType.setPtDel("0");
			SSService.addObject(problemType);

			System.out.println(problemType.getPtName());
			return this.qlTypeSetting();
		}else
		{
			//����Ŀ���ʹ��ڵ�ʱ���temp�趨һ��ֵ��ͬʱ��ҳ��������ֵ��Ȼ������Ӧ�����
			String num = numberUtil.getQlTypeNo();
			ServletActionContext.getRequest().setAttribute("ptMyselfId", num);
			ServletActionContext.getRequest().setAttribute("temp", 0);
			return "toAddQlType";
		}

	}
	//��ת����ҳ��
	public String toUpdateQlType()
	{
		String sid = ServletActionContext.getRequest().getParameter("temp");	
		int id = Integer.valueOf(sid);
		TbProblemType ptype = (TbProblemType) SSService.findObject("TbProblemType", "ptId", id);
		ServletActionContext.getRequest().setAttribute("ptype", ptype);
		return "toUpdateQlType";
	}
	//����һ��TbProblemType����
	public String updateQlType()
	{
		String qtid = ServletActionContext.getRequest().getParameter("qt_id");	
		int id = Integer.valueOf(qtid);
		TbProblemType	ptypeOld =(TbProblemType) SSService.findObject("TbProblemType", "ptId", id);


		ptypeOld.setPtMyselfId(problemType.getPtMyselfId());
		ptypeOld.setPtName(problemType.getPtName());
		SSService.updateObject(ptypeOld);
		return this.qlTypeSetting();
	}
	//ɾ��һ��TbProblemType����
	public String deleteQlType()
	{
		String qtid = ServletActionContext.getRequest().getParameter("qt_id");	
		int id = Integer.valueOf(qtid);
		TbProblemType	ptypeOld =(TbProblemType) SSService.findObject("TbProblemType", "ptId", id);

		ptypeOld.setPtDel("1");
		SSService.updateObject(ptypeOld);
		return this.qlTypeSetting();
	}




	//��Ŀ��Χ����
	private String qlRangeSetting() {
		List<TbProblemScore> list = (List<TbProblemScore>) SSService.findWithPageObject(0, 100, "TbProblemScore", "psDel", null);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "qlRangeSetting";
	}
	//������������Ŀ��Χ
	public String findQlRangeCondition()
	{
		HttpServletRequest res =ServletActionContext.getRequest();
		String psNo = res.getParameter("psNo");
		String psName = res.getParameter("psName");
		List list = SSService.findQlRangeCondition(psNo, psName);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "qlRangeSetting";
	}

	//����һ����Ŀ��Χ����
	public String addQlRange()
	{
		boolean b = SSService.findQlRange(problemScore);
		if(!b)
		{
			problemScore.setPsDel("0");
			SSService.addObject(problemScore);
			return this.qlRangeSetting();
		}else
		{
			String num = numberUtil.getQlScoreNo();
			ServletActionContext.getRequest().setAttribute("num", num);
			ServletActionContext.getRequest().setAttribute("temp", 0);
			return "toAddQlRange";
		}
	}
	//��ת������ҳ��
	public String toUpdateQlRange()
	{
		String sid = ServletActionContext.getRequest().getParameter("temp");	
		int id = Integer.valueOf(sid);
		TbProblemScore problemScoref = (TbProblemScore) SSService.findObject("TbProblemScore", "psId", id);
		ServletActionContext.getRequest().setAttribute("problemScoref", problemScoref);
		return "toUpdateQlRange";
	}
	//����һ����Ŀ��Χ����
	public String updateQlRange()
	{
		String qlrid = ServletActionContext.getRequest().getParameter("qlr_id");	
		int id = Integer.valueOf(qlrid);
		TbProblemScore	problemScoreO =(TbProblemScore) SSService.findObject("TbProblemScore", "psId", id);
		problemScoreO.setPsMyselfId(problemScore.getPsMyselfId());
		problemScoreO.setPsName(problemScore.getPsName());
		SSService.updateObject(problemScoreO);
		return this.qlRangeSetting();
	}
	//ɾ��һ����Ŀ��Χ����
	public String deleteQlRange()
	{
		String qlrid = ServletActionContext.getRequest().getParameter("qlr_id");	
		int id = Integer.valueOf(qlrid);
		TbProblemScore	problemScoreO =(TbProblemScore) SSService.findObject("TbProblemScore", "psId", id);
		problemScoreO.setPsDel("1");

		SSService.updateObject(problemScoreO);
		return this.qlRangeSetting();
	}



	//��Ŀ�Ѷ�����
	private String qlDifficultySetting() {
		List<TbProblemDifficultyLevel> list = (List<TbProblemDifficultyLevel>) SSService.findWithPageObject(0, 100, "TbProblemDifficultyLevel", "pdlDel", null);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "qlDifficultySetting";
	}
	//��������ѯ��Ŀ�Ѷ�
	public String findQlDifficultyCondition()
	{
		HttpServletRequest res =ServletActionContext.getRequest();
		String pdNo = res.getParameter("pdNo");
		String pdName = res.getParameter("pdName");
		List list = SSService.findQlDifficultyCondition(pdNo, pdName);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "qlDifficultySetting";
	}
	//������Ŀ�Ѷ�
	public String addQlDifficulty()
	{
		boolean b = SSService.findQlDifficulty(problemDifficultyLevel);
		if(!b)
		{

			problemDifficultyLevel.setPdlDel("0");
			SSService.addObject(problemDifficultyLevel);
			return this.qlDifficultySetting();
		}else
		{
			String num = numberUtil.getQlDifNo();
			ServletActionContext.getRequest().setAttribute("num", num);
			ServletActionContext.getRequest().setAttribute("temp", 0);
			return "toAddQlDifficulty";	
		}
	}
	//��ת����ҳ��
	public String toUpdateQlDifficutly()
	{
		String sid = ServletActionContext.getRequest().getParameter("temp");	
		int id = Integer.valueOf(sid);
		TbProblemDifficultyLevel qlDifficulty = (TbProblemDifficultyLevel) SSService.findObject("TbProblemDifficultyLevel", "pdlId", id);
		ServletActionContext.getRequest().setAttribute("qlDifficulty", qlDifficulty);
		return "toUpdateQlDifficutly";
	}
	//������Ŀ�Ѷ�
	public String updateQlDifficutly()
	{
		String sid = ServletActionContext.getRequest().getParameter("temp");	
		int id = Integer.valueOf(sid);
		TbProblemDifficultyLevel qlDifficulty = (TbProblemDifficultyLevel) SSService.findObject("TbProblemDifficultyLevel", "pdlId", id);
		qlDifficulty.setPdlMyselfId(problemDifficultyLevel.getPdlMyselfId());
		qlDifficulty.setPdlName(problemDifficultyLevel.getPdlName());
		SSService.updateObject(qlDifficulty);
		return this.qlDifficultySetting();
	}
	//ɾ����Ŀ�Ѷ�
	public String deleteQlDifficutly()
	{
		String sid = ServletActionContext.getRequest().getParameter("temp");	
		int id = Integer.valueOf(sid);
		TbProblemDifficultyLevel qlDifficulty = (TbProblemDifficultyLevel) SSService.findObject("TbProblemDifficultyLevel", "pdlId", id);
		qlDifficulty.setPdlDel("1");
		SSService.updateObject(qlDifficulty);
		return this.qlDifficultySetting();
	}



	//�༶��������
	private String classTypeSetting() {
		List<TbClassType> list = (List<TbClassType>) SSService.findWithPageObject(0, 100, "TbClassType", "ctDel", null);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "classTypeSetting";	
	}

	//��������ѯ�༶����
	public String findClassTypeCondition()
	{
		HttpServletRequest res =ServletActionContext.getRequest();
		String ctNo = res.getParameter("ctNo");
		String ctName = res.getParameter("ctName");
		List list = SSService.findClassTypeCondition(ctNo, ctName);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "classTypeSetting";
	}
	//�����༶����
	public String addClassType()
	{
		boolean b = SSService.findClass(classType);
		if(!b)
		{
			classType.setCtDel("0");
			SSService.addObject(classType);
			return this.classTypeSetting();
		}
		else
		{
			String num = numberUtil.getClaTypeNo();
			ServletActionContext.getRequest().setAttribute("num", num);
			ServletActionContext.getRequest().setAttribute("temp", 0);
			return "toAddClassType";	
		}
	}
	//��ת���°༶����
	public String toUpdateClassType()
	{
		String sid = ServletActionContext.getRequest().getParameter("temp");	
		int id = Integer.valueOf(sid);
		TbClassType classType = (TbClassType) SSService.findObject("TbClassType", "ctId", id);
		ServletActionContext.getRequest().setAttribute("classType", classType);
		return "toUpdateClassType";
	}

	//���°༶����
	public String updateClassType()
	{
		String sid = ServletActionContext.getRequest().getParameter("temp");	
		int id = Integer.valueOf(sid);
		TbClassType classType1 = (TbClassType) SSService.findObject("TbClassType", "ctId", id);
		classType1.setCtMyselfId(classType.getCtMyselfId());
		classType1.setCtName(classType.getCtName());
		SSService.updateObject(classType1);
		return this.classTypeSetting();
	}
	//ɾ���༶����
	public String deleteClassType()
	{
		String sid = ServletActionContext.getRequest().getParameter("temp");	
		int id = Integer.valueOf(sid);
		TbClassType classType1 = (TbClassType) SSService.findObject("TbClassType", "ctId", id);
		classType1.setCtDel("1");
		SSService.updateObject(classType1);
		return this.classTypeSetting();
	}



	//ѧ����������
	private String studentTypeSetting() {
		List<TbStudentType> list = (List<TbStudentType>) SSService.findWithPageObject(0, 100, "TbStudentType", "stDel", null);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "studentTypeSetting";
	}

	//��������ѯѧ������
	public String findStudentTypeCondition()
	{
		HttpServletRequest res =ServletActionContext.getRequest();
		String stNo = res.getParameter("stNo");
		String stName = res.getParameter("stName");
		List list = SSService.findStudentTypeCondition(stNo, stName);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "studentTypeSetting";
	}

	//����ѧ������
	public String addStudentType()
	{
		boolean b = SSService.findStuType(studentType);
		if(!b)
		{
			studentType.setStDel("0");
			SSService.addObject(studentType);
			return this.studentTypeSetting();
		}else
		{
			String num = numberUtil.getStuTypeNo();
			ServletActionContext.getRequest().setAttribute("num", num);
			ServletActionContext.getRequest().setAttribute("temp", 0);
			return "toAddStudentType";
		}
	}
	//��ת����ѧ������
	public String toUpdateStudentType()
	{
		String sid = ServletActionContext.getRequest().getParameter("temp");	
		int id = Integer.valueOf(sid);
		TbStudentType studentType = (TbStudentType) SSService.findObject("TbStudentType", "stId", id);
		ServletActionContext.getRequest().setAttribute("studentType", studentType);
		return "toUpdateStudentType";
	}
	//����ѧ������
	public String updateStudentType()
	{
		String sid = ServletActionContext.getRequest().getParameter("temp");	
		int id = Integer.valueOf(sid);
		TbStudentType studentType1 = (TbStudentType) SSService.findObject("TbStudentType", "stId", id);
		studentType1.setStMyselfId(studentType.getStMyselfId());
		studentType1.setStName(studentType.getStName());
		SSService.updateObject(studentType1);
		return this.studentTypeSetting();
	}
	//ɾ��ѧ������
	public String deleteStudentType()
	{
		String sid = ServletActionContext.getRequest().getParameter("temp");	
		int id = Integer.valueOf(sid);
		TbStudentType studentType1 = (TbStudentType) SSService.findObject("TbStudentType", "stId", id);
		studentType1.setStDel("1");
		SSService.updateObject(studentType1);
		return this.studentTypeSetting();
	}


	public SystemSettingService getSSService()
	{
		return SSService;
	}

	public void setSSService(SystemSettingService sSService)
	{
		SSService = sSService;
	}

	public TbUser getUser() {
		return user;
	}
	public void setUser(TbUser user) {
		this.user = user;
	}
	public TbClassType getClassType() {
		return classType;
	}
	public void setClassType(TbClassType classType) {
		this.classType = classType;
	}
	public TbStudentType getStudentType() {
		return studentType;
	}
	public void setStudentType(TbStudentType studentType) {
		this.studentType = studentType;
	}
	public TbProblemDifficultyLevel getProblemDifficultyLevel() {
		return problemDifficultyLevel;
	}
	public void setProblemDifficultyLevel(
			TbProblemDifficultyLevel problemDifficultyLevel) {
		this.problemDifficultyLevel = problemDifficultyLevel;
	}
	public TbProblemScore getProblemScore() {
		return problemScore;
	}
	public void setProblemScore(TbProblemScore problemScore) {
		this.problemScore = problemScore;
	}
	public TbProblemType getProblemType() {
		return problemType;
	}
	public void setProblemType(TbProblemType problemType) {
		this.problemType = problemType;
	}
	public TbUserType getUserType() {
		return userType;
	}

	public void setUserType(TbUserType userType) {
		this.userType = userType;
	}
}
