package controller2;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/getC")
public class GetCookieTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String output = "";
        Cookie[] cs = request.getCookies();
        for(Cookie c : cs){
            System.out.println("쿠키이름:" + c.getName());
            System.out.println("쿠키값:" + c.getValue());
            if(c.getName().equals("cookie_title")){
                String s = URLDecoder.decode(c.getValue(),"utf-8");
                output += "<h3>" + c.getName() + "==>" + s + "</h3>";
            }else {
                output += "<h3>" + c.getName() + "==>" + c.getValue() + "</h3>";
            }
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().append("<h1>Served at : cookie 읽기 예제</h1>")
                .append(output);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
