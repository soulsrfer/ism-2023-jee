package com.google.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			// cookie name
			// session userid
			System.out.println(user.getFirstName());

			Cookie c = new Cookie("firstName", user.getFirstName());
			c.setMaxAge(60 * 60 * 24 * 7);// second
			response.addCookie(c);

			HttpSession session = request.getSession(); // new | old
			session.setAttribute("userId", user.getUserId());

			session.setMaxInactiveInterval(60 * 5);// 5 minute

			String url = response.encodeRedirectURL("Home.jsp");
			System.out.println("this is encoded url =>" + url);

			rd = request.getRequestDispatcher(url);
		}

		rd.forward(request, response);
	}

}
