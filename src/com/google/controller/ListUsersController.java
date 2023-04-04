package com.google.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.bean.UserBean;
import com.google.dao.UserDao;

public class ListUsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// getAllUsers();
		ArrayList<UserBean> users = new UserDao().getAllUsers();
		request.setAttribute("users", users);
		
		request.getRequestDispatcher("ListUser.jsp").forward(request, response);
	}

}
