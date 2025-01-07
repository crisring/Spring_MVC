<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="" isELIgnored="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
<%--
<title>${ site_kor }</title>
<link rel="shortcut icon" href="${ defaultURL }common/images/favicon.ico"/>
<link rel="stylesheet" type="text/css" href="${ defaultURL }common/css/main_20240911.css">
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

<!-- jQuery CDN 시작-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<style type="text/css">
</style>
<script type="text/javascript">
$(function(){
	$("#createUserBtn").click(function(){
		var userId=$("#newUserId").val();
		var userName=$("#newUserName").val();
		
		var data={ userId: userId, userName: userName};
		
		$.ajax({
			url:"/restful/users",
			type:"POST", //@PostMapping
			data : data,
			dataType:"JSON",
			error : function( xhr ){
				alert( xhr.status );				
			},
			success:function( jsonObj){
				var outMsg="추가 실패하였습니다.";
				if( jsonObj.addFlag ){
					outMsg="추가되었습니다.";
				}//end if
				
				$("#output").html( `${ userName }님 데이터가 ${ outMsg } `);
				searchAllUser();
			}
			
		});//ajajx
	});//click
	
	$("#getUserBtn").click(function(){
		var userId=$("#userId").val();
		
		//아이디를 사용한 검색을 수행한다. 아이디가 URL뒤에 있어야한다.
		
		$.ajax({
			url:`/restful/users/${ userId }`,
			type: "GET", //@GetMappging("{ userId }")
			dataType:"JSON",
			error:function( xhr ){
				alert( xhr.staus );
			},
			success:function( jsonObj ){
				var outMsg=`${ userId }로는 검색된 데이터가 존재하지 않습니다.`;
				if( jsonObj.searchFlag ){
					outMsg=`${ userId }님의 이름은 ${ jsonObj.userName }`;
				}//end if
				
				$("#output").html( outMsg );
			}
		});//ajax
		
		
	});//click
	
	
	$("#getAllUserBtn").click(function(){
		searchAllUser();
	});//click
	
	$("#modifyUserBtn").click(function(){
		var userId=$("#modifyUserId").val();
		var userName=$("#modifyUserName").val();
		//아이디 PathValue, 이름 : 파라메터 
		var data={ userName:userName };
		$.ajax({
			url:`/restful/users/${ userId }`,
			type:"PUT", //@PutMapping("{ userId }"),
			data:data,
			dataType:"JSON",
			error:function( xhr ){
				alert( xhr.status );
			},
			success:function( jsonObj ){
				var outMsg=`${ userId }는 존재하지 않습니다.`;
				if( jsonObj.resultFlag ){
					outMsg=`${ userId }님의 이름이 ${ userName }으로 변경되었습니다`;
				}//end if
				
				$("#output").html( outMsg );
				
				searchAllUser();
			}
		});//ajax
		
	});//click
	
	$("#removeUserBtn").click(function(){
		var userId=$("#removeUserId").val();
		
		$.ajax({
			url:`/restful/users/${ userId }`,
			type:"DELETE", //@DeleteMapping("{ userId }"),
			dataType:"JSON",
			error:function( xhr ){
				alert( xhr.status );
			},
			success:function( jsonObj ){
				var outMsg=`${ userId }는 존재하지 않습니다.`;
				if( jsonObj.resultFlag ){
					outMsg=`${ userId }님의 정보를 삭제하였습니다.`;
				}//end if
				
				$("#output").html( outMsg );
				searchAllUser();
			}
		});//ajax
		
	});//click
			
});//ready

function searchAllUser(){
	
	$.ajax({
		url:`/restful/users/all`,
		type: "GET", // @GetMapping("/all")
		dataType: "JSON",
		error:function(xhr){
			alert(xhr.status );
		},
		success:function( jsonObj ){
			var output=`
			<h3>전체 사원 조회 - ${ jsonObj.dataSize }건 조회</h3>
			<table class='table table-hover'>`;
			output+=`<thead>
			<tr>
			<th style="width:100px">아이디</th><th style="width:300px">이름</th>
			</tr>
			</thead>
			<tbody>
			`;
			if( jsonObj.resultFlag ){
				$.each( jsonObj.data, function(i, jsonTemp){
					output += `<tr><td>${ jsonTemp.userId }</td><td>${ jsonTemp.userName }</td></tr>`;
				});//each
			}else{
				output += `<tr><td colspan="2">회원정보가 존재하지 않습니다.</td></tr>`;
			}//end else
				
			output+=`</tbody>
			  </table>`;
			  
			$("#output2").html( output ); 
			
		}
	});//ajax
}//searchAllUser

</script>
</head>
<body>
	<div id="wrap">
		<h1>Spring Boot RESTful CRUD</h1>

		<div
			style="border: 1px solid #333; width: 400px; padding: 10px; margin-bottom: 10px">
			<h2>계정생성</h2>
			<label>아이디 :</label> <input type="text" name="newUserId"
				id="newUserId" placeholder="추가할아이디" /><br /> <label>이름 :</label> <input
				type="text" name="newUserName" id="newUserName" placeholder="추가할 이름" /><br />
			<input type="button" value="추가" id="createUserBtn"
				class="btn btn-primary btn-sm">
		</div>

		<div
			style="border: 1px solid #333; width: 400px; padding: 10px; margin-bottom: 10px">
			<h2>계정조회</h2>
			<label>아이디 :</label> <input type="text" name="userId" id="userId"
				placeholder="검색할 아이디" /><br /> <input type="button" value="조회"
				id="getUserBtn" class="btn btn-primary btn-sm">
		</div>

		<div
			style="border: 1px solid #333; width: 400px; padding: 10px; margin-bottom: 10px">
			<h2>전체 사원조회</h2>
			<input type="button" value="전체조회" id="getAllUserBtn"
				class="btn btn-primary btn-sm">
		</div>

		<div
			style="border: 1px solid #333; width: 400px; padding: 10px; margin-bottom: 10px">
			<h2>계정변경</h2>
			<label>아이디 :</label> <input type="text" name="modifyUserId"
				id="modifyUserId" placeholder="변경할아이디" /><br /> <label>이름 :</label>
			<input type="text" name="modifyUserName" id="modifyUserName"
				placeholder="변경할 이름" /><br /> <input type="button" value="변경"
				id="modifyUserBtn" class="btn btn-primary btn-sm">
		</div>

		<div
			style="border: 1px solid #333; width: 400px; padding: 10px; margin-bottom: 10px">
			<h2>계정삭제</h2>
			<label>아이디 :</label> <input type="text" name="removeUserId"
				id="removeUserId" placeholder="삭제할 아이디" /><br /> <input
				type="button" value="계정삭제" id="removeUserBtn"
				class="btn btn-primary btn-sm">
		</div>

		<div>
			<h2>결과창</h2>
			<div id="output"></div>
			<div id="output2"></div>
		</div>
	</div>
</body>
</html>






