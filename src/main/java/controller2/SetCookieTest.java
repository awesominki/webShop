package controller2;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/SetCookieTest")
public class SetCookieTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //쿠키를 생성해서 응답문서에 추가하고 브라우저에 내려간다.
        Cookie c1 = new Cookie("cookie_subject","jspServlet");
        c1.setMaxAge(60*3); //3분후 지워진다.

        Cookie c2 = new Cookie("cookie_score","99");
        c2.setMaxAge(60*60); //60분후 지워진다.

        Cookie c3 = new Cookie("cookie_title", URLEncoder.encode("webShop 프로젝트연습","utf-8"));
        //지워지지 않는다.

        response.addCookie(c1);
        response.addCookie(c2);
        response.addCookie(c3);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().append("<h1>Served at : cookie 저장예제</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
