<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
 <script language="javascript" type="text/javascript" src="<%=basePath%>webep/js/My97DatePicker/WdatePicker.js"></script>
<SCRIPT language="JavaScript1.2" src="<%=basePath%>webep/js/cm_addins.js"></SCRIPT>
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
						<TD class="FormTitle" height="2" width="100%"><B>���Է������</B>
						</TD>
					</TR>
					<TR>
						<TD>	&nbsp;
						</TD>
					</TR>
					<TR>
						<TD>
						<form action="" name="form1" id="form1" method="post">
							<TABLE align="center" border="0" width="90%">
								<TR>
									<TD height="20" width="1%">
									</TD>
									<TD width="15%">	���Է�����ţ�
									</TD>
									<TD width="35%">										
										<INPUT class=box name="examNoSchamaPlan" size=20 maxLength=20 value="">
									</TD>
									<TD width="15%">	���Է������ƣ�
									</TD>
									<TD width="35%">										
										<INPUT class=box name="examNameSchamaPlan" size=20 maxLength=20 value="">
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	���ķ�ʽ��
									</TD>
									<TD>
				<select name="questionTypeSchamaPlan" >
				<option value=''>ȫ��</option>
				<option value='1'>�Զ�����</option>
				<option value='2'>��ʦ����</option>
				</select>
									</TD>
									<TD>	¼���ˣ�
									</TD>
									<TD>										
		<INPUT class=box name="examPeopleSchamaPlan" size=20 maxLength=20 value="">
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	¼�����ڣ�
									</TD>
									<TD colspan="3">	�ɣ�										
										<INPUT type="text" name="examTimeStartSchamaPlan" class="Wdate"  value='' onClick="WdatePicker()">&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;����										
										<INPUT type="text" name="examTimeEndSchamaPlan" class="Wdate"  value='' onClick="WdatePicker()">&nbsp;
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>
									</TD>
									<TD colspan="3" align="right">										
										<INPUT class="button" type="button"  name="search" value=" �� �� " onclick="findPage()">
									</TD>
								</TR>
							</TABLE>
							</form>
							
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
												<TD class="ItemTitle" height="20" width="14%">	���Է������
												</TD>
												<TD class="ItemTitle" height="20" width="14%">	���Է�������
												</TD>
												<TD class="ItemTitle" height="20" width="14%">	���ķ�ʽ
												</TD>
												<TD class="ItemTitle" height="20" width="14%">	¼����
												</TD>
												<TD class="ItemTitle" width="14%">	¼������
												</TD>
											
											</TR>
											<c:forEach items="${list}" var="li">
											<TR align="middle" class="ItemBody">
												<TD class="ItemBody" height="20">	<a href='examSchemaAction!examSchemeAudit2?Id_esMyselfId=${li.esId}'>${li.esMyselfId}</a>
												</TD>
												<TD class="ItemBody" align="left">	${li.esName}
												</TD>
												<TD class="ItemBody" align="left">	
												<c:forEach items="${li.tbExamPlans}" var="examPlans">
												${examPlans.tbReadType.rtName}
												</c:forEach>
												</TD>
												<TD class="ItemBody" align="left">	${li.esAddUser}
												</TD>
												<TD class="ItemBody">	${li.esAddTime}
												</TD>
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
                           ҳ / �� ${totalPage} ҳ 
                        <input type="button" name="btnGo" value="go" class="SearchBar_Btn" onclick="goToPage()">
							
                        <input type="button" name="btnFirst" value="|&lt;" class="SearchBar_Btn" onclick="toLastFirst(${currentPage})">

                        <input type="button" name="btnPrevious" value="&lt;" class="SearchBar_Btn"  onclick="toNextPrevious(${currentPage})">

                        <input type="button" name="btnNext" value="&gt;" class="SearchBar_Btn" onclick="toNext(${currentPage})">

                        <input type="button" name="btnEnd" value="&gt;|" class="SearchBar_Btn" onclick="toLastEnd(${currentPage})">

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
			<TD class="pagefootTl"><IMG src="<%=basePath%>webep/space.gif" width="778" height="1"></TD>
		</TR>
		<TR>
			<TD height="25" class="pagefoot"><FONT face="Arial, Helvetica, sans-serif">&copy;</FONT> 2005-2007  ��Ȩ���� ��ͨ������Ϣ�������޹�˾ Powered by ��ͨ�����人��������
			</TD>
		</TR>
	</TABLE>
</BODY>
</HTML>
<SCRIPT language="JavaScript">function queryResult()
{	
	document.location.href='examResult.htm'; 
}

function findPage(){

	document.form1.submit();
    document.form1.action="examSchemaAction!examSchemeAudit";
	
}



//1 ����һҳ
function toLastFirst(currentPage){
document.location.href='<%=basePath%>examSchemaAction!examSchemeAudit?pageMethod=first&currentPage='+currentPage; 
   }

//2������һҳ
function toNextPrevious(currentPage){
document.location.href='<%=basePath%>examSchemaAction!examSchemeAudit?pageMethod=previous&currentPage='+currentPage; 
  }

//������һҳ
function toNext(currentPage){

  document.location.href='<%=basePath%>examSchemaAction!examSchemeAudit?pageMethod=next&currentPage='+currentPage; 
  
  }

//�����һҳ
function toLastEnd(currentPage){

  document.location.href='<%=basePath%>examSchemaAction!examSchemeAudit?pageMethod=last&currentPage='+currentPage; 
  
  }

//ȥ��ѡ��ҳ��
function goToPage(){

         var page = document.getElementById("QueryPageNo").value;  
         var patrn=/^[0-9]{1,20}$/;  
            if(page == null || page == "" || !patrn.exec(page) || page.indexOf('0') == 0)  
         {  
          alert("����ȷ����,ֻ��Ϊ���֣�");  
               return false;  
           }  
            document.location="<%=basePath%>examSchemaAction!examSchemeAudit?pageMethod=goPage&currentPage="+ page;
}
</SCRIPT>