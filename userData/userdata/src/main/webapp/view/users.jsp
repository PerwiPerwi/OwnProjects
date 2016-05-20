<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pl">
<head>
    <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Userzy</title>
     <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@include file="../jspf/message.jspf"%>
<%@include file="../jspf/menu.jspf"%>
<div>
<table class="table-striped">
<tr>
<c:if test="${users.size() == 0}">
   <td> Brak userów!</td>
</c:if>
</tr>
</table>

<div class="list-group">
  <a href="#" class="list-group-item active">
    Dodani userzy
  </a>
<c:forEach items="${users}" var="user">
 <%-- <a href="user.html?id=${user.getId()}" class="list-group-item" ><c:out value="${user}"></c:out></a> --%>
   
 	 <c:out value="${user}"></c:out>
    <a href="user.html?id=${user.getId()}" class="list-group-item" ><c:out value="Usuń"></c:out></a>
    <a href="update.html?id=${user.getId()}" class="list-group-item" ><c:out value="Aktualizuj"></c:out></a>
    
    
</c:forEach>
</div>
</div>
</body>
</html>

