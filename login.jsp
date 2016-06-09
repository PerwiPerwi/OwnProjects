<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login Form</title>
<link href="../bootstrap/normalize.css" rel="stylesheet">
<link href="../bootstrap/style.css" rel="stylesheet">
</head>
<div class="login">
<h1>Login</h1>
<form id="loginForm" method="post" action="login" modelAttribute="loginBean">
<input type="text" required="required" placeholder="Username" name="user">
<input type="password" required="required" placeholder="Password" name="password">
<button class="btn btn-primary btn-block btn-large" type="submit">Let me in.</button>
</form>
</div>