package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public void excute(HttpServletRequest req, HttpServletResponse res) 
			throws Exception;
}
