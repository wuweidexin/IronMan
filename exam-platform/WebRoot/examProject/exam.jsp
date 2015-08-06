<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>iSoftStone培训中心考试平台</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="<%=basePath%>webep/css/style.css" type="text/css">

</HEAD>
<BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form action="" name="form1" method="post">
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
									<TD align="center" class="sys"><A href="<%=basePath%>indexPageAction!exitSystem" class="syslink">退出登录</A> <A href="<%=basePath%>indexPageAction!toResetPwd" class="syslink">修改密码</A>
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
<SCRIPT language=JavaScript1.2>showMenu("","<%=basePath%>",2);
</SCRIPT>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#999999">
					<TR>
						<TD><IMG src="<%=basePath%>webep/space.gif" width="1" height="1"></TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE><BR>
	<TABLE width="750" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD width="20">	&nbsp;
			</TD>
			<TD align="left" valign="top">
				<TABLE border="8" class="top" width="98%">
					<TR>
						<TD class="FormTitle" height="2" width="100%"><B>试卷预览(题目总数：${problemNum })</B>
						</TD>
					</TR>
					
					<TR bordercolor="#ffffff" >
						<TD >
							<TABLE border="0" width="100%">
							<c:forEach items="${list}" var="li" varStatus="i">	
								<TR>
									<TD valign="top"  width="100%">
				<TABLE border="1" cellspacing="0" cellpadding="0" width="100%">
					<TR>
						<TD class="QuestionTitle">
							<TABLE border="0" width="100%" height="20">
								<TR>
									<TD width="1%">	&nbsp;
									</TD>
									<TD><STRONG>第${i.index+1 }题</STRONG>
									</TD>
									
									<TD width="3%">	&nbsp;
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
					<TR>
						<TD class="QuestionBody">
							<TABLE border="0" width="100%">
								<TR>
									<TD>
										<TABLE border="0" width="100%">
											<TR>
												<TD width="2%">	&nbsp;
												</TD>
												<TD>	${li.tbProblem.PTitle }
												</TD>
											</TR>
										</TABLE>
									</TD>
								</TR>
								<c:if test="${li.tbProblem.tbProblemType.ptName == '选择题'}">
								<TR>
									<TD>
										<TABLE border="0" width="100%" cellspacing="0" cellpadding="0">
										<c:forEach items="${li.tbProblem.tbProblemResults}" var="ps" varStatus="psi">
											<TR>
												<TD width="3%">	&nbsp;
												</TD>
												<TD width="40">													
													<INPUT type="checkbox" name="answer1" value="" <c:if test="${ps.prTrueIdent == '1'}">checked</c:if> disabled>&#${psi.index+65 }
												</TD>
												<TD>	${ps.prContent }
												</TD>
											</TR>
										</c:forEach>
										</TABLE>
									</TD>
								</TR>
								</c:if>
								<c:if test="${li.tbProblem.tbProblemType.ptName == '填空题'}">
								<TR>
									<TD>
										<TABLE border="0" width="100%" cellspacing="0" cellpadding="0">
										<c:forEach items="${li.tbProblem.tbProblemResults}" var="ps" varStatus="psi">
											<TR>
												<TD><textarea rows="6" cols="120" disabled="disabled">${ps.prContent }</textarea>
												</TD>
											</TR>
										</c:forEach>
										</TABLE>
									</TD>
								</TR>
								</c:if>
							</TABLE>
						</TD>
					</TR>
				</TABLE>
									</TD>
								</TR>
								</c:forEach>
							</TABLE>
						</TD>
					</TR>
					<TR>
						<TD><IMG src="<%=basePath%>webep/space.gif" width="1" height="1"></TD>
					</TR>
					<tr>
					<td align="right">
					<INPUT type="submit" class="button" name="commit" value=" 重新生成 " onclick="save(${esId})">
	                <INPUT type="Button" class="button" name="commit" value=" 打 印 " >
	                <INPUT type="Button" class="button" name="commit" value=" 返回 " onclick="javascript:history.back(-1)">
					</td></tr>
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
	</form>
</BODY>
</HTML>
<SCRIPT language="JavaScript">function save(esId)
{	
	if(confirm("确定要重新生成吗？"))
	{
		alert("重新生成成功！"); 
		form1.action="<%=basePath%>examPlanAction!examPage?examSchemeName="+esId;
		form1.submit();
	}
}
function commit()
{	
	if(confirm("确定提交答卷吗？"))
	{
		alert("答卷提交成功！"); 
		document.location.href='<%=basePath%>login_s.htm'; 
	}
}
</SCRIPT>