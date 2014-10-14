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
			<font color=black>图书管理系统-修改 </font>
		</h2>
		<input type="button" value="返回首页"
			onclick="{window.location.href='index.jsp';}" />
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
		<s:form action="login" method="post">
			<tr>
				<s:textfield id="Publisher" label="Publisher" cssStyle="width:150;"></s:textfield>
				<s:textfield id="PublishDate" label="PublishDate"
					cssStyle="width:150;"></s:textfield>
				<s:textfield id="Price" label="Price" cssStyle="width:150;"></s:textfield>
				<s:textfield id="Name" label="Name" cssStyle="width:150;"></s:textfield>
				<s:textfield id="Age" label="Age" cssStyle="width:150;"></s:textfield>
				<s:textfield id="Country" label="Country" cssStyle="width:150;"></s:textfield>
			</tr>
			<center>
				<s:iterator value="#session.authorlist" status="status">
					<input type="button" value="修改"
						onclick="{window.location.href='login!update1.action?AuthorID='+<s:property value="AuthorID"/>+'&Publisher='+document.getElementById('Publisher').value+'&PublishDate='+document.getElementById('PublishDate').value+'&Price='+document.getElementById('Price').value+'&Name='+document.getElementById('Name').value+'&Age='+document.getElementById('Age').value+'&Country='+document.getElementById('Country').value;}" />
				</s:iterator>
			</center>
		</s:form>
	</center>
</body>
</html>