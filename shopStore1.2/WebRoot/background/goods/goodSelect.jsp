<%@ page contentType="text/html; charset=gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.chen.entity.*"%>
<jsp:useBean id="bookServiceImp" scope="page"
	class="com.chen.serviceImp.BookServiceImp" />

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>�����̳ǵĺ�̨</title>
		<script language="JavaScript" type="text/JavaScript">

</script>
		<style type="text/css">
<!--
.style1 {
	color: #990000;
	font-weight: bold;
}
-->
</style>

	</head>

	<body>
		<tr>

			<table width="775" height="90%" border="0" align="center"
				cellpadding="0" cellspacing="0">

				</tr>

				<tr valign="bottom">
					<td colspan="2" background="image/banner1.jpg" height="108">
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
										<div align="center">
											<font color="#990000"><b>��Ʒ��Ϣ��ѯ</b> </font>
										</div>
									</td>
								</tr>
							</table>
							<br>
							<br>

							<table width="90%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td>
										<a href="bookAction!loadBookSet?action=3">��ѧͼ���ѯ</a>
									</td>
									<td>
										<a href="bookAction!loadBookSet?action=4">����ͼ���ѯ</a>
									</td>
									<td>
										<a href="bookAction!loadBookSet?action=5">�Ƽ�ͼ���ѯ</a>
									</td>
									<td>
										<a href="bookAction!loadBookSet?action=6">����ͼ���ѯ</a>
									</td>
									<td>
										<a href="javascript:history.go(-1)">����</a>
									</td>
								</tr>
							</table>
							<br>

							<table width="90%" border="1" cellspacing="0" cellpadding="0">

								<tr>
									<td width="14%" height="25">
										<div align="center">
											ͼ����
										</div>
									</td>
									<td width="15%">
										<div align="center">
											ͼ������
										</div>
									</td>
									<td width="14%">
										<div align="center">
											����
										</div>
									</td>
									<td width="14%">
										<div align="center">
											������
										</div>
									</td>
									<td width="14%">
										<div align="center">
											���
										</div>
									</td>
									<td width="14%">
										<div align="center">
											���
										</div>
									</td>
									<td width="14%">
										<div align="center">
											�۸�
										</div>
									</td>
									<td width="25%">
										<div align="center">
											����
										</div>
									</td>
								</tr>
								<c:forEach items="${list}" var="li">
									<tr>
										<td height="25">
											<div align="center">
												${li.bookID}
											</div>
										</td>

										<td height="25">
											<div align="center">
												${li.bookName}
											</div>
										</td>

										<td height="25">
											<div align="center">
												${li.author }
											</div>
										</td>

										<td height="25">
											<div align="center">
												${li.press }
											</div>
										</td>

										<td height="25">
											<div align="center">
												${li.version }
											</div>
										</td>

										<td height="25">
											<div align="center">
												${li.count }
											</div>
										</td>
										<td height="25">
											<div align="center">
												${li.price }
											</div>
										</td>
										<td height="25">
											<div align="center">
												<a href="bookAction!loadBookSet?action=1&id=${li.id }">�޸���Ϣ</a>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;

												<a href="bookAction!loadBookSet?action=2&id=${li.id }">ɾ��</a>

											</div>
										</td>
								</c:forEach>
							</table>
							<br>
							<table width="90%" border="0" cellspacing="0" cellpadding="0">
								<td width="20%" class="linkBlack">
									<div align="right">
										<a href="bookAction!loadBookSet?action=7">�����Ʒ</a>&nbsp;
									</div>
								</td>
							</table>
				</tr>
			</table>


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
