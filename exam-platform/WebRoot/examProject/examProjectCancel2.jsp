<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
    <TITLE>
        iSoftStone��ѵ���Ŀ���ƽ̨
    </TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="<%=basePath %>webep/css/style.css" type="text/css">
</HEAD>
   <BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<SCRIPT language="JavaScript1.2" src="<%=basePath %>webep/js/coolmenus4.js"></SCRIPT>
 <script language="javascript" type="text/javascript" src="<%=basePath %>webep/js/My97DatePicker/WdatePicker.js"></script>
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
   									<TD align="center" class="sys"><A href="<%=basePath%>indexPageAction!exitSystem" class="syslink">�˳���¼</A> <A href="<%=basePath%>indexPageAction!toResetPwd" class="syslink">�޸�����</A>
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
   						<TD class="FormTitle" height="2" width="100%">	���Լƻ�����
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
   									<TD width="15%">	���Լƻ���ţ�
   									</TD>
   									<TD>
									<font color="#808080">${pn.epMyselfId}</font>
   									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										���Լƻ����ƣ�
   									
									<font color="#808080">${pn.planName }</font>
   									</TD>
									
   								</TR>
								<TR>
								    <TD height="20" width="1%">
   									</TD>
   									<TD width="15%">	¼���ˣ�
   									</TD>
   									<TD>
									<font color="#808080">${pn.col2 }</font>
   									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										¼�����ڣ�&nbsp;&nbsp;&nbsp;&nbsp;
   									
									<font color="#808080">${pn.col1 }</font>
   									</TD>
									
   								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	���Լƻ�������
									</TD>
									<TD>
                                      <font color="#808080">${pn.planDescribe }</font>
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
									<TD width="15%">	�༶���ƣ�
   									</TD>
   									<TD width="35%">
									<font color="#808080">${pn.tbClasses.CName }</font>
   									</TD>
									<TD colspan="2">
   									</TD>
   								</TR>
								<TR>
								    <TD height="20">
   									</TD>
									<TD>	����ʱ�䣺
   									</TD>
   									<TD colspan="3">�ɣ�
									<font color="#808080">${pn.planStartTime }</font>
   									
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����
   									
				                  <font color="#808080">${pn.planEndTime }</font>
									</TD>
   								</TR>
								<TR>
   									<TD height="20">
   									</TD>
									<TD>	���Է������ƣ�
   									</TD>
   									<TD>
									<font color="#808080">${pn.tbExamScheme.esName }</font>
   									
									<TD>	���Ľ���ʱ�䣺
   									</TD>
									<TD>
				                  <font color="#808080">${pn.planReadOverTime }</font>
									</TD>
			
								</TR>
								<TR>
   									<TD height="20">
   									</TD>
									<TD>	���ķ�ʽ��
   									</TD>
   									<TD>
									<font color="#808080">${pn.tbReadType.rtName }</font>
   									</TD>
									<TD width="15%">	�����ˣ�
   									</TD>
									<TD>
				                    <font color="#808080">${pn.col3 }</font>
									</TD>
   								</TR>
   							</TABLE>
					</TD>
					</TR>
					<!--
					<TR>
						<TD>
<HR width="98%">
						</TD>
					</TR>
					 
				<tr>
				<td>
				<table align="center" border="0" width="88%">
				<TR>
									
									<TD>	���������
									</TD>
									<TD>
<TEXTAREA class=box cols=40 name="txtAddress" rows=3  ></TEXTAREA> 
									</TD>
								</TR></table></td></tr> -->
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
										<input class=button type=button name="bsave" value=" �� �� " onclick='set()'>
										<input class=button type=button name="bsave" value=" �� �� " onclick="javascript:history.back(-1)">
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
   			<TD height="25" class="pagefoot">   			   
   			   <FONT face="Arial, Helvetica, sans-serif">&copy;</FONT>2005-2007  ��Ȩ���� ��ͨ������Ϣ�������޹�˾ Powered by ��ͨ�����人��������
   			</TD>
   		</TR>
   	</TABLE>
   	</form>
   </BODY>
</HTML>
<SCRIPT language="JavaScript">
function set()
{	if(confirm("ȷ�������ÿ��Լƻ���"))
	{
		alert("���ԼƷ������ɹ���"); 
		
	document.form1.action="examPlanAction!examPlanCanelBack";
	document.form1.submit();
	 }
}
</SCRIPT>