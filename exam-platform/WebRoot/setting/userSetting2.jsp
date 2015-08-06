
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
<SCRIPT language="JavaScript1.2" src="<%= basePath %>webep/js/coolmenus4.js"></SCRIPT>
<SCRIPT language="JavaScript1.2" src="<%= basePath %>webep/js/cm_addins.js"></SCRIPT>
<SCRIPT language="JavaScript1.2" src="<%=basePath %>webep/js/chen.js"></SCRIPT>
<form action="" name="form1" method="post">
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
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD width="20">	&nbsp;
			</TD>
			<TD align="left" valign="top">
				<TABLE border="0" class="top" width="700">
					<TR>
						<TD class="FormTitle" height="2" width="100%"><B>用户新增</B>
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
   									<TD>
										<INPUT class="box" name="UAccount" size="20" maxLength="20" value="${uAccount }" type="Text" disabled>
										<INPUT class="box" name="user.UAccount" size="20" maxLength="20" value="${uAccount }" type="hidden">
   									</TD>
   								</TR>
								<TR>
								    <TD height="20">
   									</TD>
								    <TD>	初始密码：
   									</TD>
   									<TD>
									<INPUT class="box" name="user.UPwd" size="20" maxLength="20" value="000000" type="Text" disabled="true">
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
					<TD>
   							<TABLE align="center" border="0" width="90%">
   								<TR>
								    <TD height="20" width="1%">
   									</TD>
									<TD width="12%">	用户姓名：
   									</TD>
   									<TD width="35%">
									<INPUT class="box" name="user.UName" size="20" maxLength="20" value="" >
   									</TD>
								</TR>
								   <TR>	
								   <TD height="20" width="1%">
   									</TD>
									<TD width="12%">	EMAIL地址：
   									</TD>
   									<TD width="50%">
									<INPUT class="box" id="uEmail" name="user.UEmail" size="20" maxLength="20" value="" >&nbsp;&nbsp;如：susan@isoftstone.com
   									</TD>
									<TD colspan="2">
   									</TD>
   								</TR>
								<TR>
								    <TD height="20">
   									</TD>
									<TD>	性别：
   									</TD>
   									<TD>
				 						<input type="Radio" name="user.UGender" value="男">男&nbsp;&nbsp; 
				 						<input type="Radio" name="user.UGender" value="女">女
   									</TD>
									<TD colspan="2">
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
   						<TD>
   							<TABLE align="center" border="0" width="90%">
   								<TR>
   									<TD height="20" width="1%">
   									</TD>
									<TD width="12%">	用户类型：
   									</TD>
   									<TD width="50%">
									<input type="Radio"  name="userType.utName"  value="讲师">讲师&nbsp;&nbsp;
									<input type="Radio"  name="userType.utName"  value="班主任">班主任&nbsp;&nbsp;
									<input type="Radio"  name="userType.utName"  value="教务主任">教务主任&nbsp;&nbsp;
									<input type="Radio"  name="userType.utName"  value="一般用户">一般用户
   									</TD>
   				
									<TD colspan="2">
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
						<TD>
							<TABLE align="center" border="0" width="90%">
								<TR>
									<TD align="right">
										<input class=button type=button name="bsave" value=" 增 加 " onclick="create()">
										<input class=button type=button name="bsave" value=" 返 回 " onclick="javascript:history.back(-1)">
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
</table>
		<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr><td><br></td></tr>
			<TR>
				<TD class="pagefootTl"><IMG src="<%= basePath %>webep/space.gif" width="778" height="1"></TD>
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
function create()
{	
	for(i=0;i<form1.length;i++){
		if(form1.elements[i].value==""){
				alert("表单信息不能为空");
				return false;
		}
		if(!checkInput(form1.elements[i].value)){
			alert("为空或存在非法字符");
			return  ;
		}
	
	}
	if(!isemail(document.getElementById("uEmail").value))
	{
		alert("邮箱格式有误");
		return false;
	}
	if(confirm("确定增加新用户吗？"))
	{
		form1.action="systemsettingAction!addUser"
		form1.submit();
		
	}
	
}

function onChecked(cb) {
	
var hasC = document.getElementById("t"+cb);
	for (i = 1; i < 5; i ++) {
		document.getElementById("t" + i);
		if(document.getElementById("t" + i) != hasC)
		{
			if(document.getElementById("t" + i).checked == true)
			{
				alert("用户身份只能单选");
				document.getElementById("t"+cb).checked=false;
			}
		}
   }
   return hasC = document.getElementById("t"+cb).value
}

function next()
{	
	
	document.location.href='userSetting.htm'; 
}
</SCRIPT>