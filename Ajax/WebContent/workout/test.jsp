<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="utf-8"/>
<% String name = request.getParameter("name"); %>
<c:set var="date" value="${param.date}"/>
<c:set var="year" value="${fn:substring(date,0,4)}"/>
<c:set var="month" value="${fn:substring(date,4,6)}"/>
<c:set var="day" value="${fn:substring(date,6,8)}"/>
<%=name%>���� ������ <c:out value="${year}"/>�� <c:out value="${month}"/>�� <c:out value="${day}"/>�� �Դϴ�.
<c:set var="tyear" value="2021"></c:set>

<c:set var="age" value="${tyear - year}"/>
���̴� <c:out value="${age}"/>�Դϴ�