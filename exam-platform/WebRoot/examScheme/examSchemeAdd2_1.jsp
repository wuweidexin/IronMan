<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
						<TD class="FormTitle" height="2" width="100%"><B>��������</B>
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
									<TD  height="20" width="1%">
									</TD>
									<TD width="12%">	��Ŀ��Χ��
									</TD>
									<TD width="35%">			
			
				<select name="questionBoundary" >
				<option value='' selected></option>
					<c:forEach items="${score}" var="score">
				<option value='${score.psName}' selected>${score.psName}</option>
				   </c:forEach>
				</select>
									</TD>
									<TD width="12%">	��Ŀ�Ѷȣ�
									</TD>
									<TD>
												
				<select name="questionDifficult" >
				<option value='' selected></option>
					<c:forEach items="${level}" var="level">	
				<option value='${level.pdlName}' selected>${level.pdlName}</option>
					</c:forEach>
				</select>
			
									</TD>
																		<TD width="12%">	��Ŀ���ͣ�
									</TD>
									<TD>
																		
				<select name="questionType" >
				<option value='' selected></option>
				<c:forEach items="${type}" var="type">	
				<option value='${type.ptName}'>${type.ptName}</option>
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

									<TD>	<input type="radio" id="userType1" name="userType" checked value="�Զ���ȡ">�Զ���ȡ
									</TD>
								</TR>
								<TR>

									<TD >
									<table border="1" bordercolor="#999999" width="100%">
									<tr bordercolor="#eaeaea"><td >������</td><td><INPUT class=box id="examProblemNumber" name="examProblemNumber" size=20 maxLength=20 value=""></td><td >��Ŀ������</td><td ><INPUT class=box name="examNo" size=20 maxLength=20 value="${count}" disabled></td></tr>
									<tr bordercolor="#eaeaea"><td width="60">���ķ�ʽ��                                    </td><td>�Զ�����</td></tr>
									</table>
									</TD>
								</TR>
					<TR>
						<TD>	&nbsp;
						</TD>
					</TR>
								<TR>

									<TD>	<input type="radio" id="userType2" name="userType" checked value="�ֶ�ָ��">�ֶ�ָ��
									</TD>
								</TR>
								<TR>
									<TD >
									<table border="1" bordercolor="#999999" width="100%">
<tr bordercolor="#eaeaea"><td><table><tr><td width="60">������</td><td><INPUT class=box name="examNo" size=20 maxLength=20 value="${countNumer}"  disabled></td></tr></table></td></tr>
									<tr bordercolor="#eaeaea"><td><table><tr><td width="60">���ķ�ʽ��</td><td>��ʦ����</td></tr></table></td></tr>
									<tr  bordercolor="#eaeaea">
									<TD height="40" width="96%" valign="top">
									
									
										<TABLE align="left" border="0" class="ItemList" height="20" width="100%">
											<TR height="24" align="middle">
												<TD class="ItemTitle" height="20" width="10%">	ѡ��
												</TD>
												<TD class="ItemTitle" width="14%">	��Ŀ���
												</TD>
												<TD class="ItemTitle" width="14%">	��Ŀ����
												</TD>
												<TD class="ItemTitle" width="14%">	¼����
												</TD>
												<TD class="ItemTitle" width="14%">	¼������
												</TD>
											
											</TR>
							<c:forEach items="${list}" var="li">				
	
											<TR align="middle" class="ItemBody">
												<TD class="ItemBody" height="20">	<INPUT type="checkbox" name="checked11" id="checked11" value="${li.PId}">

												</TD>
												<TD class="ItemBody">	<a href='<%=basePath%>examSchemaAction!quesLibQuery3?tbP_Id=${li.PId}'>${li.col1}</a>
												</TD>
												<TD class="ItemBody">	${li.tbProblemType.ptName}
												</TD>
												<TD class="ItemBody" align="left">	${li.tbUser.UName}
												</TD>
												<TD class="ItemBody">	 ${li.PAddTime}
												</TD>
				
											</TR>                           
     
			            
	                       </c:forEach>								
											
										</TABLE>
									</TD>
									</tr>
								<TR  bordercolor="#eaeaea">
									<TD align="center">
									<input class="button" type="button"  name="Submit2222" value=" ȫ ѡ" onclick="checkAll('checked11')">
        								<input class=button type="button" name="Submit223" value=" ������Ŀ "  onclick="add()">
        								<input class=button type="button" name="Submit223"  value=" ɾ �� " onclick="ddelete()">
									</TD>
								</TR>
									
									</table>
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
					<TR>
						<TD>
<HR width="98%">
						</TD>
					<TR>
						<TD>
							<TABLE align="center" border="0" width="90%">
								<TR>
									<TD height="20" width="1%">
									</TD>
									<TD width="12%">	ÿ�������
									</TD>
									<TD width="87%">										
<INPUT class=box name="examScore" size=20 maxLength=20 value="">
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
						<TD>
<HR width="98%">
						</TD>
					</TR>
					<TR>
						<TD>
							<TABLE align="center" border="0" width="90%">
								<TR>
									<TD align="right">
										<input class=button type=button name="bsave" value=" �� �� " onclick="save()">
										<input class=button type=button name="bsave" value=" ɾ �� " onclick="dddelete()">
										<INPUT class="button" type="button"  name="search" value=" �� �� " onclick="toBack()">
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
function save()
{	
	
	if(document.all.form1.userType[0].checked)
	{
		if (document.form1.examProblemNumber.value=="") {
			alert("��������Ϊ��");
			return false;
			}
		var el2 = ${count}; 
		var el1 = document.getElementById("examProblemNumber").value;
		if (el1>el2){
			alert("�������ܴ���������");
			return false;
			}	
	}
	if (document.form1.questionBoundary.value=="") {
		alert("��Ŀ��Χ����Ϊ��");
		return false;
		}
	if (document.form1.questionDifficult.value=="") {
		alert("��Ŀ�ѶȲ���Ϊ��");
		return false;
		}
	if (document.form1.questionType.value=="") {
		alert("��Ŀ���Ͳ���Ϊ��");
		return false;
		}
	if (document.form1.examScore.value=="") {
		alert("ÿ���������Ϊ��");
		return false;
		}
	form1.action="examSchemaAction!examSchemeAdd2_1?save=1111";
	form1.submit();

}
function toReturn()
{	
	form1.action="examSchemaAction!examSchemeAdd2_1";
	form1.submit();
	 
}
function toBack()
{	
	form1.action="examSchemaAction!examSchemeQuery2?Id_esId=${iiii}";
	form1.submit();
	 
}



function add()
{	
	form1.action="examSchemaAction!examSchemeAdd4";
	form1.submit();
	
}
function ddelete()
{	
	if(confirm("ȷ��ɾ��������"))
	{
		alert("ɾ���ɹ���"); 
		form1.action="examSchemaAction!examSchemeAdd2_1";
		form1.submit();
	}
}
function dddelete()
{	
	if(confirm("ȷ��ɾ���ò�����"))
	{
		alert("ɾ���ɹ���"); 
		form1.action="examSchemaAction!examSchemeAdd2_1?delete=2222";
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