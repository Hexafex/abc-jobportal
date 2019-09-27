<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><s:property value="msg"/></title>
<link rel="stylesheet" type="text/css" href="./css/styles.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
</head>
<body>
<div class="overlay container col-sm-3 col-sm-6 col-sm-3 register">
	<span style="color:green;font-size:18px;">
			<s:property value="msg"/>	
	</span>
	<div>
		<a href="/Jobportal/">Please Click here to Login</a>
	</div>
</div>
</body>
</html>