<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Parametry szukania </h2>
<%  	
	String query = request.getParameter("query");
	
	Map <String, Integer> tempMap = (Map <String, Integer>)session.getAttribute("query");
	
	if(tempMap == null){
		tempMap = new HashMap<>();
	}
	
	Integer tempValue = tempMap.get(query);
	
	if(tempValue == null){
		tempValue = 1;
	}
	
	tempValue++;
	
	tempMap.put(query, tempValue);
	session.setAttribute(query, tempMap);
%>
<p> Szukane slowo: <b><%= query %></b><br/>
	Strona: <b> <%= request.getParameter("page") %></b><br/>
	Sortowanie: <b> <%= "0".equals(request.getParameter("inputRadio")) ? "malejaco" : "rosnaco" %> </b><br/>
</p>

<form action="search.jsp" method="get">

Podaj słowo: <input name = "query" type ="text"><br/>
Podaj strone: <input name = "page" type = "text"><br/>
podaj sortowanie: <br/>
	Malejaco: <input type="radio" name="inputRadio" value="0" ><br/>
    Rosnaco: <input type="radio" name="inputRadio" value="1" ><br/>
<button type = "submit" value = "submit">Slij</button>
</form>



</body>
</html>