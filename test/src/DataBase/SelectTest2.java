package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest2 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "c##javaDB";
			String password = "12345";
			con = DriverManager.getConnection(url, user, password);
			String sql = "select * from userTBL wher no = 1";
			pstmt = con .prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt(1)+'\t'+
						rs.getString(2)+'\t'+
						rs.getInt(3)+'\t'+
						rs.getString(4)+'\t'+
						rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
