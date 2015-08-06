<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>iSoftStone培训中心考试平台</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="<%= basePath %>webep/css/style.css" type="text/css">
</HEAD>
<BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<SCRIPT language="JavaScript1.2" src="<%=basePath %>webep/js/chen.js"></SCRIPT>
<SCRIPT language="JavaScript1.2" src="<%= basePath %>webep/js/coolmenus4.js"></SCRIPT>
 <script language="javascript" type="text/javascript" src="<%= basePath %>webep/js/My97DatePicker/WdatePicker.js"></script>
<SCRIPT language="JavaScript1.2" src="<%= basePath %>webep/js/cm_addins.js"></SCRIPT>
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="pagetop">
					<TR>
						<TD width="420" nowrap class="headerLogo"><IMG src="<%= basePath %>webep/logo.gif"><IMG src="<%= basePath %>webep/logo_js.gif">
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
									<TD>	&nbsp;
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
					<TR>
						<TD height="2" class="menuBl1"><IMG src="<%= basePath %>webep/space.gif" width="1" height="1"></TD>
					</TR>
					<TR>
						<TD height="3" class="menuBl2"><IMG src="<%= basePath %>webep/space.gif" width="1" height="1"></TD>
					</TR>
				</TABLE>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
					<TR>
						<TD><IMG src="<%= basePath %>webep/space.gif" width="778" height="1"></TD>
					</TR>
				</TABLE>
<P>
<SCRIPT language=JavaScript1.2>showMenu("","<%= basePath %>",2);
</SCRIPT>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#999999">
					<TR>
						<TD><IMG src="<%= basePath %>webep/space.gif" width="1" height="1"></TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE><BR>
	<form action="" name="form1" method="post">
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD width="20">	&nbsp;
			</TD>
			<TD align="left" valign="top">
				<TABLE border="0" class="top" width="700">
					<TR>
						<TD class="FormTitle" height="2" width="100%"><B>用户查询</B>
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
									<TD width="12%">	用户帐号：
									</TD>
									<TD width="35%">										
										<INPUT class=box name="uAccount" size=20 maxLength=20 value="">
									</TD>														
									<TD width="12%">	用户姓名：
									</TD>
									<TD>
				<INPUT class=box name="uName" size=20 maxLength=20 value="">
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	用户类型：
									</TD>
									<TD>
				<select name="userTypeName" >
				<option value='0'>全部</option>
				<option value='1'>讲师</option>
				<option value='2'>班主任</option>
				<option value='3'>教务主任</option>
				<option value='4'>一般用户</option>
				</select>
									</TD>
									<TD>	性别：
									</TD>
									<TD>										
				<select name="uGender" >
				<option value='0'>全部</option>
				<option value='1'>男</option>
				<option value='2'>女</option>
				</select>
									</TD>
								</TR>								
								<TR>
									<TD height="20">
									</TD>
									<TD>	录入日期：
									</TD>
									<TD colspan="3">	由：										
											<INPUT type="text" name="uHiretime" class="Wdate"  value='' onClick="WdatePicker()">&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;到：										
										<INPUT type="text" name="uHiretime1" class="Wdate"  value='' onClick="WdatePicker()">&nbsp;
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>
									</TD>
									<TD colspan="3" align="right">										
										<INPUT class="button" type="button"  name="search" value=" 增 加 " onclick="toAdd()">
										<INPUT class="button" type="button"  name="search" value=" 查 找 " onclick="toFindWithCon()">
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
												<TD class="ItemTitle" height="20" width="14%">	用户帐号
												</TD>
												<TD class="ItemTitle" width="14%">	用户姓名
												</TD>
												<TD class="ItemTitle" width="14%">	性别
												</TD>
											   <TD class="ItemTitle" width="14%">	用户类型
												</TD>
												 <TD class="ItemTitle" width="14%">	录入日期
												</TD>
											</TR>
											<c:forEach items="${list}" var="li">
											<TR align="middle" class="ItemBody">
												<TD class="ItemBody" height="20"><a href="systemsettingAction!toUpdateUser?temp=${li.UId }">${li.UAccount }</a>
												</TD>
												<TD class="ItemBody" align="left">	${li.UName }
												</TD>
												<TD class="ItemBody">	${li.UGender }
												</TD>
												<TD class="ItemBody" align="left">	${li.tbUserType.utName }
												</TD>
												<TD class="ItemBody">	${li.UHiretime }
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
		              	
                        <input type="text" name="QueryPageNo" size="3" value="${currentPage}" class="SearchBar_Page">
                           		页 /共 ${totalPage}页 
                        <input type="button" name="btnGo" value="go" class="SearchBar_Btn" onclick="go()">
							
                        <input type="button" name="btnFirst" value="|&lt;" class="SearchBar_Btn" onclick="first()">

                        <input type="button" name="btnPrevious" value="&lt;" class="SearchBar_Btn" onclick="previous()">

                        <input type="button" name="btnNext" value="&gt;" class="SearchBar_Btn" onclick="next()">

                        <input type="button" name="btnEnd" value="&gt;|" class="SearchBar_Btn" onclick="end()">

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
	</form>
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD class="pagefootTl"><IMG src="<%= basePath %>webep/space.gif" width="778" height="1"></TD>
		</TR>
		<TR>
			<TD height="25" class="pagefoot"><FONT face="Arial, Helvetica, sans-serif">&copy;</FONT> 2005-2007  版权所有 软通动力信息技术有限公司 Powered by 软通动力武汉开发中心
			</TD>
		</TR>
	</TABLE>
</BODY>
</HTML>
<SCRIPT language="JavaScript">
function toAdd()
{	
	
	document.location.href='<%= basePath %>systemsettingAction!toNext?temp=toAddUser'; 

}
function create()
{	
	document.location.href='userSetting1.htm'; 
}
function toFindWithCon()
{
	for(i=0;i<form1.length;i++){
		if(!checkInput(form1.elements[i].value)){
			alert("存在非法字符");
			return  ;
		}
	
	}
	form1.action="systemsettingAction!findUserCondition";
	form1.submit();

}
function go()
{
	var page=form1.QueryPageNo.value;
		var patrn=/^[0-9]{1,20}$/;  
	    if(page == null || page == "" || !patrn.exec(page) || page.indexOf('0') == 0)  
	 {  
	  alert("请正确输入,只能为数字！");  
	       return false;  
	   }  
	form1.action="systemsettingAction!findWithPage?currentPage="+page+"&pageMethod=go";
	form1.submit();
}
function first()
{
	form1.action="systemsettingAction!findWithPage?currentPage="+${currentPage}+"&pageMethod=first";
	form1.submit();
}
function previous()
{
	form1.action="systemsettingAction!findWithPage?currentPage="+${currentPage}+"&pageMethod=previous";
	form1.submit();
}
function next()
{
	form1.action="systemsettingAction!findWithPage?currentPage="+${currentPage}+"&pageMethod=next&flag=1";
	form1.submit();
}
function end()
{
	form1.action="systemsettingAction!findWithPage?currentPage="+${currentPage}+"&pageMethod=last&flag=1";
	form1.submit();
}
</SCRIPT>