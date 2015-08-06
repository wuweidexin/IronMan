<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
response.setContentType("text.xml");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);
request.getAttribute("name");

response.getWriter().write("<msg>exit</msg>");
 %>