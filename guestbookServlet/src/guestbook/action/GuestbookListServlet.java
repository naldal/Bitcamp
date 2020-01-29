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

import guestbook.bean.GuestbookDAO;
import guestbook.dao.GuestbookDTO;

@WebServlet("/GuestbookServlet")
public class GuestbookListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	static List<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestbookDTO guestdto = null;
		GuestbookDAO guestbookDAO = GuestbookDAO.getinstance();
		
		//req
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		guestdto = new GuestbookDTO(name, email, homepage, subject, content);
		
		
		//db
		boolean flag = false;
		GuestbookDTO dto = guestbookDAO.insert(guestdto);
		
		if(dto!=null) {
			flag=true;
			list.add(dto); //list에 추가.
			System.out.println(list.size());
			System.out.println("list insert success");
		}
		else {
			System.out.println("list insert fail");
			flag=false;
		}
		
		
		//res
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		if(flag) {
			out.println("작성하신 글을 저장했습니다.");
		} else {
			out.println("저장에 실패했습니다.");
		}
		out.println("<a href=\"http://localhost:8081/guestbookServlet/guestbook/guestbookWriteForm.html\">뒤로가기</a>");
		out.println("</html>");
		out.println("</head>");
		out.println("</html>");
	}
}
