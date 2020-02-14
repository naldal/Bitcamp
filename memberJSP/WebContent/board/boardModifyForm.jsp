<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");

int seq = Integer.parseInt(request.getParameter("seq"));
int pg = Integer.parseInt(request.getParameter("pg"));
String subject = request.getParameter("subject");
String content = request.getParameter("content");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>글 수정하기</h3><br>
<form name="boardModifyForm" method="post" action="boardModify.jsp">
<table border="1" cellspacing="0" cellpadding="3">
<tr>
<td align="center" width="70">제목</td> 
<td>
<input type="text" name="subject" id="subject" placeholder="제목 입력"  value="<%=subject %>" size="30">
</td>
</tr>

<tr>
<td align="center">내용</td>
<td>
<textarea name="content" id="content" cols="55" rows="10"><%=content %></textarea>
</td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="hidden" name="seq" value="<%=seq%>">
<input type="hidden" name="pg" value="<%=pg%>">
<input type="button" value="수정" onclick="boardModify()">&emsp;
<input type="button" value="취소" onclick="location.href='boardView.jsp?seq=<%=seq%>&pg=<%=pg%>'">
</td>
</tr>

</table>
</form>

</body>
<script>
function boardModify() {
	if(document.boardModifyForm.subject.value=="") {
		alert("수정 할 제목을 입력하세요.");
	} else if(document.boardModifyForm.content.value=="") {
		alert("수정 할 내용을 입력하세요.");
	} else {
		document.boardModifyForm.submit();
	}
}
</script>
</html>

<%-- <!-- location.href='boardList.jsp?seq=<%=seq%>&pg=<%=pg%>' --> --%>