<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%!
//전역변수 - 서블릿의 init()에 해당 => 실행시 딱 1번 실행
String name = "홍길동";
int age = 25;
%>

<%
//지역변수, 요청시마다 실행한다.
age++;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  Hello jsp!!<br> -->
<%-- 안녕하시오 jsp!!<br> --%>
나의 이름은 <%=name%> 입니다.<br>
<!-- 내 나이는 <%=age %>살 입니다.<br> -->

<%--<%out.println("내 나이는 " + age + "살 입니다.");%>--%>
</body>
</html>



