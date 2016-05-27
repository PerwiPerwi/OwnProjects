<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<%@include file="../jspf/menu.jspf"%>
<h2>${user}</h2>
<h3><a href="removeUser.do?id=${user.getId()}">usuń</a></h3>
</body>
</html>
