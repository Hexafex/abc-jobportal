<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
<s:include value="topBarMenu.jsp"/>
 

<div class="overlay text-color mt-2 col-6">
<div>My Particulars</div>

<s:a href="updateUser?submitType=update"><button>Edit Profile</button></s:a>
<s:iterator value="particulars">
	<table class="text">
		<tr>
			<th>Username:</th>
			<td><s:property value="username"/></td>
		</tr>
		
		<tr>
			<th>First Name:</th>
			<td><s:property value="firstName"/></td>
		</tr>
			
		<tr>
			<th>Last Name:</th>
			<td><s:property value="lastName"/></td>
		</tr>
			
		<tr>
			<th>Email:</th>
			<td><s:property value="email"/></td>
		</tr>
		
		<tr>
			<th>Password:</th>
			<td><s:property value="password"/></td>
		</tr>	
		<tr>
			<th>Country:</th>
			<td><s:property value="country"/></td>
		</tr>
			
		<tr>
			<th>State:</th>
			<td><s:property value="state"/></td>
		</tr>
			
		<tr>
			<th>City:</th>
			<td><s:property value="city"/></td>
		</tr>
			
		<tr>
			<th>Postal Code:</th>
			<td><s:property value="postalCode"/></td>
		</tr>
			
		<tr>
			<th>Birth Date:</th>
			<td><s:property value="birthDate"/></td>
		</tr>
			
		<tr>
			<th>Birth Month:</th>
			<td><s:property value="birthMonth"/></td>
		</tr>
		
	</table>
</s:iterator>

<span>
	<s:property value="msg"/>
</span>
</div>
</body>
</html>