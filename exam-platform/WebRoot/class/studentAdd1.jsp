<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<form action="" name="form1" method="post">
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
									<TD align="center" class="sys"><A href="<%=basePath %>Index.htm" class="syslink">退出登录</A> <A href="password.htm" class="syslink">修改密码</A>
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
						<TD class="FormTitle" height="2" width="100%"><B>学生新增—第二步（共二步）</B>
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
   									<TD width="12%">	班级编号：
   									</TD>
   									<TD>
										${tbClasses.CNum }
   									</TD>
									
   								</TR>
								<tr>
								   <TD height="20" width="1%">
   									</TD>
   									<TD width="12%">	班级名称：
   									</TD>
   									<TD>
										${tbClasses.CName }
   									</TD>
								</tr>
								<tr>
								   <TD height="20" width="1%">
   									</TD>
   									<TD width="12%">	班级类型：
   									</TD>
   									<TD>
										${tbClasses.tbClassType.ctName}
   									</TD>
								</tr>
								<TR>
								    <TD height="20" width="1%">
   									</TD>
   									<TD width="12%">	学生帐号：
   									</TD>
   									<TD>
										<INPUT class="box" name="stuNo" size="20" maxLength="20" value="" type="Text">
   									</TD>
   								</TR>
<%--								<TR>--%>
<%--								    <TD height="20">--%>
<%--   									</TD>--%>
<%--								    <TD>	初始密码：--%>
<%--   									</TD>--%>
<%--   									<TD>--%>
<%--									<INPUT class="box" name="initPassword"  size="20" maxLength="20" value="" type="Text"  disabled>--%>
<%--   									</TD>--%>
<%--								</TR>								--%>
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
									<TD width="12%">	学生姓名：
   									</TD>
   									<TD width="35%">
									<INPUT class="box" name="stuName" type="text" size="20" maxLength="20" value="" >
   									</TD>
									<TD width="12%">	学生类型：
   									</TD>
									<TD>										
				<select name="stuTypeId" > 
				<option value='1' selected>请选择 </option>
				<c:forEach items="${stuTypeList}" var="sl">
				<option value="${sl.stId}">${sl.stName} </option>
				</c:forEach>
				</select>
									</TD>
   								</TR>
								<TR>
								    <TD height="20">
   									</TD>
									<TD>	性别：
   									</TD>
   									<TD>
				 <input type="Radio" name="sex" checked value="1">男&nbsp;&nbsp;
				  <input type="Radio" name="sex" value="0">女
   									</TD>
									<TD colspan="2">
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
										<input class=button type="button" name="bsave" value=" 增 加 " onclick="create()">
										<input class=button type=button name="bsave" value=" 返 回 " onclick="next()">
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
		<TR>
			<TD>
<HR width="98%"><br>
			</TD>
		</TR>
		<tr><td></td>
		</tr></table>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr><td><br></td></tr>
			<TR>
				<TD class="pagefootTl"><IMG src="<%=basePath %>webep/space.gif" width="778" height="1"></TD>
			</TR>
			<TR>
				<TD height="25" class="pagefoot"><FONT face="Arial, Helvetica, sans-serif">&copy;</FONT> 2005-2007  版权所有 软通动力信息技术有限公司 Powered by 软通动力武汉开发中心
				</TD>
			</TR>
		</TABLE>
		</form>
</BODY>
</HTML>
<SCRIPT language="JavaScript">function create()
{	
	if(confirm("确定增加新学生吗？"))
	{
		alert("增加成功！"); 
		form1.action="<%=basePath %>classMangerAction!AddStudent?classId=${tbClasses.CId}";
		form1.submit(); 
	}
}

function next()
{	
	form1.action="<%=basePath %>classMangerAction!studentAdd?isNew=1"; 
	form1.submit();
}
</SCRIPT>