<%@page contentType="text/html;charset=gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.*,com.chen.entity.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
.STYLE1 {font-size: 12px}
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
.STYLE7 {font-size: 12}

-->
</style>


	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>��ѵ�γ̹���ϵͳ</title>
		<body>
		<br/>
		<br/>
		<font size="5" color="42870a"><b>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��ѡ�γ�</b>
		</font>
		<br/>
		<br/>
			<form action="" name="form" method="post">
				<table width="90%" border="0" align="center" cellpadding="0"
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
										<span class="STYLE4">ѡ����Ϣ����</span>
									</td>
									<td width="281" background="images/tab_05.gif">
										<table border="0" align="right" cellpadding="0"
											cellspacing="0">
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
	changeto();;;
onmouseout=
	changeback();
>
											<tr>
												<td width="6%" height="18" background="images/tab_14.gif"
													class="STYLE1">
													<div align="center" class="STYLE2 STYLE1">
														���
													</div>
												</td>
												<td width="8%" height="18" background="images/tab_14.gif"
													class="STYLE1">
													<div align="center" class="STYLE2 STYLE1">
														�γ̺�
													</div>
												</td>
												<td width="8%" height="18" background="images/tab_14.gif"
													class="STYLE1">
													<div align="center" class="STYLE2 STYLE1">
														�γ���
													</div>
												</td>
												<td width="6%" height="18" background="images/tab_14.gif"
													class="STYLE1">
													<div align="center" class="STYLE2 STYLE1">
														��ʱ
													</div>
												</td>
												<td width="8%" height="18" background="images/tab_14.gif"
													class="STYLE1">
													<div align="center" class="STYLE2 STYLE1">
														�ον�ʦ���
													</div>
												</td>
												<td width="8%" height="18" background="images/tab_14.gif"
													class="STYLE1">
													<div align="center" class="STYLE2 STYLE1">
														�ον�ʦ����
													</div>
												</td>											
												<td width="8%" height="18" background="images/tab_14.gif"
													class="STYLE1">
													<div align="center" class="STYLE2 STYLE1">
														��ʦ�����༶
													</div>
												</td>
												<td width="8%" height="18" background="images/tab_14.gif"
													class="STYLE1">
													<div align="center" class="STYLE2 STYLE1">
														�༶�ص�
													</div>
												</td>
												<td width="13%" height="18" background="images/tab_14.gif"
													class="STYLE1">
													<div align="center" class="STYLE2">
														����
													</div>
												</td>
											</tr>

										
											<c:forEach items="${tea}" var="li">
												<tr id="haha">
													<td height="18" bgcolor="#FFFFFF">
														<div align="center" class="STYLE1">

															${li.TId}
													</td>
													<td height="18" bgcolor="#FFFFFF" class="STYLE2">
														<div align="center" class="STYLE2 STYLE1">
															${li.course.CNumber}
														</div>
													</td>
													<td height="18" bgcolor="#FFFFFF" class="STYLE2">
														<div align="center" class="STYLE2 STYLE1">
															${li.course.CName}
														</div>
													</td>
													<td height="18" bgcolor="#FFFFFF" class="STYLE2">
														<div align="center" class="STYLE2 STYLE1">
															${li.course.CTime}
														</div>
													</td>
													<td height="18" bgcolor="#FFFFFF" class="STYLE2">
														<div align="center" class="STYLE2 STYLE1">
															${li.TNumber}
														</div>
													</td>
													<td height="18" bgcolor="#FFFFFF" class="STYLE2">
														<div align="center" class="STYLE2 STYLE1">
															${li.TName}
														</div>
													</td>
													<td height="18" bgcolor="#FFFFFF" class="STYLE2">
														<div align="center" class="STYLE2 STYLE1">
															${li.classes.clName}
														</div>
													</td>
													<td height="18" bgcolor="#FFFFFF" class="STYLE2">
														<div align="center" class="STYLE2 STYLE1">
															${li.classes.studylocation.loName}
														</div>
													</td>
													

													<td height="18" bgcolor="#FFFFFF">
														<div align="center">
															<span class="STYLE1"></span>
															<input name="xuanze" type="checkbox" value="${li.TId}"/>
															ѡ��
															<span class="STYLE1"></span>
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
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												
												<td width="75%" valign="top" class="STYLE1">
													<div align="right">
														<table width="352" height="20" border="0" cellpadding="0"
															cellspacing="0">
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
				<div align="center">
					<input type="button" align="right" value="ȷ��" onclick="choose()" />
					<input type="button" align="right" value="ȡ��" onclick="reset()" />
				</div>
			</form>

		</body>
<script type="text/javascript">
//�ú�����Ҫ����������ѡ��Ŀγ�
function choose()
{
	var s ="";
	var checkArray = document.getElementsByName("xuanze");
	for(var i=0; i < checkArray.length; i ++)
	{
		if(checkArray[i].checked)
		{
			s=s+checkArray[i].value+",";
  		}
    }
	form.action="courseAction!chooseCourse?choose="+s;
	form.submit();
}

//ȡ��ѡ��
function reset()
{
}

</script>
<!--var checkArray = document.getElementsByName("xuanze");
	for(var i=0;i<checkArray.length;i++)
	{
		if(checkArray[i].checked)
		{
			alert(checkArray[i].value);
  		}
    }
    -->