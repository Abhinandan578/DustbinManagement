<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>List-users</title>

<!-- link jsp page with css style -->
	<link type="text/css"
	 rel="stylesheet"
	 href="${pageContext.request.contextPath}/resources/css/style.css" />
	 
	 <link type="text/css"
	 rel="stylesheet"
	 href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>

<body>
	
	<div id="wrapper">
	
		<div id="header">
			<h2>LIST OF COLLECTORS</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		<!-- add button -->
		<input type="button" value="Add User"
			onclick="window.location.href='showFormForAdd'; return false;" 
			class="add-button"/>
			<table>
			 <tr>
				<th>Name</th>
				<th>Type</th>
				<th>Dustbin Id</th>
			 </tr>
			
			 <c:forEach var="temp" items="${user}">
			   lala
				<tr>
					<td>${temp.name}</td>
					<td>${temp.typeOfUser}</td>
					<td>${temp.dustbinId}</td>
				
				</tr>
			 </c:forEach>
			
			</table>
		</div>
	
	</div>
	
</body>

</html>