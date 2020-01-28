<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>결과 페이지 입니다.</title>
<body>
<%
	String name = (String)request.getAttribute("name");

%>

<%=name%>님에 대한 데이터가 저장되었습니다.
</body>