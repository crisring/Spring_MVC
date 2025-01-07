<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info=""%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
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
			document.frm.method = $("[name='method2']:checked").val();
			if (confirm((document.frm.method) + "방식으로 요청하시겠습니까?")) {
				$("#frm").submit();
			}
		});
	});//ready
	function useResponsebody() {
		$.ajax({
			url : "/day1211/useResponsebody",
			type : "GET",
			dataType : "JSON",
			error : function(xhr) {
				alter(xhr.status);
			},
			success : function(jsonObj) {
				var output = "<strong>검색결과 없음</strong>";
				if (jsonObj.resultFlag) {
					output = "<strong>검색결과</strong>";
					output += "<ul>";
					output += "<li>이름 : " + jsonObj.name + "</li>";
					output += "<li>나이 : " + jsonObj.age + "</li>";
					output += "<li>취미 :";
					$.each(jsonObj.hobby, function(i, jsonHobby) {
						output += (i + 1) + "." + jsonHobby.hobby + " ";
					});
					output += "</li>";
					output += "</ul>";
				}//end if

				$("#output").html(output);
			}
		})//ajax

	}//useResponseBody
</script>
</head>
<body>
	<div id="wrap">
		<h2>작업 KJH</h2>

		<ul>
			<li><a href="/request_get">GET요청</a></li>
			<li><form action="/request_post" method="post">
					<input type="submit" value="POST요청" name="btnSubmit"
						class="btn btn-sm btn-success" /> <a href="/request_get">GET요청</a>
				</form></li>


			<li><form action="/request_get_post" method="post" id="frm">
					<input type="radio" name="method2" value="GET" checked="checked" />GET방식
					<input type="radio" name="method2" value="POST" />POST방식 <input
						type="button" id="btn" value="요청" class="btn btn-sm btn-success" />
				</form></li>

			<li><a href="/param/param_test">웹 파라메터 받기</a></li>

			<li><a href="/day1202/send_data">JSP로 업무처리한 값 전달</a></li>

			<li><a href="/day1203/redirect">redirect로 페이지 이동</a></li>

			<li><a href="/day1203/forward">forward로 페이지 이동</a></li>

			<li><a href="/day1204/include">include로 사용</a></li>

			<li><a href="/day1204/session">HttpSession로 사용</a></li>

			<li><a href="/day1204/model">Model session로 사용</a></li>

			<li><a href="/day1205/cookie">Cookie 사용</a></li>

			<li><a href="/day1205/webutils">WebUtils 사용</a></li>

			<li><a href="/day1205/exception">Controller내 예외처리</a></li>

			<li><a href="/day1205/exception2">Controller내 예외처리2</a></li>

			<li><a href="/day1206/fileuploadFrm">파일 업로드</a></li>

			<li><a href="/day1206/fileuploadFrm2">파일 업로드2</a></li>

			<li><a href="/day1209/di">DI</a></li>

			<li><a href="/day1210/injectionTest">InjectionTest</a></li>

			<li><a href="/day1210/searchEmpno">Mybatis연습</a></li>

			<li><a href="/day1211/useResponsebody">@ResponseBody사용(링크호출)</a><br>
				<a href="javascript:useResponsebody()">@ResponseBody사용(javaScript)</a>
				<div id="output"></div></li>

			<li><a href="/board/board_list">게시판</a></li>

			<li><a href="/day1212/crypto">암호화</a></li>

			<li><a href="/day1219/email">메일전송</a></li>

			<li><a href="/day1220/restful">RESTful</a></li>
		</ul>

		<ul>
			<li><a href="/loginPractice/login">암호화/복호화 연습</a></li>
			<li><a href="/member/memberList">암호화/복호화 연습2</a></li>
		</ul>

	</div>
</body>
</html>