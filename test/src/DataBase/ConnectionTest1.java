package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest1 {
	public static void main(String[] args) {
		// 드라이버 로드
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			// 데이터베이스 연결
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			// 커넥션을 리턴해주므로 커넥션 변수에 받아놓음
			Connection con = DriverManager.getConnection(url, "c##javaDB", "12345");
			if(con!=null) {
				System.out.println("연결되었습니다.");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
