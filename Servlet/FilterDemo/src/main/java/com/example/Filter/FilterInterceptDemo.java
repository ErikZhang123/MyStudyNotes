package com.example.Filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**实现过滤器借口，java类必须实现其doFilter方法
 *
 * 在执行的时候，Filter会在http服务器创建request和response包后将其拦截
 *
 * 在检测通过后将其返回Http服务器，执行接下来的操作*/
public class FilterInterceptDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //传入 http://localhost:8080?age=98
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //通过年龄判断是否合法
        String age = servletRequest.getParameter("age");
        if(Integer.valueOf(age)<50){
            //合法，则通过doFilter方法放行，返回request和response包
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //不合法,服务器拒绝请求直接通过response包返回数据，不处理其内容
            System.out.println("请求不合法");
            servletResponse.setContentType("text/html;charset=UTF-8");
            PrintWriter outer = servletResponse.getWriter();
            outer.print("<center><font style='font-size:50px;color:red'> 年龄过大！拒绝访问</font></center>");
        }
        //在xml文件中进行注册
    }

    @Override
    public void destroy() {

    }
}
