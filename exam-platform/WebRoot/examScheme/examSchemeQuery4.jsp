<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="com.cissst.entity.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
									<TD align="center" class="sys"><A href="<%=basePath %>indexPageAction!exitSystem" class="syslink">退出登录</A><A href="<%=basePath %>indexPageAction!toResetPwd" class="syslink">修改密码</A>
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
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD width="20">	&nbsp;
			</TD>
			<TD align="left" valign="top">
				<TABLE border="0" class="top" width="700">
					<TR>
						<TD class="FormTitle" height="2" width="100%"><B>策略信息</B>
						</TD>
					</TR>
					<TR>
						<TD>	&nbsp;
						</TD>
					</TR>
					<TR>
						<TD>
							<TABLE align="center" border="0" width="90%">
								<TR>
									<TD  height="20" width="1%">
									</TD>
									<TD width="12%">	题目范围：
									</TD>
									<TD width="35%">
				
				                       <FONT color="#808080">${tbTactics.tbProblemScore.psName}</FONT>
				
									</TD>
									<TD width="12%">	题目难度：
									</TD>
									<TD>										
				 <FONT color="#808080">${tbTactics.tbProblemDifficultyLevel.pdlName}</FONT>
				
				
									</TD>
																		<TD width="12%">	题目类型：
									</TD>
									<TD>										
				 <FONT color="#808080">${tbTactics.tbProblemType.ptName}</FONT>
				
				
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
							 <%    
								   TbTactics tbTactics=(TbTactics)request.getAttribute("tbTactics"); 
			                       String free=tbTactics.getTGetTitleMethod();
			                           if(free.endsWith("1")){
			    	    %>
							
								<TR>

									<TD>	<input type="radio" name="userType" checked value="student" disabled>自动抽取
									</TD>
								</TR>
								<TR>

									<TD >
									<table border="1" bordercolor="#999999" width="100%">
									<tr bordercolor="#eaeaea"><td >题量：</td><td><FONT color="#808080">${tbTactics.TProblemNum}</FONT></td></tr>
									<tr bordercolor="#eaeaea"><td width="60">批阅方式：</td><td><input type="radio" name="checkType" checked value="student" disabled>自动批阅</td></tr>
									</table>
									</TD>
								</TR>
					<TR>
						<TD>	&nbsp;
						</TD>
					</TR>
								<TR>
<% 
			    	   
			       }else if(free.endsWith("0")){
			    	   
			    	   %>
									<TD>	<input type="radio" name="userType" checked value="student" disabled>手动指定
									</TD>
								</TR>
								<TR>
									<TD >
									<table border="1" bordercolor="#999999" width="100%">
<tr bordercolor="#eaeaea"><td><table><tr><td width="60">题量：</td><td><FONT color="#808080">${tbTactics.TProblemNum}</FONT></td></tr></table></td></tr>
									<tr bordercolor="#eaeaea"><td><table><tr><td width="60">批阅方式：</td><td>老师批阅</td></tr></table></td></tr>
									<tr  bordercolor="#eaeaea">
									<TD height="40" width="96%" valign="top">
										<TABLE align="left" border="0" class="ItemList" height="20" width="100%">
											<TR height="24" align="middle">
												
												<TD class="ItemTitle" width="14%">	题目编号
												</TD>
												<TD class="ItemTitle" width="14%">	题目类型
												</TD>
												<TD class="ItemTitle" width="14%">	录入人
												</TD>
												<TD class="ItemTitle" width="14%">	录入日期
												</TD>
												<TD class="ItemTitle" width="14%">	批阅方式
												</TD>
												
											</TR>
											<c:forEach items="${tbTactics.tbProblemType.tbProblems}" var="tbProblemType">

											<TR align="middle" class="ItemBody">
												
												<TD class="ItemBody">	<a href='<%=basePath%>examSchemaAction!quesLibQuery3?tbP_Id=${tbProblemType.PId}'>${tbProblemType.col1}</a>
												</TD>
												<TD class="ItemBody">	${tbProblemType.tbProblemType.ptName}
												</TD>
												
												<TD class="ItemBody" align="left">	${tbProblemType.tbUser.UName }
												</TD>
												
												
												
												<TD class="ItemBody">	${tbProblemType.PAddTime}
												</TD>
											
												
												
												<TD class="ItemBody" align="left">	老师批阅
												</TD>
											</TR>
										
												</c:forEach>	
												  		<% 
			    	                     }   
			                         %>	
							</TABLE>
						</TD>
					</TR>
					<TR>
						<TD>
<HR width="98%">
						</TD>
					<TR>
						<TD>
							<TABLE align="center" border="0" width="90%">
								<TR>
									<TD height="20" width="1%">
									</TD>
									<TD width="12%">	每题分数：
									</TD>
									<TD width="87%">										
 <FONT color="#808080">${tbTactics.TEveryMark}</FONT>
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
						<TD>
<HR width="98%">
						</TD>
					</TR>
					<TR>
						<TD>
							<TABLE align="center" border="0" width="90%">
								<TR>
									<TD align="right">
										<INPUT class="button" type="button"  name="search" value=" 返 回 " onclick="javascript:history.back(-1)">
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
					<TR>
						<TD>	&nbsp;
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
function save()
{	
	document.location.href='examSchemaAction!examSchemeAdd2'; 
}
function toReturn()
{	
	document.location.href='examSchemaAction!examSchemeAdd'; 
}
function add()
{	
	document.location.href='examSchemaAction!examSchemeAdd4'; 
}
function ddelete()
{	
	if(confirm("确定删除该题吗？"))
	{
		alert("删除成功！"); 
		document.location.href='examSchemaAction!examSchemeAdd2'; 
	}
}
function dddelete()
{	
	if(confirm("确定删除该策略吗？"))
	{
		alert("删除成功！"); 
		document.location.href='examSchemaAction!examSchemeAdd'; 
	}
}


</SCRIPT>