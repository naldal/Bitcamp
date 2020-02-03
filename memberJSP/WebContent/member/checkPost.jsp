<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.dao.MemberDAO,member.bean.ZipcodeDTO,java.util.List,java.util.ArrayList"%>
<%
	//request
	request.setCharacterEncoding("UTF-8");
	ZipcodeDTO addressDto = new ZipcodeDTO();

	String sido = request.getParameter("sido");
	String sigungu = request.getParameter("sigungu");
	String roadname = request.getParameter("doro");
	
	System.out.println(sido+" "+sigungu+" "+roadname);
	
	addressDto.setSido(sido);
	addressDto.setSigungu(sigungu);
	addressDto.setRoadname(roadname);
	
	//db
	MemberDAO memberDAO = MemberDAO.getinstance();
	List<ZipcodeDTO> list = null;
	if(sido!=null && roadname!=null) {
		list = memberDAO.getZipcodeList(sido, sigungu, roadname); 
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
td {
	font-size: 9pt;
}
</style>
</head>
<body>
<form action="checkPost.jsp" method="post">
	<table border="1" width="100%" cellspacing="0" cellpadding="3">
		<tr>
			<td>시도</td>
			<td>
				<select name="sido">
					<option value="서울">서울</option>
					<option value="인천">인천</option>
					<option value="대전">대전</option>
					<option value="대구">대구</option>
					<option value="울산">울산</option>
					<option value="세종">세종</option>
					<option value="광주">광주</option>
					<option value="경기">경기</option>
					<option value="강원">강원</option>
					<option value="전남">전남</option>
					<option value="전북">전북</option>
					<option value="경남">경남</option>
					<option value="경북">경북</option>
					<option value="충남">충남</option>
					<option value="충북">충북</option>
					<option value="부산">부산</option>
					<option value="제주">제주</option>
				</select>
			</td>
			<td>시.군.구</td>
			<td>
				<input type="text" name="sigungu">
			</td>
		</tr>
		<tr>
			<td>
				도로명
			</td>
			<td colspan="3">
				<input type="text" name="doro">
				<input type="submit" value="검색">
			</td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td colspan="3" align="center">주소</td>
		</tr>
		<%if(list!=null) { %>
			<%for(ZipcodeDTO zipcodeDTO : list) { %>
			<tr>
				<td><%=zipcodeDTO.getZipcode() %></td>
				<td>
				<%=zipcodeDTO.getSido()+" "+zipcodeDTO.getSigungu()+" "+zipcodeDTO.getYubmyundong()+" "+zipcodeDTO.getRi()+" "+zipcodeDTO.getRoadname()+" "+zipcodeDTO.getBuildingname() %>
				</td>
			</tr>
		<%} %>
	<%} %>
	</table>
	</form>
</body>
</html>