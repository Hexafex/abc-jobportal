<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
<link rel="stylesheet" type="text/css" href="./css/styles.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
</head>
<body>
<div class="overlay container col-sm-4 col-sm-4 col-sm-4">
<span style="color:red;">
	<s:property value="msg"/>
</span>
<div style="color:red;font-size:24px; text-align:center;">Please confirm your details</div>
<div>
	<s:form action="addUser" method="post" theme="xhtml">
		<s:textfield label="First Name" name="user.firstName" title="First name must be at least 2 characters long" />
		<s:textfield label="Last Name" name="user.lastName" />
		<s:textfield label="Username" name="user.username" />
		<s:textfield label="Email" name="user.email" />
		<s:textfield label="Password" type="password" name="user.password" />
		<s:textfield label="Country" name="user.country" />
		<s:textfield label="City" name="user.city" placeholder="(optional)" />
		<s:textfield label="State" name="user.state" placeholder="(optional)" />
		<s:textfield label="Postal Code" name="user.postalCode" />
		<s:textfield label="Birth Date" name="user.birthDate" />
		<s:textfield label="Birth Month" name="user.birthMonth" />	
	<s:submit value="Confirm" class="btn btn-success"/>
	</s:form>
	</div>
</div>
</body>
</html>