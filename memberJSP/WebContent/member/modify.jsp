<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="memberDAO" class="member.dao.MemberDAO"/>
<jsp:useBean id="memberDTO" class="member.bean.MemberDTO"/>
<jsp:setProperty property="*" name="memberDTO"/>

<% memberDAO.modify(memberDTO); %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
window.onload=function(){
	alert("회원정보를 수정하였습니다.");
	location.href="../main/index.jsp";
}
</script>

</body>
</html>