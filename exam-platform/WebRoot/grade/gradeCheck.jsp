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
</HEAD>
<BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form action="" name="form3" method="post">
<SCRIPT language="JavaScript1.2" src="<%=basePath%>webep/js/coolmenus4.js"></SCRIPT>
 <script language="javascript" type="text/javascript" src="<%=basePath%>webep/js/My97DatePicker/WdatePicker.js"></script>
<SCRIPT language="JavaScript1.2" src="<%=basePath%>webep/js/cm_addins.js"></SCRIPT>
	<script language="JavaScript" src="<%=basePath%>webep/js/Control.js"></script>
	<script language="JavaScript" src="<%=basePath%>webep/js/calendar.js"></script>
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
									<TD align="center" class="sys"><A href="<%=basePath%>Index.htm" class="syslink">退出登录</A> <A href="password.htm" class="syslink">修改密码</A>
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
			<TD width="20">&nbsp;	
			</TD>
			<TD align="left" valign="top">
				<TABLE border="0" class="top" width="700">
					<TR>
						<TD class="FormTitle" height="2" width="100%"><B>成绩批阅</B>
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
									<TD width="15%">	考试计划编号：
									</TD>
									<TD width="35%">										
										<INPUT class=box name="epMyselfId" size=20 maxLength=20 value="">
									</TD>
									<TD width="15%">	考试计划描述：
									</TD>
									<TD width="35%">										
										<INPUT class=box name="planDescribe" size=20 maxLength=20 value="">
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD >	班级名称：
									</TD>
									<TD >										
										<INPUT class=box name="CName" size=20 maxLength=20 value="">
									</TD>
                               </TR>
							   	<TR>
									<TD height="20">
									</TD>
									<TD >	考试方案编号：
									</TD>
									<TD >										
										<INPUT class=box name="esMyselfId" size=20 maxLength=20 value="">
									</TD>
									<TD>	批阅状态：
									</TD>
									<TD width="35%">																				
				<select name="rsName" >
				<option value='0'>全部</option>
				<option value='1'>未批阅</option>
				<option value='2'>批阅中</option>
				<option value='3'>已批阅</option>
				</select>
									</TD>
									
                               </TR>
								
								<TR>
									<TD height="20">
									</TD>
									<TD>	考试时间：
									</TD>
									<TD colspan="4">由：										
										<INPUT type="text" name="planStartTime" class="Wdate"  value='' onClick="WdatePicker()">&nbsp;
									<select name="starthour">
                                      <option value="">8</option>
                                      <option >9</option>
                                      <option>10</option>
                                      <option>14</option>
                                      <option>15</option>
                                      <option>16</option>
                                    </select>
									：
									<select name="planEndTime">
										<option value="">00</option>
										<option>15</option>
										<option>30</option>
										<option>45</option>
									</select>
										&nbsp;&nbsp至：										
										<INPUT type="text" name="planEndTime" class="Wdate"  value='' onClick="WdatePicker()"><select name="endhour">
                                      <option>10</option>
                                      <option>11</option>
									  <option>12</option>
                                      <option>16</option>
                                      <option>17</option>
									  <option>18</option>
                                    </select>：<select name="endminitue">
										<option>00</option>
										<option>15</option>
										<option>30</option>
										<option>45</option>
									</select>
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>
									</TD>
									<TD colspan="3" align="right">	
									<input type="hidden" name="newHQL" value="1">									
										<INPUT class="button" type="button"  name="search" value=" 查 找 " onClick="next()">
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
												
												<TD class="ItemTitle" width="12%">	考试计划编号
												</TD>
												<TD class="ItemTitle" width="14%">	考试计划描述
												</TD>
												<TD class="ItemTitle" width="12%">	考试方案
												</TD>
												<TD class="ItemTitle" width="21%">	考试时间
												</TD>
												<TD class="ItemTitle" width="12%">	班级编号
												</TD>
												<TD class="ItemTitle" width="12%">	批阅状态
												</TD>
												<TD class="ItemTitle" width="12%">	操作
												</TD>
											</TR>
											<c:forEach items="${gradeChecklist}" var="li">
											<TR align="middle" class="ItemBody">
												<TD class="ItemBody" height="20">	<a href='examPlanAction!examProjectQuery3?planId=${li.planId}'> ${li.epMyselfId }</a>
												</TD>
												<TD class="ItemBody" align="left">	${li.planDescribe }
												</TD>
												<TD class="ItemBody">	<a href='<%=basePath%>examSchemaAction!examSchemeQuery3'> ${li.tbExamScheme.esMyselfId }</a>
												</TD>
												<TD class="ItemBody">	${li.planStartTime }－${li.planEndTime }
												</TD>
												<TD class="ItemBody">	<a href='..\class\classQuery3.htm'>${li.tbClasses.CNum }</a>
												</TD>
												<TD class="ItemBody">	${li.epMyselfId }
												</TD>
												<TD class="ItemBody">	<INPUT type="button" name="joinExam" value="成绩批阅"  onclick="gradeCheck(${li.planId})"> 
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
                      <P><B>第 
		              	
                         <input type="text" name="QueryPageNo" size="3" value="${currentPage}" class="SearchBar_Page">
                           页 / 共 ${totalPage} 页 
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
function gradeCheck(i)
{	
	document.location.href='<%=basePath%>scoreManagerAction!gradeCheckList?c_id1='+ i;
}
function next()
{
	form3.action="<%=basePath%>scoreManagerAction!gradeCheck?newHQL=1";
	form3.submit();
}
function go()
{
    var page=form3.QueryPageNo.value;

	alert("当前页 "+page);
	var patrn=/^[0-9]{1,20}$/;  
    if(page == null || page == "" || !patrn.exec(page) || page.indexOf('0') == 0)  
 {  
  alert("请正确输入,只能为数字！");  
       return false;  
   }  
	document.location.href='<%=basePath%>scoreManagerAction!gradeCheck?pageMethod=goPage&currentPage='+page;
	
}
function firstPage()
{
	document.location.href='<%=basePath%>scoreManagerAction!gradeCheck?pageMethod=first&currentPage=${currentPage}';
	
}
function prePage()
{
	document.location.href='<%=basePath%>scoreManagerAction!gradeCheck?pageMethod=previous&currentPage=${currentPage}';

}
function nextPage()
{
	document.location.href='<%=basePath%>scoreManagerAction!gradeCheck?pageMethod=next&currentPage=${currentPage}';
	
}function endPage()
{
	document.location.href='<%=basePath%>scoreManagerAction!gradeCheck?pageMethod=last&currentPage=${currentPage}';
	
}
</SCRIPT>