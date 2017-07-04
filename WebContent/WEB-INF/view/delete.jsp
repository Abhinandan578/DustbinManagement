<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c " %>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Login</title>
</head>
<body>
				<form:form id="loginForm" method="post" action ="login"  modelAttribute="user">
								
								<form:label path="id">Enter your user-name</form:label>
								<form:input id="id" name="id" path="id" ></form:input><br>
								<form:label path="password">Please enter your password</form:label>
								<form:password id="password" name="password" path="password" ></form:password><br>
								<input type="submit" value="Submit" />
								
				</form:form>		
</body>
</html>