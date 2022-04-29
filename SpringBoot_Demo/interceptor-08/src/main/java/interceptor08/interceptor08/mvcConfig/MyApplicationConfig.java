package interceptor08.interceptor08.mvcConfig;

import interceptor08.interceptor08.Interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 记得要将本文件作为configuration使用，否则拦截器不会被配置
public class MyApplicationConfig implements WebMvcConfigurer {

    //添加拦截器对象，并注入到容器中
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建拦截器对象：
        HandlerInterceptor interceptor = new MyInterceptor();
        // 让拦截器拦截哪些网址 , 可以使用list数组，一次拦截多个uri地址
//        registry.addInterceptor().addPathPatterns();
//        registry.addInterceptor().excludePathPatterns(); // 让拦截器不拦截哪些网址
        String[] path = {"/user/**"};
        String[] exclude = {"/user/login"};
        registry.addInterceptor(interceptor)
                .addPathPatterns(path)
                .excludePathPatterns(exclude);
    }
}
