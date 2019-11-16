package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserVO;
import persistence.UserDAO;

import static persistence.JDBCUtil.*;

import java.sql.Connection;

public class UserGetAction implements Action {

	private String path;

	public UserGetAction(String path) {
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// no값 가져오기
		int no = Integer.parseInt(req.getParameter("no"));

		// no값을 이용하여 DB 작업하기
		Connection con = getConnection();
		UserDAO dao = new UserDAO(con);
		UserVO vo = dao.selectOne(no);

		// 페이지 이동
		if (vo == null) {
			path = "select.do";
			return new ActionForward(path, true);
		} else {
			// null이 아니라면 지정한 경로(user_get.jsp)로 이동
			req.setAttribute("vo", vo);
			return new ActionForward(path, false);
		}
	}
}
