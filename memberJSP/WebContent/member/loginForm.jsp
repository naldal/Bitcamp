<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="loginForm" method="post" action="/memberJSP/member/login.jsp">
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
<input type="button" value="회원가입" onclick="javascript:location.href='/memberJSP/member/writeForm.jsp'">
</td>
</tr>

</table>
</form>

</body>
<script src="/memberJSP/js/member.js"></script>
</html>