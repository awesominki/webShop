package model;

import dto.DeptDTO;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DAO(Data Access Object) : DB에 접근하는 비지니스 로직 작성
public class DeptDAO {
	
	//1. 전체 조회
	public List<DeptDTO> selectAll(){
		List<DeptDTO> deptList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from departments order by 1";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				DeptDTO dept = makeDept(rs);
				deptList.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deptList;
	}
	
	private DeptDTO makeDept(ResultSet rs) throws SQLException {
		int deptid = rs.getInt(1);
		String deptname = rs.getString(2);
		int mid = rs.getInt(3);
		int loc = rs.getInt(4);
		DeptDTO dept = new DeptDTO(deptid, deptname, mid, loc);
		return dept;
	}

	//2. 특정 부서 조회(부서코드로 조회)
	public DeptDTO selectById(int deptid) {
		DeptDTO dept = null;
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from departments where department_id = "
				+ deptid
				+ " order by 1";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next())
				dept = makeDept(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dept;
	}
	
	//3. 지역코드로 조회
	public List<DeptDTO> selectByLocation(int locid) {
		List<DeptDTO> deptList = new ArrayList<>();
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from departments where location_id = "
				+ locid
				+ " order by 1";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				DeptDTO dept = makeDept(rs);
				deptList.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deptList;
	}
	
	//4. 신규 부서입력
	public int deptInsert(DeptDTO dept) {
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		int ret = 0;
		String sql = "insert into departments values("
				+ dept.getDepartment_id()
				+ ", '"
				+ dept.getDepartment_name()
				+ "', "
				+ dept.getManager_id()
				+ " , "
				+ dept.getLocation_id()
				+ ")";
		try {
			st = conn.createStatement();
			ret = st.executeUpdate(sql); //-1(error) , 1(insert 1건) , 0(insert 건수없음)
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	//5. 특정 부서수정
	public int deptUpdate(DeptDTO dept) {
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		int ret = 0;
		String sql = "update departments "
				+ "set department_name='"
				+ dept.getDepartment_name()
				+ "', manager_id="
				+ dept.getManager_id()
				+ ", location_id="
				+ dept.getLocation_id()
				+ " where department_id="
				+ dept.getDepartment_id();
		try {
			st = conn.createStatement();
			ret = st.executeUpdate(sql); //-1(error) , 1(update 1건) , 0(update 건수없음)
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	//6. 특정 부서삭제
	public int deptDelete(int deptid) {
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		int ret = 0;
		String sql = "delete from departments where department_id = " + deptid;
		try {
			st = conn.createStatement();
			ret = st.executeUpdate(sql); //-1(error) , 1(delete 1건) , 0(delete 건수없음)
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
