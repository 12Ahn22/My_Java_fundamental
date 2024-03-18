<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update User</title>
</head>
<body>
	<c:choose>
		<c:when test="${updated !=0}">
			<h1>회원정보 수정 성공</h1>
			<a href="users?action=view&userid=${userid}">확인</a>
		</c:when>
		<c:otherwise>
			<h1>회원정보 수정 실패</h1>
			<a href="users?action=view&userid=${userid}">확인</a>
		</c:otherwise>
	</c:choose>
</body>
</html>