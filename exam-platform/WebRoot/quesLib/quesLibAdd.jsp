<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>iSoftStone培训中心考试平台</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="<%=basePath %>webep/css/style.css" type="text/css">
</HEAD>
<BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<SCRIPT language="JavaScript1.2" src="<%=basePath %>webep/js/coolmenus4.js"></SCRIPT>
<SCRIPT language="JavaScript1.2" src="<%=basePath %>webep/js/cm_addins.js"></SCRIPT>
<FORM action=""  name="form1" method="post">
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="pagetop">
					<TR>
						<TD width="420" nowrap class="headerLogo"><IMG src="<%=basePath %>webep/logo.gif"><IMG src="<%=basePath %>webep/logo_js.gif">
						</TD>
						<TD class="welcome">
						</TD>
						<TD width="187" align="right" nowrap class="headerHelp">
							<TABLE border="0" cellpadding="4" cellspacing="2">
								<TR>
									<TD align="center" class="sys">  <A href="<%=basePath %>indexPageAction!exitSystem" class="syslink">退出登录</A>
											<A href="<%=basePath %>indexPageAction!toResetPwd" class="syslink">修改密码</A>
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
						<TD height="2" class="menuBl1"><IMG src="<%=basePath %>webep/space.gif" width="1" height="1"></TD>
					</TR>
					<TR>
						<TD height="3" class="menuBl2"><IMG src="<%=basePath %>webep/space.gif" width="1" height="1"></TD>
					</TR>
				</TABLE>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
					<TR>
						<TD><IMG src="<%=basePath %>webep/space.gif" width="778" height="1"></TD>
					</TR>
				</TABLE>
<P>
<SCRIPT language=JavaScript1.2>showMenu("","<%=basePath %>",2);
</SCRIPT>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#999999">
					<TR>
						<TD><IMG src="<%=basePath %>webep/space.gif" width="1" height="1"></TD>
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
						<TD class="FormTitle" height="2" width="100%"><B>题目新增－第一步（共二步）</B>
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
									<TD width="12%">	题目类型：
									</TD>
									<TD>
				<select id="ptId" name="ptId" > 
				<option value="" selected>请选择</option>
				<c:forEach items="${proTypeList}" var="sl">
				<option value=${sl.ptId }>${sl.ptName }</option>
				</c:forEach>
				</select>
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	题目范围：
									</TD>
									<TD>
				<select id="psId" name="psId" > 
				<option value="" selected>请选择</option>
				<c:forEach items="${ProScopeList}" var="pl">
				<option value=${pl.psId }>${pl.psName }</option>
				</c:forEach>
				</select>
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	题目难度：
									</TD>
									<TD>
				<select id="pdlId" name="pdlId" > 
				<option value="" selected>请选择</option>
				<c:forEach items="${proDiffLevList}" var="dl">
				<option value=${dl.pdlId }>${dl.pdlName }</option>
				</c:forEach>
				</select>
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>
									</TD>
									<TD align="right">										
										<INPUT class="button" type="button" name="search" value="下一步 " onclick="next();">
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
			<TD class="pagefootTl"><IMG src="<%=basePath %>webep/space.gif" width="778" height="1"></TD>
		</TR>
		<TR>
			<TD height="25" class="pagefoot"><FONT face="Arial, Helvetica, sans-serif">&copy;</FONT> 2005-2007  版权所有 软通动力信息技术有限公司 Powered by 软通动力武汉开发中心
			</TD>
		</TR>
	</TABLE>
	</FORM>
</BODY>
</HTML>
<SCRIPT language="JavaScript">
function next()
{	
<%--	var probleNum = document.getElementsById("probleNum").value;--%>
<%--	if(document.form1.probleNum.value == "" ) {--%>
<%--		alert("请输入题目编号！！");--%>
<%--		return false;--%>
<%--	} --%>
<%--	var ptId = document.getElementsById("ptId").value;--%>
	 if(document.form1.ptId.value == "" ) {
		 alert("请选择题目类型！！");
		return false;
	} 
<%--	 var psId = document.getElementsById("psId").value;--%>
	 if(document.form1.psId.value == "" ) {
		 alert("请选择题目范围！！");
		return false;
	}
<%--	 var pdlId = document.getElementsById("pdlId").value;	--%>
    if(document.form1.pdlId.value == "" ) {
    	alert("请选择题目难度等级！！");
		return false;
	}
	form1.action='<%=basePath %>problemManagerAction!nextOutPut'; 
	form1.submit();
	
}
</SCRIPT>