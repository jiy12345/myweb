package DataBase2;

//JDBCUtil 클래스를 정적으로 import
import static DataBase2.JDBCUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
	
	Connection con;
	
	public UserDAO(Connection con) {
		this.con=con;
	}
	
	
	//DML 관련 작업	
	//insert
	public int user_insert(String username,int birthyear,String addr,String tel) {
		int result=0;
		PreparedStatement pstmt=null;
		try {
			String sql="insert info userTBL values(user_seq.nextVal,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setInt(2, birthyear);
			pstmt.setString(3, addr);
			pstmt.setString(4, tel);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	//update
	public int user_update(UserVO vo) {
		int result=0;
		PreparedStatement pstmt=null;
		try {
			String sql="update userTBL set addr=? where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getAddr());
			pstmt.setInt(2, vo.getNo());			
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	//delete
	public int user_delete(int no) {
		int result=0;
		PreparedStatement pstmt=null;		
		try {
			String sql="delete from userTBL where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}	
		return result;
	}
	//select => selectAll
	public ArrayList<UserVO> selectAll() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		ArrayList<UserVO> list=new ArrayList<>();
		UserVO vo=null;		
		try {
			String sql="select * from userTBL";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				vo=new UserVO();
				vo.setNo(rs.getInt(1));
				vo.setUsername(rs.getString(2));
				vo.setBirthYear(rs.getInt(3));
				vo.setAddr(rs.getString(4));
				vo.setMobile(rs.getString(5));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	
	// selectOne
	public UserVO selectOne() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UserVO vo=null;
		try {
			String sql="select * from userTBL where no=3";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vo=new UserVO();
				vo.setNo(rs.getInt(1));
				vo.setUsername(rs.getString(2));
				vo.setBirthYear(rs.getInt(3));
				vo.setAddr(rs.getString(4));
				vo.setMobile(rs.getString(5));
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return vo;
	}
}








