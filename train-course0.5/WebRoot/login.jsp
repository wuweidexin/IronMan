<%@page contentType="text/html;charset=gb2312"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<title>培训课程管理系统</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
}

.STYLE3 {
	color: #528311;
	font-size: 12px;
}

.STYLE4 {
	color: #42870a;
	font-size: 12px;
}
</style>
	</head>

	<body>
	<%
		String flag = (String)request.getAttribute("flag"); 
		
	%>
		<form action="" method="post" name="login">
			<table width="100%" height="100%" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td height="608" background="images/login_03.gif">
						<table width="862" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td height="266" background="images/login_04.gif">

									&nbsp;
								</td>
							</tr>
							<tr>
								<td height="95">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">

										<tr>
											<td width="424" height="95" background="images/login_06.gif">
												&nbsp;
											</td>
											<td width="183" background="images/login_07.gif">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">

													</td>
													<tr>
														<td width="21%" height="15">
															<div align="center">
																<span class="STYLE3">用户</span>
															</div>
														</td>
														<td width="79%" height="15">
															<input type="text" name="username"
																style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
														</td>
													</tr>
													<tr>
														<td height="20">
															<div align="center">
																<span class="STYLE3">密码</span>
															</div>
														</td>
														<td height="20">
															<input type="password" name="password"
																style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
														</td>
													</tr>
													<tr>
														<td height="20">
															<div align="center">
																<span class="STYLE3">权限</span>
															</div>
														</td>
														<td height="15">
															<select size="1" name="rights"
																style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
																<option value=""
																	style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
																	=====请选择=====
																</option>
																<option value="student"
																	style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
																	学生
																</option>
																<option value="manager"
																	style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
																	管理员
																</option>
															</select>
														</td>
													</tr>
													<tr>
														<td height="30">
															&nbsp;


														</td>
														<td height="15">
															&nbsp;

															<input type="button" value="登录" onclick="toLogin()"
																style="height: 20px; width: 30px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;" />

															<input type="button" value="取消" onclick="reset()"
																style="height: 20px; width: 30px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;" />
															<input type="button" value="注册" onclick="register()"
																style="height: 20px; width: 30px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;" />


														</td>



													</tr>
												</table>
											</td>
											<td width="255" background="images/login_08.gif">
												&nbsp;
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="247" valign="top" background="images/login_09.gif">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="22%" height="30">
												&nbsp;
											</td>
											<td width="56%">
												&nbsp;
											</td>
											<td width="22%">
												&nbsp;
											</td>
										</tr>
										<tr>
											<td>
												&nbsp;
											</td>
											<td height="30">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="44%" height="20">
															&nbsp;
														</td>

													</tr>
												</table>
											</td>
											<td>
												&nbsp;
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td bgcolor="#a2d962">
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
		<map name="Map">
			<area shape="rect" coords="3,3,36,19" href="#">
			<area shape="rect" coords="40,3,78,18" href="#">
		</map>
	</body>
</html>
<script>
function toLogin(){
	username=login.username.value;
	password=login.password.value;
	rights = login.rights.value;
	if(username=="")
	{
		alert("用户名不能为空");
		return false;
	}else if(password=="")
	{
		alert("密码不能为空");
		return false;
	}else if(rights=="")
	{
		alert("权限不能为空");
		return false;
	}else
	{
		login.action="loginAction!login";
		login.submit();
	}	
}
function reset(){
	document.login.username.value="";
	document.login.password.value="";
	document.login.rights.value="";
}
function register(){
	login.action="stuRegister.jsp";
	login.submit();
}
</script>


