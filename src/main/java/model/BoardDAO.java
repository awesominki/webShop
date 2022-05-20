package model;

import dto.BoardEmpVO;
import dto.BoardVO;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	static final String SQL_SELECT_ALL = "select * from tbl_board order by 1 desc";
	static final String SQL_SELECT_BY_ID = "select * from tbl_board where bno = ?";
	static final String SQL_SELECT_BY_WRITER = "select * from tbl_board where writer = ?";
	static final String SQL_SELECT_BY_TITLE = "select * from tbl_board where title like ?";
	static final String SQL_SELECT_BY_REGDATE = "select * from tbl_board where regdate between ? and ?";
	static final String SQL_INSERT = "insert into tbl_board values(seq_bno.nextval,?,?,?,sysdate,sysdate)";
	static final String SQL_UPDATE = "update tbl_board set title = ? , content = ? , updatedate = sysdate where bno = ?";
	static final String SQL_DELETE = "delete from tbl_board where bno = ?";
	static final String SQL_BOARD_EMP_JOIN = "SELECT b.bno , b.title, b.content , e.FIRST_NAME || ' ' || e.LAST_NAME AS fullname "
			+ "FROM tbl_board b JOIN EMPLOYEES e ON (b.writer = e.EMPLOYEE_ID)";
	
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;
	
	public List<BoardEmpVO> selectAllJoin() {
		List<BoardEmpVO> blist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_BOARD_EMP_JOIN);
			rs = st.executeQuery();
			while(rs.next()) {
				blist.add(new BoardEmpVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return blist;
	}
	
	public List<BoardVO> selectAll() {
		List<BoardVO> blist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_SELECT_ALL);
			rs = st.executeQuery();
			while(rs.next()) {
				blist.add(makeBoard(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return blist;
	}
	
	public BoardVO selectById(int bno){
		BoardVO board = null;
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_SELECT_BY_ID);
			st.setInt(1, bno);
			rs = st.executeQuery();
			while(rs.next()) {
				board = makeBoard(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return board;
	}
	
	private BoardVO makeBoard(ResultSet rs) throws SQLException {
		BoardVO board = new BoardVO();
		board.setBno(rs.getInt(1));
		board.setTitle(rs.getString(2));
		board.setContent(rs.getString(3));
		board.setWriter(rs.getInt(4));
		board.setRegdate(rs.getDate(5));
		board.setUpdatedate(rs.getDate(6));
		
		return board;
	}

	public List<BoardVO> selectByWriter(int writer) {
		List<BoardVO> blist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_SELECT_BY_WRITER);
			st.setInt(1, writer);
			rs = st.executeQuery();
			while(rs.next()) {
				blist.add(makeBoard(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return blist;
	}
	
	public List<BoardVO> selectByTitle(String title) {
		List<BoardVO> blist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_SELECT_BY_TITLE);
			st.setString(1, "%" + title + "%");
			rs = st.executeQuery();
			while(rs.next()) {
				blist.add(makeBoard(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return blist;
	}
	
	public List<BoardVO> selectByRegDate(Date sdate, Date edate) {
		List<BoardVO> blist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_SELECT_BY_REGDATE);
			st.setDate(1, sdate);
			st.setDate(2, edate);
			rs = st.executeQuery();
			while(rs.next()) {
				blist.add(makeBoard(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return blist;
	}
	
	public int insert(BoardVO board) {
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_INSERT);
			st.setString(1, board.getTitle());
			st.setString(2, board.getContent());
			st.setInt(3, board.getWriter());
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return result;
	}
	
	public int update(BoardVO board) {
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_UPDATE);
			st.setString(1, board.getTitle());
			st.setString(2, board.getContent());
			st.setInt(3, board.getBno());
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return result;
	}
	
	public int delete(int bno) {
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SQL_DELETE);
			st.setInt(1, bno);
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return result;
	}
}
