<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><s:property value="postTitle"/></title>
</head>
<body>
<s:include value="topBarMenu.jsp"></s:include>
<hr>
<s:iterator value="jp">
	<table class="overlay">
		<tr>
			<td>
				<s:property value="postContent"/>
			</td>
		</tr>
	</table>
</s:iterator>
<hr>
<s:iterator value="commentList">
<table class="overlay">
		<tr>
			<td>
				<s:property value="username"/>
			</td>
			<td>
				<s:property value="msgContent"/>
			</td>
		</tr>
	</table>
	<hr>
</s:iterator>
<s:form action="addComment">
	<s:textfield name="comment.msgContent" label="Comment" placeholder="Type comment here"></s:textfield>
	<s:hidden  name="comment.username" value="%{jp.username}"/>
	<s:hidden name="postId" value="%{postId}"/>
	<s:submit/>
</s:form>
</body>
</html>