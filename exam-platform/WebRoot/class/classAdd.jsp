<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>iSoftStone��ѵ���Ŀ���ƽ̨</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="<%=basePath %>webep/css/style.css" type="text/css">
</HEAD>
<BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<SCRIPT language="JavaScript1.2" src="<%=basePath %>webep/js/coolmenus4.js"></SCRIPT>
<SCRIPT language="JavaScript1.2" src="<%=basePath %>webep/js/cm_addins.js"></SCRIPT>
<FORM action="" name = "form1" method="post">
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
									<TD align="center" class="sys"><A href="<%=basePath %>Index.htm" class="syslink">�˳���¼</A> <A href="password.htm" class="syslink">�޸�����</A>
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
<SCRIPT language=JavaScript1.2>showMenu("","<%=basePath%>",2);
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
						<TD class="FormTitle" height="2" width="100%"><B>�༶����</B>
						</TD>
					</TR>
					<TR>
						<TD>	&nbsp;
						</TD>
					</TR>
					<TR>
   						<TD>
   							<TABLE align="center" border="0" width="90%">
<%--   								<TR>--%>
<%--								    <TD height="20" width="1%">--%>
<%--   									</TD>--%>
<%--   									<TD width="12%">	�༶��ţ�--%>
<%--   									</TD>--%>
<%--   									<TD>--%>
<%--										<INPUT class="box" name="CNum" size="20" maxLength="20" value="" type="Text">--%>
<%--   									</TD>--%>
<%--   								</TR>--%>
								<TR>
								    <TD height="20">
   									</TD>
								    <TD>	�༶���ƣ�
   									</TD>
   									<TD>
									<INPUT class="box" name="CName" size="20" maxLength="20" value="" type="Text">
   									</TD>
								</TR>
								<TR>
								    <TD height="20">
   									</TD>
								    <TD>	�����Σ�
   									</TD>
   									<TD>
									<select name="UId" >
				<option value='1' selected>��ѡ��</option>
				<c:forEach items="${uName}" var="ua">
				<option value=${ua.UId }>${ua.UName }</option>
				</c:forEach>
				</select>
								</TR>
								<TR>
					<TD height="20">
   						</TD>
								    <TD>	�༶���ͣ�
   									</TD>
   									<TD >
									<select name="ctId" >
				<option value='1' selected>��ѡ��</option>
				<c:forEach items="${clatypeName}" var="cn">
				<option value=${cn.ctId }>${cn.ctName }</option>
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
									
									<TD width="12%">	�༶������
									</TD>
									<TD colspan="2">	<TEXTAREA class=box cols="70%" name="col1" rows=5></TEXTAREA> 
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
										<INPUT class="button" type="button"  name="search" value=" �� �� " onclick="create()"/>
										 <INPUT class="button" type="Reset" name="cancle" value=" ȡ �� " onclick="next()"/>
										 
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
</table>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr><td><br></td></tr>
			<TR>
				<TD class="pagefootTl"><IMG src="<%=basePath %>webep/space.gif" width="778" height="1"></TD>
			</TR>
			<TR>
				<TD height="25" class="pagefoot"><FONT face="Arial, Helvetica, sans-serif">&copy;</FONT> 2005-2007  ��Ȩ���� ��ͨ������Ϣ�������޹�˾ Powered by ��ͨ�����人��������
				</TD>
			</TR>
		</TABLE>
		</FORM>
</BODY>
</HTML>
<SCRIPT language="JavaScript">function create()
{	
	if(confirm("ȷ�������°༶��"))
	{
		alert("���ӳɹ���"); 
		form1.action='<%=basePath %>classMangerAction!saveClass'; 
		form1.submit();
	}
}

function next()
{	
	document.location.href='<%=basePath %>classMangerAction!classAdd'; 
}
</SCRIPT>