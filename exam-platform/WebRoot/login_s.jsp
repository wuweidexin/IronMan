<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>iSoftStone培训中心考试平台</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="webep/css/style.css" type="text/css">
<DIV id="sending" style="position:absolute; top:320; left:20; z-index:10; visibility:hidden">
		<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
			<TR>
				<TD width="30%">
				</TD>
				<TD bgcolor="#ff9900">
					<TABLE width="100%" height="70" border="0" cellspacing="2" cellpadding="0">
						<TR>
							<TD bgcolor="#eeeeee" align="center">	正在读取试题, 请稍候...
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
									<TD align="center" class="sys"><A href="Index.htm" class="syslink">退出登录</A> <A href="password1.htm" class="syslink">修改密码</A>
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
						<TD class="FormTitle" height="2" width="100%"><B>个人信息</B>
						</TD>
					</TR>
					<TR>
						<TD height="200" width="100%">
							<TABLE align="center" border="1" bordercolor="#999999" height="190" width="99%">
								<TR bordercolor="#eaeaea">
									<TD>	学生姓名：周明星
									</TD>
								</TR>
								<TR bordercolor="#eaeaea">
									<TD>	性别：男
									</TD>
								</TR>
								<TR bordercolor="#eaeaea">
									<TD>	班级名称：JAVA第一期
									</TD>
								</TR>
								<TR bordercolor="#eaeaea">
									<TD>	学生帐号：elf
									</TD>
								</TR>
								<TR bordercolor="#eaeaea">
									<TD>	考试次数：3
									</TD>
								</TR>
								<TR bordercolor="#eaeaea">
									<TD>	上次登陆时间：
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
						<TD class="FormTitle" height="2" width="100%"><B>考试信息</B>
						</TD>
					</TR>
					<TR>
						<TD width="100%">
							<TABLE align="center" width="97%">
								<TR>
									<TD height="30"><STRONG>即将进行的考试：</STRONG>
									</TD>
								</TR>
								<TR>
									<TD height="40" width="96%" valign="top">
										<TABLE align="center" border="0" class="ItemList" height="20" width="100%">
											<TR height="24" align="middle">
												<TD align="center" class="ItemTitle" height="20" width="17%">	考试计划编号												</TD>
												<TD align="center" class="ItemTitle" width="16%">	考试计划名称												</TD>
												<TD align="center" class="ItemTitle" width="20%">	考试时间												</TD>
												<TD align="center" class="ItemTitle" width="13%">	题量												</TD>
												<TD align="center" class="ItemTitle" width="17%">	考试计划状态												</TD>
												<TD align="center" class="ItemTitle" width="17%">	操作												</TD>
											</TR>
											<TR align="center" class="ItemBody">
												<TD align="center" class="ItemBody" height="20">ISSTCWH_J001_01</TD>
												<TD align="center" class="ItemBody">Java基础</TD>
												<TD align="center" class="ItemBody">2005-11-20 09:00－2005-11-20 11:00</TD>
												<TD align="center" class="ItemBody">50</TD>
												<TD align="center" class="ItemBody">已发布</TD>
												<TD class="ItemBody">													
													<INPUT type="button" name="joinExam" value="参加考试"  onclick="exam()">
												</TD>
											</TR>
											<TR align="center" class="ItemBody">
												<TD align="center" class="ItemBody" height="20">ISSTCWH_J001_02</TD>
												<TD align="center" class="ItemBody">	Java高级编程</TD>
												<TD align="center" class="ItemBody">2005-12-20 09:00－2005-12-20 11:00</TD>
												<TD align="center" class="ItemBody">50</TD>
												<TD align="center" class="ItemBody">已发布</TD>
												<TD class="ItemBody">													
													<INPUT type="button" name="joinExam" value="参加考试"  onclick="exam()" disabled>
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
									<TD height="30"><STRONG>已经结束的考试（最后的5次）：</STRONG>
									</TD>
								</TR>
								<TR>
									<TD height="40" width="96%" valign="top">
										<TABLE align="left" border="0" class="ItemList" height="20" width="100%">
											<TR height="24" align="middle">
												<TD align="center" class="ItemTitle" height="20" width="17%">考试计划编号</TD>
												<TD align="center" class="ItemTitle" width="16%">考试计划名称</TD>
												<TD align="center" class="ItemTitle" width="20%">考试时间</TD>
												<TD align="center" class="ItemTitle" width="13%">题量</TD>
												<TD align="center" class="ItemTitle" width="17%">考试成绩状态</TD>
												<TD align="center" class="ItemTitle" width="17%">操作</TD>
											</TR>
											<TR align="middle" class="ItemBody">
												<TD align="center" class="ItemBody" height="20">ISSTCWH_J001_01</TD>
												<TD align="center" class="ItemBody">Java基础</TD>
												<TD align="center" class="ItemBody">2005-10-20 09:00－2005-10-20 11:00</TD>
												<TD align="center" class="ItemBody">50</TD>
												<TD align="center" class="ItemBody">已发布</TD>
												<TD align="center" class="ItemBody">													
													<INPUT type="button" name="joinExam" value="查询成绩" onClick="queryResult()">
												</TD>
											</TR>
											<TR align="middle" class="ItemBody">
												<TD align="center" class="ItemBody" height="20">ISSTCWH_J001_02</TD>
												<TD align="center" class="ItemBody">Java高级编程</TD>
												<TD align="center" class="ItemBody">2005-09-20 09:00－2005-09-20 11:00</TD>
												<TD align="center" class="ItemBody">50</TD>
												<TD align="center" class="ItemBody">批阅中</TD>
												<TD align="center" class="ItemBody">													
													<INPUT type="button" name="joinExam" value="查询成绩" disabled onClick="queryResult()">
												</TD>
											</TR>
											<TR align="middle" class="ItemBody">
												<TD align="center" class="ItemBody" height="20">ISSTCWH_J001_03</TD>
												<TD align="center" class="ItemBody">Java高级编程</TD>
												<TD align="center" class="ItemBody">2004-09-20 09:00－2004-09-20 11:00</TD>
												<TD align="center" class="ItemBody">50</TD>
												<TD align="center" class="ItemBody">已批阅</TD>
												<TD align="center" class="ItemBody">													
													<INPUT type="button" name="joinExam" value="查询成绩" disabled onClick="queryResult()">
												</TD>
											</TR>
											<TR align="middle" class="ItemBody">
												<TD align="center" class="ItemBody" height="20">ISSTCWH_J001_04</TD>
												<TD align="center" class="ItemBody">Java高级编程</TD>
												<TD align="center" class="ItemBody">2006-09-20 09:00－2006-09-20 11:00</TD>
												<TD align="center" class="ItemBody">50</TD>
												<TD align="center" class="ItemBody">已批阅</TD>
												<TD align="center" class="ItemBody">													
													<INPUT type="button" name="joinExam" value="查询成绩" disabled onClick="queryResult()">
												</TD>
											</TR>
											<TR align="middle" class="ItemBody">
												<TD align="center" class="ItemBody" height="20">ISSTCWH_J001_05</TD>
												<TD align="center" class="ItemBody">Java高级编程</TD>
												<TD align="center" class="ItemBody">2006-09-20 09:00－2006-09-20 11:00</TD>
												<TD align="center" class="ItemBody">50</TD>
												<TD align="center" class="ItemBody">已发布</TD>
												<TD align="center" class="ItemBody">													
													<INPUT type="button" name="joinExam" value="查询成绩"  onclick="queryResult()">
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
			<TD height="25" class="pagefoot"><FONT face="Arial, Helvetica, sans-serif">&copy;</FONT> 2005-2007  版权所有 软通动力信息技术有限公司 Powered by 软通动力武汉开发中心
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
	if(confirm("确定参加考试吗？"))
	{
       
		window.showModalDialog("exam/exam.htm","","dialogHeight: 550px; dialogWidth: 800px; dialogTop: 50px; dialogLeft: 100px; edge: Raised; center: Yes; help: No; resizable: Yes; status: Yes;");
	}
}
</SCRIPT>