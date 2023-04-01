<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<%
		String error = (String)request.getAttribute("error");
	%>


	<form action="RegistrationController" method="post">
		FirstName :<input type="text" name="firstName" /><br> <br>
		Email:<input type="text" name="email" /><br> <br> Password:<input
			type="text" name="password" /><br> <br> <input
			type="submit" value="Signup" />
	</form><br>
	<%=error%> 

</body>
</html>