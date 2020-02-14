<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="board.dao.BoardDAO"%>
<%@ page import="board.bean.BoardDTO"%>

<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>
<jsp:useBean id="boardDTO" class="board.bean.BoardDTO"></jsp:useBean>
<%
	request.setCharacterEncoding("utf-8");

	//데이터
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	//조회수 - 새로고침 방지
	Cookie[] ar = request.getCookies();
	if(ar!=null) {
		for(int i=0; i<ar.length; i++) {
			if(ar[i].getName().equals("memHit")) {
				boardDAO.boardHit(seq);
				ar[i].setMaxAge(0);
				response.addCookie(ar[i]);
			}
		}
	}
	
	//DB
	boardDTO = boardDAO.getBoard(seq);
	
	String subject = boardDTO.getSubject();
	String content = boardDTO.getContent();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.contents {
	white-space:pre-wrap;
	word-break: break-all;
}
</style>
</head>
<body>
	<form name="boardViewForm" method="post">
	<input type="hidden" name="seq" value="<%=seq%>">
	<input type="hidden" name="pg" value="<%=pg%>">
	<input type="hidden" name="subject" value="<%=subject%>">
	<input type="hidden" name="content" value="<%=content%>">
	<table width= "450" border="1" cellpadding="5" frame="hsides" rules="rows">
		<tr>
			<td colspan="3">
				<h3><%=boardDTO.getSubject()%></h3>
			</td>
		</tr>
		<tr>
			<td width="150">글번호 : <%=boardDTO.getSeq()%></td>
			<td width="150">작성자 : <%=boardDTO.getId()%></td>
			<td width="150">조회수 : <%=boardDTO.getHit()%></td>
		</tr>

		<tr>
			<td colspan="3" height="200" valign="top"><pre class="contents"><%=boardDTO.getContent()%></pre>
			</td>
		</tr>

	</table>
	<input type="button" value="목록" onclick="location.href='boardList.jsp?pg=<%=pg%>'">
	<%if (session.getAttribute("memId").equals(boardDTO.getId())) {%>
	<%-- <input type="button" value="글수정" onclick="location.href='boardModifyForm.jsp?seq=<%=seq%>&pg=<%=pg%>'"> --%>
<!-- 	<input type="button" value="글삭제" onclick=""> -->
	<input type="button" value="글수정" onclick="mode(1)">
	<input type="button" value="글삭제" onclick="mode(2)">
	<%
		}
	%>
	</form>
</body>
<script type="text/javascript">
function mode(num) {
	if(num==1) {
		document.boardViewForm.method = 'post';
		document.boardViewForm.action = 'boardModifyForm.jsp';
		document.boardViewForm.submit();
	} else if(num==2) {
		document.boardViewForm.method = 'post';
		//document.boardViewForm.action = 'boardDelete.jsp';
		document.boardViewForm.submit();
	}
}
</script>
</html>