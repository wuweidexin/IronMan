<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>iSoftStone��ѵ���Ŀ���ƽ̨</TITLE>
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
									<TD align="center" class="sys"><A href="<%=basePath%>Index.htm" class="syslink">�˳���¼</A> <A href="password.htm" class="syslink">�޸�����</A>
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
<%-- ��ſ�ʼ--%>				
					<TR>
						<TD class="QuestionTitle">
							<TABLE border="0" width="100%" height="20">								
								<TR>
									<TD width="1%">	&nbsp;
									</TD>
									<TD><STRONG>��${Ai.index+1}��</STRONG>
									</TD>
									<TD width="60">										
										�÷�<INPUT  type="text" name="score" value="" size="5"/>
										<input type="hidden" name="gradeForCheck" value="${examPlanId}">
										<input type="hidden" name="paperId" value="${paperId}"> 
										<input type="button" name="save" value="����" onclick="saveScore(${answer.epaId})">
									</TD>
									<TD width="60">
									<input class=button type=button name="bsave" value=" �� �� "
												onclick="back(${answer.tbExamPaper.tbExamPlan.planId})">
									</TD>
									<TD width="3%">	&nbsp;
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
<%-- ��Ž���--%>
					<TR>
						<TD class="QuestionBody">
							<TABLE border="0" width="100%">
<%--��Ŀ���⿪ʼ--%>
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
<%--��Ŀ�������--%>
                   <c:if test="${answer.tbProblem.tbProblemType.ptName=='ѡ����'}">			
<%--ѡ�ʼ--%>
                       <c:forEach items="${answer.tbProblem.tbProblemResults}" var="problemResult" varStatus="Ri">
								<TR>
									<TD>
										<TABLE border="0" width="100%" cellspacing="0" cellpadding="0" >
											<TR>
												<TD width="3%">	&nbsp;
												</TD>
                                         <%--��ѡ�����ʾ������ѡ��--%>
                                                <c:set var="temp" value=""></c:set>
												<c:forEach items="${answer.tbProblemAnswers}" var="problemAnswers">
												<c:if test="${problemResult.prId==problemAnswers.paComment}">
												  <c:set var="temp" value="checked"></c:set>
												</c:if>
												</c:forEach>	
										  <%--��ѡ�����ʾ������ѡ��--%>	
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
<%--ѡ�����--%>
<%--��������ݿ�ʼ--%>
						 <c:if test="${answer.tbProblem.tbProblemType.ptName=='�����'}">
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
<%--��������ݽ���--%>
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
			<TD height="25" class="pagefoot"><FONT face="Arial, Helvetica, sans-serif">&copy;</FONT> 2005-2007  ��Ȩ���� ��ͨ������Ϣ�������޹�˾ Powered by ��ͨ�����人��������
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
	  alert("����ȷ�����ֵ��");  
	       return false;  
	   }  
	if(confirm("ȷ�����浽����������"))
	{
		form5.action="<%=basePath%>scoreManagerAction!saveScore?answerId="+i;
		form5.submit();
		alert("����ɹ���"); 
	}
}
function back(i)
{	
	document.location.href='<%=basePath%>scoreManagerAction!gradeCheckList?c_id1='+ i;
}


<%--function save(i)--%>
<%--{	--%>
<%----%>
<%--	if(confirm("ȷ�����浽����������"))--%>
<%--	{--%>
<%--		form5.action="<%=basePath%>scoreManagerAction!saveScore?answerId="+i;--%>
<%--		form5.submit();--%>
<%--		alert("����ɹ���"); --%>
<%--	}--%>
<%----%>
<%--}--%>
<%--function commit()--%>
<%--{	--%>
<%--	if(confirm("ȷ������������"))--%>
<%--	{--%>
<%--		alert("����ύ�ɹ���"); --%>
<%--		document.location.href='<%=basePath%>grade/gradeCheckList.jsp'; --%>
<%--	}--%>
<%--}--%>
</SCRIPT>