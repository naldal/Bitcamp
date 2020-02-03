<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO" %>
<%@ page import="member.dao.MemberDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	System.out.println(id);
	System.out.println(pwd);
	
	MemberDAO memberDAO = MemberDAO.getinstance();
	boolean flag1 = memberDAO.loginChecking(id, pwd);
	
	response.setContentType("text/html;charset=UTF-8");
	if(flag1) {
		out.println("로그인 성공. "+id+"님 어서오세요");
	} else {
		out.println("로그인 실패.");
	}

%>
</body>
</html>