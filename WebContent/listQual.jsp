<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Qualification</title>
</head>
<body>
<s:include value="topBarMenu.jsp"/>
	<div class="overlay text-color mt-2 container">
	Your Qualifications
	<s:if test="noData==false">
	
		<table style="width:100%;">
			<thead>
				<tr>
					<th>Sr. No.</th>
					<th>School Name</th>
					<th>Specialization</th>
					<th>Graduation Year</th>
				</tr>
			</thead>
			<s:iterator value="qualList">
				<tr>
					<td><s:property value="srNo"/></td>
					<td><s:property value="schoolName"/></td>
					<td><s:property value="specialization"/></td>
					<td><s:property value="gradYear"/></td>
					<td>
						<a href="updateQual.action?submitType=update&qualId=<s:property value='id'/>
								&username=${sessionScope.username}
								&schoolName=<s:property value='schoolName'/>
								&specialization=<s:property value='specialization'/>
								&gradYear=<s:property value='gradYear'/>">
							<button class="btn btn-warning">Edit</button>
						</a>
						<a href="deleteQual?qualId=<s:property value='id'/>&username=${sessionScope.username}">
							<button class="btn btn-danger">Delete</button>
						</a>
					</td>
				</tr>
			</s:iterator>
		</table>
		<a href=addQual.jsp>
			<button class="btn btn-success">Add Qualification</button>
		</a>
	</s:if>
	<s:else>
		
		<a href=addQual.jsp>
			<button class="btn btn-success">Add Qualification</button>
		</a>
		<div  style="color: red;">No Data is found</div>
	</s:else>
	<s:if test="msg!= null">
		<span style="color:green;"><s:property value="msg"/></span>
	</s:if>
	</div>

</body>
</html>