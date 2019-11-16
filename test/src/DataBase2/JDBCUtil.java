package DataBase2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	//드라이버 로드, 커넥션, close, commit, rollback
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}		
	}
	
	public static Connection getConnection() {
		Connection con=null;
		
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="c##javaDB";
			String password="12345";
			con=DriverManager.getConnection(url,user,password);
			con.setAutoCommit(false);			 
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return con;	
	}
	
	public static void close(ResultSet rs) {
		try {		
				if(!rs.isClosed()) {
					rs.close();
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection con) {
		try {					
				if(!con.isClosed()) {
					con.close();
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pstmt) {
		try {					
				if(!pstmt.isClosed()) {
					pstmt.close();
				}				
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}	
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
}










