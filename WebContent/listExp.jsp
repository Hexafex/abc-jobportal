<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Experience</title>
</head>
<body>
<s:include value="topBarMenu.jsp"></s:include>
<div class="overlay text-color mt-2 container">
Your Experiences
<input type="hidden" name="username" value="${sessionScope.username}">
	<s:if test="noData==false">
		<table style="width:100%;">
			<thead>
				<tr>
					<th>Sr. No.</th>	
					<th>Job Title</th>
					<th>Company Name</th>
					<th>Years of Experience</th>
				</tr>
			</thead>
			<s:iterator value="expList">
				<tr>
					<td><s:property value="srNo"/></td>					
					<td><s:property value="jobTitle"/></td>
					<td><s:property value="companyName"/></td>
					<td><s:property value="yearsOfExp"/></td>
					<td>
						<a href="updateExp?submitType=update
								&expId=<s:property value='id'/>
								&username=${sessionScope.username}
								&jobTitle=<s:property value='jobTitle'/>
								&companyName=<s:property value='companyName'/>
								&yearsOfExp=<s:property value='yearsOfExp'/>">
							<button class="btn btn-warning">Update</button>
						</a>
						<a href="deleteExp?expId=<s:property value='id'/>&username=${sessionScope.username}">
							<button class="btn btn-danger">Delete</button>
						</a>
					</td>
				</tr>
			</s:iterator>
		</table>
		<a href=addExp.jsp>
			<button class="btn btn-success">Add Experience</button>
		</a>
	</s:if>
	<s:else>
		<div  style="color: red;">No Data is found</div>
	</s:else>
	<s:if test="msg!= null">
		<span style="color:green;"><s:property value="msg"/></span>
	</s:if>
</div>

</body>
</html>