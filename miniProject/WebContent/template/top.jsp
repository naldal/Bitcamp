<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>
<img src="../img/3.jpg" width="70" height="70" 
onclick="location.href='/miniProject/main/index.do'" 
style="cursor:pointer;">
MVC를 이용한 미니 프로젝트 
</h3>

<c:if test="${sessionScope.memId eq null}">
<a href="/miniProject/member/writeForm.do">회원가입</a>
</c:if>

<c:if test="${sessionScope.memId ne null}">
<a href="">회원정보수정</a><br>
<a href="/miniProject/member/logout.do">로그아웃</a>
<a href="/miniProject/board/boardWriteForm.do">글쓰기</a>
</c:if>

<c:if test="${sessionScope.memId == 'admin'}">
<a href="/miniProject/imageboard/imageboardWriteForm.do">이미지등록</a>
</c:if>

<a href="/miniProject/board/boardList.do">목록</a>
<a href="">이미지목록</a>
