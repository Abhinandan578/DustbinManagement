<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<center>Welcome ${loggedInUser}</center>
	<center>Admin</center>
	
	<table>
					
					<tr>
								<td><input type="button"  value="View Collector"
		onclick="window.location.href='listCollector'; return false;" /></td>
								<td><input type="button"  value="View Caretaker"
		onclick="window.location.href='listCareTaker'; return false;" /></td>						
					</tr>
	</table>
	
	
</body>
</html>
