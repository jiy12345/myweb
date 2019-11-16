package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserVO;
import persistence.UserDAO;

import static persistence.JDBCUtil.*;

import java.sql.Connection;

public class InsertAction implements Action {

	private String path;

	public InsertAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// pro에서 했던 작업을 여기서 함!

		// user_insert.jsp에서 사용자가 넘긴 값 가져오기
		String username = req.getParameter("username");
		int birthyear = Integer.parseInt(req.getParameter("birthyear"));
		String addr = req.getParameter("addr");
		String mobile = req.getParameter("mobile");

		// DB작업 후 페이지 이동
		Connection con = getConnection();
		UserDAO dao = new UserDAO(con);

		UserVO vo = new UserVO(username, birthyear, addr, mobile);
		int result = dao.user_insert(vo);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		// path에는 select.do가 들어와 있다
		// redirect : true(sendRedirect), false(forward)
		return new ActionForward(path, true);
	}

}
