<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>iSoftStone培训中心考试平台</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="<%=basePath %>webep/css/style.css" type="text/css">
</HEAD>
<BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<SCRIPT language="JavaScript1.2" src="<%=basePath %>webep/js/coolmenus4.js"></SCRIPT>
 <script language="javascript" type="text/javascript" src="<%=basePath %>webep/js/My97DatePicker/WdatePicker.js"></script>
<SCRIPT language="JavaScript1.2" src="<%=basePath %>webep/js/cm_addins.js"></SCRIPT>
<FORM action="" name="form1" method="post">
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
									<TD align="center" class="sys">  <A href="<%=basePath %>indexPageAction!exitSystem" class="syslink">退出登录</A>
											<A href="<%=basePath %>indexPageAction!toResetPwd" class="syslink">修改密码</A>
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
			<TD width="20">&nbsp;	
			</TD>
			<TD align="left" valign="top">
				<TABLE border="0" class="top" width="700">
					<TR>
						<TD class="FormTitle" height="2" width="100%"><B>题目审核</B>
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
									<TD width="12%">	题目编号：
									</TD>
									<TD width="35%">										
										<INPUT class=box name="problemNo" size=20 maxLength=20 value="">
									</TD>
									<TD width="12%">	题目类型：
									</TD>
									<TD>										
			<select name="ptName" >
				<option value="">全部</option>
				<c:forEach items="${proTypeList}" var="sl">
				<option value="${sl.ptName }">${sl.ptName }</option>
				</c:forEach>
				</select>
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	题目范围：
									</TD>
									<TD>
				<select name="psName" >
				<option value="">全部</option>
				<c:forEach items="${ProScopeList}" var="pl">
				<option value="${pl.psName }">${pl.psName }</option>
				</c:forEach>
				</select>
									</TD>
									<TD>	题目难度：
									</TD>
									<TD>										
				<select name="pdlName" > 
				<option value="" selected>全部</option>
				<c:forEach items="${proDiffLevList}" var="dl">
				<option value=${dl.pdlName }>${dl.pdlName }</option>
				</c:forEach>
				</select>
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	录入人：
									</TD>
									<TD>										
				<INPUT class=box name="addTbUser" size=20 maxLength=20 value="">
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	录入日期：
									</TD>
									<TD colspan="3">	由：										
										<INPUT type="text" name="startTime" class="Wdate"  value='' onClick="WdatePicker()">&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;到：										
										<INPUT type="text" name="endTime" class="Wdate"  value='' onClick="WdatePicker()">&nbsp;
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>
									</TD>
									<TD colspan="3" align="right">
										<input type="hidden" name="newHQL" value="1">											
										<INPUT class="button" type="button"  name="search" value=" 查 找 " onclick="queryResult()">
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
												<TD class="ItemTitle" height="20" width="14%">	题目编号
												</TD>
												<TD class="ItemTitle" width="14%">	题目类型
												</TD>
												<TD class="ItemTitle" width="14%">	题目范围
												</TD>
												<TD class="ItemTitle" width="14%">	题目难度
												</TD>
												<TD class="ItemTitle" width="14%">	录入人
												</TD>
												<TD class="ItemTitle" width="14%">	录入日期
												</TD>
												
											</TR>
											<c:forEach items="${problemList}" var="pl">
											<TR align="center" class="ItemBody">
												<TD class="ItemBody" height="20">	<a href="<%=basePath %>problemManagerAction!quesLibAudit2?pNO=${pl.col1 }">${pl.col1 }</a>
												</TD>
												<TD class="ItemBody" align="left">${pl.tbProblemType.ptName }
												</TD>
												<TD class="ItemBody" align="left">${pl.PTitle }
												</TD>
												<TD class="ItemBody" align="left">${pl.tbProblemDifficultyLevel.pdlName }
												</TD>
												<TD class="ItemBody" align="left">${pl.tbUser.UName }
												</TD>
												<TD class="ItemBody">${pl.PAddTime } 
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
                      <P><B>第 
		              	
                        <input type="text" id="queryPageNo" name="queryPageNo" size="3" value="${currentPage}" class="SearchBar_Page">
                           页 / 共 ${totalPages } 页 
                        <input type="submit" name="btnGo" value="go" class="SearchBar_Btn" onclick="clickButton()">
							
                        <input type="button" name="btnFirst" value="|&lt;" class="SearchBar_Btn" onclick="clickButton1()" >

                        <input type="button" name="btnPrevious" value="&lt;" class="SearchBar_Btn" onclick="clickButton2()">

                        <input type="button" name="btnNext" value="&gt;" class="SearchBar_Btn" onclick="clickButton3()" >

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
			<TD height="25" class="pagefoot"><FONT face="Arial, Helvetica, sans-serif">&copy;</FONT> 2005-2007  版权所有 软通动力信息技术有限公司 Powered by 软通动力武汉开发中心
			</TD>
		</TR>
	</TABLE>
	</FORM>
</BODY>
</HTML>
<SCRIPT language="JavaScript">
function queryResult()
{	
	form1.action='<%=basePath %>problemManagerAction!quesLibAudit?newHQL=1';
	form1.submit();
}

function clickButton(){ 
		var  page = document.getElementById("queryPageNo").value;
		var patern =/^[0-9]{1,20}$/;
		if (page == null || page == "" || !patern.exec(page) || page.indexOf('0') == 0 )
		{
			alter("请正确输入，只能为数字?");
	        return false;
		}
		form1.action="<%=basePath %>problemManagerAction!quesLibAudit?currentPage="+page;
		form1.submit();
}	
function clickButton1(){ 
	
	    document.location.href='<%=basePath %>problemManagerAction!quesLibAudit?pageMethod=first&currentPage=${currentPage}';
}	
function clickButton2(){ 
	
	   document.location.href='<%=basePath %>problemManagerAction!quesLibAudit?pageMethod=previous&currentPage=${currentPage}';
}	
function clickButton3(){ 
	
	   document.location.href='<%=basePath %>problemManagerAction!quesLibAudit?pageMethod=next&currentPage=${currentPage}';
}	
function clickButton4(){ 
	
	   document.location.href='<%=basePath %>problemManagerAction!quesLibAudit?pageMethod=last&currentPage=${currentPage}';
}	
</SCRIPT>	