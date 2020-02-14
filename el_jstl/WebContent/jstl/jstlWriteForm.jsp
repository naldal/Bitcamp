<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="writeForm" method="post" action="jstlWrite.jsp">
		<table border="1" cellspacing="0" cellpadding="3">

			<tr>
				<td width="70" align="center">이름</td>
				<td><input type="text" name="name" placeholder="이름 입력" size=>
				</td>
			</tr>

			<tr>
				<td align="center">아이디</td>
				<td>
					<input type="text" name="id" placeholder="아이디 입력">
				</td>
			</tr>

			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd"></td>
			</tr>

			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="회원가입">&emsp;
				<input type="reset" value="다시작성">&emsp;
				<input type="button" value="목록" onclick="location.href='jstlList.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>