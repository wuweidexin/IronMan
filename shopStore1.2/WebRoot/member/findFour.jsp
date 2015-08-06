<%@ page contentType="text/html; charset=gb2312" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>找回密码步骤四</title>
</head>
 <link href="../css/css1.css" rel="stylesheet" type="text/css">

<body>
<p>&nbsp;</p>
<div align="center">
  <p><strong>

    你的密码为${gpcus.cusPassword }

  </strong></p>
  <a href="<%=basePath%>index.jsp">返回主页</a>

</div>
</body>
</html>
