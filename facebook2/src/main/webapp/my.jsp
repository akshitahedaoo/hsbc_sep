<%@page import="com.facebook2.entity.facebook2user"%>
<%@page import="java.util.*,com.facebook2.service.facebook2serviceinterface,com.facebook2.utility.ServiceFactory" %>



<%
String n=request.getParameter("email");
facebook2user f=new facebook2user();
f.setEmail(n);
	facebook2serviceinterface s=ServiceFactory.createObject("adminservice");
	int i1=s.checkemail(f);
	if(i1>0){ %>
		<font color=red>email already exists</font>
	<%}
	else{ %>
		<font color=green>VALID email</font>
	<%}
%>