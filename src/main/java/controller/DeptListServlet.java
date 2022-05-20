package controller;

import model.DeptService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/dept/deptlist.do")
public class DeptListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeptService service = new DeptService();
        request.setAttribute("deptlist",service.selectAll());

        RequestDispatcher rd = request.getRequestDispatcher("deptList.jsp");
        rd.forward(request,response);
    }
}
