<%@ page language="java" contentType="text/html;charset=gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>培训课程管理系统</title>
	</head>
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
	<body>
		<form method="post" action="update_zhuanjia" name="register">
			<input type="hidden" name="z_id" value="aaa">
			<input type="hidden" name="z_username" value="aaa">
			<TABLE cellSpacing=0 cellPadding=5 width=200 border=1
				bordercolor="42870a" class="black_text">
				<TBODY>
					<TR>
						<TD width=80 align="left">
							<FONT color=42870a>用&nbsp;户&nbsp;名:</FONT>
						</TD>
						<TD align="left" width="100">
							aaa
						</TD>
					</TR>
					<TR>
						<TD>
							<FONT color=42870a>密&nbsp;&nbsp;&nbsp;&nbsp;码:</FONT>
						</TD>
						<TD align="left">
							<input
								style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;"
								size=17 id=password type="text" name="z_password" value="aaa">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<SPAN id=password1>
						</TD>
					</TR>

					<TR>
						<TD align="left">
							<FONT color=42870a>真实姓名:</FONT>
						</TD>
						<TD align="left" noWrap>
							<input size=17 id=tname type="text" name="z_name" value="aaa"
								style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<SPAN id=rname1>
						</TD>
					</TR>

					<TR>
						<TD align="left">
							<FONT color=42870a>性 别:</FONT>
						</TD>
						<TD align="left" noWrap>
							<label>
								<input name="z_sex" type="text" size=17 value="aaa"
									style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
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
							<input type="submit" name="Submit" value=" 修  改 "
								style="height: 20px; width: 50px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" name="Submit" value=" 重  置 "
								style="height: 20px; width: 50px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;" />
						</TD>
					</TR>
				</TBODY>
			</TABLE>
	</body>
</html>
