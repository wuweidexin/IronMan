<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="com.chen.entity.*"%>
<jsp:useBean id="cusService" scope="page"
	class="com.chen.serviceImp.CustomerServiceImp" />
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>找回密码步骤二</title>
	</head>
	<link href="../css/css1.css" rel="stylesheet" type="text/css">
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
	<body>
		<p>
			<br>
		</p>
		<div align="center">

			<p>
				<strong>输入答案</strong>
			</p>
			<form name="form" method="post"
				action="memberAction!findPassword?action=2"
				onSubmit="return checkEmpty(form)">
				<table width="298" border="1" cellspacing="0" cellpadding="0"
					bordercolor="#FFFFFF" bordercolordark="#819BBC"
					bordercolorlight="#FFFFFF">
					<tr>
						<td width="105" height="35" bgcolor="#EFF6FE">
							<div align="center">
								问题
							</div>
						</td>
						<td width="187">
							<div align="center">
								<input type="text" name="question" value="${getPassCus.question }">
							</div>
						</td>
					</tr>
					<tr>
						<td width="105" height="35" bgcolor="#EFF6FE">
							<div align="center">
								答案
							</div>
						</td>
						<td width="187">
							<div align="center">
								<input type="text" name="result">
							</div>
						</td>
					</tr>
				</table>
				<br>
				<br>
				<br>
				<input type="submit" name="Submit2" value="提交">
				&nbsp;&nbsp;
				<input type="reset" name="Submit3" value="重置">
				&nbsp;&nbsp;
				<a href="../index.jsp">返回</a>
			</form>


		</div>
	</body>
</html>
