package com.cissst.iService;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.cissst.dao.ScoreManagerDao;
import com.cissst.entity.TbExamPaper;
import com.cissst.entity.TbExamPaperAnswer;
import com.cissst.entity.TbExamPlan;
import com.cissst.service.ScoreManagerService;
/**
 * @ģ�����ƣ�ScoreManagerAction(�ɼ�����)
 * @�����ˣ�
 * @��          �ܣ�����ScoreManagerAction�����ݿ�����в���
 * @����ʱ�䣺
 */
public class ScoreManagerServiceImp implements ScoreManagerService{
	//�������ݷ��ʲ�
	private ScoreManagerDao scoreManagerDao;
    //ʵ��get��set����
	public ScoreManagerDao getScoreManagerDao()
	{
		return scoreManagerDao;
	}

	public void setScoreManagerDao(ScoreManagerDao scoreManagerDao)
	{
		this.scoreManagerDao = scoreManagerDao;
	}
	
	//��ҳ���õ����Լƻ���������
	public int getRows(String HQL) {	
		return scoreManagerDao.findList(HQL).size();
	}
//	public int getRows() {	
//		String HQL="select count(*) from TbExamPlan  where 1=1";
//		Object object=scoreManagerDao.getRows(HQL);
//		long tempNumber=(Long)object;
//		return (int)tempNumber;
//	}
	  //�ڳɼ������и���һ���ƻ���ŵõ�����ƻ���Ҫ���ĵ�������
	public int getRowsCheck(int id) {
		HttpServletRequest request=ServletActionContext.getRequest();
		//TbExamPlan examPlanrequest.getParameter(name);
		String HQL="from TbExamPaper where tbExamPlan.planId="+id;
		System.out.println("&&&&"+HQL);
//		Object object=scoreManagerDao.getRows(HQL);
//		long tempNumber=(Long)object;
//		return (int)tempNumber;
		return   scoreManagerDao.findList(HQL).size();
	}
	//������ѯƴ��HQL
	public String joinHql(){
		HttpServletRequest request=ServletActionContext.getRequest();
		StringBuilder builderHql=new StringBuilder("from TbExamPlan where 1=1 ");
		//���Լƻ����
		String epMyselfId=request.getParameter("epMyselfId");
		if(epMyselfId!=null && epMyselfId!=""){
			builderHql.append(" and epMyselfId like '%"+epMyselfId+"%'");
		}
		//���Լƻ�����
		String planName=request.getParameter("planName");
		if(planName!=null && planName!=""){
			builderHql.append(" and planName like '%"+planName+"%'");
		}
		//���Լƻ�����
		String planDescribe=request.getParameter("planDescribe");
		if(planDescribe!=null && planDescribe!=""){
			builderHql.append(" and planDescribe like '%"+planDescribe+"%'");
		}
		//���Է������
		String esMyselfId=request.getParameter("esMyselfId");
		if(esMyselfId!=null && esMyselfId!=""){
			builderHql.append(" and tbExamScheme.esMyselfId like '%"+esMyselfId+"%'");
		}
		//����״̬
		String rsName=request.getParameter("rsName");
		if(rsName!=null&&rsName!="" ){
			int tempt=Integer.valueOf(rsName);
			switch (tempt) {
			case 0: rsName=null;
			    break;
			case 1: rsName="δ����";
				break;
			case 2: rsName="������";
			     break;
			case 3: rsName="������";
		     break;
			}
			}
		if(rsName!=null&&rsName!=""){
			builderHql.append(" and  tbReadStatus.rsName like '%"+rsName+"%' ");
		}
		//��������
		String rtName=request.getParameter("rtName");
		
		if(rtName!=null&&rtName!="" ){
			int tempt=Integer.valueOf(rtName);
			System.out.println(tempt);
			switch (tempt) {
			case 0: rtName=null;
			    break;
			case 1: rtName="�Զ�����";
				break;
			case 2: rtName="��ʦ����";
			     break;
			}
			}
		if(rtName!=null && rtName!=""){
			builderHql.append(" and tbReadType.rtName like '%"+rtName+"%'");
		}
		//�༶����
		String CName=request.getParameter("CName");
		if(CName!=null&&CName!=""){
			builderHql.append(" and tbClasses.CName like '%"+CName+"%'");
		}
		//�༶״̬
		String csName=request.getParameter("csName");
		if(csName!=null&&csName!="" ){
			int tempt=Integer.valueOf(csName);
			switch (tempt) {
			case 0: csName=null;
			    break;
			case 1: csName="�ѿ���";
				break;
			case 2: csName="�ѽ�ҵ";
			     break;
			}
			}
		if(csName!=null&&csName!=""){
			builderHql.append(" and tbClasses.tbClazzStatus.csName like '%"+csName+"%'");
		}
		//���Կ�ʼʱ��
		String planStartTime=request.getParameter("planStartTime");
		if(planStartTime!=null&&planStartTime!=""){
			builderHql.append(" and planStartTime  > '"+planStartTime+"'");
		}
		//���Խ���ʱ��
		String planEndTime=request.getParameter("planEndTime");
		if(planEndTime!=null&&planEndTime!=""){
			builderHql.append(" and planEndTime < '"+planEndTime+"'");
		}
		builderHql.append(" and planDel=0");
		//ת����String����
		String builderHQL=builderHql.toString();
		//set��session��
		request.getSession().setAttribute("builderHQL", builderHQL);
		System.out.println("HQL�ǣ�"+builderHQL);
		return builderHQL;
	}
	/**
	 * @ģ�����ƣ��ɼ���ѯ
	 * @�����ˣ�������
	 * @��          �ܣ���ѯ���гɼ�
	 * @����ʱ�䣺
	 */
	@SuppressWarnings("unchecked")
	public List<TbExamPlan> gradeQuery(int startNumber,int pageSize,String HQL) {
		return (List<TbExamPlan>)scoreManagerDao.findWithPage(startNumber, pageSize, HQL);
	}


	//���һ���Լƻ��Ķ���
	public TbExamPlan findPlan(int id){
		String HQL="from TbExamPlan where planId="+id;
		TbExamPlan TbExamPlan=(TbExamPlan)scoreManagerDao.findByHQL(HQL);
		System.out.println("HQL:"+HQL);
		return TbExamPlan;
	}
	/**
	 * @ģ�����ƣ��ɼ�����
	 * @�����ˣ�������
	 * @��          �ܣ�ʵ�ֿ��Է���ҳ��������ѯ
	 * @����ʱ�䣺
	 */
	@SuppressWarnings("unchecked")
	public List<TbExamPlan> gradeIssue(int startNumber,int pageSize,String HQL) {
		return (List<TbExamPlan>)scoreManagerDao.findWithPage(startNumber, pageSize, HQL);
	}
	/**
	 * @ģ�����ƣ��ɼ�����
	 * @�����ˣ�������
	 * @��          �ܣ���ѯһ�����Լƻ�
	 * @����ʱ�䣺
	 */
	public TbExamPlan gradeIssueOne(String epMyselfId){
		String HQL="from TbExamPlan where epMyselfId="+epMyselfId;
		System.out.println(HQL);
		return (TbExamPlan) scoreManagerDao.findByHQL(HQL);
	}
	/**
	 * @ģ�����ƣ��ɼ�����
	 * @�����ˣ�������
	 * @��          �ܣ���ѯ����������
	 * @����ʱ�䣺
	 */
	@SuppressWarnings("unchecked")
	public List<TbExamPlan> gradeCheck(int startNumber,int pageSize,String HQL) {
		
		return (List<TbExamPlan>)scoreManagerDao.findWithPage(startNumber, pageSize, HQL);
	}
	/**
	 * @ģ�����ƣ��ɼ�����
	 * @�����ˣ�������
	 * @��          �ܣ���ѯһ����Ҫ���ĵĿ��Լƻ�
	 * @����ʱ�䣺
	 */
	public TbExamPlan gradeCheckList(int id){
		String HQL="from TbExamPlan where planId="+id;
		return (TbExamPlan) scoreManagerDao.findByHQL(HQL);
		
	}
	/**
	 * @ģ�����ƣ��ɼ�����
	 * @�����ˣ�������
	 * @��          �ܣ����ݿ��Լƻ�id��ѯһ���Ծ�
	 * @����ʱ�䣺
	 */
	public TbExamPlan gradeForCheck(int id){
		String HQL="from TbExamPlan   where  planId="+id;
		return (TbExamPlan) scoreManagerDao.findByHQL(HQL);
		
	}
	/**
	 * @ģ�����ƣ��ɼ�����
	 * @�����ˣ�������
	 * @��          �ܣ�����paper��id��ѯһ���Ծ�
	 * @����ʱ�䣺
	 */
    public TbExamPaper checkPaper(int id){
		String HQL="from TbExamPaper where epId="+id;
    	return (TbExamPaper)scoreManagerDao.findByHQL(HQL);
    }
    /**
	 * @ģ�����ƣ��ɼ�����
	 * @�����ˣ�������
	 * @��          �ܣ�����id��ѯ��һ���Ծ��������
	 * @����ʱ�䣺
	 */
	public TbExamPaperAnswer paperAnswer(int id) {
		String HQL="from TbExamPaperAnswer where epaId="+id;
		
		return (TbExamPaperAnswer) scoreManagerDao.findByHQL(HQL);
	}
	/**
	 * @ģ�����ƣ��ɼ�����
	 * @�����ˣ�������
	 * @��          �ܣ�����ĳɼ�
	 * @����ʱ�䣺
	 */
    public void saveScore(TbExamPaperAnswer paperAnswer){
    	scoreManagerDao.update(paperAnswer);
    }


	/**
	 * @ģ�����ƣ��ɼ�����
	 * @�����ˣ�������
	 * @��          �ܣ����¿��Լƻ�
	 * @����ʱ�䣺
	 */
	public void updatePlan(TbExamPlan examPlan){
		scoreManagerDao.update(examPlan);
	}

	
}
