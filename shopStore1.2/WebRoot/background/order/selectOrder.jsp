<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.chen.entity.*" %>
<jsp:useBean id="orderSer" scope="page" class="com.chen.serviceImp.OrderServiceImp"/>
<%
	List<Order> list = orderSer.findList("from Order");

 %>


<script Language="JavaScript">
	function deleteOrder(date) {
		if (confirm("确定要删除吗？")) {
			window.location = "orderAction.do?action=2&number=" + date;
		}
	}
</script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>电子商城的后台</title>
		<style type="text/css">
<!--
.style1 {
	color: #990000;
	font-weight: bold;
}
-->
</style>
	</head>
	<link href="css/css.css" rel="stylesheet" type="text/css">
	<body>
		<table width="755" height="100%" border="0" align="center"
			cellpadding="0" cellspacing="0" bordercolor="#FFFFFF"
			bordercolordark="#000000" bordercolorlight="#FFFFFF">
			<tr valign="bottom">
				<td colspan="2" background="image/banner1.jpg" height="108">
					<div align="center">
						<jsp:include page="../upTwo.jsp" />
					</div>
				</td>
			</tr>
			<tr>
				<td width="24%" height="332"><jsp:include
						page="../../leftManager.jsp" />
				</td>
				<td width="76%" bgcolor="#FFFFFF">
					<div align="center">
						<table width="99%" height="16" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<td bgcolor="#E6E6E6">
									<div align="center" class="style1">
										订单的查询
									</div>
								</td>
							</tr>
						</table>
						<br>
						<br>
						<table width="96%" border="1" cellspacing="0" cellpadding="0">

							<tr>
								<td width="15%" height="25">
									<div align="center">
										编号
									</div>
								</td>
								<td width="14%">
									<div align="center">
										真实姓名
									</div>
								</td>
								<td width="16%">
									<div align="center">
										出货状态
									</div>
								</td>
								
								<td width="16%">
									<div align="center">
										修改出货状态
									</div>
								</td>
								<td width="26%">
									<div align="center">
										订货时间
									</div>
								</td>
								<td width="29%">
									<div align="center">
										操作
									</div>
								</td>
							</tr>
							<%
								for(int i=0; i<list.size(); i++)
								{
									Order order = list.get(i);
									Customer customer = order.getCustomer();							
							 %>
							<tr align="center">
								<td height="25">
									<%=order.getOrderID()%>
								</td>
								<td>
									<%=customer.getCusName()%>
								</td>
								<td>								
								<% if(order.getOrderState() == 1){
									%>
									已经出货
									<%}else { %>
									
									还没有出货 &nbsp;&nbsp;
									<%} %>
								</td>
								<td class="linkBlack">
								
									<a href="orderAction!loadOrderSet?action=0&id=<%=order.getId() %>">是</a>
								</td>
								<td>
									<%=order.getOrderTime()%>
								</td>
								
								<td width="29%">
									<a href="orderAction!loadOrderSet?action=2&id=<%=order.getId() %>">详细信息</a> &nbsp;&nbsp; 
									
									
									<a href="orderAction!loadOrderSet?action=3&id=<%=order.getId() %>">删除</a>

								</td>
							</tr>
							<%} %>
						</table>
						<br>

					</div>
				</td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="50" colspan="2">
					<p align="center"><jsp:include page="../downNews.jsp" />
				</td>
			</tr>
		</table>
	</body>
</html>
