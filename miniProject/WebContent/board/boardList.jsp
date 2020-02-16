<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
	
<c:if test="${requestScope.list ne null}">	
	<th>글번호</th><!-- 가운데 정렬 , 글씨 굵게 -->
	<th>제목</th>
	<th>작성자</th>
	<th>작성일</th>
	<th>조회수</th>
</c:if>


<c:if test="${list ne null}">
	<c:forEach var="i" begin="0" end="${list.size()}" step="1">
	<tr>
		<td width="50" align="center">
			${list[i].getSeq()}
		</td>
		
		<td>
		<a id="subjectA" width="300" href="javascript:void(0)" 
		onclick="isLogin(${id}, ${list[i].seq}, ${pg})">
			${list[i].subject}
		</a>
		</td>
		
		<td width="100" align="center">
			${list[i].name}
		</td>
		
		<td width="200" align="center">
			${list[i].logtime}
		</td>
		
		<td width="50" align="center">
			${list[i].hit}
		</td>
	</tr>
</c:forEach>
</c:if>
</table>

<div style=" float:left; width: 500px; text-align: center;">
${boardPaging.pagingHTML}</div>


</body>
<script type="text/javascript">
function isLogin(id, seq, pg) {
	alert("들어온 id : " + id);
	if(id=='null') {
		alert("먼저 로그인하세요.");
	} else {
		
		location.href="../main/index.jsp
	}
}
</script>
</html>
