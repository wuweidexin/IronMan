<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<TD class="FormTitle" height="2" width="100%"><B>�༶��ѯ</B>
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
									<TD  width="12%">	�༶��ţ�
									</TD>
									<TD width="35%">										
										<INPUT class=box name="classNo" size=20 maxLength=20 value="">
									</TD>
									<TD width="12%">	�༶���ƣ�
									</TD>
									<TD>										
										<INPUT class=box name="className" size=20 maxLength=20 value="">
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD >	�����Σ�
									</TD>
									<TD >										
										<select name="uName" >
				<option value='' >��ѡ��</option>
				<c:forEach items="${list1}" var="list">
				<option value='${list.UName}'>${list.UName}</option>
				</c:forEach>
				</select>
									</TD>
									<TD>	�༶״̬
									</TD>
									<TD>										
				<select name="csName" >
				<option value='' selected>��ѡ��</option>
				<c:forEach items="${list3}" var="list">
				<option value=${list.csName }>${list.csName }</option>
				</c:forEach>
				</select>
									</TD>
                               </TR>
							   <TR>
									<TD height="20">
									</TD>
									
									<TD>	�༶����
									</TD>
									<TD>										
				<select name="ctName" >
				<option value='' selected>��ѡ��</option>
				<c:forEach items="${list2}" var="list">
				<option value=${list.ctName }>${list.ctName }</option>
				</c:forEach>
				</select>
									</TD>
                               </TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	�������ڣ�
									</TD>
									<TD colspan="3">	�ɣ�										
											<INPUT type="text" name="examTimeStart" class="Wdate"  value='' onClick="WdatePicker()">&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;����										
										<INPUT type="text" name="examTimeEnd" class="Wdate"  value='' onClick="WdatePicker()">&nbsp;
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>
									</TD>
									<TD colspan="3" align="right">
										<input type="hidden" name="isNew" value="1">										
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
								<TR height="24" align="center">
												<TD class="ItemTitle" height="20" width="12%">	�༶���
												</TD>
												<TD class="ItemTitle" width="12%">	�༶����
												</TD>
												<TD class="ItemTitle" width="12%">	������
												</TD>
												<TD class="ItemTitle" width="12%">	��������
												</TD>
												<TD class="ItemTitle" width="12%">	��ҵ����
												</TD>
												<TD class="ItemTitle" width="12%">	�༶����
												</TD>
												<TD class="ItemTitle" width="12%">	�༶����
												</TD>
													<TD class="ItemTitle" width="12%">	�༶״̬
												</TD>
												
												
												
											</TR>
											<c:forEach items="${classList}" var="li"> 
											<TR align="center" class="ItemBody">
											
												<TD class="ItemBody" height="20">	<a href="<%=basePath %>classMangerAction!classQuery2?classId=${li.CId}">${li.CNum }</a>
												</TD>
												<TD class="ItemBody" align="left">	${li.CName }
												</TD>
												<TD class="ItemBody" align="left">	${li.tbUser.UName }
												</TD>
												<TD class="ItemBody">	${li.CStartTime } 
												</TD>
												<TD class="ItemBody">	${li.CEndTime }  
												</TD>
												<TD class="ItemBody" align="left">	${li.tbClassType.ctName}
												</TD>
												<TD class="ItemBody" align="right">	32
												</TD>
												<TD class="ItemBody">	${li.tbClazzStatus.csName }
												</TD>
												
												</TR>
												</c:forEach>
											<TR align="center" class="ItemBody">
												<TD colSpan=8 height=1>
            <TABLE border=0 cellPadding=0 cellSpacing=3 class=SearchBar 
            height=20 width="135%">
              <TR>
                <TD height=20 width=1100>
                    <DIV align=right> 
                      <P><B>�� 
		              	
                        <input type="text" id="queryPageNo"  name="QueryPageNo" size="3" value="${currentPage }" class="SearchBar_Page">
                           ҳ / �� ${totalPages }ҳ 
                        <input type="submit" name="btnGo" value="go" class="SearchBar_Btn" onclick="goPage()">
							
                        <input type="button" name="btnFirst" value="|&lt;" class="SearchBar_Btn" onclick="first()">

                        <input type="button" name="btnPrevious" value="&lt;" class="SearchBar_Btn" onclick="pageUp()">

                        <input type="button" name="btnNext" value="&gt;" class="SearchBar_Btn" onclick="pageDown()">

                        <input type="button" name="btnEnd" value="&gt;|" class="SearchBar_Btn" onclick="last()" >

                        <SPAN 
          class=SearchBar></SPAN></B></P>
                  </DIV></TD></TR></TABLE>
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
	form1.action='<%=basePath %>classMangerAction!findClasses?isNew=1'; 
	form1.submit();
}

function goPage(){
	var pageNo = document.getElementById("queryPageNo").value;
	if(pageNo == "" ) {
			alert("����ȷ���룬ֻ��Ϊ���֣���")
			return false;
		} 
		
	form1.action='<%=basePath %>classMangerAction!findClasses?pageMethod='+pageNo; 
}
function first(){
	document.location.href='<%=basePath %>classMangerAction!findClasses?pageMethod=first&currentPage=${currentPage}';
}
function pageUp(){
	document.location.href='<%=basePath %>classMangerAction!findClasses?pageMethod=previous&currentPage=${currentPage}';
}
function pageDown(){
	document.location.href='<%=basePath %>classMangerAction!findClasses?pageMethod=next&currentPage=${currentPage}';
}
function last(){
	document.location.href='<%=basePath %>classMangerAction!findClasses?pageMethod=last&currentPage=${currentPage}';
}

</SCRIPT>