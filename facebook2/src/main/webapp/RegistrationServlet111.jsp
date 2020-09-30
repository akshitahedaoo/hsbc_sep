<%@page import="com.facebook2.entity.facebook2user,com.facebook2.service.facebook2serviceinterface,com.facebook2.utility.ServiceFactory" %>

public class RegistrationServlet111 extends HttpServlet {
	<%
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
		int i=s.createprofileservice(f);
		
		if(i>0) { %>
		Registration successful   <a href=Login.html>Continue...</a>;
		your name is<%= name %>
		<br>your password is <%= password %>
	<%	}  %>
		

