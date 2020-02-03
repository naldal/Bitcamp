<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int x = Integer.parseInt(request.getParameter("xValue"));
	int y = Integer.parseInt(request.getParameter("yValue"));
%>

<%=x %>+<%=y %>=<%=x+y %><br>
<%=x %>-<%=y %>=<%=x-y %><br>
<%=x %>*<%=y %>=<%=x*y %><br>
<%=x %>/<%=y %>=<%=(1.0*x)/y %><br>
</body>
</html>