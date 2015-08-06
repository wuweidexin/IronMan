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
		<title>管理员登录</title>
	</head>
	<link href="../css/css1.css" rel="stylesheet" type="text/css">
	<script language="javascript">
 function checkEmpty(){
 if(document.form.managerName.value==""){
  window.alert("请输入管理员账号")
   document.form.managerName.focus();
   return false;
 }
 if(document.form.managerPassword.value==""){
 window.alert("请输入管理员密码")
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
										<strong>账号:</strong>
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
										<strong>密码:</strong>
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
							<input type="submit" name="Submit2" value="提交">
							&nbsp;&nbsp;
							<input type="reset" name="reset" value="重置">
							&nbsp;&nbsp;
							<a href="../index.jsp"><strong>返回</strong> </a>
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
