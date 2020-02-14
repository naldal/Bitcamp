<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="writeForm" method="post" action="/miniProject/member/write.do">
		<table border="1" cellspacing="0" cellpadding="3">

			<tr>
				<td width="70" align="center">이름</td>
				<td><input type="text" name="name" placeholder="이름 입력" size=>
				</td>
			</tr>

			<tr>
				<td align="center">아이디</td>
				<td>
					<input type="text" name="id" placeholder="아이디 입력">
					<input type="button" value="중복첵크" onclick="checkId()">
					<input type="hidden" name="idCheck" value="">
				</td>
			</tr>

			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd"></td>
			</tr>

			<tr>
				<td align="center">재확인</td>
				<td><input type="password" name="repwd"></td>
			</tr>

			<tr>
				<td align="center">성별</td>
				<td><input type="radio" name="gender" value="0" checked>남자
					<input type="radio" name="gender" value="1">여자</td>
			</tr>

			<tr>
				<td align="center">이메일</td>
				<td><input type="text" name="email1" size="15">
				 	@
				 	<input type="text" name="email2" list="email2" placeholder="직접입력">
					<datalist id="email2">
						<option value="naver.com">
						<option value="gmail.com">
						<option value="daum.net">
					</datalist></td>
			</tr>

			<tr>
				<td align="center">핸드폰</td>
				<td>
				<select name="tel1" style="width:70px;">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="017">017</option>
				<option value="018">018</option>
				</select>
				-
				<input type="text" name="tel2" size="5">
				-
				<input type="text" name="tel3" size="5">
				</td>
			</tr>

			<tr>
				<td align="center">주소</td>
				<td>
				<input type="text" name="zipcode" id="zipcode" size="6" readonly>
				<input type="button" value="우편번호 검색" onclick="checkPost()"><br>
				<input type="text" name="addr1" id="addr1" placeholder="주소" size="50" readonly><br>
				<input type="text" name="addr2" id="addr2" placeholder="상세 주소" size="50">
 				</td>
			</tr>

			<tr>
				<td colspan="2" align="center">
				<input type="button" value="회원가입" onclick="checkWriteForm()">&emsp;
				<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript" src="../js/member.js"></script>
<!-- <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> -->
</html>