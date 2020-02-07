<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>
<%@ page import="board.bean.BoardDTO" %>

<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));

	BoardDTO boardDTO = boardDAO.getBoard(seq);
%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성한 글 확인</title>
<style type="text/css">
	#preSelector {
		white-space: pre-wrap;
		word-break: break-all;
	}
</style>
</head>
<body>
<h3>글쓰기</h3>
<table border="1" cellpadding="5" frame="hsides" rules="rows">

    <tr>
        <td colspan="3">
        	<h3><%=boardDTO.getSubject()%></h3>
        </td>
    </tr>
    
    <tr>
    	<td width="150">글번호 : <%=boardDTO.getSeq()%></td>
    	<td width="150">작성자 : <%=boardDTO.getName()%></td>
    	<td width="150">조회수 : <%=boardDTO.getHit()%></td>
   	</tr> 
    
    <tr>
        <td colspan="3" height="200" valign="top" width="500px">
        	<pre id="preSelector"><%=boardDTO.getContent()%></pre>
        </td>
    </tr>
</table>
<input type="button" value="목록" onclick="location.href='boardList.jsp?pg=<%=pg%>'">
<% if(session.getAttribute("memId").equals(boardDTO.getId())) {%>
	<input type="button" value="글수정" onclick="location.href=
	'boardModifyForm.jsp?seq=<%=seq%>&pg=<%=pg%>&subject=<%=boardDTO.getSubject()%>&content=<%=boardDTO.getContent()%>'">
	<input type="button" value="글삭제">
<%} %>
</body>
<script type="text/javascript" src="../js/board.js"></script>
</html>