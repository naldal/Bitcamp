<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<table border="1" width="100%">
	<tr style="text-align:center;">
		<td colspan="2" ><jsp:include page="../template/top.jsp"/></td>
	</tr>
	<tr height="300">
		<td valign="top" width="30%">
			<jsp:include page="../template/left.jsp"/>
			<%-- <c:if test="${sessionScope.memId eq null}">
				<jsp:include page="../member/loginForm.jsp"/>
				<input type="hidden" id="fail" value="${fail}">
				<div style="margin-top: 8px" id='loginChk' align="center"></div>
			</c:if>
			<c:if test="${sessionScope.memId ne null}">
				<jsp:include page="../member/loginOk.jsp"/>
			</c:if> --%>
		</td>
		<td>
			<jsp:include page="${display}"/>
		</td>
	</tr>
	<tr >
		<td colspan="2"><jsp:include page="../template/bottom.jsp"/></td>
	</tr>
	
</table>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>	
<script type="text/javascript" src="../js/member.js"></script>