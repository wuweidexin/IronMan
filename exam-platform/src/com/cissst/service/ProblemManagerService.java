package com.cissst.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cissst.entity.TbAuditStatus;
import com.cissst.entity.TbProblem;
import com.cissst.entity.TbProblemAudit;
import com.cissst.entity.TbProblemDifficultyLevel;
import com.cissst.entity.TbProblemResult;
import com.cissst.entity.TbProblemScore;
import com.cissst.entity.TbProblemType;
import com.cissst.entity.TbUser;
import com.cissst.utils.Pager;

/**
 * @ģ�����ƣ�ProblemManagerAction(������)
 * @�����ˣ�
 * @��          �ܣ�����ProblemManagerAction������ҵ���߼�
 * @����ʱ�䣺
 */
public interface ProblemManagerService
{
	/**
	 * ��ѯ��Ŀ����
	 */
	public List<?> findProblemType();
	
	/**
	 * ��ѯ��Ŀ��Χ
	 */
	public List<?> findProblemScore();
	
	/**
	 * ��ѯ��Ŀ�Ѷȵȼ�
	 */
	public List<?> findProblemDifficultyLevel();
	
	/**
	 * ��ѯ��һ��Ŀ����
	 */
	
	public TbProblemType getProblemType( int id);
	
	/**
	 * ��ѯ��һ�����ⷶΧ
	 */
	
	public TbProblemScore getProblemScore(int id);
	
	/**
	 * ��ѯ��һ�����Ѷȵȼ�
	 */
	
	public TbProblemDifficultyLevel getProblemDifficultyLevel(int id);
	
	/**
	 * ��ѯ�����
	 */
	public List<?> findProResult(int id);
	
	/**
	 * ͨ����ĿId��øõ���Ŀ���д𰸵�id
	 */
	public List<?> getResultId(int id);
	
	/**
	 * ͨ����Id���һ����
	 */
	public TbProblemResult getProResult(int id);
	
	/**
	 * ɾ����
	 */
	public void deleteProResult(int id);
	
	/**
	 * �洢һ����Ŀ
	 */
	public void saveProblem(TbProblem tbProblem);

	/**
	 * ͨ����Ŀ��Ų�ѯһ����Ŀ
	 */
	public TbProblem findTbProblem(String col1);
	
	/**
	 * ͨ����ĿID��ѯһ����Ŀ
	 */
	public TbProblem getTbProblem(int id);
	
	/**
	 * �洢һ����
	 */
	public void saveResult(TbProblemResult tbProblemResult);
	
	/**
	 * ���´�
	 */
	public void updateResult(TbProblemResult result);
	
	/**
	 * ����һ����Ŀ
	 */
	public void updateProblem(TbProblem problem);
	
	/**
	 * ���� TbUser����
	 */
	public void saveTbUser(TbUser user);
	
	/**
 	 * �������״̬���Ʋ������Id
	 */
	public TbAuditStatus findTbAuditStatus(String asName);
	
	/**
	 * ��ѯ��������õļ���״̬
	 */
	public List<?> findTbAuditStatusList();
	
	/**
	 * ��ҳ��ѯ����
	 */
	public List<?> findWithPage(Pager pager, String HQL);
	
	
	/**
	 * �������������(ȫ���ҳ����)
	 */
	public int getRows(String HQL);
	
	/**
	 * 
	 *��ҳHqlƴд
	 */
	public String checkHQL(HttpServletRequest request);
	
	/**
	 * 
	 *��Ŀ��˷�ҳHqlƴд
	 */
	public String AuditHQL(HttpServletRequest request);
	
	/**
	 * 
	 * ����һ��tbUser��ͨ��tbUbser��id ���˷�������ʱ���ܻ�ȥ��)
	 */
	public TbUser getTbUser(int id);
	
	/**
	 * ������Ŀ������
	 * 
	 */
	public void saveTbProblemAudit(TbProblemAudit audit);
	
	/**
	 * 
	 *��Ŀ��˷�ҳHqlƴд
	 */
	public String cancelHQL(HttpServletRequest request);
	
	/**
	 * ͨ����Ŀid������Ŀ�����״̬
	 */
	public TbProblemAudit findTbProblemAudit (int id);

	/**
	 * ������Ŀ���״̬��
	 */
	public void updateTbProblemAudit(TbProblemAudit problemAudit);
	
	/**
	 * ͨ����ĿIDɾ����Ŀ
	 */
	public void deleteProblem(int id);

}
