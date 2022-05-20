package model;

import dto.BoardEmpVO;
import dto.BoardVO;

import java.sql.Date;
import java.util.List;

public class BoardService {
	BoardDAO dao = new BoardDAO();
	public List<BoardEmpVO> selectAllJoin() {
		return dao.selectAllJoin();
	}
	
	public List<BoardVO> selectAll() {
		return dao.selectAll();
	}
	
	public BoardVO selectById(int bno){
		return dao.selectById(bno);
	}
	
	public List<BoardVO> selectByWriter(int writer) {
		return dao.selectByWriter(writer);
	}
	
	public List<BoardVO> selectByTitle(String title) {
		return dao.selectByTitle(title);
	}
	
	public List<BoardVO> selectByRegDate(Date sdate, Date edate) {
		return dao.selectByRegDate(sdate, edate);
	}
	
	public int insert(BoardVO board) {
		return dao.insert(board);
	}
	
	public int update(BoardVO board) {
		return dao.update(board);
	}
	
	public int delete(int bno) {
		return dao.delete(bno);
	}
}
