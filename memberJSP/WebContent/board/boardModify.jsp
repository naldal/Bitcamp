<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>
<%@ page import="board.bean.BoardDTO"%>

    
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	String subject = (String)request.getParameter("subject");
	String content = (String)request.getParameter("content");
	
	boolean flag = boardDAO.modifyBoard(seq, subject, content); 
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(flag) {
		out.print("정상 수정되었습니다.");
	} else {
		out.print("nope");
	}
%>
</body>
</html>