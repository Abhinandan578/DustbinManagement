<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>List-customers</title>

<!-- link jsp page with css style -->
	<link type="text/css"
	 rel="stylesheet"
	 href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
	
	<div id="wrapper">
	
		<div id="header">
			<h2>LIST OF CARE-TAKERS</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		<!-- add button -->
		<input type="button" value="Add Customer"
			onclick="window.location.href='showFormForAdd'; return false;" 
			class="add-button"/>
			<table>
			 <tr>
				<th>Name</th>
				<th>LastName</th>
				<th>Email</th>
			 </tr>
			
			 <c:forEach var="temp" items="${users}">
			
				<!-- update link -->
				<c:url var="updateLink" value="/user/showFormForUpdate">
				
					<c:param name="customerId" value="${temp.id}" />
				
				</c:url>
				
				<c:url var="deleteLink" value="/customer/delete">
				
					<c:param name="customerId" value="${temp.id}" />
				
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