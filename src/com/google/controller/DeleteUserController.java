package com.google.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.dao.UserDao;

public class DeleteUserController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer userId = Integer.parseInt(request.getParameter("userId"));
		new UserDao().deleteUser(userId);
				//
		
		response.sendRedirect("ListUsersController");
	

	}

}
