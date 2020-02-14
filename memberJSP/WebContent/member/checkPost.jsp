<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.bean.ZipcodeDTO"%>
<%@page import="java.util.List"%>
<%@page import="member.dao.MemberDAO"%>

<%
request.setCharacterEncoding("utf-8");

//데이터
String sido = request.getParameter("sido");
String sigungu = request.getParameter("sigungu");
String roadname = request.getParameter("roadname");

//DB
MemberDAO memberDAO = MemberDAO.getInstance();
List<ZipcodeDTO> list = null;
if(sido!=null && roadname!=null) { 
	if(sido!="" && roadname!="") {
	list = memberDAO.getZipcode(sido, sigungu, roadname);
	}
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/member.css">

</head>
<body>
<form method="post" action="checkPost.jsp">

<table border="1" width="100%" cellspacing="1" cellpadding="3">
<tr>
<td width="170" align="center">시도</td>
<td>
<select name="sido" style="width:100px; height:23px;">
<option value="">시도선택</option>
<option value="서울">서울</option>
<option value="인천">인천</option>
<option value="대전">대전</option>
<option value="대구">대구</option>
<option value="울산">울산</option>
<option value="광주">광주</option>
<option value="경기">경기</option>
<option value="강원">강원</option>
<option value="충북">충북</option>
<option value="충남">충남</option>
<option value="세종">세종</option>
<option value="경북">경북</option>
<option value="경남">경남</option>
<option value="전북">전북</option>
<option value="전남">전남</option>
<option value="부산">부산</option>
<option value="제주">제주</option>
</td>
<td width="130" align="center">시군구</td>
<td>
<input type="text" name="sigungu" size="15">
</td>
</tr>

<tr>
<td align="center">도로명</td>
<td colspan="3">
<input type="text" name="roadname" size="30">
<input type="submit" value="검색">
</td>
</tr>

<tr>
<td align="center" >우편번호</td>
<td align="center" colspan="3">주소</td>
</tr>
<%if(list!=null) {%>
<%for(ZipcodeDTO zipcodeDTO : list) { %>
<tr>
<td width="130" align="center">
<%=zipcodeDTO.getZipcode()%>
<%String addr = zipcodeDTO.getSiDo()+" "
				+ zipcodeDTO.getSiGunGu()+" "
				+ zipcodeDTO.getYumMyunDong()+" "
				+ zipcodeDTO.getRi()+" "
				+ zipcodeDTO.getRoadName()+" "
				+ zipcodeDTO.getBuildingName();%>
</td>
<td colspan="3"><a class="addressA" href="#" onclick="checkPostClose('<%=zipcodeDTO.getZipcode()%>', '<%=addr%>')"><%=addr %></td>
<!--  <input type="button" value="" onclick="postClose()">-->

</tr>
<%} %>
<%} %>
</table>

</form>
</body>
<script>
function checkPostClose(zipcode, addr) {
	
/* 	opener.document.forms[0].zipcode.value = zipcode;
	opener.document.forms[0].addr1.value= addr;
	window.close();
	opener.document.forms[0].addr2.focus(); */
/* 	if(opener.writeForm){
		opener.writeForm.zipcode.value = zipcode;
		opener.writeForm.addr1.value= addr;
		opener.writeForm.addr2.focus();
	} else if(opener.modifyForm){
		opener.modifyForm.zipcode.value = zipcode;
		opener.modifyForm.addr1.value=addr;
		opener.modifyForm.addr2.focus();
	} */
	
	opener.document.getElementById('zipcode').value = zipcode;
	opener.document.getElementById('addr1').value = addr;
	window.close();
	opener.document.getElementById('addr2').focus();
}
</script>
</html>