<%@ page contentType="text/html; charset=gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.chen.serviceImp.*"%>
<%@ page import="com.chen.entity.*"%>
<jsp:useBean id="shoppingCartService" scope="page"
	class="com.chen.serviceImp.ShoppingCartServiceImp" />
<jsp:useBean id="bookService" scope="page"
	class="com.chen.serviceImp.BookServiceImp" />

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
				<td height="847">
					<table width="100%" height="100%" border="0" cellpadding="0"
						cellspacing="0">
						<tr>
							<td width="25%" height="638" rowspan="2" valign="top"
								background="image/zuocedaohangbeijing.jpg">

								<jsp:include page="left.jsp" />


							</td>
							<td width="75%" height="31" align="center" valign="middle"
								background="image/gouwuche.jpg">
								&nbsp;
							</td>

						</tr>
						<tr>
							<td height="613" valign="top" bgcolor="#FFFFFF">

							
								<c:choose>
									<c:when test="${!empty li}">

										<form method="post" action="cart_modify.jsp" name="form">
											<table width="96%" border="1" align="center" cellpadding="0"
												cellspacing="0" bordercolor="#FFFFFF"
												bordercolordark="#819BBC" bordercolorlight="#FFFFFF">
												<tr>
													<td width="16%" height="28">
														<div align="center">
															序号
														</div>
													</td>
													<td width="23%">
														<div align="center">
															商品的名称
														</div>
													</td>
													<td width="22%">
														<div align="center">
															商品价格
														</div>
													</td>
													<td width="22%">
														<div align="center">
															操作
														</div>
													</td>

												</tr>

												<c:forEach items="${li}" var="li">

													<tr>
														<td height="28">
															<div align="center">${li.bookID}</div>
														</td>
														<td>
															<div align="center">
																${li.bookName}
															</div>
														</td>
														<td>
															<div align="center">
																${li.price}
															</div>
														</td>
														<td>
															<div align="center">
																<a href="cartAction!checkOut">删除</a>
															</div>
														</td>
														


													</tr>
												</c:forEach>

											</table>

										</form>
										<table width="100%" height="52" border="0" align="center"
											cellpadding="0" cellspacing="0">
											<tr align="center" valign="middle">
												<td height="10">
													&nbsp;
												</td>
												<td width="24%" height="10" colspan="-3" align="left">
													&nbsp;
												</td>
											</tr>
											<tr align="center" valign="middle">
												<td height="21" class="tableBorder_B1">
													&nbsp;
												</td>
												<td height="21" colspan="-3" align="left">
													合计总金额：${sum }
												</td>
											</tr>
											<tr align="center" valign="middle">
												<td height="21" colspan="2" class="linkBlack">
													<a href="cartAction!backIndex">继续购物</a> |
													<a href="cartAction!checkOut">去收银台结账</a> |
													<a href="cartAction!clearShoppingCart">清空购物车</a>

												</td>
											</tr>
										</table>

									</c:when>
									<c:otherwise>
									
									<div align="center">
											<br>

											您还没有购物！！！


										</div>
									
									<table width="100%" height="52" border="0" align="center"
											cellpadding="0" cellspacing="0">
											<tr align="center" valign="middle">
												<td height="10">
													&nbsp;
												</td>
												<td width="24%" height="10" colspan="-3" align="left">
													&nbsp;
												</td>
											</tr>
											<tr align="center" valign="middle">
												<td height="21" class="tableBorder_B1">
													&nbsp;
												</td>
												<td height="21" colspan="-3" align="left">
													合计总金额：${sum }
												</td>
											</tr>
											<tr align="center" valign="middle">
												<td height="21" colspan="2" class="linkBlack">
													<a href="cartAction!backIndex">继续购物</a> |
												</td>
											</tr>
										</table>

										
									</c:otherwise>
								</c:choose>

							</td>
						</tr>
					</table>
				</td>
			</tr>

		</table>
	</body>
</html>
