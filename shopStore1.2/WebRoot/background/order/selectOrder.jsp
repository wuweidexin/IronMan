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
		if (confirm("ȷ��Ҫɾ����")) {
			window.location = "orderAction.do?action=2&number=" + date;
		}
	}
</script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>�����̳ǵĺ�̨</title>
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
										�����Ĳ�ѯ
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
										���
									</div>
								</td>
								<td width="14%">
									<div align="center">
										��ʵ����
									</div>
								</td>
								<td width="16%">
									<div align="center">
										����״̬
									</div>
								</td>
								
								<td width="16%">
									<div align="center">
										�޸ĳ���״̬
									</div>
								</td>
								<td width="26%">
									<div align="center">
										����ʱ��
									</div>
								</td>
								<td width="29%">
									<div align="center">
										����
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
									�Ѿ�����
									<%}else { %>
									
									��û�г��� &nbsp;&nbsp;
									<%} %>
								</td>
								<td class="linkBlack">
								
									<a href="orderAction!loadOrderSet?action=0&id=<%=order.getId() %>">��</a>
								</td>
								<td>
									<%=order.getOrderTime()%>
								</td>
								
								<td width="29%">
									<a href="orderAction!loadOrderSet?action=2&id=<%=order.getId() %>">��ϸ��Ϣ</a> &nbsp;&nbsp; 
									
									
									<a href="orderAction!loadOrderSet?action=3&id=<%=order.getId() %>">ɾ��</a>

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
