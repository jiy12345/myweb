package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserVO;
import persistence.UserDAO;

// 클래스명 안 써도 되게 함
import static persistence.JDBCUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

public class SelectAction implements Action {

	private String path;
	
	public SelectAction(String path) {
		super();
		this.path = path;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 전체 리스트를 가져오는 DB작업하기
		Connection con = getConnection();
		UserDAO dao = new UserDAO(con);
		ArrayList<UserVO> list = dao.selectAll();
		
		if(!list.isEmpty()) {
			// 리스트를 담고 페이지 이동
			req.setAttribute("list", list);
		}
		
		// 리퀘스트에 값이 담겨있으므로 리퀘스트 영역의 상태를 그대로 유지해야하기 때문에
		// false(forward 방식)로 옮겨준다!
		return new ActionForward(path, false);
	}

}
