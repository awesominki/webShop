package util;

import java.sql.*;

public class DBConnectionTest2 {

	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		//60번 부서의 직원정보를 조회
		String sql = "select employee_id, first_name, salary, hire_date from employees where department_id = 60";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				int empid = rs.getInt(1);
				String fname = rs.getString(2);
				double sal = rs.getDouble(3);
				Date hdate = rs.getDate(4);
				
				System.out.println(empid + "\t" + fname + "\t" + sal + "\t" + hdate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		
	}

}
