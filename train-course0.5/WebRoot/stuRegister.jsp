<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ page import="com.chen.entity.*"%>
<jsp:useBean id="stu" class="com.chen.entity.Student"></jsp:useBean>
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
		<title>��ѵ�γ̹���ϵͳ</title>
		<link href="css/edu.css" rel="stylesheet" type="text/css" />
	</head>

	<body>

		<br>
		<br>
		<font size="5" color="42870a"><b>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 ��Աע��</b> </font>
		<br>
		<%
			stu = (Student) request.getSession().getAttribute("user");
		%>
		<br>
		<center>
			<form method="post" action="" name="register">

			
				

				<TABLE cellSpacing=0 cellPadding=5 width=200 border=1
					bordercolor="42870a" class="black_text">
					<TBODY>
						<TR>
							<TD width=80 align="left">
								<FONT color=#666666>��&nbsp;��&nbsp;��:</FONT>
							</TD>
							<TD align="left" width="100">
								<input
									style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;"
									size=17 id=password type="text" name="s_number"
									value="">
							</TD>
						</TR>
						<TR>
							<TD>
								<FONT color=#666666>��&nbsp;&nbsp;&nbsp;&nbsp;��:</FONT>
							</TD>
							<TD align="left">
								<input
									style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;"
									size=17 id=password type="text" name="s_pwd"
									value="">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<SPAN id=password1>
							</TD>
						</TR>

						<TR>
							<TD align="left">
								<FONT color=#666666>��ʵ����:</FONT>
							</TD>
							<TD align="left" noWrap>
								<input size=17 id=rname type="text" name="s_name"
									value=""
									style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<SPAN id=rname1>
							</TD>
						</TR>

						<TR>
							<TD align="left">
								<FONT color=#666666>�� ��:</FONT>
							</TD>
							<TD align="left" noWrap>
								<label>
									<input name="s_sex" type="text" size=17
										value=""
										style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
						</TR>


						<TR>
							<TD align="left">
								<FONT color=#666666>��&nbsp;&nbsp;&nbsp;&nbsp;��:</FONT>
							</TD>
							<TD align="left" noWrap>
								<input type="text" name="s_phone" size=17
									value=""
									style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
							</TD>
						</TR>
						<TR>
							<TD align="left">
								<FONT color=#666666>ѧ&nbsp;&nbsp;&nbsp;&nbsp;��:</FONT>
							</TD>
							<TD align="left" noWrap>
								<input type="text" name="s_education" size=17
									value=""
									style="height: 18px; width: 150px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
							</TD>
						</TR>

					</TBODY>
				</TABLE>
				<TABLE cellSpacing=0 cellPadding=0 width=430 border=0>
					<TBODY>
						<TR height=30>
							<TD height="50" class="green_btn_small">
								
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;
								<input type="button" name="update" value=" ȷ �� " onclick="goUpdate()"
									style="height: 20px; width: 50px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="button" name="reset" value=" ��  �� " onclick="reSet()"
									style="height: 20px; width: 50px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;" />
							</TD>
						</TR>
				</table>
			</form>
	</body>
</html>
<Script>
function goUpdate()
{
	for(i=0;i<register.length;i++)
	{
		if(register.elements[i].value=="")
		{
			alert("����Ϣ����Ϊ��");
			return false;
		}
	}
	register.action="stuAction!stuRegister?flag=register";
	register.submit();
}
</Script>
<!--

	

-->
