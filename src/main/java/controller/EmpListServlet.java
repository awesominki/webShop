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
 * Servlet implementation class DeptListServlet
 */
@WebServlet("/emp/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		UsersVO user = (UsersVO) session.getAttribute("user");
		if(user == null){
			System.out.println("로그인하지않음... 직원정보 볼수 없다.");
			response.sendRedirect("../html/login.do");
			return;
		}

        EmpService service = new EmpService();
        request.setAttribute("emplist", service.selctAll());
        
        RequestDispatcher rd;
		rd = request.getRequestDispatcher("empList.jsp");
		rd.forward(request, response);
	}

 

}
