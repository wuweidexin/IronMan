<%@page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
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

</script>
	</head>

	<body>
		<em> <br /> <br /> <font size="5" color="42870a"><b>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 学生信息管理</b>
		</font>
		<br>
				<br>


					<table width="80%" cellspacing="0" cellpadding="0" border="0"
						align="center">
						<tr>
							<td height="30">
								<table width="100%" cellspacing="0" cellpadding="0" border="0">
									<tr>
										<td height="30" width="15">
											<img height="30" width="15" src="images/tab_03.gif" />
										</td>
										<td width="1101" background="images/tab_05.gif">
											<img height="16" width="16" src="images/311.gif" />
											<span class="STYLE4">学生信息管理</span>
										</td>
										<td width="281" background="images/tab_05.gif">
											<table cellspacing="0" cellpadding="0" border="0"
												align="right">
												<tr>
													<td class="STYLE1">
														<div align="center">
															<img height="14" width="14" src="images/001.gif" />
														</div>
													</td>
													<td class="STYLE1">
														<div align="center">
															<a href="addstudent.jsp">新增</a>
														</div>
													</td>
												</tr>
											</table>
										</td>
										<td width="14">
											<img height="30" width="14" src="images/tab_07.gif" />
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table width="100%" cellspacing="0" cellpadding="0" border="0">
									<tr>
										<td width="9" background="images/tab_12.gif">
											&nbsp;
										</td>
										<td bgcolor="#f3ffe3">
											<table width="99%" cellspacing="1" cellpadding="0" border="0"
												bgcolor="#c0de98" align="center" onmouseover="changeto()"
												onmouseout="changeback()">
												<tr>
													<td height="18" width="6%" background="images/tab_14.gif"
														class="STYLE1">
														<div align="center" class="STYLE2 STYLE1">
															序号
														</div>
													</td>
													<td height="18" width="8%" background="images/tab_14.gif"
														class="STYLE1">
														<div align="center" class="STYLE2 STYLE1">
															用户名
														</div>
													</td>
													<td height="18" width="8%" background="images/tab_14.gif"
														class="STYLE1">
														<div align="center" class="STYLE2 STYLE1">
															密码
														</div>
													</td>
													<td height="18" width="8%" background="images/tab_14.gif"
														class="STYLE1">
														<div align="center" class="STYLE2 STYLE1">
															姓名
														</div>
													</td>
													<td height="18" width="8%" background="images/tab_14.gif"
														class="STYLE1">
														<div align="center" class="STYLE2 STYLE1">
															性别
														</div>
													</td>
													<td height="18" width="5%" background="images/tab_14.gif"
														class="STYLE1">
														<div align="center" class="STYLE2 STYLE1">
															学历
														</div>
													</td>
													<td height="18" width="8%" background="images/tab_14.gif"
														class="STYLE1">
														<div align="center" class="STYLE2">
															操作
														</div>
													</td>
												</tr>
												<c:forEach items="${listStu}" var="li">
													<tr>
														<td height="18" bgcolor="#ffffff">
															<div align="center" class="STYLE1">
																${li.SId }
															</div>
														</td>
														<td height="18" bgcolor="#ffffff" class="STYLE2">
															<div align="center" class="STYLE2 STYLE1">
																${li.SNumber }
															</div>
														</td>
														<td height="18" bgcolor="#ffffff" class="STYLE2">
															<div align="center" class="STYLE2 STYLE1">
																${li.SPwd }
															</div>
														</td>
														<td height="18" bgcolor="#ffffff" class="STYLE2">
															<div align="center" class="STYLE2 STYLE1">
																${li.SName }
															</div>
														</td>
														<td height="18" bgcolor="#ffffff" class="STYLE2">
															<div align="center" class="STYLE2 STYLE1">
																${li.SSex }
															</div>
														</td>
														<td height="18" bgcolor="#ffffff" class="STYLE2">
															<div align="center" class="STYLE2 STYLE1">
																${li.SEducation }
															</div>
														</td>
														<td height="18" bgcolor="#ffffff">
															<div align="center">
																<span class="STYLE1"></span><a
																	href="stuAction!delectStu?id=${li.SId }"
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
								<table width="100%" cellspacing="0" cellpadding="0" border="0">
									<tr>
										<td height="29" width="15">
											<img height="29" width="15" src="images/tab_20.gif" />
										</td>
										<td background="images/tab_21.gif">
											<table width="100%" cellspacing="0" cellpadding="0"
												border="0">
												<tr>
													
													<td width="75%" valign="top" class="STYLE1">
														<div align="right">
															<table height="20" width="352" cellspacing="0"
																cellpadding="0" border="0">
																<tr>
																	
																	<td height="22" width="59" valign="middle">

																	</td>
																	<td height="22" width="25" valign="middle">
																		<span class="STYLE7"> </span>
																	</td>
																	<td height="22" width="23" valign="middle"></td>
																	<td height="22" width="30" valign="middle"></td>
																</tr>
															</table>
														</div>
													</td>
												</tr>
											</table>
										</td>
										<td width="14">
											<img height="29" width="14" src="images/tab_22.gif" />
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
		</em>
	</body>
</html>