<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>
<%@ page import="board.bean.BoardDTO"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>

    
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	String subject = (String)request.getParameter("subject");
	String content = (String)request.getParameter("content");
	
	Map<String, String> map = new HashMap<String, String>();
	map.put("seq", seq+"");
	map.put("subject", subject);
	map.put("content", content);
	
	
	boardDAO.boardModify(map); 
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
	location.href='boardView.jsp?seq='+<%=seq%>+'&pg='+<%=pg%>;
}
</script>
</html>