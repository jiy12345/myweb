package action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberVO;
import oracle.net.ns.SessionAtts;
import persistence.MemberDAO;

import static persistence.JDBCUtil.*;

public class ModifyAction implements Action {

	private String path;

	public ModifyAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 세션이 가지고 있는 아이디 가져오기
		HttpSession session = req.getSession(false);
		MemberVO sesVO = (MemberVO) session.getAttribute("vo");
		String userid = sesVO.getUserid();

		// modifyForm.jsp에서 넘긴 값 가져오기
		String current_password = req.getParameter("current_password");
		String new_password = req.getParameter("new_password");
		String confirm_password = req.getParameter("confirm_password");

		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);

		// 현재 비밀번호가 맞는지 체크하기
		MemberVO vo = dao.isLogin(userid, current_password);

		if (vo != null) {
			if (new_password.equals(confirm_password)) {
				int result = dao.modify(userid, new_password);
				if (result > 0) {
					commit(con);
					session.removeAttribute("vo");
				} else { // 비밀번호 수정이 이루어지지 않았을 경우
					rollback(con);
				}
			} else { // 새 비밀번호와 새 비밀번호 확인이 틀린 경우
				path = "view/modifyForm.jsp";
			}
		} else { // 현재 비밀번호가 틀렸을 경우
			path = "view/modifyForm.jsp";
		}
//		if (vo != null && new_password.equals(confirm_password)) {
//			// userid, current_password가 일치한다면
//			// 수정 작업하기
//			int result = dao.modify(userid, new_password);
//			if (result > 0) {
//				// 세션 해제해주기
//				// loginForm.jsp로 보내주기
//				commit(con);
//				session.removeAttribute("vo");
//			} else {
//				rollback(con);
//				path = "view/modifyForm.jsp";
//			}
//		} else {
//			// userid, current_password가 일치하지 않는다면
//			// return 시키기(modifyForm.jsp)
//			path = "view/modifyForm.jsp";
//		}
		close(con);
		return new ActionForward(path, true);
	}

}
