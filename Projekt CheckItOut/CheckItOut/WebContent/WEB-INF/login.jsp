<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

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
	<div class="form">
		<h1>Check IT!</h1>
		<ul class="tab-group">
			<li class="tab active"><a href="#login">Log In</a></li>
			<li class="tab"><a href="#signup">Sign Up</a></li>
		</ul>

		<div class="tab-content">
			<div id="login">
				<h1>Welcome Back!</h1>

				<form action="j_security_check" method="post">

					<div class="field-wrap">
						<label> User Name<span class="req">*</span>
						</label> <input name="j_username" type="text" required autocomplete="off" />
					</div>

					<div class="field-wrap">
						<label> Password<span class="req">*</span>
						</label> <input name="j_password" type="password" required
							autocomplete="off" />
					</div>

					<button type="submit" class="button button-block" />
					Log In
					</button>
				</form>

			</div>

			<div id="signup">
				<h1>Sign Up!</h1>

				<form action="register" method="post">

					<div class="field-wrap">
						<label> Email Address<span class="req">*</span>
						</label> <input name="inputEmail" type="email" required autocomplete="off" />
					</div>

					<div class="field-wrap">
						<label> User Name<span class="req">*</span>
						</label> <input id="inputUsername" name="inputUsername" type="text"
							required autocomplete="off" />
					</div>


					<div class="field-wrap">
						<label> Set A Password<span class="req">*</span>
						</label> <input id="inputPassword" name="inputPassword" type="password"
							required autocomplete="off" />
					</div>

					<button id="buttonSubmit" type="submit" class="button button-block" />
					Get Started
					</button>

				</form>

			</div>

		</div>
		<!-- tab-content -->

	</div>
	<!-- /form -->


	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-2.2.4.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootbox.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/RegisterScript.js"></script>

</body>
</html>