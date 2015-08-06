<%@page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>培训课程管理系统</title>
		<body>
			<br>
			<br>
				<font size="5" color="42870a"><b>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						基本信息管理</b> </font><br>
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
									<span class="STYLE4">基本信息管理</span>
								</td>
								<td width="281" background="images/tab_05.gif">
									<table border="0" align="right" cellpadding="0" cellspacing="0">
										<tr>
											<td class="STYLE1">
												<div align="center"></div>
											</td>
											<td class="STYLE1">
												<div align="center"></div>
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
					<form action="" name="form" method="post">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="9" background="images/tab_12.gif">
									&nbsp;
								</td>
								<td bgcolor="#f3ffe3">
									<table width="99%" border="0" align="center" cellpadding="0"
										cellspacing="1" bgcolor="#c0de98" onmouseover=changeto();
										onmouseout=changeback();>
										<tr>
											<td width="6%" height="18" background="images/tab_14.gif"
												class="STYLE1">
												<div align="center" class="STYLE2 STYLE1">
													用户名
												</div>
											</td>
											<td width="8%" height="18" background="images/tab_14.gif"
												class="STYLE1">
												<div align="center" class="STYLE2 STYLE1">
													管理员姓名
												</div>
											</td>
											<td width="8%" height="18" background="images/tab_14.gif"
												class="STYLE1">
												<div align="center" class="STYLE2 STYLE1">
													管理员密码
												</div>
											</td>										
											<td width="13%" height="18" background="images/tab_14.gif"
												class="STYLE1">
												<div align="center" class="STYLE2">
													操作
												</div>
											</td>
										</tr>
										<c:forEach items="${nList}" var="lim">
												<tr >
													<td height="18" bgcolor="#FFFFFF">
														<div align="center" class="STYLE1">
															${lim.MNumber}
													</td>
													<td height="18" bgcolor="#FFFFFF" class="STYLE2">
														<div align="center" class="STYLE2 STYLE1">
															${lim.MName }
													</td>
													<td height="18" bgcolor="#FFFFFF" class="STYLE2">
														<div align="center" class="STYLE2 STYLE1">
															${lim.MPwd }
														</div>
													</td>									

													<td height="18" bgcolor="#FFFFFF">
														<div align="center">
																<span class="STYLE1"></span><a
																	href="managerAction!delectManager?mId=${lim.MId }"
																	onclick="return (confirm('你确定要删除么？'))">删除</a> 
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
								</td>
								<td width="14">
									<img src="images/tab_22.gif" width="14" height="29" />
								</td>
							</tr>
						</table>
					</td>
				</tr>


			</table>
		</form>

		</body>
</html>
