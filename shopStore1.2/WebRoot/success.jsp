<%@ page contentType="text/html; charset=gb2312" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <title>成功处理</title>
  </head>  
  <body>
	成功处理
	  <a href="<%=basePath%>index.jsp">返回主页</a>
  </body>
</html>