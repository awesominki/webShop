package controller;

import dto.UsersVO;
import model.UsersService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/html/login.do")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        RequestDispatcher rd =
                request.getRequestDispatcher("loginForm.html");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("userid");
        String pass = request.getParameter("userpass");

        UsersService service = new UsersService();
        UsersVO user = service.selectById(id,pass);
        //Session저장하기 : 다른페이지에서 상태를 알기위해 (로그인여부 알고 처리하기)
        //쿠키:브라우저에 정보를 저장
        //세션:정보는 서버에 저장, 브라우저에서 session ID를 저장
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        if(user == null){
            //로그인 실패시 다시 로그인하도록 유도한다.
            response.sendRedirect("login.do");
        }else{
            response.sendRedirect("../emp/emplist.do");
        }

//        String email = request.getParameter("user_email");
//        String address = request.getParameter("user_address");
//        System.out.println(id);
//        System.out.println(pass);
//        System.out.println(email);
//        System.out.println(address);
//        System.out.println(request.getMethod());
//        System.out.println(request.getContextPath());

        //응답문서 만들기
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter out = response.getWriter();
//        out.write("<h1>로그인에 성공</h1>");
//        out.write("<h2>DB접속후 다시 수정하기</h2>");

//        RequestDispatcher rd =
//                request.getRequestDispatcher("../jsp/loginResult.jsp");
//        rd.forward(request, response);
    }
}
