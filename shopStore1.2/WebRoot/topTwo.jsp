<%@ page contentType="text/html; charset=gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/css.css" rel="stylesheet" type="text/css">
<jsp:useBean id="cus" class="com.chen.entity.Customer"></jsp:useBean>

<c:choose>
<c:when test="${empty customer}">
<table width="97%" height="41" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr align="center">
		<td width="117" height="39" class="linkWhite">
			<a href="index.jsp">��ҳ<br> Index</a>
		</td>
		
		
		<td width="117">
			<a href="connection.jsp">�鿴����<br> Order</a>
		</td>
		<td width="117" class="linkWhite">
			<a href="connection.jsp">�鿴���ﳵ<br> Cart</a>
		</td>
		<td width="117" class="linkWhite">
			<a href="connection.jsp">��Ա�޸�<br> Member</a>
		</td>
		<td width="117" class="linkWhite">
			<a hre
	this.style.behavior = 'url(#default#homepage)';
	this.sethomepage('http://www.ming
risoft.com')"
				class="linkBlack">��Ϊ��ҳ<br> SettingFirst</a>
		</td>
	</tr>
</table>
</c:when>
<c:otherwise>
<table width="97%" height="41" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr align="center">
		<td width="117" height="39" class="linkWhite">
			<a href="index.jsp">��ҳ<br>
			
			
				<td width="117" class="linkWhite">
					<a href="orderAction!orderLogin">�鿴����<br> Order</a>
				</td>
				<td width="117" class="linkWhite">
					<a href="cartAction!cartLogin">�鿴���ﳵ<br> Cart</a>
				</td>
				<td width="117" class="linkWhite">
					<a
						href="memberAction!goUpdateCustomer">��Ա�޸�<br>
						Member</a>
				</td>
				<td width="117" class="linkWhite">
					<a href="#"
						onclick=
	this.style.behavior = 'url(#default#homepage)';
	this.sethomepage('http://www.mingrisoft.com');
>��Ϊ��ҳ<br>
						SettingFirst</a>
				</td>
	</tr>
</table>
</c:otherwise>
</c:choose>
