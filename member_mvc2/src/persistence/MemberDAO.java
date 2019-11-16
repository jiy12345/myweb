package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberVO;
import static persistence.JDBCUtil.*;

public class MemberDAO {
	private Connection con;

	public MemberDAO(Connection con) {
		this.con = con;
	}

	// 회원가입 메소드
	public int join(MemberVO vo) {
		int result = 0;
		PreparedStatement pstmt = null;

		try {
			String sql="insert into member values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public MemberVO isLogin(String userid,String password) {
		MemberVO vo = null;
		// 사용자가 입력한 아이디와 비밀번호가 같으면
		// 아이디와 이름만 VO에 담고 리턴
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select userid, name from member where userid=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				// 있어야 객체를 생성
				vo=new MemberVO();
				vo.setUserid(rs.getString(1));
				vo.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return vo;
	}
	
	// 회원삭제하는 메소드
	public int leave(String userid) {
		int result = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = "DELETE FROM member WHERE userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// 비밀번호 수정
	public int modify(String userid, String new_password) {
		int result = 0;
		PreparedStatement pstmt = null;
		try {
			String sql = "UPDATE FROM member SET password=? WHERE userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, new_password);
			pstmt.setString(2, userid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
