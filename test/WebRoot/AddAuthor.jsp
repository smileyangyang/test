<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>查询所以信息界面</title>

</head>

<body>
<center>
		<h2>
			<font color=black>图书管理系统 </font>
		</h2>
		<input type="button" value="返回首页"
					onclick="{window.location.href='index.jsp';}"/>
		<h3>
			<font color=black>添加作者</font>
		</h3>
		<s:form action="login" method="post">
			<tr>
				<s:textfield id="AuthorID" label="AuthorID" cssStyle="width:150;"></s:textfield>
				<s:textfield id="Name" label="Name" cssStyle="width:150;"></s:textfield>
				<s:textfield id="Age" label="Age" cssStyle="width:150;"></s:textfield>
				<s:textfield id="Country" label="Country" cssStyle="width:150;"></s:textfield>
			</tr>
			<center>
			<input type="button" value="提交"
					onclick="{window.location.href='login!addauthor.action?AuthorID='+document.getElementById('AuthorID').value+'&Name='+document.getElementById('Name').value+'&Age='+document.getElementById('Age').value+'&Country='+document.getElementById('Country').value;}"/>
			</center>
		</s:form>
		</center>
</body>
</html>