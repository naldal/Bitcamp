<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<sql:query var="rs" dataSource="jdbc/oracle">
	select * from usertable where id='${param.id}'
</sql:query>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form name="modifyForm" method="post" action="jstlModify.jsp">
<!-- rs.rowsByIndex -->
		<table border="1" cellspacing="0" cellpadding="3">
		 <c:forEach var="row" items="${rs.rowsByIndex }">
			<tr>
				<td width="70" align="center">이름</td>
				<td><input type="text" name="name" value="${row[0] }" placeholder="수정 할 이름 입력" size=>
				</td>
			</tr>

			<tr>
				<td align="center">아이디</td>
				<td>
					<input type="text" name="id" value="${row[1] }" readonly>
				</td>
			</tr>

			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd" value="${row[2] }" placeholder="수정 할 비밀번호 입력"></td>
			</tr>
		</c:forEach> 
<!-- ****************************************************** -->
<!-- rs.rows 
		<table border="1" cellspacing="0" cellpadding="3">
		<c:forEach var="row" items="${rs.rows }">
			<tr>
				<td width="70" align="center">이름</td>
				<td><input type="text" name="name" value="${row.name }" size=>
				</td>
			</tr>

			<tr>
				<td align="center">아이디</td>
				<td>
					<input type="text" name="id" value="${row.id }" readonly>
				</td>
			</tr>

			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd" value="${row.pwd }"></td>
			</tr>
		</c:forEach>
		-->
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="수정">&emsp;
				<input type="reset" value="다시작성">&emsp;
				<input type="button" value="취소" onclick="location.href='jstlList.jsp'">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>