<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="board.bean.BoardDTO"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>
<%
	//req
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	//paging
	int endNum = pg*5;
	int startNum = endNum-4;
	int totalA = boardDAO.getTotalBoard();
	int totalP = (totalA+4)/5;
	
	List<BoardDTO> list = boardDAO.boardList(startNum, endNum);
	
	String id = (String)session.getAttribute("memId");
	if(id==null){
		System.out.print("this is null id");
	} 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardlist.jsp</title>
</head>
<style>
	#subjectId {
		color:black;
		text-decoration: none;
	}
	
	#subjectId:hover {
		text-decoration: underline;
	}
</style>
<body>
<h3>글쓰기</h3>
<table border="1" cellpadding="5" frame="hsides" rules="rows">

    <tr>
        <th>글번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회수</th>
    </tr>
    

<% for(BoardDTO boardDTO : list) { %>
	<tr>
	    <td width="50" align="center"><%=boardDTO.getSeq() %></td>
	    <td width="300" align="center">
		<a href="#" id="subjectId" onclick="isLogin(<%=id%>)"><%=boardDTO.getSubject() %></a>
	    </td>
	    <td width="100" align="center"><%=boardDTO.getName() %></td>
	    <td width="200" align="center"><%=boardDTO.getLogtime() %></td>
	    <td width="50" align="center"><%=boardDTO.getHit() %></td>
	</tr>
<% } %>
</table>
<div style="border: 1px solid red; width:100px; display:inline;">
	<jsp:include page="../main/logo.jsp"/>
</div>
<div style="border: 1px solid blue; width: 300px; display:inline">asdf</div>
</body>
<script type="text/javascript" src="../js/boardList.js"></script>
</html>