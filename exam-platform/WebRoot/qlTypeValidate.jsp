<%@ page language="java" import="java.util.*,com.cissst.entity.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="systemIS" scope="page"
	class="com.cissst.iService.SystemSettingServiceImp" />
<%
response.setContentType("text.xml");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);
//String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
String name = request.getParameter("name");
System.out.println(name);
TbProblemType tpt = (TbProblemType)systemIS.find("from TbProblemType where ptDel='0' and ptName='"+name+"'");
if(tpt == null)
{
	response.getWriter().write("<msg>exit</msg>");
}

 %>