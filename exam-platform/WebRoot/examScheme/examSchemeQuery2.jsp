<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cissst.entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<HTML>
<HEAD>
<TITLE>iSoftStone��ѵ���Ŀ���ƽ̨</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="<%=basePath%>webep/css/style.css" type="text/css">
</HEAD>
<BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<SCRIPT language="JavaScript1.2" src="<%=basePath%>webep/js/coolmenus4.js"></SCRIPT>
<SCRIPT language="JavaScript1.2" src="<%=basePath%>webep/js/cm_addins.js"></SCRIPT>
<form action="" name="form1" id="form1" method="post">
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="pagetop">
					<TR>
						<TD width="420" nowrap class="headerLogo"><IMG src="<%=basePath%>webep/logo.gif"><IMG src="<%=basePath%>webep/logo_js.gif">
						</TD>
						<TD class="welcome">
						</TD>
						<TD width="187" align="right" nowrap class="headerHelp">
							<TABLE border="0" cellpadding="4" cellspacing="2">
								<TR>
									<TD align="center" class="sys"><A href="<%=basePath %>indexPageAction!exitSystem" class="syslink">�˳���¼</A><A href="<%=basePath %>indexPageAction!toResetPwd" class="syslink">�޸�����</A>
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
						<TD height="2" class="menuBl1"><IMG src="<%=basePath%>webep/space.gif" width="1" height="1"></TD>
					</TR>
					<TR>
						<TD height="3" class="menuBl2"><IMG src="<%=basePath%>webep/space.gif" width="1" height="1"></TD>
					</TR>
				</TABLE>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
					<TR>
						<TD><IMG src="<%=basePath%>webep/space.gif" width="778" height="1"></TD>
					</TR>
				</TABLE>
<P>
<SCRIPT language=JavaScript1.2>showMenu("","<%=basePath%>",2);
</SCRIPT>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#999999">
					<TR>
						<TD><IMG src="<%=basePath%>webep/space.gif" width="1" height="1"></TD>
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
						<TD class="FormTitle" height="2" width="100%"><B>���Է���ά��</B>
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
									<TD width="16%">	���Է�����ţ�
									</TD>
									<TD>										
										<font color="#808080">${tes.esMyselfId}</font>
									
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										
									���Է������ƣ�
									
																			
										<font color="#808080">${tes.esName}</font>
									</TD>
								</TR>
								<TR>
								   <TD height="20" width="1%">
									</TD>
									</TD>
									<TD width="12%">	¼���ˣ�
									</TD>
									<TD>									
										<font color="#808080">${tes.esAddUser}</font>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¼�����ڣ�
																
										<font color="#808080">${tes.col1}</font>
									</TD>
									</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	���Է���������
									</TD>
									<TD>
<TEXTAREA class=box cols=40 name="txtAddressssss" rows=3 >${tes.esDescribe}</TEXTAREA> 
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
						<TD valign="top">
		<TABLE align="center" width="97%" border="0">
							<TR>
									<TD height="30">���Է������ԣ�
									</TD>
								</TR>
								<TR>
									<TD height="40" width="96%" valign="top">
							<TABLE align="center" border="0" class="ItemList" height="20" width="96%">
								<TR height="24" align="middle">
												<TD class="ItemTitle" height="20" width="5%">	ѡ��
												</TD>
												<TD class="ItemTitle" width="5%">	���
												</TD>
												<TD class="ItemTitle" width="17%">	��Ŀ��Χ
												</TD>
												<TD class="ItemTitle" width="9%">	��Ŀ�Ѷ�
												</TD>
												<TD class="ItemTitle" width="10%">	��Ŀ����
												</TD>
												<TD class="ItemTitle" width="10%">	���ⷽʽ
												</TD>
												<TD class="ItemTitle" width="18%">	���ķ�ʽ
												</TD>
												<TD class="ItemTitle" width="8%">	ÿ�����
												</TD>
												<TD class="ItemTitle" width="8%">	����
												</TD>
												
												<TD class="ItemTitle" width="8%">	�����ϼ�
												</TD>
											</TR>
											
											<c:forEach items="${tes.tbExamSchemeDetails}" var="tbDetails">
											<TR align="middle" class="ItemBody">
												<TD class="ItemBody" height="20">	<input type="checkbox" name="checked11" id="checked11" value="${tbDetails.tbTactics.TId}">
												</TD>
												<TD class="ItemBody"><a href="examSchemaAction!examSchemeQuery4?tbTactics=${tbDetails.tbTactics.TId}">${tbDetails.tbTactics.TId}</a>
												</TD>
												<TD class="ItemBody" align="left">	${tbDetails.tbTactics.tbProblemScore.psName}
												</TD>
												<TD class="ItemBody"> ${tbDetails.tbTactics.tbProblemDifficultyLevel.pdlName}
												</TD>
												<TD class="ItemBody"> ${tbDetails.tbTactics.tbProblemType.ptName}
												</TD>
												<c:if test="${tbDetails.tbTactics.TGetTitleMethod ==0}">
												<TD class="ItemBody">�ֶ�ָ��	
												</TD>
												</c:if>
												<c:if test="${tbDetails.tbTactics.TGetTitleMethod ==1}">
												<TD class="ItemBody">�Զ���ȡ	
												</TD>
												</c:if>
												<TD class="ItemBody" align="left">	${tbDetails.tbTactics.tbReadType.rtName}
												</TD>
												<TD class="ItemBody" align="right">	${tbDetails.tbTactics.TEveryMark}
												</TD>
												<TD class="ItemBody" align="right">	${tbDetails.tbTactics.TProblemNum}<c:set var="problemNum" value="${problemNum + tbDetails.tbTactics.TProblemNum}"/>
												</TD>
												<TD class="ItemBody" align="right">	${tbDetails.tbTactics.TEveryMark*tbDetails.tbTactics.TProblemNum}<c:set var="sumScore" value="${sumScore + tbDetails.tbTactics.TEveryMark*tbDetails.tbTactics.TProblemNum}"/>
												</TD>
											  </TR>
											 </c:forEach>
											
											<TR align="middle" class="ItemBody">
												<TD class="ItemBody" height="20" colspan="8"><b>��  ��</b>
												</TD>
												
												<TD class="ItemBody" align="right">	<b>${problemNum}</b>
												</TD>
												
											<TD class="ItemBody" align="right">	<b>${sumScore}</b>
												</TD>
											</TR>
							</TABLE>
				</TD>
								</TR>
								<TR>
									<TD align="center">
										<input class=button type="button" name="Submit2222"  value=" ȫ ѡ " onclick="checkAll('checked')">
        								<input class=button type="button" name="Submit223" value="����������" onclick="toAdd()">
        								<input class=button type="button" name="Submit223"  value="ɾ��������" onclick="toDelete()">
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
									<c:forEach items="${tes.tbSchemeAudits}" var="lli">
									<TD width="12%">	����ˣ�
									</TD>
									<TD width="35%">										
										<font color="#808080">${lli.tbUser.UName}</font>
									</TD>
									
									<TD width="12%">	������ڣ�
									</TD>
									<TD>										
										<font color="#808080">${lli.saTime}</font>
									</TD>
									</c:forEach>
								</TR>
								<TR>
									<TD height="20" width="1%">
									</TD>
									<TD width="12%">	״̬��
									</TD>
									<TD width="35%">										
										<font color="#808080">${tes.tbAuditStatus.asName}</font>
									</TD>
									
									<c:forEach items="${tes.tbSchemeAudits}" var="llli">
									<TD width="12%">	��������
									</TD>
									<TD>										
										<font color="#808080">${llli.saComment}</font>
									</TD>
									</c:forEach>
									
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
										<input class=button type=button name="bsave" value=" �� �� " onclick="commit()">
										<input class=button type=button name="bsave" value=" �� �� " onclick="save()">
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
			<TD class="pagefootTl"><IMG src="<%=basePath%>webep/space.gif" width="778" height="1"></TD>
		</TR>
		<TR>
			<TD height="25" class="pagefoot"><FONT face="Arial, Helvetica, sans-serif">&copy;</FONT> 2005-2007  ��Ȩ���� ��ͨ������Ϣ�������޹�˾ Powered by ��ͨ�����人��������
			</TD>
		</TR>
	</TABLE>
	</form>
</BODY>
</HTML>
<SCRIPT language="JavaScript">
function toAdd()
{	
	document.location.href='examSchemaAction!examSchemeAdd2_1?eeee=${tes.esId}'; 
}
function toDelete()
{	
	if(confirm("ȷ��ɾ���ò�����"))
	{
		alert("ɾ���ɹ���"); 
		form1.action="examSchemaAction!examSchemeQuery2?Id_esId2=${tbDetails.tbTactics.TId}"; 
		form1.submit();
	}
}
function save()
{	
	
	form1.action="examSchemaAction!examSchemeQuery2?Id_esId1=${tes.esId}"; 
	form1.submit();
}
function commit()
{	
	if(confirm("ȷ���ύ�÷�����"))
	{
		alert("�ύ�ɹ���"); 
		form1.action="examSchemaAction!examSchemeQuery?esMyselfId2=${tes.esId}"; 
		form1.submit();
	}
}
function ddelete()
{	
	if(confirm("ȷ��ɾ���÷�����"))
	{
		alert("ɾ���ɹ���"); 
		form1.action="examSchemaAction!examSchemeQuery?Id_esId3=${tes.esId}"; 
		form1.submit();
	}
}

function checkAll(name)
{
    var el = document.getElementsByTagName('input');
 
    var len = el.length;
    for(var i=0; i<len; i++)
    {
        if((el[i].type=="checkbox") && (el[i].name==name))
        {
              el[i].checked = true;
        }
    }
}
</SCRIPT>