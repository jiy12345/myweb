package pattern;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.DeleteAction;
import action.InsertAction;
import action.SearchAction;
import action.SelectAction;

/**
 * Servlet implementation class PatternServlet
 */
@WebServlet("*.do") // 호출시 아무거나.do로 호출할 수 있다!
public class PatternServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		// req와 res를 ~Action으로 넘겨줌 
		// 서블릿에 처리해달라고 넘겨진 일을 다른 자바 파일로 넘김
		if(command.equals("/select.do")) {
			out.print("select 요청");
			Action action = new SelectAction();
			try {
				action.excute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/delete.do")) {
			out.print("delete 요청");
			Action action = new DeleteAction();
			try {
				action.excute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/search.do")) {
			out.print("search 요청");
			Action action = new SearchAction();
			try {
				action.excute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(command.equals("/insert.do")) {
			out.print("insert 요청");
			Action action = new InsertAction();
			try {
				action.excute(req, res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		out.print("서블릿 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
