<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO" %>
    
<jsp:useBean id="memberDAO" class="member.dao.MemberDAO" />


${String id = (String)sessionScope.memId }


${MemberDTO memberDTO = memberDAO.getMember(id) }



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="modifyForm" method="post" action="modify.jsp">
		<table border="1" cellspacing="0" cellpadding="3">

			<tr>
				<td width="70" align="center">이름</td>
				<td>
				<input type="text" name="name" id="name" value="${memberDTO.name }">
				</td>
			</tr>

			<tr>
				<td align="center">아이디</td>
				<td>
					<input type="text" name="id" id="id" value="${memberDTO.id }" readonly>
					<input type="button" value="중복체크" onclick="checkId()">
					<input type="hidden" name="idCheck" value="">
				</td>
			</tr>

			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd" id="pwd"></td>
			</tr>

			<tr>
				<td align="center">재확인</td>
				<td><input type="password" name="repwd" id="repwd"></td>
			</tr>

			<tr>
				<td align="center">성별</td>
				<td>
				<input type="radio" name="gender" value="0">남자
				<input type="radio" name="gender" value="1">여자
				</td>
			</tr>

			<tr>
				<td align="center">이메일</td>
				<td><input type="text" name="email1" size="15" value="${memberDTO.email1 }">
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
				<select name="tel1" id="tel1" style="width:70px;">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="017">017</option>
				<option value="018">018</option>
				</select>
				-
				<input type="text" name="tel2" size="5" value="${memberDTO.tel2 }">
				-
				<input type="text" name="tel3" size="5" value="${memberDTO.tel3 }">
				</td>
			</tr>

			<tr>
				<td align="center">주소</td>
				<td>
				<input type="text" name="zipcode" id="zipcode" size="6"  value="${memberDTO.zipcode }" readonly>
				<input type="button" value="우편번호 검색" onclick="checkPost()"><br>
				<input type="text" name="addr1" id="addr1" value="${memberDTO.addr1 }" size="50" readonly><br>
				<input type="text" name="addr2" id="addr2" value="${memberDTO.addr2 }" size="50">
 				</td>
			</tr>

			<tr>
				<td colspan="2" align="center">
				<input type="button" value="회원정보수정" onclick="checkModifyForm()">&emsp;
				<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript" src="../js/member.js"></script>
<script type="text/javascript">
window.onload=function() {
	document.modifyForm.gender[${memberDTO.gender}].checked = true;
	document.modifyForm.email2.value = ${memberDTO.email2}
	<%-- document.modifyForm.tel1.value='<%=memberDTO.getTel1()%>' --%>
	document.getElementById('tel1').value=${memberDTO.tel1}
}
</script>
</html>