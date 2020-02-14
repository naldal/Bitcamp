<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<jsp:useBean id="dataDTO" class="exam.bean.DataDTO" scope="session"/>
<!-- 위의 내용은 =>DataDTO dataDTO = new DataDTO();
대신 계속해서 생성해내는게 아니고 싱글톤의 개념 -->
<jsp:setProperty property="x" name="dataDTO" />
<jsp:setProperty property="y" name="dataDTO" />
<!-- dataoDTO의 Public void set x와y를 실행하는 코드 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:getProperty property="x" name="dataDTO"/> +
<jsp:getProperty property="y" name="dataDTO"/> =
<%=dataDTO.getX()+dataDTO.getY() %>
<br><br>
<input type="button" value="곱 구하기" onclick="location.href='mul.jsp'">
</form>
</body>
</html>