package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BookVO;
import persistence.BookDAO;

import static persistence.JDBCUtil.*;

import java.sql.Connection;

public class BookDeleteAction implements Action {

	private String path;
		
	public BookDeleteAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// book_delete.jsp에서 삭제할 코드 가져오기
		String code = req.getParameter("code");
		BookVO vo = new BookVO();
		vo.setCode(code);
		
		// 데이터베이스 작업
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		int result = dao.book_delete(code);
		
		// result에 따라 페이지 이동
		if(result>0) {
			commit(con);
		} else {
			path = "index.jsp";
			rollback(con);
		}
		close(con);
		return new ActionForward(path, true);
	}

}
