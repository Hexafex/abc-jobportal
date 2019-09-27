<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Qualification</title>
</head>
<body>
<s:include value="topBarMenu.jsp"></s:include>
<div class="overlay text-color mt-2 container">
Update Qualification
<s:form action="updateQual">
	

	<s:hidden value="%{qual.username}" key="qual.username"/>
	<s:hidden value="%{qualId}" key="qual.id"/>
	
	
	<s:textfield key="qual.specialization" 	name="qual.specialization" 	label="Specialization" />
	<s:textfield key="qual.schoolName"  name="qual.schoolName" 	label="School Name" />
	<s:textfield key="qual.gradYear" 	name="qual.gradYear" 	label="Graduation Year" />
	<s:submit/>

</s:form>

<span style="color:green;">
	<s:property value="msg"/>
</span>
</div>

</body>
</html>