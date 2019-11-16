package action;

// 각 액션 클래스가 DB와의 작업을 마치고 이동할 경로와
// 이동 방식을 가지고 있는 클래스
public class ActionForward {
	private String path; // 다음에 어디로 이동할지
	private boolean redirect; // 다음에 어떻게 이동할지 true(sendRedirect)/false(forward)
	
	public ActionForward() {
		super();
	}

	public ActionForward(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
}
