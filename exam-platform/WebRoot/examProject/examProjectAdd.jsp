<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
	<HEAD>
		<TITLE>iSoftStone培训中心考试平台</TITLE>
		<META http-equiv="Content-Type" content="text/html; charset=gb2312">
		<LINK rel="stylesheet" href="<%=basePath %>webep/css/style.css"
			type="text/css">
	</HEAD>
	<BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0"
		marginheight="0">
		<SCRIPT language="JavaScript1.2"
			src="<%=basePath %>webep/js/coolmenus4.js"></SCRIPT>
		<SCRIPT language="JavaScript1.2" src="<%=basePath %>webep/js/chen.js"></SCRIPT>
		<script language="javascript" type="text/javascript"
			src="<%=basePath %>webep/js/My97DatePicker/WdatePicker.js"></script>
		<SCRIPT language="JavaScript1.2"
			src="<%=basePath %>webep/js/cm_addins.js"></SCRIPT>
		<script language="JavaScript" src="<%=basePath %>webep/js/Control.js"></script>
		<script language="JavaScript" src="<%=basePath %>webep/js/calendar.js"></script>
		<form action="" name="form1" method="post">
			<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
				<TR>
					<TD>
						<TABLE width="100%" border="0" cellpadding="0" cellspacing="0"
							class="pagetop">
							<TR>
								<TD width="420" nowrap class="headerLogo">
									<IMG src="<%=basePath %>webep/logo.gif">
									<IMG src="<%=basePath %>webep/logo_js.gif">
								</TD>
								<TD class="welcome">
								</TD>
								<TD width="187" align="right" nowrap class="headerHelp">
									<TABLE border="0" cellpadding="4" cellspacing="2">
										<TR>
											<TD align="center" class="sys">
						<A href="<%=basePath%>indexPageAction!exitSystem" class="syslink">退出登录</A> <A href="<%=basePath%>indexPageAction!toResetPwd" class="syslink">修改密码</A>
											</TD>
										</TR>
									</TABLE>
								</TD>
							</TR>
						</TABLE>
						<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
							<TR>
								<TD height="24" class="menuMain">
									<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
										<TR>
											<TD>
												&nbsp;
											</TD>
										</TR>
									</TABLE>
								</TD>
							</TR>
							<TR>
								<TD height="2" class="menuBl1">
									<IMG src="<%=basePath %>webep/space.gif" width="1" height="1">
								</TD>
							</TR>
							<TR>
								<TD height="3" class="menuBl2">
									<IMG src="<%=basePath %>webep/space.gif" width="1" height="1">
								</TD>
							</TR>
						</TABLE>
						<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
							<TR>
								<TD>
									<IMG src="<%=basePath %>webep/space.gif" width="778" height="1">
								</TD>
							</TR>
						</TABLE>
						<P>
							<SCRIPT language=JavaScript1.2>showMenu("","<%=basePath %>",2);
</SCRIPT>
							<TABLE width="100%" border="0" cellpadding="0" cellspacing="0"
								bgcolor="#999999">
								<TR>
									<TD>
										<IMG src="<%=basePath %>webep/space.gif" width="1" height="1">
									</TD>
								</TR>
							</TABLE>
					</TD>
				</TR>
			</TABLE>
			<BR>
			<form name="form1">
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
					<TR>
						<TD width="20">
							&nbsp;
						</TD>
						<TD align="left" valign="top">
							<TABLE border="0" class="top" width="700">
								<TR>
									<TD class="FormTitle" height="2" width="100%">
										考试计划新增
									</TD>
								</TR>
								<TR>
									<TD>
										&nbsp;
									</TD>
								</TR>
								<TR>
   						<TD>
   							<TABLE align="center" border="0" width="90%">
   								<TR>
								    <TD height="20" width="1%">
   									</TD>
   									<TD width="14%">	考试计划编号：
   									</TD>
   									<TD>
   									<c:if test="${plan.epMyselfId == null }">
									<INPUT class="box" name="planId" size="20" maxLength="20" value="系统自动生成" disabled>
									</c:if>
									<c:if test="${plan.epMyselfId != null }">
									<INPUT class="box" name="planId" size="20" maxLength="20" value="${plan.epMyselfId}" disabled>
									</c:if>
									</TD>
   									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<TD width="14%">	考试计划名称：
									</TD>
   									<TD>
									<INPUT class="box" name="planName" size="20" maxLength="20" value="${plan.planName }">
   									</TD>
									
   								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	考试计划描述：
									</TD>
									<TD>
<TEXTAREA class=box cols=40 name="txtAddress" rows=3 value="${plan.planDescribe }" ></TEXTAREA> 
									</TD>
								</TR>
   							</TABLE>
   						</TD>
   					</TR>
								<TR>
									<TD>
										<HR width="98%">
									</TD>
								</TR>
								<TR>
									<TD>
										<TABLE align="center" border="0" width="90%">
											<TR>
												<TD height="20" width="1%">
												</TD>
												<TD width="15%">
													班级名称：
												</TD>
												<TD width="35%">
													<select name="classesName">
														<option value="">
															请选择
														</option>
														<c:forEach items="${classesname}" var="cn">
															<option value="${cn.CId}">
																${cn.CName }
															</option>
														</c:forEach>
													</select>
												</TD>
												<TD colspan="2">
												</TD>
											</TR>
											<TR>
												<TD height="20">
												</TD>
												<TD>
													考试时间：
												</TD>
												<TD colspan="3">
													由：
													<INPUT type="text" name="examTimeStart" class="Wdate"
														value="${plan.planStartTime }" onClick="WdatePicker()">
													&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;到：
													<INPUT type="text" name="examTimeEnd" class="Wdate"
														value="${plan.planEndTime }" onClick="WdatePicker()">
													&nbsp;
												</TD>
											</TR>
											<TR>
												<TD height="20">
												</TD>
												<TD>
													考试方案名称：
												</TD>
												<TD>
													<select name="examSchemeName">
														<option value="">
															请选择
														</option>
														<c:forEach items="${examschemename}" var="sn">
															<option value="${sn.esId }">
																${sn.esName }
															</option>
														</c:forEach>
													</select>
												</TD>

												<TD>
													批阅截至时间：
												</TD>
												<TD>
													<INPUT type="text" name="readOverTime" class="Wdate"
														value="${plan.planReadOverTime }" onClick="WdatePicker()">
													&nbsp;
												</TD>
											</TR>
											<TR>
												<TD height="20">
												</TD>
												<TD width="15%">
													批阅人：
												</TD>
												
												<TD>
												<INPUT class="box" name="readerName" size="20" maxLength="20" value="${plan.col3 }">
													<!-- <select name="readerName">
														<option value=''>全部</option>
														<c:forEach items="${reader}" var="red">
														<option value="">${red.col3 }</option>
														</c:forEach>
														</select> -->
												</TD>
												
											</TR>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD>
										<HR width="98%">
									</TD>
								</TR>
								<TR>
									<TD>
										<TABLE align="center" border="0" width="90%">
											<TR>
												<TD align="right">
													<input class=button type=button name="bsave" value=" 试卷预览 "
														onclick="issue()">
													<input class=button type=button name="bsave" value=" 保 存 "
														onclick="save()">
													<input class=button type=reset name="bsave" value=" 删 除 "
														onclick="ddelete(${plan.planId})";>
												</TD>
											</TR>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD>
										&nbsp;
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
					</form>
				</TABLE>
				<BR>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
					<TR>
						<TD class="pagefootTl">
							<IMG src="<%=basePath %>webep/space.gif" width="778" height="1">
						</TD>
					</TR>
					<TR>
						<TD height="25" class="pagefoot">
							<FONT face="Arial, Helvetica, sans-serif">&copy;</FONT>2005-2007
							版权所有 软通动力信息技术有限公司 Powered by 软通动力武汉开发中心
						</TD>
					</TR>
				</TABLE>
			</form>
	</BODY>
</HTML>
<SCRIPT language="JavaScript">
function toReturn()
{	
	document.location.href='examSchemeAdd.htm'; 
}
function commit()
{	
	if(confirm("确定提交该考试计划吗？"))
	{
		alert("提交成功！"); 
		document.location.href='examProjectQuery3.htm'; 
	}
}
function save()
{	
	for(i=0;i<form1.length;i++){
	
		if(form1.elements[i].value==""){
				alert("表单信息不能为空");
				return false;
		}
		if(!checkInput(form1.elements[i].value)){
			alert("空或存在非法字符");
			return  ;
		}
	
	}
	if(confirm("确定保存该考试计划吗？"))
	{
		alert("保存成功！"); 
		document.form1.action="examPlanAction!examPlanAddSave";
		document.form1.submit();
	}
	
}
function ddelete(planId)
{	
	if(confirm("确定删除该考试计划吗？"))
	{
		alert("删除成功！"); 
		document.form1.action="examPlanAction!examProjectAdddelete?planId="+planId; 
		document.form1.submit();
	}
}
function issue()
{	
		document.form1.action="examPlanAction!examPage"; 
		document.form1.submit();
	
}
</SCRIPT>