<%@ page contentType="text/html; charset=gb2312"%>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<%java.util.Date date=new java.util.Date();%>


<table width="100%" height="15" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<td width="24%" height="18">
			&nbsp;&nbsp;&nbsp;
			<font color="#FFFFFF">��ǰ��¼���ǣ�${manager.managerName }</font>
		</td>
		<td width="76%">
			<div align="right">
				<font color="#FFFFFF">������<%=date.getYear()+1900%>��<%=date.getMonth()+1%>��<%=date.getDate()%>��</font>&nbsp;&nbsp;&nbsp;
			</div>
		</td>
	</tr>
</table>
