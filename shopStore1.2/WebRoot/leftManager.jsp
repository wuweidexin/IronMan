<%@ page contentType="text/html; charset=gb2312" %>
 <link href="css/css.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
 <script Language="JavaScript">
 function quit() {
  if(confirm("ȷ��Ҫ�˳���̨��")){
    window.location.href="loginOut.jsp";
	}
  }
 </script>
<table width="100%" height="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="45" colspan="2" background="image/zuocedaohang1.jpg">       </td>
      </tr>
      <tr>
        <td width="14%" height="48"   background="image/zuocedaohang2.jpg">&nbsp;</td>
        <td width="86%"   background="image/zuocedaohang2.jpg" class="linkBlack"><p align="center"><a href="bookAction!loadBookSet?action=0">��Ʒ����<br>
        Goods Manager </a></p></td>
      </tr>
      <tr>
        <td height="40" background="image/zuocedaohang2.jpg">&nbsp;</td>
        <td height="40" background="image/zuocedaohang2.jpg" class="linkBlack"><p align="center"><a href="memberAction!loadMemberSet?action=0">��Ա����<br>
        Member Manager</a></p></td>
      </tr>
      <tr>
        <td height="40" background="image/zuocedaohang4.jpg">&nbsp;</td>
        <td height="40" background="image/zuocedaohang4.jpg" class="linkBlack"><p align="center"><a href="managerAction!loadManagerSet?action=0">��̨����Ա����<br>
        Administrator Manager </a></p></td>
      </tr>
      <tr>
        <td height="34" background="image/zuocedaohang5.jpg">&nbsp;</td>
        <td height="40" background="image/zuocedaohang5.jpg" class="linkBlack"><p align="center"><a href="orderAction!loadOrderSet?action=4">��������<br>
        Order Manager</a></p></td>
      </tr>
      <tr>
        <td height="40" background="image/zuocedaohang8.jpg">&nbsp;</td>
        <td height="40" background="image/zuocedaohang8.jpg" class="linkBlack"><p align="center"><a href="javascript:quit()">�˳���̨<br>
        Exit Background </a></p></td>
      </tr>
</table>
