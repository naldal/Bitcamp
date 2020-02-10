<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>
<%@ page import="board.bean.BoardDTO" %>

<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	String subject = (String)request.getParameter("subject");
	String content = (String)request.getParameter("content");
%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>글수정</title>
<style type="text/css">
	#preSelector {
		white-space: pre-wrap;
		word-break: break-all;
	}
</style>
</head>
<body>
<h3>글 수정</h3>
    <form name="boardModifyForm" action="boardModify.jsp" method="get">
    <input type="hidden" name="pg" value="<%=pg%>">
       <table border=1 cellpadding="3" cellspacing="0">
        <tr>
        <td class='key'>제목</td>
        <td class='value'>
          <input type="hidden" name="seq" value=<%=seq%>>
          <input type="text" name="subject"size="50" value=<%=subject%>>
        </td>
      </tr>
        <tr>
        <td class='key'>내용</td>
        <td class='value'>
          <textarea name="content" cols="60" rows="10"><%=content%></textarea>
        </td>
      </tr>
        <tr>
          <td colspan="2" align="center">
            <input type="button" value="글수정" onclick="boardModify()">
            <input type="reset" value="다시작성">
          </td>
        </tr>
      </table>
  </form>
</body>
<script type="text/javascript">
function boardModify(){
	/* if(document.boardModifyForm.subject.value=="")
		alert("제목을 입력하세요");
	else if(document.boardModifyForm.content.value=="")
		alert("내용을 입력하세요");
	else  */
		document.boardModifyForm.submit();
}
</script>
</html>