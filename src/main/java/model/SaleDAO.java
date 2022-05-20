package model;

import dto.SaleAdoptVO;
import dto.SaleVO;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO {
	static final String INSERT_SALE = "insert into usersale values(seq_sid.nextval,?,?,?,?,1)";
	static final String SELECT_ALL = "select * from usersale where sstatus = 1 and suserid != ?";
	static final String SELECT_ADOPT = "SELECT s.sid, s.sdesc, s.sgender, s.sage, a.auserid , a.aid\n"
			+ "FROM USERSALE s JOIN useradopt a ON (s.sid = a.asid) WHERE s.suserid = ? and a.astatus != 0";
	
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;
	
	public List<SaleVO> selectAll(String userid){
		List<SaleVO> slist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SELECT_ALL);
			st.setString(1, userid);
			rs = st.executeQuery();
			while(rs.next()) {
				slist.add(new SaleVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),rs.getInt(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return slist;
	}
	
	public int insertSale(SaleVO sale) {
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(INSERT_SALE);
			st.setString(1, sale.getSuserid());
			st.setString(2, sale.getSdesc());
			st.setString(3, sale.getSgender());
			st.setInt(4, sale.getSage());
			result = st.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return result;
	}

	public List<SaleAdoptVO> selectAdopt(String userid) {
		List<SaleAdoptVO> slist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SELECT_ADOPT);
			st.setString(1, userid);
			rs = st.executeQuery();
			while(rs.next()) {
				slist.add(new SaleAdoptVO(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getInt(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return slist;
	}
}
