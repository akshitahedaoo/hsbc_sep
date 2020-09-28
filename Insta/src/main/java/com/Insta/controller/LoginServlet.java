package com.Insta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Insta.entity.InstaUser;
import com.Insta.service.InstaServiceInterface;
import com.Insta.utility.ServiceFactory;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  name=request.getParameter("name");
		String password=request.getParameter("password");
		
		InstaUser iu=new InstaUser();
		iu.setName(name);
		iu.setPassword(password);
		
		InstaServiceInterface s=ServiceFactory.createObject("adminservice");
		boolean i=s.loginProfile(iu);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		if(i) {
			
			HttpSession ss=request.getSession(true);
			ss.setAttribute("userid", name);
			ss.setAttribute("pass", password);
			out.println("welcome "+name+"   <a href=TimeLine>timeline</a>   <a href=FollowerList>followerlist</a>");
	
		}
		else {
			out.println("Invalid id and password");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
			rd.include(request, response);
		}
		out.println("</body></html>");
	}
	}


