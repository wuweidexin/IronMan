<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>



<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>�����̳ǵĺ�̨</title>
	</head>
	<link href="css/css.css" rel="stylesheet" type="text/css">
	<body>
		<table width="755" height="100%" border="0" align="center"
			cellpadding="0" cellspacing="0">
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
				<td width="76%" height="318" bgcolor="#FFFFFF" class="linkBlack">

					<table width="99%" height="16" border="0" cellpadding="0"
						cellspacing="0">
						<tr>
							<td bgcolor="#E6E6E6">
								<div align="center">
									<font color="#990000"><b>�鿴��Ա����ϸ���</b> </font>
								</div>
							</td>
						</tr>
					</table>
					<br>
					<br>

					<br>
					<br>
					<table width="71%" height="130" border="1" align="center"
						cellpadding="0" cellspacing="0">
						<tr>
							<td width="20%" height="26">
								<div align="center">
									���ݱ��
								</div>
							</td>
							<td width="31%">
								<div align="center">
									${customer.id }
								</div>
							</td>
							<td width="20%">
								<div align="center">
									��Ա�˺�
								</div>
							</td>
							<td width="31%">
								<div align="center">
									${customer.cusID }
								</div>
							</td>
						</tr>
						<tr>
							<td height="25">
								<div align="center">
									��Ա����
								</div>
							</td>
							<td>
								<div align="center">
									${customer.cusName }
								</div>
							</td>
							<td>
								<div align="center">
									��Ա�绰
								</div>
							</td>
							<td>
								<div align="center">
									${customer.cusTelephone }
								</div>
							</td>
						</tr>
						<tr>
							<td height="27">
								<div align="center">
									��Ա��ַ
								</div>
							</td>
							<td>
								<div align="center">
									${customer.cusAddress}
								</div>
							</td>
							<td>
								<div align="center">
									�����ʼ�
								</div>
							</td>
							<td>
								<div align="center">
									${customer.cusMail}
								</div>
							</td>
						</tr>

						<tr>
							<td height="27">
								<div align="center">
									��&nbsp;&nbsp;&nbsp;&nbsp;��
								</div>
							</td>
							<td>
								<div align="center">
									${customer.question}
								</div>
							</td>
							<td>
								<div align="center">
									��&nbsp;&nbsp;&nbsp;&nbsp;��
								</div>
							</td>
							<td>
								<div align="center">
									${customer.answer}
								</div>
							</td>
						</tr>
					</table>
					<table width="71%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td width="87%" height="29">
								&nbsp;
							</td>
							<td width="13%">
								<a href="javascript:history.back();">����</a>
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
