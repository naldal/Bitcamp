package com.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public void init(){
		System.out.println("init()");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		
		response.setContentType("text/html;charset=UTF-8");
		
		//1. System.out.println("<html>");
		//2.
		//3. 
		//위의 io들과 같이 웹으로도 보내느 길이 필요하고 그 길을 만드는 것은 아래와 같다
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("Hello Servlet!!<br>");
		out.println("안녕하세요 서블릿씨!!<br>");
		out.println("</body>");
		out.println("</html>");
		
	}

	public void destroy() {
		System.out.println("destroy()");
	}

}
