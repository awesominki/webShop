package filter;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter("/*")
public class TimeCheckFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //요청
        long start = System.currentTimeMillis();

        chain.doFilter(request, response); //-->요청수행
        //응답
        long end = System.currentTimeMillis();
        System.out.println("요청수행하는데 걸린 시간 : " + (end-start) + "ms");
    }
}
