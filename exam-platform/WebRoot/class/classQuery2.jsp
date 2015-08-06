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
<FORM action="" name="form1" method="post">
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
						<TD class="FormTitle" height="2" width="100%"><B>班级维护</B>
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
										<font color="#808080">${tbClasses.CNum }</font>
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	班级名称：
									</TD>
									<TD>										
										<INPUT class=box name="claName"  size=20 maxLength=20 value="${tbClasses.CName }">
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	班主任：
									</TD>
									<TD>	
														<select name="UId" >
				<option value='1' selected>${tbClasses.tbUser.UName }</option>
				<c:forEach items="${teaList}" var="tl">
				<option value=${tl.UId }>${tl.UName }</option>
				</c:forEach>
				</select>								
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
									<TD width="12%">	创建日期：
									</TD>
									<TD width="35%">										
										<font color="#808080">${tbClasses.CStartTime }</font>
									</TD>
									<TD width="12%">	班级状态：
									</TD>
									<TD>										
										
										<select name="statusId" >
				<option value='1' selected>${tbClasses.tbClazzStatus.csName}</option>
				<c:forEach items="${claStatus}" var="cs">
				<option value=${cs.csName  }>${cs.csName }</option>
				</c:forEach>
				</select>
									</TD>
								</TR>
								<TR>
									<TD height="20" width="1%">
   									</TD>
									<TD width="12%">	班级类型：
   									</TD>
   									<TD width="60%">
									<select name="ctId" >
				<option value='1' >${tbClasses.tbClassType.ctName }</option>
				<c:forEach items="${claTypeList}" var="cl">
				<option value=${cl.ctId }>${cl.ctName }</option>
				</c:forEach>
				</select>
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
									<TD height="20" width="1%">
									</TD>
									<TD width="12%">	班级描述：
									</TD>
									<TD colspan="2">	<TEXTAREA class=box cols="70%" name="classDescribe" rows=5>${tbClasses.col1 }</TEXTAREA> 
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
										<input class=button type="submit" name="bsave" value=" 更 新 " onclick="commit()">
										<input class=button type="submit" name="bsave" value=" 结 业 " onclick="save()">
										<input class=button type="button" name="bsave" value=" 删 除 " onclick="toDelete()">
										<input class=button type="button" name="bsave" value=" 返 回 " onclick="next()">
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
<SCRIPT language="JavaScript">function next()
{	
	document.location.href='<%=basePath %>classMangerAction!returnClassQuery'; 
}
function commit()
{	
	if(confirm("确定更新班级吗？"))
	{
		alert("更新成功！"); 
		form1.action='<%=basePath %>classMangerAction!updateClaInfo?clazzId=${tbClasses.CId}'; 
	}
}
function save()
{	
	if(confirm("确定结业吗？"))
	{
		alert("结业成功！"); 
		form1.action='<%=basePath %>classMangerAction!endEducation?clazzId=${tbClasses.CId}'; 
	}
}
function toDelete()
{	
	if(confirm("确定删除班级吗？"))
	{
		alert("删除成功！"); 
		document.location.href='<%=basePath %>classMangerAction!deleteClazz?clazzId=${tbClasses.CId}'; 
	}
}

</SCRIPT>