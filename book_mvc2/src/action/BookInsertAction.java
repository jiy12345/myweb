package action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BookVO;
import persistence.BookDAO;

import static persistence.JDBCUtil.*;

public class BookInsertAction implements Action {

	private String path;

	public BookInsertAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// book_insert.jsp에서 사용자가 입력한 도서정보 가져오기
		String code = req.getParameter("code");
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		int price = Integer.parseInt(req.getParameter("price"));
		BookVO vo = new BookVO(code, title, writer, price);

		// 데이터베이스 작업
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		int result = dao.book_insert(vo);
		if(result>0) {
			// result가 1이라면 전체 목록으로 이동
			commit(con);
		}else {
			// result가 0이면 입력 화면으로 이동
			path = "index.jsp";
			rollback(con);
		}
		close(con);
		return new ActionForward(path, true); // 값을 살리것이 없으므로 true로 빼기!
	}

}
