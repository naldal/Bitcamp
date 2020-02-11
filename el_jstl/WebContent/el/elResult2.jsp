<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="angel" uri="uri"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8"> 
<title></title>
</head>
<body>

${param.x}+${param.y}=${angel:sum(param.x, param.y)}<br>
${param.x}*${param.y}=${angel:mul(param.x, param.y)}<br>

</body>
</html>