package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import persistence.BoardDAO;

import static persistence.JDBCUtil.*;

import java.sql.Connection;

public class BoardViewAction implements Action {

	private String path;

	public BoardViewAction(String path) {
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
			commit(con);
		} else {
			rollback(con);
		}

		// 보여줄 내용 가져오기
		BoardVO vo = dao.view(bno);

		// VO 담고 이동하기
		if (vo != null) {
			req.setAttribute("vo", vo);
		}
		close(con);
		return new ActionForward(path, false);
	}

}
