<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Experience</title>
</head>

<body>
<s:include value="topBarMenu.jsp"></s:include>
<div class="overlay text-color mt-2 container">
Add new Experience
<s:form action="addExp" method="post">

<s:hidden label="Username" key="exp.username" value="%{#session.username}"/>
	<s:textfield label="Job Title" name="exp.jobTitle"/>
	<s:textfield label="Company Name" name="exp.companyName"/>
	<s:textfield label="Years of Experience" name="exp.yearsOfExp"/>
<s:submit value="Add Exp"/>
</s:form>
</div>

</body>
</html>