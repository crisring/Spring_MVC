<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="FileUploadController에서 제공하는 jsp"%>
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

		$("#btn").click(function() {

			// 유효성 검증
			if ($("#upfile").val() == "") {

				alert("파일은 필수 선택!")
				return;
			}
			$("#btnSubmit").submit();
		})

	}); // document.ready
</script>
</head>
<body>
	<div id="wrap">

		<h2>파일 업로드</h2>
		<form action="/day1206/uploadProcess2" method="post"
			enctype="multipart/form-data" id="btnSubmit" multiple="">

			<label>업로더</label> <input type="text" name="uploader" id="uploader"
				value="테스트" /><br> <label>사용대상</label>
			<c:forEach var="age" begin="10" end="80" step="10">
				<input type="checkbox" name="targetAge" id="${age }" />
				<c:out value="${age }" />대
	</c:forEach>
			<br> <label>파일</label> <input type="file" name="upfile" id="upfile"
				multiple="multiple" /> <input type="button" value="업로드" id="btn"
				class="btn btn-sm btn-primary" />


		</form>
	</div>
</body>
</html>