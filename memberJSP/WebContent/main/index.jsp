<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> *** 메인화면 *** </h3>
<!-- 로그인이 안되어 있을 때 -->
<% if(session.getAttribute("memId")==null){ %>
	<a href="../member/writeForm.jsp">회원가입</a><br>
	<a href="../member/loginForm.jsp">로그인</a><br>
<%} else {%>
<!-- 로그인이 되어있을 때 -->
	<a href="../member/logout.jsp">로그아웃</a><br>
	<a href="../member/modifyForm.jsp">회원정보수정</a><br>
	<a href="../member/boardWriteForm.jsp">글쓰기</a><br>
<%}%>
<a href="">목록</a><br>

</body>
</html>