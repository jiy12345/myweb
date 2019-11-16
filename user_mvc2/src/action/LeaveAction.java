package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.UserDAO;

import static persistence.JDBCUtil.*;

import java.sql.Connection;

public class LeaveAction implements Action {

	String path;
	
	public LeaveAction(String path) {
		super();
		this.path = path;
	}



	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// no값 가져오기
		int no = Integer.parseInt(req.getParameter("no"));
		
		// DB작업
		Connection con = getConnection();
		UserDAO dao = new UserDAO(con);
		int result = dao.user_delete(no);
		
		// 페이지 이동
		if(result>0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		// 페이지 이동

		return new ActionForward(path, true);
	}

}
