<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<HTML>
<HEAD>
<TITLE>iSoftStone培训中心考试平台</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="<%=basePath%>webep/css/style.css" type="text/css">
</HEAD>
<BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<SCRIPT language="JavaScript1.2" src="<%=basePath%>webep/js/coolmenus4.js"></SCRIPT>
<SCRIPT language="JavaScript1.2" src="<%=basePath%>webep/js/cm_addins.js"></SCRIPT>
<form action="" name="form1" id="form1" method="post">
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" class="pagetop">
					<TR>
						<TD width="420" nowrap class="headerLogo"><IMG src="<%=basePath%>webep/logo.gif"><IMG src="<%=basePath%>webep/logo_js.gif">
						</TD>
						<TD class="welcome">
						</TD>
						<TD width="187" align="right" nowrap class="headerHelp">
							<TABLE border="0" cellpadding="4" cellspacing="2">
								<TR>
									<TD align="center" class="sys"><A href="<%=basePath %>indexPageAction!exitSystem" class="syslink">退出登录</A><A href="<%=basePath %>indexPageAction!toResetPwd" class="syslink">修改密码</A>
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
				</TABLE>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
					<TR>
						<TD height="24" class="menuMain">
							<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
								<TR>
									<TD>	&nbsp;
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
					<TR>
						<TD height="2" class="menuBl1"><IMG src="<%=basePath%>webep/space.gif" width="1" height="1"></TD>
					</TR>
					<TR>
						<TD height="3" class="menuBl2"><IMG src="<%=basePath%>webep/space.gif" width="1" height="1"></TD>
					</TR>
				</TABLE>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
					<TR>
						<TD><IMG src="<%=basePath%>webep/space.gif" width="778" height="1"></TD>
					</TR>
				</TABLE>
<P>
<SCRIPT language=JavaScript1.2>showMenu("","<%=basePath%>",2);
</SCRIPT>
				<TABLE width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#999999">
					<TR>
						<TD><IMG src="<%=basePath%>webep/space.gif" width="1" height="1"></TD>
					</TR>
				</TABLE>
			</TD>
		</TR>
	</TABLE><BR>
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD width="20">	&nbsp;
			</TD>
			<TD align="left" valign="top">
				<TABLE border="0" class="top" width="800">
					<TR>
						<TD class="FormTitle" height="2" width="100%"><B>题目新增</B>
						</TD>
					</TR>
					<TR>
						<TD>	&nbsp;
						</TD>
					</TR>
					<TR>
						<TD>
						
						
						
						
						
							<TABLE align="center" border="0" width="90%">
								<TR>
									<TD height="20" width="1%">
									</TD>
									<TD width="12%">	题目编号：
									</TD>
									<TD width="35%">										
										<INPUT class=box name="examNo" size=20 maxLength=20 value="">
									</TD>
									<TD width="12%">	录入人：
									</TD>
									<TD>										
				                    <INPUT type="text" name="quesName" class="box"  value=''>
									</TD>
									
									
								</TR>
								
								<TR>
									<TD height="20">
									</TD>
									<TD>	
									</TD>
									<TD colspan="3">											
										
										
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>	录入日期：
									</TD>
									<TD colspan="3">	由：										
										<INPUT type="text" name="examTimeStart" class="box"  value=''>&nbsp;<A href="#"><IMG name="button" src='<%=basePath%>webep/calendar.gif' border="0" onClick="WdatePicker()" align="center"></A>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;至：										
										<INPUT type="text" name="examTimeEnd" class="box"  value=''>&nbsp;<A href="#"><IMG name="button" src='<%=basePath%>webep/calendar.gif' border="0" onClick="WdatePicker()" align="center"></A>
									</TD>
								</TR>
								<TR>
									<TD height="20">
									</TD>
									<TD>
									</TD>
									<TD colspan="3" align="right">										
										<INPUT class="button" type="submit"  name="search" value=" 查 找 " onclick="queryResult()">
									</TD>
								</TR>
							</TABLE>
					
							
							
							
							
							
						</TD>
					</TR>
					<TR>
						<TD>
<HR width="98%">
						</TD>
					</TR>
					<TR>
						<TD height="40" valign="top">


							<TABLE align="center" border="0" class="ItemList" height="20" width="96%">
								<TR height="24" align="middle">
								                <TD class="ItemTitle" height="20" width="5%">	选择
												</TD>
		                                        <TD class="ItemTitle" height="20" width="11%">	题目编号
												</TD>
												<TD class="ItemTitle" width="11%">	题目类型
												</TD>
												<TD class="ItemTitle" width="11%">	题目范围
												</TD>
												<TD class="ItemTitle" width="11%">	题目难度
												</TD>
												<TD class="ItemTitle" width="11%">	录入人
												</TD>
												<TD class="ItemTitle" width="11%">	录入日期
												</TD>
									
									
									
											<c:forEach items="${list}" var="li">
											<TR align="middle" class="ItemBody">
												<td width="3%" ><input type="checkbox" name="checked" id="checked" value="${li.PId}"></td>
		                                        
												<TD class="ItemBody" height="20" />	<a href='<%=basePath%>examSchemaAction!quesLibQuery3?tbP_Id=${li.PId}'>${li.col1}</a>
												</TD>
												<TD class="ItemBody">	${li.tbProblemType.ptName}
												</TD>
												<TD class="ItemBody" align="left">	  ${li.tbProblemScore.psName}
												</TD>
												<TD class="ItemBody">	${li.tbProblemDifficultyLevel.pdlName}
												</TD>
												<TD class="ItemBody" align="left">	  ${li.tbUser.UName}
												</TD>
												<TD class="ItemBody">	 ${li.PAddTime} 
												</TD>

									   </c:forEach>
									   
									  
										
											</TR>
											<TR align="middle" class="ItemBody">
												<TD colSpan=9 height=1>
												
	
            <TABLE border=0 cellPadding=0 cellSpacing=3 class=SearchBar 
            height=20 width="135%">
              <TR>
                <TD height=20 width=1100>
                    <DIV align=right> 
                      <P> <B>第 
		              	
                        <input type="text" name="QueryPageNo" id="QueryPageNo" size="3" value="${currentPage}" class="SearchBar_Page">
                           页 / 共 ${totalPage} 页 
                           
                        <input type="button" name="btnGo" value="go" class="SearchBar_Btn" onclick="goToPage()">
						 
						
                        <input type="button" name="btnFirst" value="|&lt;" class="SearchBar_Btn" onclick="toLastFirst(${currentPage})">

                        <input type="button" name="btnPrevious" value="&lt;" class="SearchBar_Btn" onclick="toNextPrevious(${currentPage})">

                        <input type="button" name="btnNext" value="&gt;" class="SearchBar_Btn" onclick="toNext(${currentPage})">

                        <input type="button" name="btnEnd" value="&gt;|" class="SearchBar_Btn" onclick="toLastEnd(${currentPage})">


                        <SPAN 
          class=SearchBar></SPAN></B></P>
          
                  </DIV></TD></TR>
                  </TABLE>	
         
				  </TD>
										</TR>
							</TABLE>

							
						</TD>
					</TR>
					
					<TR>
									
									
									<TD colspan="4" align="center">		
									<INPUT class="button" type="button"  name="search" value=" 全 选" onclick="checkAll('checked');">							
										<INPUT class="button" type="button"  name="search" value=" 增 加" onclick="add()">
										<INPUT class="button" type="button"  name="search" value=" 返 回" onclick="toReturn()">
									</TD>
								</TR>
								<TR>
									
									
									<td height="10"></td>
								</TR>
				</TABLE>
				
			</TD>
		</TR>
	</TABLE><BR>
	<TABLE width="100%" border="0" cellpadding="0" cellspacing="0">
		<TR>
			<TD class="pagefootTl"><IMG src="<%=basePath%>webep/space.gif" width="778" height="1"></TD>
		</TR>
		<TR>
			<TD height="25" class="pagefoot"><FONT face="Arial, Helvetica, sans-serif">&copy;</FONT> 2005-2007  版权所有 软通动力信息技术有限公司 Powered by 软通动力武汉开发中心
			</TD>
		</TR>
	</TABLE>
		</form>
</BODY>
</HTML>
<SCRIPT language="JavaScript">
function queryResult()
{	
    
	form1.action="examSchemaAction!examSchemeAdd4";
	form1.submit();
}

function checkAll(name)
{
    var el = document.getElementsByTagName('input');
 
    var len = el.length;
    for(var i=0; i<len; i++)
    {
        if((el[i].type=="checkbox") && (el[i].name==name))
        {
              el[i].checked = true;
        }
    }
}
function  check(){
	  var  object=document.getElementById("checked");
    if(object!=null){
         for(
         var i=0;
         i<document.form1.checkthemeId.length;i++){
         document.form1.checkthemeId[i].checked=false;
          } 
     }
	
}
function add()
{
      
	if(confirm("确定增加该题目吗？"))
	{
		alert("新增成功！"); 
		form1.submit();
		form1.action="examSchemaAction!examSchemeAdd4";
	}
	
}
function toReturn()
{	
	document.location.href='<%=basePath%>examSchemaAction!examSchemeAdd2';
	
}

//1 到第一页
function toLastFirst(currentPage){
	document.location.href='<%=basePath%>examSchemaAction!examSchemeAdd4?pageMethod=first&currentPage='+currentPage; 
   }

//2到第上一页
function toNextPrevious(currentPage){
	document.location.href='<%=basePath%>examSchemaAction!examSchemeAdd4?pageMethod=previous&currentPage='+currentPage; 
  }

//到第下一页
function toNext(currentPage){

	document.location.href='<%=basePath%>examSchemaAction!examSchemeAdd4?pageMethod=next&currentPage='+currentPage; 
  
  }

//到最后一页
function toLastEnd(currentPage){

	document.location.href='<%=basePath%>examSchemaAction!examSchemeAdd4?pageMethod=last&currentPage='+currentPage; 
  
  }

//去所选的页面
function goToPage(){

         var page = document.getElementById("QueryPageNo").value;  
         var patrn=/^[0-9]{1,20}$/;  
            if(page == null || page == "" || !patrn.exec(page) || page.indexOf('0') == 0)  
         {  
          alert("请正确输入,只能为数字！");  
               return false;  
           }  
            document.location.href="<%=basePath%>examSchemaAction!examSchemeAdd4?pageMethod=goPage&currentPage="+ page;
}




</SCRIPT>