<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>iSoftStone培训中心考试平台</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="<%=basePath%>webep/css/style.css" type="text/css">
</HEAD>
<BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<SCRIPT language="JavaScript1.2" src="<%=basePath%>webep/js/coolmenus4.js"></SCRIPT>
<SCRIPT language="JavaScript1.2" src="<%=basePath%>webep/js/cm_addins.js"></SCRIPT>
<form action="" name="form1" method="post">
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
									<TD align="center" class="sys">  <A href="<%=basePath %>indexPageAction!exitSystem" class="syslink">退出登录</A>
											<A href="<%=basePath %>indexPageAction!toResetPwd" class="syslink">修改密码</A>	</TD>
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
						<TD class="FormTitle" height="2" width="100%"><B>用户维护</B>
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
									<input class=button type=text name="user.UAccount" value=" ${userN.UAccount }" onclick="reset()">
   									
   									</TD>
   									<TD>
										elf
										&nbsp;
									<input class=button type=button name="user.UPwd" value=" 重置密码 " onclick="reset()">
   									
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
									<INPUT class="box" name="user.UName" size="20" maxLength="20" value="${userN.UName }" >
   									</TD>
									<TD width="12%">	录入日期：
   									</TD>
   									<TD width="35%">
   									<INPUT class="box" name="user.UHiretime" size="20" maxLength="20" value="${userN.UHiretime }" >
									
   									</TD>
									<TD colspan="2">
   									</TD>
								</TR>
								   <TR>	
								   <TD height="20" width="1%">
   									</TD>
									<TD width="12%">	EMAIL地址：
   									</TD>
   									<TD width="50%">
									<INPUT class="box" id="uEmail" name="user.UEmail" size="20" maxLength="20" value="${userN.UEmail }" >&nbsp;&nbsp;如：susan@isoftstone.com
   									</TD>
									<TD colspan="2">
   									</TD>
   								</TR>
								<TR>
								    <TD height="20">
   									</TD>
									<TD>	性别：
   									</TD>
   									<c:if test="${userN.UGender=='男'}">
   									<TD>
				 <input type="Radio" name="user.UGender" checked value="男">男&nbsp;&nbsp; <input type="Radio" name="userN.UGender" value="女">女
									 </TD>
				 					</c:if>
				 					<c:if test="${userN.UGender=='女'}">
				 					<TD>
				 <input type="Radio" name="user.UGender" value="男">男&nbsp;&nbsp; <input type="Radio" name="userN.UGender" checked value="女">女
				 					</TD>
									</c:if>
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
   									<c:if test="${userN.tbUserType.utName=='讲师'}">
									<input type="Radio" name="userType.utName" checked value="讲师">讲师&nbsp;&nbsp;
									<input type="Radio" name="userType.utName" value="班主任">班主任&nbsp;&nbsp;
									<input type="radio" name="userType.utName" value="教务主任">教务主任&nbsp;&nbsp;
									<input type="radio" name="userType.utName" value="一般用户">一般用户
									</c:if>
									<c:if test="${userN.tbUserType.utName=='班主任'}">
									<input type="Radio" name="userType.utName" value="讲师">讲师&nbsp;&nbsp;
									<input type="Radio" name="userType.utName" checked value="班主任">班主任&nbsp;&nbsp;
									<input type="radio" name="userType.utName" value="教务主任">教务主任&nbsp;&nbsp;
									<input type="radio" name="userType.utName" value="一般用户">一般用户
									</c:if>
									<c:if test="${userN.tbUserType.utName=='教务主任'}">
									<input type="Radio" name="userType.utName" value="讲师">讲师&nbsp;&nbsp;
									<input type="Radio" name="userType.utName" value="班主任">班主任&nbsp;&nbsp;
									<input type="radio" name="userType.utName" checked value="教务主任">教务主任&nbsp;&nbsp;
									<input type="radio" name="userType.utName" value="一般用户">一般用户
									</c:if>
									
									<c:if test="${userN.tbUserType.utName=='一般用户'}">
									<input type="Radio" name="userType.utName" value="讲师">讲师&nbsp;&nbsp;
									<input type="Radio" name="userType.utName" value="班主任">班主任&nbsp;&nbsp;
									<input type="radio" name="userType.utName" value="教务主任">教务主任&nbsp;&nbsp;
									<input type="radio" name="userType.utName" checked value="一般用户">一般用户
									</c:if>
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
										<input class=button type=button name="bsave" value=" 更 新 " onclick="commit()">
										<input class=button type=button name="bsave" value=" 删 除 " onclick="toDelete()">
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
function commit()
{	
	if(!isemail(document.getElementById("uEmail").value))
	{
		alert("邮箱格式有误");
		return false;
	}
	if(confirm("确定更新用户吗？"))
	{
		form1.action="systemsettingAction!updateUser?u_id="+${userN.UId};
		form1.submit();
		 
	}
}
function toDelete()
{	
	if(confirm("确定删除用户吗？"))
	{
		form1.action="systemsettingAction!deleteUser?u_id="+${userN.UId};
		form1.submit();
	}
}
function next()
{	
	document.location.href='userSetting.htm'; 
}
function reset()
{
	if(confirm("确定重置吗？"))
	{
		alert("重置成功！"); 
		document.location.href='userSetting3.htm'; 
	}
}
</SCRIPT>