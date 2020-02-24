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
<%=name%>님의 생일은 <c:out value="${year}"/>년 <c:out value="${month}"/>월 <c:out value="${day}"/>일 입니다.
<c:set var="tyear" value="2021"></c:set>

<c:set var="age" value="${tyear - year}"/>
나이는 <c:out value="${age}"/>입니다