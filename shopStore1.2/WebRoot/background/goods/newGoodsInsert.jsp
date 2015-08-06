<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>


<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
return false;
}
}
}

</script>
<style type="text/css">
<!--
.style1 {
	color: #990000;
	font-weight: bold;
}
-->
</style>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>电子商城的后台</title>
	</head>
	<link href="css/css.css" rel="stylesheet" type="text/css">
	<body>
		<table width="755" height="100%" border="0" align="center" 
			cellpadding="0" cellspacing="0">
			<tr valign="bottom">
				<td height="108" colspan="2" background="image/banner1.jpg">
					<div align="center"><jsp:include page="../upOne.jsp" />
					</div>
					<div align="center">
						<jsp:include page="../upTwo.jsp" />
					</div>
				</td>
			</tr>
			<tr>
				<td width="24%" height="318"><jsp:include
						page="../../leftManager.jsp" />
				</td>
				<td width="76%" height="318" bgcolor="#FFFFFF">
					<div align="center">
						<table width="99%" height="16" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<td bgcolor="#E6E6E6">
									<div align="center" class="style1">
										添加图书信息
									</div>
								</td>
							</tr>
						</table>
						<br>
						<form action="bookAction!saveBook" method="post"
							enctype="multipart/form-data" name="form"
							onSubmit="return checkEmpty(form)">
							<table width="90%" border="1" cellspacing="0" cellpadding="0">
								<tr>
									<td width="20%" height="26">
										&nbsp;&nbsp;书编号
									</td>
									<td>
										&nbsp;
										<input name="bookID" type="text" size="35"
										value = "${book.bookID}" disabled = "disabled"
											>
									</td>
									<td width="20%">
										&nbsp;&nbsp;书名
									</td>
									<td>
										&nbsp;
										<input name="bookName" type="text" size="35"
											>
									</td>
								</tr>
								<tr>
									<td height="25">
										&nbsp;&nbsp;书作者
									</td>
									<td>
										&nbsp;
										<input name="author" type="text" size="35"
										>
									</td>
									<td>
										&nbsp;&nbsp;出版社
									</td>
									<td>
										&nbsp;
										<input name="press" type="text" size="35"
											>
									</td>
								</tr>
								<tr>
									<td height="27">
										&nbsp;&nbsp;版次
									</td>
									<td>
										&nbsp;
										<input name="version" type="text" size="35"
											>
									</td>
									<td>
										&nbsp;&nbsp;价格
									</td>
									<td>
										&nbsp;
										<input name="price" type="text" size="35"
											>
									</td>
								</tr>
								<tr>
								
								<td>
										&nbsp;&nbsp;库存
									</td>
									<td>
										&nbsp;
										<input name="count" type="text" size="35"
											>
									</td>
									
									<td height="30">
										<div align="center">
											图书类别
										</div>
									</td>
									<td>
										&nbsp;
										<select name="bookSort" class="textarea">
											<option value=" ">
												请选择
											</option>
											<option value="literature">
												文学
											</option>
											<option value="economy">
												经济
											</option>
											<option value="science">
												科学
											</option>
											<option value="education">
												教育
											</option>
										</select>
									</td>
								</tr>
							</table>
							<p>
								<input type="submit" name="Submit2" value="提交">
								&nbsp;
								<input type="reset" name="reset" value="清除">
								&nbsp;
								<input type="button" name="back" value="返回"
									onClick="javasrcipt:history.go(-1)">
							</p>
						</form>
						<p>
							&nbsp;
						</p>
						<p>
							&nbsp;
						</p>
					</div>
				</td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td height="60" colspan="2">
					<p align="center"><jsp:include page="../downNews.jsp" />

					</p>
				</td>
			</tr>
		</table>
	</body>
</html>
