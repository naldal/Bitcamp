<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.dao.BoardDAO"%>
<%@ page import="board.bean.BoardDTO" %>
<!DOCTYPE html>
<!-- DB에 insert 할 때 seq는 시퀀스 객체를 이용한다
	id name email(email1 email2의 2개를 합침) 세션을 통해서 얻어온다
	ref는 seq와 똑같은 값이 들어간다	
  -->
  
<%

	//req
	request.setCharacterEncoding("UTF-8");
	String id = (String)session.getAttribute("memId"); 
	String name = (String)session.getAttribute("memName");
	String email = (String)session.getAttribute("memEmail");
	
	String subject = request.getParameter("subject");
	String content= request.getParameter("content");
	
	BoardDTO boardDTO = new BoardDTO();
	boardDTO.setName(name);
	boardDTO.setId(id);
	boardDTO.setEmail(email);
	boardDTO.setSubject(subject);
	boardDTO.setContent(content);
	
	System.out.println("name"+name);
	System.out.println("id"+id);
	System.out.println("subject"+subject);
	
	//db
	BoardDAO boardDAO = BoardDAO.getinstance();
	boolean flag = boardDAO.saveBoard(boardDTO);
	
	//res
	if(flag) {
		out.println("board insert 성공");
	} else {
		out.println("실패.....");
	}
%>