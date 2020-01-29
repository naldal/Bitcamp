package guestbook.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.GuestbookDTO;

@WebServlet("/GuestWriteServlet")
public class GuestWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//req
		request.setCharacterEncoding("UTF-8");		
		List<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
		
		list = GuestbookListServlet.list;
		if(list==null) {
			System.out.println("null!!");
		}
		
		System.out.println(list.size());
		
		//res
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		for(int i=0; i<list.size(); i++) {
			out.println("<head>");
		    out.println("<style>");
		        out.println("table {");
		            out.println("width: 500;");
		        out.println("}");
		
		        out.println(".td1 {");
		           out.println("width: 100;");
		        out.println("}");
		        out.println(".td3 {");
		            out.println("width:100;");
				out.println("}");
		        out.println("td4 {");
		            out.println("width: 300;");
		        out.println("}");
		    out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		    out.println("<form name=\"boardForm\" action=\"\">");
		    out.println("<table border=\"1\" width=\"100\">");
		        out.println("<tr>");
			       	out.println("<td class=\"td1\">작성자</td>");
			        out.println("<td class=\"td2\">"+list.get(i).getName()+"</td>");
			        out.println("<td class=\"td1\">작성일</td>");
			        out.println("<td class=\"td2\">"+list.get(i).getLogtime()+"</td>");
		        out.println("</tr>");
		        out.println("<tr>");
			        out.println("<td class=\"td3\">이메일</td>");
			        out.println("<td class=\"td4\" colspan=\"3\" size=\"20\">"+list.get(i).getEamil()+"</td>");
		        out.println("</tr>");
		        out.println("<tr>");
			        out.println("<td class=\"td3\">홈페이지</td>");
			        out.println("<td class=\"td4\" colspan=\"3\" size=\"20\">"+list.get(i).getHomepage()+"</td>");
		        out.println("</tr>");
		        out.println("(<tr>");
			        out.println("<td class=\"td3\">제목</td>");
			        out.println("<td class=\"td4\" colspan=\"3\" size=\"20\">"+list.get(i).getSubject()+"</td>");
		        out.println("</tr>");
		        out.println("<tr>");
		        out.println("<td class=\"td5\" colspan=\"4\" size=\"20\">");
		        	out.println("<textarea name=\"content\" cols=\"70\" rows=\"10\">"+list.get(i).getContent()+"</textarea>");
		        out.println("</td>");
		        out.println("</tr>");
		    out.println("</form>");
		out.println("</body>");
	out.println("</html>");
			
	out.println("<a href=\"http://localhost:8081/guestbookServlet/guestbook/guestbookWriteForm.html\">뒤로가기</a>");
			
			
		}
		
	}

}
