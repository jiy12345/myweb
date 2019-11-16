package action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberVO;
import persistence.MemberDAO;

import static persistence.JDBCUtil.*;

public class LeaveAction implements Action {

	private String path;

	public LeaveAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// leaveForm.jsp에서 넘긴 값 가져오기
		String userid = req.getParameter("userid");
		String password = req.getParameter("current_password");

		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);

		MemberVO vo = dao.isLogin(userid, password);

		if (vo == null) {
			// userid, current_password가 일치하지 않는다면
			// return 시키기(leaveForm.jsp)
			path = "view/leaveForm.jsp";
		} else {
			// userid, current_password가 일치한다면
			// 탈퇴 작업하기
			int result = dao.leave(userid);
			if(result>0) {
				// 세션 해제해주기
				commit(con);
				HttpSession session = req.getSession(false);
				session.removeAttribute("vo");
			} else {
				rollback(con);
				path = "view/leaveForm.jsp";
			}
		}	
		close(con);
		return new ActionForward(path, true);
	}
}
