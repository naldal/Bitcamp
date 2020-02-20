<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="utf-8"/>
<sql:update dataSource="jdbc/oracle" var="su">
	update usertable set name='${param.name }', pwd='${param.pwd }' where id='${param.id }'
</sql:update>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <c:if test="${su==1 }">정보 수정 완료</c:if>
<c:if test="${su==0 }">정보 수정 실패</c:if> --%>
</body>
<script type="text/javascript">
window.onload=function(){
	alert("회원정보수정 완료");
	location.href='jstlList.jsp';
}

</script>
</html>