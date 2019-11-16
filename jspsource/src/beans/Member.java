package beans;

// 기본 클래스 모양 -> bean이라고 부름

public class Member {
	// 인스턴스 변수, 멤버변수
	private String id;
	private String name;
	private String tel;
	
	public Member() {
		
	}

	public Member(String id, String name, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
