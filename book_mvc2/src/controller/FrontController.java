package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 서블릿으로 넘어오는 요청 한글처리
		req.setCharacterEncoding("utf-8");
		
		// URI 분리하기 - 명령어가 어디서 왔는지 알아내기 위해
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String cmd = requestURI.substring(contextPath.length());
		
		// cmd(ex  /select.do)에 의해 액션 생성하기
		// 액션 생성은 BookActionFactory에게 맡겨서 액션 리턴 받기
		BookActionFactory baf = BookActionFactory.getInstance(); // 객체 생성
		// action을 써서 하는 이유 -> 부모를 사용하여 여러가지를 다 받을 수 있다!
		Action action = baf.action(cmd); 
		
		// 넘겨받은 액션에게 일 시키고 난 후 이동 경로와 이동 방식 리턴 받기
		ActionForward af = null;
		try {
			af = action.execute(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 리턴 받은 ActionForward를 기반으로 이동
		if(af.isRedirect()) { // true ->sendRedirect
			res.sendRedirect(af.getPath());
		} else {
			RequestDispatcher rd = req.getRequestDispatcher(af.getPath());
			rd.forward(req, res);
		}
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}