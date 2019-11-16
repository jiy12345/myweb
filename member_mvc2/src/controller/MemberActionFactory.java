package controller;

import action.Action;
import action.JoinAction;
import action.LeaveAction;
import action.LoginAction;
import action.LogoutAction;
import action.ModifyAction;

public class MemberActionFactory {
	private static MemberActionFactory maf;
	
	private MemberActionFactory() {
		
	}
	
	public static MemberActionFactory getInstance() {
		if(maf==null)
			maf = new MemberActionFactory();
		return maf;
	}
	
	Action action = null;
	public Action action(String cmd) {
		
		if(cmd.equals("/join.do")) {
			action = new JoinAction("view/loginForm.jsp");
		} else if(cmd.equals("/login.do")) {
			action = new LoginAction("view/loginForm.jsp");
		} else if(cmd.equals("/logout.do")) {
			action = new LogoutAction("view/loginForm.jsp");
		} else if(cmd.equals("/leave.do")) {
			action = new LeaveAction("index.jsp");
		} else if(cmd.equals("/modify.do")) {
			action = new ModifyAction("view/loginForm.jsp");
		}
		
		return action;
	}
}
