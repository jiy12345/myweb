package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BookVO;
import persistence.BookDAO;

import static persistence.JDBCUtil.*;

import java.sql.Connection;

public class BookModifyAction implements Action {

	private String path;

	public BookModifyAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// book_modify.jsp에서 넘긴 값 가져오기
		String code = req.getParameter("code");
		int price = Integer.parseInt(req.getParameter("price"));

		// 데이터베이스 작업하기
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		int result = dao.book_modify(code, price);

		// result에 따라 페이지 이동
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return new ActionForward(path, true);
	}

}
