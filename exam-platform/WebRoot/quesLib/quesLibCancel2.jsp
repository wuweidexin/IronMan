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
									<TD>&nbsp;	
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
			<TD width="20">&nbsp;	
			</TD>
			<TD align="left" valign="top">
				<TABLE border="0" class="top" width="700">
					<TR>
						<TD class="FormTitle" height="2" width="100%"><B>��Ŀ����</B>
						</TD>
					</TR>
					<TR>
						<TD>&nbsp;	
						</TD>
					</TR>
					<TR>
						<TD>
							<TABLE align="center" border="0" width="90%">
								<TR>
									<TD height="20" width="1%">
									</TD>
									<TD width="12%">	��Ŀ��ţ�
									</TD>
									<TD width="35%">										
										<font color="#808080">${tbProblem.col1 }</font>
									</TD>
									<TD width="12%">	��Ŀ���ͣ�
									</TD>
									<TD>										
										<font color="#808080">${tbProblem.tbProblemType.ptName }</font>
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	��Ŀ��Χ��
									</TD>
									<TD>
										<font color="#808080">${tbProblem.tbProblemScore.psName }</font>
									</TD>
									<TD>	��Ŀ�Ѷȣ�
									</TD>
									<TD>										
										<font color="#808080">${tbProblem.tbProblemDifficultyLevel.pdlName }</font>
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	¼���ˣ�
									</TD>
									<TD>
				                      <font color="#808080">${tbProblem.tbUser.UName }</font>
									</TD>
									<TD width="12%">	¼�����ڣ�
									</TD>
									<TD>										
										<font color="#808080">${tbProblem.PAddTime }</font>
									</TD>
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
									<TD width="12%">	��Ŀ��
									</TD>
								<TD>	<TEXTAREA class=box  cols="70%" name="question" rows=7 disabled>${tbProblem.PTitle }</TEXTAREA> 
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
									<TD width="12%">	�𰸣�
									</TD>
								<TD>	
								   <TABLE align="left" border="0" class="ItemList" height="20" width="83%">
								      <TR height="24" align="middle" >
												<TD class="ItemTitle" height="20" width="5%">	ѡ��
												</TD>
												
												<TD class="ItemTitle" width="20%">	��ѡ��
												</TD>
												
											</TR>
											<c:forEach items="${list1}" var="rt">
											<TR align="center" class="ItemBody">
												<TD class="ItemBody" height="20">	<input type="checkbox" name="C1" value="ON" checked disabled>
												</TD>
											
												<TD class="ItemBody" align="left">	${rt.prContent }
												</TD>
											</TR>
										</c:forEach>
										
											<c:forEach items="${list0}" var="rs">
											<TR align="center" class="ItemBody">
												<TD class="ItemBody" height="20">	<input type="checkbox" name="C1" value="ON" disabled>
												</TD>
											
												<TD class="ItemBody" align="left">	${rs.prContent}
												</TD>
											</TR>
										</c:forEach>
										</TABLE>
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
									<TD width="12%">	����ˣ�
									</TD>
									<TD width="35%">										
										<font color="#808080">${audit.tbUser.UName }</font>
									</TD>
									<TD width="12%">	������ڣ�
									</TD>
									<TD>										
								<font color="#808080">${audit.paTime }</font>
									</TD>
								</TR>
						<TR>
									<TD height="20" width="1%">
									</TD>
									<TD width="12%">	��������
									</TD>
									<TD width="35%">										
										<font color="#808080">${audit.paComplaint}</font>
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
										<input class=button type=button name="bsave" value=" �� �� " onclick="toCancel()">
										<INPUT class="button" type="button"  name="search" value=" �� �� " onclick="toReturn()">
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
					<TR>
						<TD>&nbsp;	
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
			<TD height="25" class="pagefoot"><FONT face="Arial, Helvetica, sans-serif">&copy;</FONT> 2005-2007  ��Ȩ���� ��ͨ������Ϣ�������޹�˾ Powered by ��ͨ�����人��������
			</TD>
		</TR>
	</TABLE>
</BODY>
</HTML>
<SCRIPT language="JavaScript">
function toCancel()
{	
	if(confirm("ȷ��������Ŀ��"))
	{
		alert("�����ɹ���"); 
		document.location.href='<%=basePath %>problemManagerAction!cancleQuestion?pId=${tbProblem.PId}'; 
	}
}
function toReturn()
{	
	document.location.href='<%=basePath %>problemManagerAction!returnQuesLibCancel'; 
}
</SCRIPT>