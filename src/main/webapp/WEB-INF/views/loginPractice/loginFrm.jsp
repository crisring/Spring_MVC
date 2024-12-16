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
<script>
	$(function() {
		// 버튼 클릭 이벤트 핸들러 등록
		$("#btnSubmit").click(function() {
			if (chkNull()) {
				// 폼 전송
				$("#loginFrm").submit(); // 'yourFormId'를 실제 폼 ID로 대체하세요
			}
		});
	}); // document.ready

	function chkNull() {
		let id = $("#id").val(); // 아이디 값 가져오기
		let password = $("#password").val(); // 비밀번호 값 가져오기
		let phone_number = $("#phone_number").val(); // 전화번호 값 가져오기
		let address = $("#address").val(); // 주소 값 가져오기

		// 필수 입력값 확인
		if (id == null || id.trim() === "") {
			alert("아이디는 필수 입력!!");
			return false;
		}
		if (password == null || password.trim() === "") {
			alert("비밀번호는 필수 입력!!");
			return false;
		}
		if (phone_number == null || phone_number.trim() === "") {
			alert("전화번호는 필수 입력!!");
			return false;
		}
		if (address == null || address.trim() === "") {
			alert("주소는 필수 입력!!");
			return false;
		}

		return true; // 모든 입력값이 유효하면 true 반환
	}
</script>

<!--다음 주소API  -->
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9426f33fe983e55d&libraries=services"></script>

<script>
	function sample5_execDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				var addr = data.address; // 최종 주소 변수

				// 주소 정보를 해당 필드에 넣는다.
				document.getElementById("address").value = addr;

				// 팝업 닫기
				window.close();
			}
		}).open();
	}
</script>

</head>
<body>
	<div id="wrap">

		<h2>로그인(암호화/복호화 연습)</h2>
		<!-- form action에는 mapping 시켜줄 주소를 입력! -> Controller에 method에 맞게 매핑  -->
		<form action="/loginPractice/loginProc" method="post" id="loginFrm">
			<label for="id">아이디</label> <input type="text" id="id" name="id"
				value="test" /><br> <label for="password">비밀번호</label> <input
				type="password" id="password" name="password" value="tiger" /><br>
			<label for="phone_number">전화번호</label> <input type="text"
				id="phone_number" name="phone_number" value="010-1234-1234" /><br>

			<input type="text" id="address" name="address" placeholder="주소"
				style="width: 300px;" value="경기 광명시 안양천서자전거길 854"> <input
				type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
			<input type="button" id="btnSubmit" name="btnSubmit"
				class="btn btn-sm btn-success" value="제출" />
		</form>
	</div>
</body>
</html>