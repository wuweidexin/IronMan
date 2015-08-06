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
 * @模块名称：ExamSchemaAction(考试方案)
 * @开发人：
 * @功 能：管理ExamSchemaAction的所有业务逻辑
 * @开发时间：
 */
public class ExamSchemaServiceImp implements ExamSchemaService {
	private ExamSchemaDao examSchemaDao;

	// 查询题目难度
	@SuppressWarnings("unchecked")
	public List<TbProblemDifficultyLevel> TbPrfindByHQLdifficultyLevel() {

		return (List<TbProblemDifficultyLevel>) examSchemaDao.findList("from TbProblemDifficultyLevel where pdlDel=0");
	}
	
	//更新题目
	public void updateTbProblem(TbProblem tbProblem) {
		examSchemaDao.update(tbProblem);
		
	}

	// 查询题目类型
	@SuppressWarnings("unchecked")
	public List<TbProblemType> findByHQLtbProblemType() {

		return (List<TbProblemType>) examSchemaDao.findList("from TbProblemType where ptDel=0");
	}
	
	// 查询题目范围
	@SuppressWarnings("unchecked")
	public List<TbProblemScore> TbPrfindByHQLtbScore() {

		return (List<TbProblemScore>) examSchemaDao.findList("from TbProblemScore where psDel=0");
	}

	// 查询题目
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

	
	
	// 通过ID查询一个题目
	public TbProblem findByHQLTbProblem(int ID) {
		String HQL = "from TbProblem where PDel=0 and PId=" + ID;
		System.out.println(HQL);
		return (TbProblem) examSchemaDao.findByHQL(HQL);

	}

	// 题目表的分页查询，即题目数量
	public int getRow() {
		Object object = examSchemaDao
				.findByHQL("select count(*) from TbProblem");
		long tempNumber = (Long) object;
		return (int) tempNumber;

	}

	// 自动查询
	@SuppressWarnings("unchecked")
	public List<?> findByHQLFree() {
		
		StringBuffer sql = new StringBuffer("from TbProblem where PDel=0");
		return  examSchemaDao.findList(sql.toString());

	}
	
	// 存储策略详细表
	public void saveDetail(TbTacticsDetail tbTacticsDetail) {
		
		examSchemaDao.save(tbTacticsDetail);
	}

	// 存储策略
	public void save(TbTactics tbTactics) {

		examSchemaDao.save(tbTactics);

	}
	// 存储批阅方式
	public void saveTbReadType(TbReadType tbReadType) {
		examSchemaDao.save(tbReadType);
	}
	// 存储详细方案表
	public void saveSchemeDetail(TbExamSchemeDetail tbExamSchemeDetail) {
		
		examSchemaDao.save(tbExamSchemeDetail);
	}
	
	
	// 策略查询

	public TbTactics TbTacticsfindByHQLQuery(int ID) {
		String HQL = "from TbTactics where  TDel=0 and TId=" + ID;
		return (TbTactics) examSchemaDao.findByHQL(HQL);
	}
	
	// 策略全查
	@SuppressWarnings("unchecked")
	public List<TbTactics> findByHQLtbTactics() {
		String HQL="from TbTactics where  TDel=0";
		return (List<TbTactics>) examSchemaDao.findList(HQL);
	}
	
	
	// 更新或删除一个策略
	public void TbTacticsupdate(TbTactics tbTactics) {

		examSchemaDao.update(tbTactics);
	}

	// 方案表的分页查询，即方案数量
	public int getRowNum() {
		Object object = examSchemaDao
				.findByHQL("select count(*) from TbExamScheme");
		long temp = (Long) object;
		return (int) temp;
	}

	// 存储一个方案
	public void saveTbE(TbExamScheme tbExamScheme) {
		examSchemaDao.save(tbExamScheme);

	}

	// 查询方案审核状态
	@SuppressWarnings("unchecked")
	public List<TbAuditStatus> TbPrfindByHQLtbAuditStatus() {

		return (List<TbAuditStatus>) examSchemaDao.findList("from TbAuditStatus where asDel=0");
	}

	
	
	
	
	
	
	
	

	// 查询方案
	public List<?> findWithPageSchamaPlan(int startNumber, int pageSize) {

		StringBuffer sql = new StringBuffer("from TbExamScheme where esDel=0");

		// 考试方案编号：
		String examNoSchamaPlan = ServletActionContext.getRequest().getParameter("examNoSchamaPlan");
		// 考试方案名称：
		String examNameSchamaPlan = ServletActionContext.getRequest().getParameter("examNameSchamaPlan");
		// 批阅方式：
		String questionTypeSchamaPlan = ServletActionContext.getRequest().getParameter("questionTypeSchamaPlan");
		// 录入人：
		String examPeopleSchamaPlan = ServletActionContext.getRequest().getParameter("examPeopleSchamaPlan");
		// 状态：
		String examStaticSchamaPlan = ServletActionContext.getRequest().getParameter("examStaticSchamaPlan");
		// 录入日期：
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
		
				sql.append(" and tbExamPlans.tbReadType.rtName like '%"+ "自动批阅" + "%' ");
			}
			if (questionTypeSchamaPlan.equals(2)) {
				
				sql.append(" and tbExamPlans.tbReadType.rtName like '%"+ "老师批阅" + "%' ");
			}

		 }

		
		if (examPeopleSchamaPlan!=null&&examPeopleSchamaPlan!="") {
			sql.append(" and esAddUser like '%" + examPeopleSchamaPlan + "%' ");
		}
		

		if (examStaticSchamaPlan!=null&&examStaticSchamaPlan!="") {
			
			  if (examStaticSchamaPlan.equals(1)) {
		
			        sql.append(" and tbAuditStatus.asName ssslike '%" + "已提交" + "%'");
			
			     }
			 if (examStaticSchamaPlan.equals(2)) {
				
				   sql.append(" and tbAuditStatus.asName like '%" + "已保存" + "%'");
				
				 }
			 if (examStaticSchamaPlan.equals(3)) {
					
					sql.append(" and tbAuditStatus.asName like '%" + "已拒绝" + "%'");
					
			    }	
				
            if (examStaticSchamaPlan.equals(4)) {
				
				   sql.append(" and tbAuditStatus.asName like '%" + "已通过" + "%'");
				
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
	
	
	//查询审核状态
	public TbAuditStatus findByHQL(String HQ) {
		StringBuffer sql = new StringBuffer("from TbAuditStatus where asDel=0");
		 sql.append(" and asName like '%" + HQ + "%'");
		return (TbAuditStatus)examSchemaDao.findByHQL(sql.toString());
	}
		

	// 通过ID查询一个方案

	public TbExamScheme findByHQL(int ID) {
		String HQL = "from TbExamScheme where esDel=0 and esId=" + ID;

		return (TbExamScheme) examSchemaDao.findByHQL(HQL);
	}

	// 方案撤销
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
		// 提交状态
		public TbAuditStatus findByHQLtbAuditStatus(String HQL) {
			StringBuffer sql = new StringBuffer("from TbAuditStatus where asDel=0");
			 sql.append(" and asName like '%" + HQL + "%'");
			return (TbAuditStatus)examSchemaDao.findByHQL(sql.toString());
		}
         //更新方案表
		public void updatetbExamSchemeDetail(TbExamSchemeDetail tbExamSchemeDetail) {
			
			examSchemaDao.update(tbExamSchemeDetail);
		}


		
	}


	

	


	


	




	






	

	
