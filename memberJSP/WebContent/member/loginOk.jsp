<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO" %>
<%@ page import="member.bean.MemberDTO" %>


<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//req
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");

	//db
	MemberDAO memberDAO = MemberDAO.getinstance();
	MemberDTO memberDTO = memberDAO.findInfo(id);
	
	String name = memberDTO.getName();
	String password = memberDTO.getPassword();
	String gender = memberDTO.getGender();
	String email1= memberDTO.getEmail1();
	String email2 = memberDTO.getEmail2();
	String tel1 = memberDTO.getTel1();
	String tel2 = memberDTO.getTel2();
	String tel3 = memberDTO.getTel3();
	String zipcode = memberDTO.getZipcode();
	String addr1 = memberDTO.getAddr1();
	String addr2 = memberDTO.getAddr2();
	
	System.out.println(id);
	System.out.println(name);
	System.out.println(gender);
	System.out.println(email1);
%>

<input type="hidden" name="name" value=<%=name%>>
<input type="hidden" name="id" value=<%=id%>>
<input type="hidden" name="password" value=<%=password%>>
<input type="hidden" name="gender" value=<%=gender%>>
<input type="hidden" name="email1" value=<%=email1%>>
<input type="hidden" name="eamil2" value=<%=email2%>>
<input type="hidden" name="tel1" value=<%=tel1%>>
<input type="hidden" name="tel2" value=<%=tel2%>>
<input type="hidden" name="tel3" value=<%=tel3%>>
<input type="hidden" name="zipcode" value=<%=zipcode%>>
<input type="hidden" name="addr1" value=<%=addr1%>>
<input type="hidden" name="addr2" value=<%=addr2%>>

<% response.sendRedirect("modifyForm.jsp?name="+URLEncoder.encode(name,"UTF-8")
						+"&id="+URLEncoder.encode(id,"UTF-8")
						+"&password="+URLEncoder.encode(password,"UTF-8")
						+"&gender="+URLEncoder.encode(gender,"UTF-8")
						+"&email1="+URLEncoder.encode(email1,"UTF-8")
						+"&email2="+URLEncoder.encode(email2,"UTF-8")
						+"&tel1="+URLEncoder.encode(tel1,"UTF-8")
						+"&tel2="+URLEncoder.encode(tel2,"UTF-8")
						+"&tel3="+URLEncoder.encode(tel3,"UTF-8")
						+"&zipcode="+URLEncoder.encode(zipcode,"UTF-8")
						+"&addr1="+URLEncoder.encode(addr1,"UTF-8")
						+"&addr2="+URLEncoder.encode(addr2,"UTF-8")
		);
%>

</body>
</html>