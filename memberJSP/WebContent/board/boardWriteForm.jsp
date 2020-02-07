<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

</style>
</head>
<body>
<h3>글쓰기</h3>
<form name="boardForm" action="boardWrite.jsp" method="post">
<table border="1">
    <tr>
        <td>제목</td>
        <td><input type="text" name="subject"></td>
    </tr>
    <tr>
        <td>내용</td>
        <td><textarea name="content" id="content" cols="30" rows="10"></textarea></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="button" value="글쓰기" onclick="checkBoard()">
            <input type="reset" value="다시작성">
        </td>
    </tr>
</table>
</form>
</body>
<script type="text/javascript" src="../js/board.js"></script>
</html>