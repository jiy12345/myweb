package controller;

import action.Action;
import action.InsertAction;
import action.LeaveAction;
import action.ModifyAction;
import action.SelectAction;
import action.UserGetAction;

// 사용자로부터 넘어온 command에 따라 액션을 
// 생성한 후 넘겨주는 클래스
public class ActionFactory {
	Action action;
	
	// Singleton 패턴 적용하기(객체를 하나만 생성하도록 만들기)
	// 1. -> 디폴트 생성자를 프라이빗으로 설정함
	private static ActionFactory factory;
	private ActionFactory() {	}
	public static ActionFactory getInstance() {
		if(factory == null) {
			factory = new ActionFactory() ;
		}
		return factory;
	}
	
	// 처음에 들어올때는 /가 붙어야하지만 그 다음에는 루트 주소가 같이 들어오므로 안써주는 것이 맞다!
	
	// /는 루트 경로부터 잡으라는 의미
	public Action action(String cmd) {
		if(cmd.equals("/select.do")) {
			action = new SelectAction("user_all.jsp"); // 모든 작업이 다 끝났을 때
		} else if(cmd.equals("/insert.do")) {
			// insert 후 전체 리스트 보기로 이동
			action = new InsertAction("select.do");
		} else if(cmd.equals("/get.do")) {
			action = new UserGetAction("get.do");
		} else if(cmd.equals("/leave.do")) {
			action = new LeaveAction("select.do");
		} else if(cmd.equals("/modify.do")) {
			action = new ModifyAction("select.do");
		}
		
		return action;
	}
}
