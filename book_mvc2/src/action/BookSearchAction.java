package action;

import javax.naming.directory.SearchResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BookVO;
import persistence.BookDAO;

import static persistence.JDBCUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

public class BookSearchAction implements Action {
	
	private String path;
		
	public BookSearchAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// book_search.jsp로부터 값 받아오기
		String criteria = req.getParameter("criteria");
		String searchword = req.getParameter("searchword");
		
		// 데이터베이스 작업 -> select일때는 commit이 없다!
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		
		ArrayList<BookVO> list = dao.book_search(criteria, searchword);
		
		// ArrayList 결과에 따라 페이지 이동
		if(list.size()>0) {
			req.setAttribute("list", list);
		}
		close(con);
		return new ActionForward(path, false);
	}

}
