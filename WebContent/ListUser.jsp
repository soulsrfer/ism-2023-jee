<%@page import="com.google.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

	<%
		int a = 90;
		int b = 0;
		int c = a / b;
	%>

	<%
		ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("users");
	%>


	<table border="1">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>Email</th>
			<th>Password</th>
			<th>Action</th>
		</tr>

		<%
			for (UserBean user : users) {
		%>


		<tr>
			<td><%=user.getUserId()%></td>
			<td><%=user.getFirstName()%></td>
			<td><%=user.getEmail()%></td>
			<td><%=user.getPassword()%></td>
			<td><a href="DeleteUserController?userId=<%=user.getUserId()%>">Delete</a></td>
		</tr>
		<%
			}
		%>


	</table>
	<Br>
	<BR>

	<table border="1">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>Email</th>
			<th>Password</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.userId}</td>
				<td>${user.firstName}</td>
				<td>${user.email}</td>
				<td>${user.password}</td>
				<td><a href="DeleteUserController?userId=${user.userId}">Delete</a>
					| <a href="ViewUserController?userId=${user.userId}">View</a> | <a
					href="EditUserController?userId=${user.userId}">Edit</a></td>
			</tr>
		</c:forEach>


	</table>
	<Br>
	<BR>


</body>
</html>