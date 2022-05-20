package model;

import dto.UserVO;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
	static final String INSERT_USER = "insert into id values(?,?)";
	static final String SELECT_USER = "select * from id";
	
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int result;
	
	public int insertUser(UserVO user) {
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(INSERT_USER);
			st.setString(1,user.getUserid());
			st.setString(2, user.getPassword());
			result = st.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return result;
	}
	public ArrayList<UserVO> getUsers(){
		ArrayList<UserVO> users = new ArrayList<UserVO>();
		UserVO userVO;
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(SELECT_USER);
			rs = st.executeQuery();
			while(rs.next()) {
				userVO = makeUser(rs);
				users.add(userVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return users;
	}
	
	private UserVO makeUser(ResultSet rs) throws SQLException {
		UserVO user = new UserVO();
		user.setUserid(rs.getString(1));
		user.setPassword(rs.getString(2));
		
		return user;
	}
}
