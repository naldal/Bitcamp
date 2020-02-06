<%@page import="java.net.URLEncoder"%>
<%@page import="javax.websocket.SendResult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO"%>
<%@ page import="member.dao.MemberDAO"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String password = request.getParameter("password");

	MemberDAO memberDAO = MemberDAO.getinstance();
	MemberDTO memberDTO = memberDAO.login(id, password);


	if (memberDTO != null) {
		session.setAttribute("memName", memberDTO.getName());
		session.setAttribute("memId", memberDTO.getId());

		//email
		String email = memberDTO.getEmail1() + "@" + memberDTO.getEmail2();
		
		session.setAttribute("memEmail", email);

		response.sendRedirect("loginOk.jsp");
	} else {
		response.sendRedirect("loginFail.jsp");
	}
%>
</body>
</html>