<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pl">
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
<meta charset="UTF-8">
<!-- <link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet"> -->
<title>Userzy</title>
</head>
<%@include file="../jspf/message.jspf"%>
<%@include file="../jspf/menu.jspf"%>
<div class="table-striped">
	<table class="table">
		<c:choose>
			<c:when test="${users.size() == 0}">
				<tr>
					<td>Brak userów!</td>
				<tr>
			</c:when>
			<c:otherwise>
				<h2>Dodani Userzy</h2>
				<tr>
					<td>ID</td>
					<td>Imie</td>
					<td>Email</td>
					<td>Data Rejestracji</td>
				</tr>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><c:out value="${user.getId()}"></c:out></td>
						<td><c:out value="${user.getName()}"></c:out></td>
						<td><c:out value="${user.getEmail()}"></c:out></td>
						<td><c:out value="${user.getRegistrationDate()}"></c:out></td>
						<%-- 			<c:out value="${user}"></c:out> --%>
						<td><a href="user.html?id=${user.getId()}"
							class="list-group-item"><c:out value="Usun"></c:out></a></td>
						<td><a href="update.html?id=${user.getId()}"
							class="list-group-item"><c:out value="Aktualizuj"></c:out></a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</div>
</body>
</html>

