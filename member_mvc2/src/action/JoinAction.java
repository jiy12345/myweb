package action;

import java.sql.Connection;
import static persistence.JDBCUtil.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberVO;
import persistence.MemberDAO;

public class JoinAction implements Action {

	private String path;

	public JoinAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// joinForm.jsp에서 넘어오는 값 가져오기

		String userid = req.getParameter("userid");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");

		String confirm_password = req.getParameter("confirm_password");

		MemberVO vo = new MemberVO();
		vo.setPassword(password);
		
		// VO에 값을 세팅하기전 equalToPassword()가 true를 리턴하면 VO에 값을 세팅
		if (vo.equalToPassword(confirm_password)) {
			vo.setUserid(userid);
			vo.setName(name);
			vo.setGender(gender);
			vo.setEmail(email);
		}
		// DB작업
		Connection con = getConnection();
		MemberDAO dao = new MemberDAO(con);

		int result = dao.join(vo);

		// result 결과에 따라 commit, rollback 경로 이동
		if (result > 0) {
			commit(con);
		} else {
			path = "view/joinForm.jsp";
			rollback(con);
		}
		close(con);
		return new ActionForward(path, true);
	}

}
