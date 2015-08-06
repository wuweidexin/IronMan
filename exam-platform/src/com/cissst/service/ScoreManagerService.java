package com.cissst.service;

import java.util.List;

import com.cissst.entity.TbExamPaper;
import com.cissst.entity.TbExamPaperAnswer;
import com.cissst.entity.TbExamPlan;

/**
 * @ģ�����ƣ�ScoreManagerAction(�ɼ�����)
 * @�����ˣ�
 * @��          �ܣ�����ScoreManagerAction�����ݿ�����в���
 * @����ʱ�䣺
 */
public interface ScoreManagerService
{
    //�ڳɼ���ѯ�в�ѯ���гɼ�
	public List<TbExamPlan> gradeQuery(int startNumber,int pageSize,String HQL);
	
	//��ҳ���õ����Լƻ���������
	public int getRows(String HQL);
	
//	//��ҳ���õ����Լƻ���������
//	public int getRows();
	
	//������ѯƴ��HQL
	public String joinHql();
	
	//���һ���Լƻ��Ķ���
	public TbExamPlan findPlan(int id);
	
	//�ڿ��Է����в�ѯ����
	public List<TbExamPlan> gradeIssue(int startNumber,int pageSize,String HQL);
	
	//�ڿ��Է����в�ѯһ�����Լƻ�
	public TbExamPlan gradeIssueOne(String epMyselfId);
	
	//�ڿ��������в�ѯ����������
	public List<TbExamPlan> gradeCheck(int startNumber,int pageSize,String HQL);
	
	//�ڳɼ������в�ѯһ����Ҫ���ĵĿ��Լƻ�
	public TbExamPlan gradeCheckList(int id);
	
	//�ڳɼ������и���һ���ƻ���ŵõ�����ƻ���Ҫ���ĵ�������
	public int getRowsCheck(int id);
	
	//�ڿ��������и��ݿ��Լƻ�id��ѯһ���ƻ�
	public TbExamPlan gradeForCheck(int id);
	
	//�ڿ��������и���id��ѯһ���Ծ�
	public TbExamPaper checkPaper(int id);
	
	//����id��ѯһ���Ծ��������
	public TbExamPaperAnswer paperAnswer(int id);
	
	//����ÿ����ɼ�
	public void saveScore(TbExamPaperAnswer paperAnswer);
	
	//�ڿ��Է����и��¼ƻ�
	public void updatePlan(TbExamPlan examPlan);

}
