package filters10.filters10;

import org.springframework.context.annotation.ComponentScan;

import javax.servlet.*;
import java.io.IOException;

//注意要使用servlet的filter

public class myfilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter执行了");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
