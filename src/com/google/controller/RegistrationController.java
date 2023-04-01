package com.google.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");// null
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		System.out.println("firstName => " + firstName);
		System.out.println("email => " + email);
		System.out.println("password => " + password);

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

		// isError = true | false
		//
		RequestDispatcher rd = null;
		if (isError) {
			// Regi.jsp
			request.setAttribute("error", error.toString()); 
			rd = request.getRequestDispatcher("Registration.jsp");
		} else {
			// Login.jsp
			rd = request.getRequestDispatcher("Login.jsp");
		}

		rd.forward(request, response);
		
	}
}
