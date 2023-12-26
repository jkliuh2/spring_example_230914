<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fmt 라이브러리</title>
</head>
<body>
	<h1>숫자 출력</h1>
	<c:set var="number" value="12345678" /> <%-- 숫자 쓰기위한 변수 선언 --%>
	<fmt:formatNumber value="${number}" />
	
	<h3>Type</h3>
	숫자: <fmt:formatNumber value="${number}" type="number" /><br> <%-- number가 기본 타입 --%>
	숫자 3자리마다 콤마 제거하기: <fmt:formatNumber value="${number}" type="number" groupingUsed="false" /><br>
	
	<%-- percent --%>
	100%: <fmt:formatNumber type="percent" value="1" /><br>
	40%: <fmt:formatNumber type="percent" value="0.4" /><br>
	
	<%-- 통화(currency) --%>
	통화(원): <fmt:formatNumber type="currency" value="${number}" /><br>
	달러: <fmt:formatNumber type="currency" value="${number}" currencySymbol="$" /><br>
	
	<h3>Pattern</h3>
	3.14: <fmt:formatNumber value="3.14" /><br> <%-- 3.14 --%>
	3.14(0.0000): <fmt:formatNumber value="3.14" pattern="0.0000" /><br> <%-- 3.1400 --%>
	3.14(#.####): <fmt:formatNumber value="3.14" pattern="#.####" /><br> <%-- 3.14## --%>
	3.141592653(#.####): <fmt:formatNumber value="3.141592653" pattern="#.####" /><br> <%-- 3.1416 뒤는 반올림 --%>
	
	<hr>
	
	<h1>Date 객체를 String 형태로 출력(fmt:formatDate)</h1>
	Date: ${now}<br> <%-- 그냥 Date로 받아온 그대로 뿌렸을 때. --%>
	<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" /><br>
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" var="pattern2" /><br> 
	pattern2: ${pattern2} <%-- var로 변수에 저장해서 출력은 안된다. 출력하려면 따로 호출해야 함 --%>
	
	<h1>String을 Date객체로 변환(fmt:parseDate)</h1>
	<fmt:parseDate value="${pattern2}" pattern="yyyy-MM-dd HH:mm:ss" /><br>
	<%-- value의 String이 pattern의 포맷에 맞춰서 Date타입의 형태로 변환된다. --%>
	
	예시: <fmt:parseDate value="2012-12-24 19:09:19" pattern="yyyy-MM-dd HH:mm:ss" />
</body>
</html>