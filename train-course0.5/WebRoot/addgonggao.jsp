<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>��ѵ�γ̹���ϵͳ</title>
</head>
	<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	<body>
		<center>
			<br>
			<br>
			<font size="5" color="42870a"><b> ���ӹ�����Ϣ</b>
			</font>
			<br>
			<br>
			<form name="frm" action="noticeAction!addNotice" method="post"
				onsubmit="return users()">
				<table border="1" bordercolor="42870a">
					<tr>
						<td>
							<font size="2" color="42870a">�������:</font>
						</td>
						<td>
							<input type="text" name="n_title" size="21"></input>
						</td>
					</tr>
					<tr>
						<td>
							<font size="2" color="42870a">��������:</font>
						</td>
						<td>
							<textarea name="n_content" cols="45" rows="20"></textarea>
						</td>
					</tr>
					<tr>
						<td>
							<font size="2" color="42870a">����ʱ��:</font>
						</td>
						<td>
							<input type="text" name="n_time" size="21"></input>
						</td>
					</tr>
				</table>
				<br>
				<input type="submit" value="�ύ"
					Style="height: 20px; width: 50px; border: solid 1px #cadcb2; font-size: 12px; color: 42870a;"></input>
				<input type="button" value="��  ��"
					Style="height: 20px; width: 50px; border: solid 1px #cadcb2; font-size: 12px; color: 42870a;"></input>
			</form>

		</center>
	</body>
	<script type="text/javascript">
	function users() {
		var n_title = frm.n_title.value;
		var n_content = frm.n_content.value;
		var n_time = frm.n_time.value;
		if (n_title == "") {
			alert("������ⲻ��Ϊ�գ�");
			return false;
		} else if (n_content == "") {
			alert("�������ݲ���Ϊ�գ�");
			return false;
		} else if (n_time == "") {
			alert("���ӹ���ʱ�䲻��Ϊ�գ�");
			return false;
		} else {
			return true;
		}

	}
</script>
</html>