<%@ page contentType="text/html; charset=gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.chen.entity.*"%>
<jsp:useBean id="bookService" scope="page"
	class="com.chen.serviceImp.BookServiceImp" />

<%if(bookService.findWithPage(0,10,"from Book")!=null)
{
List list = bookService.findWithPage(0,10,"from Book");
%>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<table width="100%" height="590" border="0" align="center"
	cellpadding="0" cellspacing="0">
	<tr>
		<td height="44" align="center" valign="middle"
			background="image/xinpinshangjia.jpg">
			<div align="left">
				<table width="95%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td height="22">
							&nbsp;

						</td>
						<td>
							<div align="right" class="linkBlack">
								<a href="more.jsp"><b>更多</b> </a>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</td>
	</tr>

	<tr>
		<td height="529">
			<table width="100%" height="179" border="0" align="center"
				cellpadding="0" cellspacing="0">
				<tr>
					<td height="179">
						<table width="99%" height="163" border="2" align="center"
							cellpadding="0" cellspacing="0" bordercolor="#CCCCCC">
							<tr>
								<td height="179" bordercolor="#666666">

									<table width="96%" height="120" border="1" align="center"
										cellpadding="0" cellspacing="0" bordercolor="#EFEFEF">
										<%for(int i = 0; i < list.size(); i ++)
											{
												Book book = new Book();
												book = (Book)list.get(i);
											 %>
										<tr>
											<td width="36%" rowspan="5" height="160">
												<div align="center">
													<input name="pricture1" type="image"
														src="goodsPicture/i.jpg" width="110" height="100" />
												</div>
											</td>
											<td width="64%" height="30">
												<div align="center">
													图书名称:<%=book.getBookName() %>
												</div>
											</td>
										</tr>
										<tr>
											<td height="30">
												<div align="center">
													<font color="#F14D83">单价：<%=book.getPrice() %> 元</font>
												</div>
											</td>
										</tr>
										<tr>
											<td height="30">
												<div align="center">
													<font color="#F14D83">作者：<%=book.getAuthor() %></font>
												</div>
											</td>
										</tr>
										<tr>
											<td height="30">
												<div align="center">
													<font color="#F14D83">版次：<%=book.getVersion() %></font>
												</div>
											</td>
										</tr>

										<tr>
											<td height="30">
												<div align="center">
													<font color="#F14D83">库存：<%=book.getCount() %></font>
												</div>
											</td>
										</tr>
										<c:choose>
											<c:when test="${empty customer.cusName}">
												<td height="30">
													<div align="center">
														<a href="connection.jsp"><b>加入购物车</b> </a>
													</div>

												</td>
											</c:when>
											<c:otherwise>
												<tr>
													<td height="30">
														<div align="center">
															<a
																href="bookAction!addInCart?c_Id=${customer.id}&b_Id=<%=book.getId()%>"><b>加入购物车</b>
															</a>
														</div>

													</td>
												</tr>
											</c:otherwise>
										</c:choose>
										<%} %>

									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>

</table>
<%}else{ %>
<tr>
	<td height="30">
		<div align="center">
			没有找到你要找到内容！！！
		</div>

	</td>
</tr>
<%} %>
