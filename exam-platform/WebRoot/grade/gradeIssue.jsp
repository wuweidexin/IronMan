<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="" name="form2" method="post">
<SCRIPT language="JavaScript1.2" src="<%=basePath %>webep/js/coolmenus4.js"></SCRIPT>
 <script language="javascript" type="text/javascript" src="<%=basePath %>webep/js/My97DatePicker/WdatePicker.js"></script>
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
			<TD width="20">&nbsp;	
			</TD>
			<TD align="left" valign="top">
				<TABLE border="0" class="top" width="700">
					<TR>
						<TD class="FormTitle" height="2" width="100%"><B>�ɼ�����</B>
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
									<TD width="15%">	���Լƻ���ţ�
									</TD>
									<TD width="35%">										
										<INPUT class=box name="epMyselfId" size=20 maxLength=20 value="">
									</TD>
									<TD width="15%">	���Լƻ����ƣ�
									</TD>
									<TD width="35%">										
										<INPUT class=box name="planName" size=20 maxLength=20 value="">
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD >	�༶���ƣ�
									</TD>
									<TD >										
										<INPUT class=box name="CName" size=20 maxLength=20 value="">
									</TD>
									
									<TD >	���ķ�ʽ��</TD>
									<TD >										
									  <select name="rtName" >
                                          <option value='0'>ȫ��</option>
                                          <option value='1'>�Զ�����</option>
                                          <option value='2'>��ʦ����</option>
                                        </select>
									</TD>
								<TR>
									<TD height="20">
									</TD>
									<TD>	����ʱ�䣺
									</TD>
									<TD colspan="3">	�ɣ�										
											<INPUT type="text" name="planStartTime" class="Wdate"  value='' onClick="WdatePicker()">&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;����										
										<INPUT type="text" name="planEndTime" class="Wdate"  value='' onClick="WdatePicker()">&nbsp;
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>
									</TD>
									<TD colspan="3" align="right">	
									<input type="hidden" name="newHQL" value="1">									
										<INPUT class="button" type="button"  name="search" value=" �� �� " onclick="next()">
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
												
												<TD class="ItemTitle" width="12%">	���Լƻ����
												</TD>
												<TD class="ItemTitle" width="12%">	���Լƻ�����
												</TD>
												<TD class="ItemTitle" width="12%">	���Է������
												</TD>
												<TD class="ItemTitle" width="12%">	���Է�������
												</TD>
												<TD class="ItemTitle" width="14%">	����ʱ��
												</TD>
												<TD class="ItemTitle" width="12%">	�༶����
												</TD>																							
											</TR>
											<c:forEach items="${gradeIssueList}" var="li3">
											<TR align="middle" class="ItemBody">
												<TD class="ItemBody" height="20">	<a href='<%=basePath %>scoreManagerAction!gradeIssueOne?issueId=${li3.planId}'> ${li3.epMyselfId}</a>
												</TD>
												<TD class="ItemBody" align="left">	${li3.planName}
												</TD>
												<TD class="ItemBody">	${li3.tbExamScheme.esMyselfId}
												</TD>
												<TD class="ItemBody" align="left">	${li3.tbExamScheme.esName}
												</TD>
												<TD class="ItemBody">	${li3.planStartTime }��${li3.planEndTime}
												</TD>
												<TD class="ItemBody" align="left">	${li3.tbClasses.CName }
												</TD>
											</TR>
											</c:forEach>

											<TR align="middle" class="ItemBody">
												<TD colSpan=8 height=1>
            <TABLE border=0 cellPadding=0 cellSpacing=3 class=SearchBar 
            height=20 width="135%">
              <TR>
                <TD height=20 width=1100>
                    <DIV align=right> 
                      <P><B>�� 
		              	
                        <input type="text" name="QueryPageNo" size="3" value="${currentPage}" class="SearchBar_Page">
                           ҳ / �� ${totalPage} ҳ 
                        <input type="button" name="btnGo" value="go" class="SearchBar_Btn" onclick="go()">
							
                        <input type="button" name="btnFirst" value="|&lt;" class="SearchBar_Btn" onclick="firstPage()">

                        <input type="button" name="btnPrevious" value="&lt;" class="SearchBar_Btn" onclick="prePage()">

                        <input type="button" name="btnNext" value="&gt;" class="SearchBar_Btn" onclick="nextPage()">

                        <input type="button" name="btnEnd" value="&gt;|" class="SearchBar_Btn" onclick="endPage()">

                        <SPAN 
          class=SearchBar></SPAN></B></P>
                  </DIV></TD></TR></TABLE>
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
</form>
</BODY>
</HTML>
<SCRIPT language="JavaScript">
function next()
{	
	form2.action='<%=basePath%>scoreManagerAction!gradeIssue?newHQL=1'; 
	form2.submit();
}
function go()
{
    var page=form2.QueryPageNo.value;

	alert("��ǰҳ "+page);
	var patrn=/^[0-9]{1,20}$/;  
    if(page == null || page == "" || !patrn.exec(page) || page.indexOf('0') == 0)  
 {  
  alert("����ȷ����,ֻ��Ϊ���֣�");  
       return false;  
   }  
	document.location.href='<%=basePath%>scoreManagerAction!gradeIssue?pageMethod=goPage&currentPage='+page;
	
}
function firstPage()
{
	document.location.href='<%=basePath%>scoreManagerAction!gradeIssue?pageMethod=first&currentPage=${currentPage}';
	
}
function prePage()
{
	document.location.href='<%=basePath%>scoreManagerAction!gradeIssue?pageMethod=previous&currentPage=${currentPage}';

}
function nextPage()
{
	document.location.href='<%=basePath%>scoreManagerAction!gradeIssue?pageMethod=next&currentPage=${currentPage}';
	
}function endPage()
{
	document.location.href='<%=basePath%>scoreManagerAction!gradeIssue?pageMethod=last&currentPage=${currentPage}';
	
}

</SCRIPT>