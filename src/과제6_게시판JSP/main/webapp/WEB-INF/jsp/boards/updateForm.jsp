<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>수정화면</title>
    <style>
        label {
            display: inline-block;
            width: 120px;
        }

        input {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<h1>
    게시물 수정양식
</h1>
<form action="board.do" method="post">
    <input type="hidden" name="action" value="update">
    <label>NO : </label> <input type="text" id="bno" name="bno" value="${board.bno}" readonly> <br/>
    <label>제목 : </label> <input type="text" id="title" name="title" value="${board.title}"> <br/>
    <label>내용: </label> <textarea value="${board.content}" id="content" name="content">${board.content}</textarea> <br/>
    <label>작성자 : </label> <input type="text" id="writer" name="writer" value="${board.writer}"><br/>
    <label>작성일:</label> <input type="text" value="${board.date}" readonly name="date" id="date"/><br/>
    <div>
        <input type="submit" value="수정">
        <a href="board.do?action=view&bno=${board.bno}">취소</a>
    </div>
</form>
</body>
</html>
