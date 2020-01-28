package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 데이터
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String color = request.getParameter("color");
		String[] checkbox = request.getParameterValues("hobby");
		String[] subject = request.getParameterValues("subject");
		
		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("#aaa {color:"+color+";}");
		out.println(".backA:link {color : red; text-decoration : none;}"); //a tag가 처음 걸렸을 때
		out.println(".backA:visited {color : blue; text-decoration : none;}"); // a tag를 클릭했을 떄
		out.println(".backA:hover {color : green; text-decoration : underline;}"); // a tag에 마우스를 올려놨을 때
		out.println(".backA:active {color : magenta; text-decoration : none;}"); // a tag를 누르고 있는 동안
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<ul id='aaa'>");
		out.println("<li>이 름 : "+name+"</li>");
		if(gender.equals("0"))
			out.println("<li>성 별 : "+"남자"+"</li>");
		else
			out.println("<li>성 별 : "+"여자"+"</li><br>");
		out.println("<li>색 깔 : "+color+"</li>");
		out.print("<li>취 미 : ");
		for(int i=0; i<checkbox.length; i++) {
			out.print(checkbox[i]+" ");
		}
		out.print("<li>과 목 : ");
		for(String e : subject) {
			out.print(e+" ");
		}
		out.println("</ul>");
		out.println("<a class='backA' href='javascript:history.go(-1)'>뒤로</a>");
		
		
		out.println("</body>");
		out.println("</html>");
	}

}
