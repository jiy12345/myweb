package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.BookVO;

import static persistence.JDBCUtil.*;


public class BookDAO {
	private Connection con;
	
	public BookDAO(Connection con) {
		this.con = con;
	}
	
	public int book_insert(BookVO vo) {
		PreparedStatement pstmt;
		int result = 0;
		try {	
			String sql="insert into bookTBL values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, vo.getPrice());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<BookVO> selectAll(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BookVO> list = new ArrayList<>();
		BookVO vo = null;
		try {
			String sql ="select * from bookTBL";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				vo = new BookVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}	
		return list;
	}
	
	public int book_delete(String code) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from bookTBL where code=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int book_modify(String code, int price) {
		int result = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("update bookTBL set price=? where code=?");
			pstmt.setInt(1, price);
			pstmt.setString(2, code);	
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<BookVO> book_search(String criteria, String searchword) {
		// criteria => code or writer
		ArrayList<BookVO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from bookTBL where " + criteria + " = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchword);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BookVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return list;
	}
}
