<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.sql.*"%>
<%@page import="com.chen.entity.*"%>
<%
	java.util.Date date = new java.util.Date();
%>

<script language="javascript">
	function land() 
	{ //登录的脚本
		if (document.form.cusName.value == "") 
		{
			window.alert("请输入账号");
			return false;
		}
		if (document.form.cusPassWord.value == "") 
		{
			window.alert("请输入密码");
			return false;
		}

		return true;
	}
	function quit() {
		if (confirm("欢迎下次光临！！！")) {
			window.location.href = "loginOut.jsp";
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<table width="193" height="635" border="0" align="center"
	cellpadding="0" cellspacing="0">
	<tr>
		<td width="193" height="252" valign="middle"
			background="image/denglu.jpg">
			<c:choose>
				<c:when test="${empty customer}">
					<form name="form" method="post" action="memberAction!login"
						onSubmit="return land()">
						<table width="80%" height="90" border="0" align="center"
							cellpadding="0" cellspacing="0">
							<tr>
								<td width="39%" height="20">
									<div align="right">
										用户名：
									</div>
								</td>
								<td width="61%">
									<input name="cusName" type="text" size="13">
								</td>
							</tr>
							<tr>
								<td height="20">
									<div align="right">
										密&nbsp;&nbsp;码：
									</div>
								</td>
								<td>
									<input name="cusPassword" type="password" size="13">
								</td>
							</tr>
							<tr align="center">
								<td height="27">
									&nbsp;
								</td>
								<td>
									<input type="submit" name="Submit3" value="登录">
								</td>
							</tr>
							<tr align="center">
								<td height="23">
									<div align="right">
										<table width="82%" height="77%" border="0" cellpadding="0"
											cellspacing="0">
											<tr>
												<td class="linkBlack">
													<div align="center">
														<a href="memberAction!goRegister">注  册</a>
													</div>
												</td>
											</tr>
										</table>
									</div>
								</td>
								<td>
									<table width="82%" height="77%" border="0" cellpadding="0"
										cellspacing="0">
										<tr>
											<td  class="linkBlack">
												<div align="center">
													<a href="memberAction!findPassword?action=0">找回密码 </a>
												</div>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</form>

				</c:when>
				<c:otherwise>
					<div align="center">
						欢迎${customer.cusName}
					</div>
					<br>
					<table width="93%" height="90" border="0" align="center"
						cellpadding="0" cellspacing="0" bordercolor="#FFFFFF"
						bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
						<tr>
							<td align="center">
								今天是<%=date.getYear()+1900%>年<%=date.getMonth()+1%>月<%=date.getDate()%>日
							</td>
						</tr>

						<tr>
							<td align="center">
								会员姓名：${customer.cusName}
						</tr>

						<tr>
							<td align="center" class="linkBlack">
								<a href="javascript:quit()">安全退出</a>
							</td>
						</tr>
					</table>

					<p>
						&nbsp;
					</p>
				</c:otherwise>
			</c:choose>
		</td>

	</tr>

	<tr>
		<td height="142" align="center" valign="top">
			<table width="100%" height="100%" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td height="43" background="image/shangchenggenggao.jpg">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td height="111">
						<table width="84%" height="209" border="0" align="center"
							cellpadding="0" cellspacing="0">
							<tr>
								<td height="166" valign="middle">

									<MARQUEE direction="up" height="180" onmouseout="this.start()"
										onmouseover="this.stop()" scrollAmount="1" scrollDelay="1"
										class="linkBlack">

										<div align="center">

										</div>
										<br>
										<br>
									</marquee>
								</td>
							</tr>
						</table>



					</td>
				</tr>
			</table>



		</td>
	</tr>
	<tr>
		<td height="236" valign="top">
			<table width="100%" height="235" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td height="43" background="image/shangpinxiaoshoupaihang.jpg">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td height="192">
						<table width="84%" height="153" border="0" align="center"
							cellpadding="0" cellspacing="0">
							<ul>

								<tr align="center">

									<td width="39%">
										没有商品排名
									</td>


									<td width="12%" class="linkBlack">
										&nbsp;
									</td>
									<td width="44%" class="linkBlack">
										<li type="square">
											<div align="left">

											</div>
									</td>
									<td width="5%">
										</li>
								</tr>
							</ul>
						</table>





					</td>
				</tr>
			</table>

		</td>
	</tr>
</table>



