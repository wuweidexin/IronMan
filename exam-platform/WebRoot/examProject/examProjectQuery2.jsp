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
   						<TD class="FormTitle" height="2" width="100%">	���Լƻ�ά��
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
									${pq.epMyselfId }
   									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										���Լƻ����ƣ�
   									
									<INPUT class="box" name="planName" size="20" maxLength="20" value="${pq.planName }">
   									</TD>
									
   								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	���Լƻ�������
									</TD>
									<TD>
<TEXTAREA class=box cols=40 name="txtAddress" rows=3  >${pq.planDescribe }</TEXTAREA>
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
									<select name="className" >
				                         <option value=''>��</option>
				                         <c:forEach items="${cla}" var="cl">
				                         <option value="${cl.CId}">${cl.CName}</option>
				                         </c:forEach>
				                     </select>
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
									<INPUT class="box" name="startTime" size="20" maxLength="20" value="${pq.planStartTime }"  >&nbsp;<!-- <A href="#"><IMG name="button" src='<%=basePath %>webep/calendar.gif' border="0" onClick="" align="center"></A> -->
   									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;����
   									
				                   <INPUT class="box" name="endTime" size="20" maxLength="20" value="${pq.planEndTime }"  >&nbsp;<!--  <A href="#"><IMG name="button" src='<%=basePath %>webep/calendar.gif' border="0" onClick="" align="center"></A>-->
									</TD>
   								</TR>
   								<TR>
   									<TD height="20">
   									</TD>
									<TD>	���Է������ƣ�
   									</TD>
   									<TD>
									<select name="examSchemeName" >
				                         <option value=''>��</option>
				                         <c:forEach items="${sch}" var="sh">
				                         <option value="${sh.esId }">${sh.esName}</option>
				                         </c:forEach>
				                     </select>
   									</TD>
									<TD>	���Ľ���ʱ�䣺
   									</TD>
									<TD>
				                  <INPUT class="box" name="readOverTime" size="20" maxLength="20" value="${pq.planReadOverTime }" >&nbsp;<!-- <A href="#"><IMG name="button" src='<%=basePath %>webep/calendar.gif' border="0" onClick="" align="center"></A> -->
									</TD>
								</TR>
								<TR>
   									<TD height="20">
   									</TD>
									<TD>	���ķ�ʽ��
   									</TD>
   									<TD>
									<select name="readType" >
				                         <option value=''>��</option>
				                         <c:forEach items="${readType}" var="rt">
				                         <option value="${rt.rtId}">${rt.rtName}</option>
				                         </c:forEach>
				                     </select>
   									</TD>
									<TD width="15%">	�����ˣ�
   									</TD>
									<TD>
				                    	<INPUT class="box" name="reader" size="20" maxLength="20" value="${pq.col3}">
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
									    <input class=button type=button name="bsave" value=" �Ծ�Ԥ�� " onclick="issue()">
										<input class=button type=button name="bsave" value=" �� �� " onclick="commit()">
										<input class=button type=button name="bsave" value=" �� �� " onclick="save(${pq.planId})">
										<input class=button type=reset name="bsave" value=" ɾ �� " onclick="ddelete()">
										<INPUT class="button" type="button"  name="search" value=" �� �� " onclick="javascript:history.back(-1)">
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
function toReturn()
{	
	document.location.href='examSchemeAdd.htm'; 
}
function commit()
{	
	if(confirm("ȷ���ύ�ÿ��Լƻ���"))
	{
		alert("�ύ�ɹ���"); 
				document.form1.action="examPlanAction!examPlanQueryIssue";
		document.form1.submit(); 
	}
}
function save(planId)
{	
	
		if(confirm("ȷ������ÿ��Լƻ���"))
	{
		alert("����ɹ���"); 
		document.form1.action="examPlanAction!examPlanQuerySave?planId="+planId;
		document.form1.submit(); 
	}
	
}
function ddelete()
{	
	if(confirm("ȷ������ÿ��Լƻ���"))
	{
		alert("�ύ�ɹ���"); 
		document.form1.action="examPlanAction!examPlanQuerydelete";
		document.form1.submit(); 
	}
}
function issue()
{	
	    document.form1.action="examPlanAction!examPage"; 
		document.form1.submit();
	
}
</SCRIPT>