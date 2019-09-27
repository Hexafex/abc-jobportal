<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>
<link rel="stylesheet" type="text/css" href="./css/styles.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
</head>
<body>
<div class="overlay container col-sm-3 col-sm-6 col-sm-3 register">
	<s:form action="forget">
	<div style="color:white;text-align:center;">
		<h2>Change Password</h2>
	</div>
		
		<s:textfield name="user.email" label="Email"/>
		<s:password name="user.password" label="New Password"/>
	
	<s:submit class="btn btn-success"/>
	</s:form>
	<span>
		<s:property value="msg"/>
	</span>
</div>
</body>
</html>