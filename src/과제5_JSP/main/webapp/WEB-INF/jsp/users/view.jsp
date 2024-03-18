<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="common.css">
<title>View</title>
</head>

<body>
	<main class="layout">
		<h1>회원 상세 정보</h1>
		<ul class="user_info">

			<li><span>아이디:</span>${user.userid}</li>
			<li><span>이름:</span>${user.username}</li>
			<li><span>비밀번호:</span>${user.userpassword}</li>
			<li><span>나이:</span>${user.userage}</li>
			<li><span>이메일:</span>${user.useremail}</li>

		</ul>
		<!-- 두개의 폼을 하나로 합치는 방법, js를 통해 처리한다. -->
		<form action="delete.jsp" method="post" id="viewForm" >
			<input name="userid" value="${user.userid}" type="hidden" />
			<input type="button" value="삭제" onclick="onClickDelete()" />
			<input type="button" value="수정" onclick="onClickUpdate()" />
		</form>
	
		<div>
			<a class="button" href="users?action=list">목록</a> 
			<a class="button" href="users?action=updateForm&userid=${user.userid}">수정</a> 
			<a class="button--gray"	href="users?action=delete&userid=${user.userid}">삭제</a>
		</div>
	</main>
</body>
<script>
	const onClickDelete = () => {
		if(confirm("정말 삭제하시겠습니까?")){
			viewForm.action = "users?action=delete";
			viewForm.submit();
		}
	};
	const onClickUpdate = () => {
		viewForm.action = "users?action=updateForm";
		viewForm.submit();
	};
</script>
</html>