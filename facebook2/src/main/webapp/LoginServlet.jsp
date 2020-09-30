<%@page import=" com.facebook2.entity.facebook2user,com.facebook2.service.facebook2serviceinterface,com.facebook2.utility.ServiceFactory" %>
	<%
		String  name=request.getParameter("name");
		String password=request.getParameter("password");
		
		facebook2user f=new facebook2user();
		f.setName(name);
		f.setPassword(password);
		
		facebook2serviceinterface s=ServiceFactory.createObject("adminservice");
		boolean i=s.loginProfile(f);
		
		if(i) {
			
			HttpSession ss=request.getSession(true);
			ss.setAttribute("userid", name);
			ss.setAttribute("pass", password);%>
			welcome <%= name %>   <a href=TimeLine>timeline</a>   <a href=FriendList>friendlist</a>;
	
		<% }
		else {%>
			Invalid id and password
			<%@include file="Login.html" %>
			<%
		}%>
	



