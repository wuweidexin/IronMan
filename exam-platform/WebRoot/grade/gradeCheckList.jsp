<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>iSoftStone培训中心考试平台</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="<%=basePath%>webep/css/style.css" type="text/css">
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
<form action="" name="form4" method="post" >	
<SCRIPT language="JavaScript1.2" src="<%=basePath%>webep/js/coolmenus4.js"></SCRIPT>
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
									<TD align="center" class="sys"><A href="Index.htm" class="syslink">退出登录</A> <A href="password.htm" class="syslink">修改密码</A>
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
<SCRIPT language=JavaScript1.2>showMenu("","<%=basePath%>",2);
</SCRIPT>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#999999">
					<TR>
						<TD><IMG src="webep/space.gif" width="1" height="1"></TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
   </TABLE>
	</TABLE><BR>
			
			<TD width="20">	&nbsp;
			</TD>
			<TD align="left" valign="top">
				<TABLE border="0" class="top" height="217" width="700">
					<TR>
						<TD class="FormTitle" height="2" width="100%"><B>试卷批阅</B>
						</TD>
					</TR>
					<TR>
						<TD width="100%">
							<TABLE align="center" width="97%">
								<TR>
									<TD height="30"><STRONG>等待批阅的试卷：</STRONG>
									</TD>
								</TR>
								<TR>
									<TD height="40" width="96%" valign="top">
										<TABLE align="center" border="0" class="ItemList" height="20" width="100%">
											<TR height="24" align="middle">
												<TD class="ItemTitle" height="20" width="14%">	考试计划编号
												</TD>
												<TD class="ItemTitle" width="14%">	考试计划描述
												</TD>
												<TD class="ItemTitle" width="14%">	考试时间
												</TD>
												<TD class="ItemTitle" width="14%">	考试方案
												</TD>
												<TD class="ItemTitle" width="14%">	考生名字
												</TD>
												<TD class="ItemTitle" width="14%">	批阅截至时间
												</TD>
												<TD class="ItemTitle" width="14%">	操作
												</TD>
											</TR>
											<c:forEach items="${examPlanCheck.tbExamPapers}" var="paper">
											<TR align="middle" class="ItemBody">
											
												<TD class="ItemBody" height="20"><a href='#'>${examPlanCheck.epMyselfId}</a>
												</TD>
												<TD class="ItemBody" align="left">${examPlanCheck.planDescribe}
												</TD>
												<TD class="ItemBody">${examPlanCheck.planStartTime}－${examPlanCheck.planEndTime}
												</TD>
												<TD class="ItemBody"><a href='#'>${examPlanCheck.tbExamScheme.esMyselfId}</a>
												
												<TD class="ItemBody">${paper.tbUser.UName }
												</TD>
												<input type="hidden" name="paperId" value="${paper.epId}">
												</TD>
												<TD class="ItemBody" align="left"><a href='#'>${examPlanCheck.planEndTime}</a>
												</TD>

												<TD class="ItemBody">													
													<INPUT type="button" name="joinExam" value="成绩批阅"  onclick="gradeCheck(${examPlanCheck.planId},${paper.epId})">
												</TD>
												
											</TR>
											</c:forEach>

											<TR align="middle" class="ItemBody">
									      <TD colspan="7" height="1">
										  <TABLE border="0" cellpadding="0" cellspacing="3" class="SearchBar" height="20" width="135%">
											<TR>
												<TD height="20" width="1100">
													<DIV align="right">
<P><B>第														
														<INPUT type="text" name="QueryPageNo" size="3" value="${currentPage}" class="SearchBar_Page">页 / 共 ${totalPage} 页														
														<INPUT type="button" name="btnGo" value="go" class="SearchBar_Btn">														
														<INPUT type="button" name="btnFirst" value="|&lt;" class="SearchBar_Btn" >														
														<INPUT type="button" name="btnPrevious" value="&lt;" class="SearchBar_Btn">														
														<INPUT type="button" name="btnNext" value="&gt;" class="SearchBar_Btn" >														
														<INPUT type="button" name="btnEnd" value="&gt;|" class="SearchBar_Btn" ><SPAN class="SearchBar"></SPAN></B></P>
													</DIV>
												</TD>
											</TR>
										</TABLE>
									      </TD>
								          </TR>
										</TABLE>
									</TD>
									
								</TR>
								<input class=button type=button name="bsave" value=" 返 回 " onclick="javascript:history.back(-1)" align="right">
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
							
							</TABLE>
							
						</TD>
					</TR>
			</TABLE><BR>
	</TD>
	</TD>
		</TR>
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD class="pagefootTl"><IMG src="<%=basePath%>webep/space.gif" width="778" height="1"></TD>
		</TR>
		<TR>
			<TD height="25" class="pagefoot"><FONT face="Arial, Helvetica, sans-serif">&copy;</FONT> 2005-2007  版权所有 软通动力信息技术有限公司 Powered by 软通动力武汉开发中心
			</TD>
		</TR>
	</TABLE>
	</form>
</BODY>
</HTML>
<SCRIPT language="JavaScript">
function queryResult()
{	
	
	document.location.href='<%=basePath%>exam/examResult.htm'; 
}
function gradeCheck(i,j)
{	
	if(confirm("确认批阅该试卷吗？"))
	{
		showSending();
		form4.action="<%=basePath%>scoreManagerAction!gradeForCheck?gradeForCheck="+i+"&paperId="+j;
		form4.submit(); 
	}
}
function go()
{
    var page=form4.QueryPageNo.value;

	alert("当前页 "+page);
	var patrn=/^[0-9]{1,20}$/;  
    if(page == null || page == "" || !patrn.exec(page) || page.indexOf('0') == 0)  
 {  
  alert("请正确输入,只能为数字！");  
       return false;  
   }  
	document.location.href='<%=basePath%>scoreManagerAction!gradeCheckList?pageMethod=goPage&currentPage='+page;
	
}
function firstPage()
{
	document.location.href='<%=basePath%>scoreManagerAction!gradeCheckList?pageMethod=first&currentPage=${currentPage}';
	
}
function prePage()
{
	document.location.href='<%=basePath%>scoreManagerAction!gradeCheckList?pageMethod=previous&currentPage=${currentPage}';

}
function nextPage()
{
	document.location.href='<%=basePath%>scoreManagerAction!gradeCheckList?pageMethod=next&currentPage=${currentPage}';
	
}function endPage()
{
	document.location.href='<%=basePath%>scoreManagerAction!gradeCheckList?pageMethod=last&currentPage=${currentPage}';
	
}
</SCRIPT>