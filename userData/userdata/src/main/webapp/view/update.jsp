<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java" isELIgnored="false"%>
<html>
<head>
<title>User</title>
</head>
<body>
<%-- 	<%@include file="../jspf/menu.jspf"%>
	<%@include file="users.jsp"%> --%>
	

	<form name="updateUser" action="/addUser.do" method="post">
		<div class="form-group">
			<label for="nm">Name:</label> <input type="text" name="name"
				class="form-control" id="nm">
		</div>
		<div class="form-group">
			<label for="mail">Email:</label> <input type="text" name="email"
				value="" class="form-control" id="mail">
		</div>
		<input type="submit" name="submit" value="Dodaj" />
	</form>

	<h2>${user}</h2>
	<h3>
		<a href="/updateUser.do?id=${user.getId()}">aktualizuj</a>
	</h3>

</body>
</html>