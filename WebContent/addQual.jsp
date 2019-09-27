<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Qualification</title>
</head>
<body>
<s:include value="topBarMenu.jsp"></s:include>
<div class="overlay text-color mt-2 container">
Add Qualification
<s:form action="addQual" method="post">
<s:hidden label="Username" key="qual.username" value="%{#session.username}"/>

	<s:textfield label="School Name" name="qual.schoolName" key="qual.schoolName"/>
	<s:textfield label="Specialization" name="qual.specialization" key="qual.specialization"/>
	<s:textfield label="Graduation year" name="qual.gradYear" key="qual.gradYear"/>
<s:submit value="Add Qualification"/>
</s:form>
</div>

</body>
</html>