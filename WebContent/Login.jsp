<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Date" session="false"  autoFlush="true" info="this is demo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
<body>

<%=new Date() %>
 
 <c:if test="${cookie.firstName != null}">
 	<c:redirect url="Home.jsp"></c:redirect>
 </c:if>
  	
	

	


	<form action="AuthenticationController" method="post">

		<br> <br> Email:<input type="text" name="email" /> <br>
		<br> Password:<input type="text" name="password" /> <br> <br>
		<input type="submit" value="Login" />
	</form>
	<br> ${error}
</body>
</html>