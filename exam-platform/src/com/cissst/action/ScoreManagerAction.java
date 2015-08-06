package com.cissst.action;
import java.awt.print.Paper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.jboss.cache.eviction.BaseSortedEvictionAlgorithm;

import com.cissst.entity.TbClasses;
import com.cissst.entity.TbExamPaper;
import com.cissst.entity.TbExamPaperAnswer;
import com.cissst.entity.TbExamPlan;
import com.cissst.entity.TbStudent;
import com.cissst.entity.TbUser;
import com.cissst.service.ScoreManagerService;
import com.cissst.utils.Pager;
import com.cissst.utils.PagerHelper;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @ģ�����ƣ�ScoreManagerAction(�ɼ�����)
 * @�����ˣ�������
 * @��          �ܣ�
 * @����ʱ�䣺
 */
public class ScoreManagerAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	//����ҵ���߼���
	private ScoreManagerService SMService;
	private TbExamPaper  tbExamPaper;
	private TbExamPlan examPlan ;
	private TbExamPaperAnswer paperAnswer;
	//ʵ��get/set����
	public TbExamPaperAnswer getPaperAnswer() {
		return paperAnswer;
	}

	public void setPaperAnswer(TbExamPaperAnswer paperAnswer) {
		this.paperAnswer = paperAnswer;
	}

	public TbExamPlan getExamPlan() {
		return examPlan;
	}

	public void setExamPlan(TbExamPlan examPlan) {
		this.examPlan = examPlan;
	}

	public TbExamPaper getTbExamPaper() {
		return tbExamPaper;
	}

	public void setTbExamPaper(TbExamPaper tbExamPaper) {
		this.tbExamPaper = tbExamPaper;
	}
	public ScoreManagerService getSMService()
	{
		return SMService;
	}

	public void setSMService(ScoreManagerService sMService)
	{
		SMService = sMService;
	}

	
	/**
	 * @ģ�����ƣ��ɼ���ѯ
	 * @�����ˣ�������
	 * @��          �ܣ�ʵ�ֲ�ѯ���п�ʼ�ƻ��Ĳ�ѯ
	 * @����ʱ�䣺
	 */
	public String gradeQuery(){
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String newHQL=request.getParameter("newHQL");
		String HQL=null;
		if(newHQL!=null){
			HQL=SMService.joinHql();
		}else{
			 HQL=(String) request.getSession().getAttribute("builderHQL");
		}
		//����HQL�õ�������
		int totalRows=SMService.getRows(HQL);
		//�õ�һ��pager����
		Pager pager=PagerHelper.getPager(request, totalRows);
		request.setAttribute("totalPage", pager.getTotalPages());
		request.setAttribute("currentPage",pager.getCurrentPage());
		
		List<TbExamPlan> gradeQueryList=SMService.gradeQuery(pager.getStartRow(),pager.getPageSize(),HQL);
		request.setAttribute("gradeQueryList", gradeQueryList);
		return "gradeQuery";
	}
	/**
	 * @ģ�����ƣ��ɼ���ѯ
	 * @�����ˣ�������
	 * @��          �ܣ�ʵ�ֲ�ѯһ��ѧ���ɼ�����
	 * @����ʱ�䣺
	 */
	public String findOneScore(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int id=Integer.valueOf(request.getParameter("c_id"));
         System.out.println("~~~~~~~"+id);
		 examPlan=SMService.findPlan(id);
		request.setAttribute("examPlan", examPlan);
		
//		Set<TbExamPaper> paperSet=new HashSet<TbExamPaper>();
//		paperSet=examPlan.getTbExamPapers();
//		Iterator<TbExamPaper> it=paperSet.iterator();
//		List<TbExamPaper> paperList=new ArrayList<TbExamPaper>();
//		while(it.hasNext()){
//			TbExamPaper paper=new TbExamPaper();
//			paper=it.next();
//			paperList.add(paper);
//			request.setAttribute("paperList", paperList);
//		}
		return "gradeQuery2";
	}
	
	/**
	 * @ģ�����ƣ��ɼ�����
	 * @�����ˣ�������
	 * @��          �ܣ�ʵ�ֲ�ѯһ��ѧ���ɼ�����
	 * @����ʱ�䣺
	 */
	public String gradeIssue(){
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String newHQL=request.getParameter("newHQL");
		String HQL=null;
		if(newHQL!=null&&newHQL!=""){
			HQL=SMService.joinHql();
		}else{
			 HQL=(String) request.getSession().getAttribute("builderHQL");

		}
		//����HQL�õ�������
		int totalRows=SMService.getRows(HQL);
		//�õ�һ��pager����
		Pager pager=PagerHelper.getPager(request, totalRows);
		request.setAttribute("totalPage", pager.getTotalPages());
		request.setAttribute("currentPage",pager.getCurrentPage());
		
		List<TbExamPlan> gradeIssueList=SMService.gradeIssue(pager.getStartRow(), pager.getPageSize(),HQL);
		request.setAttribute("gradeIssueList", gradeIssueList);
		return "gradeIssue";
	}
	/**
	 * @ģ�����ƣ��ɼ�����
	 * @�����ˣ�������
	 * @��          �ܣ���ѯ���Է�����һ�����Լƻ�
	 * @����ʱ�䣺
	 */
	@SuppressWarnings("unchecked")
	public String gradeIssueOne(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int id=Integer.valueOf(request.getParameter("issueId"));
		
		TbExamPlan examPlanIssue=SMService.findPlan(id);
		TbClasses classes=examPlanIssue.getTbClasses();
		Set<TbStudent> stuSet=classes.getTbStudents();
		int stuTotal=stuSet.size();
		request.setAttribute("stuTotal", stuTotal);
		request.setAttribute("examPlanIssue", examPlanIssue);
		return "gradeIssue1";
	}
	
	/**
	 * @ģ�����ƣ��ɼ�����
	 * @�����ˣ�������
	 * @��          �ܣ���ѯ���Է�����һ�����Լƻ�
	 * @����ʱ�䣺
	 */
	public String issue(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int id=Integer.valueOf(request.getParameter("pId"));
		TbExamPlan examPlan =SMService.findPlan(id);
		examPlan.setCol2("�ѷ���");
		SMService.updatePlan(examPlan);
		return this.gradeIssueOne();
		
	}
	
	
	
	
	/**
	 * @ģ�����ƣ��ɼ�����
	 * @�����ˣ�������
	 * @��          �ܣ���ѯ������Ҫ���ĵĿ��Լƻ�
	 * @����ʱ�䣺
	 */
	public String gradeCheck(){
        HttpServletRequest request=ServletActionContext.getRequest();
        //���ҳ�������ֵ
        String newHQL=request.getParameter("newHQL");
        String HQL=null;
        //�ж�newHQL�Ƿ�Ϊ��
        if(newHQL!=null){
        	HQL=SMService.joinHql();
        }else{
        	HQL=(String) request.getSession().getAttribute("builderHQL");
        }
        //����HQL�õ�������
		int totalRows=SMService.getRows(HQL);
		//�õ�һ��pager����
		Pager pager=PagerHelper.getPager(request, totalRows);
		//����ҳ���͵�ǰҳ�赽ҳ����
		request.setAttribute("totalPage", pager.getTotalPages());
		request.setAttribute("currentPage",pager.getCurrentPage());
		
		List<TbExamPlan> gradeChecklist=SMService.gradeCheck(pager.getStartRow(), pager.getPageSize(),HQL);
		request.setAttribute("gradeChecklist", gradeChecklist);
		return "gradeCheck";
	}
	/**
	 * @ģ�����ƣ��ɼ�����
	 * @�����ˣ�������
	 * @��          �ܣ�����id��ѯһ����Ҫ���ĵĿ��Լƻ�
	 * @����ʱ�䣺
	 */
	public String gradeCheckList(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int id=Integer.valueOf(request.getParameter("c_id1"));
		int totalRows=SMService.getRowsCheck(id);
		Pager pager=PagerHelper.getPager(request, totalRows);
		request.setAttribute("totalPage", pager.getTotalPages());
		request.setAttribute("currentPage", pager.getCurrentPage());
		
		
		TbExamPlan examPlanCheck=SMService.gradeCheckList(id);
		request.setAttribute("examPlanCheck", examPlanCheck);
		return "gradeCheckList";
	}
	/**
	 * @ģ�����ƣ��ɼ�����
	 * @�����ˣ�������
	 * @��          �ܣ�����id��ѯһ����Ҫ���ĵĿ��Լƻ�
	 * @����ʱ�䣺
	 */
	@SuppressWarnings("unchecked")
	public String gradeForCheck(){
		HttpServletRequest request=ServletActionContext.getRequest();
		//����ǰһҳ�Ŀ��Լƻ�id������Լƻ�
		int id=Integer.valueOf(request.getParameter("gradeForCheck"));
		 examPlan=SMService.gradeForCheck(id);
		 //�����Ա�ŷŵ����ĵı�����
		 request.setAttribute("examPlan", examPlan);

         int paperId=Integer.valueOf(request.getParameter("paperId"));
         //�õ�һ�ſ���
         tbExamPaper=SMService.checkPaper(paperId);
           Set answersSet=new HashSet();
           //ȡ��paperAnswer����
           answersSet=tbExamPaper.getTbExamPaperAnswers();
          request.setAttribute("answersSet",answersSet);
		return "gradeForCheck";
	}
	/**
	 * @ģ�����ƣ��ɼ�����
	 * @�����ˣ�������
	 * @��          �ܣ�����ÿ����ɼ�
	 * @����ʱ�䣺
	 */
	public String saveScore(){
		HttpServletRequest request=ServletActionContext.getRequest();
		//�õ���ʦ��ķ���
		String mark=request.getParameter("score");
		float mark1=Float.valueOf(mark);
		//�õ��Ƿ��Ծ�id��������ѷ������½�ȥ
		int  id=Integer.valueOf(request.getParameter("answerId"));
		TbExamPaperAnswer paperAnswer=SMService.paperAnswer(id);
		paperAnswer.setEpaMark(mark1);
		SMService.saveScore(paperAnswer);
		//return "gradeForCheck";
		return this.gradeForCheck();
		
		
		
		
	}
	
	

}
