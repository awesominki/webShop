package model;

import dto.DeptDTO;

import java.util.List;

//Service : Business Logic작성한다.
//DB작은 DAO를 호출한다.
public class DeptService {
	private DeptDAO deptDAO = new DeptDAO();
	
	//1. 전체 조회
	public List<DeptDTO> selectAll(){
		return deptDAO.selectAll();
	}
	//2. 특정 부서 조회(부서코드로 조회)
	public DeptDTO selectById(int deptid) {
		return deptDAO.selectById(deptid);
	}
	//3. 지역코드로 조회
	public List<DeptDTO> selectByLocation(int locid) {
		return deptDAO.selectByLocation(locid);
	}
	//4. 신규 부서입력
	public int deptInsert(DeptDTO dept) {
		return deptDAO.deptInsert(dept);
	}
	//5. 특정 부서수정
	public int deptUpdate(DeptDTO dept) {
		return deptDAO.deptUpdate(dept);
	}
	//6. 특정 부서삭제
	public int deptDelete(int deptid) {
		return deptDAO.deptDelete(deptid);
	}
}
