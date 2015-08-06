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
<TITLE>iSoftStone培训中心考试平台</TITLE>
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
									<TD align="center" class="sys"><A href="<%=basePath %>indexPageAction!exitSystem" class="syslink">退出登录</A><A href="<%=basePath %>indexPageAction!toResetPwd" class="syslink">修改密码</A>
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
						<TD class="FormTitle" height="2" width="100%"><B>考试方案撤销</B>
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
									<TD width="15%">	考试方案编号：
									</TD>
									<TD width="35%">										
										<INPUT class=box name="examNoSchamaPlan" size=20 maxLength=20 value="">
									</TD>
									<TD width="15%">	考试方案名称：
									</TD>
									<TD width="35%">										
										<INPUT class=box name="examNameSchamaPlan" size=20 maxLength=20 value="">
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	批阅方式：
									</TD>
									<TD>
				<select name="questionTypeSchamaPlan" >
				<option value=''>全部</option>
				<option value='1'>自动批阅</option>
				<option value='2'>老师批阅</option>
				
				</select>
									</TD>
									<TD>	录入人：
									</TD>
									<TD>										
				<INPUT class=box name="examPeopleSchamaPlan" size=20 maxLength=20 value="">
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	录入日期：
									</TD>
									<TD colspan="3">	由：										
											<INPUT type="text" name="examTimeStartSchamaPlan" class="Wdate"  value='' onClick="WdatePicker()">&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;到：										
										<INPUT type="text" name="examTimeEndSchamaPlan" class="Wdate"  value='' onClick="WdatePicker()">&nbsp;
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>
									</TD>
									<TD colspan="3" align="right">										
										<INPUT class="button" type="button"  name="search" value=" 查 找 " onclick="queryFind()">
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
												<TD class="ItemTitle" height="20" width="14%">	考试方案编号
												</TD>
												<TD class="ItemTitle" height="20" width="14%">	考试方案名称
												</TD>
												<TD class="ItemTitle" height="20" width="14%">	批阅方式
												</TD>
												<TD class="ItemTitle" height="20" width="14%">	录入人
												</TD>
												<TD class="ItemTitle" width="14%">	考试方案录入日期
												</TD>
											</TR>
									
										<c:forEach items="${list}" var="li">
										
											<TR align="middle" class="ItemBody">
												<TD class="ItemBody" height="20">	<a href='examSchemaAction!examSchemeCancel2?Id_esMyselfId=${li.esId}'>${li.esMyselfId}</a>
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
		              	
                        <input type="text" name="QueryPageNo" id="QueryPageNo" size="3" value="${currentPage}" class="SearchBar_Page" >
                           页 / 共${totalPage} 页 
                        <input type="button" name="btnGo" value="go" class="SearchBar_Btn" onclick="goToPage()">
							
                        <input type="button" name="btnFirst" value="|&lt;" class="SearchBar_Btn" onclick="toLastFirst(${currentPage})">

                        <input type="button" name="btnPrevious" value="&lt;" class="SearchBar_Btn" onclick="toNextPrevious(${currentPage})">

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
			<TD height="25" class="pagefoot"><FONT face="Arial, Helvetica, sans-serif">&copy;</FONT> 2005-2007  版权所有 软通动力信息技术有限公司 Powered by 软通动力武汉开发中心
			</TD>
		</TR>
	</TABLE>
</BODY>
</HTML>
<SCRIPT language="JavaScript">


function queryFind()
{	
    
	document.form1.action="examSchemaAction!examSchemeCancel";
	document.form1.submit();
}
function queryResult()
{	
	document.location.href='examResult.htm'; 
}

//1 到第一页
function toLastFirst(currentPage){
document.location.href='<%=basePath%>examSchemaAction!examSchemeCancel?pageMethod=first&currentPage='+currentPage; 
   }

//2到第上一页
function toNextPrevious(currentPage){
document.location.href='<%=basePath%>examSchemaAction!examSchemeCancel?pageMethod=previous&currentPage='+currentPage; 
  }

//到第下一页
function toNext(currentPage){

  document.location.href='<%=basePath%>examSchemaAction!examSchemeCancel?pageMethod=next&currentPage='+currentPage; 
  
  }

//到最后一页
function toLastEnd(currentPage){

  document.location.href='<%=basePath%>examSchemaAction!examSchemeCancel?pageMethod=last&currentPage='+currentPage; 
  
  }

//去所选的页面
function goToPage(){

         var page = document.getElementById("QueryPageNo").value;  
         var patrn=/^[0-9]{1,20}$/;  
            if(page == null || page == "" || !patrn.exec(page) || page.indexOf('0') == 0)  
         {  
          alert("请正确输入,只能为数字！");  
               return false;  
           }  
            document.location="<%=basePath%>examSchemaAction!examSchemeCancel?pageMethod=goPage&currentPage="+ page;
}

</SCRIPT>