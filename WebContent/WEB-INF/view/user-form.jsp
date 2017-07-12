<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title> Save User </title>
	<link type = "text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
		
		<link type = "text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>

<body>
	
	<div id="container">
		
		<h3>Save customer</h3>
		<form:form action = "saveUser" modelAttribute="user" method = "POST" >
		<form:hidden path="id" />
		<table>
			<tbody>
			
					
			
					<tr>
					<td><label> Dustbin : </label></td>
					<td><form:input path="dustbinId"/></td>
					</tr>
					
					<tr>
				
				
					<td><label> Name : </label></td>
					<td><form:input path="name"/></td>
					
					</tr>
					
					<tr>
					<td><label> Password : </label></td>
					<td><form:input path="passwordUser"/></td>
					
					</tr>
					
					<tr>
					<td><label> Type Of User : </label></td>
					<td><form:input path="typeOfUser"/></td>
					</tr>
					
					
					<tr>
					<td><label></label></td>
					<td><input type="submit" value="save" class="save"/></td>
					</tr>
					
			</tbody>
		</table>	
		
		<div></div>
		
		<p>
		
		<a href="${pageContext.request.contextPath}/listController">Back to List</a>
		
		</p>
		
		</form:form>
	
	</div>
</body>

</html>