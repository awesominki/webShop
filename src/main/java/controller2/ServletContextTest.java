package controller2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ServletContextTest")
public class ServletContextTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext app = getServletContext();
        System.out.println("getContextPath : " + app.getContextPath());
        System.out.println("getMajorVersion : " + app.getMajorVersion());
        System.out.println("getMinorVersion : " + app.getMinorVersion());
        System.out.println("getRealPath : " + app.getRealPath("."));
        System.out.println("getRealPath : " + app.getRealPath("./board"));

        app.setAttribute("myname","mingi");
        request.setAttribute("myaddress","서울시 금천구 가산");
        System.out.println("getAttribute : " + app.getAttribute("myname"));

        RequestDispatcher rd;
        rd = request.getRequestDispatcher("jsp/contextTest.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
