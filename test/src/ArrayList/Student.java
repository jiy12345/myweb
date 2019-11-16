
package ArrayList;

public class Student {
	private String id;
	private String name;
	private String tel;
	private String addr;
	
	public Student(String id, String name, String tel, String addr) {
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}
}
