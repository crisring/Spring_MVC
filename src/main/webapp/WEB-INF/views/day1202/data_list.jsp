<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info=""%>
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
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<!-- bootstrap CDN 끝-->

<style type="text/css">
#wrap {
	text-align: center;
}
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
		<h2>View로 데이터 전달하기</h2>
		<form action="/day1202/useModel">
			<h3>Model사용</h3>
			<label>번호</label> <input type="text" name="num" /> <input
				type="submit" value="Model사용" class="btn btn-sm btn-success" />
		</form>

		<form action="/day1203/useRequest">
			<h3>HttpServletRequest사용</h3>
			<label>번호</label> <input type="text" name="num" /> <input
				type="submit" value="Request사용" class="btn btn-sm btn-success" />
		</form>

		<form action="/day1203/useModelAndView">
			<h3>ModelAndView사용</h3>
			<label>번호</label> <input type="text" name="numTest" /> <input
				type="submit" value="ModelAndView사용" class="btn btn-sm btn-success" />
		</form>
	</div>
</body>
</html>