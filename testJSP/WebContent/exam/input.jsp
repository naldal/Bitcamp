<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="/testJSP/exam/result.jsp">
<table border="1" cellspacing="0" cellpadding="3">

<tr>
<td align="center" width="60" >X</td>
<td>
<input type="text" name="X" size="7">
</td>
</tr>

<tr>
<td align="center">Y</td>
<td>
<input type="text" name="Y" size="7">
</td>
</tr>
<td colspan="2" align="center">
<input type="submit" value="계산">
<input type="reset" value="취소">
</td>
<tr >
</tr>

</table>
</form>
</body>
</html>