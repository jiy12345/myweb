package DataBase2;

import static DataBase2.JDBCUtil.*;

import java.sql.Connection;
import java.util.ArrayList;


public class UserMain {
	public static void main(String[] args) {
		//드라이버로드, Connection
		Connection con=getConnection();
		UserDAO dao=new UserDAO(con);
		//selectOne
		UserVO vo=dao.selectOne();
		if(vo!=null) {
			System.out.println(vo);
		}else {
			System.out.println("데이터가 없습니다.");
		}
		
		//userTBL 전체 가져오기
//		ArrayList<UserVO> list=dao.selectAll();
//		if(!list.isEmpty()) {// list.size()>0
//			for(UserVO vo1:list) {
//				System.out.println(vo1);
//			}
//		}
//		
//		//update 작업 : addr, no 가 필요함
//		UserVO vo1=new UserVO();
//		vo1.setNo(4);
//		vo1.setAddr("부천");
//		int result=dao.user_update(vo1);
//		if(result>0) {
//			System.out.println("수정완료");
//			commit(con);
//		}else {
//			rollback(con);
//		}
//		
//		
//		//delete		
//		
//		
//		//insert 작업
//		String username="송중기";
//		int birthyear=2005;
//		String addr="부산";
//		String tel="01056899685";		
//		
//		int result1=dao.user_insert(username,birthyear,addr,tel);
//		//result가 0보다 큰 경우 commit
//		if(result1>0) {
//			System.out.println("삽입 완료");
//			commit(con);
//		}else {
//		//0이면 rollback
//			rollback(con);
//		}
//		close(con);
	}
}











