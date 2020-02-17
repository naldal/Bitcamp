<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
	
<c:if test="${requestScope.list ne null}">	
	<th>글번호</th><!-- 가운데 정렬 , 글씨 굵게 -->
	<th>제목</th>
	<th>작성자</th>
	<th>작성일</th>
	<th>조회수</th>
</c:if>


<c:if test="${list ne null}">
	<c:forEach var="boardDTO" items="${list}">
	<tr>
		<td width="50" align="center">
			${boardDTO.seq}
		</td>
		
		<td>
		<a id="subjectA" width="300" href="javascript:void(0)" 
		onclick="isLogin('${id}', ${boardDTO.seq}, ${pg})">
			${boardDTO.subject}
		</a>
		</td>
		
		<td width="100" align="center">
			${boardDTO.name}
		</td>
		
		<td width="200" align="center">
			${boardDTO.logtime}
		</td>
		
		<td width="50" align="center">
			${boardDTO.hit}
		</td>
	</tr>
</c:forEach>
</c:if>
</table>

<div style=" float:left; width: 500px; text-align: center;">
${boardPaging.pagingHTML}
</div>

<script type="text/javascript">
function isLogin(id, seq, pg){
	if(id==''){
		alert('먼저 로그인 하세용');
	} else {
		location.href="boardView.jsp?seq="+seq+"&pg="+pg;
	}
}

</script>

