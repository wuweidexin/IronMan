<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.chen.entity.*"%>
<jsp:useBean id="cusServiceImp" scope="page"
	class="com.chen.serviceImp.CustomerServiceImp" />

<%
	List<Customer> list = cusServiceImp.findWithPage(0, 5,
			"from Customer");
%>

<style type="text/css">
<!--
.style1 {
	color: #990000;
	font-weight: bold;
}
-->
</style>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>电子商城的后台</title>
	</head>
	<link href="css/css.css" rel="stylesheet" type="text/css">
	<body>
		<table width="755" height="100%" align="center" cellpadding="0"
			cellspacing="0">
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
				<td width="76%" bgcolor="#FFFFFF">
					<div align="center">
						<table width="99%" height="16" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<td bgcolor="#E6E6E6">
									<div align="center" class="style1">
										会员信息查询
									</div>
								</td>
							</tr>
						</table>
						<br>
						<br>
						<table width="71%" border="1" cellspacing="0" cellpadding="0">

							<tr>
								<td width="14%" height="25">
									<div align="center">
										编号
									</div>
								</td>
								<td width="14%">
									<div align="center">
										会员账号
									</div>
								</td>
								<td width="14%">
									<div align="center">
										会员姓名
									</div>
								</td>
								<td width="14%">
									<div align="center">
										会员邮箱
									</div>
								</td>

								<td width="38%">
									<div align="center">
										操作
									</div>
								</td>
							</tr>
							<%
								for (int i = 0; i < list.size(); i++) {
									Customer cus = list.get(i);
							%>
							<tr>
								<td height="30">
									<div align="center"><%=cus.getId()%></div>
								</td>
								<td>
									<div align="center"><%=cus.getCusID()%></div>
								</td>
								<td>
									<div align="center"><%=cus.getCusName()%></div>
								</td>
								<td>
									<div align="center"><%=cus.getCusMail()%>
									</div>
								</td>
								<td class="linkBlack">
									<div align="center">

										<a href="memberAction!loadMemberSet?action=1&id=<%=cus.getId()%>">详细信息</a>&nbsp;&nbsp;&nbsp;&nbsp;

										<a href="memberAction!loadMemberSet?action=2&id=<%=cus.getId()%>">删除</a>

									</div>
								</td>
							</tr>
							<%
								}
							%>
						</table>
						<br>

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
</html>
