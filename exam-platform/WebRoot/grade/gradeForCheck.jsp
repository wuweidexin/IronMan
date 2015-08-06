<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>iSoftStone培训中心考试平台</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="<%=basePath%>webep/css/style.css" type="text/css">
</HEAD>
<BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<SCRIPT language="JavaScript1.2" src="<%=basePath%>webep/js/coolmenus4.js"></SCRIPT>
<SCRIPT language="JavaScript1.2" src="<%=basePath%>webep/js/cm_addins.js"></SCRIPT>
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="pagetop">
					<TR>
						<TD width="420" nowrap class="headerLogo"><IMG src="<%=basePath%>webep/logo.gif"><IMG src="<%=basePath%>webep/logo_js.gif">
						</TD>
						<TD class="welcome">
						</TD>
						<TD width="187" align="right" nowrap class="headerHelp">
							<TABLE border="0" cellpadding="4" cellspacing="2">
								<TR>
									<TD align="center" class="sys"><A href="<%=basePath%>Index.htm" class="syslink">退出登录</A> <A href="password.htm" class="syslink">修改密码</A>
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
									<TD>	&nbsp;
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
					<TR>
						<TD height="2" class="menuBl1"><IMG src="<%=basePath%>webep/space.gif" width="1" height="1"></TD>
					</TR>
					<TR>
						<TD height="3" class="menuBl2"><IMG src="<%=basePath%>webep/space.gif" width="1" height="1"></TD>
					</TR>
				</TABLE>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
					<TR>
						<TD><IMG src="<%=basePath%>webep/space.gif" width="778" height="1"></TD>
					</TR>
				</TABLE>
<P>
<SCRIPT language=JavaScript1.2>showMenu("","../../exam-platform",2);
</SCRIPT>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#999999">
					<TR>
						<TD><IMG src="<%=basePath%>webep/space.gif" width="1" height="1"></TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE><BR>
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD width="20">	&nbsp;
			</TD>
			<TD align="left" valign="top">
				<TABLE border="0" class="top" width="98%">
					<TR bordercolor="#ffffff">
						<TD>
							<TABLE border="0">
								<TR>
									
									<TD valign="top" height="100%">
<form action="" method="post" name="form5" >
<c:forEach items="${answersSet}" var="answer" varStatus="Ai">
	<TABLE border="0" width="100%">
		<TR>
			<TD width="100%">
				<TABLE border="1" cellspacing="0" cellpadding="0" width="100%">
<%-- 题号开始--%>				
					<TR>
						<TD class="QuestionTitle">
							<TABLE border="0" width="100%" height="20">								
								<TR>
									<TD width="1%">	&nbsp;
									</TD>
									<TD><STRONG>第${Ai.index+1}题</STRONG>
									</TD>
									<TD width="60">										
										得分<INPUT  type="text" name="score" value="" size="5"/>
										<input type="hidden" name="gradeForCheck" value="${examPlanId}">
										<input type="hidden" name="paperId" value="${paperId}"> 
										<input type="button" name="save" value="保存" onclick="saveScore(${answer.epaId})">
									</TD>
									<TD width="60">
									<input class=button type=button name="bsave" value=" 返 回 "
												onclick="back(${answer.tbExamPaper.tbExamPlan.planId})">
									</TD>
									<TD width="3%">	&nbsp;
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
<%-- 题号结束--%>
					<TR>
						<TD class="QuestionBody">
							<TABLE border="0" width="100%">
<%--题目标题开始--%>
								<TR>
									<TD>
										<TABLE border="0" width="100%">												
											<TR>
												<TD width="2%">	&nbsp;
												</TD>
												<TD>${answer.tbProblem.PTitle }
												</TD>
											</TR>
										</TABLE>
									</TD>
								</TR>
<%--题目标题结束--%>
                   <c:if test="${answer.tbProblem.tbProblemType.ptName=='选择题'}">			
<%--选项开始--%>
                       <c:forEach items="${answer.tbProblem.tbProblemResults}" var="problemResult" varStatus="Ri">
								<TR>
									<TD>
										<TABLE border="0" width="100%" cellspacing="0" cellpadding="0" >
											<TR>
												<TD width="3%">	&nbsp;
												</TD>
                                         <%--在选项框显示中作答选项--%>
                                                <c:set var="temp" value=""></c:set>
												<c:forEach items="${answer.tbProblemAnswers}" var="problemAnswers">
												<c:if test="${problemResult.prId==problemAnswers.paComment}">
												  <c:set var="temp" value="checked"></c:set>
												</c:if>
												</c:forEach>	
										  <%--在选项框显示中作答选项--%>	
												<TD width="40">													
													<INPUT type="checkbox" name="answer1" value="" ${temp} disabled >&#${Ri.index+65}
												</TD>
												<TD>${problemResult.prContent}
												</TD>
											</TR>
										</TABLE>
									</TD>
								</TR>
						</c:forEach>
						</c:if>
<%--选项结束--%>
<%--简答题内容开始--%>
						 <c:if test="${answer.tbProblem.tbProblemType.ptName=='简答题'}">
						 <c:forEach items="${answer.tbProblemAnswers}" var="problemAnswers" varStatus="Ri">
							   <TR>
						         	<TD>
										<TABLE border="0" width="100%" cellspacing="0" cellpadding="0" >
											<TR>
												<TD width="3%">	&nbsp;
												</TD>
												<TD>
												<textarea rows="5" cols="100%" disabled="disabled">${problemAnswers.paComment}</textarea>
												</TD>
											</TR>
										</TABLE>
									</TD>
								</TR>
								</c:forEach>
						 </c:if>
<%--简答题内容结束--%>
							</TABLE>
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE>
  </c:forEach>
</form>
 <%--										<IFRAME frameborder="1" width="100%" src="examPage.htm" scrolling="auto" name="monitorlist" id="monitorlist" marginheight="0" marginwidth="0" height="100%"></IFRAME>--%>
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE><BR>
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD class="pagefootTl"><IMG src="<%=basePath%>webep/space.gif" width="778" height="1"></TD>
		</TR>
		<TR>
			<TD height="25" class="pagefoot"><FONT face="Arial, Helvetica, sans-serif">&copy;</FONT> 2005-2007  版权所有 软通动力信息技术有限公司 Powered by 软通动力武汉开发中心
			</TD>
		</TR>
	</TABLE>
</BODY>
</HTML>
<SCRIPT language="JavaScript">
function saveScore(i){
    var j=document.getElementById("score").value;
    
    var patrn=/^[0-9]+(.[0-9]{1,3})?$/; 
	    if(j==null||j==""||!patrn.exec(j))  
	 {  
	  alert("请正确输入分值！");  
	       return false;  
	   }  
	if(confirm("确定保存到服务器上吗？"))
	{
		form5.action="<%=basePath%>scoreManagerAction!saveScore?answerId="+i;
		form5.submit();
		alert("保存成功！"); 
	}
}
function back(i)
{	
	document.location.href='<%=basePath%>scoreManagerAction!gradeCheckList?c_id1='+ i;
}


<%--function save(i)--%>
<%--{	--%>
<%----%>
<%--	if(confirm("确定保存到服务器上吗？"))--%>
<%--	{--%>
<%--		form5.action="<%=basePath%>scoreManagerAction!saveScore?answerId="+i;--%>
<%--		form5.submit();--%>
<%--		alert("保存成功！"); --%>
<%--	}--%>
<%----%>
<%--}--%>
<%--function commit()--%>
<%--{	--%>
<%--	if(confirm("确定批阅完了吗？"))--%>
<%--	{--%>
<%--		alert("结果提交成功！"); --%>
<%--		document.location.href='<%=basePath%>grade/gradeCheckList.jsp'; --%>
<%--	}--%>
<%--}--%>
</SCRIPT>