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
<DIV id="sending" style="position:absolute; top:320; left:20; z-index:10; visibility:hidden">
		<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
			<TR>
				<TD width="30%">
				</TD>
				<TD bgcolor="#ff9900">
					<TABLE width="100%" height="70" border="0" cellspacing="2" cellpadding="0">
						<TR>
							<TD bgcolor="#eeeeee" align="center">	���ڶ�ȡ����, ���Ժ�...
							</TD>
						</TR>
					</TABLE>
				</TD>
				<TD width="30%">
				</TD>
			</TR>
		</TABLE>
	</DIV>
	<DIV id="cover" style="position:absolute; top:0; left:0; z-index:9; visibility:hidden">
		<TABLE width="100%" height="600" border="0" cellspacing="0" cellpadding="0">
			<TR>
				<TD align="center"><BR>
				</TD>
			</TR>
		</TABLE>
	</DIV>
<SCRIPT language=javascript>function showSending() 
{
 	gnIsShowSending=1;
	sending.style.visibility="visible";
	cover.style.visibility="visible";
}
</SCRIPT>
</HEAD>
<BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	
<SCRIPT language="JavaScript1.2" src="webep/js/coolmenus4.js"></SCRIPT>
<SCRIPT language="JavaScript1.2" src="webep/js/cm_addins.js"></SCRIPT>
<form action="" name="form1" method="post">
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="pagetop">
					<TR>
						<TD width="420" nowrap class="headerLogo"><IMG src="webep/logo.gif"><IMG src="webep/logo_js.gif">
						</TD>
						<TD class="welcome">
						</TD>
						<TD width="187" align="right" nowrap class="headerHelp">
							<TABLE border="0" cellpadding="4" cellspacing="2">
								<TR>
									<TD align="center" class="sys">
									  <A href="<%=basePath %>indexPageAction!exitSystem" class="syslink">�˳���¼</A>
											<A href="<%=basePath %>indexPageAction!toResetPwd" class="syslink">�޸�����</A>
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
						<TD height="2" class="menuBl1"><IMG src="webep/space.gif" width="1" height="1"></TD>
					</TR>
					<TR>
						<TD height="3" class="menuBl2"><IMG src="webep/space.gif" width="1" height="1"></TD>
					</TR>
				</TABLE>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
					<TR>
						<TD><IMG src="webep/space.gif" width="778" height="1"></TD>
					</TR>
				</TABLE>
<P>
<SCRIPT language=JavaScript1.2>showMenu("","<%=basePath %>",2);
</SCRIPT>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#999999">
					<TR>
						<TD><IMG src="webep/space.gif" width="1" height="1"></TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE><BR>
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
			<TR align="center">
						<TD width="100%" colspan="3">
						<input class=button type=reset name="bsave" value=" �������� " onclick="login1()">
						<input class=button type=reset name="bsave" value=" ������ " onclick="login2()">
						<input class=button type=reset name="bsave" value=" ��ʦ " onclick="login3()">
						<input class=button type=reset name="bsave" value=" һ���û� " onclick="login4()">
						<input class=button type=reset name="bsave" value=" ����Ա " onclick="login5()">
						</TD>
					</TR>
		<TR>
			<TD width="250" valign="top">
				<TABLE align="center" border="0" class="top" height="217" width="210">
					<TR>
						<TD class="FormTitle" height="2" width="100%"><B>������Ϣ</B>
						</TD>
					</TR>
					<TR>
						<TD height="200" width="100%">
							<TABLE align="center" border="1" bordercolor="#999999" height="190" width="99%">
								<TR bordercolor="#eaeaea">
										<TD>
											�û�������${user.UName }
										</TD>
									</TR>
									<TR bordercolor="#eaeaea">
										<TD>
											�Ա�${user.UGender }
										</TD>
									</TR>
									<TR bordercolor="#eaeaea">
										<TD>
											�û��ʺţ�${user.UAccount }
										</TD>
									</TR>
									<TR bordercolor="#eaeaea">
										<TD>
											�û����ͣ�${user.tbUserType.utName }
										</TD>
									</TR>

									<TR bordercolor="#eaeaea">
										<TD>
											�ϴε�½ʱ�䣺
										</TD>
									</TR>
									<TR bordercolor="#eaeaea">
										<TD align="center">
											${user.ULastLoginTime }
										</TD>
									</TR>
							</TABLE>
						</TD>
					</TR>
				</TABLE>
			</TD>
			<TD width="20">	&nbsp;
			</TD>
			<TD align="left" valign="top">
				<TABLE border="0" class="top" height="217" width="700">
					<TR>
						<TD class="FormTitle" height="2" width="100%"><B>������Ϣ</B>
						</TD>
					</TR>
					<TR>
						<TD width="100%">
							<TABLE align="center" width="97%">
								<TR>
									<TD height="30"><STRONG>�ȴ����ĵĿ��Լƻ���</STRONG>
									</TD>
								</TR>
								<TR>
									<TD height="40" width="96%" valign="top">
										<TABLE align="center" border="0" class="ItemList" height="20" width="100%">
											<TR height="24" align="middle">
												<TD class="ItemTitle" height="20" width="14%">	���Լƻ����
												</TD>
												<TD class="ItemTitle" width="14%">	���Լƻ�����
												</TD>
												<TD class="ItemTitle" width="14%">	����ʱ��
												</TD>
												<TD class="ItemTitle" width="14%">	���Է�������
												</TD>
												<TD class="ItemTitle" width="14%">	���԰༶
												</TD>
												<TD class="ItemTitle" width="14%">	���Ľ���ʱ��
												</TD>
												<TD class="ItemTitle" width="14%">	����
												</TD>
											</TR>
											<c:forEach items="${list}" var="li">
											<c:if test="${li.tbReadStatus.rsName eq 'δ����'}">
											<TR align="middle" class="ItemBody">
												<TD class="ItemBody" height="20"><a href='<%=basePath %>examPlanAction!examProjectQuery3?planId=${li.planId }'>${li.epMyselfId }</a>
												</TD>
												<TD class="ItemBody">${li.planName }
												</TD>
												<TD class="ItemBody">${li.planStartTime }��${li.planEndTime }
												</TD>
												<TD class="ItemBody">${li.tbExamScheme.esName}
												</TD>
												<TD class="ItemBody">${li.tbClasses.CName }
												</TD>
												<TD class="ItemBody">${li.planReadOverTime}
												</TD>
												<TD class="ItemBody">													
													<INPUT type="button" name="joinExam" value="�ɼ�����"  onclick="gradeCheck(${li.planId })">
												</TD>
											</TR>
											</c:if>
											</c:forEach>
											
										</TABLE>
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
					<TR>
						<TD>	&nbsp;
						</TD>
					</TR>
					<TR>
						<TD>
<HR width="98%">
						</TD>
					</TR>
					<TR>
						<TD width="100%">
							<TABLE align="center" width="97%">
								<TR>
									<TD height="30"><STRONG>���ύ����⣨����5�⣩��</STRONG>
									</TD>
								</TR>
								<TR>
									<TD height="40" width="96%" valign="top">
										<TABLE align="left" border="0" class="ItemList" height="20" width="100%">
											<TR height="24" align="middle">
												<TD class="ItemTitle" height="20" width="14%">	�����
												</TD>
												<TD class="ItemTitle" width="14%">	�������
												</TD>
												<TD class="ItemTitle" width="14%">	��ⷶΧ
												</TD>
												<TD class="ItemTitle" width="14%">	¼����
												</TD>
												<TD class="ItemTitle" width="14%">	¼������
												</TD>
												<TD class="ItemTitle" width="14%">	���ķ�ʽ
												</TD>
												<TD class="ItemTitle" width="14%">	״̬
												</TD>
											</TR>
											<c:forEach items="${listPro}" var="lip">
											<c:if test="${lip.tbAuditStatus.asName eq '�ѱ���'}">
											<TR align="middle" class="ItemBody">
												<TD class="ItemBody" height="20">	<a href='problemManagerAction!quesLibQuery2?proNum=${lip.col1 }'>${lip.col1}</a>
												</TD>
												<TD class="ItemBody">	${lip.tbProblemType.ptName }
												</TD>
												<TD class="ItemBody">	${lip.tbProblemScore.psName}
												</TD>
												<TD class="ItemBody">	${lip.tbUser.UName }
												</TD>
												<TD class="ItemBody">	${lip.PAddTime}
												</TD>
												<TD class="ItemBody">	�Զ�����
												</TD>
												<TD class="ItemBody">	${lip.tbAuditStatus.asName }
												</TD>
											</TR>
											</c:if>
											</c:forEach>
											
										</TABLE>
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
					<TR>
						<TD>	&nbsp;
						</TD>
					</TR>
					<TR>
						<TD>
<HR width="98%">
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
			<TD class="pagefootTl"><IMG src="../webep/space.gif" width="778" height="1"></TD>
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
function gradeCheck(i)
{	
	form1.action="scoreManagerAction!gradeCheckList?c_id1="+i;
	form1.submit();
}
function queryResult()
{	
	if(confirm("����ǰ�����Ķ�\"����ָ��\"��\nȷ�ϲμӿ�����"))
	{
		showSending();
		document.location.href='#'; 
	}
}
</SCRIPT>
<SCRIPT language="JavaScript">
function login1()
{	
		form1.action="indexPageAction!jwzrFindProblem";
		form1.submit();
	
}function login2()
{	

		form1.action="indexPageAction!bzrFindEP";
		form1.submit();
	
}function login3()
{	
		form1.action="indexPageAction!teacherFind";
		form1.submit();

	
}
function login4()
{	

		form1.action="indexPageAction!userFind";
		form1.submit();
	
}function login5()
{	
		form1.action="indexPageAction!indexPage";
		form1.submit();
	
}
</SCRIPT>