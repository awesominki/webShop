package controller;

import dto.DeptDTO;
import dto.EmpVO;
import dto.JobVO;
import dto.UsersVO;
import model.DeptService;
import model.EmpService;
import util.DateUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

/**
 * Servlet implementation class EmpDetailServlet
 */
@WebServlet("/emp/empInsert.do")
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsersVO user = (UsersVO) session.getAttribute("user");
		if(user == null){
			System.out.println("로그인하지않음... 직원정보 볼수 없다.");
			response.sendRedirect("../html/login.do");
			return;
		}

		DeptService dService = new DeptService();
		List<DeptDTO> dlist = dService.selectAll();
		
		EmpService eService = new EmpService();
		List<JobVO> jobList = eService.selctJobAll();
		request.setAttribute("dlist", dlist);
		request.setAttribute("jlist", jobList);
		request.setAttribute("mlist", eService.selctManagerAll());
		
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("empInsert.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�Է��ϱ� 
		//request.setCharacterEncoding("utf-8");
		EmpVO emp = makeEmp(request);
		EmpService eService = new EmpService();
		int result = eService.empInsert(emp);
		request.setAttribute("message", result>0?"직원정보 insert성공":"직원정보 insert실패");
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}
	private EmpVO makeEmp(HttpServletRequest request) {
		EmpVO emp = new EmpVO();
		int empid = readInt(request, "employee_id");
		Integer mid = readInt(request, "manager_id");
		int did = readInt(request, "department_id");
		double salary = readDouble(request, "salary");
		double commission_pct = readDouble(request, "commission_pct");
		Date hire_date = readDate(request, "hire_date");
		
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phone_number");
		String job_id = request.getParameter("job_id");
		
		emp.setCommission_pct(commission_pct);
		emp.setDepartment_id(did);
		emp.setEmail(email);
		emp.setEmployee_id(empid);
		emp.setFirst_name(first_name);
		emp.setHire_date(hire_date);
		emp.setJob_id(job_id);
		emp.setLast_name(last_name);
		emp.setManager_id(mid);
		emp.setPhone_number(phone_number);
		emp.setSalary(salary);
		System.out.println(emp);
		return emp;
	}
	private int readInt(HttpServletRequest request, String column) {
		String data = request.getParameter(column);
		return Integer.parseInt(data);
	}
	private double readDouble(HttpServletRequest request, String column) {
		String data = request.getParameter(column);
		return Double.parseDouble(data);
	}
	
	private Date readDate(HttpServletRequest request, String column) {
		String data = request.getParameter(column);
		return DateUtil.convertToDate(data);
	}
	

}







