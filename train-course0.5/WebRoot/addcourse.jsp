<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
	color: #42870a;
	font-size: 12px;
}

option {
	color: #42870a;
	font-size: 12px;
}

.STYLE3 {
	color: #528311;
	font-size: 12px;
}

.STYLE4 {
	color: #42870a;
	font-size: 12px;
}
-->
</style>
		<title>培训课程管理系统</title>
		<link href="css/edu.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		<br>
		<br>
		<font size="5" color="42870a"><b>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;课程信息新增</b> </font>
		<br>
		<br>
		<center>
			<form method="post" action="courseAction!addCourse" name="register">
				<input type="hidden" name="s_id" value="">
				<input type="hidden" name="s_username" value="">
				<TABLE cellSpacing=0 cellPadding=5 width=200 border=1
					bordercolor="42870a" class="black_text">
					<TBODY>
						<TR>
							<TD width=100 align="left">
								<FONT color=#666666>教&nbsp;师&nbsp;编&nbsp;号：</FONT>
							</TD>
							<TD align="left">
							<input type="hidden" name="tNumber" value="${tNo}"/>
								${tNo}
							</TD>
						</TR>
						<TR>
							<TD>
								<FONT color=#666666>教&nbsp;师&nbsp;名&nbsp;字：</FONT>
							</TD>
							<TD align="left">
								<input
									style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;"
									size=17 type="text" name="tName" value="">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<SPAN id=password1>
							</TD>
						</TR>
						<TR>
							<TD align="left">
								<FONT color=#666666>性&nbsp;&nbsp;&nbsp;别:</FONT>
							</TD>
							<TD align="left" noWrap>
								<input type="text" name="tSex" size=17 value=""
									style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
							</TD>
						</TR>
						<TR>
							<TD>
								<FONT color=#666666>班&nbsp;级&nbsp;编&nbsp;号：</FONT>
							</TD>
							<TD align="left">
							<input type="hidden" name="clNumber" value="${clNo }"/>
								${clNo }
							</TD>
						</TR>
						<TR>
							<TD>
								<FONT color=#666666>班&nbsp;级&nbsp;名&nbsp;字：</FONT>
							</TD>
							<TD align="left">
								<input
									style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;"
									size=17 type="text" name="clName" value="">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<SPAN id=password1>
							</TD>
						</TR>

						<TR>
							<TD align="left">
								<FONT color=#666666>课&nbsp;程&nbsp;编&nbsp;号:</FONT>
							</TD>
							<TD align="left" noWrap>
							<input type="hidden" name="cNumber" value="${cNo }"/>
								${cNo }
							</TD>
						</TR>

						<TR>
							<TD align="left">
								<FONT color=#666666>课&nbsp;程&nbsp;名：</FONT>
							</TD>
							<TD align="left" noWrap>
								<label>
									<input name="cName" type="text" size=17 value=""
										style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
						</TR>


						<TR>
							<TD align="left">
								<FONT color=#666666>课 &nbsp;&nbsp;&nbsp;时：</FONT>
							</TD>
							<TD align="left" noWrap>
								<input type="text" name="cTime" size=17 value=""
									style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
							</TD>
						</TR>
						<TR>
							<TD align="left">
								<FONT color=#666666>教 &nbsp;&nbsp;&nbsp;室：</FONT>
							</TD>
							<TD align="left" noWrap>
								<select size="1" name="loId"
									style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
									
									<option value=""
										style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
										=====请选择=====
									</option>
									<c:forEach items="${listSL}" var="li">
										
										<option value="${li.loId }"
											style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
											${li.loName }
										</option>
									</c:forEach>
								</select>
							</TD>
						</TR>
					</TBODY>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=430 border=0>
					<TBODY>
						<TR height=30>
							<TD height="50" class="green_btn_small">
								<input type="hidden" name="quanxian" value="2">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;
								<input type="submit" name="Submit" value=" 确 定"
									style="height: 20px; width: 50px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" name="Submit" value=" 重  置 "
									style="height: 20px; width: 50px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;" />
							</TD>
						</TR>
				</TABLE>
			</form>
	</body>
</html>

