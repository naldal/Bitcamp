<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="board.dao.BoardDAO" %>

<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"/>

<%
//데이터
request.setCharacterEncoding("utf-8");

int seq = Integer.parseInt(request.getParameter("seq"));
int pg = Integer.parseInt(request.getParameter("pg"));

String subject = request.getParameter("subject");
String content = request.getParameter("content");

/* //세션
String id= (String)session.getAttribute("memId");
String name= (String)session.getAttribute("memName");
String email = (String)session.getAttribute("memEmail");

Map<String, String> map = new HashMap<String, String>();
map.put("id", id);
map.put("name", name);
map.put("email", email);
map.put("subject", subject);
map.put("content", content);
 */
 
//DB

Map<String,String> map = new HashMap<String, String>();
 map.put("seq", seq+"");
 map.put("subject", subject);
 map.put("content", content);
 
//boardDAO.boardModify(seq, subject, content);
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
window.onload=function() {
	alert("글 수정 완료");
	location.href="boardView.jsp?seq=<%=seq%>&pg=<%=pg%>";
}
</script>
</html>