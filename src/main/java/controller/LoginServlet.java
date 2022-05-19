package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/html/login.do")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("userid");
        String pass = request.getParameter("userpass");
        System.out.println(id);
        System.out.println(pass);
        System.out.println(request.getMethod());
        System.out.println(request.getContextPath());

        //응답문서 만들기
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//        out.write("<h1>로그인에 성공</h1>");
//        out.write("<h2>DB접속후 다시 수정하기</h2>");

        RequestDispatcher rd =
                request.getRequestDispatcher("../jsp/loginResult.jsp");
        rd.forward(request, response);
    }
}
