<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<SCRIPT language="JavaScript1.2" src="<%=basePath %>webep/js/chen.js"></SCRIPT>
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
						<TD class="FormTitle" height="2" width="100%"><B>���Լƻ�����</B>
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
									<TD width="35%">										
										<INPUT class=box name="examPlanNo" size=20 maxLength=20 value="">
									</TD>
									<TD width="15%">	���Լƻ����ƣ�
									</TD>
									<TD>
										<INPUT class=box name="examPlanName" size=20 maxLength=20 value="">
									</TD>
									<TD>	&nbsp;
									</TD>
									<TD>										
				&nbsp;
									</TD>
								</TR>
								
								<TR>
									<TD height="20">
									</TD>
									<TD>	���ķ�ʽ��
									</TD>
									<TD>
				<select name="readType" >
				<option value="">��ѡ��</option>
				<c:forEach items="${readType}" var="rt">
				<option value="${rt.rtName}">${rt.rtName}</option>
				</c:forEach>
				<!-- 
				<option value='0'>ȫ��</option>
				<option value='1'>�Զ�����</option>
				<option value='2'>��ʦ����</option>
				 -->
				</select>
									</TD>
									<TD>	�༶��ţ�
									</TD>
									<TD>
										<INPUT class=box name="classNum" size=20 maxLength=20 value="">
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	����ʱ�䣺
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
										<INPUT class="button" type="button"  name="search" value=" �� �� " onclick='find()'>
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
												<TD class="ItemTitle" height="20" width="14%">	���Լƻ����
												</TD>
												<TD class="ItemTitle" width="14%">	���Լƻ�����
												</TD>
												<TD class="ItemTitle" width="16%">	����ʱ��
												</TD>
												<TD class="ItemTitle" width="14%">	���Է�������
												</TD>
												<TD class="ItemTitle" width="14%">	�༶���
												</TD>
												<TD class="ItemTitle" width="14%">	���Ľ���ʱ��
												</TD>
												
											</TR>
											<c:forEach items="${list}" var="li">
											<TR align="middle" class="ItemBody">
												<TD class="ItemBody" height="20"><a href="<%=basePath %>examPlanAction!examPlanIssueNum?epin=${li.planId}">${li.epMyselfId}</a>
												</TD>
												<TD class="ItemBody" align="left">${li.planName }
												</TD>
												<TD class="ItemBody">${li.planStartTime }------${li.planEndTime }
												</TD>
												<TD class="ItemBody"><a href="<%=basePath %>examSchemaAction!examSchemeQuery3?t_ID=${li.tbExamScheme.esId}">${li.tbExamScheme.esName }</a>
												</TD>
												<TD class="ItemBody" align="left"><a href="<%=basePath %>examPlanAction!classNumQuery?classNum=${li.tbClasses.CNum}">${li.tbClasses.CNum }</a>
												</TD>
												<TD class="ItemBody">${li.planReadOverTime }
												</TD>
												
											</TR>
											</c:forEach>
											<TR align="middle" class="ItemBody">
												<TD colSpan=7 height=1>
            <TABLE border=0 cellPadding=0 cellSpacing=3 class=SearchBar 
            height=20 width="135%">
              <TR>
                <TD height=20 width=1100>
                    <DIV align=right> 
                      <P><B>�� 
		              	
                        <input type="text" name="QueryPageNo" size="3" value="${currentPage}" class="SearchBar_Page">
                           ҳ / �� ${totalPages } ҳ 
                        <input type="button" name="btnGo" value="go" class="SearchBar_Btn" onclick="clickButton()">
							
                        <input type="button" name="btnFirst" value="|&lt;" class="SearchBar_Btn" onclick="clickButton1()">

                        <input type="button" name="btnPrevious" value="&lt;" class="SearchBar_Btn" onclick="clickButton2()">

                        <input type="button" name="btnNext" value="&gt;" class="SearchBar_Btn"  onclick="clickButton3()" >

                        <input type="button" name="btnEnd" value="&gt;|" class="SearchBar_Btn" onclick="clickButton4()" >

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
<SCRIPT language="JavaScript">function queryResult()
{	
	document.location.href='examResult.htm'; 
}
function find()
{
	
	for(i=0;i<form1.length;i++){
		if(!checkInput(form1.elements[i].value)){
			alert("�ջ���ڷǷ��ַ�");
			return  ;
		}
	
	}
	document.form1.action='examPlanAction!examProjectIssue?newHQL=1';
	document.form1.submit();
}
function clickButton(){ 
		var  page = document.getElementById("queryPageNo").value;
		var patern =/^[0-9]{1,20}$/;
		if (page == null || page == "" || !patern.exec(page) || page.indexOf('0') == 0 )
		{
			alter("����ȷ���룬ֻ��Ϊ����?");
	        return false;
		}
		form1.action=" <%=basePath %>examPlanAction!examProjectIssue?pageMethod="+page;
		form1.submit();
}	
function clickButton1(){ 
	
	    document.location.href='<%=basePath %>examPlanAction!examProjectIssue?pageMethod=first&currentPage=${currentPage}';
}	
function clickButton2(){ 
	
	   document.location.href='<%=basePath %>examPlanAction!examProjectIssue?pageMethod=previous&currentPage=${currentPage}';
}	
function clickButton3(){ 
	
	   document.location.href='<%=basePath %>examPlanAction!examProjectIssue?pageMethod=next&currentPage=${currentPage}';
}	
function clickButton4(){ 
	
	   document.location.href='<%=basePath %>examPlanAction!examProjectIssue?pageMethod=last&currentPage=${currentPage}';
}	
</SCRIPT>