<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>iSoftStone��ѵ���Ŀ���ƽ̨</TITLE>
		<META http-equiv="Content-Type" content="text/html; charset=gb2312">
		<LINK rel="stylesheet" href="<%=basePath%>webep/css/style.css"
			type="text/css">
	</HEAD>
	<BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0"
		marginheight="0">
		<SCRIPT language="JavaScript1.2"
			src="<%=basePath%>webep/js/coolmenus4.js"></SCRIPT>
		<SCRIPT language="JavaScript1.2"
			src="<%=basePath%>webep/js/cm_addins.js"></SCRIPT>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
			<TR>
				<TD>
					<TABLE width="100%" border="0" cellpadding="0" cellspacing="0"
						class="pagetop">
						<TR>
							<TD width="420" nowrap class="headerLogo">
								<IMG src="<%=basePath%>webep/logo.gif">
								<IMG src="<%=basePath%>webep/logo_js.gif">
							</TD>
							<TD class="welcome">
							</TD>
							<TD width="187" align="right" nowrap class="headerHelp">
								<TABLE border="0" cellpadding="4" cellspacing="2">
									<TR>
										<TD align="center" class="sys">
											<A href="<%=basePath%>Index.htm" class="syslink">�˳���¼</A>
											<A href="password.htm" class="syslink">�޸�����</A>
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
										<TD>
											&nbsp;
										</TD>
									</TR>
								</TABLE>
							</TD>
						</TR>
						<TR>
							<TD height="2" class="menuBl1">
								<IMG src="<%=basePath%>webep/space.gif" width="1" height="1">
							</TD>
						</TR>
						<TR>
							<TD height="3" class="menuBl2">
								<IMG src="<%=basePath%>webep/space.gif" width="1" height="1">
							</TD>
						</TR>
					</TABLE>
					<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
						<TR>
							<TD>
								<IMG src="<%=basePath%>webep/space.gif" width="778" height="1">
							</TD>
						</TR>
					</TABLE>
					<P>
						<SCRIPT language=JavaScript1.2>showMenu("","<%=basePath%>",2);
</SCRIPT>
						<TABLE width="100%" border="0" cellpadding="0" cellspacing="0"
							bgcolor="#999999">
							<TR>
								<TD>
									<IMG src="<%=basePath%>webep/space.gif" width="1" height="1">
								</TD>
							</TR>
						</TABLE>
				</TD>
			</TR>
		</TABLE>
		<BR>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
			<TR>
				<TD width="20">
					&nbsp;
				</TD>
				<TD align="left" valign="top">
					<TABLE border="0" class="top" width="700">
						<TR>
							<TD class="FormTitle" height="2" width="100%">
								<B>�ɼ���ѯ</B>
							</TD>
						</TR>
						<TR>
							<TD>
								&nbsp;
							</TD>
						</TR>
						<TR>
							<TD>
								<TABLE align="center" border="0" width="90%">
									<TR>
										<TD height="20" width="1%">
										</TD>
										<TD width="15%">
											���Լƻ���ţ�
										</TD>
										<TD width="35%">
											${examPlan.epMyselfId }
										</TD>
										<TD width="15%">
											�༶��ţ�
										</TD>
										<TD width="35%">
											${examPlan.tbClasses.CNum}
										</TD>
									</TR>
									<TR>
										<TD height="20" width="1%">
										</TD>
										<TD width="15%">
											���Լƻ����ƣ�
										</TD>
										<TD width="35%">
											${examPlan.planName }
										</TD>
										<TD width="15%">
											�༶���ƣ�
										</TD>
										<TD width="35%" >
											${examPlan.tbClasses.CName }
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
								<TABLE align="center" border="0" class="ItemList" height="20"
									width="96%">
									<TR height="24" align="middle">
										<TD class="ItemTitle" width="12%">
											ѧ������
										</TD>
										<TD class="ItemTitle" width="12%">
											�� ��
										</TD>
									</TR>
<%--									<c:forEach items="${paperList}" var="li1">--%>
<%--										<TR align="middle" class="ItemBody">--%>
<%--											<TD class="ItemBody" height="20" align="left">--%>
<%--												${li1.tbUser.UName }--%>
<%--											</TD>--%>
<%--											<TD class="ItemBody" align="right">--%>
<%--												${li1.epTotalMark }--%>
<%--											</TD>--%>
<%--										</TR>--%>
<%--									</c:forEach>--%>

									<c:forEach items="${examPlan.tbExamPapers}" var="papers">
										<TR align="middle" class="ItemBody">
											<TD class="ItemBody" height="20" align="left">
												${papers.tbUser.UName }
											</TD>
											<TD class="ItemBody" align="right">
												${papers.epTotalMark }
											</TD>
										</TR>
									</c:forEach>

								</TABLE>
							</TD>
						</TR>
						<tr>
							<td>
								<HR width="98%">
							</td>
						</tr>
						<TR>
							<TD>
								<TABLE align="center" border="0" width="90%">
									<TR>
										<TD align="right">
											<input class=button type=button name="dayin" value=" �� ӡ "
												onclick="dayin()">
											<input class=button type=button name="bsave" value=" �� �� "
												onclick="javascript:history.back(-1)">
										</TD>
									</TR>
								</TABLE>
							</TD>
						</TR>
					</TABLE>
				</TD>
			</TR>
		</TABLE>
		<BR>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
			<TR>
				<TD class="pagefootTl">
					<IMG src="<%=basePath%>webep/space.gif" width="778" height="1">
				</TD>
			</TR>
			<TR>
				<TD height="25" class="pagefoot">
					<FONT face="Arial, Helvetica, sans-serif">&copy;</FONT> 2005-2007
					��Ȩ���� ��ͨ������Ϣ�������޹�˾ Powered by ��ͨ�����人��������
				</TD>
			</TR>
		</TABLE>
	</BODY>
</HTML>
<SCRIPT language="JavaScript">
function gradeCheck()
{	
	document.location.href='<%=basePath%>grade/examResult.htm'; 
}
function next()
{
	document.location.href='#';
}
function dayin()
{
window.print()
<!--	document.location.href='#';-->
}
</SCRIPT>