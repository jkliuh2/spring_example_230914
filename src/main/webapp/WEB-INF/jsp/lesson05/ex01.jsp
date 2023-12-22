<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리(1)</title>
</head>
<body>
	<h1>1. 변수 정의하기 (c:set)</h1>
	<c:set var="number1" value="100" /> <%-- number1 = 100 이라는 뜻 --%>
	<c:set var="number2">250</c:set> <%-- number2 = 250 이라는 뜻. 비추 --%>
	
	number1: ${number1}<br>
	number2: ${number2}<br>
	number1 + number2: ${number1 + number2} <%-- EL문법 내부에서 처리. 외부는 html 영역 --%>
	
	
	<h1>2. 변수 출력하기 (c:out)</h1>
	<c:out value="Hello world" /><br> <%-- 문장 자체를 출력 --%>
	<c:out value="number1" /><br> <%-- String "number1" 출력 --%>
	<c:out value="${number1}" /><br><%-- EL문법 사용으로 number1을 ★Model에서★ 가져와서 출력 --%>
	
	<c:out value="<script>alert('얼럿창 띄우기')</script>" /><br> <%-- html로는 출력할 수 없는 글자 출력 가능 --%>
	<c:out value="<script>alert('얼럿창 띄우기')</script>" escapeXml="true" /><br> <%-- 기본. 생략되어있음 --%> 
	<%-- <c:out value="<script>alert('얼럿창 띄우기')</script>" escapeXml="false" /><br> <!-- false 하면 alert뜸 -->  --%>
	
	
	<h1>3. 조건문(c:if)</h1> <%-- else X. 오직 if --%>
	<c:if test="${number1 > 50}">
		number1은 50보다 크다.<br> <%-- test 조건이 참이면 태그 사이 value 출력. --%>
	</c:if>
	
	<c:if test="${number1 == 100}">
		number1은 100이다.<br>
	</c:if>
	<c:if test="${number1 eq 100}"> <%-- ==과 같음. 이게 "정석" --%>
		number1은 100이다.<br>
	</c:if>
	
	<c:if test="${number1 != 50}"> 
		number1은 50이 아니다.<br>
	</c:if>
	<c:if test="${number1 ne 50}"> <%-- 역시 이게 정석 --%> 
		number1은 50이 아니다.<br>
	</c:if>
	
	
	<c:if test="${empty number}"> <%-- ★나중에 많이 쓰게되니 기억해놓자. --%>
		number1은 비어있다.<br>
	</c:if>
	
	<c:if test="${!empty number}"> <%-- empty의 반대 --%>
		number1은 비어있지 않다.<br>
	</c:if>
	<c:if test="${not empty number}"> <%-- empty의 반대. 정석 --%>
		number1은 비어있지 않다.<br>
	</c:if>
</body>
</html>