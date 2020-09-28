package com.wa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wa.entity.wauser;
import com.wa.service.waserviceinterface;
import com.wa.utility.ServiceFactory;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		
		wauser iu=new wauser();
		iu.setName(name);
		iu.setEmail(email);
		iu.setPassword(password);
		iu.setAddress(address);

		
		
		waserviceinterface s=ServiceFactory.createObject("adminservice");
		int i=s.createprofileservice(iu);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		if(i>0) {
		out.println("Registration successful   <a href=Logic.html>Continue...</a>");
		out.println("your name is"+ name);
		out.println("<br>your password is"+ password);
		}
		out.println("</body></html>");
	}
	}


