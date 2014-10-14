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
			<font color=black>添加图书</font>
		</h3>
		<s:form action="login" method="post">
			<tr>
				<s:textfield id="ISBN" label="ISBN" cssStyle="width:150;"></s:textfield>
				<s:textfield id="Title" label="Title" cssStyle="width:150;"></s:textfield>
				<s:textfield id="AuthorID" label="AuthorID" cssStyle="width:150;"></s:textfield>
				<s:textfield id="Publisher" label="Publisher" cssStyle="width:150;"></s:textfield>
				<s:textfield id="PublishDate" label="PublishDate" cssStyle="width:150;"></s:textfield>
				<s:textfield id="Price" label="Price" cssStyle="width:150;"></s:textfield>
			</tr>
			<center>
			<input type="button" value="提交"
					onclick="{window.location.href='login!add.action?ISBN='+document.getElementById('ISBN').value+'&Title='+document.getElementById('Title').value+'&AuthorID='+document.getElementById('AuthorID').value+'&Pubisher='+document.getElementById('Publisher').value+'&PublishDate='+document.getElementById('PublishDate').value+'&Price='+document.getElementById('Price').value;}"/>
			</center>
		</s:form>
		</center>
</body>
</html>