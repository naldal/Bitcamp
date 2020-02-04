<%@page import="java.net.URLEncoder"%>
<%@page import="javax.websocket.SendResult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO" %>
<%@ page import="member.dao.MemberDAO" %>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	MemberDAO memberDAO = MemberDAO.getinstance();
	String name = memberDAO.loginChecking(id, pwd);
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% if(name!=null) {
		//session.setAttribute("id", id);
		response.sendRedirect("loginOk.jsp?id="+URLEncoder.encode(id,"UTF-8"));	
	%>
	<%} else {
		response.sendRedirect("loginFail.jsp");
	}%>

%>
</body>
</html>