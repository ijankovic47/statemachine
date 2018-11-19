<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Case 1 current state: ${cases[0].s} <c:if test="${fn:contains(case1, 'E11')}">
		<a href="?id=1&event=E11">S1 to S1</a>
	</c:if>
	<c:if test="${fn:contains(case1, 'E12')}">
		<a href="?id=1&event=E12">S1 to S2</a>
	</c:if>
	<c:if test="${fn:contains(case1, 'E22')}">
		<a href="?id=1&event=E22">S2 to S2</a>
	</c:if>
	<c:if test="${fn:contains(case1, 'E23')}">
		<a href="?id=1&event=E23">S2 to S3</a>
	</c:if>
	<c:if test="${fn:contains(case1, '31')}">
		<a href="?id=1&event=E31">S3 to S1</a>
	</c:if></p>
	
	
	
	
	<p>Case 2 current state: ${cases[1].s} <c:if test="${fn:contains(case2, 'E11')}">
		<a href="?id=2&event=E11">S1 to S1</a>
	</c:if>
	<c:if test="${fn:contains(case2, 'E12')}">
		<a href="?id=2&event=E12">S1 to S2</a>
	</c:if>
	<c:if test="${fn:contains(case2, 'E22')}">
		<a href="?id=2&event=E22">S2 to S2</a>
	</c:if>
	<c:if test="${fn:contains(case2, 'E23')}">
		<a href="?id=2&event=E23">S2 to S3</a>
	</c:if>
	<c:if test="${fn:contains(case2, 'E31')}">
		<a href="?id=2&event=E31">S3 to S1</a>
	</c:if></p>
	
	
	
	
	
	<p>Case 3 current state: ${cases[2].s} <c:if test="${fn:contains(case3, 'E11')}">
		<a href="?id=3&event=E11">S1 to S1</a>
	</c:if>
	<c:if test="${fn:contains(case3, 'E12')}">
		<a href="?id=3&event=E12">S1 to S2</a>
	</c:if>
	<c:if test="${fn:contains(case3, 'E22')}">
		<a href="?id=3&event=E22">S2 to S2</a>
	</c:if>
	<c:if test="${fn:contains(case3, 'E23')}">
		<a href="?id=3&event=E23">S2 to S3</a>
	</c:if>
	<c:if test="${fn:contains(case3, '31')}">
		<a href="?id=3&event=E31">S3 to S1</a>
	</c:if></p>
</body>
</html>