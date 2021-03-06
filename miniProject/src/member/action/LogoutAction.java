package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

public class LogoutAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		/* System.out.println("로그아웃 세션 : " + session.getAttribute("memId")); */
		session.invalidate();
		
		request.setAttribute("display", "/member/logout.jsp");
		return "/main/index.jsp";
	}

}
