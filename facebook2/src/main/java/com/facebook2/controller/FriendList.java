package com.facebook2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebook2.entity.facebook2user;
import com.facebook2.service.facebook2serviceinterface;
import com.facebook2.utility.ServiceFactory;

/**
 * Servlet implementation class FriendList
 */
public class FriendList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession ss=request.getSession(true);
		String name=ss.getAttribute("userid").toString();
		
		System.out.println(name);
		
		facebook2user fe=new facebook2user();
		fe.setName(name);
		
		facebook2serviceinterface fs=ServiceFactory.createObject("adminservice");
		List<facebook2user> i=fs.friendProfile(fe);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		if(i.size()>0) {
			for(facebook2user ff:i) {
				out.println(ff.getName());
			}
		}
		else {
			out.println("no friend found");
		}
		
		out.println("</body></html>");
	}

	}


