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

import com.google.bean.UserBean;
import com.google.dao.UserDao;
import com.google.util.DbConnection;
import com.google.util.Validations;

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
		UserBean userBean = new UserBean();

		System.out.println("firstName => " + firstName);
		System.out.println("email => " + email);
		System.out.println("password => " + password);

		boolean isError = false;
		StringBuffer error = new StringBuffer("");
		if (Validations.isEmpty(firstName)) {
			isError = true;
			request.setAttribute("firstNameError", "Please Enter FirstName");
		} else if (firstName.trim().length() <= 2) {
			isError = true;
			request.setAttribute("firstNameError", "Please Enter atleast 3 characters in FirstName");
			userBean.setFirstName(firstName);
		} else {
			String alpha = "[a-zA-Z]+"; // min 1 max N
			if (firstName.matches(alpha) == false) {
				isError = true;
				request.setAttribute("firstNameError", "Please Enter Valid FirstName");
				userBean.setFirstName(firstName);
			} else {
				userBean.setFirstName(firstName);
			}
		}

		if (email == null || email.trim().length() == 0) {
			isError = true;
			request.setAttribute("emailError", "Please Enter Email");

		} else {
			userBean.setEmail(email);
		}
		if (password == null || password.trim().length() == 0) {
			isError = true;
			request.setAttribute("passwordError", "Please Enter Password");

		} else {
			userBean.setPassword(password);
		}

		// isError = true | false
		//
		request.setAttribute("user", userBean); 
		RequestDispatcher rd = null;
		if (isError) {
			// Regi.jsp

			rd = request.getRequestDispatcher("Registration.jsp");
		} else {
			// Login.jsp

			UserDao userDao = new UserDao();
			userDao.addUser(userBean);

			rd = request.getRequestDispatcher("Login.jsp");
		}

		rd.forward(request, response);

	}

	public void destroy() {
		System.out.println("RegistrationController::destroy()");
	}
}
