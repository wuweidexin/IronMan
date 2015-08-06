package com.cissst.service;

import java.util.List;

import com.cissst.entity.TbAuditStatus;
import com.cissst.entity.TbExamScheme;
import com.cissst.entity.TbExamSchemeDetail;
import com.cissst.entity.TbProblem;
import com.cissst.entity.TbProblemDifficultyLevel;
import com.cissst.entity.TbProblemScore;
import com.cissst.entity.TbProblemType;
import com.cissst.entity.TbReadType;
import com.cissst.entity.TbTactics;
import com.cissst.entity.TbTacticsDetail;

/**
 * @ģ�����ƣ�ExamSchemaAction(���Է���)
 * @�����ˣ�
 * @��          �ܣ�����ExamSchemaAction������ҵ���߼�
 * @����ʱ�䣺
 */
public interface ExamSchemaService
{
	
	//�洢����
	public void save(TbTactics tbTactics);
	
	//�洢���ķ�ʽ
	public void saveTbReadType(TbReadType tbReadType);
	
	//�洢��ϸ������
	public void saveSchemeDetail(TbExamSchemeDetail tbExamSchemeDetail);
	
	//�洢������ϸ��
	public void saveDetail(TbTacticsDetail tbTacticsDetail);
	
	//��ѯ����
	public TbTactics TbTacticsfindByHQLQuery(int ID);
	
	//����ȫ��
	public List<TbTactics> findByHQLtbTactics();
	
	//���²���
	public void TbTacticsupdate(TbTactics tbTactics);
	
	//�Զ���ѯ
	public List<?> findByHQLFree();
	
	//������Ŀ
	public void updateTbProblem(TbProblem tbProblem);
	
    //��ѯ��Ŀ
	public List<?> findWithPage(int startNumber,int pageSize);
	
	//��ѯ��Ŀ����Ŀ
	public int getRow();
	
	//ͨ��ID��ѯһ����Ŀ
	public TbProblem findByHQLTbProblem(int ID);
	
	//�洢һ������
	public void saveTbE(TbExamScheme tbExamScheme);
	
	//��ѯ����
	public List<?> findWithPageSchamaPlan(int startNumber,int pageSize);
	
	//��ѯ��������Ŀ
	public int getRowNum();
	
	//ͨ��ID��ѯһ������
	public TbExamScheme findByHQL(int ID);
	
	//��������
	public void update(TbExamScheme tbExamScheme);
	
	//ȫ����Ŀ
	public List<TbProblem> findByHQLtbTbProblem();
	//��ѯ��Ŀ��Χ
	public List<TbProblemScore> TbPrfindByHQLtbScore();
	
	//��ѯ��Ŀ�Ѷ�
	public List<TbProblemDifficultyLevel> TbPrfindByHQLdifficultyLevel();
	
	//��ѯ��Ŀ����
	public List<TbProblemType> findByHQLtbProblemType();
	
	//��ѯ�������״̬
	public List<TbAuditStatus> TbPrfindByHQLtbAuditStatus();
	
	
	//��ѯ���״̬
	public TbAuditStatus findByHQL(String HQ);
	
	
	//��ѯ��Ŀ��Χ
	public TbProblemScore findByHQLtbScore(String HQL);
	
	//��ѯ��Ŀ�Ѷ�
	public TbProblemDifficultyLevel findByHQLdifficultyLevel(String HQL);
	
	//��ѯ��Ŀ����
	public TbProblemType findByHQLtProblemType(String HQL);
	
	//��ѯ��Ŀ����
	public TbAuditStatus findByHQLtbAuditStatus(String HQL);
	
	//������ϸ������
	public void updatetbExamSchemeDetail(TbExamSchemeDetail tbExamSchemeDetail);
}
