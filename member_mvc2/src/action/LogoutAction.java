package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	public String path;
	
	public LogoutAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 세션 해제만 해주면 된다!
		HttpSession session = req.getSession(false);
		session.removeAttribute("vo");
		
		// 이동은 loginForm으로 이동해주면 된다!
		return new ActionForward(path, true); // 가져갈 내용 없으므로 true
	}

}
