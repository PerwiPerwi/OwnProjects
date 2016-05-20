<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date" %>

<%@page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title> Dzisiaj jest: </title></head>
<body bgcolor="#E6E6FA">
	<h2>
		<%	Date date = new Date();
			String name = "Jan";
			out.println(String.format("Hello %s!", name));
		%>
	</h2>
	<%@include file= "Counter.jsp"%> 
	
	
	<p> Dzisiaj jest: <%= LocalDate.now().toString() %> </p>
	<p>Request (method) <%= request.getMethod() %>   </p>
	<p>Request (uri) <%= request.getRequestURI() %></p>
	<p>Request (url) <%= request.getRequestURL() %></p>
	<p>Request (addr) <%= request.getRemoteAddr() %></p>
	<p>Session <%= request.getSession() %></p>
	
	<%	
	Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			out.println(" Cookie name: " + cookie.getName() + 
			" Cookie value: " + cookie.getValue() +"<br/>");
	}
		out.print("<br/>");
	%>
	
	
</body>
</html>
