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
		<title>����Ա��¼</title>
	</head>
	<link href="../css/css1.css" rel="stylesheet" type="text/css">
	<script language="javascript">
 function checkEmpty(){
 if(document.form.managerName.value==""){
  window.alert("���������Ա�˺�")
   document.form.managerName.focus();
   return false;
 }
 if(document.form.managerPassword.value==""){
 window.alert("���������Ա����")
 document.form.managerPassword.focus();
 return false;
 }
 return true;
 } 
 
 </script>
	<body>
		<br>

		<table width="452" height="358" border="0" align="center"
			cellpadding="0" cellspacing="0">
			<tr>
				<td background="../image/land.jpg">
					<form name="form" method="post" action="../managerAction!loadManagerSet?action=-1"
						onSubmit="return checkEmpty()">
						<table width="55%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="23%" height="30">
									<div align="right">
										<strong>�˺�:</strong>
									</div>
								</td>
								<td width="77%">
									&nbsp;
									<input name="managerName" type="text" size="23">
								</td>
							</tr>
							<tr>
								<td height="30">
									<div align="right">
										<strong>����:</strong>
									</div>
								</td>
								<td>
									&nbsp;
									<input name="managerPassword" type="password" size="23">
								</td>
							</tr>
						</table>
						<br>
						<div align="center">
							&nbsp;
							<input type="submit" name="Submit2" value="�ύ">
							&nbsp;&nbsp;
							<input type="reset" name="reset" value="����">
							&nbsp;&nbsp;
							<a href="../index.jsp"><strong>����</strong> </a>
						</div>
					</form>


					<p>
						&nbsp;
					</p>
					<p>
						&nbsp;
					</p>
				</td>
			</tr>
		</table>
		<p>
			&nbsp;
		</p>
	</body>
</html>
