package controller;

import action.Action;
import action.BookDeleteAction;
import action.BookInsertAction;
import action.BookModifyAction;
import action.BookSearchAction;
import action.BookSelectAction;

public class BookActionFactory {
	private static BookActionFactory baf;
	// Singleton 패턴
	
	// 디폴트 생성자 프라이빗으로 막기
	private BookActionFactory() {}
	
	// 스태틱 메소드 안에 생성자 넣기
	public static BookActionFactory getInstance() {
		if(baf == null) {
			baf = new BookActionFactory();
		}
		return baf;
	}
	
	Action action = null;
	
	public Action action(String cmd) {
		
		if(cmd.equals("/select.do")) {
			action = new BookSelectAction("book_select_result.jsp");
		} else if(cmd.equals("/insert.do")) {
			action = new BookInsertAction("select.do");
		} else if(cmd.equals("/delete.do")) {
			action = new BookDeleteAction("select.do");
		} else if(cmd.equals("/modify.do")) {
			action = new BookModifyAction("select.do");
		} else if(cmd.equals("/search.do")) {
			action = new BookSearchAction("book_search_result.jsp");
		}
		return action;
	}
}
