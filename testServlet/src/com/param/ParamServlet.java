package com.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		//응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println(name + "님의 나이는 " + age + "살 이므로");
		if(age>=19)
			out.println("<b>성인</b> 입니다.");
		else
			out.println("<b>청소년</b> 입니다.");
		out.println("</body>");
		out.println("</html>");
	
	}

}
