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
	<h1>get ������� ȣ����</h1>
	<h2>name= ${param.name}</h2>
	<h2>name= ${param["name"]}</h2>
	<h2>a= ${a}</h2>
	<h2>b= ${b}</h2>
	<h2>c= ${c}</h2>
	<h2>result= ${result}</h2>

	<h2>���� ����</h2>
	<h3>���̵� : ${users.userid}</h3>
	<h3>��й�ȣ : ${users.userpassword}</h3>
	<h3>�̸��� : ${users.useremail}</h3>
	<h3>���� : ${users.userid}</h3>

	<h2>
		Map ����ϱ�
		</h3>
		<h3>�̸�: ${map.name}</h3>
		<h3>����: ${map.age}</h3>
		<h3>����: ${map.job}</h3>


		<h2>c:forEach �ݺ���</h2>
			<c:forEach var="i" begin="1" end="10">
				<h3>���� i = ${i}</h3>
			</c:forEach>

			<table border="1">
				<c:forEach var="user" items="${list}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${status.index}</td>
						<td>${status.index % 2 == 0 ? "¦��":"Ȧ��"}</td>
						<td>
							<c:choose>
								<c:when test="${status.index % 2 == 0}">
									¦��
								</c:when>
								<c:otherwise>Ȧ��</c:otherwise>
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