package com.cissst.iService;

import java.util.HashSet;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cissst.dao.ExamSchemaDao;
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
import com.cissst.iDao.ExamSchemaDaoImp;
import com.cissst.service.ExamSchemaService;

/**
 * @ģ�����ƣ�ExamSchemaAction(���Է���)
 * @�����ˣ�
 * @�� �ܣ�����ExamSchemaAction������ҵ���߼�
 * @����ʱ�䣺
 */
public class ExamSchemaServiceImp implements ExamSchemaService {
	private ExamSchemaDao examSchemaDao;

	// ��ѯ��Ŀ�Ѷ�
	@SuppressWarnings("unchecked")
	public List<TbProblemDifficultyLevel> TbPrfindByHQLdifficultyLevel() {

		return (List<TbProblemDifficultyLevel>) examSchemaDao.findList("from TbProblemDifficultyLevel where pdlDel=0");
	}
	
	//������Ŀ
	public void updateTbProblem(TbProblem tbProblem) {
		examSchemaDao.update(tbProblem);
		
	}

	// ��ѯ��Ŀ����
	@SuppressWarnings("unchecked")
	public List<TbProblemType> findByHQLtbProblemType() {

		return (List<TbProblemType>) examSchemaDao.findList("from TbProblemType where ptDel=0");
	}
	
	// ��ѯ��Ŀ��Χ
	@SuppressWarnings("unchecked")
	public List<TbProblemScore> TbPrfindByHQLtbScore() {

		return (List<TbProblemScore>) examSchemaDao.findList("from TbProblemScore where psDel=0");
	}

	// ��ѯ��Ŀ
	@SuppressWarnings("unchecked")
	public List<?> findWithPage(int startNumber, int pageSize) {

		StringBuffer sql = new StringBuffer("from TbProblem where PDel=0");
		
		String examNo = ServletActionContext.getRequest().getParameter("examNo");
		String quesName = ServletActionContext.getRequest().getParameter("quesName");
		String examTimeStart = ServletActionContext.getRequest().getParameter("examTimeStart");
		String examTimeEnd = ServletActionContext.getRequest().getParameter("examTimeEnd");
		System.out.println(examNo);
		System.out.println(quesName);
		System.out.println(examTimeStart);
		System.out.println(examTimeStart);
		
		
		System.out.println(examTimeEnd);
		if (examNo!= null&&examNo!="") {
			sql.append(" and col1 like '%" + examNo.trim() + "%'");
		}

		if (quesName!=null&&quesName!="") {
			sql.append(" and tbUser.UName like '%" + quesName + "%'");
		}

		if ((examTimeStart!=null&&examTimeStart!="")
				&& (examTimeEnd!=null&&examTimeEnd!="")) {

			sql.append(" and PAddTime >= '" + examTimeStart
					+ "' and PAddTime <= '" + examTimeEnd + "'");

		}
		System.out.println(sql);
		return examSchemaDao.findWithPage(startNumber, pageSize, sql.toString());
	}

	@SuppressWarnings("unchecked")
	public List<TbProblem> findByHQLtbTbProblem() {
		
		return (List<TbProblem>) examSchemaDao.findList("from TbProblem where PDel=0 and col3='1'");
	}

	
	
	// ͨ��ID��ѯһ����Ŀ
	public TbProblem findByHQLTbProblem(int ID) {
		String HQL = "from TbProblem where PDel=0 and PId=" + ID;
		System.out.println(HQL);
		return (TbProblem) examSchemaDao.findByHQL(HQL);

	}

	// ��Ŀ��ķ�ҳ��ѯ������Ŀ����
	public int getRow() {
		Object object = examSchemaDao
				.findByHQL("select count(*) from TbProblem");
		long tempNumber = (Long) object;
		return (int) tempNumber;

	}

	// �Զ���ѯ
	@SuppressWarnings("unchecked")
	public List<?> findByHQLFree() {
		
		StringBuffer sql = new StringBuffer("from TbProblem where PDel=0");
		return  examSchemaDao.findList(sql.toString());

	}
	
	// �洢������ϸ��
	public void saveDetail(TbTacticsDetail tbTacticsDetail) {
		
		examSchemaDao.save(tbTacticsDetail);
	}

	// �洢����
	public void save(TbTactics tbTactics) {

		examSchemaDao.save(tbTactics);

	}
	// �洢���ķ�ʽ
	public void saveTbReadType(TbReadType tbReadType) {
		examSchemaDao.save(tbReadType);
	}
	// �洢��ϸ������
	public void saveSchemeDetail(TbExamSchemeDetail tbExamSchemeDetail) {
		
		examSchemaDao.save(tbExamSchemeDetail);
	}
	
	
	// ���Բ�ѯ

	public TbTactics TbTacticsfindByHQLQuery(int ID) {
		String HQL = "from TbTactics where  TDel=0 and TId=" + ID;
		return (TbTactics) examSchemaDao.findByHQL(HQL);
	}
	
	// ����ȫ��
	@SuppressWarnings("unchecked")
	public List<TbTactics> findByHQLtbTactics() {
		String HQL="from TbTactics where  TDel=0";
		return (List<TbTactics>) examSchemaDao.findList(HQL);
	}
	
	
	// ���»�ɾ��һ������
	public void TbTacticsupdate(TbTactics tbTactics) {

		examSchemaDao.update(tbTactics);
	}

	// ������ķ�ҳ��ѯ������������
	public int getRowNum() {
		Object object = examSchemaDao
				.findByHQL("select count(*) from TbExamScheme");
		long temp = (Long) object;
		return (int) temp;
	}

	// �洢һ������
	public void saveTbE(TbExamScheme tbExamScheme) {
		examSchemaDao.save(tbExamScheme);

	}

	// ��ѯ�������״̬
	@SuppressWarnings("unchecked")
	public List<TbAuditStatus> TbPrfindByHQLtbAuditStatus() {

		return (List<TbAuditStatus>) examSchemaDao.findList("from TbAuditStatus where asDel=0");
	}

	
	
	
	
	
	
	
	

	// ��ѯ����
	public List<?> findWithPageSchamaPlan(int startNumber, int pageSize) {

		StringBuffer sql = new StringBuffer("from TbExamScheme where esDel=0");

		// ���Է�����ţ�
		String examNoSchamaPlan = ServletActionContext.getRequest().getParameter("examNoSchamaPlan");
		// ���Է������ƣ�
		String examNameSchamaPlan = ServletActionContext.getRequest().getParameter("examNameSchamaPlan");
		// ���ķ�ʽ��
		String questionTypeSchamaPlan = ServletActionContext.getRequest().getParameter("questionTypeSchamaPlan");
		// ¼���ˣ�
		String examPeopleSchamaPlan = ServletActionContext.getRequest().getParameter("examPeopleSchamaPlan");
		// ״̬��
		String examStaticSchamaPlan = ServletActionContext.getRequest().getParameter("examStaticSchamaPlan");
		// ¼�����ڣ�
		String examTimeStartSchamaPlan = ServletActionContext.getRequest().getParameter("examTimeStartSchamaPlan");
		String examTimeEndSchamaPlan = ServletActionContext.getRequest().getParameter("examTimeEndSchamaPlan");
		
		if (examNoSchamaPlan!=null&& examNoSchamaPlan!="") {
			sql.append(" and esMyselfId like '%" + examNoSchamaPlan + "%' ");
		}

		if (examNameSchamaPlan!= null&& examNameSchamaPlan!="") {
			sql.append(" and esName like '%" + examNameSchamaPlan + "%' ");
		}

	
		if (questionTypeSchamaPlan!=null&&questionTypeSchamaPlan!="") {

			if (questionTypeSchamaPlan.equals(1)) {
		
				sql.append(" and tbExamPlans.tbReadType.rtName like '%"+ "�Զ�����" + "%' ");
			}
			if (questionTypeSchamaPlan.equals(2)) {
				
				sql.append(" and tbExamPlans.tbReadType.rtName like '%"+ "��ʦ����" + "%' ");
			}

		 }

		
		if (examPeopleSchamaPlan!=null&&examPeopleSchamaPlan!="") {
			sql.append(" and esAddUser like '%" + examPeopleSchamaPlan + "%' ");
		}
		

		if (examStaticSchamaPlan!=null&&examStaticSchamaPlan!="") {
			
			  if (examStaticSchamaPlan.equals(1)) {
		
			        sql.append(" and tbAuditStatus.asName ssslike '%" + "���ύ" + "%'");
			
			     }
			 if (examStaticSchamaPlan.equals(2)) {
				
				   sql.append(" and tbAuditStatus.asName like '%" + "�ѱ���" + "%'");
				
				 }
			 if (examStaticSchamaPlan.equals(3)) {
					
					sql.append(" and tbAuditStatus.asName like '%" + "�Ѿܾ�" + "%'");
					
			    }	
				
            if (examStaticSchamaPlan.equals(4)) {
				
				   sql.append(" and tbAuditStatus.asName like '%" + "��ͨ��" + "%'");
				
				}	
			
			
		}

	
		
		if ((examTimeStartSchamaPlan!=null&&examTimeStartSchamaPlan!="")
				&& (examTimeEndSchamaPlan!=null&&examTimeEndSchamaPlan!="")) {

			sql.append(" and esAddTime >= '" + examTimeStartSchamaPlan
					+ "' and esAddTime <= '" + examTimeEndSchamaPlan + "'");

		}
		System.out.println(sql);
		return examSchemaDao.findWithPage(startNumber, pageSize, sql.toString());
	
	}
	
	
	//��ѯ���״̬
	public TbAuditStatus findByHQL(String HQ) {
		StringBuffer sql = new StringBuffer("from TbAuditStatus where asDel=0");
		 sql.append(" and asName like '%" + HQ + "%'");
		return (TbAuditStatus)examSchemaDao.findByHQL(sql.toString());
	}
		

	// ͨ��ID��ѯһ������

	public TbExamScheme findByHQL(int ID) {
		String HQL = "from TbExamScheme where esDel=0 and esId=" + ID;

		return (TbExamScheme) examSchemaDao.findByHQL(HQL);
	}

	// ��������
	public void update(TbExamScheme tbExamScheme) {

		examSchemaDao.update(tbExamScheme);
	}
	
	
	
 
		public TbProblemDifficultyLevel findByHQLdifficultyLevel(String HQL) {
			StringBuffer sql = new StringBuffer("from TbProblemDifficultyLevel where pdlDel=0");
			 sql.append(" and pdlName like '%" + HQL + "%'");
			return (TbProblemDifficultyLevel)examSchemaDao.findByHQL(sql.toString());
		}

		public TbProblemType findByHQLtProblemType(String HQL) {
			StringBuffer sql = new StringBuffer("from TbProblemType where ptDel=0");
			 sql.append(" and ptName like '%" + HQL + "%'");
			return (TbProblemType)examSchemaDao.findByHQL(sql.toString());
		}

		public TbProblemScore findByHQLtbScore(String HQL) {
			StringBuffer sql = new StringBuffer("from TbProblemScore where psDel=0");
			 sql.append(" and psName like '%" + HQL + "%'");
			return (TbProblemScore)examSchemaDao.findByHQL(sql.toString());
		}


		public ExamSchemaDao getExamSchemaDao()
		{
			return examSchemaDao;
		}

		public void setExamSchemaDao(ExamSchemaDao examSchemaDao)
		{
			this.examSchemaDao = examSchemaDao;
		}
		// �ύ״̬
		public TbAuditStatus findByHQLtbAuditStatus(String HQL) {
			StringBuffer sql = new StringBuffer("from TbAuditStatus where asDel=0");
			 sql.append(" and asName like '%" + HQL + "%'");
			return (TbAuditStatus)examSchemaDao.findByHQL(sql.toString());
		}
         //���·�����
		public void updatetbExamSchemeDetail(TbExamSchemeDetail tbExamSchemeDetail) {
			
			examSchemaDao.update(tbExamSchemeDetail);
		}


		
	}


	

	


	


	




	






	

	
