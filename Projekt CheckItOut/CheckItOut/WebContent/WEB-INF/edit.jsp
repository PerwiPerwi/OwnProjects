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
	<form action="update" method="POST">
		<div class="form">
			<h1>
				Hi
				<c:out value="${sessionScope.user.username}"></c:out>
				!
			</h1>
			<h3 class="editProfile">Edit Profile</h3>
			<hr>
			<div class="row">
				<!-- left column -->
				<div class="col-md-3">
					<div class="text-center">

						<img width="150px" height="150px"
							src='${pageContext.request.contextPath}/profilePictures/${sessionScope.user.pictureUrl}'
							class="avatar img-circle" alt="avatar"> <a
							class="changePhoto" href="pictureWriterView">Change Photo </a>
					</div>
				</div>
				<form action="update" method="POST">
					<!-- edit form column -->
					<div class="col-md-9 personal-info">

						<form class="form-horizontal" role="form">

							<div class="field-wrap">
								<input id="inputPassword" placeholder="Password"
									name="inputPassword" type="password" />
							</div>
							<div class="field-wrap">
								<input id="inputConfirmPassword" placeholder="Confirm Password"
									name="inputConfirmPassword" type="password" />
							</div>
							<div class="field-wrap">
								<input id="inputEmail" placeholder="Email" name="inputEmail"
									type="email" value="${sessionScope.user.email}" />
							</div>
					</div>
					<button id="buttonSubmit" type="submit" class="button button-block" />
					SAVE CHANGES
					</button>
					<button id="buttonReset" type="reset" class="button button-default" />
					RESET
					</button>
					<h3 class="delete">
						<a id="buttonDelete" class="deleteAcc" href="delete?user_id=${user.id}">DELETE
							ACCOUNT</a>
					</h3>
				</form>
			</div>
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
		src="${pageContext.request.contextPath}/resources/js/UpdateScript.js"></script>
</body>
</html>