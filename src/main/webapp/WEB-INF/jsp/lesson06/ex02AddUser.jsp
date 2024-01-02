<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex02 회원가입</title>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery 원본 필요(slim 쓰면 안된다.) --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원 가입</h1>
		
		<div class="form-group">
			<label for="name">이름</label>
			
			<div class="d-flex">
				<input type="text" id="name" name="name" class="form-control col-4">
				<button type="button" id="nameCheckBtn" class="btn btn-info">중복확인</button>
			</div>
			
			<small id="nameStatusArea">
				<%-- 아이디 중복이면 나타나는 글자 -> 동적으로 나타나게 할 것임. --%>
			</small> 
		</div>
		
		<input id="joinBtn" type="button" value="회원가입" class="btn btn-success">
		
<script>
	$(document).ready(function() {
		
		// 중복확인 버튼 클릭
		$("#nameCheckBtn").on('click', function() {
			// nameStatusArea 하위 태그들을 초기화(없으면 계속 추가됨)
			$('#nameStatusArea').empty(); // 자식 태그들을 모두 비운다.
			//alert("중복확인");
			
			let name = $("#name").val().trim(); // trim으로 앞뒤 여백도 제거하면서 가져옴
			
			// 유효성 검사
			// 이름 비어있는지 확인
			if (!name) { 
				$('#nameStatusArea').append('<span class="text-danger">이름이 비어있습니다.</span>'); // 태그를 추가하는 함수
				return;
			}
			
			// AJAX 통신 - 중복된 이름인지 DB에서 확인
			$.ajax({
				// request
				type:"GET" // 노출되도 상관 없는 정보이면 Get으로 -> 생략 가능
				, url:"/lesson06/ex02/is-duplication-name"
				, data:{"name":name}
				
				// response
				, success:function(data) { // 성공시 => data:dictionary
					// {"code":200, "is_duplication":true} -> 중복일 때(true)
					if (data.is_duplication) {
						// 중복일 때 (아닐 때는 안쓰면 되서 생략되었다)
						$('#nameStatusArea').append('<span class="text-danger">중복된 이름입니다.</span>');
					}
				}
				, errer:function(request, status, error) {
					alert("이름 중복확인에 실패했습니다.");
				}
				
			}) // ajax 끝
		}); // 중복확인 클릭 이벤트 끝
		
		
		// 회원 가입 버튼 클릭
		$('#joinBtn').on('click', function() {
			//alert("회원 가입");
			
			// nameStatusArea에 아무 자식 태그가 없다면 -> 가입 진행 (원래는 이러면 안됨)
			console.log($('#nameStatusArea').children());
			
			if($('#nameStatusArea').children().length < 1) {
				alert("회원가입 진행");
			} else {
				alert("회원가입 불가");
			}
			
		}); // 회원 가입 버튼 클릭 이벤트 끝
	}); // 레디 이벤트 끝
</script>
</body>
</html>