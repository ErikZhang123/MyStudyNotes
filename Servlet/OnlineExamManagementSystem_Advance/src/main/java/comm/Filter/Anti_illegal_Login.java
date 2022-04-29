package comm.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Anti_illegal_Login implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.setCharacterEncoding("UTF-8");
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        System.out.println("正在判断是否合法");
        System.out.println(uri);

        if ((uri.indexOf("login") != -1) || ("/OEMS_Ad/".equals(uri))) {
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        HttpSession session = request.getSession(false);
        System.out.println(session);
        if (session == null) {
            request.getRequestDispatcher("/loginError.html").forward(servletRequest, servletResponse);
            return;
        } else
            filterChain.doFilter(servletRequest,servletResponse);
    }
}
