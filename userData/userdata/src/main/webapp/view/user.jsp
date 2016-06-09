<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<%@include file="../jspf/menu.jspf"%>
<h2>${user}</h2>
<<<<<<< HEAD
<h3><a href="/removeUser.do?id=${user.getId()}">Usun</a></h3>
=======
<h3><a href="removeUser.do?id=${user.getId()}">usuń</a></h3>
>>>>>>> b3ab3e90ec311ffd0fe7536c41c00f7c91c83df2
</body>
</html>
