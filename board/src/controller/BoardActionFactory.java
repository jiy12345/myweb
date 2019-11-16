package controller;

import action.Action;
import action.BoardHitAction;
import action.BoardListAction;
import action.BoardModifyAction;
import action.BoardUpdateAction;
import action.BoardViewAction;
import action.BoardWriteAction;

public class BoardActionFactory {
	private static BoardActionFactory maf;
	
	private BoardActionFactory() {
		
	}
	
	public static BoardActionFactory getInstance() {
		if(maf==null)
			maf = new BoardActionFactory();
		return maf;
	}
	
	Action action = null;
	public Action action(String cmd) {
		
		if(cmd.equals("/insert.do")) {
			action = new BoardWriteAction("list.do");
		} else if(cmd.equals("/list.do")) {
			action = new BoardListAction("view/qna_board_list.jsp");
		} else if(cmd.equals("/view.do")) {
			action = new BoardViewAction("view/qna_board_view.jsp");
		} else if(cmd.equals("/hitUpdate.do")) {
			action = new BoardHitAction("view.do");
		} else if(cmd.equals("modify.do")) {
			action = new BoardModifyAction("view/qna_board_modify.jsp");
		} else if(cmd.equals("update.do")) {
			action = new BoardUpdateAction("view.do");
		}
		
		return action;
	}
}
