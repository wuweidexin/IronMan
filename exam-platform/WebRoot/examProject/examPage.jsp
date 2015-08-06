<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>iSoftStone培训中心考试平台</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="<%=basePath%>webep/css/style.css" type="text/css">
</HEAD>
<BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

	<TABLE border="0" width="100%">
	  <c:forEach items="${list}" var="li">
		<TR>
			<TD width="100%">
	      
				<TABLE border="1" cellspacing="0" cellpadding="0" width="100%">
				
					<TR>
						<TD class="QuestionTitle">
						
							<TABLE border="0" width="100%" height="20">
							
								<TR>
							
									<TD width="1%">	&nbsp;
									</TD>
									
									<TD><STRONG>第1题</STRONG>
									</TD>
									
									<TD width="3%">	&nbsp;
									</TD>
								</TR>
							</TABLE>
						</TD>
					</TR>
					
					<TR>
					
						<TD class="QuestionBody">
							<TABLE border="0" width="100%">
								<TR>
									<TD>
										<TABLE border="0" width="100%">
											<TR>
												<TD width="2%">	&nbsp;
												</TD>
												
												<TD>	
												${li.tbProblem.PTitle}
												</TD>
											</TR>
										</TABLE>
									</TD>
								</TR>
								
								<TR>
									<TD>
										<TABLE border="0" width="100%" cellspacing="0" cellpadding="0">
											<TR>
												<TD width="3%">	&nbsp;
												</TD>
												<TD width="40">													
													<INPUT type="checkbox" name="answer1" value="A" checked disabled>A
												</TD>
												<TD>	${li.prContent}
												</TD>
											</TR>
											<TR>
												<TD>	&nbsp;
												</TD>
												<TD>													
													<INPUT type="checkbox" name="answer1" value="B" disabled>B
												</TD>
												<TD>	
												${li.col1}
												</TD>
											</TR>
											<TR>
												<TD>	&nbsp;
												</TD>
												<TD>													
													<INPUT type="checkbox" name="answer1" value="C" disabled>C
												</TD>
												<TD>	
												${li.col2}
												</TD>
											</TR>
											<TR>
												<TD>	&nbsp;
												</TD>
												<TD>													
													<INPUT type="checkbox" name="answer1" value="D" disabled>D
												</TD>
												<TD>	${li.col3}
												</TD>
											</TR>
										
										</TABLE>
									</TD>
										
								</TR>
							
							</TABLE>
							
						</TD>
					</TR>
					
				</TABLE>
				
			</TD>
		</TR>
	</c:forEach>
	</TABLE>

</BODY>
</HTML>
