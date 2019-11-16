package domain;

public class MemberVO {
	private String userid;
	private String password;
	private String name;
	private String gender;
	private String email;
	
	// password와 confirm_password가 동일한지 확인하는 메소드
	public boolean equalToPassword(String confirm_password) {
		return password.equals(confirm_password);
	}
	
	public MemberVO() {
		super();
	}
	
	public MemberVO(String userid, String password, String name, String gender, String email) {
		super();
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.email = email;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", password=" + password + ", name=" + name + ", gender=" + gender
				+ ", email=" + email + "]";
	}
		
}
