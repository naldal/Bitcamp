<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��� ������ �Դϴ�.</title>
<body>
<%
	String name = (String)request.getAttribute("name");

%>

<%=name%>�Կ� ���� �����Ͱ� ����Ǿ����ϴ�.
</body>