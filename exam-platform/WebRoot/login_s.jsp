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
									<TD align="center" class="sys"><A href="Index.htm" class="syslink">�˳���¼</A> <A href="password1.htm" class="syslink">�޸�����</A>
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
<SCRIPT language=JavaScript1.2>showMenu("","<%=basePath %>",1);
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
									<TD>	ѧ��������������
									</TD>
								</TR>
								<TR bordercolor="#eaeaea">
									<TD>	�Ա���
									</TD>
								</TR>
								<TR bordercolor="#eaeaea">
									<TD>	�༶���ƣ�JAVA��һ��
									</TD>
								</TR>
								<TR bordercolor="#eaeaea">
									<TD>	ѧ���ʺţ�elf
									</TD>
								</TR>
								<TR bordercolor="#eaeaea">
									<TD>	���Դ�����3
									</TD>
								</TR>
								<TR bordercolor="#eaeaea">
									<TD>	�ϴε�½ʱ�䣺
									</TD>
								</TR>
								<TR bordercolor="#eaeaea">
									<TD align="center">	2005-11-27 09:23
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
				</TABLE>
			</TD>
			<TD width="20">&nbsp;	
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
									<TD height="30"><STRONG>�������еĿ��ԣ�</STRONG>
									</TD>
								</TR>
								<TR>
									<TD height="40" width="96%" valign="top">
										<TABLE align="center" border="0" class="ItemList" height="20" width="100%">
											<TR height="24" align="middle">
												<TD align="center" class="ItemTitle" height="20" width="17%">	���Լƻ����												</TD>
												<TD align="center" class="ItemTitle" width="16%">	���Լƻ�����												</TD>
												<TD align="center" class="ItemTitle" width="20%">	����ʱ��												</TD>
												<TD align="center" class="ItemTitle" width="13%">	����												</TD>
												<TD align="center" class="ItemTitle" width="17%">	���Լƻ�״̬												</TD>
												<TD align="center" class="ItemTitle" width="17%">	����												</TD>
											</TR>
											<TR align="center" class="ItemBody">
												<TD align="center" class="ItemBody" height="20">ISSTCWH_J001_01</TD>
												<TD align="center" class="ItemBody">Java����</TD>
												<TD align="center" class="ItemBody">2005-11-20 09:00��2005-11-20 11:00</TD>
												<TD align="center" class="ItemBody">50</TD>
												<TD align="center" class="ItemBody">�ѷ���</TD>
												<TD class="ItemBody">													
													<INPUT type="button" name="joinExam" value="�μӿ���"  onclick="exam()">
												</TD>
											</TR>
											<TR align="center" class="ItemBody">
												<TD align="center" class="ItemBody" height="20">ISSTCWH_J001_02</TD>
												<TD align="center" class="ItemBody">	Java�߼����</TD>
												<TD align="center" class="ItemBody">2005-12-20 09:00��2005-12-20 11:00</TD>
												<TD align="center" class="ItemBody">50</TD>
												<TD align="center" class="ItemBody">�ѷ���</TD>
												<TD class="ItemBody">													
													<INPUT type="button" name="joinExam" value="�μӿ���"  onclick="exam()" disabled>
												</TD>
											</TR>
										</TABLE>
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
					<TR>
						<TD>&nbsp;	
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
									<TD height="30"><STRONG>�Ѿ������Ŀ��ԣ�����5�Σ���</STRONG>
									</TD>
								</TR>
								<TR>
									<TD height="40" width="96%" valign="top">
										<TABLE align="left" border="0" class="ItemList" height="20" width="100%">
											<TR height="24" align="middle">
												<TD align="center" class="ItemTitle" height="20" width="17%">���Լƻ����</TD>
												<TD align="center" class="ItemTitle" width="16%">���Լƻ�����</TD>
												<TD align="center" class="ItemTitle" width="20%">����ʱ��</TD>
												<TD align="center" class="ItemTitle" width="13%">����</TD>
												<TD align="center" class="ItemTitle" width="17%">���Գɼ�״̬</TD>
												<TD align="center" class="ItemTitle" width="17%">����</TD>
											</TR>
											<TR align="middle" class="ItemBody">
												<TD align="center" class="ItemBody" height="20">ISSTCWH_J001_01</TD>
												<TD align="center" class="ItemBody">Java����</TD>
												<TD align="center" class="ItemBody">2005-10-20 09:00��2005-10-20 11:00</TD>
												<TD align="center" class="ItemBody">50</TD>
												<TD align="center" class="ItemBody">�ѷ���</TD>
												<TD align="center" class="ItemBody">													
													<INPUT type="button" name="joinExam" value="��ѯ�ɼ�" onClick="queryResult()">
												</TD>
											</TR>
											<TR align="middle" class="ItemBody">
												<TD align="center" class="ItemBody" height="20">ISSTCWH_J001_02</TD>
												<TD align="center" class="ItemBody">Java�߼����</TD>
												<TD align="center" class="ItemBody">2005-09-20 09:00��2005-09-20 11:00</TD>
												<TD align="center" class="ItemBody">50</TD>
												<TD align="center" class="ItemBody">������</TD>
												<TD align="center" class="ItemBody">													
													<INPUT type="button" name="joinExam" value="��ѯ�ɼ�" disabled onClick="queryResult()">
												</TD>
											</TR>
											<TR align="middle" class="ItemBody">
												<TD align="center" class="ItemBody" height="20">ISSTCWH_J001_03</TD>
												<TD align="center" class="ItemBody">Java�߼����</TD>
												<TD align="center" class="ItemBody">2004-09-20 09:00��2004-09-20 11:00</TD>
												<TD align="center" class="ItemBody">50</TD>
												<TD align="center" class="ItemBody">������</TD>
												<TD align="center" class="ItemBody">													
													<INPUT type="button" name="joinExam" value="��ѯ�ɼ�" disabled onClick="queryResult()">
												</TD>
											</TR>
											<TR align="middle" class="ItemBody">
												<TD align="center" class="ItemBody" height="20">ISSTCWH_J001_04</TD>
												<TD align="center" class="ItemBody">Java�߼����</TD>
												<TD align="center" class="ItemBody">2006-09-20 09:00��2006-09-20 11:00</TD>
												<TD align="center" class="ItemBody">50</TD>
												<TD align="center" class="ItemBody">������</TD>
												<TD align="center" class="ItemBody">													
													<INPUT type="button" name="joinExam" value="��ѯ�ɼ�" disabled onClick="queryResult()">
												</TD>
											</TR>
											<TR align="middle" class="ItemBody">
												<TD align="center" class="ItemBody" height="20">ISSTCWH_J001_05</TD>
												<TD align="center" class="ItemBody">Java�߼����</TD>
												<TD align="center" class="ItemBody">2006-09-20 09:00��2006-09-20 11:00</TD>
												<TD align="center" class="ItemBody">50</TD>
												<TD align="center" class="ItemBody">�ѷ���</TD>
												<TD align="center" class="ItemBody">													
													<INPUT type="button" name="joinExam" value="��ѯ�ɼ�"  onclick="queryResult()">
												</TD>
											</TR>
										</TABLE>
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
					<TR>
						<TD>&nbsp;	
						</TD>
					</TR>
					<TR>
						<TD>
<HR width="98%">
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
			<TD class="pagefootTl"><IMG src="../webep/space.gif" width="778" height="1"></TD>
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
	document.location.href='exam/examResult.htm'; 
}
function exam()
{	
	if(confirm("ȷ���μӿ�����"))
	{
       
		window.showModalDialog("exam/exam.htm","","dialogHeight: 550px; dialogWidth: 800px; dialogTop: 50px; dialogLeft: 100px; edge: Raised; center: Yes; help: No; resizable: Yes; status: Yes;");
	}
}
</SCRIPT>