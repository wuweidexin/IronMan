<%@ page contentType="text/html; charset=gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.chen.entity.*"%>


<jsp:useBean id="orderSer" scope="page"
	class="com.chen.serviceImp.OrderServiceImp" />
<jsp:useBean id="book" scope="page"
	class="com.chen.serviceImp.BookServiceImp" />


<html>
	<head>
		<style type="text/css">
<!--
.style1 {
	color: #990000;
	font-weight: bold;
}
-->
</style>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>电子商城的后台</title>
	</head>
	<link href="css/css.css" rel="stylesheet" type="text/css">
	<body>
		<table width="755" height="100%" border="0" align="center"
			cellpadding="0" cellspacing="0">
			<tr valign="bottom">
				<td height="108" colspan="2" background="image/banner1.jpg">
					<div align="center"><jsp:include page="../upOne.jsp" />
					</div>
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
										订单号为：${detailOrder.orderID }的详细信息
									</div>
								</td>
							</tr>
						</table>
						<br>

						<table width="76%" border="1" cellspacing="0" cellpadding="0">
							<tr align="center">
								<td width="26%" height="25">
									会员账号
								</td>
								<td width="22%">${customer.cusID}</td>
								<td width="26%">
									会员姓名
								</td>
								<td width="22%">${customer.cusName }</td>
							</tr>
							<tr align="center">
								<td height="25">
									送货电话
								</td>
								<td>${detailOrder.recieverOphone }</td>
								<td>
									送货地址
								</td>
								<td>${detailOrder.recieverAddress }</td>
							</tr>
							<tr align="center">
								<td height="25">
									付款方式
								</td>
								<td>${detailOrder.moneySendMethod }</td>
								<td>
									运送方式
								</td>
								<td>${detailOrder.deliveryMethod}</td>
							</tr>
							<tr align="center">
								<td height="25">
									备注信息
								</td>
								<td>
									订货时间
								</td>
								<td>${detailOrder.orderTime}</td>
							</tr>
						</table>
						<br>
						<strong>商品详细信息</strong>
						<br>
						<br>
						<table width="74%" border="1" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<div align="center">
										商品名称
									</div>
								</td>
								
								<td>
									<div align="center">
										商品价格
									</div>
								</td>
							</tr>
							<c:forEach items="${listDetail}" var="li">
							<tr>
								<td>
									<div align="center">${li.bookName }</div>
								</td>
								<td>
									<div align="center">${li.price }元
									</div>
								</td>
							</tr>
							</c:forEach>
						</table>
						<br>
						<br>
					
						<table width="76%" height="19" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="72%">
								<c:if test="${detailOrder.orderState==0}">
									<div align="left">
																		
										没有出货
										
									</div>
								</c:if>
								<c:if test="${detailOrder.orderState==1}">
									<div align="left">
										
										已经出货
																			
									</div>
								</c:if>
								</td>
								
								<td width="28%" class="linkBlack">
									<div align="right">
										<a href="javascript:history.go(-1)">返回</a>
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
</html>
