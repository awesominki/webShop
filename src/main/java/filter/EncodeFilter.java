package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("*.do")
public class EncodeFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        HttpServletRequest req = (HttpServletRequest)request;
        System.out.println("getContextPath : " + req.getContextPath()); //결과 : /webShop_war_exploded
        System.out.println("getRequestURL : " + req.getRequestURL()); //결과 : http://localhost:8080/webShop_war_exploded/first/test1
        System.out.println("getRequestURI : " + req.getRequestURI()); //결과 : /webShop_war_exploded/first/test1
        System.out.println("getServletPath : " + req.getServletPath()); //결과 : /first/test1
        System.out.println("getServerPort : " + req.getServerPort()); //결과 : 8080

        chain.doFilter(request, response);
    }
}
