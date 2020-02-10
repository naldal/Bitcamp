<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.BufferedInputStream, java.io.BufferedOutputStream, java.io.FileInputStream" %>

<%@ page import="java.io.File" %>
<%@page import="java.net.URLEncoder"%>
    
<%
	//데이터
	String fileName = request.getParameter("fileName");
	String realFolder = request.getServletContext().getRealPath("/storage");
	
	//다운로드 받을 파일 생성
	File file = new File(realFolder, fileName);
	fileName = URLEncoder.encode(fileName, "UTF-8").replace("+"," ");
	
	response.setHeader("Content-Disposition", "attachment;fileName="+fileName);
	response.setHeader("Content-Length", file.length()+"");
	
	out.clear();
	out = pageContext.pushBody();
	
	BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
	BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	
	int size = (int)file.length();
	byte[] b = new byte[size];
	bis.read(b,0,size); /* 배열의 0번째 방부터 현재 사이즈까지의 모든 바이트를 저장 */
	bos.write(b);
	
	bis.close();
	bos.close();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>