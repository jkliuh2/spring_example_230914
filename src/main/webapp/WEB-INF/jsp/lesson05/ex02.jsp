<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리(2)</title>
</head>
<body>
	<h1>1. 조건문(c:choose, C:when, c:otherwise)</h1>
	<c:set var="weight" value="65" />
	
	<c:choose>
		<%-- 60 미만 --%>
		<c:when test="${weiget < 60}">
			치맥<br>
		</c:when>
		
		<%-- 60이상, 70 미만 --%>
		<c:when test="${weight < 70}"> <%-- 위의 조건이 거짓이라는 암묵적인 조건이 있다.(else if) --%>
			샐러드 먹자!<br>
		</c:when>
		
		<%-- 70 이상 --%>
		<c:otherwise> <%-- (=else) 속성 필요 X --%>
			굶자<br>
		</c:otherwise>
	</c:choose>
	
	
	<h1>2. 반복문(c:forEach)</h1>
	<%-- int i = 0; i <= 5; i++ --%>
	<c:forEach begin="0" end="5" step="1" var="i"> 
		${i}<br>
	</c:forEach>
	
	<%-- int i = 16; i <= 20; i++ --%>
	<%-- varStatus: 반복문에 대한 객체를 만드는 것에 가까움. "객체명"
	관례적으로 "status"로 명명한다. --%>
	<c:forEach begin="16" end="20" step="1" var="i" varStatus="status"> 
		var: ${i} 
		current: ${status.current}
		first: ${status.first}
		last: ${status.last}
		index: ${status.index} <%-- 숫자로 돌릴 때는 숫자와 동일. ★List로 돌릴 때는 0부터 시작★ --%>
		count: ${status.count} <%-- 현재 반복문이 몇번째 반복문인가? --%>
		<br>
	</c:forEach>
	<br>
	
	${fruits}<br><br>
	
	<%-- 서버에서 가져온 List<String> 출력 --%>
	<%-- items: model의 key명. ★반드시 EL로 감싸야 한다. --%>
	<%-- var: List에서 꺼낸 개체가 담기는 변수(일종의 Iterator). 절대 items와 겹치면 안된다! --%>
	<c:forEach items="${fruits}" var="fruit" varStatus="status">
		${fruit} ::: index: ${status.index}<br> <%-- index는 0부터 시작! --%>
	</c:forEach>
	<br>
	
	<%-- 서버에서 가져온 List<Map> 테이블 출력 --%>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
			</tr>
		</thead>
		<tbody>
			<%-- 스크립틀릿 사용법과 동일한 방식 --%>
			<c:forEach items="${users}" var="user" varStatus="status">
				<tr>
					<td>${status.count}</td> <%-- 번호를 붙이기 위해 status 이용 --%>
					<td>${user.name}</td>
					<td>${user.age}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>