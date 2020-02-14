<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="" method = "post" action="jstlResult.jsp">
<table border = "1" cellspacing = "0" cellpadding = "5">

<tr>
	<td width = "70" align="center">이름</td>
	<td><input type="text" name="name" placeholder="이름 입력"></td>
</tr>

<tr>
	<td width = "70" align="center">나이</td>
	<td><input type="text" name="age"></td>
</tr>

<tr>
	<td width = "70" align="center">색깔</td>
	<td>
	<select name="color" style = "width: 100px;">
	<option value="red">빨 강</option>
	<option value="blue">파 랑</option>
	<option value="magenta">보 라</option>
	<option value="green">초 록</option>
	<option value="orange">주 황</option>
	</select>
	</td>
</tr>

<tr>
	<td width = "70" align="center">취미</td>
	<td>
	<input type="checkbox" name="hobby" value="독서">독서 
	<input type="checkbox" name="hobby"value="영화">영화 
	<input type="checkbox" name="hobby"value="음악">음악 
	<input type="checkbox" name="hobby" value="게임">게임 
	<input type="checkbox" name="hobby" value="쇼핑">쇼핑
	</td>
</tr>

<tr>
	<td colspan ="2" align ="center">
	<input type="submit" value="SEND">&emsp;
	<input type="reset" value="CANCEL">
	</td>
</tr>
</table>

</form>

</body>
</html>