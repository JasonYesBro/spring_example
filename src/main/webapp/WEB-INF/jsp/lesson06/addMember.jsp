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
<script src="https://code.jquery.com/jquery-3.6.4.js"
	integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1 class="display-3">회원추가</h1>
		<div class="form-group">
			<label for="name"><b>이름</b></label>
			<div class="d-flex">
				<input type="text" id="name" name="name" class="form-control col-3 mr-2" />
				<button type="button" class="btn btn-info" id="nameCheckBtn">중복확인</button>
			</div>
			<small id="nameStatusArea" class="text-danger"></small>
		</div>
		<button type="button" class="btn btn-success" id="joinBtn">가입하기</button>
	</div>
	
<script>
	$(document).ready(function() {
		// 중복환인 버튼 클릭 했을때
		$("#nameCheckBtn").on("click", function() {
			
			// #nameStatusArea 하위 태그들을 초기화 append가 쌓이지 않는 것을 방지
			$("#nameStatusArea").empty();
			
			let name = $("#name").val().trim();
			
			if(name == "") {
				$("#nameStatusArea").append("<span class='text-danger'>이름이 비어있습니다.</span>");
				return;
			}
			
			// 이름이 중복되었는지 체크 -> AJAX 통신
			$.ajax({
				// request
				type: "get",
				url : "/lesson06/ex02/is_duplication",
				data : {"name": name},
				
				// response
				success: function(data) {
					//{"code":1, "isDuplication":true}
					//{"code":500, "errorMessage":"실패한 이유"}

					if(data.isDuplication){
						$("#nameStatusArea").append("<span class='text-danger'>이름이 중복되었습니다.</span>");
					}

					
				},
				error : function(request, status, error) {
					alert("중복확인에 실패했습니다. 관리자에게 문의해주세요.")
				}
				
			
			});
		});
		
		// 가입 버튼 클릭
		$("#joinBtn").on("click", function() {
			// #nameStatusArea 상자 하위 노드들이 있는지 확인 domTree 의 객체 or 태그라고 이해
			console.log(); // span태그가 있으면 1로 나올테고 없다면 0
			if($("#nameStatusArea").children().length == 0) {
				alert("서버호출 가능");
			} else {
				alert("서버호출 불가");
			}
		});
	});
</script>
</body>
</html>