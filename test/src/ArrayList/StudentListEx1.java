package ArrayList;

import java.util.ArrayList;
import java.util.List;

public class StudentListEx1 {

	public static void main(String[] args) {
		// Student 객체를 ArrayList에 담기
		List<Student> list1 = new ArrayList<>();
		
		Student stu1 = new Student("suyeon0255", "조수연", "01050280255", "서울시");
		list1.add(stu1);
		list1.add(new Student("jiy12345", "정일용", "01048843953", "경기도"));
		
		for(Student stu:list1) {
			stu.toString();
		}
	}
}
