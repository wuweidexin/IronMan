<%@ page contentType="text/html; charset=gb2312" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�һ����벽����</title>
</head>
 <link href="../css/css1.css" rel="stylesheet" type="text/css">

<body>
<p>&nbsp;</p>
<div align="center">
  <p><strong>

    �������Ϊ${gpcus.cusPassword }

  </strong></p>
  <a href="<%=basePath%>index.jsp">������ҳ</a>

</div>
</body>
</html>
