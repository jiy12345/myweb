package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import persistence.BoardDAO;

import static persistence.JDBCUtil.*;

import java.sql.Connection;

public class BoardWriteAction implements Action {

	private String path;
	
	public BoardWriteAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String name = req.getParameter("name");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String password = req.getParameter("password");
		
		BoardVO vo = new BoardVO();
		vo.setName(name);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setPassword(password);
		
		Connection con = getConnection();
		BoardDAO dao = new BoardDAO(con);
		
		int result = dao.insertArticle(vo);
		
		if(result>0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return new ActionForward(path, true);
	}

}
