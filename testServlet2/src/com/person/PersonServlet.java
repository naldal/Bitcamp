package com.person;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String color = request.getParameter("color");
		String[] subject = request.getParameterValues("subject");
		String[] stacks = request.getParameterValues("stacks");
		
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("color", color);
		
		List list = Arrays.asList(subject);
		request.setAttribute("subject", list);
		
		List list2 = Arrays.asList(stacks);
		request.setAttribute("stacks", list2);
		
		RequestDispatcher disp = request.getRequestDispatcher("personresult.jsp");
		disp.forward(request, response);

		
		response.setContentType("text/html);charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		
		
		
		
		
	}

}