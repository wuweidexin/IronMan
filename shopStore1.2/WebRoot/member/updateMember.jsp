<%@ page contentType="text/html; charset=gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>��Ա�޸�����</title>
	</head>
	<link href="css/css1.css" rel="stylesheet" type="text/css">
	<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("����Ϣ����Ϊ��");
return false;
}
}
if(document.form.oldPassword.value!=document.form.passwordOld.value){
window.alert("�������������ԭ���Ĳ�һ�£�����������");
return false;
}
if(document.form.password.value!=document.form.passwordOne.value){
window.alert("��������������벻һ�£�����������");
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
				<strong>�޸Ļ�Ա��Ϣ </strong>
			</p>
			<form name="form" method="post" action="memberAction!updateCustomer"
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
							
								<input type="text" name="name" value="${customer.cusName}" disabled="disabled">
								
							</div>
						</td>
					</tr>
					<tr>
						<td height="35" bgcolor="#EFF6FE">
							<div align="center">
								ԭ��������
							</div>
						</td>
						<td>
							<div align="center">
								<input type="hidden" name="question" value="${customer.question}">
								<input type="hidden" name="answer"
									value="${customer.answer}">
								<input type="hidden" name="passwordOld"
									value="${customer.cusPassword}">
								<input type="password" name="oldPassword">
							</div>
						</td>
					</tr>
					<tr>
						<td height="35" bgcolor="#EFF6FE">
							<div align="center">
								������
							</div>
						</td>
						<td>
							<div align="center">
								<input type="password" name="password">
							</div>
						</td>
					</tr>
					<tr>
						<td height="35" bgcolor="#EFF6FE">
							<div align="center">
								����ȷ��
							</div>
						</td>
						<td>
							<div align="center">
								<input type="password" name="passwordOne">
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
								<input type="text" name="cusTelephone"
									value="${customer.cusTelephone}">
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
								<input type="text" name="cusAddress" value="${customer.cusAddress}">
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
								<input type="text" name="cusPostCode"
									value="${customer.cusPostCode }">
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
								<input name="cusMail" type="text" value="${customer.cusMail}">
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
			<p>
				&nbsp;
			</p>
		</div>
	</body>
</html>
