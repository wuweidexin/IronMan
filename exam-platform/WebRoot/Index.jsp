<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>iSoftStone��ѵ���Ŀ���ƽ̨</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="webep/css/style.css" type="text/css">
</HEAD>
<BODY>
	<FORM name="form1" method="post" action="">
		<TABLE width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
			<TR>
				<TD>
					<TABLE width="540" border="0" align="center" cellpadding="0" cellspacing="0">
						<TR>
							<TD align="center" height="76" background="webep/login_top.gif"><IMG src="webep/login_logo.jpg">
							</TD>
						</TR>
						<TR>
							<TD height="259" align="center" background="webep/login_middle.jpg">
								<TABLE width="247" border="0" cellpadding="3" cellspacing="4">
									<TR>
										<TD colspan="2" align="center" nowrap>
										<input type="radio" name="userType" checked value="student"><STRONG><FONT color="#000000">ѧ��</FONT></STRONG>
										<input type="radio" name="userType" value="admin"><STRONG><FONT color="#000000">����Ա</FONT></STRONG>
									
										</TD>
									</TR>
									
									<TR>
										<TD width="68" nowrap><STRONG><FONT color="#000000">�û��ʺţ�</FONT></STRONG>
										</TD>
										<TD width="122">											
											<INPUT name="user.UAccount" type="text" size="23" style="width:150px">
										</TD>
										<c:if test="${unkown=='unkown'}">
											<FONT color="#000000">�û�������</FONT>
										</c:if>
									</TR>
									<TR>
										<TD nowrap><STRONG><FONT color="#000000">�ܡ����룺</FONT></STRONG>
										</TD>
										<TD>											
											<INPUT name="user.UPwd" type="password"  size="23" style="width:150px">
										</TD>
										<c:if test="${unsuccess=='unsuccess'}">
											<FONT color="#000000">�û��������</FONT>
										</c:if>
									</TR>
									<TR>
										<TD colspan="2" align="center" nowrap>											
											<INPUT name="Submit3" type="button" value="�ύ" onclick="toLogin();">											
											<INPUT name="Submit22" type="reset" value="ȡ��">
										</TD>
										
									</TR>
										<c:if test="${errorMsg!=''}">
											<FONT color="#000000">${errorMsg}</FONT>
										</c:if>
									
								</TABLE>
							</TD>
						</TR>
						<TR>
							<TD height="57" valign="bottom" background="webep/login_bottom.gif">
								<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
									<TR>
										<TD height="30" align="center" valign="top">	&copy; 2005 - 2007 ��ͨ������Ϣ�������޹�˾ ��Ȩ����.
										</TD>
									</TR>
								</TABLE>
							</TD>
						</TR>
					</TABLE>
				</TD>
			</TR>
		</TABLE>		
		<INPUT type=hidden name="currency" value="1">		
		<INPUT type=hidden name="select2" value="1">
	</FORM>
</BODY>
</HTML>
<SCRIPT language="JavaScript">function toLogin()
{	
	for(i=0;i<form1.length;i++){
		if(form1.elements[i].value==""){
				alert("����Ϣ����Ϊ��");
				return false;
		}
	}
	if(document.all.form1.userType[0].checked)
	{
		document.location.href='login_s.jsp';
	}
	else if(document.all.form1.userType[1].checked)
	{
		
		form1.action="indexPageAction!sLogin";
		form1.submit();
	}
	
}
</SCRIPT>