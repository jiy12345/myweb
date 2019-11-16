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
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 사용자의 요청이 어디에서 왔는지 알아내기
		req.setCharacterEncoding("utf-8");
		
		String requestURI = req.getRequestURI(); // ex) /user_mvc2/select.do
		String contextPath = req.getContextPath(); // /user_mvc2
		String cmd = requestURI.substring(contextPath.length()); // /selecet.do
		
		
		ActionFactory factory = ActionFactory.getInstance();
		Action action = factory.action(cmd);
		
		ActionForward af = null;
		try {
			af = action.execute(req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(af.isRedirect()) {
			// sendRedirect
			res.sendRedirect(af.getPath());
		} else {
			// forward
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
