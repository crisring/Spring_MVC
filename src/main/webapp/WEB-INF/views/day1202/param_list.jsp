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
		<h2>parameter 처리 연습</h2>
		<form action="/param/single_param" method="post">
			<h3>파라메터가 하나인 경우 (단일형)</h3>
			<label>이름</label> <input type="text" name="name" /> <input
				type="submit" value="하나의 값 전송" class="btn btn-sm btn-success" />
		</form>
		<br>
		<form action="/param/multi_param_request">
			<h3>파라메터가 여러개인 경우 (request)</h3>
			<label>이름</label> <input type="text" name="name" /> <label>나이</label>
			<input type="text" name="age" /> <label>주소</label> <input
				type="text" name="addr" /> <label>주소2</label> <input type="text"
				name="addr" /> <input type="submit" value="여러개 값 전송"
				class="btn btn-sm btn-success" />
		</form>
		<br>
		<form action="/param/multi_param_vo">
			<h3>파라메터가 여러개인 경우 (VO)</h3>
			<label>이름</label> <input type="text" name="name" /> <label>나이</label>
			<input type="text" name="age" /> <label>주소</label> <input
				type="text" name="addr" /> <label>주소2</label> <input type="text"
				name="addr" /> <input type="submit" value="여러개 값 전송"
				class="btn btn-sm btn-success" />
		</form>
	</div>
</body>
</html>