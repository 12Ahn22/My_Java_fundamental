<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./common.css">
<title>Document</title>
</head>

<body>
	<main class="layout">
		<h1>회원 정보 수정</h1>

		<form class="form" action="users" method="get">
			<input type="hidden" name="action" value="update"/>
			
			<label for="userid" class="label">
				<span class="label_text">아이디:</span>
				<input readOnly value="${user.userid}" class="input" type="text" id="userid" name="userid"></label>
				
			<label for="userpassword" class="label">
				<span class="label_text">비밀번호:</span><input class="input" type="password" id="userpassword" name="userpassword">
			</label>
			
			<label for="userpassword2" class="label">
				<span class="label_text">비밀번호확인:</span><input class="input" type="password" id="password2" name="userpassword2">
			</label>
	
			<label for="username" class="label">
				<span class="label_text">이름:</span><input class="input" value="${user.username}" type="text" id="username" name="username">
			</label> 
			
			<label for="userage" class="label">
				<span class="label_text">나이:</span><input class="input" type="number" id="userage" name="userage" value="${user.userage}">
			</label> 
			
			<label	for="useremail" class="label">
				<span class="label_text">이메일:</span><input class="input" type="email" id="useremail" name="useremail" value="${user.useremail}">
			</label>

			<div>
				<span class="label_text">성별:</span> <label for="female"
					class="label"><input type="radio" name="gender" id="female"
					value="female">여성</label> <label for="male" class="label"><input
					type="radio" name="gender" id="male" value="male">남성</label>
			</div>

			<label for="birthdate" class="label"><span class="label_text">생일
					:</span><input type="date" id="birthdate" name="birthdate"></label>
			<div>
				<span class="label_text">취미:</span> <label for="bicycle">자전거<input
					type="checkbox" id="bicycle" name="hobby" value="bicycle"></label>
				<label for="reading">독서<input type="checkbox" id="reading"
					name="hobby" value="reading"></label> <label for="movie">영화<input
					type="checkbox" id="movie" name="hobby" value="movie"></label>
			</div>
			<div>
				<button class="button" type="submit">등록</button> 
				<a class="button--gray"	href="users?action=view&userid=${user.userid}">취소</a>
			</div>
		</form>

	</main>
</body>

</html>
