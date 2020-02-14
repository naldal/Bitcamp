package member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.bean.ZipcodeDTO;
import member.dao.MemberDAO;

public class CheckPostAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//request.setCharacterEncoding("utf-8"); mvc 방식에서는 이미 controlServlet에서 한글처리 하므로 걸지 않아도 됨.

		//데이터
		String sido = request.getParameter("sido");
		String sigungu = request.getParameter("sigungu");
		String roadname = request.getParameter("roadname");
		
		System.out.println(sido + ", " + sigungu + ", "+ roadname);

		//DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		List<ZipcodeDTO> list = null;
		if(sido!=null && roadname!=null) { 
			if(sido!="" && roadname!="") {
			list = memberDAO.getZipcode(sido, sigungu, roadname);
			}
		}
		
		//응답
		request.setAttribute("list", list);
		
		return "/member/checkPost.jsp";
	}

}
