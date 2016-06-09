<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Check IT! - Add New Stuff</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	type="text/css" rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/normalize.css"
	type="text/css" rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/loginAndSignup.css"
	type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/footer.css"
	type="text/css" rel="stylesheet">
</head>

<body>

<jsp:include page="fragment/navbar.jspf" />

	<div class="form">
		<div id="login">
			<h1>Add new STUFF!</h1>

			<form action="add" method="post">

				<div class="field-wrap">
					<label> What You Wanna Add?<span class="req">*</span>
					</label> <input id="discoveryName" name="inputName" type="text" required autocomplete="off" />
				</div>

				<div class="field-wrap">
					<label> Url<span class="req">*</span>
					</label> <input id="discoveryUrl"  name="inputUrl" type="text" required autocomplete="off" />
				</div>
				<div class="field-wrap">
					<label class="description"> Description </label>
					<textarea id="discoveryDescription" name="inputDescription" rows="5">
				</textarea>
				</div>
				<button id="buttonSubmit" type="submit" class="button button-block" />
				ADD NEW STUFF!
				</button>

			</form>

		</div>
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
		src="${pageContext.request.contextPath}/resources/js/AddDiscoveryScript.js"></script>
</body>
</html>