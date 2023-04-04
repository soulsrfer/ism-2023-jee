<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<%
		String firstNameError = (String) request.getAttribute("firstNameError");
		String emailError = (String) request.getAttribute("emailError");
		String passwordError = (String) request.getAttribute("passwordError");
	%>


	<form action="RegistrationController" method="post">
		FirstName :<input type="text" name="firstName"
			value="${user.firstName}" /> <span class="error"><%=firstNameError == null ? "" : firstNameError%></span>

		<br> <br> Email:<input type="text" name="email"
			value="${user.email}" /> <span class="error"><%=emailError != null ? emailError : ""%></span>

		<br> <br> Password:<input type="text" name="password" /> <span
			class="error"><%=passwordError == null ? "" : passwordError%></span>

		<br> <br> <input type="submit" value="Signup" />
	</form>
	<br>


	<%!public void jspInit() {

	}%>
</body>
</html>