<%@ page contentType="text/html; charset=gb2312" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <title>�ɹ�����</title>
  </head>  
  <body>
	�ɹ�����
	  <a href="<%=basePath%>index.jsp">������ҳ</a>
  </body>
</html>