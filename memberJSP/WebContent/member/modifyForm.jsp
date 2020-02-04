<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO" %>
<jsp:useBean id="memberDTO" class="member.bean.MemberDTO"/>
<jsp:setProperty property="*" name="memberDTO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	<h2>회원가입</h2>
	<form name="UpdateForm" method="post" action="update.jsp">
	<table border="1" style="width: 100">
		<tr>
			<td>이름</td>
			<td>
				<input type="text" name="name" value="<jsp:getProperty property="name" name="memberDTO"/>">
			</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>
				<input type="text" name="id" readonly="readonly" value="<jsp:getProperty property="id" name="memberDTO"/>">
				<input type="button" value="중복체크" onclick="checkId()" disabled="disabled">
				<input type="hidden" name="check" value="">
			</td>
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<td>
				<input type="password" name="password" id="pwd" value="<jsp:getProperty property="password" name="memberDTO"/>">
			</td>
		</tr>
		<tr>
			<td>재확인</td>
			<td>
				<input type="password" name="repwd" value="<jsp:getProperty property="password" name="memberDTO"/>">
			</td>
		</tr>
		
		
		<tr>
			<td>성별</td>
			<td>
				<input type="radio" name="gender" value="male" checked>남
				<input type="radio" name="gender" value="female">여
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email1" value="<jsp:getProperty property="email1" name="memberDTO"/>">
			
			@
			<input type="text" name="email2" list="email2" placeholder="직접입력">
				<datalist id="email2">
					<option value="gmail.com">
					<option value="hanmail.net">
					<option value="naver.com">
				</datalist>
			</td>
		</tr>
		
		
		<tr>
			<td>핸드폰</td>
			<td>
				<select name="tel1">
					<option value="010">010</option>
					<option value="011">010</option>
				</select>
				-
					<input type="text" name="tel2" style="width: 70px;" value="<jsp:getProperty property="tel2" name="memberDTO"/>">
				-
					<input type="text" name="tel3" style="width: 70px;" value="<jsp:getProperty property="tel3" name="memberDTO"/>">
			</td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="zipcode" id="zipcode" readonly size='6' value="<jsp:getProperty property="zipcode" name="memberDTO"/>" >
				<input type="button" value="우편번호검색" onclick="checkPost()"><br>
				<input type="text" name="addr1" id="addr1" placeholder="주소" readonly style="width: 300px;" value="<jsp:getProperty property="addr1" name="memberDTO"/>"><br>
				<input type="text" name="addr2" id="addr2" placeholder="상세주소" style="width: 300px;"  value="<jsp:getProperty property="addr2" name="memberDTO"/>"><br>
			</td>
		</tr>
		
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="회원정보 수정" onclick="oll()">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
	</form> 
</body>
<script type="text/javascript" src="../js/member.js"></script>

</html>