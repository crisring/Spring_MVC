<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="Model인터페이스에 저장된 값을 사용"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
<%--
<title>${site_kor }</title>
<link rel="shortcut icon" href="${defaultURL }common/images/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="${defaultURL }common/css/main_20240911.css">
--%>
<!-- bootstrap CDN 시작-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<!-- bootstrap CDN 끝-->

<style type="text/css">
</style>
<!-- jQuery CDN 시작-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {

	}); // document.ready
</script>
</head>
<body>
	<div id="wrap">
		<h2>
			<c:out value="${requestScope.msg }" />
		</h2>
		<script type="text/javascript">
			$(function() {
				console.log("접속자 브라우저 정보");
				console.log("${requestScope.userAgent}");
			});
		</script>
		<ul>
			<li><strong>이름</strong> : <c:out value="${data.name }" /></li>
			<li><strong>나이</strong> : <c:out value="${data.age }" /></li>
		</ul>



		<br> <a href="/">메인화면</a> <br> <a
			href="javascript:history.back()">뒤로가기</a>

	</div>
</body>
</html>