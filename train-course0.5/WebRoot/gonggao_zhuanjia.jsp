<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>培训课程管理系统</title>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	font-size: 12px;
	color: #1F4A65;
}

.STYLE1 {
	font-size: 12px
}

.STYLE4 {
	font-size: 12px;
	color: #1F4A65;
	font-weight: bold;
}

a:link {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}

a:visited {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}

a:hover {
	font-size: 12px;
	color: #FF0000;
	text-decoration: underline;
}

a:active {
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

.STYLE7 {
	font-size: 12
}
-->
</style>

		<script>
var  highlightcolor='#eafcd5';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
</script>
	</head>

	<body>&nbsp; 
 
		<br>
			<br>
				<font size="5" color="42870a"><b>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						公告信息管理</b> </font><br>
					<br>


						<table width="80%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td height="30">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="15" height="30">
												<img src="images/tab_03.gif" width="15" height="30" />
											</td>
											<td width="1101" background="images/tab_05.gif">
												<img src="images/311.gif" width="16" height="16" />
												<span class="STYLE4">公告信息管理</span>
											</td>
											<td width="281" background="images/tab_05.gif">
												<table border="0" align="right" cellpadding="0"
													cellspacing="0">
													<tr>
														<td class="STYLE1">
															<div align="center">
																<img src="images/001.gif" width="14" height="14" />
															</div>
														</td>
														<td class="STYLE1">
															<div align="center">
																<a href="addgonggao.jsp">新增</a>
															</div>
														</td>
													</tr>
												</table>
											</td>
											<td width="14">
												<img src="images/tab_07.gif" width="14" height="30" />
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="9" background="images/tab_12.gif">
												&nbsp;
											</td>
											<td bgcolor="#f3ffe3">
												<table width="99%" border="0" align="center" cellpadding="0"
													cellspacing="1" bgcolor="#c0de98" onmouseover="changeto()"
													onmouseout="changeback()">
													<tr>
														<td width="6%" height="18" background="images/tab_14.gif"
															class="STYLE1">
															<div align="center" class="STYLE2 STYLE1">
																序号
															</div>
														</td>
														<td width="12%" height="18" background="images/tab_14.gif"
															class="STYLE1">
															<div align="center" class="STYLE2 STYLE1">
																公告标题
															</div>
														</td>
														<td width="20%" height="18" background="images/tab_14.gif"
															class="STYLE1">
															<div align="center" class="STYLE2 STYLE1">
																公告内容
															</div>
														</td>
														<td width="6%" height="18" background="images/tab_14.gif"
															class="STYLE1">
															<div align="center" class="STYLE2 STYLE1">
																添加时间
															</div>
														</td>
														<td width="8%" height="18" background="images/tab_14.gif"
															class="STYLE1">
															<div align="center" class="STYLE2">
																操作
															</div>
														</td>
													</tr>
													<tr>

													<c:forEach items="${nList}" var="li">
													<tr>
														<td height="18" bgcolor="#FFFFFF">
															<div align="center" class="STYLE1">
																${li.NNumber }
														</td>
														<td height="18" bgcolor="#FFFFFF" class="STYLE2">
															<div align="center" class="STYLE2 STYLE1">
																${li.NTitle }
															</div>
														</td>
														<td height="18" bgcolor="#FFFFFF" class="STYLE2">
															<div align="center" class="STYLE2 STYLE1">
																${li.NContent }
															</div>
														</td>
														<td height="18" bgcolor="#FFFFFF" class="STYLE2">
															<div align="center" class="STYLE2 STYLE1">
																${li.NTime }
															</div>
														</td>												
														<td height="18" bgcolor="#FFFFFF">
															<div align="center">
																<span class="STYLE1"></span><a
																	href="noticeAction!delectNotice?id=${li.NId}"
																	onclick="return (confirm('你确定要删除么？'))">删除</a><span
																	class="STYLE1"></span>
															</div>
														</td>

													</tr>
												</c:forEach>														
												

												</table>
											</td>
											<td width="9" background="images/tab_16.gif">
												&nbsp;
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="29">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="15" height="29">
												<img src="images/tab_20.gif" width="15" height="29" />
											</td>
											<td background="images/tab_21.gif">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														
														<td width="75%" valign="top" class="STYLE1">
															<div align="right">
																<table width="352" height="20" border="0"
																	cellpadding="0" cellspacing="0">
																	<tr>
																		
																		<td width="59" height="22" valign="middle">
																			<div align="right"></div>
																		</td>
																		<td width="25" height="22" valign="middle">
																			<span class="STYLE7"> </span>
																		</td>
																		<td width="23" height="22" valign="middle"></td>
																		<td width="30" height="22" valign="middle"></td>
																	</tr>
																</table>
															</div>
														</td>
													</tr>
												</table>
											</td>
											<td width="14">
												<img src="images/tab_22.gif" width="14" height="29" />
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>