package com.cissst.iService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.cissst.dao.ProblemManagerDao;
import com.cissst.entity.TbAuditStatus;
import com.cissst.entity.TbProblem;
import com.cissst.entity.TbProblemAudit;
import com.cissst.entity.TbProblemDifficultyLevel;
import com.cissst.entity.TbProblemResult;
import com.cissst.entity.TbProblemScore;
import com.cissst.entity.TbProblemType;
import com.cissst.entity.TbUser;
import com.cissst.service.ProblemManagerService;
import com.cissst.utils.Pager;
/**
 * @ģ�����ƣ�ProblemManagerAction(������)
 * @�����ˣ�
 * @��          �ܣ�����ProblemManagerAction������ҵ���߼�
 * @����ʱ�䣺
 */
public class ProblemManagerServiceImp implements ProblemManagerService
{
	private ProblemManagerDao problemManagerDao;

	public ProblemManagerDao getProblemManagerDao()
	{
		return problemManagerDao;
	}

	public void setProblemManagerDao(ProblemManagerDao problemManagerDao)
	{
		this.problemManagerDao = problemManagerDao;
	}

	/**
	 * ��ѯ��Ŀ�Ѷȵȼ�
	 */
	public List<?> findProblemDifficultyLevel() {

		return problemManagerDao.findList("from TbProblemDifficultyLevel where pdlDel=0 ");
	}

	/**
	 * ��ѯ��Ŀ��Χ
	 */
	public List<?> findProblemScore() {

		return problemManagerDao.findList("from TbProblemScore where psDel = 0");
	}

	/**
	 * ��ѯ��Ŀ����
	 */
	public List<?> findProblemType() {
		return problemManagerDao.findList("from TbProblemType where ptDel = 0");
	}

	/**
	 * ��ѯ��һ�����Ѷȵȼ�
	 */
	public TbProblemDifficultyLevel getProblemDifficultyLevel(int id) {

		return (TbProblemDifficultyLevel) problemManagerDao.findByHQL("from TbProblemDifficultyLevel where pdlDel=0 and id=" +id);
	}

	/**
	 * ��ѯ��һ�����ⷶΧ
	 */
	public TbProblemScore getProblemScore(int id) {

		return (TbProblemScore) problemManagerDao.findByHQL("from TbProblemScore where psDel = 0 and id ="+id);
	}

	/**
	 * ��ѯ��һ��Ŀ����
	 */
	public TbProblemType getProblemType(int id) {

		return (TbProblemType) problemManagerDao.findByHQL("from TbProblemType where ptDel = 0 and id=" + id);
	}

	/**
	 * ɾ����
	 */
	public void deleteProResult(int id) {
		TbProblemResult problemResult = (TbProblemResult) problemManagerDao.findByHQL("from TbProblemResult where id=" +id);
		String prDel = "1";
		problemResult.setPrDel(prDel);
		problemManagerDao.update(problemResult);
	}

	/**
	 * �洢һ����Ŀ
	 */
	public void saveProblem(TbProblem tbProblem) {
		problemManagerDao.save(tbProblem);
	}

	/**
	 * ��ѯһ����Ŀ
	 * col1Ϊ������
	 */
	public TbProblem findTbProblem(String col1) { 
		StringBuffer HQL = new StringBuffer("from TbProblem where PDel = 0 ");
		HQL.append(" and col1 like '%"+col1+"%'");
		return (TbProblem) problemManagerDao.findByHQL(HQL.toString());
	}

	/** 
	 * ͨ��ID��ѯһ����Ŀ
	 */
	public TbProblem getTbProblem(int id) {

		return (TbProblem) problemManagerDao.findByHQL("from TbProblem where PDel = 0 and PId =" + id);
	}

	/**
	 * �洢һ����
	 */
	public void saveResult(TbProblemResult tbProblemResult) {
		problemManagerDao.save(tbProblemResult);
	}

	/**
	 * ͨ����ĿId��ѯ��Ŀ��
	 */
	public List<?> findProResult(int id ) {

		return problemManagerDao.findList("from TbProblemResult as pr where pr.prDel=0 and pr.tbProblem.PId = " + id);

	}

	/**
	 * ͨ����ĿId��øõ���Ŀ���д𰸵�id
	 */
	public List<?> getResultId(int id){
		return problemManagerDao.findList(" select pr.prId from TbProblemResult as pr where pr.prDel=0 and pr.tbProblem.PId = " + id);

	}

	/**
	 * ���´�
	 */
	public void updateResult(TbProblemResult result) {
		problemManagerDao.update(result);
	}

	/**
	 * ͨ����Id���һ����
	 */
	public TbProblemResult getProResult(int id) {
		return (TbProblemResult) problemManagerDao.findByHQL("from TbProblemResult where prDel = 0 and id =" +id);
	}

	/**
	 * ����һ����Ŀ
	 */
	public void updateProblem(TbProblem problem) {
		problemManagerDao.update(problem);
	}

	/**
	 * ���� TbUser����
	 */
	public void saveTbUser(TbUser user) {
		problemManagerDao.save(user);
	}

	/**
	 * �洢���״̬
	 */
	public void saveAuditStatus(TbAuditStatus auditStatus){
		problemManagerDao.save(auditStatus);
	}

	/**
	 * �������״̬���Ʋ������Id
	 */
	public TbAuditStatus findTbAuditStatus(String asName){
		return (TbAuditStatus) problemManagerDao.findByHQL(" from TbAuditStatus as tbAs where tbAs.asDel=0 and tbAs.asName like '%"+asName+"%'");
	}

	/**
	 * ��ѯ��������õļ���״̬
	 */
	public List<?> findTbAuditStatusList(){
		return problemManagerDao.findList("from TbAuditStatus where asDel = 0");

	}

	/**
	 * 
	 *��ҳHqlƴд
	 */
	public String checkHQL(HttpServletRequest request) {

		StringBuffer buffer = new StringBuffer("from TbProblem where PDel = 0");

		//�����Ŀ���
		String  problemNo = ServletActionContext.getRequest().getParameter("problemNo");
		if(problemNo != "" && problemNo != null) {
			buffer.append(" and col1 like '%"+problemNo+"%'");
		}

		//�����Ŀ��������
		String ptName = ServletActionContext.getRequest().getParameter("ptName");
		if(ptName != "" && ptName  != null) {
			buffer.append(" and tbProblemType.ptName like '%"+ptName+"%'");
		}

		//�����Ŀ��Χ����
		String psName = ServletActionContext.getRequest().getParameter("psName");
		if(psName != "" && psName != null) {
			buffer.append(" and tbProblemScore.psName like '%"+ psName +"%'");
		}

		//�����Ŀ�Ѷȵȼ�
		String pdlName = ServletActionContext.getRequest().getParameter("pdlName");
		if(pdlName != "" && pdlName != null) {
			buffer.append(" and tbProblemDifficultyLevel.pdlName like '%"+ pdlName  +"%'");
		}

		//�����Ŀ����״̬
		String asName = ServletActionContext.getRequest().getParameter("asName");
		if(asName != "" && asName != null) {
			buffer.append(" and tbAuditStatus.asName like '%"+ asName +"%'");
		}

		//��������
		String addTbUser = request.getParameter("addTbUser");
		if(addTbUser != "" && addTbUser != null) {
			buffer.append(" and  tbUser.UName like '%"+ addTbUser +"%'");
		}

		//���ǰ̨��ʼ����ʱ��
		String startTime = ServletActionContext.getRequest().getParameter("startTime");
		String endTime = ServletActionContext.getRequest().getParameter("endTime");
		if(startTime != "" && startTime != null) {
			buffer.append(" and PAddTime > '"+startTime+"'");
		}
		if(endTime != "" && endTime != null) {
			buffer.append(" and PAddTime < '"+endTime+"'");
		}

		String HQL = buffer.toString();
		ServletActionContext.getRequest().getSession().setAttribute("HQL", HQL);

		return HQL;
	}

	/**
	 * 
	 *��Ŀ��˷�ҳHqlƴд
	 */
	public String AuditHQL(HttpServletRequest request) {
		StringBuffer buffer = new StringBuffer("from TbProblem  where PDel = 0  ");

		//�����Ŀ���
		String  problemNo = ServletActionContext.getRequest().getParameter("problemNo");
		if(problemNo != "" && problemNo != null) {
			buffer.append(" and col1 like '%"+problemNo+"%'");
		}

		//�����Ŀ��������
		String ptName = ServletActionContext.getRequest().getParameter("ptName");
		if(ptName != "" && ptName  != null) {
			buffer.append(" and tbProblemType.ptName like '%"+ptName+"%'");
		}

		//�����Ŀ��Χ����
		String psName = ServletActionContext.getRequest().getParameter("psName");
		if(psName != "" && psName != null) {
			buffer.append(" and tbProblemScore.psName like '%"+ psName +"%'");
		}

		//�����Ŀ�Ѷȵȼ�
		String pdlName = ServletActionContext.getRequest().getParameter("pdlName");
		if(pdlName != "" && pdlName != null) {
			buffer.append(" and tbProblemDifficultyLevel.pdlName like '%"+ pdlName  +"%'");
		}

		//��������
		String addTbUser = request.getParameter("addTbUser");
		if(addTbUser != "" && addTbUser != null) {
			buffer.append(" and  tbUser.UName like '%"+ addTbUser +"%'");
		}

		//���ǰ̨��ʼ����ʱ��
		String startTime = ServletActionContext.getRequest().getParameter("startTime");
		String endTime = ServletActionContext.getRequest().getParameter("endTime");
		if(startTime != "" && startTime != null) {
			buffer.append(" and PAddTime > '"+startTime+"'");
		}
		if(endTime != "" && endTime != null) {
			buffer.append(" and PAddTime < '"+endTime+"'");
		}


		buffer.append(" and tbAuditStatus.asName  like  '%"+ "���ύ" +"%' ");


		String HQLs = buffer.toString();
		ServletActionContext.getRequest().getSession().setAttribute("HQLs", HQLs);

		return HQLs;
	}

	/**
	 * 
	 *��Ŀ��˷�ҳHqlƴд
	 */
	public String cancelHQL(HttpServletRequest request) {

		StringBuffer buffer = new StringBuffer("from TbProblem where PDel = 0  ");

		//�����Ŀ���
		String  problemNo = ServletActionContext.getRequest().getParameter("problemNo");
		if(problemNo != "" && problemNo != null) {
			buffer.append(" and col1 like '%"+problemNo+"%'");
		}

		//�����Ŀ��������
		String ptName = ServletActionContext.getRequest().getParameter("ptName");
		if(ptName != "" && ptName  != null) {
			buffer.append(" and tbProblemType.ptName like '%"+ptName+"%'");
		}

		//�����Ŀ��Χ����
		String psName = ServletActionContext.getRequest().getParameter("psName");
		if(psName != "" && psName != null) {
			buffer.append(" and tbProblemScore.psName like '%"+ psName +"%'");
		}

		//�����Ŀ�Ѷȵȼ�
		String pdlName = ServletActionContext.getRequest().getParameter("pdlName");
		if(pdlName != "" && pdlName != null) {
			buffer.append(" and tbProblemDifficultyLevel.pdlName like '%"+ pdlName  +"%'");
		}

		//��������
		String addTbUser = request.getParameter("addTbUser");
		if(addTbUser != "" && addTbUser != null) {
			buffer.append(" and  tbUser.UName like '%"+ addTbUser +"%'");
		}

		//���ǰ̨��ʼ����ʱ��
		String startTime = ServletActionContext.getRequest().getParameter("startTime");
		String endTime = ServletActionContext.getRequest().getParameter("endTime");
		if(startTime != "" && startTime != null) {
			buffer.append(" and PAddTime > '"+startTime+"'");
		}
		if(endTime != "" && endTime != null) {
			buffer.append(" and PAddTime < '"+endTime+"'");
		}
		buffer.append(" and tbAuditStatus.asName not like '%"+ "�ѱ���" +"%'");

		String HQLes = buffer.toString();
		ServletActionContext.getRequest().getSession().setAttribute("HQLes", HQLes);

		return HQLes;
	}


	/**
	 * ��ҳ��ѯ����
	 */
	public List<?> findWithPage(Pager pager, String HQL){

		return problemManagerDao.findWithPage(pager.getStartRow(), pager.getPageSize(), HQL);

	}

	/**
	 * �������������
	 */
	public int getRows(String HQL){
		return problemManagerDao.findList(HQL).size();
	}


	/**
	 * 
	 * ����һ��tbUser��ͨ��tbUbser��id ���˷�������ʱ���ܻ�ȥ��)
	 */
	public TbUser getTbUser(int id){
		return (TbUser) problemManagerDao.findByHQL("from TbUser where UDel=0 and UId="+id );

	}

	/**
	 * ������Ŀ������
	 */
	public void saveTbProblemAudit(TbProblemAudit audit) {
		problemManagerDao.save(audit);
	}

	/**
	 * ͨ����Ŀid������Ŀ�����״̬
	 */
	public TbProblemAudit findTbProblemAudit (int id) {
		return (TbProblemAudit) problemManagerDao.findByHQL("from TbProblemAudit where paDel=0 and tbProblem.PId = " + id);
	}

	/**
	 * ������Ŀ���״̬��
	 */
	public void updateTbProblemAudit(TbProblemAudit problemAudit){
		problemManagerDao.update(problemAudit);
	}

	/**
	 * ͨ����ĿIDɾ����Ŀ
	 */
	public void deleteProblem(int id) {
		String HQL = "from TbProblem where PDel=0 and PId =" +id;
		TbProblem problem = (TbProblem) problemManagerDao.findByHQL(HQL);
		problem.setPDel("1");
		problemManagerDao.update(problem);
	}


}
