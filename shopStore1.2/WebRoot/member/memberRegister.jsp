<%@ page contentType="text/html; charset=gb2312"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>��Աע��</title>
	</head>
	<script language="javascript">
	function checkEmpty(form)
	{
		for(i=0;i<form.length;i++)
		{
			if(form.elements[i].value=="")
			{
				alert("����Ϣ����Ϊ��");
				return false;
			}
		}
	}
	</script>
	
	<body>
		<p>
			&nbsp;
		</p>
		<div align="center">
			<p>
				<strong>��Աע�� </strong>
			</p>
			<form name="form" method="post"
				action="<%=basePath%>memberAction!memberRegister"
				onSubmit="return checkEmpty(form)">
				<table width="298" border="1" cellspacing="0" cellpadding="0"
					bordercolor="#FFFFFF" bordercolordark="#819BBC"
					bordercolorlight="#FFFFFF">
					<tr>
						<td width="105" height="35" bgcolor="#EFF6FE">
							<div align="center">
								��Ա����
							</div>
						</td>
						<td width="187">
							<div align="center">
								<input type="text" name="customer.cusName">
							</div>
						</td>
					</tr>
					<tr>
						<td height="35" bgcolor="#EFF6FE">
							<div align="center">
								��Ա����
							</div>
						</td>
						<td>
							<div align="center">
								<input type="password" name="customer.cusPassword">
							</div>
						</td>
					</tr>
					<tr>
						<td height="35" bgcolor="#EFF6FE">
							<div align="center">
								�绰
							</div>
						</td>
						<td>
							<div align="center">
								<input type="text" name="customer.cusTelephone">
							</div>
						</td>
					</tr>
					<tr>
						<td height="35" bgcolor="#EFF6FE">
							<div align="center">
								��ַ
							</div>
						</td>
						<td>
							<div align="center">
								<input type="text" name="customer.cusAddress">
							</div>
						</td>
					</tr>
					<tr>
						<td height="35" bgcolor="#EFF6FE">
							<div align="center">
								Email��ַ
							</div>
						</td>
						<td>
							<div align="center">
								<input name="customer.cusMail" type="text">
							</div>
						</td>
					</tr>
					<tr>
						<td height="35" bgcolor="#EFF6FE">
							<div align="center">
								�ʱ�
							</div>
						</td>
						<td>
							<div align="center">
								<input type="text" name="customer.cusPostCode">
							</div>
						</td>
					</tr>
					
					
					<tr>
						<td height="35" bgcolor="#EFF6FE">
							<div align="center">
								�һ���������
							</div>
						</td>
						<td>
							<div align="center">
								<input type="text" name="customer.question">
							</div>
						</td>
					</tr>
					<tr>
						<td height="35" bgcolor="#EFF6FE">
							<div align="center">
								��
							</div>
						</td>
						<td>
							<div align="center">
								<input type="text" name="customer.answer">
							</div>
						</td>
					</tr>
				</table>
				<br>
				<br>
				<br>
				<input type="submit" name="Submit2" value="�ύ">
				&nbsp;&nbsp;
				<input type="reset" name="Submit3" value="����">
				&nbsp;&nbsp;
				<input type="button" name="back" value="����"
					onClick="javascript:history.go(-1)">
			</form>
		</div>
	</body>
</html>
