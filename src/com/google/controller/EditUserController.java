package com.google.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.bean.UserBean;
import com.google.dao.UserDao;

public class EditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer userId = Integer.valueOf(request.getParameter("userId"));

		UserDao userDao = new UserDao();

		UserBean user = userDao.getUserById(userId);

		request.setAttribute("user", user);
		request.getRequestDispatcher("EditUser.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String firstName = request.getParameter("firstName");// null
		String email = request.getParameter("email");
		Integer userId = Integer.valueOf(request.getParameter("userId"));

		UserBean userBean = new UserBean();
		
		userBean.setFirstName(firstName);
		userBean.setEmail(email);
		userBean.setUserId(userId);

		new UserDao().updateUser(userBean);
		//jsp 
		//servlet 
		response.sendRedirect("ListUsersController");
	}

}
