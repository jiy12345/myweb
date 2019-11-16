package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserVO;
import persistence.UserDAO;

import static persistence.JDBCUtil.*;

import java.sql.Connection;

public class ModifyAction implements Action {

	private String path;

	public ModifyAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 수장하기 위한 값(no, addr, mobile) 가져오기
		int no = Integer.parseInt(req.getParameter("no"));
		String addr = req.getParameter("addr");
		String mobile = req.getParameter("mobile");

		UserVO vo = new UserVO();
		vo.setNo(no);
		vo.setAddr(addr);
		vo.setMobile(mobile);

		// DB 작업
		Connection con = getConnection();
		UserDAO dao = new UserDAO(con);
		int result = dao.user_update(vo);

		// 페이지 이동
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
			path = "get.do?no =" + no;
		}
		close(con);
		return new ActionForward(path, true);
	}

}
