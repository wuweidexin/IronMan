<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>iSoftStone培训中心考试平台</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="<%= basePath %>webep/css/style.css" type="text/css">
</HEAD>
<BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<SCRIPT language="JavaScript1.2" src="<%= basePath %>webep/js/coolmenus4.js"></SCRIPT>
<SCRIPT language="JavaScript1.2" src="<%=basePath %>webep/js/chen.js"></SCRIPT>
<SCRIPT language="JavaScript1.2" src="<%= basePath %>webep/js/cm_addins.js"></SCRIPT>
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="pagetop">
					<TR>
						<TD width="420" nowrap class="headerLogo"><IMG src="<%= basePath %>webep/logo.gif"><IMG src="<%= basePath %>webep/logo_js.gif">
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
						<TD height="2" class="menuBl1"><IMG src="<%= basePath %>webep/space.gif" width="1" height="1"></TD>
					</TR>
					<TR>
						<TD height="3" class="menuBl2"><IMG src="<%= basePath %>webep/space.gif" width="1" height="1"></TD>
					</TR>
				</TABLE>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
					<TR>
						<TD><IMG src="<%= basePath %>webep/space.gif" width="778" height="1">
						</TD>
					</TR>
				</TABLE>
<P>
<SCRIPT language=JavaScript1.2>showMenu("","<%= basePath %>",2);
</SCRIPT>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#999999">
					<TR>
						<TD><IMG src="<%= basePath %>webep/space.gif" width="1" height="1"></TD>
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
			<form action="" name="form1" method="post">
				<TABLE border="0" class="top" width="700">
					<TR>
						<TD class="FormTitle" height="2" width="100%"><B>题目难度查询</B>
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
									<TD width="15%">	题目难度编号：
									</TD>
									<TD>										
										<INPUT class=box name="pdNo" size=20 maxLength=20 value="">
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	题目难度名称：
									</TD>
									<TD>
<INPUT class=box name="pdName" size=20 maxLength=20 value="">
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>
									</TD>
									<TD colspan="3" align="right">		
									<INPUT class="button" type="button"  name="search" value=" 增 加 " onclick="toAdd()">								
										<INPUT class="button" type="button"  name="search" value=" 查 找 " onclick="toFindWithCon()">
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
						<TD height="40" valign="top">
							<TABLE align="center" border="0" class="ItemList" height="20" width="96%">
								<TR height="24" align="middle">
									<TD class="ItemTitle" height="20" width="14%">	题目难度编号
									</TD>
									<TD class="ItemTitle" width="14%">	题目难度名称
									</TD>
								</TR>
								<c:forEach items="${list}" var="li">
								<TR align="middle" class="ItemBody">
									<TD class="ItemBody" height="20"><A href="systemsettingAction!toUpdateQlDifficutly?temp=${li.pdlId }">${li.pdlMyselfId }</A>
									</TD>
									<TD class="ItemBody">	${li.pdlName }
									</TD>
									
								</TR>
								</c:forEach>
<!--								<TR align="middle" class="ItemBody">-->
<!--									<TD class="ItemBody" height="20"><A href="qlDifficultySetting3.htm">	QD20051128002</A>-->
<!--									</TD>-->
<!--									<TD class="ItemBody">	困难-->
<!--									</TD>-->
<!--								</TR>-->
							</TABLE>
						</TD>
					</TR>
					<TR>
						<TD>	&nbsp;
						</TD>
					</TR>
				</TABLE>
				</form>
			</TD>
		</TR>
	</TABLE><BR>
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD class="pagefootTl"><IMG src="<%= basePath %>webep/space.gif" width="778" height="1"></TD>
		</TR>
		<TR>
			<TD height="25" class="pagefoot"><FONT face="Arial, Helvetica, sans-serif">&copy;</FONT> 2005-2007  版权所有 软通动力信息技术有限公司 Powered by 软通动力武汉开发中心
			</TD>
		</TR>
	</TABLE>
</BODY>
</HTML>
<SCRIPT language="JavaScript">function toAdd()
{	
	form1.action="systemsettingAction!toNext?temp=toAddQlDifficulty";
	form1.submit();
}
function toFindWithCon()
{
	for(i=0;i<form1.length;i++){
		if(!checkInput(form1.elements[i].value)){
			alert("为空或存在非法字符");
			return  ;
		}
	
	}
	form1.action="systemsettingAction!findQlDifficultyCondition";
	form1.submit();

}
function create()
{	
	document.location.href='qlDifficultySetting1.htm'; 
}
</SCRIPT>