<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="includeController에서 연결"%>
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

<jsp:include page="/WEB-INF/views/common/common_cdn.jsp" />

<script type="text/javascript">
	$(function() {

	}); // document.ready
</script>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<c:import url="/header" />
		</div>
		<div id="container">페이지마다 제공하는 기능들 구현</div>
		<div id="footer">
			<jsp:include page="/WEB-INF/views/common/footer.jsp" />
		</div>

	</div>
</body>
</html>