package DataBase2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JDBCUtil {
	// 커넥션, close, commit, rollback
	public static Connection getConnection() {
		Connection con=null;
		
		try {
			Context ctx;
			ctx = new InitialContext();
			DataSource ds= (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle");
			con=ds.getConnection();
			con.setAutoCommit(false);			 
		} catch (SQLException|NamingException e) {			
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










