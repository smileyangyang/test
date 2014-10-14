<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>图书管理系统</title>
<title>图书管理</title>
</head>
<body>
	<center>
		<h2>
			<font color=black>图书管理</font>
		</h2>
		<h3>
			<font color=black>图书管理系统 </font>
		</h3>
		<input type="button" value="增加书籍"
					onclick="{window.location.href='AddBook.jsp';}"/>
		<s:form action="login" method="post">
			<s:textfield name="name" label="作者姓名" cssStyle="width:150;"></s:textfield>
			<td width="80" align="center"><s:submit value="查找" theme="simple"></s:submit>
			<td width="150" align="center"><s:reset value="清空" theme="simple"></s:reset>
		</s:form>
		<br /> <font color=red> <s:property value="msg" />
		 </font>
	</center>
</body>
</html>