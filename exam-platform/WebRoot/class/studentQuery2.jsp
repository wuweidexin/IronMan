<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<HTML>
<HEAD>
<TITLE>iSoftStone培训中心考试平台</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="<%=basePath %>webep/css/style.css" type="text/css">
</HEAD>
<BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<SCRIPT language="JavaScript1.2" src="<%=basePath %>webep/js/coolmenus4.js"></SCRIPT>
<SCRIPT language="JavaScript1.2" src="<%=basePath %>webep/js/cm_addins.js"></SCRIPT>
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
						<TD class="FormTitle" height="2" width="100%"><B>学生维护</B>
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
										<INPUT class="box" name="Discribe" size="20" maxLength="20" value="${student.tbClasses.CNum }" readonly="true">
									</TD>								
   								</TR>
   								<TR>
								    <TD height="20" width="1%">
   									</TD>
									<TD width="12%">	班级名称：
									</TD>
									<TD>										
										${student.tbClasses.CName}
									</TD>									
								</TR>
								<TR>
								     <TD height="20">
   									</TD>
   									<TD>	班级类型：
									</TD>
									<TD>										
										${student.tbClasses.tbClassType.ctName}
									</TD>
   								</TR>
   								<TR>	
								<TR>
								     <TD height="20">
   									</TD>
   									<TD>	学生帐号：
   									</TD>
   									<TD>
										${student.col1}
										&nbsp;
									<input class=button type=button name="reset" value=" 重置密码 " onclick="reset()">
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
									<TD width="12%">	学生姓名：
   									</TD>
   									<TD width="35%">
									<INPUT class="box" name="Discribe" size="20" maxLength="20" value="${student.col2}" >
   									</TD>
									<TD colspan="2">
   									</TD>
									<TD width="12%">	学生状态：
									</TD>
									<TD width="35%">	
									<select name="">
									<option value="">${student.tbStudentStatus.ssName}</option>
									<c:forEach items="${stuStaList}" var="sst">
									<option value="${sst.ssName}">${sst.ssName}</option>
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
				 <input type="Radio" name="sex" checked>男&nbsp;&nbsp; <input type="Radio" name="sex">女
   									</TD>
									<TD colspan="2">
   									</TD>
									<TD width="12%">	学生类型：
									</TD>
									<TD width="35%">										
										<font color="#808080">${student.tbStudentType.stName}</font>
									</TD>
   								</TR>						
								<TR>
								    <TD height="20" width="1%">
   									</TD>
									<TD width="12%">	录入日期：
									</TD>
									<TD width="35%">										
										<font color="#808080">${student.tbClasses.CStartTime}</font>
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
										<input class=button type=button name="commit" value=" 更 新 " onclick="commit()">
										<input class=button type=button name="del" value=" 删 除 " onclick="del()">
										<input class=button type=button name="end" value=" 结 业 " onclick="end()">
										<input class=button type=button name="back" value=" 退 学 " onclick="back()">
										<input class=button type=button name="bsave" value=" 返 回 " onclick="nextBack()">
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
</BODY>
</HTML>
<SCRIPT language="JavaScript">function next()
{	
	document.location.href='studentQuery.htm'; 
}
function commit()
{	
	if(confirm("确定更新信息吗？"))
	{
		alert("更新成功！"); 
		document.location.href='studentQuery.htm'; 
	}
}
function back()
{	
	if(confirm("确定退学吗？"))
	{
		alert("退学成功！"); 
		document.location.href='<%=basePath %>classMangerAction!backAndEnd?student_back=${student.stuId}'; 
	}
}
function reset()
{
	if(confirm("确定重置吗？"))
	{
		alert("重置成功！"); 
		document.location.href='studentQuery2.htm'; 
	}
}
function end()
{
	if(confirm("确定结业吗？"))
	{
		alert("结业成功！"); 
		document.location.href='<%=basePath %>classMangerAction!backAndEnd?student_end=${student.stuId}'; 
	}
}
function del()
{	
	if(confirm("确定删除吗？"))
	{
		alert("删除成功！"); 
		document.location.href=''; 
	}
}

function nextBack()
{	
	
		document.location.href='<%=basePath %>classMangerAction!studentQuery?isNew=1'; 

}
</SCRIPT>