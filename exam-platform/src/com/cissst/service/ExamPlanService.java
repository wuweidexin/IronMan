package com.cissst.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cissst.entity.TbClasses;
import com.cissst.entity.TbExamPlan;
import com.cissst.entity.TbExamScheme;
import com.cissst.entity.TbExamSchemeDetail;
import com.cissst.entity.TbPlanStatus;
import com.cissst.entity.TbProblem;
import com.cissst.entity.TbProblemResult;
import com.cissst.entity.TbReadType;
import com.cissst.utils.Pager;


/**
 * @ģ�����ƣ�ExamPlanAction(���Լƻ�)
 * @�����ˣ�
 * @��          �ܣ�����ExamPlanAction������ҵ���߼�
 * @����ʱ�䣺
 */
public interface ExamPlanService
{

	/**
	 * Addҳ��
	 */
	/**
	 * �༶���������б�
	 */
	public List<?> selectClassName();
	/**
	 * ���Է������������б�
	 */
	public List<?> selectExamSchemeName();
	/**
	 * ���Լƻ����������������水ť
	 */
	public void examPlanAddSaveButton(TbExamPlan plan);
	/**
	 * ���ݰ༶������ID
	 */
	public TbClasses findclaID(int Cid);
	/**
	 * ���ݿ��Է���������ID
	 */
	public TbExamScheme findschID(int esId);
	/**
	 * ����ID��ѯ���Է���
	 */
	public TbExamScheme getTbExamScheme(int esId);
	/**
	 * ��ѡ����ѯ
	 */
	public List<TbProblemResult> findTbProblemResult();
	//-------------------------------------------------------------------------//
	/**
	 * Queryҳ�����
	 */
	public String findWithQueryPage(HttpServletRequest request);
	/**
	 * ���ķ�ʽ�����б�
	 */
	public List<?> selectReadType();
	/**
	 * ���Լƻ�״̬�����б�
	 */
	public List<?> selectExamPlanStatus();
	/**
	 * TbExamPlan����
	 * 
	 */
	public TbExamPlan loginExamPlan(int planId);
	/**
	 * ���ķ�ʽ
	 */
	public TbReadType loginReadType(int rtId);
	
	public List<?> seleteReadType();
	//-------------------------------------------------------------------------------//
	/**
	 * Issueҳ�����
	 */
	public String findWithIssuePage(int startNumber, int pageSize);

	/**
	 * Cancelҳ�����
	 */
	public String findWithCancelPage(int startNumber, int pageSize);
	/**
	 * �༶�������
	 */
	public TbClasses loginClassNum(String classNum) ;

	/**
	 * ���Է�����������
	 */
	public TbExamScheme loginExamSchemeName(String examSchemeNum);

	/**
	 * TbProblem��ȫ��
	 */
	public List<?> findWithProblemPage(int startNumber,int pageSize);

	/**
	 * TbProblem����
	 * 
	 */
	public TbProblem loginProblem(int num);

	public TbProblem Problem();

	

	/**
	 * ���Լƻ�������������������ť
	 */
	/**
	 * ���Լƻ�ά�������������水ť
	 */
	public void examPlanUpdate(TbExamPlan del);

	/**
	 * ���Լƻ�������
	 */
	public List<?> selectExamPlanReader();

	
	

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
	 */
	public TbExamSchemeDetail loginSchemeDetail(TbExamScheme scheme);

	//��ÿ��Լƻ�״̬�ķ���
	public	TbPlanStatus getStatus(String str);
	
}

