<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet" type="text/css" href="./css/styles.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
<script type="text/javascript" src="./js/bootstrap.js"></script>

</head>
<body>
<nav class="navbar overlay">
	<ul class="navbar-nav mr-auto">
		<li class="nav-item active ">
			<a href="listPosts" class="btn btn-primary">Job Postings</a>
			<a href="listExp?username=<s:property value='#session.username'/>" class="btn btn-primary" >Experience</a>
			<a href="listQual?username=<s:property value='#session.username'/>" class="btn btn-primary" >Qualification</a>
			<a href="profile?username=<s:property value="#session.username"/>" class="btn btn-primary">Profile</a>
			<a href="search.jsp" class="btn btn-primary">Search Users</a>
			<a href="logout" class="btn btn-warning">Logout</a>
		</li>
	</ul>
	
</nav>

</body>
</html>