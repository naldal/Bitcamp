package board.action;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;
import member.bean.MemberDTO;

public class BoardListAction implements CommandProcess{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//data
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		request.setAttribute("memberDTO", memberDTO);  // 
		request.setAttribute("id", id);  //
		
		int pg = 0;
		if(request.getParameter("pg")!=null)
			pg = Integer.parseInt(request.getParameter("pg"));
		else 
			pg=1;
		
		request.setAttribute("pg", pg); //
		
		int endNum = pg*5;
		int startNum = endNum-4;
		
		//db
		BoardDAO boardDAO = BoardDAO.getInstance();
		List<BoardDTO> list = boardDAO.getBoardList(startNum, endNum);
		request.setAttribute("list", list); //
		
		//paging
		BoardPaging boardPaging = new BoardPaging();
		int totalA = boardDAO.getTotalArticle(); //총글수
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		
		request.setAttribute("boardPaging", boardPaging); //
		
		if(session.getAttribute("memId")!=null) {
			Cookie cookie = new Cookie("memHit", "0");
			cookie.setMaxAge(30*60);
			response.addCookie(cookie);
		}
		
		request.setAttribute("display", "/board/boardList.jsp?pg=1");
		return "/main/index.jsp";
	}

}
