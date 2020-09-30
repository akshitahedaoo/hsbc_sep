package com.facebook2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebook2.entity.facebook2user;
import com.facebook2.service.facebook2serviceinterface;
import com.facebook2.utility.ServiceFactory;

/**
 * Servlet implementation class RegistrationServlet111
 */
public class RegistrationServlet111 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet111() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String  name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		
		facebook2user f=new facebook2user();
		f.setAddress(address);
		f.setEmail(email);
		f.setName(name);
		f.setPassword(password);
		
		facebook2serviceinterface s=ServiceFactory.createObject("adminservice");
		int i1=s.createprofileservice(f);
		
		int i=s.checkemail(f);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		
		if(i1>0) {
		out.println("Registration successful   <a href=Login.html>Continue...</a>");
		out.println("your name is"+ name);
		out.println("<br>your password is"+ password);
		}
		out.println("</body></html>");
	}
	}

