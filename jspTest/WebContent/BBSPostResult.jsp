<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h2>�۾���</h2>
<%
	String str = request.getParameter("RESULT");
	if(str.equals("SUCCESS"))
		out.println("����Ǿ����ϴ�.");
	else
		out.println("���Ͽ� �����͸� �� �� �����ϴ�.");
%>
</body>
</html>