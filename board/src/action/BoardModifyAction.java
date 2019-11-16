package action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import persistence.BoardDAO;

import static persistence.JDBCUtil.*;

public class BoardModifyAction implements Action {

	private String path;
	
	public BoardModifyAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		int bno = Integer.parseInt(req.getParameter("bno"));
		
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		BoardVO vo = dao.view(bno);
		if(vo!=null) {
			req.setAttribute("vo", vo);
		}
		close(con);
		return new ActionForward(path, false);
	}

}
