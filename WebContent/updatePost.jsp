<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Post</title>
</head>
<body>
<s:include value="topBarMenu.jsp"></s:include>
<div class="overlay text-color mt-2 container">
Update Post

<s:form action="updatePost">
	

	<s:hidden value="%{jp.username}" key="jp.username"/>
	<s:hidden value="%{postId}" key="jp.id"/>
	
	
	<s:textfield key="jp.postTitle" 	name="jp.postTitle" 	label="Post Title" />
	<s:textfield key="jp.postContent"  name="jp.postContent" 	label="Post Content" />
	<s:submit/>

</s:form>

<span style="color:green;">
	<s:property value="msg"/>
</span>
</div>

</body>
</html>