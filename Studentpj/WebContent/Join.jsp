<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" errorPage="ErrorPage.jsp"%>
<%@page import ="java.sql.*"%>


<%
	int seq = 1;
	String name = request.getParameter("name");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2Req");
	String tel3 = request.getParameter("tel3Req");
	
	request.setAttribute("name", name);
	
	String[] hobbyReq = request.getParameterValues("chk_hobby");
	int genderReq = Integer.parseInt(request.getParameter("chk_gender"));

	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url= "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "c##java";
	String password = "bit";
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection conn= DriverManager.getConnection(url, username, password);

	try{
		Class.forName(driver);
		String insertSql = "insert into studnet values(?,?,?,?,?,?)"; 
		pstmt = conn.prepareStatement(insertSql);
		pstmt.setInt(1, seq);
		pstmt.setString(2, name);
		pstmt.setString(3, tel1);
		pstmt.setString(4, tel2);
		pstmt.setString(5, tel3);
		pstmt.setInt(6, genderReq);
		pstmt.setString(7, hobbyReq.toString());
		
		pstmt.executeUpdate();
	} catch(Exception e){
		e.printStackTrace();
	} finally {
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	response.sendRedirect("JoinResult.jsp");

%>