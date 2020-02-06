<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="board.dao.BoardDAO"%>
<%@ page import="board.bean.BoardDTO"%>
<%
	//req
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	//db
	BoardDAO boardDAO = BoardDAO.getinstance();
	
	//paging
	int endNum = pg*5;
	int startNum = endNum-4;
	int totalA = boardDAO.getTotalBoard();
	int totalP = (totalA+4)/5;
	
	List<BoardDTO> list = boardDAO.listing(startNum, endNum); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글쓰기</h3>
<table border="1">
    <tr>
        <td>글번호</td>
        <td>제목</td>
        <td>작성자</td>
        <td>작성일</td>
        <td>조회수(hit)</td>
    </tr>
    
<%-- <%
if(list!=null) {
	for(int i=0; i<totalP; i++) {
		if(i==pg)
			out.println("[a id='currentPaging' href='/memberJSP/boardList?pg="+i+"'>"+i+"</a>]");
		else
			out.println("[a id='currentPaging' href='/memberJSP/boardList?pg="+i+"'>"+i+"</a>]");
	}
}
%> --%>
<% for(BoardDTO boardDTO : list) { %>
	<tr>
	    <td><%=boardDTO.getSeq() %></td>
	    <td><%=boardDTO.getSubject() %></td>
	    <td><%=boardDTO.getName() %></td>
	    <td><%=boardDTO.getLogtime() %></td>
	    <td><%=boardDTO.getHit() %></td>
	</tr>
<% } %>
</table>
</body>
</html>