package action;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BookVO;
import persistence.BookDAO;

import static persistence.JDBCUtil.*;

public class BookSelectAction implements Action {

	private String path;
	
	
	
	public BookSelectAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 도서 전체 목록 가져오기
		Connection con =  getConnection();
		BookDAO dao = new BookDAO(con);
		
		// 전체 목록을 담고 페이지 이동
		ArrayList<BookVO> list = dao.selectAll();
		
		if(list.size()>0) {
			req.setAttribute("list", list);
		}
		close(con);
		return new ActionForward(path, false);
	}

}
