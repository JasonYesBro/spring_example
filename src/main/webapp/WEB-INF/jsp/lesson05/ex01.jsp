<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리(1)</title>
</head>
<body>
	<h2>1. 변수 정의 하기 (c:set)</h2>
	<c:set var="number1" value="100" />
	<c:set var="number2">2400</c:set>
	number1: ${number1}<br>
	number2: ${number2}<br>
	
	num1 + num2 : ${number1 + number2}<br>
	
	<h2>2. 변수 출력하기 (c:out)</h2>
	number1: <c:out value="${number1}"></c:out><br>
	<c:out value="hell korea"></c:out><br>
	<%-- 문구 그대로 출력됨 --%>
	<c:out value="<script>alert('alert창 띄우기');</script>" escapeXml="true"></c:out>
	
	<%-- escapeXml값을 false로 준다면 script가 수행이됨 --%>
	<%-- <c:out value="<script>alert('alert창 띄우기');</script>" escapeXml="false"></c:out> --%>
	
	<h2>3. 조건문 (c:if)</h2>
	
	<c:if test="${number1 > 50}">
	<%-- 참이되면 수행할 문장 --%>
		number1 은 50보다 크다.<br>
	</c:if>
	<c:if test="${number1 == 100}">
		number1 은 100과 같다.<br>
	</c:if>
	<c:if test="${number1 eq 100}">
		number1 은 100과 같다.<br>
	</c:if>
	<c:if test="${number1 ne 111}">
		number1 은 111이 아니다.<br>
	</c:if>
	<c:if test="${ !empty number1 }">
		number1은 비어있지 않다.<br>
	</c:if>
	<c:if test="${ not empty number1 }">
		number1은 비어있지 않다.<br>
	</c:if>
</body>
</html>