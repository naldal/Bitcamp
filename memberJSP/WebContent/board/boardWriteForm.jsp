<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글쓰기</h3><br>
<form name="boardWriteForm" method="post" action="boardWrite.jsp">
<table border="1" cellspacing="0" cellpadding="3">
<tr>
<td align="center" width="70">제목</td> 
<td>
<input type="text" name="subject" id="subject" placeholder="제목 입력"  size="30">
</td>
</tr>

<tr>
<td align="center">내용</td>
<td>
<textarea width="450" name="content" id="content" cols="55" rows="10"></textarea>
</td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="button" value="글쓰기" onclick="checkBoardWriterForm()">&emsp;
<input type="reset" value="다시작성">
</td>
</tr>

</table>
</form>
</body>
<script type="text/javascript" src="../js/member.js"></script>
</html>