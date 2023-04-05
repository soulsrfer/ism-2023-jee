package com.google.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.bean.UserBean;
import com.google.dao.UserDao;

public class ViewUserController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer userId = Integer.valueOf(request.getParameter("userId"));

		UserDao userDao = new UserDao();

		// dao -> parameter | return ?
		// parameter -> userId

		UserBean user = userDao.getUserById(userId);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("ViewUser.jsp").forward(request, response);
	}

}
