package controller2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/first/test1")
//@WebServlet("/first/*")
@WebServlet("*.aa")
public class URLPatternTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getContextPath : " + request.getContextPath()); //결과 : /webShop_war_exploded
        System.out.println("getRequestURL : " + request.getRequestURL()); //결과 : http://localhost:8080/webShop_war_exploded/first/test1
        System.out.println("getRequestURI : " + request.getRequestURI()); //결과 : /webShop_war_exploded/first/test1
        System.out.println("getServletPath : " + request.getServletPath()); //결과 : /first/test1
        System.out.println("getServerPort : " + request.getServerPort()); //결과 : 8080
    }
}
