<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="./css/styles.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
</head>
<body>
<div class="col-sm-4 col-sm-4 col-sm-4 container">
	<img alt="Portal logo" src="./assets/ABC JOBPORTAL LOGO.png">
</div>
<div class="overlay text-color col-sm-4 col-sm-4 col-sm-4 container" style="margin-top:150px;">


	<div class="row" style="font-size:32px;">
		<div class="col-sm-12" style="text-align:center">Login</div>
	</div>

	<s:form action="login" theme="simple" class="form" method="post">
	
	<div class="mt-1">
		<label>Username:</label>
		<s:textfield label="Username" name="user.username" placeholder="Username"/> 
		<br/>
		<label>Password:</label>
		<s:password label="Password" name="user.password" placeholder="Password" class="ml-1"/>
	</div>	
	<div class="row">
		<div class="mb-1 col-sm-4 mr-2">
			<s:a href="registration.jsp"><button type="button" class="btn btn-warning">Sign up</button></s:a>
			</div>
		<div class="col-sm-4 ml-2">
			<button type="submit" class="btn btn-success">Login</button>
		</div>
	</div>
		
	<div class="row">
		<div class="col-sm-12">
			<a href=forgetpw.jsp>Forget Password?</a>
		</div>
	</div>
	</s:form>
	<s:if test="ctr>0">
		<span style="color:green;">
			<s:property value="msg"/>
		</span>
	</s:if>
	<s:else>
	<span style="color:red;">
			<s:property value="msg"/>
		</span>
	</s:else>
</div>
</body>
</html>