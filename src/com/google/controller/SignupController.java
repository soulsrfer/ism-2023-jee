package com.google.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupController extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("SignupController");

		String firstName = request.getParameter("firstName");// null
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		System.out.println("firstName => " + firstName);
		System.out.println("email => " + email);
		System.out.println("password => " + password);

		// response

		response.setContentType("text/html");// pdf audio video jpg html - MIME type

		PrintWriter out = response.getWriter();// IOException

		out.print("<html><body>");
		// required
		boolean isError = false;
		StringBuffer error = new StringBuffer("");
		if (firstName == null || firstName.trim().length() == 0) {
			isError = true;
			error.append("<br>Please Enter FirstName");
		} else if (firstName.trim().length() <= 2) {
			isError = true;
			error.append("<br>Please Enter atleast 3 characters in FirstName");

		} else {
			String alpha = "[a-zA-Z]+"; // min 1 max N
			if (firstName.matches(alpha) == false) {
				isError = true;
				error.append("<br>Please Enter Valid FirstName");
			}
		}

		if (email == null || email.trim().length() == 0) {
			isError = true;
			error.append("<br>Please Enter Email");

		}
		if (password == null || password.trim().length() == 0) {
			isError = true;
			error.append("<br>Please Enter Password");

		}
		if (isError == true) {
			out.print("<span style='color:red;'>" + error + "</span>");
		} else {
			out.print("FirstName => " + firstName + "<br>");
			out.print("Email => " + email + "<br>");
			out.print("Password => " + password + "<br>");
		}
		out.print("</body></html>");

	}
}
