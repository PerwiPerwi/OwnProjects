<%@page import="java.awt.print.Printable"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java" isELIgnored="false"%>
<html>
<head>
<title>User</title>
</head>
<body>
	<%@include file="../jspf/menu.jspf"%>
	<h2>{user}</h2>
	<h3>Wpisz nowe dane do aktualizacji</h3>
	<form name="updateUser" action="/updateUser.do?id=${user.getId()}"
		method="post">
		<div class="form-group">
			<label for="nm">Name:</label> <input type="text" name="name"
				class="form-control" id="nm">
		</div>
		<div class="form-group">
			<label for="mail">Email:</label> <input type="text" name="email"
				value="" class="form-control" id="mail">
		</div>
		<input type="submit" name="submit" value="Aktualizuj" />
	</form>

	<%-- 	<h2>${user}</h2>
	<h3>
		<a href="/updateUser.do?id=${user.getId()}">Aktualizuj</a>
	</h3> --%>

</body>
</html>