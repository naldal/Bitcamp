<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="loginForm" method="post" action="/mvcMember/member/login.do">
<table border="1" cellspacing="0" cellpadding="3">

<tr>
<td width="70" align="center">아이디</td>
<td>
<input type="text" name="id">
</td>
</tr>

<tr>
<td align="center">비밀번호</td>
<td>
<input type="password" name="pwd">
</td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="button" value="로그인" onclick="checkLoginForm()">&emsp;
<input type="button" value="회원가입" onclick="javascript:location.href='/mvcMember/member/writeForm.do'">
</td>
</tr>

</table>
</form>

</body>
<script src="/mvcMember/js/member.js"></script>
</html>