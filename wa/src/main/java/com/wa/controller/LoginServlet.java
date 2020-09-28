package com.wa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wa.entity.wauser;
import com.wa.service.waserviceinterface;
import com.wa.utility.ServiceFactory;



/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  name=request.getParameter("name");
		String password=request.getParameter("password");
		
		wauser iu=new wauser();
		iu.setName(name);
		iu.setPassword(password);
		
		waserviceinterface s=ServiceFactory.createObject("adminservice");
		boolean i=s.loginProfile(iu);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		if(i) {
			
			HttpSession ss=request.getSession(true);
			ss.setAttribute("userid", name);
			ss.setAttribute("pass", password);
			out.println("welcome "+name+"   <a href=TimeLine>timeline</a>   <a href=ContactList>contactlist</a>");
	
		}
		else {
			out.println("Invalid id and password");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
			rd.include(request, response);
		}
		out.println("</body></html>");
	}
	
	}


