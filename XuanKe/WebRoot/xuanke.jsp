<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>无标题文档</title>
	</head>

	<body>
		<table width="100%" border="0" align="center" cellpadding="0"
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
								<span class="STYLE4">选课信息管理</span>
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
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="9" background="images/tab_12.gif">
								&nbsp;
							</td>
							<td bgcolor="#f3ffe3">
								<table width="99%" border="0" align="center" cellpadding="0"
									cellspacing="1" bgcolor="#c0de98" onmouseover=
	changeto();
onmouseout=
	changeback();
>
									<tr>
										<td width="6%" height="18" background="images/tab_14.gif"
											class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												序号
											</div>
										</td>
										<td width="8%" height="18" background="images/tab_14.gif"
											class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												课程号
											</div>
										</td>
										<td width="8%" height="18" background="images/tab_14.gif"
											class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												课程名
											</div>
										</td>
										<td width="6%" height="18" background="images/tab_14.gif"
											class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												课时
											</div>
										</td>
										<td width="8%" height="18" background="images/tab_14.gif"
											class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												任课教师编号
											</div>
										</td>
										<td width="8%" height="18" background="images/tab_14.gif"
											class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												任课教师姓名
											</div>
										</td>
										<td width="6%" height="18" background="images/tab_14.gif"
											class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												选课人数
											</div>
										</td>
										<td width="8%" height="18" background="images/tab_14.gif"
											class="STYLE1">
											<div align="center" class="STYLE2 STYLE1">
												教室安排
											</div>
										</td>
										<td width="13%" height="18" background="images/tab_14.gif"
											class="STYLE1">
											<div align="center" class="STYLE2">
												操作
											</div>
										</td>
									</tr>

									<tr>
										<form action="kexuankecheng.jsp" method="post">
											<td height="18" bgcolor="#FFFFFF">
												<div align="center" class="STYLE1">
													*
											</td>
											<td height="18" bgcolor="#FFFFFF" class="STYLE2">
												<div align="center" class="STYLE2 STYLE1">
													<input type=text name="c_code" size="8"></input>
												</div>
											</td>
											<td height="18" bgcolor="#FFFFFF" class="STYLE2">
												<div align="center" class="STYLE2 STYLE1">
													<input type=text name="c_name" size="15"></input>
												</div>
											</td>
											<td height="18" bgcolor="#FFFFFF" class="STYLE2">
												<div align="center" class="STYLE2 STYLE1">
													<input type=text name="c_keshi" size="6"></input>
												</div>
											</td>
											<td height="18" bgcolor="#FFFFFF" class="STYLE2">
												<div align="center" class="STYLE2 STYLE1">
													<input type=text name="c_tid" size="10"></input>
												</div>
											</td>
											<td height="18" bgcolor="#FFFFFF" class="STYLE2">
												<div align="center" class="STYLE2 STYLE1">
													<input type=text name="c_tname" size="10"></input>
												</div>
											</td>
											<td height="18" bgcolor="#FFFFFF" class="STYLE2">
												<div align="center" class="STYLE2 STYLE1">
													<input type=text name="c_renshu" size="6"></input>
												</div>
											</td>
											<td height="18" bgcolor="#FFFFFF" class="STYLE2">
												<div align="center" class="STYLE2 STYLE1">
													<input type=text name="c_address" size="10"></input>
												</div>
											</td>
											<td height="20" bgcolor="#FFFFFF">
												<div align="center" class="STYLE21">
													<input type="submit" value="查询"
														style="height: 20px; width: 40px; border: solid 1px #99cccc; font-size: 12px; color: 42870a;"></input>
												</div>
											</td>
										</form>
									</tr>
									<tr id="haha">
										<td height="18" bgcolor="#FFFFFF">
											<div align="center" class="STYLE1">
												<%=(cpage-1)*10+s++ %>
										</td>
										<td height="18" bgcolor="#FFFFFF" class="STYLE2">
											<div align="center" class="STYLE2 STYLE1">
												<input type="hidden" name="code" value=
													<%=rst.getString("c_code") %>></input>
												<%=rst.getString("c_code") %>
											</div>
										</td>
										<td height="18" bgcolor="#FFFFFF" class="STYLE2">
											<div align="center" class="STYLE2 STYLE1">
												<%=rst.getString("c_name") %>
											</div>
										</td>
										<td height="18" bgcolor="#FFFFFF" class="STYLE2">
											<div align="center" class="STYLE2 STYLE1">
												<%=rst.getString("c_keshi") %>
											</div>
										</td>
										<td height="18" bgcolor="#FFFFFF" class="STYLE2">
											<div align="center" class="STYLE2 STYLE1">
												<%=rst.getString("c_tid") %>
											</div>
										</td>
										<td height="18" bgcolor="#FFFFFF" class="STYLE2">
											<div align="center" class="STYLE2 STYLE1">
												<%=rst.getString("c_tname") %>
											</div>
										</td>
										<td height="18" bgcolor="#FFFFFF" class="STYLE2">
											<div align="center" class="STYLE2 STYLE1">
												<%=rst.getString("c_renshu") %>
											</div>
										</td>
										<td height="18" bgcolor="#FFFFFF" class="STYLE2">
											<div align="center" class="STYLE2 STYLE1">
												<%=rst.getString("c_address") %>
											</div>
										</td>
										<td height="18" bgcolor="#FFFFFF">
											<div align="center">
												<span class="STYLE1"></span>
												<input id="zhuangtai" value=
													<%=rst.getString("c_code") %> name="xuanzhe"
													type="checkbox" />选定 <span class="STYLE1"></span></div>
										</td>
									</tr>


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
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="25%" height="29" nowrap="nowrap">
											<span class="STYLE1"><input type="hidden"
													id="s_username" name=s_username value=
													<%=session.getAttribute("user") %>></input>共<%= allCol
												%>条纪录，当前第<%=cpage%>/<%=allpage%>页，共<%= allpage %>记录，每页10条纪录</span>
										</td>
										<td width="75%" valign="top" class="STYLE1">
											<div align="right">
												<table width="352" height="20" border="0" cellpadding="0"
													cellspacing="0">
													<tr>
														<td width="62" height="22" valign="middle">
															<div align="right">
																<a href="kexuankecheng.jsp?pages=1"><img
																		src="images/first.gif" width="37" height="15"
																		border="0" />
																</a>
															</div>
														</td>
														<td width="50" height="22" valign="middle">
															<div align="right">
																<a href="kexuankecheng.jsp?pages=<%= cpage-1 %>"><img
																		src="images/back.gif" width="43" height="15"
																		border="0" />
																</a>
															</div>
														</td>
														<td width="54" height="22" valign="middle">
															<div align="right">
																<a href="kexuankecheng.jsp?pages=<%= cpage+1 %>"><img
																		src="images/next.gif" width="43" height="15"
																		border="0" />
																</a>
															</div>
														</td>
														<td width="49" height="22" valign="middle">
															<div align="right">
																<a href="kexuankecheng.jsp?pages=<%=allpage%>"><img
																		src="images/last.gif" width="37" height="15"
																		border="0" />
																</a>
															</div>
														</td>
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

	</body>
</html>
