<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="utf-8"/>
<sql:query dataSource="jdbc/oracle" var="result">
	select * from imageboard
</sql:query>

<table border="1" width="100%">
	<tr>
		<th>글번호</th>
		<th>ImageID</th>
		<th>ImageName</th>
		<th>ImagePrice</th>
		<th>ImageQty</th>
		<th>ImageContent</th>
		<th>Image1</th>
		<th>Logtime</th>
	</tr>
<c:forEach var="row" items='${result.rows}'>
	<tr>
		<td><c:out value='${row.seq}'/></td>
		<td><c:out value='${row.imageid}'/></td>
		<td><c:out value='${row.imagename}'/></td>
		<td><c:out value='${row.imageprice}'/></td>
		<td><c:out value='${row.imageqty}'/></td>
		<td><c:out value='${row.imagecontent}'/></td>
		<td><img src=<c:out value='${row.image1}'/>></td>
		<td><c:out value='${row.logtime}'/></td>
	</tr>
</c:forEach>
</table>