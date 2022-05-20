package model;

import dto.EmpVO;

import java.util.List;

//사용자요청 --> Controller --> Service --> DAO --> DB
//        <--            <--         <--     <--
public class EmpService {
	EmpDAO empDAO = new EmpDAO();
	//1. 모든직원조회
	public List<EmpVO> selectAll() {
		return empDAO.selectAll();
	}
	
	//2. 조건조회(특정 부서 조회)
	public List<EmpVO> selectByDept(int deptid) {
		return empDAO.selectByDept(deptid);
	}
	
	//3. 조건조회(특정 매니저)
	public List<EmpVO> selectByManager(int mid) {
		return empDAO.selectByManager(mid);
	}
	
	//4. 조건조회(특정 job)
	public List<EmpVO> selectByJob(String job_id) {
		return empDAO.selectByJob(job_id);
	}
	
	//5. 조건조회(특정 deptid, jobid, salary>=?, hire_date>=?)
	public List<EmpVO> selectByCondition(int deptid, String job_id, double sal, String hire_date) {
		return empDAO.selectByCondition(deptid, job_id, sal, hire_date);
	}
	
	//6. 특정 직원 1건 조회
	public EmpVO selectById(int empid) {
		return empDAO.selectById(empid);
	}
	
	//7. insert
	public int empInsert(EmpVO emp) {
		return empDAO.empInsert(emp);
	}
	
	//8. update(특정 직원 1건 employee_id=?)
	public int empUpdate(EmpVO emp) {
		return empDAO.empUpdate(emp);
	}
	
	//9. update(조건 department_id=?)
	public int empUpdateByDept(EmpVO emp, int deptid) {
		return empDAO.empUpdateByDept(emp, deptid);
	}
	
	//10. delete(특정 직원 1건 employee_id=?)
	public int empDelete(int empid) {
		return empDAO.empDelete(empid);
	}
	
	//11. delete(조건 department_id=?)
	public int empDeleteByDept(int deptid) {
		return empDAO.empDeleteByDept(deptid);
	}
}
