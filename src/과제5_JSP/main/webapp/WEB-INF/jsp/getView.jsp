<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>get 방식으로 호출함</h1>
	<h2>name= ${param.name}</h2>
	<h2>name= ${param["name"]}</h2>
	<h2>a= ${a}</h2>
	<h2>b= ${b}</h2>
	<h2>c= ${c}</h2>
	<h2>result= ${result}</h2>

	<h2>유저 정보</h2>
	<h3>아이디 : ${users.userid}</h3>
	<h3>비밀번호 : ${users.userpassword}</h3>
	<h3>이메일 : ${users.useremail}</h3>
	<h3>나이 : ${users.userid}</h3>

	<h2>
		Map 사용하기
		</h3>
		<h3>이름: ${map.name}</h3>
		<h3>나이: ${map.age}</h3>
		<h3>직업: ${map.job}</h3>


		<h2>c:forEach 반복문</h2>
			<c:forEach var="i" begin="1" end="10">
				<h3>변수 i = ${i}</h3>
			</c:forEach>

			<table border="1">
				<c:forEach var="user" items="${list}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${status.index}</td>
						<td>${status.index % 2 == 0 ? "짝수":"홀수"}</td>
						<td>
							<c:choose>
								<c:when test="${status.index % 2 == 0}">
									짝수
								</c:when>
								<c:otherwise>홀수</c:otherwise>
							</c:choose>
						</td>
						<td>${user.numberLabel}</td>
						<td>${user.username}</td>
						<td>${user.useremail}</td>
						<td>${user.userage}</td>
					</tr>
				</c:forEach>
			</table>
</body>
</html>