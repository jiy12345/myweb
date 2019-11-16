package persistence;

import static persistence.JDBCUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.BoardVO;

public class BoardDAO {
	private Connection con;

	public BoardDAO(Connection con) {
		super();
		this.con = con;
	}

	// 게시판 글 작성
	public int insertArticle(BoardVO vo) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "insert into board(bno,name,password,title,content,re_ref,re_lev,re_seq) ";
		sql += "values(board_seq.nextVal,?,?,?,?,board_seq.currVal,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<BoardVO> getList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<BoardVO> list = new ArrayList<>();
		BoardVO vo = null;
		try {
			String sql = "select bno,title,name,regdate,readcount from board "; // 공백 처리를 해주어야 뒤에 바로 붙지 않는다!
			sql += "order by bno desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new BoardVO();
				vo.setBno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setRegdate(rs.getDate(4));
				vo.setReadcount(rs.getInt(5));
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

	// bno와 일치하는 정보 가져오기 = vo
	// 작성자, 제목, 내용, 글 번호
	public BoardVO view(int bno) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		BoardVO vo = null;
		try {
			String sql = "select bno,title,name,content from board where bno=?"; // 공백 처리를 해주어야 뒤에 바로 붙지 않는다!
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new BoardVO();
				vo.setBno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setContent(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return vo;
	}

	// 조회수 업데이트 하는 메소드
	public int update_readcount(int bno) {
		int result = 0;
		PreparedStatement pstmt = null;

		try {
			String sql = "UPDATE board SET readcount=readcount+1 where bno=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	// 내용수정
	public int update(BoardVO vo) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "update board set title=?, content=? where bno=? and password=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(1, vo.getBno());
			pstmt.setString(1, vo.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
