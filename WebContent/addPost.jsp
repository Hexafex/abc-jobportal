<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Make a new Post!</title>
</head>
<body>
<s:include value="topBarMenu.jsp"></s:include>
<div class="overlay text-color mt-2 container">
Make a new Post!

<s:form action="addPost" method="post">
	<table>
		<tr>
			<td></td>
			<td><s:textfield label="Post Title" key="jp.postTitle"/></td>
		</tr>
		<tr>
			<td></td>
			<td><s:textarea label="Post Content" key="jp.postContent"/></td>
		</tr>
		<tr>
			<td></td>
			<td><s:hidden label="Username" key="jp.username" value="%{#session.username}"/></td>
		</tr>
	</table>
	<s:submit value="Post!"/>
</s:form>
<span>
	<s:property value="msg"/>
</span>
</div>

</body>
</html>