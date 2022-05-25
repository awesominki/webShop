package model;

import dto.UsersVO;
import util.DBUtil;
import util.LogPreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO {
    Connection conn;
    LogPreparedStatement st;
    ResultSet rs;
    public UsersVO selectById(String user_id,String user_pass){
        UsersVO user = null;
        conn = DBUtil.getConnection();
        try {
            st = new LogPreparedStatement(conn,"select user_name,phone from tbl_users where user_id=? and user_pass=?");
            st.setString(1, user_id);
            st.setString(2, user_pass);
            rs = st.executeQuery();
            while(rs.next()) {
                user = new UsersVO(user_id,rs.getString(1),user_pass,rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbClose(rs, st, conn);
        }

        return user;
    }
}
