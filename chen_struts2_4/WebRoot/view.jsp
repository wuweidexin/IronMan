<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
  </head>
  
  <body>
 
   <table border="1" align="center">
    <tr><td>UserName</td><td>PassWord</td><td>CreateTime</td><td>EndTime</td></tr>
    
    <c:forEach items="${list}" var="li">
    
     <tr>
     <td>${li.userName}</td>
     <td>${li.passWord}</td>
     <td>${li.createTime}</td>
     <td>${li.endTime}</td>
     <td><a href="<%=basePath%>baseAction!updateUser?id=&{li.id}">updateUser</a></td>
     <td><a href="<%=basePath%>baseAction!deleteUser?id=&{li.id}">deleteUser</a></td>
     <td>${li.endTime}</td>
     </tr>
    </c:forEach>
    
    
   </table>
  </body>
</html>
