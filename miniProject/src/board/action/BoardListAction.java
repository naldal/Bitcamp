package board.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;
import member.bean.MemberDTO;

public class BoardListAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		// data
		HttpSession session = request.getSession();
		int pg = Integer.parseInt(request.getParameter("pg"));

		// 페이징 1페이장 5개씩
		int endNum = pg * 5;
		int startNum = endNum - 4;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("endNum", endNum);
		map.put("startNum", startNum);

		// DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		List<BoardDTO> list = boardDAO.getBoardList(map);

		// paging
		BoardPaging boardPaging = new BoardPaging();
		int totalA = boardDAO.getTotalArticle(); // 총글수
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();

		if (session.getAttribute("memId") != null) {
			Cookie cookie = new Cookie("memHit", "0");
			cookie.setMaxAge(30 * 60);
			response.addCookie(cookie);
		}

		// 응답
		request.setAttribute("pg", pg);
		request.setAttribute("list", list);
		request.setAttribute("boardPaging", boardPaging);
		request.setAttribute("display", "/board/boardList.jsp");

		return "/main/index.jsp";
	}

}
