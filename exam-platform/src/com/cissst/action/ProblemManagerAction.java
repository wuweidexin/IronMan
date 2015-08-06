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
 * @模块名称：ProblemManagerAction(题库管理)
 * @开发人：张学
 * @功          能：
 * @开发时间：
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
	 * 到添加页面
	 * @return
	 */
	public String quesLibAdd() {
		this.findProTypeScoDiffLev();
		return "quesLibAdd";
	}

	/**
	 * 查询试题类型、范围、难度等级
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
	 * 点击quesLibAdd中next时执行的传值方法
	 * @return
	 */
	public String nextOutPut() {
		//获取题目编号
		String problemNum =numberUtil.getProblemNo();
		String temp = problemNum;
		tbProblem.setCol1(problemNum);

		//获取题目类型
		int ptId = Integer.valueOf(ServletActionContext.getRequest().getParameter("ptId"));
		tbProblemType.setPtId(ptId);
		tbProblem.setTbProblemType(tbProblemType);

		//获取题目范围
		int psId = Integer.valueOf(ServletActionContext.getRequest().getParameter("psId"));
		tbProblemScore.setPsId(psId);
		tbProblem.setTbProblemScore(tbProblemScore);

		//获取题目难度等级
		int pdlId = Integer.valueOf(ServletActionContext.getRequest().getParameter("pdlId"));
		proDiffLevel.setPdlId(pdlId);
		tbProblem.setTbProblemDifficultyLevel(proDiffLevel);

		//添加题目的录入时间(即当前的系统时间)
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String addTime = format.format(d);
		System.out.println(addTime);
		tbProblem.setPAddTime(addTime);

		//添加录入人
		TbUser user = (TbUser) ServletActionContext.getRequest().getSession().getAttribute("user");
		//整合时应该修改这部分内容
		tbProblem.setTbUser(user);

		//题目存在状态
		tbProblem.setPDel("0");

		

		PMService.saveProblem(tbProblem);

		TbProblem tbProblem = PMService.findTbProblem(temp);

		ServletActionContext.getRequest().setAttribute("tbProblem", tbProblem);
		return "quesLibAdd2";

	}

	/**
	 * 返回添加首页
	 */
	public String returnQuesLibAdd() {
		this.findProTypeScoDiffLev();
		return "quesLibAdd";
	}

	/**
	 * 带值跳转到QuesLibAdd3页面
	 */
	public String transeferQuesLibAdd3() {

		//获取题目id
		int id = Integer.valueOf(ServletActionContext.getRequest().getParameter("pId"));
		int temp = id;
		System.out.println(id);
		//获得题目
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
	 * 添加答案
	 */
	public String addNewResult() {

		String  pId = ServletActionContext.getRequest().getParameter("pId"); 
		String pId_2 = ServletActionContext.getRequest().getParameter("pId_2"); 
		if(pId != "" && pId != null) {
			int id = Integer.parseInt(pId);
			TbProblem tbProblem = PMService.getTbProblem(id);


			//获取答案内容
			String resultContent = ServletActionContext.getRequest().getParameter("quesAnswer");
			tbProblemResult.setPrContent(resultContent);

			//设置答案存在状态
			tbProblemResult.setPrDel("0");

			//设置答案正确标志
			tbProblemResult.setPrTrueIdent("0");
			tbProblemResult.setTbProblem(tbProblem);
			PMService.saveResult(tbProblemResult);

		} else {
			int id = Integer.parseInt(pId_2);
			TbProblem tbProblem = PMService.getTbProblem(id);
			tbProblemResult.setTbProblem(tbProblem);

			//获取答案内容
			String resultContent = ServletActionContext.getRequest().getParameter("quesAnswer");
			tbProblemResult.setPrContent(resultContent);

			//设置答案存在状态
			tbProblemResult.setPrDel("0");

			//设置答案正确标志
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
	 * 查找本次编辑的题目及该题目的答案发送到处理页面quesLibAdd4
	 */
	public String findProblemAndResult() {

		//查找本次编辑的题目
		int id = Integer.valueOf(ServletActionContext.getRequest().getParameter("pId")); 
		TbProblem tbProblem = PMService.getTbProblem(id);
		ServletActionContext.getRequest().setAttribute("tbProblem", tbProblem);

		//通过题目Id查询该题目的答案
		List<?> resultId = PMService.getResultId(id);

		List<TbProblemResult> list0 = new ArrayList<TbProblemResult>();
		List<TbProblemResult> list1 = new ArrayList<TbProblemResult>();
		//判断返回的答案Id是否为空，以免引起程序错误
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
	 * 删除答案
	 * @return
	 */
	public String deleteProResult() {

		//获取要删除的题目的Id
		String[] correctResults = (String[]) ServletActionContext.getRequest().getParameterValues("results");
		for(int i=0;i<correctResults.length;i++){
			int cr = Integer.parseInt(correctResults[i]);
			PMService.deleteProResult(cr);
		}

		//查找并显示未删除的
		String da_id = ServletActionContext.getRequest().getParameter("daf_id"); 
		String dq_id = ServletActionContext.getRequest().getParameter("daf_id");
		if (da_id != "" && da_id != null) {
			int id = Integer.parseInt(da_id);
			//通过题目Id查询该题目的答案
			List<?> resultId = PMService.getResultId(id);

			List<TbProblemResult> list0 = new ArrayList<TbProblemResult>();
			List<TbProblemResult> list1 = new ArrayList<TbProblemResult>();
			//判断返回的答案Id是否为空，以免引起程序错误
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
			//通过题目Id查询该题目的答案
			List<?> resultId = PMService.getResultId(id);

			List<TbProblemResult> list0 = new ArrayList<TbProblemResult>();
			List<TbProblemResult> list1 = new ArrayList<TbProblemResult>();
			//判断返回的答案Id是否为空，以免引起程序错误
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
	 * 编辑试题以及选中正确答案
	 * @return
	 */
	public String saveProblem() {
		//获得某道题目的Id

		String  pId = ServletActionContext.getRequest().getParameter("pId"); 
		String pId_2 = ServletActionContext.getRequest().getParameter("pId_2"); 
		if(pId != "" && pId != null) {
			int id = Integer.parseInt(pId);
			//在设置某道题正确答案时先将所有答案正确标志改为"0"
			List<?> resultIdList = PMService.getResultId(id);
			for(int i=0; i<resultIdList.size();i++) {
				Object id1 = resultIdList.get(i);
				int resultId= (Integer)id1;
				TbProblemResult result =  PMService.getProResult(resultId);
				result.setPrTrueIdent("0");
				PMService.updateResult(result);
			}

			//获得选中答案的Id更改其正确标志为"1"
			String[] correctResults = (String[]) ServletActionContext.getRequest().getParameterValues("results");
			for(int i=0;i<correctResults.length;i++){
				int cr = Integer.parseInt(correctResults[i]);
				TbProblemResult tbProblemResult = PMService.getProResult(cr);
				//防止重复提交时造成程序错误
				String str = tbProblemResult.getPrTrueIdent();
				if(str != "1"){
					tbProblemResult.setPrTrueIdent("1");
				}
				PMService.updateResult(tbProblemResult);
			}

			//获得题目并更新到数据库
			TbProblem   tbProblem = PMService.getTbProblem(id);
			String pTitle = ServletActionContext.getRequest().getParameter("question");
			if(pTitle != null) {
				tbProblem.setPTitle(pTitle);
			}

			//更改题目审核状态
			TbAuditStatus tbAuditStatus = PMService.findTbAuditStatus("已保存");
			tbProblem.setTbAuditStatus(tbAuditStatus);

			PMService.updateProblem(tbProblem);
			this.findProblemAndResult();
		} else {
			int id = Integer.parseInt(pId_2);
			//在设置某道题正确答案时先将所有答案正确标志改为"0"
			List<?> resultIdList = PMService.getResultId(id);
			for(int i=0; i<resultIdList.size();i++) {
				Object id1 = resultIdList.get(i);
				int resultId= (Integer)id1;
				TbProblemResult result =  PMService.getProResult(resultId);
				result.setPrTrueIdent("0");
				PMService.updateResult(result);
			}

			//获得选中答案的Id更改其正确标志为"1"
			String[] correctResults = (String[]) ServletActionContext.getRequest().getParameterValues("results");
			for(int i=0;i<correctResults.length;i++){
				int cr = Integer.parseInt(correctResults[i]);
				TbProblemResult tbProblemResult = PMService.getProResult(cr);
				//防止重复提交时造成程序错误
				String str = tbProblemResult.getPrTrueIdent();
				if(str != "1"){
					tbProblemResult.setPrTrueIdent("1");
				}
				PMService.updateResult(tbProblemResult);
			}

			//获得题目并更新到数据库
			TbProblem   tbProblem = PMService.getTbProblem(id);
			String pTitle = ServletActionContext.getRequest().getParameter("question");
			if(pTitle != null) {
				tbProblem.setPTitle(pTitle);
			}

			//获得题目范围并更新题目
			String psId = ServletActionContext.getRequest().getParameter("psId");
			if(psId != "" && psId != null) {
				int id1 = Integer.parseInt(psId);
				TbProblemScore scope = PMService.getProblemScore(id1);
				tbProblem.setTbProblemScore(scope);
			}

			//获得题目难度并更新题目
			String pdlId = ServletActionContext.getRequest().getParameter("pdlId");
			if(pdlId != "" && pdlId != null) {
				int id1 = Integer.parseInt(pdlId);
				TbProblemDifficultyLevel level = PMService.getProblemDifficultyLevel(id1);
				tbProblem.setTbProblemDifficultyLevel(level);
			}

			//更改题目审核状态
			TbAuditStatus tbAuditStatus = PMService.findTbAuditStatus("已保存");
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
	 * 用户点击提交时调用该方法
	 */
	public String submitQuestion() {
		
		//获得某道题目的Id
		String  pId = ServletActionContext.getRequest().getParameter("pId");
		String p_Id2 = ServletActionContext.getRequest().getParameter("p_Id2");
		if(pId != "" && pId != null) {
			int id = Integer.parseInt(pId);
			TbProblem tbProblem = PMService.getTbProblem(id);
			tbAuditStatus = PMService.findTbAuditStatus("已提交");
			tbProblem.setTbAuditStatus(tbAuditStatus);
			PMService.updateProblem(tbProblem);
			this.quesLibAdd();
		} else {
			int id = Integer.parseInt(p_Id2);
			
			//更改题目状态
			TbProblem tbProblem = PMService.getTbProblem(id);
			tbAuditStatus = PMService.findTbAuditStatus("已提交");
			tbProblem.setTbAuditStatus(tbAuditStatus);
			PMService.updateProblem(tbProblem);
			
			//如果是已审批的题目，则应该删除其审批资料
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
	 * 跳转到quesLibQuery页面
	 * 分页方法findWithPage()
	 * 执行全查及分页
	 */	
	public String quesLibQuery() {

		HttpServletRequest request = ServletActionContext.getRequest();
		String newHQL = (String) ServletActionContext.getRequest().getParameter("newHQL");
		String HQL = null;
		//当newHQL为不为null时，表明是新的查询，从新拼写SQL
		if(newHQL != null) {
			HQL = PMService.checkHQL(request);
		}
	
		else {
			HQL =(String) request.getSession().getAttribute("HQL");
		}

		int totalRows = PMService.getRows(HQL);

		//将总页数及当前页数发往前台
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
		//查找将要维护的题目
		String proNum = ServletActionContext.getRequest().getParameter("proNum");
		TbProblem tbProblem = PMService.findTbProblem(proNum);
		ServletActionContext.getRequest().setAttribute("tbProblem", tbProblem);

		//显示题目类型、范围、难度等级
		this.findProTypeScoDiffLev();

		//通过题目Id查询该题目的答案
		int pId = tbProblem.getPId();
		List<?> resultId = PMService.getResultId(pId);

		List<TbProblemResult> list0 = new ArrayList<TbProblemResult>();
		List<TbProblemResult> list1 = new ArrayList<TbProblemResult>();
		//判断返回的答案Id是否为空，以免引起程序错误
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

		//查询审批资料(根据题目Id)
		TbProblemAudit tbProblemAudit =PMService.findTbProblemAudit(pId);
		if(tbProblemAudit != null) {
			ServletActionContext.getRequest().setAttribute("tbProblemAudit", tbProblemAudit);
		}

		return "quesLibQuery2";
	}

	//维护题目时跳转到quesLibAdd3页面
	public String transeferQuesLibAdd3_2() {
		int pId_2 = Integer.parseInt(ServletActionContext.getRequest().getParameter("pId_2"));
		TbProblem tbProblem = PMService.getTbProblem(pId_2);
		ServletActionContext.getRequest().setAttribute("tbProblem", tbProblem);
		return "quesLibAdd3_2";

	}

	/**
	 * 删除题目(删除题目相关的答案，以及审批资料)
	 */
	public String deleteProblem () {
		String p_Id2 = ServletActionContext.getRequest().getParameter("p_Id2");
		if(p_Id2 != "" && p_Id2 != null) {
			int id = Integer.parseInt(p_Id2);
			PMService.deleteProblem(id);
			
			//删除该题答案
			List<?> resultIds = PMService.getResultId(id);
			if( resultIds != null) {
				for(int i=0; i<resultIds.size();i++) {
					Object obj = resultIds.get(i);
					long id_1 = (Long)obj;
					int id_2 = (int) id_1;
					PMService.deleteProResult(id_2);
				}
			}
			
			//删除审批资料
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
	 * 跳转到quesLibAudit页面
	 * 
	 * 分页方法findWithPage()
	 * 执行全查及分页
	 */	
	public String quesLibAudit() {

		HttpServletRequest request = ServletActionContext.getRequest();
		String newHQL = (String) ServletActionContext.getRequest().getParameter("newHQL");
		String HQL = null;
		//当newHQL为不为null时，表明是新的查询，从新拼写SQL
		if(newHQL != null) {
			HQL = PMService.AuditHQL(request);
		} else {
			HQL = (String) request.getSession().getAttribute("HQLs");
			//如果ＨＱＬ为空说明是从主页调用方法执行的，所以要用主页的方法返回
			if(HQL == null)
			{
				return indexPageAction.jwzrFindProblem();
			}
		}

		int totalRows = PMService.getRows(HQL);

		//将总页数及当前页数发往前台
		Pager pager = PagerHelper.getPager(ServletActionContext.getRequest(), totalRows);
		ServletActionContext.getRequest().setAttribute("totalPages", pager.getTotalPages());
		ServletActionContext.getRequest().setAttribute("currentPage", pager.getCurrentPage());

		List<?> problemList = PMService.findWithPage(pager, HQL);
		ServletActionContext.getRequest().setAttribute("problemList", problemList);

		this.findProTypeScoDiffLev();
		return "quesLibAudit";
	}

	/**
	 * 通过题目编号查出题目并传往二级页面(quesLibAudit2)
	 */
	public String quesLibAudit2() {
		//查找到题目(通过题目编号)
		String pNO = ServletActionContext.getRequest().getParameter("pNO");
		TbProblem tbProblem = PMService.findTbProblem(pNO);
		int pId = tbProblem.getPId();
		ServletActionContext.getRequest().setAttribute("tbProblem", tbProblem);

		//通过题目Id查询该题目的答案
		List<?> resultId = PMService.getResultId(pId);

		List<TbProblemResult> list0 = new ArrayList<TbProblemResult>();
		List<TbProblemResult> list1 = new ArrayList<TbProblemResult>();
		//判断返回的答案Id是否为空，以免引起程序错误
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
	 * 保存审核意见 (审核通过)
	 * @return
	 */
	public String toPassAudit () {


		//设置审核的题目
		int pId = Integer.parseInt(ServletActionContext.getRequest().getParameter("pId"));
		TbProblem problem = PMService.getTbProblem(pId);
		tbProblemAudit.setTbProblem(problem);

		//审核人                        整合时应该修改这部分内容
		
		TbUser user = (TbUser)ServletActionContext.getRequest().getSession().getAttribute("user");
		tbProblemAudit.setTbUser(user);

		//审核时间(即当前的系统时间)
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String auditTime = format.format(d);
		tbProblemAudit.setPaTime(auditTime);

		//审核意见
		String auditAdvice = ServletActionContext.getRequest().getParameter("auditAdvice");
		System.out.println(auditAdvice);
		tbProblemAudit.setPaComplaint(auditAdvice);

		//存在状态(存在还是已被删除)
		tbProblemAudit.setPaDel("0");
		TbAuditStatus tbAuditStatus = PMService.findTbAuditStatus("已通过");
		problem.setTbAuditStatus(tbAuditStatus);
		PMService.updateProblem(problem);

		PMService.saveTbProblemAudit(tbProblemAudit);

		//修改题目状态
		
		return this.quesLibAudit();
	}


	/**
	 * 审核被拒绝
	 */
	public String toRefuseAudit() {

		//设置审核的题目
		int pId = Integer.parseInt(ServletActionContext.getRequest().getParameter("pId"));
		TbProblem problem = PMService.getTbProblem(pId);
		tbProblemAudit.setTbProblem(problem);

		//审核人                        整合时应该修改这部分内容
		int id = 1;
		TbUser user = PMService.getTbUser(id);
		tbProblemAudit.setTbUser(user);

		//审核时间(即当前的系统时间)
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String auditTime = format.format(d);
		tbProblemAudit.setPaTime(auditTime);

		//审核意见
		String auditAdvice = ServletActionContext.getRequest().getParameter("auditAdvice");
		System.out.println(auditAdvice);
		tbProblemAudit.setPaComplaint(auditAdvice);

		//存在状态(存在还是已被删除)
		tbProblemAudit.setPaDel("0");

		PMService.saveTbProblemAudit(tbProblemAudit);

		//修改题目状态
		TbAuditStatus tbAuditStatus = PMService.findTbAuditStatus("已拒绝");
		problem.setTbAuditStatus(tbAuditStatus);
		PMService.updateProblem(problem);
		return this.quesLibAudit();
	}

	/**
	 * 返回审核首页
	 */
	public String returnQuesLibAudit() {

		return this.quesLibAudit();
	}



	/**
	 * 跳转到quesLibCancel页面
	 * 
	 * 分页方法findWithPage()
	 * 执行全查及分页
	 */	
	public String quesLibCancel() {

		HttpServletRequest request = ServletActionContext.getRequest();
		String newHQL = (String) ServletActionContext.getRequest().getParameter("newHQL");
		String HQL = null;
		//当newHQL为不为null时，表明是新的查询，从新拼写SQL
		if(newHQL != null) {
			HQL = PMService.cancelHQL(request);
		} else {
			HQL = (String) request.getSession().getAttribute("HQLes");
		}

		int totalRows = PMService.getRows(HQL);

		//将总页数及当前页数发往前台
		Pager pager = PagerHelper.getPager(ServletActionContext.getRequest(), totalRows);
		ServletActionContext.getRequest().setAttribute("totalPages", pager.getTotalPages());
		ServletActionContext.getRequest().setAttribute("currentPage", pager.getCurrentPage());

		List<?> problemList = PMService.findWithPage(pager, HQL);
		ServletActionContext.getRequest().setAttribute("problemList", problemList);

		this.findProTypeScoDiffLev();
		return "quesLibCancel";
	}

	/**
	 *查找特定题目并转往二级子页面
	 */
	public String quesLibCancel2() {
		String proNum = ServletActionContext.getRequest().getParameter("proNum");
		TbProblem tbProblem = PMService.findTbProblem(proNum);
		ServletActionContext.getRequest().setAttribute("tbProblem", tbProblem);

		int pId = tbProblem.getPId();
		//通过题目Id查询该题目的答案
		List<?> resultId = PMService.getResultId(pId);

		List<TbProblemResult> list0 = new ArrayList<TbProblemResult>();
		List<TbProblemResult> list1 = new ArrayList<TbProblemResult>();
		//判断返回的答案Id是否为空，以免引起程序错误
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

		//通过题目id找到其审批资料
		TbProblemAudit audit = PMService.findTbProblemAudit(pId);
		ServletActionContext.getRequest().setAttribute("audit", audit);

		return "quesLibCancel2";
	}

	/**
	 * 撤销题目
	 */
	public String cancleQuestion() {
		//更改题目状态
		int pId = Integer.parseInt(ServletActionContext.getRequest().getParameter("pId"));
		TbProblem tbProblem = PMService.getTbProblem(pId);
		TbAuditStatus tbAuditStatus = PMService.findTbAuditStatus("已保存");
		tbProblem.setTbAuditStatus(tbAuditStatus);
		PMService.updateProblem(tbProblem);

		//删除题目审批资料
		TbProblemAudit tbProblemAudit = PMService.findTbProblemAudit(pId);
		if(tbProblemAudit != null) {
			tbProblemAudit.setPaDel("1");
			PMService.updateTbProblemAudit(tbProblemAudit);
		}

		return this.quesLibCancel();
	}

	/**
	 * 返回撤销首页
	 */
	public String returnQuesLibCancel() {
		return this.quesLibCancel();

	}




	/**
	 * 获得业务层实现层接口
	 * @return
	 */
	public ProblemManagerService getPMService()
	{
		return PMService;
	}

	/**
	 * /**
	 * 设定业务层实现层接口
	 * @return
	 */

	public void setPMService(ProblemManagerService pMService)
	{
		PMService = pMService;
	}

	/**
	 * TbProblem的geter方法
	 * @return
	 */
	public TbProblem getTbProblem() {
		return tbProblem;
	}

	/**
	 * TbProblem的seter方法
	 * @return
	 */
	public void setTbProblem(TbProblem tbProblem) {
		this.tbProblem = tbProblem;
	}

	/**
	 * TbAuditStatus的geter方法
	 * @return
	 */
	public TbAuditStatus getTbAuditStatus() {
		return tbAuditStatus;
	}

	/**
	 * TbAuditStatus的seter方法
	 * @return
	 */
	public void setTbAuditStatus(TbAuditStatus tbAuditStatus) {
		this.tbAuditStatus = tbAuditStatus;
	}

	/**
	 * TbProblemType的geter方法
	 * @return
	 */
	public TbProblemType getTbProblemType() {
		return tbProblemType;
	}

	/**
	 * TbProblemType的seter方法
	 * @return
	 */
	public void setTbProblemType(TbProblemType tbProblemType) {
		this.tbProblemType = tbProblemType;
	}

	/**
	 * TbProblemScore的geter方法
	 * @return
	 */
	public TbProblemScore getTbProblemScore() {
		return tbProblemScore;
	}

	/**
	 * TbProblemScore的seter方法
	 * @return
	 */
	public void setTbProblemScore(TbProblemScore tbProblemScore) {
		this.tbProblemScore = tbProblemScore;
	}

	/**
	 * TbProblemDifficultyLevel的geter方法
	 * @return
	 */
	public TbProblemDifficultyLevel getProDiffLevel() {
		return proDiffLevel;
	}

	/**
	 * TbProblemDifficultyLevel的seter方法
	 * @return
	 */
	public void setProDiffLevel(TbProblemDifficultyLevel proDiffLevel) {
		this.proDiffLevel = proDiffLevel;
	}

	/**
	 * TbProblemAnswer的geter方法
	 * @return
	 */
	public TbProblemResult getTbProblemResult() {
		return tbProblemResult;
	}

	/**
	 * TbProblemAnswer的seter方法
	 * @return
	 */
	public void setTbProblemResult(TbProblemResult tbProblemResult) {
		this.tbProblemResult = tbProblemResult;
	}

	/**
	 * TbUser的geter方法
	 * @return
	 */
	public TbUser getTbUser() {
		return tbUser;
	}

	/**
	 * TbUser的seter方法
	 * @return
	 */
	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	/**
	 * TbProblemAudit的geter方法
	 * @return
	 */
	public TbProblemAudit getTbProblemAudit() {
		return tbProblemAudit;
	}

	/**
	 * TbProblemAudit的seter方法
	 * @return
	 */
	public void setTbProblemAudit(TbProblemAudit tbProblemAudit) {
		this.tbProblemAudit = tbProblemAudit;
	}
	
	/**
	 * NumberUtil的Geter方法
	 * @return
	 */
	public NumberUtil getNumberUtil() {
		return numberUtil;
	}

	/**
	 * NumberUtil的seter方法
	 * @return
	 */
	public void setNumberUtil(NumberUtil numberUtil) {
		this.numberUtil = numberUtil;
	}


}
