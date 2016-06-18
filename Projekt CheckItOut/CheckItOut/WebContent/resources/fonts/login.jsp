<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Check IT!</title>
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

</head>
<body>
		function getInfo() {
			FB.api("/me", 'GET', {
				fields : 'first_name,last_name,id, email'
			}, function(response) {
				document.getElementById('status').innerHTML = response.id;
				document.getElementById('status').innerHTML = response.first_name;
				document.getElementById('status').innerHTML = response.last_name;
				document.getElementById('status').innerHTML = response.email;
				console.log(response.first_name);
				console.log(response.last_name);
				console.log(response.first_email);
			})
		}

		function check() {
			FB.login(function(response) {
				console.log("dupa");
				if (response.status === 'connected') {
					document.getElementById('status').innerHTML = 'EHE'
							+ 'into this app.';
				} else if (response.status === 'not_authorized') {
					// The person is logged into Facebook, but not your
					// app.
					document.getElementById('status').innerHTML = 'Please log '
							+ 'into this app.';
				} else {
					document.getElementById('status').innerHTML = 'Please log '
							+ 'into Facebook.';
				}
			},{scope:'email'});
		}

	<div id="status">

	</div>
			<button onclick="check()">login</button>
		<button onclick="getInfo()">Info</button>
	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/RegisterScript.js"></script>
</body>
</html>