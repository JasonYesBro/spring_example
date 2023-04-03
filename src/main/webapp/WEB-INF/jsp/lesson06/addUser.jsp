<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<%-- 제이쿼리 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1 class="display-3">회원가입</h1>
		<form method="post" action="/lesson06/ex01/add_user">
			<div class="form-group">
				<label for="name"><b>이름</b></label> <input type="text" id="name"
					name="name" class="form-control col-3" />
			</div>
			<div class="form-group">
				<label for="yyyymmdd"><b>생년월일</b></label> <input type="text"
					id="yyyymmdd" name="yyyymmdd" class="form-control col-3" />
			</div>
			<div class="form-group">
				<label for="email"><b>이메일</b></label> <input type="text" id="email"
					name="email" class="form-control col-4" />
			</div>
			<div class="form-group">
				<label for="introduce"><b>자기소개</b></label>
				<textarea id="introduce" name="introduce" class="form-control col-6"
					rows="6"></textarea>
			</div>
			<!-- <input type="submit" class="btn btn-primary" value="회원가입" /> -->
			<!-- ajax통신일 때는 반드시 button타입으로 지정한다. -->
			<input type="button" id="addBtn" class="btn btn-primary" value="회원가입" />
		</form>
	</div>
	<script>
		$(document).ready(function() {
			// 1. Jquery 의 submit 기능 이용하기
			
			/*
			$("form").on("submit", function(e) {
				// e.preventDefault(); // submit 되는 걸 막는다. 기본 event를 막음(form 태그 - submit)
				// alert("submit 버튼 클릭");
				
				// validation
				let name = $("#name").val().trim();
				if(!name) {
					alert("이름을 입력하세요.");
					return false; // submit 안함
				}
				
				let yyyymmdd = $("#yyyymmdd").val().trim(); // trim()을 이용해 혹시모를 빈 값을 비워줌
				if(!yyyymmdd) {
					alert("생년월일을 입력하세요.");
					return false; // submit 안함
				}
				
				// 여기까지 코드가 수행이 된다면 submit처리
			});
			*/
			
			// (2) Ajax 통신을 이용한 post처리
			
			$("#addBtn").on("click", function() {
				//alert("버튼클릭");
				// validation
				let name = $("#name").val().trim();
				if(!name) {
					alert("이름을 입력하세요.");
					return;
				}
				
				let yyyymmdd = $("#yyyymmdd").val().trim(); // trim()을 이용해 혹시모를 값을 비워줌 (앞뒤)
				if(!yyyymmdd) {
					alert("생년월일을 입력하세요.");
					return;
				}
				
				let email = $("input[name=email]").val().trim();
				let introduce = $("#introduce").val();
				
				console.log(name);
				console.log(yyyymmdd);
				console.log(email);
				console.log(introduce);
				
				// ajax :폼태그와 상관없이 비동기로 별도 요청(Request)
				$.ajax({
					// request 
					type: "post"
					, url: "/lesson06/ex01/add_user"
					, data: {"name": name, "yyyymmdd": yyyymmdd, "email": email, "introduce": introduce}
										
					// response
					, success : function(data) { //데이터 : response의 결과 응답임
						if(data=="성공") {
							location.href="/lesson06/ex01/result_view";	
						}
						//alert(data);
					}
					, complete : function(data) {
						alert("성공실패 여부 상관없이 완료");
					}
					, error : function(request, status, error) {
						alert(request);
						alert(status);
						alert(error);
					}
				});
			});
		});		

	</script>
</body>
</html>