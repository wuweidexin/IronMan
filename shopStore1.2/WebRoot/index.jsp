<%@ page contentType="text/html; charset=gb2312"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>电子商城</title>
	</head>

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
							<td width="193" height="638" rowspan="4" valign="top"
								background="image/zuocedaohangbeijing.jpg"><jsp:include
									page="left.jsp" /></td>

							<td height="89" valign="top" background="image/guanggaotiao.jpg">
								&nbsp;





							</td>
						</tr>
						<tr>
							<td height="524" valign="top" bgcolor="#FFFFFF">
							<jsp:include
									page="right.jsp" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="100">
					<p align="center"><jsp:include page="downNews.jsp" />
				</td>
			</tr>
		</table>
	</body>
</html>
