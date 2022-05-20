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

@WebServlet("/html/dept.do")
public class DeptDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deptid = request.getParameter("dept_id");
        System.out.println(deptid);

        int idept = Integer.parseInt(deptid);
        DeptService dService = new DeptService();
        DeptDTO dept = dService.selectById(idept);

        if(dept != null){
            request.setAttribute("deptname",dept.getDepartment_name());
            request.setAttribute("mid",dept.getManager_id());
            request.setAttribute("loc",dept.getLocation_id());
        }
        request.setAttribute("dept",dept);


        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/dept/deptDetail.jsp");
        rd.forward(request, response);  // jsp에 요청과 응답

//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//        out.print("<h1>파라미터로 받은 부서번호 : " + deptid + "</h1>");
    }
}
