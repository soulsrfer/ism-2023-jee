package com.google.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupController  extends HttpServlet {

	
	public void service(HttpServletRequest request,HttpServletResponse  response){
		System.out.println("SignupController");
		
		String firstName = request.getParameter("firstName");//null
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println("firstName => "+firstName);
		System.out.println("email => "+email);
		System.out.println("password => "+password);
		
		//response
	}
}
