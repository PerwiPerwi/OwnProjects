<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pl">
<head>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
<meta charset="utf-8">
<link href="../bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="../bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<title>Userzy</title>
</head>
	<%@include file="../jspf/message.jspf"%>
	<%@include file="../jspf/menu.jspf"%>
	<div>
		<table class="table-striped">
			<tr>
				<c:if test="${users.size() == 0}">
					<td>Brak userów!</td>
				</c:if>
			</tr>
		</table>

		<div class="list-group">
			<a href="#" class="list-group-item active"> Dodani userzy </a>
			<c:forEach items="${users}" var="user">
				<c:out value="${user}"></c:out>
				<a href="user.html?id=${user.getId()}" class="list-group-item"><c:out
						value="Usun"></c:out></a>
				<a href="update.html?id=${user.getId()}" class="list-group-item"><c:out
						value="Aktualizuj"></c:out></a>


<<<<<<< HEAD
<div class="list-group">
  <a href="#" class="list-group-item active">
    Dodani userzy
  </a>
<c:forEach items="${users}" var="user">
 <%-- <a href="user.html?id=${user.getId()}" class="list-group-item" ><c:out value="${user}"></c:out></a> --%>
   
 	 <c:out value="${user}"></c:out>
    <a href="user.html?id=${user.getId()}" class="list-group-item" ><c:out value="Usun"></c:out></a>
    <a href="update.html?id=${user.getId()}" class="list-group-item" ><c:out value="Aktualizuj"></c:out></a>
    
    
</c:forEach>
</div>
</div>
=======
			</c:forEach>
		</div>
	</div>
>>>>>>> b3ab3e90ec311ffd0fe7536c41c00f7c91c83df2
</body>
</html>

