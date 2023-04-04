<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>

	<form action="AuthenticationController" method="post">

		<br> <br> Email:<input type="text" name="email" /> <br>
		<br> Password:<input type="text" name="password" />    <br>
		<br> <input type="submit" value="Login" />
	</form>
	<br> ${error}
</body>
</html>