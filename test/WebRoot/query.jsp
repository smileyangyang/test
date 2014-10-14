<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>查询所以信息界面</title>
<title>查询所以信息界面</title>
<title>查询所以信息界面</title>
</head>

<body>
<center>
		<h2>
			<font color=red>图书管理系统 </font>
		</h2>
		<input type="button" value="返回首页"
					onclick="{window.location.href='index.jsp';}"/>
	<table border="1" align="center">
		<tr>
			<td colspan="6" align="center" bgcolor="white">图书信息</td>
		</tr>
		<tr>
			<td align="center" bgcolor="white">ISBN</td>
			<td align="center" bgcolor="white">Title</td>
			<td align="center" bgcolor="white">AuthorID</td>
			<td align="center" bgcolor="white">Publisher</td>
			<td align="center" bgcolor="white">PublishDate</td>
			<td align="center" bgcolor="white">Price</td>
		</tr>
		<s:iterator value="#session.booklist" status="status">
			<tr>
				<td width="150" align="center"><s:property value="ISBN" />
				<td width="150" align="center"><s:property value="Title" />
				<td width="114" align="center"><s:property value="AuthorID" />
				<td width="173" align="center"><s:property value="Publisher" />
				<td width="173" align="center"><s:property value="PublishDate" />
				<td width="173" align="center"><s:property value="Price" />
			</tr>
		</s:iterator>
	</table>
	<table border="1" align="center">
		<tr>
			<td colspan="4" align="center" bgcolor="white">作者信息</td>
		</tr>
		<tr>
			<td align="center" bgcolor="white">AuthorID</td>
			<td align="center" bgcolor="white">Name</td>
			<td align="center" bgcolor="white">Age</td>
			<td align="center" bgcolor="white">Country</td>
		</tr>
		<s:iterator value="#session.authorlist" status="status">
			<tr>
				<td width="150" align="center"><s:property value="AuthorID" />
				<td width="150" align="center"><s:property value="Name" />
				<td width="114" align="center"><s:property value="Age" />
				<td width="173" align="center"><s:property value="Country" />
			</tr>
		</s:iterator>
	</table>
</body>
</html>