<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
						<TD class="FormTitle" height="2" width="100%"><B>ѧ����ѯ</B>
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
									<TD width="12%">	ѧ���ʺţ�
									</TD>
									<TD width="35%">										
										<INPUT class=box name="stuNo" size=20 maxLength=20 value="">
									</TD>
									<TD width="12%">	ѧ��������
									</TD>
									<TD width="35%">										
										<INPUT class=box name="stuName" size=20 maxLength=20 value="">
									</TD>
								</TR>
								<TR>
									<TD height="20" width="1%">
									</TD>
									<TD width="12%">	�Ա�
									</TD>
									<TD>
										<SELECT name="sex">
											<OPTION value='0'>ȫ��</OPTION>
											<OPTION value='1'>��</OPTION>
											<OPTION value='2'>Ů</OPTION>
										</SELECT>
									</TD>
									<TD width="12%">	�༶����:
									</TD>
									<TD width="35%">										
										<INPUT class=box name="claName" size=20 maxLength=20 value="">
									</TD>									
								</TR>
								<TR>
									<TD height="20" width="1%">
									</TD>
									<TD width="9%">	ѧ��״̬��
									</TD>
									<TD>
										<SELECT name="stuStatus"> 
											<OPTION value="">��ѡ��</OPTION>
											<c:forEach items="${stuStatusList}" var="sl">
											<OPTION value="${sl.ssName }">${sl.ssName}</OPTION>
											</c:forEach>
										</SELECT>
									</TD>			
									<TD width="9%">	ѧ�����ͣ�
									</TD>
									<TD>
										<SELECT name="stuType">
											<OPTION value="">��ѡ��</OPTION>
											<c:forEach items="${stuStyList}" var="st">
											<OPTION value="${st.stName}">${st.stName }</OPTION>
											</c:forEach>
										</SELECT>
									</TD>		
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	¼�����ڣ�
									</TD>
									<TD colspan="3">	�ɣ�										
										<INPUT type="text" name="startTime" class="Wdate"  value='' onClick="WdatePicker()">&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;����										
										<INPUT type="text" name="endTime" class="Wdate"  value='' onClick="WdatePicker()">&nbsp;
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>
									</TD>
									<TD colspan="3" align="right">	
										<input type="hidden" name="isNew" value="1">								
										<INPUT class="button" type="button"  name="search" value=" �� �� " onclick="commit()">
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
									<TD class="ItemTitle" height="20" width="14%">	ѧ���ʺ�
									</TD>									
									<TD class="ItemTitle" width="14%">	ѧ������
									</TD>
									<TD class="ItemTitle" width="14%">	�Ա�
									</TD>
									<TD class="ItemTitle" width="14%">	�༶����
									</TD>
									<TD class="ItemTitle" width="14%">	ѧ��״̬
									</TD>
									<TD class="ItemTitle" width="14%">	¼������
									</TD>
								</TR>
								<c:forEach items="${stuList}" var="tl">
								<TR align="center" class="ItemBody">
									<TD class="ItemBody" height="20" align="left"><A href='<%=basePath %>classMangerAction!studentQuery2?stuNo=${tl.stuId}'>${tl.col1 }</A>
									</TD>
									<TD class="ItemBody" align="left">	${tl.col2 }
									</TD>
									<TD class="ItemBody">	${tl.col3 }
									</TD>
									<TD class="ItemBody" align="left">	<A href="<%=basePath %>classMangerAction!classQuery3?clazzId=${tl.tbClasses.CId}">${tl.tbClasses.CName }</A>
									</TD>
									<TD class="ItemBody">${tl.tbStudentType.stName }
									</TD>
									<TD class="ItemBody">	${tl.tbClasses.CStartTime }
									</TD>
								</TR>
								</c:forEach>
								<TR align="center" class="ItemBody">
									<TD colspan="7" height="1">
										<TABLE border="0" cellpadding="0" cellspacing="3" class="SearchBar" height="20" width="135%">
											<TR>
												<TD height="20" width="1100">
													<DIV align="right">
<P><B>�� 
		              	
                        <input type="text" id="queryPageNo" name="QueryPageNo" size="3" value="${currentPage }" class="SearchBar_Page">
                           ҳ / �� ${totalPages }ҳ 
                        <input type="submit" id="btnGo" name="btnGo" value="go" class="SearchBar_Btn" onclick="goPage()">
							
                        <input type="button" name="btnFirst" value="|&lt;" class="SearchBar_Btn" onclick="first()">

                        <input type="button" name="btnPrevious" value="&lt;" class="SearchBar_Btn" onclick="pageUp()">

                        <input type="button" name="btnNext" value="&gt;" class="SearchBar_Btn" onclick="pageDown()">

                        <input type="button" name="btnEnd" value="&gt;|" class="SearchBar_Btn" onclick="last()" >
<SPAN class="SearchBar"></SPAN></B></P>
													</DIV>
												</TD>
											</TR>
										</TABLE>
									</TD>
									
								</TR>
							</TABLE>
						</TD>
						<TR>
			<TD>
<HR width="98%">
			</TD>
		</TR>
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
<SCRIPT language="JavaScript">function queryResult()
{	
	document.location.href='examResult.htm'; 
}
function commit()
{
	form1.action="<%=basePath %>classMangerAction!studentQuery?isNew=1";
	form1.submit();
}
function goPage(){
	var pageNo = document.getElementById("queryPageNo").value;
	if(pageNo == "" || pageNo == null) {
			alert("����ȷ���룬ֻ��Ϊ���֣���")
			return false;
		} 
		
	form1.action='<%=basePath %>classMangerAction!studentQuery?pageMethod='+pageNo; 
	form1.submit();
		
	
}
function first(){
	document.location.href='<%=basePath %>classMangerAction!studentQuery?pageMethod=first&currentPage=${currentPage}';
}
function pageUp(){
	document.location.href='<%=basePath %>classMangerAction!studentQuery?pageMethod=previous&currentPage=${currentPage}';
}
function pageDown(){
	document.location.href='<%=basePath %>classMangerAction!studentQuery?pageMethod=next&currentPage=${currentPage}';
}
function last(){
	document.location.href='<%=basePath %>classMangerAction!studentQuery?pageMethod=last&currentPage=${currentPage}';
}
</SCRIPT>