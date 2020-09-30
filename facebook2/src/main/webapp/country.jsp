<%@page import="com.facebook2.entity.facebook2user"%>
<%@page import="java.util.*,com.facebook2.service.facebook2serviceinterface,com.facebook2.utility.ServiceFactory" %>

<%
facebook2serviceinterface s=ServiceFactory.createObject("adminservice");

List<facebook2user> i=s.country();


String ss="<select id=cc name=country   onchange=loadstate()>";
for(facebook2user ll:i){
	ss=ss+"<option value='"+ll.getCountryname()+"'>"+ll.getCountryname()+"</option>";
}
ss=ss+"</select>";
out.println(ss);
%>