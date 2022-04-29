package interceptor08.interceptor08.Interceptor;


import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyInterceptor implements HandlerInterceptor {

        /**HttpServletRequest request,
         HttpServletResponse response,
         Object handler : 被拦截的控制器对象
         return : true ,能被处理 ； false， 请求截断
         * */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("拦截器起作用了");
        return true;
    }
}
