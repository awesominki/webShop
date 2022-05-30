package controller2;

import dto.EmpVO;
import model.EmpService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/emp/duplicateCheck.do")
public class EmpDuplicateCheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empid = request.getParameter("empid");
        if(empid==null)return;
        int i_empid = Integer.parseInt(empid);
        System.out.println("emp_Id : " + empid);

        //DB에 직원 id가 존재하는지 체크한다.
        EmpService service = new EmpService();
        EmpVO emp = service.selectById(i_empid);
        PrintWriter out = response.getWriter();
        out.print(emp==null?0:1);
    }
}
