package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import persistence.BoardDAO;

import static persistence.JDBCUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

public class BoardListAction implements Action {

	private String path;
	
	public BoardListAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Connection con =getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		// 전체 목록을 담고 페이지 이동
		ArrayList<BoardVO> list = dao.getList();
		
		if(list.size()>0) {
			req.setAttribute("list", list);
		}
		close(con);
		return new ActionForward(path, false);
	}

}
