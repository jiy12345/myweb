package domain;

public class UserVO { 
	//DB 테이블의 구조랑 동일하게 만드는 것이 일반적
	private int no;
    private String username;
    private int birthyear;
    private String addr;
    private String mobile;
    
    public UserVO() {
		// TODO Auto-generated constructor stub
	}

    public UserVO(String username, int birthyear, String addr, String mobile) {
    	super();
    	this.username = username;
    	this.birthyear = birthyear;
    	this.addr = addr;
    	this.mobile = mobile;
    }
	public UserVO(int no, String username, int birthyear, String addr, String mobile) {
		super();
		this.no = no;
		this.username = username;
		this.birthyear = birthyear;
		this.addr = addr;
		this.mobile = mobile;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public int getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(int birthyear) {
		this.birthyear = birthyear;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "UserVO [no=" + no + ", username=" + username + ", birthyear=" + birthyear + ", addr=" + addr
				+ ", mobile=" + mobile + "]";
	}
	
	
}
