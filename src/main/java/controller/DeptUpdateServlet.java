package controller;

import dto.DeptDTO;
import model.DeptService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DeptInsertServlet
 */
@WebServlet("/dept/deptUpdate.do")
public class DeptUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		//request.setCharacterEncoding("utf-8");
 		int department_id = Integer.parseInt(request.getParameter("department_id"));
 		int manager_id = Integer.parseInt(request.getParameter("manager_id"));
 		int location_id = Integer.parseInt(request.getParameter("location_id"));
 		String department_name = request.getParameter("department_name");
 		DeptDTO dept = new DeptDTO(department_id, department_name, manager_id, location_id);
 		DeptService service = new DeptService();
 		  
 		request.setAttribute("message", service.deptUpdate(dept)>0?"update����":"update����");
 		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}







