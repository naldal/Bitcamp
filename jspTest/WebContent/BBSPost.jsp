<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*, java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	Date date = new Date();
	Long time = date.getTime();
	String filename = time+".txt";
	String result = "";
	PrintWriter writer = null;
	
	try {
		String filePath = application.getRealPath("/WEB-INF/bbs/"+filename);
		writer = new PrintWriter(filePath);
		writer.printf("����: %s %n",title);
		writer.printf("�۾��� :  %s %n", name);
		writer.printf(content);
		out.println("����Ǿ����ϴ�");
		result="SUCCESS";
	} catch(Exception e){
		out.println("���Ͽ� �����͸� �� �� �����ϴ�.");
	} finally {
		try {
			writer.close();
		} catch (Exception e){
			result="FAIL";
		}
	}
	response.sendRedirect("BBSPostResult.jsp?RESULT="+result);
%>
</body>
</html>