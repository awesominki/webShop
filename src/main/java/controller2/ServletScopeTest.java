package controller2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ServletScopeTest")
public class ServletScopeTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = getServletContext(); // 1. server가 살아있는동안 모든 jsp/servlet에서 접근가능
        HttpSession session = request.getSession(); // 2. Browser가 살아있는동안 모든 jsp/servlet에서 접근가능
        // 3. HttpServletRequest request : 요청이 살아있는 동안(요청이 바뀌지 않는동안) 모든 jsp/servlet에서 접근가능

        application.setAttribute("appVar","ServletContext는 server가 살아있는동안 모든 jsp/servlet에서 접근가능");
        session.setAttribute("sessionVar","HttpSession은 Browser가 살아있는동안 모든 jsp/servlet에서 접근가능");
        request.setAttribute("requestVar","HttpServletRequest는 요청이 살아있는 동안(요청이 바뀌지 않는동안) 모든 jsp/servlet에서 접근가능");

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("jsp/scopeTest.jsp");
        rd.forward(request,response);
    }
}
