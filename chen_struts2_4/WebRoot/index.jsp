<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
	</head>

	<body>
		<form action="<%=basePath%>baseAction!loginUser" method="post">
			UserName
			<input type="text" name="userName">
			<br>
			PassWord
			<input type="text" name="passWord">
			<br>
			<input type="submit" value="Login">
			<br>
		</form>
	</body>
</html>
