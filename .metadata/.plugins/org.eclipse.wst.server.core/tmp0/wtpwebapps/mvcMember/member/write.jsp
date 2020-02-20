<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="memberDTO" class="member.bean.MemberDTO" scope="session"/>
<jsp:setProperty property="*" name="memberDTO" />

<%-- 이 아래부터 주석처리된 두덩이가 위의 두줄로 해결.

<%String name = request.getParameter("name"); %>
<%String id = request.getParameter("id"); %>
<%String pwd = request.getParameter("pwd"); %>
<%String gender = request.getParameter("gender"); %>
<%String email1 = request.getParameter("email1"); %>
<%String email2 = request.getParameter("email2"); %>
<%String tel1 = request.getParameter("tel1"); %>
<%String tel2 = request.getParameter("tel2"); %>
<%String tel3 = request.getParameter("tel3"); %>
<%String zipcode = request.getParameter("zipcode"); %>
<%String addr1 = request.getParameter("addr1"); %>
<%String addr2 = request.getParameter("addr2"); %>
--%>


<%--
<% MemberDTO memberDTO = new MemberDTO();
<% memberDTO.setName(); %>
<% memberDTO.setId(id); %>
<% memberDTO.setPwd(pwd); %>
<% memberDTO.setGender(gender); %>
<% memberDTO.setEmail1(email1); %>
<% memberDTO.setEmail2(email2); %>
<% memberDTO.setTel1(tel1); %>
<% memberDTO.setTel2(tel2); %>
<% memberDTO.setTel3(tel3); %>
<% memberDTO.setZipcode(zipcode); %>
<% memberDTO.setAddr1(addr1); %>
<% memberDTO.setAddr2(addr2); %>
--%>


<% MemberDAO memberDAO = MemberDAO.getInstance(); %>
<% int su = memberDAO.memberWrite(memberDTO); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(su==1) { %>
회원가입 성공
<% } else { %>
회원가입 실패
<%} %>
</body>
</html>