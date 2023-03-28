<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리(2)</title>
</head>
<body>
	<h2>1. 조건문 (c:choose, c:when, c:otherwise)</h2>
	<c:set var="weight" value="65"></c:set>
	
	<c:choose>
		<%-- ~59 --%>
		<c:when test="${weight < 60}">
			떡볶이 먹자<br>
		</c:when>
		<%-- 61 ~ 69 --%>
		<c:when test="${weight < 70}">
			샐러드 먹자<br>
		</c:when>
		<%-- 70~ --%>
		<c:otherwise>
			굶자 <br>
		</c:otherwise>
	
	</c:choose>
	
	<h2>2. 반복문 (c:forEach)</h2>
	<%-- 0 ~ 5 => 6번 --%>
	<c:forEach begin="0" end="5" step="1" var="val1">
		${val1}<br>
	</c:forEach>
	
	<h2>2. 반복문 (c:forEach varStatus)</h2>
	<c:forEach begin="16" end="20" step="1" var="val2" varStatus="status">
		var : ${val2} current : ${status.current} <%-- 현재값 --%>
		first : ${status.first} <%-- 첫번째 값이니? --%>
		last : ${status.last} <%-- 마지막 값이니? --%>
		count : ${status.count} <%-- count는 1부터 시작 --%>
		index : ${status.index} <%-- index는 0부터 시작 --%>
		<br> 
		
	</c:forEach>
	
	<%-- // 서버에서 가져와 List<String> 출력하기 --%>
	<%-- el 문법 안에 model 객체를 넣음 --%>
	<%-- var 속성과 items 속성의 값이 같으면 안됨. 헷갈려함 --%>
	<c:forEach items="${fruits}" var="fruit" varStatus="status">
		${fruit} :::::::::::::: ${status.count} , ${status.index}
		<br>
	</c:forEach>
	
	<%-- // 서버에서 가져와 List<Map<String, Object>> 출력하기 --%>
	<c:forEach items="${users}" var="user" varStatus="status">
		<h3>${status.count} 번째 사람 정보</h3>
		이름 : ${user.name}<br>
		나이: ${user.age}<br>
		취미: ${user.hobby}<br>
		<br>
	</c:forEach>
	
	<%-- table 구성 --%>
	<table border="1" style="border:none">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>취미</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${user.name}</td>
					<td>${user.age}</td>
					<td>${user.hobby}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	
	
	
</body>
</html>