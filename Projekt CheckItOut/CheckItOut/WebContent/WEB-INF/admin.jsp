<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Check It OUT!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/footer.css"
	type="text/css" rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/addPicture.css"
	type="text/css" rel="stylesheet">
</head>

<body>
	<jsp:include page="fragment/navbar.jspf" />


	<c:choose>
		<c:when test="${not empty requestScope.users }">
			<h1 style="text-align: center; color: #333;">User Accounts</h1>
			<table class="table table-inverse">
				<thead>
					<tr>
						<th>User Id</th>
						<th>Username</th>
						<th>Email</th>
						<th>Role</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${requestScope.users}">
						<c:if test="${user.username != sessionScope.user.getUsername()}">
							<tr>
								<td><c:out value="${user.id}"></c:out></td>
								<td><c:out value="${user.username}"></c:out></td>
								<td><c:out value="${user.email}"></c:out></td>
								<td><c:out value="${user.role}"></c:out></td>
								<td><a class="deleteHref" id="delete"
									href="delete?user_id=${user.id}">Delete</a></td>
								<td><a
									href="${pageContext.request.contextPath}/updateByAdmin?user_id=${user.id}">Update</a>
							<tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<h1>Nie dodano zadnych userow</h1>
		</c:otherwise>
	</c:choose>


	<jsp:include page="fragment/footer.jspf" />
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-2.2.4.min.js">
		
	</script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootbox.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
		<script
		src="${pageContext.request.contextPath}/resources/js/ConfirmScript.js"></script>
</body>
</html>