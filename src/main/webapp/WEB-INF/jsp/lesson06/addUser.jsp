<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<%-- AJAX를 사용하려면 jquery 원본 필요(slim 쓰면 안된다.) --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원 가입</h1>
		
		<form method="post" action="/lesson06/ex01/add-user">
			<div class="form-group">
				<label for="name">이름</label>
				<input type="text" id="name" name="name" class="form-control col-4">
			</div>
			<div class="form-group">
				<label for="yyyymmdd">생년월일</label>
				<input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control col-4" placeholder="예) 19991201">
			</div>
			<div class="form-group">
				<label for="email">이메일 주소</label>
				<input type="text" id="email" name="email" class="form-control col-4">
			</div>
			<div class="form-group">
				<label for="introduce">자기소개</label>
				<textarea id="introduce" name="introduce" class="form-control"></textarea>
			</div>
			<%-- AJAX로 할 때는 submit이 되면 안되므로 type을 button으로 변경 --%>
			<input id="joinBtn" type="button" value="회원가입" class="btn btn-success">
		</form>
	</div>
	
<script>
	$(document).ready(function() {
		// 1) jquery의 submit 기능 이용하기
		
		/*
		// "form태그가 동작(submit)할 때." 를 이벤트로 잡아본다.(파일 전체에 form이 하나뿐일때)
		$("form").on('submit', function(e) {
			//e.preventDefault(); // 서브밋 기능 중단 (function에 e 필요함)
			//alert("서브밋");
			
			// validation(유효성 검사) - 이름, 생년월일, 이메일
			let name = $("#name").val(); // 이름 검사
			if (name.length < 1) { // name의 갯수가 1보다 작다(즉 비어있다)
				alert("이름을 입력하세요");
				return false; // submit 이벤트에서 해당 이벤트를 막기 위해서는 false 필요!
			}
			
			let yyyymmdd = $("#yyyymmdd").val(); // 생년월일 검사
			if (yyyymmdd == "") { // ""이다(비어있다)
				alert("생년월일을 입력하세요");
				return false;
			}
			
			let email = $("#email").val();
			if (!email) { // email이 비어있으면 참.
				alert("이메일을 입력하세요");
				return false;
			}
			
			// 여기까지 도달하면 submit (화면 이동)
			
		}); // form-submit 끝
		// 여기까지 원래 알던 방식 */
		
		
		
		// 2) jquery의 AJAX 통신을 이용하기
		// submit이 안됨 => "버튼이 클릭될 때" 를 이벤트로 잡는다
		$("#joinBtn").on('click', function() {
			//alert("클릭");
			
			// 유효성 검사(위에서 복사)
			let name = $("#name").val(); // 이름 검사
			if (name.length < 1) { 
				alert("이름을 입력하세요");
				return; // submit 이벤트가 아니므로 false 필요 없다!
			}
			let yyyymmdd = $("#yyyymmdd").val(); // 생년월일 검사
			if (yyyymmdd == "") { 
				alert("생년월일을 입력하세요");
				return;
			}
			let email = $("#email").val(); // 이메일 검사
			if (!email) { 
				alert("이메일을 입력하세요");
				return;
			}
			
			let introduce = $("#introduce").val(); // introduce 가져옴
			// AJAX는 parameter를 보냈는지를 볼 수가 없으므로 console로 꼭 찍어봐서 확인해보도록 하자!
			console.log(name);
			console.log(yyyymmdd);
			console.log(email);
			console.log(introduce);
			
			// AJAX: 비동기로 서버에 요청 / key명은 "절대로 소문자"
			$.ajax({
				// request
				type:"POST" // 보내는 방식
				, url: "/lesson06/ex01/add-user" // 보내는 url
				// 보내는 Data -> JSON으로, key-value => ""가 key명, :뒤의 변수가 value값+위에서 지정한 변수
				, data:{"name":name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce} 
				
				
				// response -> 콜백 함수. 라고 부른다고 한다.(Request를 다 수행하고 돌아온다?)
				, success:function(data) { // call back 함수 - 성공한 경우(200OK)
					// data param: request를 보내고 "반드시" 돌아오는 응답값.
					alert(data); // "성공"
					if (data == "성공") { // data에 담긴 값이 성공일 때 수행
						// insert에 성공했을 테니 이제 화면이동
						location.href="/lesson06/ex01/after-add-user-view";
						// GET 요청(화면이동)
					}
				}
				, error:function(request, status, error) { // 요청 자체가 안될 때(400), 그 외 에러들일때(500)
					alert(request);
					alert(status);
					alert(error);
				}
				, complete:function(data) { // 성공이든 에러든 일단 완료되면 수행
					// 앞으로는 안씀
					alert("성공이든 실패든 완료");
				}
				
			}); // $.ajax() 끝
			
		}); // 버튼 클릭 이벤트 끝
		
	}); // ready 끝
</script>
</body>
</html>