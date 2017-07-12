<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>List-users</title>

<!-- link jsp page with css style -->
	<link type="text/css"
	 rel="stylesheet"
	 href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
	
	<div id="wrapper">
	
		<div id="header">
			<h2>LIST OF DUSTBIN COLLECTORS</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		<!-- add button -->
		<input type="button" value="Add Collector"
			onclick="window.location.href='showFormForAdd'; return false;" 
			class="add-button"/>
			<table>
			 <tr>
				<th>Id</th>
				<th>Name</th>
				<th>Dustbin ID</th>
			 </tr>
			
			 <c:forEach var="temp" items="${user}">
			
				<!-- update link -->
				<c:url var="updateLink" value="/user/showFormForUpdate">
				
					<c:param name="userId" value="${temp.id}" />
				
				</c:url>
				
				<c:url var="deleteLink" value="/user/delete">
				
					<c:param name="userId" value="${temp.id}" />
				
				</c:url>
				
			<tr>
				<td>${temp.id}</td>
				<td>${temp.name}</td>
				<td>${temp.dustbinId}</td>
				<td> <a href="${updateLink}">Update</a></td>
				<td> <a href="${deleteLink}"
					onclick = "if(!(confirm('Are you sure want to dlete this customer'))) return false">Delete</a></td>
				
			</tr>
			 </c:forEach>
			
			</table>
		</div>
	
	</div>
	
</body>

</html>