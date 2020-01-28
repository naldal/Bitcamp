<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.List"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head></head>
<body>


<div>

<%
	String name = (String)request.getAttribute("name");
%>

	이름 : <%=name%><br>
<%
	String gender = (String)request.getAttribute("gender");
%>
	성별 : <%=gender %><br>
<%
	String color = (String)request.getAttribute("color");
%>
	색깔 : <%=color %><br>

	기술 : 
<%
	List<String> subjects = (List<String>)request.getAttribute("subject");
	for(String e : subjects){
%>
	<%=e %> 
<%	
	}
%>
	<br>
	
	과목 : 
<%
	List<String> stacks = (List<String>)request.getAttribute("stacks");
	for(String e : stacks){
%>
	<%=e %> 
<%	
	}
%>
</div>
</body>
</html>






