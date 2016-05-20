<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="UTF-8" %>

<%!private long visitCount = 0; %>

<h2>Ilosc odwiedzin strony <%=++visitCount%>
<%if (visitCount == 10){
	out.println("Text");
}
	%>

</h2>