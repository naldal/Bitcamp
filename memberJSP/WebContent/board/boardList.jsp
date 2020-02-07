<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="board.bean.BoardDTO"%>
<%@ page import="board.bean.BoardPaging" %>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>
<%
	//req
	int pg;
	
	if(request.getParameter("pg")!=null) {
		pg = Integer.parseInt(request.getParameter("pg"));
	} else {
		pg=1;
	}
	
	String id = (String)session.getAttribute("memId");
	
	//paging
	int endNum = pg*5;
	int startNum = endNum-4;
	List<BoardDTO> list = boardDAO.boardList(startNum, endNum);
	
	//페이징 처리
	BoardPaging boardPaging = new BoardPaging();
	int totalA = boardDAO.getTotalBoard();
	boardPaging.setCurrentPage(pg);
	boardPaging.setPageBlock(3);
	boardPaging.setPageSize(5);
	boardPaging.setTotalA(totalA);
	
	boardPaging.makePagingHTML();
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
		color:blue;
		text-decoration: underline;
	}
	
	#paging {
		color: black;
		text-decoration: none;
		cursor:pointer;
	}
	
	#currentPaging {
		color: red;
		text-decoration: underline;
		cursor:pointer;
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
		<a href="javascript:isLogin('<%=id%>', <%=boardDTO.getSeq()%>, <%=pg%>)" id="subjectId"><%=boardDTO.getSubject() %></a>
	    </td>
	    <td width="100" align="center"><%=boardDTO.getName() %></td>
	    <td width="200" align="center"><%=boardDTO.getLogtime() %></td>
	    <td width="50" align="center"><%=boardDTO.getHit() %></td>
	</tr>
<% } %>
</table>
<div style="float:left; width:70px;">
	<jsp:include page="../main/logo.jsp"/>
</div>
<div style="float:left; text-align:center; width: 700px"><%=boardPaging.getPagingHTML() %></div>
</body>
<script type="text/javascript">
function isLogin(id, seq, pg){
	if(id=='null'){
		alert("먼저 로그인을 하세요");
	} else {
		location.href="boardView.jsp?seq="+seq+"&pg="+pg;
	}
}
</script>
</html>