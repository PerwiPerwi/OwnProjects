<%@page
	import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		//Stworzenie obiektu Cookie
		Cookie cookie1 = new Cookie("nazwa", "wartosc");
		Cookie cookie2 = new Cookie("Kot", "Plot");
		Cookie cookie3 = new Cookie("Pies", "Klatka");
		Cookie cookie4 = new Cookie("Osmiorniczka", "Plotkeczka");

		//Ustawienie czasu trwania ciastla
		cookie1.setMaxAge(60 * 60 * 24);
		cookie2.setMaxAge(60 * 60 * 24);
		cookie3.setMaxAge(60 * 60 * 24);
		cookie4.setMaxAge(60 * 60 * 24);

		//Ustawienie Headera, tj. nagłówka HTTP, 
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		response.addCookie(cookie4);
%>
<p>
<%
		//Wyswietlnie cookie
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			out.println(" Cookie name: " + cookie.getName() + " Cookie value: " + cookie.getValue() +"<br/>");
		}
	%>
	</p>
</body>
</html>