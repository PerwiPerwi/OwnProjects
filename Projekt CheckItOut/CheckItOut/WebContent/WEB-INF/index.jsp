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
</head>
<body>
	<jsp:include page="fragment/navbar.jspf" />
	<c:if test="${not empty requestScope.discoveries }">
		<c:forEach var="discovery" items="${requestScope.discoveries}">
			<div class="container">
				<div class="row bs-callout bs-callout-primary">
					<div class="col col-md-1 col-sm-2">
						<a
							href="${pageContext.request.contextPath}/vote?discovery_id=${discovery.id}&vote=VOTE_UP"
							class="btn btn-block btn-primary btn-success"><span
							class="glyphicon glyphicon-arrow-up"></span> </a>
						<div class="well well-sm centered">
							<c:out value="${discovery.upVote - discovery.downVote}"></c:out>
						</div>
						<a
							href="${pageContext.request.contextPath}/vote?discovery_id=${discovery.id}&vote=VOTE_DOWN"
							class="btn btn-block btn-primary btn-warning"><span
							class="glyphicon glyphicon-arrow-down"></span> </a>
					</div>

					<div class="col col-md-11 col-sm-10">
						<h3 class="centered">
							<a href="${discovery.url}" class="discover"><c:out
									value="${discovery.name}"></c:out></a>
						</h3>
						<h6>
							<small>Dodane przez: <c:out
									value="${discovery.user.username}" />, Dnia: <fmt:formatDate
									value="${discovery.timestamp}" pattern="dd/MM/YYYY" /></small>
						</h6>
						<p>
							<c:out value="${discovery.description}" />
						</p>
						<a href="<c:out value="${discovery.url}" />"
							class="btn btn-default btn-xs">Check this link!</a>
						<c:if
							test="${(discovery.user.username == sessionScope.user.username) || (sessionScope.isAdmin)}">
							<a class="deleteDiscovery btn btn-default btn-xs" href="${pageContext.request.contextPath}/deleteDiscovery?discovery_id=${discovery.id}" />
								Delete</a>
						</c:if>		
					</div>
				</div>
			</div>
		</c:forEach>
	</c:if>
	<div class="fb-like" data-share="true" data-width="450"
		data-show-faces="true"></div>
	<fb:login-button scope="public_profile,email"
		onlogin="checkLoginState();">
	</fb:login-button>

	<div id="status"></div>


	<jsp:include page="fragment/footer.jspf" />

	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-2.2.4.min.js">
		
	</script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
			<script
		src="${pageContext.request.contextPath}/resources/js/HomepageScript.js"></script>
</body>
</html>