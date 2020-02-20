package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardModifyFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		System.out.println("seq : "+seq);
		int pg = Integer.parseInt(request.getParameter("pg"));
		System.out.println("pg : "+ pg);
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");		
		
		//응답
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
		request.setAttribute("subject", subject);
		request.setAttribute("content", content);
		request.setAttribute("display", "/board/boardModifyForm.jsp");
		return "/main/index.jsp";
	}

}








