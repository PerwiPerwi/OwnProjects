<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link
	href="${pageContext.request.contextPath}/resources/css/updateByAdmin.css"
	type="text/css" rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/normalize.css"
	type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/edit.css"
	type="text/css" rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/editProfile.css"
	type="text/css" rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/updateByAdmin.css"
	type="text/css" rel="stylesheet">
</head>

<body>
	<jsp:include page="fragment/navbar.jspf" />
	<form action="updateByAdmin" method="POST">
		<div class="form">
			<h1>Update User Profile</h1>
			<!-- edit form column -->
			<h1 style="text-align: left;">
				User ID:
				<c:out value="${sessionScope.userForUpdate.getId()}"></c:out>
			</h1>
			<h1 style="text-align: left;">
				Username:
				<c:out value="${sessionScope.userForUpdate.getUsername()}"></c:out>
			</h1>

			<div class="field-wrap">
				<h4 style="color: white;">Email</h4>
				<input id="inputEmail" placeholder="Email" name="inputEmail"
					type="email" value="${sessionScope.userForUpdate.getEmail()}" />
			</div>
			<div class="field-wrap">
				<h4 style="color: white;">Role</h4>
				<select name="userRole" class=" selectInput form-control">
					<c:choose>
						<c:when test="${sessionScope.userForUpdate.getRole() == 'admin'}">

							<option>Admin</option>
							<option>User</option>
						</c:when>
						<c:otherwise>
							<option>User</option>
							<option>Admin</option>
						</c:otherwise>
					</c:choose>
				</select>
			</div>

			<h4 style="color: white;">Profile Picture</h4>
			<div style="text-align: center;" class="field-wrap">
				<img width="200px" height="200px"
					src='${pageContext.request.contextPath}/profilePictures/${sessionScope.userForUpdate.getPictureUrl()}'
					class="avatar img-circle" alt="avatar">
			</div>
			<button id="buttonSubmit" type="submit" class="button button-block" />
			SAVE CHANGES

			</button>
			<h3 class="deletePicture">
				<a class="deleteHref" href="${pageContext.request.contextPath}/deletePictureByAdmin?user_id=${sessionScope.userForUpdate.getId()}">DELETE
					PHOTO</a>
			</h3>
		</div>

	</form>

	<jsp:include page="fragment/footer.jspf" />
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-2.2.4.min.js">
		
	</script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootbox.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/ConfirmScript.js"></script>
</body>
</html>