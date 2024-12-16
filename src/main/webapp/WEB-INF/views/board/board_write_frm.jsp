<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Insert title here</title>

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

<!-- jQuery CDN 시작-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<!-- include summernote css/js-->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs5.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs5.min.js"></script>

<style type="text/css">
</style>
<script type="text/javascript">
	$(function() {
		$('#content').summernote(
				{
					placeholder : '쓰고 싶은 글을 써 주세요.',
					tabsize : 2,
					height : 240,
					width : 490,
					toolbar : [ [ 'style', [ 'style' ] ],
							[ 'font', [ 'bold', 'underline', 'clear' ] ],
							[ 'insert', [ 'picture' ] ],
							[ 'view', [ 'codeview', 'help' ] ] ]
				});

		$("#btnWrite").click(function() {
			chkNull();
			writeBoard();

		});//click
		$("#btnList").click(function() {
			location.href = "/board/board_list";
		});//click

	});//ready

	function moveBoardList() {

		var url = "/board/board_list";

		location.href = url;
	}

	function chkNull() {
		if ($("#subject").val().trim() == "") {
			alert("제목은 필수 입력");
			$("#subject").focus();
			return;
		}//end if

		if ($("#content").val().trim() == "") {
			alert("내용은 필수 입력");
			return;
		}//end if

		// $("#writeFrm").submit();
	}//chkNull

	// subject,content,writer,ip,pass
	function writeBoard() {
		var subject = $("#subject").val();
		var writer = $("#writer").val();
		var content = $("#content").val();
		var ip = $('#ip').val();
		var pass = $("#pass").val();

		var param = {
			subject : subject,
			content : content,
			writer : writer,
			ip : ip,
			pass : pass
		};

		$.ajax({
			url : "/board/board_write",
			type : "POST",
			data : param,
			dataType : "JSON",
			error : function(xhr) {
				alert(xhr.status);
			},
			success : function(jsonObj) {
				var msg = jsonObj.writeCount + " 건이 ";
				if (jsonObj.writeFlag) {
					msg += "추가되었습니다";
				} else {
					msg = "추가되지 않았습니다.";
				}//end else
				$("#pass").val("");

				alert(msg)

				if (jsonObj.writeFlag) {
					moveBoardList();
				}
			}
		});//ajax
	}// modifyBoard
</script>



</head>
<body>
	<div id="wrap">
		<input type="hidden" id="ip" name="ip" value="${ip}" />

		<div id="contentDiv">
			<div id="writeFrmDiv">
				<table>
					<tr>
						<th colspan="2"><h2>글쓰기</h2></th>
					</tr>
					<tr>
						<td style="width: 80px">제목</td>
						<td style="width: 500px"><input type="text" name="subject"
							id="subject" style="width: 390px" autofocus="autofocus" /></td>
					</tr>
					<tr>
						<td style="width: 80px">내용</td>
						<td><textarea name="content" id="content"></textarea></td>
					</tr>
					<tr>
						<td style="width: 80px">작성자</td>
						<td><input type="text" name="writer" id="writer"
							style="width: 390px" /></td>
					</tr>
					<tr>
						<td style="width: 80px">비밀번호</td>
						<td><input type="password" name="pass" id="pass"
							style="width: 390px" /></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center"><input
							type="button" id="btnWrite" value="글쓰기"
							class="btn btn-sm btn-success" /> <input type="reset"
							value="초기화" class="btn btn-sm btn-warning" /> <input
							type="button" id="btnList" value="리스트"
							class="btn btn-sm btn-info" /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>