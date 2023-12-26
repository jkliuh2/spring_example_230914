<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fn 라이브러리</title>
</head>
<body>
	<c:set var="str1" value="No pain. No gain." />
	
	<h1>1. 길이 구하기</h1>
	${fn:length(str1)} <%-- str1의 길이 => 17 --%>
	
	<h1>2. 특정 문자열이 포함 되어 있는지 확인</h1>
	No가 존재하는가? ${fn:contains(str1, "No")}<br> <%-- T/F => true --%>
	no가 존재하는가? ${fn:contains(str1, "no")}<br> <%-- false / 대소문자 구분 가능 --%>
	
	<%-- 위의 리턴이 boolean으로 되기 때문에 조건문의 조건으로 넣을 수도 있다. --%>
	<c:if test="${fn:containsIgnoreCase(str1, 'no')}"> <%-- 대소문자 구별X --%>
		문장에 no라는 문자열이 존재한다.(대소문자 구별 안함)
	</c:if>
	
	<h1>3. 특정 문자열로 시작하는지 확인</h1> <%-- startsWith --%>
	No로 시작하는가? ${fn:startsWith(str1, "No")} <%-- T/F => true --%>
	
	<h1>4. 특정 문자열로 끝나는지 확인</h1>
	n으로 끝나는가? ${fn:endsWith(str1, 'n')}<br> <%-- T/F => false --%>
	.으로 끝나는가? ${fn:endsWith(str1, '.')}<br> <%-- T/F => true --%>
	<%-- STS 이전 버전(2점대)에서는 . 만으로 끝나냐고 물어보면 F가 나옴.(이제는 고쳐짐) --%>
	
	<h1>5. 문자열 치환</h1>
	<c:set var="str2" value="나는 치킨이 먹고 싶다." />
	
	${str2}<br>
	${fn:replace(str2, '치킨', '족발')} <%-- str2의 '치킨'을 '족발' 로 변경 --%>
	
	<h1>6. 구분자로 잘라서 배열 만들기</h1>
	${fn:split(str1, '.')[0]}<br> <%-- Java에서는 .으로 자르려면 추가적인 조치(\\.)가 필요함 --%>
	<%-- 배열의 index도 함께 써줘야 한다. --%>
	${fn:split(str1, '.')[1]}<br> 
	
	<h1>7. 시작 인덱스 ~ 종료 인덱스 까지 문자열 추출</h1>
	<%-- str2에서 '치킨' 추출 --%>
	${fn:substring(str2, 3, 5)} <%-- java에서는 slice(), substring() --%>
	<%-- 3~4 인덱스 추출 --%>
	
	<h1>8. 모두 소문자로 변경</h1> <%-- 실무에서 많이 씀 ★★★ --%>
	${fn:toLowerCase(str1)}
	
	<h1>9. 모두 대문자로 변경</h1>
	${fn:toUpperCase(str1)}
	
	<h1>10. 앞뒤 공백 제거</h1>
	<c:set var="str3" value="     h   ell o     " />
	<pre>${str3}</pre> <%-- pre: value를 그대로 출력. --%>
	${fn:trim(str3)}
</body>
</html>