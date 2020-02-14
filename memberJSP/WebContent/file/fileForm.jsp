<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data" action="fileUpload.jsp">
		<table border="1">
			<tr>
				<td align="center" width="70">제목</td>
				<td><input type="text" name="subject" size="30"></td>
			</tr>

			<tr>
				<td align="center">내용</td>
				<td><textarea name="content" cols="55" rows="10"></textarea></td>
			</tr>
			
			<tr>
				<td colspan="2"> 
					<input type="file" name="upload1" size="50">
				</td>
			</tr>
			
			<tr>
				<td colspan="2"> 
					<input type="file" name="upload2" size="50">
				</td>
			</tr>
			
			<tr>
				<td align="center" colspan="2"> 
					<input type="submit" value="파일 업로드">&emsp;
					<input type="reset" value="취소">
				</td>
			</tr>

		</table>
	</form>
</body>
</html>