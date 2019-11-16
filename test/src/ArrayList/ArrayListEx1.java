package ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx1 {
	public static void main(String[] args) {
		// List : 순서가 있음, 중복이 가능함
		// List 인터페이스이고 실제 구현한 클래스들이 
		// ArrayList, Vector, LinkedList 등이 있다.
		// 전체적인 개념은 배열과 동일함.
		List<String> list1 = new ArrayList<>();
		// 리스트에 데이터 추가하기
		list1.add("jsp");
		list1.add("servlet");
		list1.add("html");
		list1.add("css");
		
		for(String str:list1) {
			System.out.print(str+" ");
		}
		System.out.println("");
		// 특정 요소 가져오기
		System.out.println(list1.get(2));
	}

}
