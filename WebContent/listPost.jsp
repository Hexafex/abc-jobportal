<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Postings</title>
</head>
<body>
<s:include value="topBarMenu.jsp"></s:include>
<div class="overlay text-color mt-2 container"> 
<s:if test="noData==false">
		<table style="width:100%;">
			<thead>
				<tr>					
					<th>Post Title</th>			
				</tr>
			</thead>
			<s:iterator value="jobList">
				<tr>					
					<td>
						<a href="showPost?postId=<s:property value ='id'/>&username=${session.username}">
							<s:property value="postTitle"/>
						</a>
					</td>
					<td>
						<s:if test="username==#session.username">
						
						 	<a href="updatePost?submitType=update&postId=<s:property value='id'/>
						 			&username=${session.username}">
								<button class="btn btn-warning">Edit</button>
							</a>
							<a href="deletePost?postId=<s:property value='id'/>&username=${session.username}">
								<button class="btn btn-danger">Delete</button>
							</a>
							
						</s:if>
					</td>
				</tr>
			</s:iterator>
		</table>
		<a href=addPost.jsp>
			<button class="btn btn-success">Add Post</button>
		</a>
	</s:if>
	<s:else>
		
		<div  style="color: red;">There are currently no posts.</div>
		<a href=addPost.jsp>
			<button class="btn btn-success">Add Post</button>
		</a>
	</s:else>
	<s:if test="msg!=null">
		<span>
			<s:property value="msg"/>
		</span>
	</s:if>
</div>

	
	
</body>
</html>