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
		<title>�����̳ǵĺ�̨</title>
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
										������Ϊ��${detailOrder.orderID }����ϸ��Ϣ
									</div>
								</td>
							</tr>
						</table>
						<br>

						<table width="76%" border="1" cellspacing="0" cellpadding="0">
							<tr align="center">
								<td width="26%" height="25">
									��Ա�˺�
								</td>
								<td width="22%">${customer.cusID}</td>
								<td width="26%">
									��Ա����
								</td>
								<td width="22%">${customer.cusName }</td>
							</tr>
							<tr align="center">
								<td height="25">
									�ͻ��绰
								</td>
								<td>${detailOrder.recieverOphone }</td>
								<td>
									�ͻ���ַ
								</td>
								<td>${detailOrder.recieverAddress }</td>
							</tr>
							<tr align="center">
								<td height="25">
									���ʽ
								</td>
								<td>${detailOrder.moneySendMethod }</td>
								<td>
									���ͷ�ʽ
								</td>
								<td>${detailOrder.deliveryMethod}</td>
							</tr>
							<tr align="center">
								<td height="25">
									��ע��Ϣ
								</td>
								<td>
									����ʱ��
								</td>
								<td>${detailOrder.orderTime}</td>
							</tr>
						</table>
						<br>
						<strong>��Ʒ��ϸ��Ϣ</strong>
						<br>
						<br>
						<table width="74%" border="1" cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<div align="center">
										��Ʒ����
									</div>
								</td>
								
								<td>
									<div align="center">
										��Ʒ�۸�
									</div>
								</td>
							</tr>
							<c:forEach items="${listDetail}" var="li">
							<tr>
								<td>
									<div align="center">${li.bookName }</div>
								</td>
								<td>
									<div align="center">${li.price }Ԫ
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
																		
										û�г���
										
									</div>
								</c:if>
								<c:if test="${detailOrder.orderState==1}">
									<div align="left">
										
										�Ѿ�����
																			
									</div>
								</c:if>
								</td>
								
								<td width="28%" class="linkBlack">
									<div align="right">
										<a href="javascript:history.go(-1)">����</a>
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
