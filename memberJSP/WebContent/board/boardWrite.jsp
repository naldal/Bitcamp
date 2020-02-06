<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="boardDTO" class="board.bean.BoardDTO"/>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"/>

<%
//데이터
boardDTO.setId((String)session.getAttribute("memId"));
boardDTO.setName((String)session.getAttribute("memName"));
boardDTO.setEmail((String)session.getAttribute("memEmail"));
boardDTO.setSubject(request.getParameter("subject"));
boardDTO.setContent(request.getParameter("content"));

//DB
Map<String,String> map = new HashMap<String,String>();
map.put("id", boardDTO.getId());
map.put("name", boardDTO.getName());
map.put("email", boardDTO.getEmail());
map.put("subject", boardDTO.getSubject());
map.put("content", boardDTO.getContent());
boardDAO.boardWrite(map);

%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
<script type="text/javascript">
window.onload=function(){
	alert("작성 완료.");
	location.href='boardList.jsp?pg=1';
}
</script>
</html>