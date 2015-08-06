package com.cissst.action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.cissst.entity.TbClasses;
import com.cissst.entity.TbExamPlan;
import com.cissst.entity.TbExamScheme;
import com.cissst.entity.TbExamSchemeDetail;
import com.cissst.entity.TbProblem;
import com.cissst.entity.TbTactics;
import com.cissst.entity.TbTacticsDetail;
import com.cissst.service.ExamPlanService;
import com.cissst.utils.NumberUtil;
import com.cissst.utils.Pager;
import com.cissst.utils.PagerHelper;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @ģ�����ƣ�ExamPlanAction(���Լƻ�)
 * @�����ˣ�ʷС��
 * @��          �ܣ�
 * @����ʱ�䣺
 */
public class ExamPlanAction extends  ActionSupport
{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final String HQL = null;
	private ExamPlanService EPService;
	private NumberUtil numberUtil;
	

	public ExamPlanService getEPService()
	{
		return EPService;
	}

	public void setEPService(ExamPlanService ePService)
	{
		EPService = ePService;
	}

	/**
	 * ���Լƻ�����
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String examProjectAdd(){
		//�༶���������б�
		List classesname=EPService.selectClassName();
		ServletActionContext.getRequest().setAttribute("classesname", classesname);
		//���Է������������б�
		List examschemename= EPService.selectExamSchemeName();
		ServletActionContext.getRequest().setAttribute("examschemename", examschemename);
		return "examprojectadd";
	}
	/**
	 * ���Լƻ����������������水ť
	 */
	public String examPlanAddSave(){
		TbExamPlan plan=new TbExamPlan();
		@SuppressWarnings("unused")
		TbClasses classes=new TbClasses();
		@SuppressWarnings("unused")
		TbExamScheme scheme=new TbExamScheme();
		//
		
		//
		String planName=ServletActionContext.getRequest().getParameter("planName");
		plan.setPlanName(planName);
		//
		String txtAddress=ServletActionContext.getRequest().getParameter("txtAddress");
		plan.setPlanDescribe(txtAddress);
		//
		int CId=Integer.valueOf(ServletActionContext.getRequest().getParameter("classesName"));
		TbClasses cla = EPService.findclaID(CId);
		
		plan.setTbClasses(cla);
		
		String planId = numberUtil.getExamPlanNo(cla.getCNum());
		plan.setEpMyselfId(planId);
		//
		String examTimeStart=ServletActionContext.getRequest().getParameter("examTimeStart");
		plan.setPlanStartTime(examTimeStart);
		//
		String examTimeEnd=ServletActionContext.getRequest().getParameter("examTimeEnd");
		plan.setPlanEndTime(examTimeEnd);
		//
		int esId=Integer.valueOf(ServletActionContext.getRequest().getParameter("examSchemeName"));
		plan.setTbExamScheme(EPService.findschID(esId));
		//
		String readOverTime=ServletActionContext.getRequest().getParameter("readOverTime");
		plan.setPlanReadOverTime(readOverTime);
		//
		String readerName=ServletActionContext.getRequest().getParameter("readerName");
		plan.setCol3(readerName);
		
		//���üƻ�״̬
		plan.setTbPlanStatus(EPService.getStatus("δ����"));
		
		//
		plan.setPlanDel("0");
		EPService.examPlanAddSaveButton(plan);
        ServletActionContext.getRequest().setAttribute("plan",plan);
		return "examprojectadd";
	}
	/**
	 * ���Լƻ�������������ɾ����ť
	 */
	public String examProjectAdddelete(){
		int planId=Integer.valueOf(ServletActionContext.getRequest().getParameter("planId"));
		TbExamPlan plan=EPService.loginExamPlan(planId);
		plan.setPlanDel("1");
		return examProjectAdd();
	}
	/**
	 * �Ծ�Ԥ��
	 */
	@SuppressWarnings("unchecked")
	public String examPage(){
		List<TbTacticsDetail> list = new ArrayList<TbTacticsDetail>();
		int examSchemeName = Integer.valueOf(ServletActionContext.getRequest().getParameter("examSchemeName"));
		TbExamScheme examScheme = EPService.getTbExamScheme(examSchemeName);
		Set<TbExamSchemeDetail> esdSet = examScheme.getTbExamSchemeDetails();
		for (TbExamSchemeDetail esd : esdSet) {
			TbTactics tactics = esd.getTbTactics();
			Set<TbTacticsDetail> tdSet = tactics.getTbTacticsDetails();
			Iterator<TbTacticsDetail> tdIter= tdSet.iterator();
			while(tdIter.hasNext())
			{
				TbTacticsDetail detail =tdIter.next();
				list.add(detail);
			}
		}
		ServletActionContext.getRequest().setAttribute("list", list);
		ServletActionContext.getRequest().setAttribute("problemNum", list.size());
		ServletActionContext.getRequest().setAttribute("esId", examSchemeName);
		return "exam";	
	}
	/**
	 * ����𰸲�ѯ
	 * @return
	 */
	public String exam(){
		List<?> list=EPService.findTbProblemResult();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "examPage";	
	}
	//-------------------------------------------------------------------------------------------------------------//
	/**
	 * ���Լƻ���ѯ
	 */
	@SuppressWarnings("unchecked")
	public String examProjectQuery(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String newHQL = (String) ServletActionContext.getRequest().getParameter("newHQL");
		String HQL = null;
		//��newHQLΪ��Ϊnullʱ���������µĲ�ѯ������ƴдSQL
		if(newHQL != null) {
			HQL=EPService.findWithQueryPage(request);
		} else {
			HQL = (String) request.getSession().getAttribute("HQL");
		}

		int totalRows=EPService.getRows(HQL);

		//����ҳ������ǰҳ������ǰ̨
		Pager pager = PagerHelper.getPager(ServletActionContext.getRequest(), totalRows);
		ServletActionContext.getRequest().setAttribute("totalPages", pager.getTotalPages());
		ServletActionContext.getRequest().setAttribute("currentPage", pager.getCurrentPage());

		//���ķ�ʽ
		List readtype=EPService.selectReadType();
		ServletActionContext.getRequest().setAttribute("readtype", readtype);

		//���Լƻ�״̬
		List examplanstatus=EPService.selectExamPlanStatus();
		ServletActionContext.getRequest().setAttribute("examplanstatus", examplanstatus);

		//
		List list=EPService.findWithPage(pager, HQL);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "examprojectquery";
	}
	/**
	 * ���Լƻ���ѯ---���Լƻ��������
	 * @return
	 */
	public String examPlanQueryNum(){
		//���Լƻ�ά�����������༶����
		List<?> className=EPService.selectClassName();
		ServletActionContext.getRequest().setAttribute("cla", className);

		//���Լƻ�ά�������������Է�������
		List<?> examSchemeName=EPService.selectExamSchemeName();
		ServletActionContext.getRequest().setAttribute("sch", examSchemeName);
		
		//���Լƻ�ά�������������ķ�ʽ
		List<?> readType=EPService.selectReadType();
		ServletActionContext.getRequest().setAttribute("readType", readType);
		
		int epqn=Integer.valueOf(ServletActionContext.getRequest().getParameter("epqn"));
		TbExamPlan pq=EPService.loginExamPlan(epqn);
		ServletActionContext.getRequest().getSession().setAttribute("pq", pq);
		return "examplanquerynum";
	}
	/**
	 * ���Լƻ�ά����������ɾ����ť
	 */
	public String examPlanQuerydelete(){
		TbExamPlan pl=(TbExamPlan) ServletActionContext.getRequest().getSession().getAttribute("pq");
		pl.setPlanDel("1");
		EPService.examPlanUpdate(pl);
		ServletActionContext.getRequest().setAttribute("list", null);
		return examProjectQuery();
	}
	/**
	 * ���Լƻ�ά�������������水ť
	 */
	public String examPlanQuerySave(){
		int planId=Integer.valueOf(ServletActionContext.getRequest().getParameter("planId"));
		TbExamPlan plan=EPService.loginExamPlan(planId);
		//���Լƻ�����
		String txtAddress=ServletActionContext.getRequest().getParameter("txtAddress");
		plan.setPlanDescribe(txtAddress);

		//���Լƻ�����
		String planName=ServletActionContext.getRequest().getParameter("planName");
		plan.setPlanName(planName);

		//�༶����
		int CId=Integer.valueOf(ServletActionContext.getRequest().getParameter("className"));
		plan.setTbClasses(EPService.findclaID(CId));

		//���Կ�ʼʱ��
		String startTime=ServletActionContext.getRequest().getParameter("startTime");
		plan.setPlanStartTime(startTime);

		//���Խ���ʱ��
		String endTime=ServletActionContext.getRequest().getParameter("endTime");
		plan.setPlanEndTime(endTime);

		//���Է�������
		int esId=Integer.valueOf(ServletActionContext.getRequest().getParameter("examSchemeName"));
		plan.setTbExamScheme(EPService.findschID(esId));

		//���Ľ�ֹʱ��
		String readOverTime=ServletActionContext.getRequest().getParameter("readOverTime");
		plan.setPlanReadOverTime(readOverTime);

		//���ķ�ʽ
		int readType=Integer.valueOf(ServletActionContext.getRequest().getParameter("readType"));
		plan.setTbReadType(EPService.loginReadType(readType));

		//������
		String reader=ServletActionContext.getRequest().getParameter("reader");
		plan.setCol3(reader);

		//
		EPService.examPlanUpdate(plan);

		return "examplanquerynum";
	}
	/**
	 * ���Լƻ�ά�����������ύ��ť
	 */
	public String examPlanQueryIssue(){
		return examProjectQuery();
	}
	/**
	 * ���Լƻ�����
	 * @return
	 */
	public String examProjectIssue(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String newHQL = (String) ServletActionContext.getRequest().getParameter("newHQL");
		String HQL = null;
		//��newHQLΪ��Ϊnullʱ���������µĲ�ѯ������ƴдSQL
		if(newHQL != null) {
			HQL=EPService.findWithQueryPage(request);
		} else {
			HQL = (String) request.getSession().getAttribute("HQL");
		}

		int totalRows=EPService.getRows(HQL);

		//����ҳ������ǰҳ������ǰ̨
		Pager pager = PagerHelper.getPager(ServletActionContext.getRequest(), totalRows);
		ServletActionContext.getRequest().setAttribute("totalPages", pager.getTotalPages());
		ServletActionContext.getRequest().setAttribute("currentPage", pager.getCurrentPage());


		//���ķ�ʽ
		List<?> readType=EPService.selectReadType();
		ServletActionContext.getRequest().setAttribute("readType", readType);

		//
		List<?> list=EPService.findWithPage(pager, HQL);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "examprojectissue";

	}

	/**
	 * ���Լƻ�����
	 * @return
	 */
	public String examProjectCancel(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String newHQL = (String) ServletActionContext.getRequest().getParameter("newHQL");
		String HQL = null;
		//��newHQLΪ��Ϊnullʱ���������µĲ�ѯ������ƴдSQL
		if(newHQL != null) {
			HQL=EPService.findWithQueryPage(request);
		} else {
			HQL = (String) request.getSession().getAttribute("HQL");
		}

		int totalRows=EPService.getRows(HQL);

		//����ҳ������ǰҳ������ǰ̨
		Pager pager = PagerHelper.getPager(ServletActionContext.getRequest(), totalRows);
		ServletActionContext.getRequest().setAttribute("totalPages", pager.getTotalPages());
		ServletActionContext.getRequest().setAttribute("currentPage", pager.getCurrentPage());


		//���ķ�ʽ
		List<?> readType=EPService.selectReadType();
		ServletActionContext.getRequest().setAttribute("readType", readType);

		//
		List<?> list=EPService.findWithPage(pager, HQL);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "examprojectcancel";
	}


	/**
	 *�༶�������
	 * @return
	 */
	public String classNumQuery(){
		String classNum = ServletActionContext.getRequest().getParameter("classNum");
		TbClasses classnum= EPService.loginClassNum(classNum);
		ServletActionContext.getRequest().setAttribute("classnum", classnum);
		return "classnumquery";		
	}

	/**
	 * ���Է�����������
	 */
	public String examSchemeNameQuery(){
		//
		String examSchemeNum=ServletActionContext.getRequest().getParameter("examSchemeNum");
		TbExamScheme esn=EPService.loginExamSchemeName(examSchemeNum);
		ServletActionContext.getRequest().setAttribute("esn", esn);
		//
		List<?> list=EPService.findWithProblemPage(0, 5);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "examschemenamequery";

	}

	/**
	 * �������
	 */
	public String number(){
		int id=Integer.valueOf(ServletActionContext.getRequest().getParameter("id"));
		TbProblem pro=EPService.loginProblem(id);
		ServletActionContext.getRequest().setAttribute("pro", pro);

		List<?> list=EPService.findWithProblemPage(0, 10);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "number";

	}

	/**
	 * ��Ŀ�������
	 * @return
	 */
	public String problemNum(){
		int pn=Integer.valueOf(ServletActionContext.getRequest().getParameter("pn"));
		TbProblem pro=EPService.loginProblem(pn);
		ServletActionContext.getRequest().setAttribute("pro", pro);

		return "problemNum";
	}

	/**
	 * ���Լƻ�����---���Լƻ��������
	 * @return
	 */
	public String examPlanCancelNum(){
		int epcn=Integer.valueOf(ServletActionContext.getRequest().getParameter("epcn"));
		TbExamPlan pn=EPService.loginExamPlan(epcn);
		ServletActionContext.getRequest().getSession().setAttribute("pn", pn);
		return "examplancancelnum";	
	}

	/**
	 * �ƻ��������غ���
	 */
	public String examPlanCanelBack(){
		TbExamPlan epcb=(TbExamPlan) ServletActionContext.getRequest().getSession().getAttribute("pn");
		epcb.setPlanDel("1");
		EPService.examPlanUpdate(epcb);
		ServletActionContext.getRequest().setAttribute("list", null);
		return examProjectCancel();

	}

	/**
	 * ���Լƻ�����---���Լƻ��������
	 * @return
	 */
	public String examPlanIssueNum(){
		int epin=Integer.valueOf(ServletActionContext.getRequest().getParameter("epin"));
		TbExamPlan pi=EPService.loginExamPlan(epin);
		ServletActionContext.getRequest().setAttribute("pi", pi);
		return "examplanissuenum";

	}

	/**
	 * ���Լƻ���������
	 * @return
	 */
	public String examPlanIssueIssue(){
		return examProjectIssue();
	}

	/**
	 * 
	 */
	public String examProjectQuery3(){
		int planId=Integer.valueOf(ServletActionContext.getRequest().getParameter("planId"));
		TbExamPlan plan=EPService.loginExamPlan(planId);
		ServletActionContext.getRequest().setAttribute("plan", plan);
		return "examProjectQuery3";
	}
	/**
	 * 
	 */
	public String examProjectIssue3(){
		int esId=Integer.valueOf(ServletActionContext.getRequest().getParameter("esId"));
		TbExamScheme scheme=EPService.findschID(esId);
		TbExamSchemeDetail schemeDetail=EPService.loginSchemeDetail(scheme);
		ServletActionContext.getRequest().setAttribute("schemeDetail", schemeDetail);
		return "examProjectIssue3";
	}

	



	public NumberUtil getNumberUtil() {
		return numberUtil;
	}

	public void setNumberUtil(NumberUtil numberUtil) {
		this.numberUtil = numberUtil;
	}

	
}