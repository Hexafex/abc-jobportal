<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
</head>
<body>
<s:include value="topBarMenu.jsp"></s:include>
<div class="overlay text-color mt-2 container">
	<s:form action="updateUser" method="post" theme="xhtml" >
	<s:hidden name="usernamehidden" value="%{#session.username}"/>
		<s:textfield label="First Name" name="user.firstName" title="first name must be at least 2 characters long" />
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
	<s:submit value="Update" class="btn btn-success" style="margin-left:40%;"/>
	</s:form>
<span>
 <s:property value="msg"/>
</span>
</div>
	

</body>
</html>