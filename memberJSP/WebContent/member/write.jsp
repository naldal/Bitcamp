<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
	<jsp:useBean id="memberDTO" class="member.bean.MemberDTO"></jsp:useBean>
	<jsp:setProperty property="*" name="memberDTO"/>
<%
	//DB
	MemberDAO memberDAO = MemberDAO.getinstance();
	int su = memberDAO.write(memberDTO);
	if(su==1)
		out.println("회원가입 성공");
	else
		out.println("회원가입 실패");
%>
</body>
</html>