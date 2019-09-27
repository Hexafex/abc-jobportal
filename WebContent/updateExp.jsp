<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Experience</title>
</head>
<body>
<s:include value="topBarMenu.jsp"></s:include>

	<div class="overlay text-color mt-2 container">
		Update Experience
		<s:form action="updateExp">
			<s:hidden value="%{exp.username}" key="exp.username"/>
			<s:hidden value="%{expId}" key="exp.id"/>
			
			<s:textfield key="exp.jobTitle" 	name="exp.jobTitle" 	label="Job Title" />
			<s:textfield key="exp.companyName"  name="exp.companyName" 	label="Company Name" />
			<s:textfield key="exp.yearsOfExp" 	name="exp.yearsOfExp" 	label="Years of Exp" />
			<s:submit/>
		
		</s:form>
		
		<span style="color:green;">
			<s:property value="msg"/>
		</span>
	</div>

</body>
</html>