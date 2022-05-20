package model;

import dto.EmpVO;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//CRUD
public class EmpDAO {
	static final String SQL_SELECT_ALL = "select * from employees order by 1";
	static final String SQL_SELECT_BY_DEPT = "select * from employees where department_id = ? order by 1";
	static final String SQL_SELECT_BY_MANAGER = "select * from employees where manager_id = ? order by 1";
	static final String SQL_SELECT_BY_JOB = "select * from employees where job_id = ? order by 1";
	static final String SQL_SELECT_CONDITION = "select * from employees where department_id = ? and job_id = ?"
			+ "and salary >= ? and hire_date >= ? order by 1";
	static final String SQL_SELECT_BY_ID = "select * from employees where employee_id = ?";
	static final String SQL_INSERT = "insert into employees values(?,?,?,?,?,?,?,?,?,?,?)";
	static final String SQL_UPDATE = "update employees set first_name = ? , last_name = ?, email = ?, phone_number=?, hire_date=?,"
			+ "job_id=?, salary=?, commission_pct=?, manager_id=?, department_id=? where employee_id = ?";
	static final String SQL_UPDATE_BY_DEPT = "update employees set salary=?, commission_pct=? where department_id=?";
	static final String SQL_DELETE = "delete from employees where employee_id = ?";
	static final String SQL_DELETE_BY_DEPT = "delete from employees where department_id = ?";
	Connection conn;
	Statement st;
	PreparedStatement pst; //바인딩 변수지원 (?)
	ResultSet rs;
	int result;
	//1. 모든직원조회
	public List<EmpVO> selectAll() {
		List<EmpVO> emplist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL_SELECT_ALL);
			while(rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return emplist;
	}
	
	private EmpVO makeEmp(ResultSet rs) throws SQLException {
		EmpVO emp = new EmpVO();
		emp.setCommission_pct(rs.getDouble("commission_pct"));
		emp.setDepartment_id(rs.getInt("department_id"));
		emp.setEmail(rs.getString("email"));
		emp.setEmployee_id(rs.getInt("employee_id"));
		emp.setFirst_name(rs.getString("first_name"));
		emp.setHire_date(rs.getDate("hire_date"));
		emp.setJob_id(rs.getString("job_id"));
		emp.setLast_name(rs.getString("last_name"));
		emp.setManager_id(rs.getInt("manager_id"));
		emp.setPhone_number(rs.getString("phone_number"));
		emp.setSalary(rs.getDouble("salary"));
		return emp;
	}

	//2. 조건조회(특정 부서 조회)
	public List<EmpVO> selectByDept(int deptid) {
		List<EmpVO> emplist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_BY_DEPT);
			pst.setInt(1, deptid); //첫번째 ? 에 deptid를 대입한다!!!!!!
			rs = pst.executeQuery();
			while(rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return emplist;
	}
	
	//3. 조건조회(특정 매니저)
	public List<EmpVO> selectByManager(int mid) {
		List<EmpVO> emplist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_BY_MANAGER);
			pst.setInt(1, mid); //첫번째 ? 에 mid를 대입한다!!!!!!
			rs = pst.executeQuery();
			while(rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return emplist;
	}
	
	//4. 조건조회(특정 job)
	public List<EmpVO> selectByJob(String job_id) {
		List<EmpVO> emplist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_BY_JOB);
			pst.setString(1, job_id); //첫번째 ? 에 mid를 대입한다!!!!!!
			rs = pst.executeQuery();
			while(rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return emplist;
	}
	
	//5. 조건조회(특정 deptid, jobid, salary>=?, hire_date>=?)
	public List<EmpVO> selectByCondition(int deptid, String job_id, double sal, String hire_date) {
		List<EmpVO> emplist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_CONDITION);
			pst.setInt(1, deptid); //1번째 ? 에 mid를 대입한다!!!!!!
			pst.setString(2, job_id); //2번째 ? 에 mid를 대입한다!!!!!!
			pst.setDouble(3, sal); //3번째 ? 에 mid를 대입한다!!!!!!
			pst.setString(4, hire_date); //4번째 ? 에 mid를 대입한다!!!!!!
			rs = pst.executeQuery();
			while(rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return emplist;
	}
	
	//6. 특정 직원 1건 조회
	public EmpVO selectById(int empid) {
		EmpVO emp = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_BY_ID);
			pst.setInt(1, empid);
			rs = pst.executeQuery();
			while(rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return emp;
	}
	
	//7. insert
	public int empInsert(EmpVO emp) {
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_INSERT);
			pst.setInt(1, emp.getEmployee_id());
			pst.setString(2, emp.getFirst_name());
			pst.setString(3, emp.getLast_name());
			pst.setString(4, emp.getEmail());
			pst.setString(5, emp.getPhone_number());
			pst.setDate(6, emp.getHire_date());
			pst.setString(7, emp.getJob_id());
			pst.setDouble(8, emp.getSalary());
			pst.setDouble(9, emp.getCommission_pct());
			pst.setInt(10, emp.getManager_id());
			pst.setInt(11, emp.getDepartment_id());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return result;
	}
	
	//8. update(특정 직원 1건 employee_id=?)
	public int empUpdate(EmpVO emp) {
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_UPDATE);
			pst.setString(1, emp.getFirst_name());
			pst.setString(2, emp.getLast_name());
			pst.setString(3, emp.getEmail());
			pst.setString(4, emp.getPhone_number());
			pst.setDate(5, emp.getHire_date());
			pst.setString(6, emp.getJob_id());
			pst.setDouble(7, emp.getSalary());
			pst.setDouble(8, emp.getCommission_pct());
			pst.setInt(9, emp.getManager_id());
			pst.setInt(10, emp.getDepartment_id());
			pst.setInt(11, emp.getEmployee_id());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return result;
	}
	
	//9. update(조건 department_id=?)
	public int empUpdateByDept(EmpVO emp, int deptid) {
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_UPDATE_BY_DEPT);
			pst.setDouble(1, emp.getSalary());
			pst.setDouble(2, emp.getCommission_pct());
			pst.setInt(3, deptid);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return result;
	}
	
	//10. delete(특정 직원 1건 employee_id=?)
	public int empDelete(int empid) {
		return result;
	}
	
	//11. delete(조건 department_id=?)
	public int empDeleteByDept(int deptid) {
		return result;
	}
}
