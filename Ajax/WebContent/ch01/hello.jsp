<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>    
<%-- <%
String name = request.getParameter("name");
%>

�ȳ��ϼ��� <%=name%> --%>
<fmt:requestEncoding value="utf-8"/>
�ȳ��ϼ��� ${param.name}��