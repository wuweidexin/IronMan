<%@ page contentType="text/html; charset=gb2312" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>注册成功</title>
</head>
 <link href="../css/css.css" rel="stylesheet" type="text/css">

<body>
<p>&nbsp;</p>
<div align="center">

<script language='javascript'>alert('<%=request.getAttribute("success")%>');</script>

  <a href="<%=basePath%>index.jsp">返回主页</a>
</div>
</body>
</html>
