package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import persistence.BoardDAO;

import static persistence.JDBCUtil.*;

import java.sql.Connection;

public class BoardUpdateAction implements Action {

	private String path;

	public BoardUpdateAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String password = req.getParameter("password");
		int bno = Integer.parseInt(req.getParameter("bno"));

		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);

		BoardVO vo = new BoardVO();
		vo.setBno(bno);
		vo.setTitle(title);
		vo.setPassword(password);
		vo.setBno(bno);

		// 비밀번호가 일치하면 제목과 내용 수정
		int result = dao.update(vo);

		if (result > 0) { // view.do?bno=3 -> 수정된 내용을 확인
			commit(con);
			path += "?bno=" + bno;
		} else {
			rollback(con);
			path = "modify.do?bno" + bno;
		}
		close(con);
		return new ActionForward(path, false);
	}

}
