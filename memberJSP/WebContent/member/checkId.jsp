<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.dao.MemberDAO"%>
    
<%

String id = request.getParameter("id");


MemberDAO memberDAO = MemberDAO.getinstance();
boolean exist = memberDAO.isExistId(id);

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="checkId.jsp">
<% if(exist) { %>
	<%=id%>는 사용불가능<br><br>
	아이디<input type="text" name="id">
	<input type="submit" value="중복체크">
<% } else { %>
	<%=id%>는 사용 가능 <br><br>
	<input type="button" value="사용하기" onclick="checkIdClose('<%=id%>')">
<%}%>
</form>
</body>
<script type="text/javascript" src="../js/member.js"></script>
</html>