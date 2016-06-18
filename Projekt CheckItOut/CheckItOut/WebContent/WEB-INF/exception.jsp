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
<link
	href="${pageContext.request.contextPath}/resources/css/editProfile.css"
	type="text/css" rel="stylesheet">
</head>
<body>
	<jsp:include page="fragment/navbar.jspf" />
	<div class="form">
		<h1>Ooops! Something Was Bad!</h1>
		<h1>
			User with <br> <br>
			<c:if test="${not empty sessionScope.usernameError}">
				<c:out value="${sessionScope.usernameError}"></c:out>
				<br>
			</c:if>
			<c:if test="${not empty sessionScope.emailError}">
				<c:out value="${sessionScope.emailError}"></c:out>
				<br>
				<br>
			</c:if>
			already exist!
		</h1>
		<h3 class="delete">
			<a class="exception" href="${pageContext.request.contextPath}/home">Back
				to HomePage</a>
		</h3>

	</div>

	<jsp:include page="fragment/footer.jspf" />
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-2.2.4.min.js">
		
	</script>
</body>
</html>