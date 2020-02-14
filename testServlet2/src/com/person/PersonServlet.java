package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//데이터, 요청
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String color = request.getParameter("color");
		String[] hobby =  request.getParameterValues("hobby");
		String[] subject = request.getParameterValues("subject");
		
		
		//응답
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("#aaa {color: " + color + "; font-weight: bold; }");
		out.println(".backA:link {color : red; text-decoration : none; }"); //a태그가 처음 걸렸을 때
		out.println(".backA:visited {color : blue; text-decoration : none;}"); //a태그를 클릭했을 때
		out.println(".backA:hover {color : green; text-decoration : underline;}"); //a태그에 마우스를 올렸을 때
		out.println(".backA:active {color : magenta; text-decoration : none;}"); //a태그를 누르고 있는 동안
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<ul id='aaa'>");
		out.println("<li>이 름 : " + name +"<br><br>");
		if(gender.equals("0"))
			out.println("<li>성 별 : 남자 <br><br>");
		else
			out.println("<li>성 별 : 여자 <br><br>");
//		out.println("<li>성별 : " + gender +"<br>");
		out.println("<li>색 깔 : " + color + "<br><br>");
		out.print("<li>취 미 : ");
		for(int i=0; i<hobby.length; i++) {
			out.println(hobby[i]);
			if(i!=hobby.length-1) out.print(", ");
		}
		out.print("<br><br>");
		out.println("<li>과 목 : ");
		for(int i=0; i<subject.length; i++) {
			out.println(subject[i]);
			if(i!=subject.length-1) out.print(", ");
		}
		out.println("</ul>");
		out.println("<a class='backA' href = 'javascript:history.go(-1)'>뒤로</a>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
