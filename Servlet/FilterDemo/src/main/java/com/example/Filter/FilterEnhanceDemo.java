package com.example.Filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterEnhanceDemo implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);
        /**通过监听器，在request被servlet处理之前将其字符集改变，避免中文乱码的问题
         * 同时也防止了在servlet的doPost方法中过多使用setCharacterCode()造成代码耦合
         * */
    }

    @Override
    public void destroy() {

    }

}
