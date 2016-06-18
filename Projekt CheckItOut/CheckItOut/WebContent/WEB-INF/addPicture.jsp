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
<link
	href="${pageContext.request.contextPath}/resources/css/addPicture.css"
	type="text/css" rel="stylesheet">
</head>
<body>
	<jsp:include page="fragment/navbar.jspf" />
	<div class="form">
		<form action="pictureWriter" method="POST"
			enctype="multipart/form-data">
			<h1>Update Avatar Photo</h1>
			<hr>
			<div class="row">
				<div class="col-md-6 col-md-offset-4">
					<div>
						<img
							src="${pageContext.request.contextPath}/profilePictures/${sessionScope.user.pictureUrl}"
							class=" picture img-circle">
					</div>
				</div>
			</div>
			<input class="inputFile" type="file" name="file" />
			<button style="text-align: center;" type="submit"
				class="button button-block" />
			SAVE CHANGES
			</button>
		</form>
		<h3 class="deletePicture">
			<a class="delete deleteHref"
				href="${pageContext.request.contextPath}/defaultPicture">DELETE
				PHOTO</a>
		</h3>
	</div>
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