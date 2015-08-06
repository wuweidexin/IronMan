<%@ page contentType="text/html; charset=gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.chen.entity.*"%>
<jsp:useBean id="orderSer" scope="page"
	class="com.chen.serviceImp.OrderServiceImp" />
<%
	List<Order> list = new ArrayList<Order>();
	Customer customer = (Customer)session.getAttribute("customer");
	Set<Order> o = customer.getOrders();
	Iterator ita = o.iterator();
	while(ita.hasNext())
	{
		list.add((Order)ita.next());
	}
	double sum = 0;
 %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>电子商城</title>
	</head>
	<link href="css/css.css" rel="stylesheet" type="text/css">
	<body>
		<table width="755" height="150%" border="0" align="center"
			cellpadding="0" cellspacing="0">
			<tr>
				<td height="98">
					<div align="center">
						<jsp:include page="topOne.jsp" /></div>
				</td>
			</tr>
			<tr>
				<td height="43" align="center" valign="middle"
					background="image/daohang.jpg"><jsp:include page="topTwo.jsp" /></td>

			</tr>
			<tr>
				<td height="847" bgcolor="#FFFFFF" class="linkBlack">
					<table width="100%" height="100%" border="0" cellpadding="0"
						cellspacing="0">
						<tr>
							<td width="25%" height="638" rowspan="2" valign="top"
								background="image/zuocedaohangbeijing.jpg">

								<jsp:include page="left.jsp" />


							</td>
							<td width="75%" height="33" align="center" valign="middle"
								background="image/chakandingdan.jpg">
								&nbsp;
							</td>

						</tr>
						<tr>
							<td valign="top" height="613">
								<% if(list == null){ %>

								<div align="center">
									<br>
									<br>

									没有订货信息

								</div>

								<%}else{
									
									
									 %>
								<table width="99%" border="1" align="center" cellpadding="0"
									cellspacing="0" bordercolor="#FFFFFF"
									bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
									<%
											for(int i = 0; i < list.size(); i ++)
											{
												Order order = list.get(i);
											 %>
									<tr align="center">
										<td width="15%" height="21">
											编号
										</td>

										<td width="15%">
											电话
										</td>
										<td width="21%">
											地址
										</td>

										<td width="24%">
											订货时间
										</td>
										<td width="13%">
											出货状态
										</td>
										
									</tr>
									
									

									<tr align="center">
										
										<td>
											<%=order.getOrderID() %>
										</td>

										<td>
											<%=order.getRecieverOphone() %>

										</td>
										<td>
											<%=order.getRecieverName() %>

										</td>

										<td>
											<%=order.getOrderTime() %>

										</td>
										<%if(order.getOrderState()==1){ %>
										<td width="24%">
											已经出货
										</td>
										<%}else{ %>
										<td width="24%">
											没有出货
										</td>
										<%} %>
										

									</tr>

								</table>


								<div align="center">

									<br>
									<%
										if (list != null) {
									%>

									<br>
									订货明细查询
									<br>
									<br>

									<table width="89%" border="1" align="center" cellpadding="0"
										cellspacing="0" bordercolor="#FFFFFF"
										bordercolorlight="#FFFFFF" bordercolordark="#819BBC">

										<tr align="center">
											<td width="25%" height="21">
												编号
											</td>
											<td width="24%">
												商品名称
											</td>
											<td width="28%">
												商品价格
											</td>
											
										</tr>
										<%
											List<Book> book = new ArrayList<Book>();
		 									Iterator ita1 = order.getBook().iterator();
		 									
											while(ita1.hasNext())
											{
												Book b = (Book)ita1.next();
												
												sum =sum + b.getPrice();
			
										 %>
										<tr align="center">
											<td height="21">
												<%=b.getBookID()
												
												 %>
											</td>
											<td>
												<%=b.getBookName() %>
											</td>
											<td>
												<%=b.getPrice() %>元
											</td>
										</tr>
										
										<%
										  }
										  order.setTotalPrice(sum);
										  orderSer.updateOrder(order);
										  }
										%>
										---------------------------------
									<br>
										
												<%
											}
										%>
											
									
									
									</table>

									<table width="89%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td height="24">
												<div align="right">
													总金额：<%=sum %>元
													
												</div>
											</td>
										</tr>
									</table>
									<% }%>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr bgcolor="#FFFFFF">


				<td>
					&quot;
				</td>
			</tr>
		</table>
	</body>
</html>
