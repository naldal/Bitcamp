<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="loginForm" method="post" action="http://localhost:8081/memberServlet/LoginServlet">
<h2>로그인</h2>
<table border='1'>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pwd"></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" value="로그인" onclick="checkLoginForm()">
			<input type="button" value="회원가입" onclick="gotoSignIn()">
		</td>
	</tr>
</table>
</form>
</body>
<script type="text/javascript" src="../js/member.js"></script>
</html>