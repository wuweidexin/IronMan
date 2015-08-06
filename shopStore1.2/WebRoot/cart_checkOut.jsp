<%@ page contentType="text/html; charset=gb2312"%>
<%@ page import="java.util.*"%>
<%@ page import="com.chen.ation.*"%>
<%
	java.util.Date date = new java.util.Date();
%>


<html>
	<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
return false;
}
}

}


</script>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>电子商城</title>

		<style type="text/css">
<!--
.style1 {
	color: #FF0000;
	font-weight: bold;
}
-->
</style>
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
						cellspacing="0" bgcolor="#FFFFFF">
						<tr>
							<td width="25%" height="638" rowspan="2" valign="top"
								background="image/zuocedaohangbeijing.jpg">

								<jsp:include page="left.jsp" />


							</td>
							<td width="75%" height="33" align="center" valign="middle"
								background="image/jiezhao.jpg">
								&nbsp;
							</td>

						</tr>
						<tr>
							<td valign="top" height="613">
								<div align="center">
									<br>
									<form name="form" method="post" action="orderAction!addOrder?id=${newOrder.id}"
										onSubmit="return checkEmpty(form)">
										<table width="68%" border="1" cellspacing="0" cellpadding="0"
											bordercolor="#FFFFFF" bordercolordark="#819BBC"
											bordercolorlight="#FFFFFF">
											<tr>
												<td height="30" colspan="2">
													<div align="center" class="style1">
														注意：请您不要恶意或非法提交订单以免造成不必要的麻烦！
													</div>
												</td>
											</tr>
											<tr>
												<td height="30">
													<div align="center">
														订单编号
													</div>
												</td>
												<td>
													&nbsp;
													<input type="text" name="number" value="${newOrder.orderID }" disabled="disabled">
													
												</td>
											</tr>
											<tr>
												<td width="24%" height="30">
													<div align="center">
														会员名称
													</div>
												</td>
												<td width="76%">
													${customer.cusName }
													<input type="hidden" name="name" value="${customer.cusName}">
												</td>
											</tr>
											<tr>
												<td height="30">
													<div align="center">
														收件人姓名
													</div>
												</td>
												<td>
													<input type="text" name="recieverName" >
												</td>
											</tr>
											<tr>
												<td height="30">
													<div align="center">
														联系地址
													</div>
												</td>
												<td>
													&nbsp;
													<input type="text" name="recieverAddress">
												</td>
											</tr>
											<tr>
												<td height="30">
													<div align="center">
														联系电话
													</div>
												</td>
												<td>
													&nbsp;
													<input type="text" name="recieverOphone">
												</td>
											</tr>
											<tr>
												<td height="30">
													<div align="center">
														付款方式
													</div>
												</td>
												<td>
													&nbsp;
													<select name="moneySendMethod" class="textarea">
														<option value="">
															请选择
														</option>
														<option value="BankPay">
															银行付款
														</option>
														<option value="PostalPay">
															邮政付款
														</option>
														<option value="CashPay">
															现金支付
														</option>
													</select>
												</td>
											</tr>

											<tr>
												<td height="30">
													<div align="center">
														运送方式
													</div>
												</td>
												<td>
													&nbsp;
													<select name="deliveryMethod" class="textarea">
														<option value="">
															请选择
														</option>
														<option value="Ordinary">
															普通邮寄
														</option>
														<option value="Express">
															特快专递
														</option>
														<option value="EMS">
															EMS专递方式
														</option>
													</select>

												</td>
											</tr>
										</table>
										<br>

										<input type="submit" name="Submit2" value="提交">
										&nbsp;
										<input type="reset" name="reset" value="清除">
										&nbsp;
										<input type="button" name="back" value="返回"
											onClick="javasrcipt:history.go(-1)">
									</form>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="100">
					<p align="center"><jsp:include page="downNews.jsp" /></p>
				</td>
			</tr>
		</table>
	</body>
</html>
