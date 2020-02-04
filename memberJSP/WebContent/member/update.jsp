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
	<jsp:useBean id="memberDTO" class="member.bean.MemberDTO"/>
	<jsp:setProperty property="*" name="memberDTO"/>
<%
	//DB
	System.out.println("memberDTO : "+memberDTO.getId());
	System.out.println(memberDTO.getName());
	System.out.println(memberDTO.getGender());
	
	MemberDAO memberDAO = MemberDAO.getinstance();
	int su = memberDAO.update(memberDTO);
	if(su>=1)
		out.println("수정 성공");
	else
		out.println("수정 실패ㅁㅇㄴㄻㄴㅇㄻㄴㅇㄻㄴㅇㄻㄴㅇ");
%>

</body>
</html>