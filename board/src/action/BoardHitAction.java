package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import persistence.BoardDAO;

import static persistence.JDBCUtil.*;

import java.sql.Connection;

public class BoardHitAction implements Action {

	private String path;

	public BoardHitAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// bno 가져오기
		int bno = Integer.parseInt(req.getParameter("bno"));

		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);

		// 조회수 업데이트
		int result = dao.update_readcount(bno);
		if (result > 0) {
			path += "?bno=" + bno; // 기존 path -> view.do/?bno=1;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return new ActionForward(path, true);
	}

}
