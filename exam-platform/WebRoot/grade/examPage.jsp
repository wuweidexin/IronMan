<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE>iSoftStone��ѵ���Ŀ���ƽ̨</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=gb2312"><LINK rel="stylesheet" href="../webep/css/style.css" type="text/css">
</HEAD>
<BODY bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<TABLE border="0" width="100%">
		<TR>
			<TD width="100%">
				<TABLE border="1" cellspacing="0" cellpadding="0" width="100%">
					<TR>
						<TD class="QuestionTitle">
							<TABLE border="0" width="100%" height="20">
								<TR>
									<TD width="1%">	&nbsp;
									</TD>
									<TD><STRONG>��1��</STRONG>
									</TD>
									<TD width="60">										
										�÷�<INPUT type="text" name="question1" value="" size="5"  >
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
												<TD>	Hashtableʵ�������ĸ��ӿڣ�
												</TD>
											</TR>
										</TABLE>
									</TD>
								</TR>
								<TR>
									<TD>
										<TABLE border="0" width="100%" cellspacing="0" cellpadding="0" >
											<TR>
												<TD width="3%">	&nbsp;
												</TD>
												<TD width="40">													
													<INPUT type="checkbox" name="answer1" value="A" checked disabled >A
												</TD>
												<TD>	java.util.Map
												</TD>
											</TR>
											<TR>
												<TD>	&nbsp;
												</TD>
												<TD>													
													<INPUT type="checkbox" name="answer1" value="B" disabled >B
												</TD>
												<TD>	java.util.List
												</TD>
											</TR>
											<TR>
												<TD>	&nbsp;
												</TD>
												<TD>													
													<INPUT type="checkbox" name="answer1" value="C" disabled >C
												</TD>
												<TD>	java.util.Hashable
												</TD>
											</TR>
											<TR>
												<TD>	&nbsp;
												</TD>
												<TD>													
													<INPUT type="checkbox" name="answer1" value="D" disabled >D
												</TD>
												<TD>	java.util.Collection
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
		<TR>
			<TD width="100%">
				<TABLE border="1" cellspacing="0" cellpadding="0" width="100%">
					<TR>
						<TD class="QuestionTitle">
							<TABLE border="0" width="100%" height="20">
								<TR>
									<TD width="1%">	&nbsp;
									</TD>
									<TD><STRONG>��2��</STRONG>
									</TD>
									<TD width="60">										
										�÷�<INPUT type="text" name="question1" value="" size="5" >
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
												<TD>	������ڼ̳е���Щ��������ȷ�ģ�
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
													<INPUT type="checkbox" name="answer2" value="A" disabled >A
												</TD>
												<TD>	��java��ֻ������һ�̳�
												</TD>
											</TR>
											<TR>
												<TD>	&nbsp;
												</TD>
												<TD>													
													<INPUT type="checkbox" name="answer2" value="B" checked disabled >B
												</TD>
												<TD>	��java��һ����ֻ��ʵ��һ���ӿ�
												</TD>
											</TR>
											<TR>
												<TD>	&nbsp;
												</TD>
												<TD>													
													<INPUT type="checkbox" name="answer2" value="C" disabled >C
												</TD>
												<TD>	��java��һ���಻��ͬʱ�̳�һ�����ʵ��һ���ӿ�
												</TD>
											</TR>
											<TR>
												<TD>	&nbsp;
												</TD>
												<TD>													
													<INPUT type="checkbox" name="answer1" value="D" disabled >D
												</TD>
												<TD>	java�ĵ�һ�̳�ʹ������ɿ�
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
		<TR>
			<TD width="100%">
				<TABLE border="1" cellspacing="0" cellpadding="0" width="100%">
					<TR>
						<TD class="QuestionTitle">
							<TABLE border="0" width="100%" height="20">
								<TR>
									<TD width="1%">	&nbsp;
									</TD>
									<TD><STRONG>��3��</STRONG>
									</TD>
									<TD width="60">										
										�÷�<INPUT type="text" name="question1" value="" size="5" >
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
												<PRE>
int i=1,j=10; 
do
{ 
	if(i>j)continue; 
	j--; 
}
while(++i<6); 
i��j��ֵ�ֱ���ʲô��</PRE>
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
													<INPUT type="checkbox" name="answer3" value="A" checked disabled >A
												</TD>
												<TD>	i=6,j=5
												</TD>
											</TR>
											<TR>
												<TD>	&nbsp;
												</TD>
												<TD>													
													<INPUT type="checkbox" name="answer3" value="B" disabled >B
												</TD>
												<TD>	i=5,j=5
												</TD>
											</TR>
											<TR>
												<TD>	&nbsp;
												</TD>
												<TD>													
													<INPUT type="checkbox" name="answer3" value="C" checked disabled >C
												</TD>
												<TD>	i=6,j=4
												</TD>
											</TR>
											<TR>
												<TD>	&nbsp;
												</TD>
												<TD>													
													<INPUT type="checkbox" name="answer3" value="D" checked disabled >D
												</TD>
												<TD>	i=5,j=6
												</TD>
											</TR>
											<TR>
												<TD>	&nbsp;
												</TD>
												<TD>													
													<INPUT type="checkbox" name="answer3" value="E" disabled >E
												</TD>
												<TD>	i=6,j=6
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
		<TR>
			<TD width="100%">
				<TABLE border="1" cellspacing="0" cellpadding="0" width="100%">
					<TR>
						<TD class="QuestionTitle">
							<TABLE border="0" width="100%" height="20">
								<TR>
									<TD width="1%">	&nbsp;
									</TD>
									<TD><STRONG>��4��</STRONG>
									</TD>
									<TD width="60">										
										�÷�<INPUT type="text" name="question1" value="" size="5" >
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
												<TD>	������ڼ̳е���Щ��������ȷ�ģ�
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
													<INPUT type="checkbox" name="answer4" value="A" disabled >A
												</TD>
												<TD>	��java��ֻ������һ�̳�
												</TD>
											</TR>
											<TR>
												<TD>	&nbsp;
												</TD>
												<TD>													
													<INPUT type="checkbox" name="answer4" value="B" disabled >B
												</TD>
												<TD>	��java��һ����ֻ��ʵ��һ���ӿ�
												</TD>
											</TR>
											<TR>
												<TD>	&nbsp;
												</TD>
												<TD>													
													<INPUT type="checkbox" name="answer4" value="C" disabled >C
												</TD>
												<TD>	��java��һ���಻��ͬʱ�̳�һ�����ʵ��һ���ӿ�
												</TD>
											</TR>
											<TR>
												<TD>	&nbsp;
												</TD>
												<TD>													
													<INPUT type="checkbox" name="answer4" value="D" disabled >D
												</TD>
												<TD>	java�ĵ�һ�̳�ʹ������ɿ�
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
	</TABLE>
</BODY>
</HTML>