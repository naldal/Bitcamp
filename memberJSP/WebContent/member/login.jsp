<%@page import="java.net.URLEncoder"%>
<%@page import="javax.websocket.SendResult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO" %>
<%@ page import="member.dao.MemberDAO" %>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	MemberDAO memberDAO = MemberDAO.getinstance();
	String name = memberDAO.loginChecking(id, password);
	String email = memberDAO.getEmail(id, password);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<% if(name!=null) {

	/* 	
		//쿠키
		Cookie cookie = new Cookie("memName", name);
		cookie.setMaxAge(30*60); // 초단위
		response.addCookie(cookie); //클라이언트에게 보내기
		
		Cookie cookie2 = new Cookie("memId", id); 
		cookie2.setMaxAge(30*60);
		response.addCookie(cookie2); */
		
		//세션
		//HttpSession session = request.getSession();
		session.setAttribute("memName", name);
		session.setAttribute("memId", id);
		session.setAttribute("memEmail", email);
		
		response.sendRedirect("loginOk.jsp");
	} else {
		response.sendRedirect("loginFail.jsp");
	}%>

%>
</body>
</html>