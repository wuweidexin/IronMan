<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>iSoftStone��ѵ���Ŀ���ƽ̨</TITLE>
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
									<TD align="center" class="sys">  <A href="<%=basePath %>indexPageAction!exitSystem" class="syslink">�˳���¼</A>
											<A href="<%=basePath %>indexPageAction!toResetPwd" class="syslink">�޸�����</A>
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
						<TD><IMG src="<%= basePath %>webep/space.gif" width="778" height="1"></TD>
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
	<form action="" name="form1" method="post">
	<TABLE width="100%" border="5" cellpadding="0" cellspacing="0">
		<TR>
			<TD width="20">	&nbsp;
			</TD>
			<TD align="left" valign="top">
				<TABLE border="0" class="top" width="700">
					<TR>
						<TD class="FormTitle" height="2" width="100%"><B>�༶���Ͳ�ѯ</B>
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
									<TD width="16%">	�༶���ͱ�ţ�
									</TD>
									<TD>										
										<INPUT class=box name="ctNo" size=20 maxLength=20 value="">
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	�༶�������ƣ�
									</TD>
									<TD>
<INPUT class=box name="ctName" size=20 maxLength=20 value="">
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>
									</TD>
									<TD colspan="3" align="right">		
									<INPUT class="button" type="button"  name="search" value=" �� �� " onclick="toAdd()">								
										<INPUT class="button" type="button"  name="search" value=" �� �� " onclick="toFindWithCon()">
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
									<TD class="ItemTitle" height="20" width="14%">	�༶���ͱ��
									</TD>
									<TD class="ItemTitle" width="14%">	�༶��������
									</TD>
								</TR>
								<c:forEach items="${list}" var="li">
								<TR align="middle" class="ItemBody">
									<TD class="ItemBody" height="20"><A href="systemsettingAction!toUpdateClassType?temp=${li.ctId }">${li.ctMyselfId }</A>
									</TD>
									<TD class="ItemBody" align="left">	${li.ctName }
									</TD>
								</TR>
								</c:forEach>
<!--							<TR align="middle" class="ItemBody">
									<TD class="ItemBody" height="20"><A href="classTypeSetting2.htm">CT20051028002</A>
									</TD>
									<TD class="ItemBody" align="left">	У�����
									</TD>
								</TR>	  -->							
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
	</TABLE><BR></form>
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD class="pagefootTl"><IMG src="<%= basePath %>webep/space.gif" width="778" height="1"></TD>
		</TR>
		<TR>
			<TD height="25" class="pagefoot"><FONT face="Arial, Helvetica, sans-serif">&copy;</FONT> 2005-2007  ��Ȩ���� ��ͨ������Ϣ�������޹�˾ Powered by ��ͨ�����人��������
			</TD>
		</TR>
	</TABLE>
</BODY>
</HTML>
<SCRIPT language="JavaScript">function toAdd()
{	
	form1.action="systemsettingAction!toNext?temp=toAddClassType";
	form1.submit();
}
function toFindWithCon()
{
	for(i=0;i<form1.length;i++){
		if(!checkInput(form1.elements[i].value)){
			alert("����Ϊ�ջ���ڷǷ��ַ�");
			return  ;
		}
	
	}
	form1.action="systemsettingAction!findClassTypeCondition";
	form1.submit();

}
</SCRIPT>