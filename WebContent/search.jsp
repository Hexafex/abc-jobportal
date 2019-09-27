<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix ="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<link rel="stylesheet" type="text/css" href="./css/styles.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">
</head>
<body>
<s:include value="topBarMenu.jsp"/>
	<s:if test="noData==false">
		<div class="overlay">
		<s:form action="search" method="post" theme="simple">
		
			<input type="text" name="username" placeholder="Search">
			<s:hidden type="text" name="firstName" value="%{username}"/>
			<s:hidden type="text" name="lastName" value="%{username}"/>
			<s:hidden type="text" name="country" value="%{username}"/>
			<s:submit value ="Search" class="btn btn-info"/>
		</s:form>
		
		 	<table>			 	
			 		<tr>
			 			<th>Username</th>
			 			<th>First name</th>
			 			<th>Last name</th>
			 			<th>Country</th>
			 		</tr>			 	
			 	<s:iterator value="userList">
			 		<tr>
			 			<td><s:property value="username"/></td>
			 			<td><s:property value="firstName"/></td>
			 			<td><s:property value="lastName"/></td>
			 			<td><s:property value="country"/></td>
			 		</tr>			 	
			 	 </s:iterator>
		 	</table>
		</div>
	</s:if>
	<s:else>
		<s:form action="search" method="post" theme="simple">
		
			<input type="text" name="searchTerm" placeholder="Search">
			<s:submit value ="Search" class="btn btn-info"/>
		</s:form>
	<div style="color:red;">
		Please search something
	</div>
	</s:else>
</body>
</html>