<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>this is index page</title>
</head>
<body>

<table border="1" width="100%">
	<tr>
		<td colspan="2"><jsp:include page="../template/top.jsp"/></td>
	</tr>
	<tr width="30%" height="400">
		<td><jsp:include page="../template/left.jsp"/></td>
		<td><jsp:include page="../template/body.jsp"/></td>
	</tr>
	<tr >
		<td colspan="2"><jsp:include page="../template/bottom.jsp"/></td>
	</tr>
	
</table>

</body>
</html>