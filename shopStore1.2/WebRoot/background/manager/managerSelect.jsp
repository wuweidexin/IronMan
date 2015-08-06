<%@ page contentType="text/html; charset=gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.chen.entity.*"%>
	
<jsp:useBean id="managerServiceImp" scope="page"
	class="com.chen.serviceImp.ManagerServiceImp" />
	

<html>
<%if(managerServiceImp.findWithPage(0,2,"from Manager")!=null)
{
List list = managerServiceImp.findWithPage(0,2,"from Manager");
%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>电子商城的后台</title>
	</head>
	<link href="css/css.css" rel="stylesheet" type="text/css">
	<body>
		<table width="755" height="100%" border="0" align="center"
			cellpadding="0" cellspacing="0">

			<tr valign="bottom">
				<td height="108" colspan="2" background="image/banner1.jpg">
					<div align="center">
						<jsp:include page="../upTwo.jsp" />
					</div>
				</td>
			</tr>
			<tr>
				<td width="24%" height="318"><jsp:include
						page="../../leftManager.jsp" />
				</td>
				<td width="76%" bgcolor="#FFFFFF" class="linkBlack">
					<div align="center">
						<table width="99%" height="16" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<td bgcolor="#E6E6E6">
									<div align="center">
										<font color="#990000"><b>管理员信息的查询</b> </font>
									</div>
								</td>
							</tr>
						</table>
						<br>
						<br>

						<table width="90%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="20%" height="20" colspan="4">
									<div align="right">
										<a href="managerAction!loadManagerSet?action=1">修改您的密码</a>&nbsp;&nbsp;&nbsp;
									</div>
								</td>
								<tr> 
						</table>
						<table width="90%" border="1" cellspacing="0" cellpadding="0">

							<tr>
								<td width="20%" height="25">
									<div align="center">
										数据编号
									</div>
								</td>
								<td width="20%">
									<div align="center">
										管理员账号
									</div>
								</td>
								<td width="20%">
									<div align="center">
										管理员姓名
									</div>
								</td>

								<td width="44%">
									<div align="center">
										操作
									</div>
								</td>
							</tr>
							<% for(int i = 0; i < list.size(); i ++)
								{   
									Manager manager = (Manager)list.get(i);
									if(manager.getManagerID() != null){
							 %>
								<tr>
									<td height="30">
										<div align="center">
											<%=manager.getId()%>
										</div>
									</td>
									<td>
										<div align="center">
											<%=manager.getManagerID()%>
										</div>
									</td>
									<td>
										<div align="center">
											<%=manager.getManagerName()%>
										</div>
									</td>
									<td>
										<div align="center">

											<a href="managerAction!loadManagerSet?action=2&id=<%=manager.getId()%>">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;

											<a href="managerAction!loadManagerSet?action=4&id=<%=manager.getId()%>">删除</a>

										</div>
									</td>
								</tr>
							<%}} %>
						</table>
						<br>
						<table width="90%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr align="center">
								
								<td width="20%">
									<div align="right">
										<a href="managerAction!loadManagerSet?action=3">添加管理员</a>&nbsp;&nbsp;&nbsp;&nbsp;
									</div>
								</td>

							</tr>
						</table>

					</div>
				</td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="60" colspan="2">
					<p align="center"><jsp:include page="../downNews.jsp" />

					</p>
				</td>
			</tr>
		</table>
	</body>
	<%} %>
</html>
