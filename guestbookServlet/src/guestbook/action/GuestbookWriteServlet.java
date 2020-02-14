package guestbook.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;


@WebServlet("/GuestbookWriteServlet")
public class GuestbookWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
//		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		GuestbookDTO guestbookDTO = new GuestbookDTO();
		
		//데이터
//		int seq = guestbookDAO.getSeq();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String logtime = request.getParameter("logtime");
		
//		guestbookDTO.setSeq(seq);
		guestbookDTO.setName(name);
		guestbookDTO.setEmail(email);
		guestbookDTO.setHomepage(homepage);
		guestbookDTO.setSubject(subject);
		guestbookDTO.setContent(content);
		guestbookDTO.setLogtime(logtime);
		
		
		//DB
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		guestbookDAO.write(guestbookDTO);
		
		//응답
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
//		out.println("<form name='successForm' method='post' action='/guestbookServlet/GuestbookListServlet'>");
		out.println("글 등록 완료<br><br>");
		out.println("<input type='button' value='글목록' onclick='guestbookList()'>"); //아래의 것과 같다.
//		out.println("<input type='button' value='글목록' onclick=location.href='/guestbookServlet/GuestListServlet'>");
//		out.println("</form>");
		out.println("</body>");
		out.println("<script type='text/javascript' src='http://localhost:8080/guestbookServlet/js/guestbook.js'></script>");
		out.println("</html>");
	} 										
}
