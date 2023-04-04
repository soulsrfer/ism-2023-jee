package com.google.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.bean.UserBean;
import com.google.dao.UserDao;

@WebServlet("/AuthenticationController")
public class AuthenticationController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserBean user = new UserDao().authenticate(email, password);
		RequestDispatcher rd = null;
		if (user == null) {
			//
			request.setAttribute("error", "Please Enter Valid Credentials..");
			rd = request.getRequestDispatcher("Login.jsp");

		} else {
			rd = request.getRequestDispatcher("Home.jsp");
		}
		rd.forward(request, response);
	}

}
