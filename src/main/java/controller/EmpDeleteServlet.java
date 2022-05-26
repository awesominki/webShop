package controller;

import dto.UsersVO;
import model.EmpService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class EmpDeleteServlet
 */
@WebServlet("/emp/empDelete.do")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UsersVO user = (UsersVO) session.getAttribute("user");
		if(user == null) {
			System.out.println("로그인하지않음... 직원정보 볼수 없다.");
			response.sendRedirect("../html/login.do");
			return;
		}

		int empid = Integer.parseInt(request.getParameter("emp_id"));
		
		EmpService service = new EmpService();
		int result = service.empDelete(empid);
		request.setAttribute("message", result>0?"삭제성공":"삭제실패");
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		
	}

}
