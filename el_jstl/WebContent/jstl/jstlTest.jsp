<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>** 변수 설정 **</h3>
<c:set var="name" value="홍길동" />
<c:set var="age">25</c:set>
내 이름은 ${name } 입니다.<br>
내 나이는 <c:out value="${age }" />살 입니다.<br>
나의 키는 ${height } 입니다.<br>

<h3>** 변수 삭제 **</h3>
<c:remove var="name"/>
내 이름은 ${name } 입니다.<br>
내 나이는<c:out value="${age }" />살 입니다.<br>

<h3>** forEach **</h3>
<c:forEach var="i" begin="1" end="10" step="1">
	<c:set var="sum" value="${sum + i }"></c:set>
</c:forEach>
<br>
1 ~ 10의 합 = ${sum }
<br><br>
<!-- 위의 내용은 자바에서
for(int i=1; i<=10; i++) {
System.out.print(i);
} 와 동일하다  -->

<c:forEach var="j" begin="1" end="10" step="1">
	${11-j }
</c:forEach>


<h3>** 문자열 분리 **</h3>
<c:forTokens  var="car" items="소나타, 아우디, 링컨, 페라리, 벤츠" delims=",">
	${car }<br>
</c:forTokens>

<h3>** jstlExam.jsp에서 넘어온 데이터 출력 **</h3>
결과 = ${requestScope.list }
 
<h3>** 인덱스 2번째 데이터 출력 **</h3>
결과 = ${list[2] }
<br><br>

<!-- for(String data : list) {
} 의 표현은 아래와 같다.-->

<c:forEach var="data" items="${requestScope.list }" >
	${data }<br>
</c:forEach>
<br><br>

<c:forEach var="personDTO" items="${list2 }" varStatus="i">
<%-- 	이름 = ${personDTO.getName()} &emsp; 나이 = ${personDTO.getAge()} --%>
	i.index = ${i.index } &emsp; i.count = ${i.count } &emsp;
	이름 = ${personDTO.name} &emsp; 나이 = ${personDTO.age}
	<br>
</c:forEach>
</body>
</html>