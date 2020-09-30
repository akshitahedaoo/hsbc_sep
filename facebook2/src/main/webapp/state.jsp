<%@page import="com.facebook2.entity.facebook2user"%>
<%@page import="java.util.*,com.facebook2.service.facebook2serviceinterface,com.facebook2.utility.ServiceFactory" %>

<%

facebook2serviceinterface s=ServiceFactory.createObject("adminservice");
String n=request.getParameter("countryname");
facebook2user f=new facebook2user();
f.setCountryname(n);
List<facebook2user> i=s.state(f);


String ss="<select id=ss name=state  onchange=loadcity()>";
for(facebook2user ll:i){
	ss=ss+"<option value='"+ll.getStatename()+"'>"+ll.getStatename()+"</option>";
}
ss=ss+"</select>";
out.println(ss);
%>