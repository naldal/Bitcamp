<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="member.bean.MemberDTO" %>

<%request.setCharacterEncoding("utf-8"); %>

<% String id = request.getParameter("id"); %>
<% String pwd = request.getParameter("pwd"); %>

<% MemberDAO memberDAO = MemberDAO.getInstance(); %>
<% MemberDTO memberDTO = memberDAO.login(id, pwd);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
System.out.println(memberDTO);
if(memberDTO!=null){ 
	//response.sendRedirect("loginOk.jsp?name=" + URLEncoder.encode(name,"utf-8") + "&id="+URLEncoder.encode(id,"utf-8"));
	//이미 공개된 정보라고 해도 개인 정보를 페이지 이동 간에 실으면 안된다,
	//쿠키 혹은 세션을 이용해야 하는데 쿠키는 클라이언트 내에 저장되기에
	//개인정보의 경우는 서버 쪽에 저장되는 세션을 이용.
	
	//쿠키
/* 	Cookie cookie = new Cookie("memName", name);
	cookie.setMaxAge(30*60);//초 단위
	response.addCookie(cookie);//클라이언트에게 보내기

	Cookie cookie2 = new Cookie("memId", id);
	cookie.setMaxAge(30*60);
	response.addCookie(cookie2); */
	
	//세션
	//HttpSession session = request.getSession(); 내장객체가 있어 새로 생성시 중복
	session.setAttribute("memName", memberDTO.getName());
	session.setAttribute("memId", id);
	session.setAttribute("memEmail", memberDTO.getEmail1() + "@" + memberDTO.getEmail2());
	
	session.setAttribute("member", memberDTO);
	
	response.sendRedirect("loginOk.jsp");
} else { 
	response.sendRedirect("loginFail.jsp");
}
%>
</body>
</html>