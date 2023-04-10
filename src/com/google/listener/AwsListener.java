package com.google.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AwsListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("server::contextInit");
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("server:contextDestroy");
	}
}

//production - qa - st uat -  pre production  ->production
