<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>图书信息界面</title>

</head>

<body>
	<center>
		<h2>
			<font color=red>图书管理 </font>
		</h2>
		<input type="button" value="返回"
					onclick="{window.location.href='index.jsp';}"/>
	<table border="1" align="center">
		<tr>
			<td colspan="4" align="center" bgcolor="white">图书信息列表</td>
		</tr>
		<tr>
			<td align="center" bgcolor="white">Title</td>
			<td colspan="2" align="center" bgcolor="white">操作</td>
		</tr>
		<tr>
			<td align="center" bgcolor="white">Title</td>
			<td colspan="2" align="center" bgcolor="white">操作</td>
		</tr>
		<s:iterator value="#session.booklist" status="status">
			<tr>
				<td width="150" align="center"
					onclick="{window.location.href='login!query.action?AuthorID='+<s:property value="AuthorID"/>+'&ISBN='+<s:property value="ISBN"/>}">
					<s:property value="Title" /></td>
				<td><input type="button" value="删除"
					onclick="if(window.confirm('确定要删除[<s:property value="Title"/>]吗?')==true){window.location.href='login!del.action?AuthorID='+<s:property value="AuthorID"/>+'&ISBN='+<s:property value="ISBN"/>}">
				</td>
				<td><input type="button" value="修改"
					onclick="{window.location.href='login!update.action?AuthorID='+<s:property value="AuthorID"/>+'&ISBN='+<s:property value="ISBN"/>}">
				</td>
			</tr>
		</s:iterator>
		
		</table>
		</center>
</body>
</html>