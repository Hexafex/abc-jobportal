<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thank you!</title>
<link rel="stylesheet" type="text/css" href="./css/styles.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
</head>
<body>
<div class="row">
	<div class="col-sm-4 col-sm-4 col-sm-4 overlay text-color container">
		<h3>Thank you for registering with us!</h3>
		<h2><s:property value="msg"/></h2>
		<div>
			<a href="/Jobportal-remake">Please Click here to Login</a>
		</div>
	</div>
	
</div>
</body>
</html>