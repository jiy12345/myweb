package DataBase;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 커넥션
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "c##javaDB";
			String password = "12345";
			con = DriverManager.getConnection(url, user, password);
			// 커넥션을 통해 SQL 구문 전송
			String sql = "select * from userTBL";
			// -> select는 커밋이 필요 없다!
			pstmt = con.prepareStatement(sql); // -> sql구문을 DB서버로 전송하기 위한 객체
			// 쿼리문 실행 : select : executeQuery()
			// insert, update, delete : executeUpdate()
			
			// select : 테이블을 저장해줄 공간에 리턴 값을 받아주어야 함
			rs = pstmt.executeQuery();
			
			// insert, update, delete : int값 반환
			// int result = pstmt.executeUpdate;
			
			// 쿼리문 실행 결과를 화면에 출력하기
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t");
				// System.out.println(rs.getInt("no")+"\t"); -> 이런식으로 칼럼 명을 지정해줄 수도 있다!
				System.out.println(rs.getString(2)+"\t");
				System.out.println(rs.getInt(3)+"\t");
				System.out.println(rs.getString(4)+"\t");
				System.out.println(rs.getString(5)+"\t");
			}		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
