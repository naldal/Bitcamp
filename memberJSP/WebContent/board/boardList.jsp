<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="member.bean.MemberDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.bean.BoardPaging" %>

<<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>
    
<%
request.setCharacterEncoding("utf-8");

String id = (String)session.getAttribute("memId");
MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");

//데이터
int pg = Integer.parseInt(request.getParameter("pg"));

//DB

int endNum = pg*5;
int startNum = endNum-4;

List<BoardDTO> list = boardDAO.getBoardList(startNum, endNum);

//페이징 처리
BoardPaging boardPaging = new BoardPaging();
int totalA = boardDAO.getTotalArticle(); // 총글수
boardPaging.setCurrentPage(pg);
boardPaging.setPageBlock(3);
boardPaging.setPageSize(5);
boardPaging.setTotalA(totalA);

boardPaging.makePagingHTML();

//조회수 - 새로고침 방지
if(session.getAttribute("memId")!=null) {
	Cookie cookie = new Cookie("memHit", "0");
	cookie.setMaxAge(30*60);
	response.addCookie(cookie);
}


%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
#subjectA:link{text-decoration:none; color : black;}
#subjectA:hover {color : green; text-decoration:underline;}
#subjectA:active {color : red; font-weight:bold;}

#paging {
	color : black;
	text-decoration: none;
	cursor : pointer;
}

#currentPaging {
	color : red;
	text-decoration : underline;
	cursot : pointer;
}
</style>

</head>
<body>
<table border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
	<th>글번호</th><!-- 가운데 정렬 , 글씨 굵게 -->
	<th>제목</th>
	<th>작성자</th>
	<th>작성일</th>
	<th>조회수</th>
<%if(list!=null){ %>
	<%-- <%for (BoardDTO boardDTO : list) { System.out.println(boardDTO.getSeq());%> --%>
	<%for (int i=0; i<list.size(); i++) { %>
	<tr>
		<td width="50" align="center"><%=list.get(i).getSeq() %></td>
		<td>
		<a id="subjectA" width="300" href="javascript:void(0)" onclick="isLogin('<%=id%>', <%=list.get(i).getSeq()%>, <%=pg%>)">
		<%=list.get(i).getSubject() %>
		</a>
		</td>
		<td width="100" align="center"><%=list.get(i).getId() %></td>
		<td width="200" align="center"><%=list.get(i).getLogtime() %></td>
		<td width="50" align="center"><%=list.get(i).getHit() %></td>
	</tr>
<%}//for %>
<%}//if %>
</table>
<div style=" float:left; width: 50px; margin-right:50px;">
	<jsp:include page="../main/logo.jsp"></jsp:include>
</div>

<div style=" float:left; width: 500px; text-align: center;"><%=boardPaging.getPagingHTML() %></div>

</body>
<script type="text/javascript">
function isLogin(id, seq, pg) {
	alert("들어온 id : " + id);
	if(id=='null') {
		alert("먼저 로그인하세요.");
	} else {
		location.href="boardView.jsp?seq="+seq+"&pg="+pg;
	}
}
</script>
</html>