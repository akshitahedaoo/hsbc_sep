<%@page import="com.facebook2.entity.facebook2user"%>
<%@page import="java.util.*,com.facebook2.service.facebook2serviceinterface,com.facebook2.utility.ServiceFactory" %>


<%
facebook2serviceinterface s=ServiceFactory.createObject("adminservice");
String n=request.getParameter("statename");
facebook2user f=new facebook2user();
f.setStatename(n);

List<facebook2user> i=s.city(f);


String ss="<select id=cc name=city  >";
for(facebook2user ll:i){
	ss=ss+"<option value='"+ll.getCityname()+"'>"+ll.getCityname()+"</option>";
}
ss=ss+"</select>";
out.println(ss);
%>