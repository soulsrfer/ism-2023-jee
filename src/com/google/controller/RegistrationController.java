package com.google.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.util.DbConnection;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	public void init() {
		System.out.println("RegistrationController::init()");
	}

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
			request.setAttribute("firstNameError", "Please Enter FirstName");
		} else if (firstName.trim().length() <= 2) {
			isError = true;
			request.setAttribute("firstNameError", "Please Enter atleast 3 characters in FirstName");
			request.setAttribute("firstNameValue", firstName);
		} else {
			String alpha = "[a-zA-Z]+"; // min 1 max N
			if (firstName.matches(alpha) == false) {
				isError = true;
				request.setAttribute("firstNameError", "Please Enter Valid FirstName");
				request.setAttribute("firstNameValue", firstName);
			}else {
				request.setAttribute("firstNameValue", firstName);
			}
		}

		if (email == null || email.trim().length() == 0) {
			isError = true;
			 request.setAttribute("emailError","Please Enter Email");

		}else {
			request.setAttribute("emailValue", email);
		}
		if (password == null || password.trim().length() == 0) {
			isError = true;
			request.setAttribute("passwordError","Please Enter Password");

		}else {
			request.setAttribute("passwordValue", password);
		}

		// isError = true | false
		//
		RequestDispatcher rd = null;
		if (isError) {
			// Regi.jsp
			 
			rd = request.getRequestDispatcher("Registration.jsp");
		} else {
			// Login.jsp
			
			try {
				//store into database 
				Connection con = DbConnection.getConnection();
				//sql 
				//Statement
				//PreparedStatement
				//CallableStatement 
				PreparedStatement pstm = con.prepareStatement("insert into users (firstName,email,password) values (?,?,?) ");
				pstm.setString(1,firstName);
				pstm.setString(2, email);
				pstm.setString(3, password);
	
				int record = pstm.executeUpdate(); //db -> 	1 -> inserted , updated , deleted 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			rd = request.getRequestDispatcher("Login.jsp");
		}

		rd.forward(request, response);

	}

	public void destroy() {
		System.out.println("RegistrationController::destroy()");
	}
}
