<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Dodawanie usera</title>
<link href="bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="../jspf/message.jspf"%>
	<%@include file="../jspf/menu.jspf"%>

	<form name="addUser" action="/addUser.do" method="post">
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
</body>
</html>


<!-- <form role="form" class="form-inline" name="addUser"
	action="/addUser.do" method="post">
	name: <input type="text" name="name" value="" /><br /> email: <input
		type="text" name="email" value="" /><br /> <input type="submit"
		name="submit" value="Dodaj" />
</form> -->
