<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>iSoftStone��ѵ���Ŀ���ƽ̨</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="<%=basePath%>webep/css/style.css" type="text/css">
</HEAD>
<BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<SCRIPT language="JavaScript1.2" src="<%=basePath%>webep/js/coolmenus4.js"></SCRIPT>
<SCRIPT language="JavaScript1.2" src="<%=basePath%>webep/js/cm_addins.js"></SCRIPT>
<form action="" name="form1" method="post">
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
									<TD align="center" class="sys">  <A href="<%=basePath %>indexPageAction!exitSystem" class="syslink">�˳���¼</A>
											<A href="<%=basePath %>indexPageAction!toResetPwd" class="syslink">�޸�����</A>	</TD>
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
						<TD class="FormTitle" height="2" width="100%"><B>�û�ά��</B>
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
   									<TD width="12%">	�û��ʺţ�
   									</TD>
   									<TD>
									<input class=button type=text name="user.UAccount" value=" ${userN.UAccount }" onclick="reset()">
   									
   									</TD>
   									<TD>
										elf
										&nbsp;
									<input class=button type=button name="user.UPwd" value=" �������� " onclick="reset()">
   									
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
									<TD width="12%">	�û�������
   									</TD>
   									<TD width="35%">
									<INPUT class="box" name="user.UName" size="20" maxLength="20" value="${userN.UName }" >
   									</TD>
									<TD width="12%">	¼�����ڣ�
   									</TD>
   									<TD width="35%">
   									<INPUT class="box" name="user.UHiretime" size="20" maxLength="20" value="${userN.UHiretime }" >
									
   									</TD>
									<TD colspan="2">
   									</TD>
								</TR>
								   <TR>	
								   <TD height="20" width="1%">
   									</TD>
									<TD width="12%">	EMAIL��ַ��
   									</TD>
   									<TD width="50%">
									<INPUT class="box" id="uEmail" name="user.UEmail" size="20" maxLength="20" value="${userN.UEmail }" >&nbsp;&nbsp;�磺susan@isoftstone.com
   									</TD>
									<TD colspan="2">
   									</TD>
   								</TR>
								<TR>
								    <TD height="20">
   									</TD>
									<TD>	�Ա�
   									</TD>
   									<c:if test="${userN.UGender=='��'}">
   									<TD>
				 <input type="Radio" name="user.UGender" checked value="��">��&nbsp;&nbsp; <input type="Radio" name="userN.UGender" value="Ů">Ů
									 </TD>
				 					</c:if>
				 					<c:if test="${userN.UGender=='Ů'}">
				 					<TD>
				 <input type="Radio" name="user.UGender" value="��">��&nbsp;&nbsp; <input type="Radio" name="userN.UGender" checked value="Ů">Ů
				 					</TD>
									</c:if>
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
									<TD width="12%">	�û����ͣ�
   									</TD>
   									<TD width="50%">
   									<c:if test="${userN.tbUserType.utName=='��ʦ'}">
									<input type="Radio" name="userType.utName" checked value="��ʦ">��ʦ&nbsp;&nbsp;
									<input type="Radio" name="userType.utName" value="������">������&nbsp;&nbsp;
									<input type="radio" name="userType.utName" value="��������">��������&nbsp;&nbsp;
									<input type="radio" name="userType.utName" value="һ���û�">һ���û�
									</c:if>
									<c:if test="${userN.tbUserType.utName=='������'}">
									<input type="Radio" name="userType.utName" value="��ʦ">��ʦ&nbsp;&nbsp;
									<input type="Radio" name="userType.utName" checked value="������">������&nbsp;&nbsp;
									<input type="radio" name="userType.utName" value="��������">��������&nbsp;&nbsp;
									<input type="radio" name="userType.utName" value="һ���û�">һ���û�
									</c:if>
									<c:if test="${userN.tbUserType.utName=='��������'}">
									<input type="Radio" name="userType.utName" value="��ʦ">��ʦ&nbsp;&nbsp;
									<input type="Radio" name="userType.utName" value="������">������&nbsp;&nbsp;
									<input type="radio" name="userType.utName" checked value="��������">��������&nbsp;&nbsp;
									<input type="radio" name="userType.utName" value="һ���û�">һ���û�
									</c:if>
									
									<c:if test="${userN.tbUserType.utName=='һ���û�'}">
									<input type="Radio" name="userType.utName" value="��ʦ">��ʦ&nbsp;&nbsp;
									<input type="Radio" name="userType.utName" value="������">������&nbsp;&nbsp;
									<input type="radio" name="userType.utName" value="��������">��������&nbsp;&nbsp;
									<input type="radio" name="userType.utName" checked value="һ���û�">һ���û�
									</c:if>
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
									<TD align="right">
										<input class=button type=button name="bsave" value=" �� �� " onclick="commit()">
										<input class=button type=button name="bsave" value=" ɾ �� " onclick="toDelete()">
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
</table>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr><td><br></td></tr>
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
function commit()
{	
	if(!isemail(document.getElementById("uEmail").value))
	{
		alert("�����ʽ����");
		return false;
	}
	if(confirm("ȷ�������û���"))
	{
		form1.action="systemsettingAction!updateUser?u_id="+${userN.UId};
		form1.submit();
		 
	}
}
function toDelete()
{	
	if(confirm("ȷ��ɾ���û���"))
	{
		form1.action="systemsettingAction!deleteUser?u_id="+${userN.UId};
		form1.submit();
	}
}
function next()
{	
	document.location.href='userSetting.htm'; 
}
function reset()
{
	if(confirm("ȷ��������"))
	{
		alert("���óɹ���"); 
		document.location.href='userSetting3.htm'; 
	}
}
</SCRIPT>