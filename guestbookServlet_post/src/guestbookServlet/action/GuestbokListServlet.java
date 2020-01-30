package guestbookServlet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.GuestbookDAO;
import guestbook.dto.GuestbookDTO;

@WebServlet("/ListServlet")
//List를 보여주는 서블릿 
public class GuestbokListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// req
		req.setCharacterEncoding("UTF-8");
		int pg = Integer.parseInt(req.getParameter("pg"));

		// db
		GuestbookDAO guestdao = GuestbookDAO.getinstance();

		// paging
		int endNum = pg*3; //
		int startNum = endNum-2; //
		int totalA = guestdao.getTotalArticle();
		int totalP = (totalA+2)/3;
		
		List<GuestbookDTO> list = guestdao.listing(startNum, endNum);
		
		// res
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("#currentPaging {color: red; text-decoration: underline; }");
		out.println("#paging {color: black; text-decoration: none; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		
		if(list!=null) {
			for(int i=0; i<totalP; i++) {
				if(i==pg)
					out.println("[a id='currentPaging' href='/guestbookServlet_post/ListServlet?pg="+i+"'>"+i+"</a>]");
				else
					out.println("[a id='currentPaging' href='/guestbookServlet_post/ListServlet?pg="+i+"'>"+i+"</a>]");
			}
		}
		
		for (GuestbookDTO dto : list) {
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("<td width='100'>작성자</td>");
			out.println("<td width='150'>" + dto.getName() + "</td>");
			out.println("<td width='100'>작성일</td>");
			out.println("<td width='150'>" + dto.getLogtime() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>이메일</td>");
			out.println("<td colspan='3'>" + dto.getEmail() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>홈페이지</td>");
			out.println("<td colspan='3'>" + dto.getHomepage() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>제목</td>");
			out.println("<td colspan='3'>" + dto.getSubject() + "</td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td colspan='4'><pre>" + dto.getContent() + "</pre></td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("<hr color='red' width='500' align='left'>");
		} // for
		
		
	}

}
