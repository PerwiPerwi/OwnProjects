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
	href="${pageContext.request.contextPath}/resources/css/normalize.css"
	type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/edit.css"
	type="text/css" rel="stylesheet">
</head>
<body>
	<jsp:include page="fragment/navbar.jspf" />
	<div>
		<h1>
			Confirm remove account of

			<c:choose>
				<c:when test="${sessionScope.isAdmin}">
					<c:out value="${user.id}"></c:out>
				</c:when>
				<c:otherwise>
					<c:out value="${requestScope.users.username}"></c:out>
				</c:otherwise>
			</c:choose>

		</h1>

<form action="delete" method="post">
		<c:choose>
			<c:when test="${sessionScope.isAdmin}">
				<a
					href="${pageContext.request.contextPath}/delete?user_id=${user.id}">DeleteA</a>
			</c:when>
			<c:otherwise>
				<a
					href="${pageContext.request.contextPath}/delete?user_id=${sessionScope.user.id}">DeleteU
				</a>
			</c:otherwise>
		</c:choose>
</form>



	</div>


	<jsp:include page="fragment/footer.jspf" />
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-2.2.4.min.js">		
	</script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
</body>
</html>