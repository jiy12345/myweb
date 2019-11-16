package action;

public class ActionForward {
	// 경로와 이동 방식을 가지고 있는 클래스
	private String path;
	private boolean redirect;
	
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
