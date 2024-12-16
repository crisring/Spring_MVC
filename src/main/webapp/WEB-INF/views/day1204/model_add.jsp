<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty sessionScope.model_name }">
	<c:redirect url="/" />
</c:if>

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
		<div>
			<c:out value="${sessionScope.model_name }" />
			(
			<c:out value="${requestScope.model_name }" />
			) <select>
				<c:forEach var="menu" items="${model_data }" varStatus="i">
					<option><c:out value="${i.count }.${menu }" /></option>
				</c:forEach>
			</select>
		</div>
		<a href="/day1204/read_model?cmd=read">읽기</a> <a
			href="/day1204/remove_model?cmd=remove">삭제</a>

	</div>
</body>
</html>