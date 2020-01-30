package guestbookServlet.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.GuestbookDAO;
import guestbook.dto.GuestbookDTO;

// 글을 작성하는 서블릿

@WebServlet("/WriteServlet")
public class GuestbookWriteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GuestbookDTO guestdto = new GuestbookDTO();
		
		//req
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String homepage = req.getParameter("homepage");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		guestdto.setName(name);
		guestdto.setEmail(email);
		guestdto.setHomepage(homepage);
		guestdto.setSubject(subject);
		guestdto.setContent(content);		
		
		//db
		GuestbookDAO guestdao = GuestbookDAO.getinstance();
		boolean row = guestdao.insert();
		
		
		//res
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		if(row) {
			out.println("입력에 성공");
		} else {
			out.println("입력에 실패");
		}
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
	}

}
