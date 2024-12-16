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
<script type="text/javascript">
	$(function() {

		$("#empno").change(function() {
			var empno = $("#empno").val();

			if (empno === "None" || empno.trim() === "") {
				alert("유효한 사원번호를 입력하세요.");
				return;
			}

			if (confirm("사원조회하시겠습니까?")) {
				$.ajax({
					url : "/day1210/empDetail",
					data : {
						empno : empno
					}, // 데이터를 JSON 형식으로 보냄
					type : "POST",
					dataType : "JSON",
					error : function(xhr) {
						alert("에러 발생: " + xhr.status + " - " + xhr.statusText);
					},
					success : function(jsonObj) {
						if (jsonObj.resultFlag) {
							// 성공적으로 사원 정보를 가져온 경우
							$("#empno2").val(empno);
							$("#ename").val(jsonObj.ename);
							$("#job").val(jsonObj.job);
							$("#sal").val(jsonObj.sal);
							$("#hiredate").val(jsonObj.hiredate);
						} else {
							alert("사원 정보를 찾을 수 없습니다.");
						}
					},
				}); // ajax
			}// end if
		});

	}); // document.ready
</script>
</head>
<body>
	<div id="wrap">
		<h2>사원번호 출력</h2>
		<select id="empno">

			<c:forEach var="empno" items="${data }" varStatus="i">
				<option value="${empno }">
					<c:out value="${ i.count}. ${empno }" /></option>
			</c:forEach>
		</select>

		<div>
			<table>

				<tr>
					<th colspan="2"><h3>사원정보 조회</h3></th>
				</tr>
				<tr>
					<td>사원번호</td>
					<td><input type="text" name="empno2" id="empno2"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>사원명</td>
					<td><input type="text" name="ename" id="ename"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>직무</td>
					<td><input type="text" name="job" id="job" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>연봉</td>
					<td><input type="text" name="sal" id="sal" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>입사일</td>
					<td><input type="text" name="hiredate" id="hiredate"
						readonly="readonly" /></td>
				</tr>


			</table>

		</div>

	</div>
</body>
</html>