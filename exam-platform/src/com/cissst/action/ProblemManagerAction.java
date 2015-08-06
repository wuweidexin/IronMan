package com.cissst.action;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.cissst.entity.TbAuditStatus;
import com.cissst.entity.TbProblem;
import com.cissst.entity.TbProblemAudit;
import com.cissst.entity.TbProblemDifficultyLevel;
import com.cissst.entity.TbProblemResult;
import com.cissst.entity.TbProblemScore;
import com.cissst.entity.TbProblemType;
import com.cissst.entity.TbUser;
import com.cissst.service.ProblemManagerService;
import com.cissst.utils.NumberUtil;
import com.cissst.utils.Pager;
import com.cissst.utils.PagerHelper;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @ģ�����ƣ�ProblemManagerAction(������)
 * @�����ˣ���ѧ
 * @��          �ܣ�
 * @����ʱ�䣺
 */
public class ProblemManagerAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private ProblemManagerService PMService;
	private TbProblem tbProblem;
	private TbAuditStatus tbAuditStatus;
	private TbProblemType tbProblemType;
	private TbProblemScore tbProblemScore;
	private TbProblemDifficultyLevel proDiffLevel;
	private TbProblemResult tbProblemResult; 
	private TbUser tbUser;
	private TbProblemAudit tbProblemAudit;
	private NumberUtil numberUtil;
	private IndexPageAction indexPageAction;
	
	public IndexPageAction getIndexPageAction() {
		return indexPageAction;
	}

	public void setIndexPageAction(IndexPageAction indexPageAction) {
		this.indexPageAction = indexPageAction;
	}

	/**
	 * �����ҳ��
	 * @return
	 */
	public String quesLibAdd() {
		this.findProTypeScoDiffLev();
		return "quesLibAdd";
	}

	/**
	 * ��ѯ�������͡���Χ���Ѷȵȼ�
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findProTypeScoDiffLev() {

		List proTypeList = PMService.findProblemType();
		ServletActionContext.getRequest().setAttribute("proTypeList",proTypeList);

		List ProScopeList = PMService.findProblemScore();
		ServletActionContext.getRequest().setAttribute("ProScopeList", ProScopeList);

		List proDiffLevList = PMService.findProblemDifficultyLevel();
		ServletActionContext.getRequest().setAttribute("proDiffLevList", proDiffLevList);
		return "";
	}

	/**
	 * ���quesLibAdd��nextʱִ�еĴ�ֵ����
	 * @return
	 */
	public String nextOutPut() {
		//��ȡ��Ŀ���
		String problemNum =numberUtil.getProblemNo();
		String temp = problemNum;
		tbProblem.setCol1(problemNum);

		//��ȡ��Ŀ����
		int ptId = Integer.valueOf(ServletActionContext.getRequest().getParameter("ptId"));
		tbProblemType.setPtId(ptId);
		tbProblem.setTbProblemType(tbProblemType);

		//��ȡ��Ŀ��Χ
		int psId = Integer.valueOf(ServletActionContext.getRequest().getParameter("psId"));
		tbProblemScore.setPsId(psId);
		tbProblem.setTbProblemScore(tbProblemScore);

		//��ȡ��Ŀ�Ѷȵȼ�
		int pdlId = Integer.valueOf(ServletActionContext.getRequest().getParameter("pdlId"));
		proDiffLevel.setPdlId(pdlId);
		tbProblem.setTbProblemDifficultyLevel(proDiffLevel);

		//�����Ŀ��¼��ʱ��(����ǰ��ϵͳʱ��)
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String addTime = format.format(d);
		System.out.println(addTime);
		tbProblem.setPAddTime(addTime);

		//���¼����
		TbUser user = (TbUser) ServletActionContext.getRequest().getSession().getAttribute("user");
		//����ʱӦ���޸��ⲿ������
		tbProblem.setTbUser(user);

		//��Ŀ����״̬
		tbProblem.setPDel("0");

		

		PMService.saveProblem(tbProblem);

		TbProblem tbProblem = PMService.findTbProblem(temp);

		ServletActionContext.getRequest().setAttribute("tbProblem", tbProblem);
		return "quesLibAdd2";

	}

	/**
	 * ���������ҳ
	 */
	public String returnQuesLibAdd() {
		this.findProTypeScoDiffLev();
		return "quesLibAdd";
	}

	/**
	 * ��ֵ��ת��QuesLibAdd3ҳ��
	 */
	public String transeferQuesLibAdd3() {

		//��ȡ��Ŀid
		int id = Integer.valueOf(ServletActionContext.getRequest().getParameter("pId"));
		int temp = id;
		System.out.println(id);
		//�����Ŀ
		TbProblem tbProblem =  PMService.getTbProblem(id);
		String pTitle = ServletActionContext.getRequest().getParameter("question");
		if(pTitle != null && pTitle != "") {
			tbProblem.setPTitle(pTitle);
			PMService.updateProblem(tbProblem);
		}
		TbProblem tbProblem2 = PMService.getTbProblem(temp);
		ServletActionContext.getRequest().setAttribute("tbProblem2", tbProblem2);
		return "quesLibAdd3";	
	}

	/**
	 * ��Ӵ�
	 */
	public String addNewResult() {

		String  pId = ServletActionContext.getRequest().getParameter("pId"); 
		String pId_2 = ServletActionContext.getRequest().getParameter("pId_2"); 
		if(pId != "" && pId != null) {
			int id = Integer.parseInt(pId);
			TbProblem tbProblem = PMService.getTbProblem(id);


			//��ȡ������
			String resultContent = ServletActionContext.getRequest().getParameter("quesAnswer");
			tbProblemResult.setPrContent(resultContent);

			//���ô𰸴���״̬
			tbProblemResult.setPrDel("0");

			//���ô���ȷ��־
			tbProblemResult.setPrTrueIdent("0");
			tbProblemResult.setTbProblem(tbProblem);
			PMService.saveResult(tbProblemResult);

		} else {
			int id = Integer.parseInt(pId_2);
			TbProblem tbProblem = PMService.getTbProblem(id);
			tbProblemResult.setTbProblem(tbProblem);

			//��ȡ������
			String resultContent = ServletActionContext.getRequest().getParameter("quesAnswer");
			tbProblemResult.setPrContent(resultContent);

			//���ô𰸴���״̬
			tbProblemResult.setPrDel("0");

			//���ô���ȷ��־
			tbProblemResult.setPrTrueIdent("0");
			PMService.saveResult(tbProblemResult);
		}

		if(pId != "" && pId != null) {
			return this.transeferQuesLibAdd3();
		} else {
			return this.transeferQuesLibAdd3_2();
		}
	}

	/**
	 * ���ұ��α༭����Ŀ������Ŀ�Ĵ𰸷��͵�����ҳ��quesLibAdd4
	 */
	public String findProblemAndResult() {

		//���ұ��α༭����Ŀ
		int id = Integer.valueOf(ServletActionContext.getRequest().getParameter("pId")); 
		TbProblem tbProblem = PMService.getTbProblem(id);
		ServletActionContext.getRequest().setAttribute("tbProblem", tbProblem);

		//ͨ����ĿId��ѯ����Ŀ�Ĵ�
		List<?> resultId = PMService.getResultId(id);

		List<TbProblemResult> list0 = new ArrayList<TbProblemResult>();
		List<TbProblemResult> list1 = new ArrayList<TbProblemResult>();
		//�жϷ��صĴ�Id�Ƿ�Ϊ�գ���������������
		if(resultId != null ){
			for(int i=0; i<resultId.size();i++) {
				Object obj =resultId.get(i);
				int id1= (Integer)obj;
				TbProblemResult tbProblemResult = PMService.getProResult(id1);
				String str = tbProblemResult.getPrTrueIdent();
				if(str.equalsIgnoreCase("0") ) {
					list0.add(tbProblemResult);
				} else {
					list1.add(tbProblemResult);
				}
			}
		}
		ServletActionContext.getRequest().setAttribute("list0", list0);
		ServletActionContext.getRequest().setAttribute("list1", list1);


		return "quesLibAdd4";
	}

	/**
	 * ɾ����
	 * @return
	 */
	public String deleteProResult() {

		//��ȡҪɾ������Ŀ��Id
		String[] correctResults = (String[]) ServletActionContext.getRequest().getParameterValues("results");
		for(int i=0;i<correctResults.length;i++){
			int cr = Integer.parseInt(correctResults[i]);
			PMService.deleteProResult(cr);
		}

		//���Ҳ���ʾδɾ����
		String da_id = ServletActionContext.getRequest().getParameter("daf_id"); 
		String dq_id = ServletActionContext.getRequest().getParameter("daf_id");
		if (da_id != "" && da_id != null) {
			int id = Integer.parseInt(da_id);
			//ͨ����ĿId��ѯ����Ŀ�Ĵ�
			List<?> resultId = PMService.getResultId(id);

			List<TbProblemResult> list0 = new ArrayList<TbProblemResult>();
			List<TbProblemResult> list1 = new ArrayList<TbProblemResult>();
			//�жϷ��صĴ�Id�Ƿ�Ϊ�գ���������������
			if(resultId != null ){
				for(int i=0; i<resultId.size();i++) {
					Object obj =resultId.get(i);
					int id1= (Integer)obj;
					TbProblemResult tbProblemResult = PMService.getProResult(id1);
					String str = tbProblemResult.getPrTrueIdent();
					if(str.equalsIgnoreCase("0") ) {
						list0.add(tbProblemResult);
					} else {
						list1.add(tbProblemResult);
					}
				}
			}
			ServletActionContext.getRequest().setAttribute("list0", list0);
			ServletActionContext.getRequest().setAttribute("list1", list1);
		} else {
			int id = Integer.parseInt(dq_id);
			//ͨ����ĿId��ѯ����Ŀ�Ĵ�
			List<?> resultId = PMService.getResultId(id);

			List<TbProblemResult> list0 = new ArrayList<TbProblemResult>();
			List<TbProblemResult> list1 = new ArrayList<TbProblemResult>();
			//�жϷ��صĴ�Id�Ƿ�Ϊ�գ���������������
			if(resultId != null ){
				for(int i=0; i<resultId.size();i++) {
					Object obj =resultId.get(i);
					int id1= (Integer)obj;
					TbProblemResult tbProblemResult = PMService.getProResult(id1);
					String str = tbProblemResult.getPrTrueIdent();
					if(str.equalsIgnoreCase("0") ) {
						list0.add(tbProblemResult);
					} else {
						list1.add(tbProblemResult);
					}
				}
			}
			ServletActionContext.getRequest().setAttribute("list0", list0);
			ServletActionContext.getRequest().setAttribute("list1", list1);
		}
	
		if (da_id != "" && da_id != null) {
			return "quesLibAdd4";
		} else {
			return "quesLibQuery2";
		}

		
	}

	/**
	 * �༭�����Լ�ѡ����ȷ��
	 * @return
	 */
	public String saveProblem() {
		//���ĳ����Ŀ��Id

		String  pId = ServletActionContext.getRequest().getParameter("pId"); 
		String pId_2 = ServletActionContext.getRequest().getParameter("pId_2"); 
		if(pId != "" && pId != null) {
			int id = Integer.parseInt(pId);
			//������ĳ������ȷ��ʱ�Ƚ����д���ȷ��־��Ϊ"0"
			List<?> resultIdList = PMService.getResultId(id);
			for(int i=0; i<resultIdList.size();i++) {
				Object id1 = resultIdList.get(i);
				int resultId= (Integer)id1;
				TbProblemResult result =  PMService.getProResult(resultId);
				result.setPrTrueIdent("0");
				PMService.updateResult(result);
			}

			//���ѡ�д𰸵�Id��������ȷ��־Ϊ"1"
			String[] correctResults = (String[]) ServletActionContext.getRequest().getParameterValues("results");
			for(int i=0;i<correctResults.length;i++){
				int cr = Integer.parseInt(correctResults[i]);
				TbProblemResult tbProblemResult = PMService.getProResult(cr);
				//��ֹ�ظ��ύʱ��ɳ������
				String str = tbProblemResult.getPrTrueIdent();
				if(str != "1"){
					tbProblemResult.setPrTrueIdent("1");
				}
				PMService.updateResult(tbProblemResult);
			}

			//�����Ŀ�����µ����ݿ�
			TbProblem   tbProblem = PMService.getTbProblem(id);
			String pTitle = ServletActionContext.getRequest().getParameter("question");
			if(pTitle != null) {
				tbProblem.setPTitle(pTitle);
			}

			//������Ŀ���״̬
			TbAuditStatus tbAuditStatus = PMService.findTbAuditStatus("�ѱ���");
			tbProblem.setTbAuditStatus(tbAuditStatus);

			PMService.updateProblem(tbProblem);
			this.findProblemAndResult();
		} else {
			int id = Integer.parseInt(pId_2);
			//������ĳ������ȷ��ʱ�Ƚ����д���ȷ��־��Ϊ"0"
			List<?> resultIdList = PMService.getResultId(id);
			for(int i=0; i<resultIdList.size();i++) {
				Object id1 = resultIdList.get(i);
				int resultId= (Integer)id1;
				TbProblemResult result =  PMService.getProResult(resultId);
				result.setPrTrueIdent("0");
				PMService.updateResult(result);
			}

			//���ѡ�д𰸵�Id��������ȷ��־Ϊ"1"
			String[] correctResults = (String[]) ServletActionContext.getRequest().getParameterValues("results");
			for(int i=0;i<correctResults.length;i++){
				int cr = Integer.parseInt(correctResults[i]);
				TbProblemResult tbProblemResult = PMService.getProResult(cr);
				//��ֹ�ظ��ύʱ��ɳ������
				String str = tbProblemResult.getPrTrueIdent();
				if(str != "1"){
					tbProblemResult.setPrTrueIdent("1");
				}
				PMService.updateResult(tbProblemResult);
			}

			//�����Ŀ�����µ����ݿ�
			TbProblem   tbProblem = PMService.getTbProblem(id);
			String pTitle = ServletActionContext.getRequest().getParameter("question");
			if(pTitle != null) {
				tbProblem.setPTitle(pTitle);
			}

			//�����Ŀ��Χ��������Ŀ
			String psId = ServletActionContext.getRequest().getParameter("psId");
			if(psId != "" && psId != null) {
				int id1 = Integer.parseInt(psId);
				TbProblemScore scope = PMService.getProblemScore(id1);
				tbProblem.setTbProblemScore(scope);
			}

			//�����Ŀ�ѶȲ�������Ŀ
			String pdlId = ServletActionContext.getRequest().getParameter("pdlId");
			if(pdlId != "" && pdlId != null) {
				int id1 = Integer.parseInt(pdlId);
				TbProblemDifficultyLevel level = PMService.getProblemDifficultyLevel(id1);
				tbProblem.setTbProblemDifficultyLevel(level);
			}

			//������Ŀ���״̬
			TbAuditStatus tbAuditStatus = PMService.findTbAuditStatus("�ѱ���");
			tbProblem.setTbAuditStatus(tbAuditStatus);

			PMService.updateProblem(tbProblem);
			this.findProblemAndResult();
		}

		if(pId != "" && pId != null) {
			return "quesLibAdd4";
		} else {
			return "quesLibQuery2";
		}



	}















	/**
	 * �û�����ύʱ���ø÷���
	 */
	public String submitQuestion() {
		
		//���ĳ����Ŀ��Id
		String  pId = ServletActionContext.getRequest().getParameter("pId");
		String p_Id2 = ServletActionContext.getRequest().getParameter("p_Id2");
		if(pId != "" && pId != null) {
			int id = Integer.parseInt(pId);
			TbProblem tbProblem = PMService.getTbProblem(id);
			tbAuditStatus = PMService.findTbAuditStatus("���ύ");
			tbProblem.setTbAuditStatus(tbAuditStatus);
			PMService.updateProblem(tbProblem);
			this.quesLibAdd();
		} else {
			int id = Integer.parseInt(p_Id2);
			
			//������Ŀ״̬
			TbProblem tbProblem = PMService.getTbProblem(id);
			tbAuditStatus = PMService.findTbAuditStatus("���ύ");
			tbProblem.setTbAuditStatus(tbAuditStatus);
			PMService.updateProblem(tbProblem);
			
			//���������������Ŀ����Ӧ��ɾ������������
			TbProblemAudit audit = PMService.findTbProblemAudit(id);
			if(audit != null) {
			audit.setPaDel("1");
			PMService.updateTbProblemAudit(audit);
			}
		}
		
		if(pId != "" && pId != null) {
			return "quesLibAdd";
		} else {
			return "quesLibQuery";
		}
		
	}

	/**
	 * ��ת��quesLibQueryҳ��
	 * ��ҳ����findWithPage()
	 * ִ��ȫ�鼰��ҳ
	 */	
	public String quesLibQuery() {

		HttpServletRequest request = ServletActionContext.getRequest();
		String newHQL = (String) ServletActionContext.getRequest().getParameter("newHQL");
		String HQL = null;
		//��newHQLΪ��Ϊnullʱ���������µĲ�ѯ������ƴдSQL
		if(newHQL != null) {
			HQL = PMService.checkHQL(request);
		}
	
		else {
			HQL =(String) request.getSession().getAttribute("HQL");
		}

		int totalRows = PMService.getRows(HQL);

		//����ҳ������ǰҳ������ǰ̨
		Pager pager = PagerHelper.getPager(ServletActionContext.getRequest(), totalRows);
		ServletActionContext.getRequest().setAttribute("totalPages", pager.getTotalPages());
		ServletActionContext.getRequest().setAttribute("currentPage", pager.getCurrentPage());

		List<?> problemList = PMService.findWithPage(pager, HQL);
		ServletActionContext.getRequest().setAttribute("problemList", problemList);

		this.findProTypeScoDiffLev();
		List<?> auditStatusList = PMService.findTbAuditStatusList();
		ServletActionContext.getRequest().setAttribute("auditStatusList", auditStatusList);
		
		return "quesLibQuery";
		
	}

	public String quesLibQuery2() {
		//���ҽ�Ҫά������Ŀ
		String proNum = ServletActionContext.getRequest().getParameter("proNum");
		TbProblem tbProblem = PMService.findTbProblem(proNum);
		ServletActionContext.getRequest().setAttribute("tbProblem", tbProblem);

		//��ʾ��Ŀ���͡���Χ���Ѷȵȼ�
		this.findProTypeScoDiffLev();

		//ͨ����ĿId��ѯ����Ŀ�Ĵ�
		int pId = tbProblem.getPId();
		List<?> resultId = PMService.getResultId(pId);

		List<TbProblemResult> list0 = new ArrayList<TbProblemResult>();
		List<TbProblemResult> list1 = new ArrayList<TbProblemResult>();
		//�жϷ��صĴ�Id�Ƿ�Ϊ�գ���������������
		if(resultId != null ){
			for(int i=0; i<resultId.size();i++) {
				Object obj =resultId.get(i);
				int id= (Integer)obj;
				TbProblemResult tbProblemResult = PMService.getProResult(id);
				String str = tbProblemResult.getPrTrueIdent();
				if(str.equalsIgnoreCase("0") ) {
					list0.add(tbProblemResult);
				} else {
					list1.add(tbProblemResult);
				}
			}
		}
		ServletActionContext.getRequest().setAttribute("list0", list0);
		ServletActionContext.getRequest().setAttribute("list1", list1);

		//��ѯ��������(������ĿId)
		TbProblemAudit tbProblemAudit =PMService.findTbProblemAudit(pId);
		if(tbProblemAudit != null) {
			ServletActionContext.getRequest().setAttribute("tbProblemAudit", tbProblemAudit);
		}

		return "quesLibQuery2";
	}

	//ά����Ŀʱ��ת��quesLibAdd3ҳ��
	public String transeferQuesLibAdd3_2() {
		int pId_2 = Integer.parseInt(ServletActionContext.getRequest().getParameter("pId_2"));
		TbProblem tbProblem = PMService.getTbProblem(pId_2);
		ServletActionContext.getRequest().setAttribute("tbProblem", tbProblem);
		return "quesLibAdd3_2";

	}

	/**
	 * ɾ����Ŀ(ɾ����Ŀ��صĴ𰸣��Լ���������)
	 */
	public String deleteProblem () {
		String p_Id2 = ServletActionContext.getRequest().getParameter("p_Id2");
		if(p_Id2 != "" && p_Id2 != null) {
			int id = Integer.parseInt(p_Id2);
			PMService.deleteProblem(id);
			
			//ɾ�������
			List<?> resultIds = PMService.getResultId(id);
			if( resultIds != null) {
				for(int i=0; i<resultIds.size();i++) {
					Object obj = resultIds.get(i);
					long id_1 = (Long)obj;
					int id_2 = (int) id_1;
					PMService.deleteProResult(id_2);
				}
			}
			
			//ɾ����������
			TbProblemAudit audit = PMService.findTbProblemAudit(id);
			if(audit != null) {
				audit.setPaDel("1");
				PMService.updateTbProblemAudit(audit);
			}
			
		}
		this.quesLibQuery();
		return "quesLibQuery";
		
	}
	



























	/**
	 * ��ת��quesLibAuditҳ��
	 * 
	 * ��ҳ����findWithPage()
	 * ִ��ȫ�鼰��ҳ
	 */	
	public String quesLibAudit() {

		HttpServletRequest request = ServletActionContext.getRequest();
		String newHQL = (String) ServletActionContext.getRequest().getParameter("newHQL");
		String HQL = null;
		//��newHQLΪ��Ϊnullʱ���������µĲ�ѯ������ƴдSQL
		if(newHQL != null) {
			HQL = PMService.AuditHQL(request);
		} else {
			HQL = (String) request.getSession().getAttribute("HQLs");
			//����ȣѣ�Ϊ��˵���Ǵ���ҳ���÷���ִ�еģ�����Ҫ����ҳ�ķ�������
			if(HQL == null)
			{
				return indexPageAction.jwzrFindProblem();
			}
		}

		int totalRows = PMService.getRows(HQL);

		//����ҳ������ǰҳ������ǰ̨
		Pager pager = PagerHelper.getPager(ServletActionContext.getRequest(), totalRows);
		ServletActionContext.getRequest().setAttribute("totalPages", pager.getTotalPages());
		ServletActionContext.getRequest().setAttribute("currentPage", pager.getCurrentPage());

		List<?> problemList = PMService.findWithPage(pager, HQL);
		ServletActionContext.getRequest().setAttribute("problemList", problemList);

		this.findProTypeScoDiffLev();
		return "quesLibAudit";
	}

	/**
	 * ͨ����Ŀ��Ų����Ŀ����������ҳ��(quesLibAudit2)
	 */
	public String quesLibAudit2() {
		//���ҵ���Ŀ(ͨ����Ŀ���)
		String pNO = ServletActionContext.getRequest().getParameter("pNO");
		TbProblem tbProblem = PMService.findTbProblem(pNO);
		int pId = tbProblem.getPId();
		ServletActionContext.getRequest().setAttribute("tbProblem", tbProblem);

		//ͨ����ĿId��ѯ����Ŀ�Ĵ�
		List<?> resultId = PMService.getResultId(pId);

		List<TbProblemResult> list0 = new ArrayList<TbProblemResult>();
		List<TbProblemResult> list1 = new ArrayList<TbProblemResult>();
		//�жϷ��صĴ�Id�Ƿ�Ϊ�գ���������������
		if(resultId != null ){
			for(int i=0; i<resultId.size();i++) {
				Object obj =resultId.get(i);
				int id= (Integer)obj;
				TbProblemResult tbProblemResult = PMService.getProResult(id);
				String str = tbProblemResult.getPrTrueIdent();
				if(str.equalsIgnoreCase("0") ) {
					list0.add(tbProblemResult);
				} else {
					list1.add(tbProblemResult);
				}
			}
		}
		ServletActionContext.getRequest().setAttribute("list0", list0);
		ServletActionContext.getRequest().setAttribute("list1", list1);
		return "quesLibAudit2";
	}

	/**
	 * ���������� (���ͨ��)
	 * @return
	 */
	public String toPassAudit () {


		//������˵���Ŀ
		int pId = Integer.parseInt(ServletActionContext.getRequest().getParameter("pId"));
		TbProblem problem = PMService.getTbProblem(pId);
		tbProblemAudit.setTbProblem(problem);

		//�����                        ����ʱӦ���޸��ⲿ������
		
		TbUser user = (TbUser)ServletActionContext.getRequest().getSession().getAttribute("user");
		tbProblemAudit.setTbUser(user);

		//���ʱ��(����ǰ��ϵͳʱ��)
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String auditTime = format.format(d);
		tbProblemAudit.setPaTime(auditTime);

		//������
		String auditAdvice = ServletActionContext.getRequest().getParameter("auditAdvice");
		System.out.println(auditAdvice);
		tbProblemAudit.setPaComplaint(auditAdvice);

		//����״̬(���ڻ����ѱ�ɾ��)
		tbProblemAudit.setPaDel("0");
		TbAuditStatus tbAuditStatus = PMService.findTbAuditStatus("��ͨ��");
		problem.setTbAuditStatus(tbAuditStatus);
		PMService.updateProblem(problem);

		PMService.saveTbProblemAudit(tbProblemAudit);

		//�޸���Ŀ״̬
		
		return this.quesLibAudit();
	}


	/**
	 * ��˱��ܾ�
	 */
	public String toRefuseAudit() {

		//������˵���Ŀ
		int pId = Integer.parseInt(ServletActionContext.getRequest().getParameter("pId"));
		TbProblem problem = PMService.getTbProblem(pId);
		tbProblemAudit.setTbProblem(problem);

		//�����                        ����ʱӦ���޸��ⲿ������
		int id = 1;
		TbUser user = PMService.getTbUser(id);
		tbProblemAudit.setTbUser(user);

		//���ʱ��(����ǰ��ϵͳʱ��)
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String auditTime = format.format(d);
		tbProblemAudit.setPaTime(auditTime);

		//������
		String auditAdvice = ServletActionContext.getRequest().getParameter("auditAdvice");
		System.out.println(auditAdvice);
		tbProblemAudit.setPaComplaint(auditAdvice);

		//����״̬(���ڻ����ѱ�ɾ��)
		tbProblemAudit.setPaDel("0");

		PMService.saveTbProblemAudit(tbProblemAudit);

		//�޸���Ŀ״̬
		TbAuditStatus tbAuditStatus = PMService.findTbAuditStatus("�Ѿܾ�");
		problem.setTbAuditStatus(tbAuditStatus);
		PMService.updateProblem(problem);
		return this.quesLibAudit();
	}

	/**
	 * ���������ҳ
	 */
	public String returnQuesLibAudit() {

		return this.quesLibAudit();
	}



	/**
	 * ��ת��quesLibCancelҳ��
	 * 
	 * ��ҳ����findWithPage()
	 * ִ��ȫ�鼰��ҳ
	 */	
	public String quesLibCancel() {

		HttpServletRequest request = ServletActionContext.getRequest();
		String newHQL = (String) ServletActionContext.getRequest().getParameter("newHQL");
		String HQL = null;
		//��newHQLΪ��Ϊnullʱ���������µĲ�ѯ������ƴдSQL
		if(newHQL != null) {
			HQL = PMService.cancelHQL(request);
		} else {
			HQL = (String) request.getSession().getAttribute("HQLes");
		}

		int totalRows = PMService.getRows(HQL);

		//����ҳ������ǰҳ������ǰ̨
		Pager pager = PagerHelper.getPager(ServletActionContext.getRequest(), totalRows);
		ServletActionContext.getRequest().setAttribute("totalPages", pager.getTotalPages());
		ServletActionContext.getRequest().setAttribute("currentPage", pager.getCurrentPage());

		List<?> problemList = PMService.findWithPage(pager, HQL);
		ServletActionContext.getRequest().setAttribute("problemList", problemList);

		this.findProTypeScoDiffLev();
		return "quesLibCancel";
	}

	/**
	 *�����ض���Ŀ��ת��������ҳ��
	 */
	public String quesLibCancel2() {
		String proNum = ServletActionContext.getRequest().getParameter("proNum");
		TbProblem tbProblem = PMService.findTbProblem(proNum);
		ServletActionContext.getRequest().setAttribute("tbProblem", tbProblem);

		int pId = tbProblem.getPId();
		//ͨ����ĿId��ѯ����Ŀ�Ĵ�
		List<?> resultId = PMService.getResultId(pId);

		List<TbProblemResult> list0 = new ArrayList<TbProblemResult>();
		List<TbProblemResult> list1 = new ArrayList<TbProblemResult>();
		//�жϷ��صĴ�Id�Ƿ�Ϊ�գ���������������
		if(resultId != null ){
			for(int i=0; i<resultId.size();i++) {
				Object obj =resultId.get(i);
				int id= (Integer)obj;
				TbProblemResult tbProblemResult = PMService.getProResult(id);
				String str = tbProblemResult.getPrTrueIdent();
				if(str.equalsIgnoreCase("0") ) {
					list0.add(tbProblemResult);
				} else {
					list1.add(tbProblemResult);
				}
			}
		}
		ServletActionContext.getRequest().setAttribute("list0", list0);
		ServletActionContext.getRequest().setAttribute("list1", list1);

		//ͨ����Ŀid�ҵ�����������
		TbProblemAudit audit = PMService.findTbProblemAudit(pId);
		ServletActionContext.getRequest().setAttribute("audit", audit);

		return "quesLibCancel2";
	}

	/**
	 * ������Ŀ
	 */
	public String cancleQuestion() {
		//������Ŀ״̬
		int pId = Integer.parseInt(ServletActionContext.getRequest().getParameter("pId"));
		TbProblem tbProblem = PMService.getTbProblem(pId);
		TbAuditStatus tbAuditStatus = PMService.findTbAuditStatus("�ѱ���");
		tbProblem.setTbAuditStatus(tbAuditStatus);
		PMService.updateProblem(tbProblem);

		//ɾ����Ŀ��������
		TbProblemAudit tbProblemAudit = PMService.findTbProblemAudit(pId);
		if(tbProblemAudit != null) {
			tbProblemAudit.setPaDel("1");
			PMService.updateTbProblemAudit(tbProblemAudit);
		}

		return this.quesLibCancel();
	}

	/**
	 * ���س�����ҳ
	 */
	public String returnQuesLibCancel() {
		return this.quesLibCancel();

	}




	/**
	 * ���ҵ���ʵ�ֲ�ӿ�
	 * @return
	 */
	public ProblemManagerService getPMService()
	{
		return PMService;
	}

	/**
	 * /**
	 * �趨ҵ���ʵ�ֲ�ӿ�
	 * @return
	 */

	public void setPMService(ProblemManagerService pMService)
	{
		PMService = pMService;
	}

	/**
	 * TbProblem��geter����
	 * @return
	 */
	public TbProblem getTbProblem() {
		return tbProblem;
	}

	/**
	 * TbProblem��seter����
	 * @return
	 */
	public void setTbProblem(TbProblem tbProblem) {
		this.tbProblem = tbProblem;
	}

	/**
	 * TbAuditStatus��geter����
	 * @return
	 */
	public TbAuditStatus getTbAuditStatus() {
		return tbAuditStatus;
	}

	/**
	 * TbAuditStatus��seter����
	 * @return
	 */
	public void setTbAuditStatus(TbAuditStatus tbAuditStatus) {
		this.tbAuditStatus = tbAuditStatus;
	}

	/**
	 * TbProblemType��geter����
	 * @return
	 */
	public TbProblemType getTbProblemType() {
		return tbProblemType;
	}

	/**
	 * TbProblemType��seter����
	 * @return
	 */
	public void setTbProblemType(TbProblemType tbProblemType) {
		this.tbProblemType = tbProblemType;
	}

	/**
	 * TbProblemScore��geter����
	 * @return
	 */
	public TbProblemScore getTbProblemScore() {
		return tbProblemScore;
	}

	/**
	 * TbProblemScore��seter����
	 * @return
	 */
	public void setTbProblemScore(TbProblemScore tbProblemScore) {
		this.tbProblemScore = tbProblemScore;
	}

	/**
	 * TbProblemDifficultyLevel��geter����
	 * @return
	 */
	public TbProblemDifficultyLevel getProDiffLevel() {
		return proDiffLevel;
	}

	/**
	 * TbProblemDifficultyLevel��seter����
	 * @return
	 */
	public void setProDiffLevel(TbProblemDifficultyLevel proDiffLevel) {
		this.proDiffLevel = proDiffLevel;
	}

	/**
	 * TbProblemAnswer��geter����
	 * @return
	 */
	public TbProblemResult getTbProblemResult() {
		return tbProblemResult;
	}

	/**
	 * TbProblemAnswer��seter����
	 * @return
	 */
	public void setTbProblemResult(TbProblemResult tbProblemResult) {
		this.tbProblemResult = tbProblemResult;
	}

	/**
	 * TbUser��geter����
	 * @return
	 */
	public TbUser getTbUser() {
		return tbUser;
	}

	/**
	 * TbUser��seter����
	 * @return
	 */
	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	/**
	 * TbProblemAudit��geter����
	 * @return
	 */
	public TbProblemAudit getTbProblemAudit() {
		return tbProblemAudit;
	}

	/**
	 * TbProblemAudit��seter����
	 * @return
	 */
	public void setTbProblemAudit(TbProblemAudit tbProblemAudit) {
		this.tbProblemAudit = tbProblemAudit;
	}
	
	/**
	 * NumberUtil��Geter����
	 * @return
	 */
	public NumberUtil getNumberUtil() {
		return numberUtil;
	}

	/**
	 * NumberUtil��seter����
	 * @return
	 */
	public void setNumberUtil(NumberUtil numberUtil) {
		this.numberUtil = numberUtil;
	}


}
