package com.google.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.google.util.Validations;

public class RegistrationRegexFilter implements Filter{

	public void destroy() {
		System.out.println("RegistartionRegexFilter::destroy()");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("RegistartionRegexFilter::doFilter()");
		String firstName = request.getParameter("firstName");// null
		 
		
		boolean isError = false; 
		
		if(Validations.isAlpha(firstName) == false) {
			isError=true;
			request.setAttribute("firstNameError", "Please Enter Valid FirstName");
		}
	
		if(isError) {
			request.getRequestDispatcher("Registration.jsp").forward(request, response); 
		}else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("RegistartionRegexFilter::init()");
	}

}
