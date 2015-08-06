package com.cissst.action;


import java.text.SimpleDateFormat;
import java.util.HashSet;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;



import com.cissst.entity.TbExamScheme;

import com.cissst.entity.TbAuditStatus;
import com.cissst.entity.TbExamSchemeDetail;
import com.cissst.entity.TbProblem;
import com.cissst.entity.TbProblemDifficultyLevel;
import com.cissst.entity.TbProblemScore;
import com.cissst.entity.TbProblemType;
import com.cissst.entity.TbReadType;
import com.cissst.entity.TbTactics;
import com.cissst.entity.TbTacticsDetail;
import com.cissst.service.ExamSchemaService;
import com.cissst.utils.NumberUtil;
import com.cissst.utils.Pager;
import com.cissst.utils.PagerHelper;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @模块名称：ExamSchemaAction(考试方案)
 * @开发人： 黄   宁
 * @功 能：考试方案
 * @开发时间：
 */
public class ExamSchemaAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private ExamSchemaService ESService;
	private NumberUtil numberUtil;


	//抽取方式：0表示手动指定、1自动抽取

	// examSchemeAdd：添加考试方案
	/*	public String toExamSchemeAdd()
	{
		String num = numberUtil.getExamScheme();
		ServletActionContext.getRequest().setAttribute("num", num);
		return "toExamSchemeAdd";
	}

	 */	
	public String examSchemeAdd() {

		TbExamScheme tbExamScheme=new TbExamScheme();
		String[] valuessss= ServletActionContext.getRequest().getParameterValues("chekeee");
		if (valuessss!=null) {
			for(int i=0;i<valuessss.length;i++){
				int Id = Integer.valueOf(valuessss[i]);
				TbTactics tbTactics=ESService.TbTacticsfindByHQLQuery(Id);
				tbTactics.setTDel("1");
				ESService.TbTacticsupdate(tbTactics);
			}
		}

		List<TbTactics> tbTactics=ESService.findByHQLtbTactics();
		ServletActionContext.getRequest().setAttribute("actics", tbTactics);
	
		
		String examSchamaNumer=ServletActionContext.getRequest().getParameter("examSchamaNumer");
		String examSchamaName=ServletActionContext.getRequest().getParameter("examSchamaName");
		String txtAddressState=ServletActionContext.getRequest().getParameter("txtAddressState");
		String examSchamaPeople=ServletActionContext.getRequest().getParameter("examSchamaPeople");
	
		String save111=ServletActionContext.getRequest().getParameter("save111");
		String ddelete=ServletActionContext.getRequest().getParameter("ddelete");

		
		if (save111!=null&&save111!="") {
			
			tbExamScheme.setEsMyselfId(examSchamaNumer);
			tbExamScheme.setEsName(examSchamaName);
			tbExamScheme.setEsDescribe(txtAddressState);
			SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
			System.out.print(s.format(new java.util.Date()));
			tbExamScheme.setEsAddTime(s.format(new java.util.Date()));
			tbExamScheme.setEsAddUser(examSchamaPeople);
			tbExamScheme.setEsDel("0");
			String HQL="已保存";
			TbAuditStatus tbAuditStatus=ESService.findByHQL(HQL);
			tbExamScheme.setTbAuditStatus(tbAuditStatus);
			ESService.saveTbE(tbExamScheme);
			for(int i=0;i<tbTactics.size();i++){
				TbTactics tbTactics11=(TbTactics) tbTactics.get(i);
				TbExamSchemeDetail tbExamSchemeDetail=new TbExamSchemeDetail();
				tbExamSchemeDetail.setTbTactics(tbTactics11);
				tbExamSchemeDetail.setEsdDel("0");
				tbExamSchemeDetail.setTbExamScheme(tbExamScheme);
				ESService.saveSchemeDetail(tbExamSchemeDetail);
			}
		
			int IIID=tbExamScheme.getEsId();
			ServletActionContext.getRequest().setAttribute("IIID", IIID);
		}

		if (ddelete!=null&&ddelete!="") {
			tbExamScheme.setEsDel("1");
			ESService.update(tbExamScheme);
		}
	
		return "examSchemeAdd";

	}

	// examSchemeAdd2：添加策略

	@SuppressWarnings("unchecked")
	public String examSchemeAdd2() {

		String[] valuess= ServletActionContext.getRequest().getParameterValues("checked11");
		if (valuess!=null) {
			for(int i=0;i<valuess.length;i++){
				int Id = Integer.valueOf(valuess[i]);
				TbProblem tbProblem=ESService.findByHQLTbProblem(Id);
				tbProblem.setCol3("");
				ESService.updateTbProblem(tbProblem);	
			}
		}

		List<?> list = ESService.findByHQLtbTbProblem();
		ServletActionContext.getRequest().setAttribute("list", list);
		int countNumer=list.size();
		ServletActionContext.getRequest().setAttribute("countNumer", countNumer);

		int count=ESService.getRow();
		ServletActionContext.getRequest().setAttribute("count", count);

		List<TbProblemType> type=ESService.findByHQLtbProblemType();
		ServletActionContext.getRequest().setAttribute("type", type);

		List<TbProblemDifficultyLevel> level=ESService.TbPrfindByHQLdifficultyLevel();
		ServletActionContext.getRequest().setAttribute("level", level);

		List<TbProblemScore> score=ESService.TbPrfindByHQLtbScore();
		ServletActionContext.getRequest().setAttribute("score", score);



		String userType=ServletActionContext.getRequest().getParameter("userType");
		String examScore=ServletActionContext.getRequest().getParameter("examScore");
		String examProblemNumber=ServletActionContext.getRequest().getParameter("examProblemNumber");
		String save=ServletActionContext.getRequest().getParameter("save");
		String delete=ServletActionContext.getRequest().getParameter("delete");
		
		String questionBoundary=ServletActionContext.getRequest().getParameter("questionBoundary");
		String questionDifficult=ServletActionContext.getRequest().getParameter("questionDifficult");
		String questionType=ServletActionContext.getRequest().getParameter("questionType");

		TbTactics tbTactics = new TbTactics();
		if (save!=null&&save!="") {

			if (userType!=null&&userType!="") {
				if (userType.endsWith("自动抽取")) {
					int count1 = Integer.valueOf(ServletActionContext.getRequest().getParameter("examProblemNumber"));
					List<TbProblem> list1 = (List<TbProblem>) ESService.findByHQLFree();
					Set<TbTacticsDetail> set1 = new HashSet<TbTacticsDetail>();
					             for (int i = 0; i <count1; i++) {
						                       TbProblem tbProblem=list1.get(i);
						                       TbTacticsDetail tbTacticsDetail = new TbTacticsDetail();
						                       tbTacticsDetail.setTbProblem(tbProblem);
						                       ESService.saveDetail(tbTacticsDetail);
						                       set1.add(tbTacticsDetail);
	                                                            }
					tbTactics.setTbExamSchemeDetails(set1);
					int examScore1 = Integer.valueOf(examScore);
					tbTactics.setTEveryMark(examScore1);
					tbTactics.setTProblemNum(examProblemNumber);

					tbTactics.setTGetTitleMethod("1");
					TbReadType tbReadType = new TbReadType();
					tbReadType.setRtName("自动批阅");
					ESService.saveTbReadType(tbReadType);
					tbTactics.setTbReadType(tbReadType);
					tbTactics.setTDel("0");
					TbProblemScore tbProblemScore11=ESService.findByHQLtbScore(questionBoundary);
					TbProblemType tbProblemType11=ESService.findByHQLtProblemType(questionType);
					TbProblemDifficultyLevel tbProblemDifficultyLevel11=ESService.findByHQLdifficultyLevel(questionDifficult);
					tbTactics.setTbProblemType(tbProblemType11);
					tbTactics.setTbProblemDifficultyLevel(tbProblemDifficultyLevel11);
					tbTactics.setTbProblemScore(tbProblemScore11);
					
					ESService.save(tbTactics);
				      }

				if (userType.endsWith("手动指定")) {
					Set<TbTacticsDetail> set1 = new HashSet<TbTacticsDetail>();

					for (int i = 0; i < list.size(); i++) {
						TbProblem tbProblem = (TbProblem) list.get(i);
						TbTacticsDetail tbTacticsDetail = new TbTacticsDetail();
						tbTacticsDetail.setTbProblem(tbProblem);
						ESService.saveDetail(tbTacticsDetail);
						set1.add(tbTacticsDetail);
					                }

					tbTactics.setTbExamSchemeDetails(set1);
					int examScore1 = Integer.valueOf(examScore);
					tbTactics.setTEveryMark(examScore1);
					String num = String.valueOf(countNumer);
					tbTactics.setTProblemNum(num);
					tbTactics.setTDel("0");
					tbTactics.setTGetTitleMethod("0");
					TbReadType tbReadType = new TbReadType();
					tbReadType.setRtName("老师批阅");
					tbTactics.setTbReadType(tbReadType);
					ESService.saveTbReadType(tbReadType);
					TbProblemScore tbProblemScore11=ESService.findByHQLtbScore(questionBoundary);
					TbProblemType tbProblemType11=ESService.findByHQLtProblemType(questionType);
					TbProblemDifficultyLevel tbProblemDifficultyLevel11=ESService.findByHQLdifficultyLevel(questionDifficult);
					tbTactics.setTbProblemType(tbProblemType11);
					tbTactics.setTbProblemDifficultyLevel(tbProblemDifficultyLevel11);
					tbTactics.setTbProblemScore(tbProblemScore11);
					
					ESService.save(tbTactics);
					  }

				

			}

		}

		if (delete!=null&&delete!="") {
			tbTactics.setTDel("0");
			ESService.TbTacticsupdate(tbTactics);
		}

		return "examSchemeAdd2";

	}

	
	@SuppressWarnings("unchecked")
	public String examSchemeAdd2_1() {
		int iiiii=Integer.valueOf(ServletActionContext.getRequest().getParameter("eeee"));
		ServletActionContext.getRequest().setAttribute("iiii", iiiii);
		String[] valuess= ServletActionContext.getRequest().getParameterValues("checked11");
		if (valuess!=null) {
			for(int i=0;i<valuess.length;i++){
				int Id = Integer.valueOf(valuess[i]);
				TbProblem tbProblem=ESService.findByHQLTbProblem(Id);
				tbProblem.setCol3("");
				ESService.updateTbProblem(tbProblem);	
			}
		}

		List<?> list = ESService.findByHQLtbTbProblem();
		ServletActionContext.getRequest().setAttribute("list", list);
		int countNumer=list.size();
		ServletActionContext.getRequest().setAttribute("countNumer", countNumer);

		int count=ESService.getRow();
		ServletActionContext.getRequest().setAttribute("count", count);

		List<TbProblemType> type=ESService.findByHQLtbProblemType();
		ServletActionContext.getRequest().setAttribute("type", type);

		List<TbProblemDifficultyLevel> level=ESService.TbPrfindByHQLdifficultyLevel();
		ServletActionContext.getRequest().setAttribute("level", level);

		List<TbProblemScore> score=ESService.TbPrfindByHQLtbScore();
		ServletActionContext.getRequest().setAttribute("score", score);

          

		String userType=ServletActionContext.getRequest().getParameter("userType");
		String examScore=ServletActionContext.getRequest().getParameter("examScore");
		String examProblemNumber=ServletActionContext.getRequest().getParameter("examProblemNumber");
		String save=ServletActionContext.getRequest().getParameter("save");
		String delete=ServletActionContext.getRequest().getParameter("delete");
		
		String questionBoundary=ServletActionContext.getRequest().getParameter("questionBoundary");
		String questionDifficult=ServletActionContext.getRequest().getParameter("questionDifficult");
		String questionType=ServletActionContext.getRequest().getParameter("questionType");

		TbTactics tbTactics = new TbTactics();
		TbExamScheme tbExamScheme=ESService.findByHQL(iiiii);
		
		if (save!=null&&save!="") {

			if (userType!=null&&userType!="") {
				if (userType.endsWith("自动抽取")) {
					int count1 = Integer.valueOf(ServletActionContext.getRequest().getParameter("examProblemNumber"));
					List<TbProblem> list1 = (List<TbProblem>) ESService.findByHQLFree();
					Set<TbTacticsDetail> set1 = new HashSet<TbTacticsDetail>();
					             for (int i = 0; i <count1; i++) {
						                       TbProblem tbProblem=list1.get(i);
						                       TbTacticsDetail tbTacticsDetail = new TbTacticsDetail();
						                       tbTacticsDetail.setTbProblem(tbProblem);
						                       ESService.saveDetail(tbTacticsDetail);
						                       set1.add(tbTacticsDetail);
	                                                            }
					tbTactics.setTbExamSchemeDetails(set1);
					int examScore1 = Integer.valueOf(examScore);
					tbTactics.setTEveryMark(examScore1);
					tbTactics.setTProblemNum(examProblemNumber);

					tbTactics.setTGetTitleMethod("1");
					TbReadType tbReadType = new TbReadType();
					tbReadType.setRtName("自动批阅");
					ESService.saveTbReadType(tbReadType);
					tbTactics.setTbReadType(tbReadType);
					tbTactics.setTDel("0");
					TbProblemScore tbProblemScore11=ESService.findByHQLtbScore(questionBoundary);
					TbProblemType tbProblemType11=ESService.findByHQLtProblemType(questionType);
					TbProblemDifficultyLevel tbProblemDifficultyLevel11=ESService.findByHQLdifficultyLevel(questionDifficult);
					tbTactics.setTbProblemType(tbProblemType11);
					tbTactics.setTbProblemDifficultyLevel(tbProblemDifficultyLevel11);
					tbTactics.setTbProblemScore(tbProblemScore11);
					ESService.save(tbTactics);
					
					
					TbExamSchemeDetail tbExamSchemeDetail=new TbExamSchemeDetail();
					tbExamSchemeDetail.setTbTactics(tbTactics);
					tbExamSchemeDetail.setEsdDel("0");
					tbExamSchemeDetail.setTbExamScheme(tbExamScheme);
					ESService.saveSchemeDetail(tbExamSchemeDetail);
				      }

				if (userType.endsWith("手动指定")) {
					Set<TbTacticsDetail> set1 = new HashSet<TbTacticsDetail>();

					for (int i = 0; i < list.size(); i++) {
						TbProblem tbProblem = (TbProblem) list.get(i);
						TbTacticsDetail tbTacticsDetail = new TbTacticsDetail();
						tbTacticsDetail.setTbProblem(tbProblem);
						ESService.saveDetail(tbTacticsDetail);
						set1.add(tbTacticsDetail);
					                }

					tbTactics.setTbExamSchemeDetails(set1);
					int examScore1 = Integer.valueOf(examScore);
					tbTactics.setTEveryMark(examScore1);
					String num = String.valueOf(countNumer);
					tbTactics.setTProblemNum(num);
					tbTactics.setTDel("0");
					tbTactics.setTGetTitleMethod("0");
					TbReadType tbReadType = new TbReadType();
					tbReadType.setRtName("老师批阅");
					tbTactics.setTbReadType(tbReadType);
					ESService.saveTbReadType(tbReadType);
					TbProblemScore tbProblemScore11=ESService.findByHQLtbScore(questionBoundary);
					TbProblemType tbProblemType11=ESService.findByHQLtProblemType(questionType);
					TbProblemDifficultyLevel tbProblemDifficultyLevel11=ESService.findByHQLdifficultyLevel(questionDifficult);
					tbTactics.setTbProblemType(tbProblemType11);
					tbTactics.setTbProblemDifficultyLevel(tbProblemDifficultyLevel11);
					tbTactics.setTbProblemScore(tbProblemScore11);
					ESService.save(tbTactics);
					
					TbExamSchemeDetail tbExamSchemeDetail=new TbExamSchemeDetail();
					tbExamSchemeDetail.setTbTactics(tbTactics);
					tbExamSchemeDetail.setEsdDel("0");
					tbExamSchemeDetail.setTbExamScheme(tbExamScheme);
					ESService.saveSchemeDetail(tbExamSchemeDetail);
					  }
				ESService.update(tbExamScheme);

			}

		}

		if (delete!=null&&delete!="") {
			tbTactics.setTDel("0");
			ESService.TbTacticsupdate(tbTactics);
		}

		return "examSchemeAdd2_1";

	}



	// examSchemeAdd4：查询及添加题目

	public String examSchemeAdd4() {


		String[] values= ServletActionContext.getRequest().getParameterValues("checked");
		if (values!=null) {
			for(int i=0;i<values.length;i++){
				int Id = Integer.valueOf(values[i]);
				TbProblem tbProblem=ESService.findByHQLTbProblem(Id);
				tbProblem.setCol3("1");
				ESService.updateTbProblem(tbProblem);	
			}
		}
		int totalRows = ESService.getRow();
		Pager pager = PagerHelper.getPager(ServletActionContext.getRequest(),totalRows);
		List<?> list = ESService.findWithPage(pager.getStartRow(), pager.getPageSize());
		ServletActionContext.getRequest().setAttribute("totalPage",pager.getTotalPages());
		ServletActionContext.getRequest().setAttribute("currentPage",pager.getCurrentPage());
		ServletActionContext.getRequest().setAttribute("list", list);

		return "examSchemeAdd4";
	}



	// 考试方案信息
	public String examSchemeQuery3() {
		int id = Integer.valueOf(ServletActionContext.getRequest().getParameter("ID"));
		TbExamScheme tbExamScheme11= ESService.findByHQL(id);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaa"+tbExamScheme11.getEsDescribe());
		ServletActionContext.getRequest().getSession().setAttribute("tes", tbExamScheme11);
		String HQL="已提交";
		TbAuditStatus tbAuditStatus=ESService.findByHQL(HQL);
		tbExamScheme11.setTbAuditStatus(tbAuditStatus);
		ESService.update(tbExamScheme11);
		return "examSchemeQuery3";

	}

	// 考试方案查询11111
	public String examSchemeQuery() {


		String txtAddress = ServletActionContext.getRequest().getParameter("txtAddressssss");
		String esMyselfId1= ServletActionContext.getRequest().getParameter("Id_esId3");
		String esMyselfId2= ServletActionContext.getRequest().getParameter("esMyselfId2");
		if (esMyselfId1 != "" && esMyselfId1 != null) {
			int MyselfId = Integer.valueOf(esMyselfId1);
			TbExamScheme tbExamScheme11 = ESService.findByHQL(MyselfId);
			tbExamScheme11.setEsDel("1");
			ESService.update(tbExamScheme11);
		}
		if (esMyselfId2 != "" && esMyselfId2 != null) {
			int MyselfId = Integer.valueOf(esMyselfId2);
			TbExamScheme tbExamScheme11 = ESService.findByHQL(MyselfId);
			tbExamScheme11.setEsDescribe(txtAddress);
			tbExamScheme11.setEsDel("0");
			ESService.update(tbExamScheme11);
		}


		int totalRows = ESService.getRowNum();
		Pager pager = PagerHelper.getPager(ServletActionContext.getRequest(),totalRows);
		List<?> list = ESService.findWithPageSchamaPlan(pager.getStartRow(),pager.getPageSize());
		ServletActionContext.getRequest().setAttribute("totalPage",pager.getTotalPages());
		ServletActionContext.getRequest().setAttribute("currentPage",pager.getCurrentPage());
		ServletActionContext.getRequest().setAttribute("list", list);




		return "examSchemeQuery";

	}



	// 考试方案维护
	@SuppressWarnings("unchecked")
	public String examSchemeQuery2() {

		int Id=Integer.valueOf(ServletActionContext.getRequest().getParameter("Id_esId"));
		TbExamScheme tbExamScheme=ESService.findByHQL(Id);
		ServletActionContext.getRequest().getSession().setAttribute("tes", tbExamScheme);

		String[] value123= ServletActionContext.getRequest().getParameterValues("checked11");
		String txtAddress=ServletActionContext.getRequest().getParameter("txtAddressssss");
		String Id_esId1=ServletActionContext.getRequest().getParameter("Id_esId1");
		String Id_esId2=ServletActionContext.getRequest().getParameter("Id_esId2");
	
		//策略删除
		if (Id_esId2!=""&&Id_esId2!=null) {
			
			if (value123!=null) {
				for(int i=0;i<value123.length;i++){
					int iiId = Integer.valueOf(value123[i]);
					TbTactics tbTactics=ESService.TbTacticsfindByHQLQuery(iiId);
					tbTactics.setTDel("1");
					ESService.TbTacticsupdate(tbTactics);
					
					Iterator<TbExamSchemeDetail> iter=(Iterator<TbExamSchemeDetail>)tbTactics.getTbExamSchemeDetails();
					while(iter.hasNext()){
						TbExamSchemeDetail tbExamSchemeDetail=iter.next();
						tbExamSchemeDetail.setTbTactics(null);
						ESService.updatetbExamSchemeDetail(tbExamSchemeDetail);
					}
					
				}
			}
		}
	//方案维护保存
		if (Id_esId1!=""&&Id_esId1!=null) {
			if (value123!=null) {
			   for(int i=0;i<value123.length;i++){ 
				int iiId = Integer.valueOf(value123[i]);
				TbTactics tbTactics=ESService.TbTacticsfindByHQLQuery(iiId);
				Iterator<TbExamSchemeDetail> iter=(Iterator<TbExamSchemeDetail>)tbTactics.getTbExamSchemeDetails();
				  while(iter.hasNext()){
					TbExamSchemeDetail tbExamSchemeDetail=iter.next();
					tbExamSchemeDetail.setTbTactics(null);
					tbExamSchemeDetail.setTbTactics(tbTactics);
					tbExamSchemeDetail.setTbExamScheme(tbExamScheme);
					ESService.updatetbExamSchemeDetail(tbExamSchemeDetail);
					               }
			             }
			     }
			tbExamScheme.setEsDescribe(txtAddress);
			ESService.update(tbExamScheme);	
		   }
		return "examSchemeQuery2";
	}








	// 考试方案审核222222
	public String examSchemeAudit() {

		int totalRows = ESService.getRowNum();
		Pager pager = PagerHelper.getPager(ServletActionContext.getRequest(),
				totalRows);
		List<?> list = ESService.findWithPageSchamaPlan(pager.getStartRow(),pager.getPageSize());
		ServletActionContext.getRequest().setAttribute("totalPage",pager.getTotalPages());
		ServletActionContext.getRequest().setAttribute("currentPage",pager.getCurrentPage());
		ServletActionContext.getRequest().setAttribute("list", list);


		String esMyselfId11 = ServletActionContext.getRequest().getParameter("esMyselfId11");
		String esMyselfId22=ServletActionContext.getRequest().getParameter("esMyselfId22");
		String txt=ServletActionContext.getRequest().getParameter("txtAddresssssssssss");


		if (esMyselfId11!=""&& esMyselfId11!= null) {
			int MyselfId11 = Integer.valueOf(esMyselfId11);
			TbExamScheme tbExamScheme22= ESService.findByHQL(MyselfId11);
			String HQ="已通过";
			TbAuditStatus tbAuditStatus=ESService.findByHQL(HQ);	
			tbExamScheme22.setTbAuditStatus(tbAuditStatus);
			ESService.update(tbExamScheme22);
		}
		if (esMyselfId22!= ""&&esMyselfId22!=null) {
			int MyselfId22 = Integer.valueOf(esMyselfId22);
			TbExamScheme tbExamScheme22= ESService.findByHQL(MyselfId22);
			String HQ="已拒绝";
			TbAuditStatus tbAuditStatus=ESService.findByHQL(HQ);
			tbExamScheme22.setTbAuditStatus(tbAuditStatus);
			ESService.update(tbExamScheme22);

		}

		return "examSchemeAudit";
	}


	// 考试方案审核状态
	public String examSchemeAudit2() {

		int esMyselfId = Integer.valueOf(ServletActionContext.getRequest().getParameter("Id_esMyselfId"));
		TbExamScheme tbExamScheme = ESService.findByHQL(esMyselfId);
		ServletActionContext.getRequest().getSession().setAttribute("tes", tbExamScheme);
		return "examSchemeAudit2";
	}
	// 方案撤销查询3333333
	public String examSchemeCancel() {

		int totalRows = ESService.getRowNum();
		Pager pager = PagerHelper.getPager(ServletActionContext.getRequest(),totalRows);
		List<?> list = ESService.findWithPageSchamaPlan(pager.getStartRow(),pager.getPageSize());
		ServletActionContext.getRequest().setAttribute("totalPage",pager.getTotalPages());
		ServletActionContext.getRequest().setAttribute("currentPage",pager.getCurrentPage());
		ServletActionContext.getRequest().setAttribute("list", list);


		String txtAddress = ServletActionContext.getRequest().getParameter("txtAddress");
		String esMyselfId = ServletActionContext.getRequest().getParameter("esMyselfId");
		if (esMyselfId != "" && esMyselfId != null) {
			int MyselfId = Integer.valueOf(esMyselfId);
			TbExamScheme tbExamScheme11 = ESService.findByHQL(MyselfId);
			tbExamScheme11.setCol3(txtAddress);
			tbExamScheme11.setEsDel("1");
			ESService.update(tbExamScheme11);

		}

		return "examSchemeCancel";
	}

	// 方案撤销
	@SuppressWarnings("unchecked")
	public String examSchemeCancel2() {

		int esMyselfId = Integer.valueOf(ServletActionContext.getRequest().getParameter("Id_esMyselfId"));
		TbExamScheme tbExamScheme = ESService.findByHQL(esMyselfId);
		ServletActionContext.getRequest().getSession().setAttribute("tes",tbExamScheme);
		return "examSchemeCancel2";

	}

	// 策略信息
	public String examSchemeQuery4() {

		int MyfId = Integer.valueOf(ServletActionContext.getRequest().getParameter("tbTactics"));
		TbTactics tbTactics = ESService.TbTacticsfindByHQLQuery(MyfId);
		ServletActionContext.getRequest().setAttribute("tbTactics", tbTactics);
		System.out.println(MyfId);

		return "examSchemeQuery4";
	}


	// 题目信息
	public String quesLibQuery3() {

		int Problem_Id = Integer.valueOf(ServletActionContext.getRequest().getParameter("tbP_Id"));
		TbProblem tbProblem = ESService.findByHQLTbProblem(Problem_Id);
		ServletActionContext.getRequest().setAttribute("tbP", tbProblem);

		return "quesLibQuery3";
	}




	public ExamSchemaService getESService() {
		return ESService;
	}

	public void setESService(ExamSchemaService eSService) {
		ESService = eSService;
	}
	public NumberUtil getNumberUtil() {
		return numberUtil;
	}
	public void setNumberUtil(NumberUtil numberUtil) {
		this.numberUtil = numberUtil;
	}
}
