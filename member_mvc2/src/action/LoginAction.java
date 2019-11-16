package action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberVO;
import persistence.MemberDAO;

import static persistence.JDBCUtil.*;

public class LoginAction implements Action {

	private String path;
	
	public LoginAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// loginForm.jsp에서 정보 가져오기
		String userid = req.getParameter("userid");
		String password = req.getParameter("current_password");
		
		// DB작업
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);
		
		MemberVO vo = dao.isLogin(userid, password);
		// VO가 있다면 세션에 담고
		if(vo!=null) {
			HttpSession session = req.getSession(false);
			session.setAttribute("vo", vo);	
		}
		close(con);
		// sendRedirect -> 잘되든 안되든 path는 동일하다!
		return new ActionForward(path, true);
	}

}
