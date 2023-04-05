<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>


	<form action="EditUserController" method="post">
		<input type="hidden" name="userId" value="${param.userId}"/>
		FirstName :<input type="text" name="firstName"
			value="${user.firstName}" /> <br> <br> Email:<input
			type="text" name="email" value="${user.email}" /> <br> <br>
		<input type="submit" value="Update" />
	</form>
	<br>

</body>
</html>