<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
    <TITLE>
        iSoftStone培训中心考试平台
    </TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="<%=basePath%>webep/css/style.css" type="text/css">
</HEAD>
   <BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<SCRIPT language="JavaScript1.2" src="<%=basePath%>webep/js/coolmenus4.js"></SCRIPT>
<SCRIPT language="JavaScript1.2" src="<%=basePath%>webep/js/cm_addins.js"></SCRIPT>
<form action="" name="form6" method="post">
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
   									<TD align="center" class="sys"><A href="<%=basePath%>Index.htm" class="syslink">
退出登录
</A><A href="password.htm" class="syslink">
修改密码
</A>
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
   						<TD class="FormTitle" height="2" width="100%">	成绩发布
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
								    <TD height="20" width="1%">
   									</TD>
   									<TD width="15%">	考试计划编号：
   									</TD>
   									<TD>
									<font color="#808080">${examPlanIssue.epMyselfId }</font>
   									</TD>
   								</TR>
								<TR>
								    <TD height="20">
   									</TD>
								    <TD>	考试计划名称：
   									</TD>
   									<TD>
									<font color="#808080">${examPlanIssue.planName }</font>
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
									<TD width="15%">	班级名称：
   									</TD>
   									<TD width="35%">
									<font color="#808080">${examPlanIssue.tbClasses.CName  }</font>
   									</TD>
									<TD colspan="2">
   									</TD>
   								</TR>
								<TR>
								    <TD height="20">
   									</TD>
									<TD>	考试时间：
   									</TD>
   									<TD>
									<font color="#808080">${examPlanIssue.planStartTime }－${examPlanIssue.planEndTime}</font>
   									</TD>
									
   								</TR>
								<TR>
   									<TD height="20">
   									</TD>
									<TD>	考试方案：
   									</TD>
   									<TD>
									<font color="#808080">${examPlanIssue.tbExamScheme.esMyselfId }</font>
   									</TD>
									<TD colspan="2">
   									</TD>
								</TR>
								<TR>
   									<TD height="20">
   									</TD>
									<TD>	参加考试人数：
   									</TD>
   									<TD>
									<font color="#808080">${stuTotal}</font>
   									</TD>									
   								</TR>
								<TR>
   									<TD height="20">
   									</TD>
									<TD>	批阅方式：
   									</TD>
   									<TD>
									<font color="#808080">${examPlanIssue.tbReadType.rtName}</font>
   									</TD>
									<TD width="12%">	批阅人：
   									</TD>
									<TD>
				                    <font color="#808080">${examPlanIssue.col3}</font>
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
										<input class=button type=button name="bsave" value=" 发 布 " onclick="set(${examPlanIssue.planId})">
										<input type="hidden" name="issueId" value="${issueId}">
										<input class=button type=button name="bsave" value=" 返 回 " onclick="javascript:history.back(-1)">
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
   			<TD height="25" class="pagefoot">   			   
   			   <FONT face="Arial, Helvetica, sans-serif">&copy;</FONT>2005-2007  版权所有 软通动力信息技术有限公司 Powered by 软通动力武汉开发中心
   			</TD>
   		</TR>
   	</TABLE>
   	</form>
   </BODY>
</HTML>
<SCRIPT language="JavaScript">
function set(i)
{	
	if(confirm("确定发布成绩吗？"))
	{
		form6.action="<%=basePath%>scoreManagerAction!issue?pId=" +i; 
		form6.submit();
		alert("发布成功！"); 
	}
}

</SCRIPT>