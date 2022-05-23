package model;

import dto.EmpVO;
import dto.JobVO;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//CRUD�۾�(insert(C), select(R),update(U), Delete(D)==>DAO(Data Access Object)
public class EmpDAO {
	static final String SQL_SELECT_ALL = "select * from employees order by 1";
	static final String SQL_SELECT_BYDEPT = "select * from employees where department_id = ? order by 1";
	static final String SQL_SELECT_BYMANAGER = "select * from employees where manager_id = ? order by 1";
	static final String SQL_SELECT_JOB = "select * from employees where job_id = ? order by 1";
	static final String SQL_SELECT_CONDITION = " select * " + " from employees " + " where department_id=? "
			+ " and job_id = ? " + " and salary >= ?" + " and hire_date>= ?" + " order by 1";
	static final String SQL_SELECT_BYID = "select * from employees where employee_id = ?  ";
	static final String SQL_INSERT = "insert into employees values(?,?,?,?,?,?,?,?,?,?,?)";
	static final String SQL_UPDATE = "UPDATE EMPLOYEES SET  " + "  FIRST_NAME=?, " + "  LAST_NAME=?, " + "  EMAIL=?, "
			+ "  PHONE_NUMBER=?, " + "  HIRE_DATE=?, " + "  JOB_ID=?, " + "  SALARY=?, " + "  COMMISSION_PCT=?, "
			+ "  MANAGER_ID=decode(?,0,null,?), " + "  DEPARTMENT_ID=? " + " WHERE EMPLOYEE_ID = ?";
	static final String SQL_UPDATE_BYDEPT = "UPDATE EMPLOYEES SET" + "  SALARY=?, " + "  COMMISSION_PCT=?  "
			+ " WHERE DEPARTMENT_ID = ?";

	static final String SQL_DELETE = "DELETE FROM EMPLOYEES \r\n" + "	WHERE EMPLOYEE_ID = ?";
	static final String SQL_DELETE_BYDEPT = "DELETE FROM EMPLOYEES \r\n" + "	WHERE DEPARTMENT_ID = ?";

	static final String SQL_MANAGERALL = "select employee_id, first_name " + " from employees "
			+ " where employee_id in (select distinct manager_id from employees)";

	Connection conn;
	Statement st;
	PreparedStatement pst; // ���ε��������� (?)
	ResultSet rs;
	int result;

	// 1.���������ȸ
	public List<EmpVO> selctAll() {
		List<EmpVO> emplist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL_SELECT_ALL);
			while (rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return emplist;
	}

	// ���jobs��ȸ
	public List<JobVO> selctJobAll() {
		List<JobVO> joblist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from jobs order by 1");
			while (rs.next()) {
				JobVO job = new JobVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				joblist.add(job);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return joblist;
	}

	// ��� manager��ȸ
	public Map<Integer,String> selctManagerAll() {
		Map<Integer,String> managerMap = new HashMap<Integer,String>();
		conn = DBUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL_MANAGERALL);
			while (rs.next()) {
				managerMap.put(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		return managerMap;
	}

	private EmpVO makeEmp(ResultSet rs) throws SQLException {
		EmpVO emp = new EmpVO();
		emp.setCommission_pct(rs.getDouble("commission_PCT"));
		emp.setDepartment_id(rs.getInt("department_id"));
		emp.setEmail(rs.getString("email"));
		emp.setEmployee_id(rs.getInt("employee_id"));
		emp.setFirst_name(rs.getString("first_name"));
		emp.setHire_date(rs.getDate("hire_date"));
		emp.setJob_id(rs.getString("job_id"));
		emp.setLast_name(rs.getString("last_name"));
		emp.setManager_id(rs.getInt("manager_id"));
		emp.setPhone_number(rs.getString("PHONE_NUMBER"));
		emp.setSalary(rs.getDouble("salary"));
		return emp;
	}

	// 2.������ȸ(Ư���μ�)
	public List<EmpVO> selctByDept(int deptid) {
		List<EmpVO> emplist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_BYDEPT);
			pst.setInt(1, deptid); // ù��°?�� �μ���ȣ�� �ִ´�.
			rs = pst.executeQuery();
			while (rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return emplist;
	}

	// 3.������ȸ(Ư���޴���)
	public List<EmpVO> selctByManager(int mid) {
		List<EmpVO> emplist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_BYMANAGER);
			pst.setInt(1, mid); // ù��°?�� �μ���ȣ�� �ִ´�.
			rs = pst.executeQuery();
			while (rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return emplist;
	}

	// 4.������ȸ(Ư��job)
	public List<EmpVO> selctByJob(String job_id) {
		List<EmpVO> emplist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_JOB);
			pst.setString(1, job_id); // ù��°?�� �μ���ȣ�� �ִ´�.
			rs = pst.executeQuery();
			while (rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return emplist;
	}

	// 5.������ȸ(Ư�� department_id=, job_id=, salary>=?, hire_date>=?)
	public List<EmpVO> selctByCondition(int deptid, String job_id, double sal, String hire_date) {
		List<EmpVO> emplist = new ArrayList<>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_CONDITION);
			pst.setInt(1, deptid); // 1��°?�� �μ���ȣ�� �ִ´�.
			pst.setString(2, job_id); // 2��°?�� job_id�� �ִ´�.
			pst.setDouble(3, sal); // 3��°?�� sal�� �ִ´�.
			pst.setString(4, hire_date); // 4��°?�� hire_date�� �ִ´�.

			rs = pst.executeQuery();
			while (rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return emplist;
	}

	// 6.Ư������ 1�� ��ȸ
	public EmpVO selectById(int empid) {
		EmpVO emp = null;

		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_BYID);
			pst.setInt(1, empid); // 1��°?�� empid�� �ִ´�.
			rs = pst.executeQuery();
			while (rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return emp;
	}

	// 7.insert
	public int empInsert(EmpVO emp) {
		int result = 0;

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
			DBUtil.dbClose(rs, pst, conn);
		}

		return result;
	}

	// 8.update(Ư������ 1�� employee_id=?)
	public int empUpdate(EmpVO emp) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_UPDATE);
			pst.setInt(12, emp.getEmployee_id());
			pst.setString(1, emp.getFirst_name());
			pst.setString(2, emp.getLast_name());
			pst.setString(3, emp.getEmail());
			pst.setString(4, emp.getPhone_number());
			pst.setDate(5, emp.getHire_date());
			pst.setString(6, emp.getJob_id());
			pst.setDouble(7, emp.getSalary());
			pst.setDouble(8, emp.getCommission_pct());
			pst.setInt(9, emp.getManager_id());
			pst.setInt(10, emp.getManager_id());
			pst.setInt(11, emp.getDepartment_id());
			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}

	// 9.update(���� department_id=?)
	public int empUpdateByDept(EmpVO emp, int deptid) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_UPDATE_BYDEPT);
			pst.setDouble(1, emp.getSalary());
			pst.setDouble(2, emp.getCommission_pct());
			pst.setInt(3, deptid);

			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}

	// 10.delete(Ư������ 1�� employee_id=?)
	public int empDelete(int empid) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_DELETE);
			pst.setInt(1, empid);

			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}

	// 11.delete(���� department_id=?)
	public int empDeleteByDept(int deptid) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_DELETE_BYDEPT);
			pst.setInt(1, deptid);

			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}

}
