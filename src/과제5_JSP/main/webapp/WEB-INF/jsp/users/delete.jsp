<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Delete User</title>
</head>
<body>
	<c:choose>
		<c:when test="${updated !=0}">
			<h1>회원정보 삭제 성공</h1>
			<a href="users?action=list">확인</a>
		</c:when>
		<c:otherwise>
			<h1>회원정보 삭제 실패</h1>
			<a href="users?action=list">확인</a>
		</c:otherwise>
	</c:choose>
</body>
</html>