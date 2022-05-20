package model;

import dto.AdoptVO;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdoptDAO {
	static final String INSERT_SALE = "insert into useradopt values(seq_aid.nextval,?,?,2)";
	static final String UPDATE_SALE_STATUS = "update usersale set sstatus = ? where sid = ?";
	static final String UPDATE_ADOPT_STATUS = "update useradopt set astatus = 0 where aid = ?";
	
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;
	
	public int insertAdopt(AdoptVO adopt) {
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(INSERT_SALE);
			st.setInt(1, adopt.getAsid());
			st.setString(2, adopt.getAuserid());
			result = st.executeUpdate();
			st = conn.prepareStatement(UPDATE_SALE_STATUS);
			st.setInt(1, 0);
			st.setInt(2, adopt.getAsid());
			result = st.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return result;
	}
	public int acceptAdopt(AdoptVO adopt) {
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(UPDATE_ADOPT_STATUS);
			st.setInt(1, adopt.getAsid());
			result = st.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return result;
	}
	
}
